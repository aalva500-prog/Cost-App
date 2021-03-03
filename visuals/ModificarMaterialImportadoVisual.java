package visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import model.Material;
import model.TipoMaterial;
import model.TipoMoneda;
import model.UnidadMedida;
import net.sf.jasperreports.engine.JRException;
import services.ServicioMaterial;
import services.ServicioMoneda;
import services.ServicioTipoMaterial;
import services.ServicioUnidadMedida;
import Utils.Reportes;
import Utils.UserInterfaceSuport;
import Utils.Validate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ModificarMaterialImportadoVisual extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JTextField ProveedorjTextField = null;
	private JLabel NumeroFacturajLabel1 = null;
	private JTextField NumeropFacturajTextField = null;
	private JMenuBar jJMenuBar = null;
	private JSpinner DatejSpinner = null;
	private SpinnerDateModel DatespinnerDateModel = null;
	private JLabel FechaFacturajLabel1 = null;
	private JLabel DescripcionjLabel1 = null;
	private JTextArea DescripcionjTextArea = null;
	private JLabel UnidadMedidajLabel1 = null;
	private JLabel CantCompradajLabel1 = null;
	private JTextField CantCompradajTextField = null;
	private JLabel CantidadConvertidajLabel1 = null;
	private JTextField CantConveretidajTextField = null;
	private JLabel TipoMonedajLabel1 = null;
	private JLabel ImporteComprajLabel1 = null;
	private JTextField ImporteComprajTextField = null;
	private JButton ConvertiraGalonjButton = null;
	private JLabel PrecioAdquisicionjLabel1 = null;
	private JTextField PrecioAdquisicionjTextField = null;
	private JSpinner DatejSpinner1 = null;
	private SpinnerDateModel DatespinnerDateModel1 = null;  //  @jve:decl-index=0:
	private JLabel FechaTasaConversionjLabel1 = null;
	private JPanel ConversionjPanel1 = null;
	private JLabel TasaCambiojLabel1 = null;
	private JTextField TasaCAmbiojTextField = null;
	private JButton CAlcularPreciojButton = null;
	private JLabel PrecioCOnvertidojLabel1 = null;
	private JTextField PrecioConvertidojTextField = null;
	private JPanel GastosdeFletejPanel1 = null;
	private JLabel GastosdeFletejLabel1 = null;
	private JLabel PrecioCOnGAstosjLabel1 = null;
	private JTextField PrecioconGastosjTextField = null;
	private JTextField GastosjTextField = null;
	private JLabel CantidadFAcuradajLabel1 = null;
	private JTextField CantidadFacturadajTextField = null;
	private JButton PrecioenUSDconGAstosjButton = null;
	private JLabel PrecioenUSDconGAstosjLabel1 = null;
	private JButton SalirjButton = null;
	private JComboBox jComboBoxUnidad = null;
	private JComboBox jComboBoxMoneda= null;
	private JButton ModificarjButton = null;
	private JButton ImprimirjButton = null;
	private Material mp =null;
	private JButton jButton = null;
	private JScrollPane jScrollPane = null;
	private JPanel moldejPanel1 = null;
	private JLabel CosotjLabel1 = null;
	private JLabel jLabel1 = null;
	private JTextField MoldejTextField = null;
	private JTextField jTextField = null;
	private JButton MoldejButton1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField CostoDOPMoldejTextField = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JLabel jLabel4 = null;
	private JComboBox TipoMaterialjComboBox = null;
	public ModificarMaterialImportadoVisual(Material mp) {
		super();
		this.mp=mp;
		initialize();
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private void initialize() {
		this.setSize(new Dimension(1109, 721));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setTitle("Datos del Material Importado");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJPanel());
		
		if(mp.getMoneda().equals("EUR")){
			ConversionjPanel1.setVisible(true);
			PrecioCOnGAstosjLabel1.setVisible(true);
			PrecioconGastosjTextField.setVisible(true);
			jLabel3.setVisible(true);
			CostoDOPMoldejTextField.setVisible(true);
			PrecioenUSDconGAstosjLabel1.setVisible(false);
			jTextField2.setVisible(false);
			jLabel2.setVisible(false);
			jTextField1.setVisible(false);
		}
		
		if(mp.getUnidad().equals("GALÓN")){
			ConvertiraGalonjButton.setVisible(true);
			CantidadConvertidajLabel1.setVisible(true);
			CantConveretidajTextField.setVisible(true);
		}
		
		 //Combobox Tipo Moneda
		LinkedList<TipoMoneda> list1 = new LinkedList<TipoMoneda>();
		try {
			list1= ServicioMoneda.getMonedasInternacionales();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModel1 = new DefaultComboBoxModel();
		boxModel1.addElement(new String("<Seleccione>"));
		for (int i = 0; i < list1.size(); i++) {
		boxModel1.addElement(list1.get(i));
		}
		
		getJComboBoxMoneda().setModel(boxModel1);
		
		 //Combobox Unidad de Medida
		LinkedList<UnidadMedida> list3 = new LinkedList<UnidadMedida>();
		try {
			list3 = ServicioUnidadMedida.getUnidades();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModel3 = new DefaultComboBoxModel();
		boxModel3.addElement(new String("<Seleccione>"));
		for (int i = 0; i < list3.size(); i++) {
			boxModel3.addElement(list3.get(i));
		}
		
		getJComboBoxUnidad().setModel(boxModel3);
		
		//Combobox Tipo Material
		LinkedList<TipoMaterial> listTIpo = new LinkedList<TipoMaterial>();
		try {
			listTIpo = ServicioTipoMaterial.getRoles();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModelTipo = new DefaultComboBoxModel();
		boxModelTipo.addElement(new String("<Seleccione>"));
		for (int i = 0; i < listTIpo.size(); i++) {
			boxModelTipo.addElement(listTIpo.get(i));
		}
		
		getTipoMaterialjComboBox().setModel(boxModelTipo);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,((screenSize.height - getHeight()) / 2));
		
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.insets = new Insets(4, 4, 6, 7);
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.ipadx = 1079;
			gridBagConstraints4.ipady = 205;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(2, 4, 7, 7);
			gridBagConstraints3.gridy = 4;
			gridBagConstraints3.ipadx = 1079;
			gridBagConstraints3.ipady = 52;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(7, 4, 2, 7);
			gridBagConstraints2.gridy = 3;
			gridBagConstraints2.ipadx = 1079;
			gridBagConstraints2.ipady = 113;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(6, 4, 7, 7);
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.ipadx = 1079;
			gridBagConstraints1.ipady = 121;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(6, 4, 5, 7);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.ipadx = 1079;
			gridBagConstraints.ipady = 124;
			gridBagConstraints.gridx = 0;
			jLabel3 = new JLabel();
			jLabel3.setText("Precio de Adquisición Convertido de EUR a USD con Costos del Molde incluido:");
			jLabel3.setBounds(new Rectangle(403, 81, 443, 26));
			jLabel3.setVisible(false);
			jLabel2 = new JLabel();
			jLabel2.setText("Precio de Adquisición en USD con Costos del Molde incluido:");
			jLabel2.setBounds(new Rectangle(403, 20, 351, 26));
			PrecioenUSDconGAstosjLabel1 = new JLabel();
			PrecioenUSDconGAstosjLabel1.setText("Precio de Adquisición en USD con Gastos de Flete y otros incluido:");
			PrecioenUSDconGAstosjLabel1.setBounds(new Rectangle(416, 31, 388, 26));
			PrecioCOnvertidojLabel1 = new JLabel();
			PrecioCOnvertidojLabel1.setText("Precio de Adquisición Convertido de EUR a USD:");
			PrecioCOnvertidojLabel1.setBounds(new Rectangle(435, 49, 278, 26));
			FechaTasaConversionjLabel1 = new JLabel();
			FechaTasaConversionjLabel1.setText("Fecha Tasa de Cambio de EUR a USD:");
			FechaTasaConversionjLabel1.setBounds(new Rectangle(9, 24, 222, 26));
			PrecioAdquisicionjLabel1 = new JLabel();
			PrecioAdquisicionjLabel1.setText("* Precio de Adquisición:");
			PrecioAdquisicionjLabel1.setBounds(new Rectangle(799, 148, 181, 26));
			ImporteComprajLabel1 = new JLabel();
			ImporteComprajLabel1.setText("* Importe de la Compra:");
			ImporteComprajLabel1.setBounds(new Rectangle(651, 148, 136, 26));
			TipoMonedajLabel1 = new JLabel();
			TipoMonedajLabel1.setText("* Tipo de Moneda:  " + mp.getMoneda());
			TipoMonedajLabel1.setBounds(new Rectangle(498, 148, 136, 26));
			CantidadConvertidajLabel1 = new JLabel();
			CantidadConvertidajLabel1.setText("Cantidad Comprada Convertida a Galón:");
			CantidadConvertidajLabel1.setBounds(new Rectangle(246, 148, 232, 26));
			CantidadConvertidajLabel1.setVisible(false);
			CantCompradajLabel1 = new JLabel();
			CantCompradajLabel1.setText("* Cantidad Comprada:");
			CantCompradajLabel1.setBounds(new Rectangle(3, 148, 171, 26));
			UnidadMedidajLabel1 = new JLabel();
			UnidadMedidajLabel1.setText("* Unidad de Medida:  " + mp.getUnidad());
			UnidadMedidajLabel1.setBounds(new Rectangle(904, 9, 169, 26));
			DescripcionjLabel1 = new JLabel();
			DescripcionjLabel1.setText("* Descripción del Producto:");
			DescripcionjLabel1.setBounds(new Rectangle(550, 9, 348, 26));
			FechaFacturajLabel1 = new JLabel();
			FechaFacturajLabel1.setText("* Fecha Factura:");
			FechaFacturajLabel1.setBounds(new Rectangle(407, 9, 136, 26));
			NumeroFacturajLabel1 = new JLabel();
			NumeroFacturajLabel1.setText("* Número de Factura:");
			NumeroFacturajLabel1.setBounds(new Rectangle(266, 9, 136, 26));
			jLabel = new JLabel();
			jLabel.setText("* Nombre del Proveedor:");
			jLabel.setBounds(new Rectangle(4, 9, 251, 26));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getConversionjPanel1(), gridBagConstraints);
			jPanel.add(getGastosdeFletejPanel1(), gridBagConstraints1);
			jPanel.add(getMoldejPanel1(), gridBagConstraints2);
			jPanel.add(getJPanel1(), gridBagConstraints3);
			jPanel.add(getJPanel2(), gridBagConstraints4);
			}
		return jPanel;
	}

	/**
	 * This method initializes ProveedorjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getProveedorjTextField() {
		if (ProveedorjTextField == null) {
			ProveedorjTextField = new JTextField();
			ProveedorjTextField.setText(mp.getProveedor());
			ProveedorjTextField.setBounds(new Rectangle(3, 33, 253, 26));
		}
		return ProveedorjTextField;
	}

	/**
	 * This method initializes NumeropFacturajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNumeropFacturajTextField() {
		if (NumeropFacturajTextField == null) {
			NumeropFacturajTextField = new JTextField();
			NumeropFacturajTextField.setText(mp.getFactura());
			NumeropFacturajTextField.setBounds(new Rectangle(266, 33, 136, 26));
		}
		return NumeropFacturajTextField;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes DescripcionjTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getDescripcionjTextArea() {
		if (DescripcionjTextArea == null) {
			DescripcionjTextArea = new JTextArea();
			DescripcionjTextArea.setText(mp.getDescripcion());
		}
		return DescripcionjTextArea;
	}

	/**
	 * This method initializes CantCompradajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantCompradajTextField() {
		if (CantCompradajTextField == null) {
			CantCompradajTextField = new JTextField();
			Validate.validateDigitAndComma(CantCompradajTextField);			
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			CantCompradajTextField.setText(String.valueOf(dosDigitos.format(mp.getCantidadcomprada())));
			CantCompradajTextField.setBounds(new Rectangle(2, 173, 172, 26));
		}
		return CantCompradajTextField;
	}

	/**
	 * This method initializes CantConveretidajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantConveretidajTextField() {
		if (CantConveretidajTextField == null) {
			CantConveretidajTextField = new JTextField();
			CantConveretidajTextField.setVisible(false);
			CantConveretidajTextField.setBounds(new Rectangle(246, 173, 136, 26));
			Validate.validateDigitAndComma(CantConveretidajTextField);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getCantdadconvertida()!=0){
				CantConveretidajTextField.setText(String.valueOf(dosDigitos.format(mp.getCantdadconvertida())));
				}else{
					CantConveretidajTextField.setText("");	
				}
		}
		return CantConveretidajTextField;
	}

	/**
	 * This method initializes ImporteComprajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImporteComprajTextField() {
		if (ImporteComprajTextField == null) {
			ImporteComprajTextField = new JTextField();
			Validate.validateDigitAndComma(ImporteComprajTextField);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			ImporteComprajTextField.setText(String.valueOf(dosDigitos.format(mp.getImportecompre())));
			ImporteComprajTextField.setBounds(new Rectangle(652, 173, 136, 26));
		}
		return ImporteComprajTextField;
	}

	/**
	 * This method initializes ConvertiraGalonjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getConvertiraGalonjButton() {
		if (ConvertiraGalonjButton == null) {
			ConvertiraGalonjButton = new JButton();
			ConvertiraGalonjButton.setVisible(false);
			ConvertiraGalonjButton.setBounds(new Rectangle(187, 148, 46, 44));
			ConvertiraGalonjButton.setText("=");
			ConvertiraGalonjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					if(((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo().equals("GALÓN")){
						double lts = Double.valueOf(CantCompradajTextField.getText());
						double calculo=lts*3.7853;
						CantConveretidajTextField.setText(String.valueOf(dosDigitos.format(calculo)));
						
					}else{
						JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "La Unidad de Medida debe ser GALÓN", "Informacion", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ConvertiraGalonjButton;
	}

	/**
	 * This method initializes PrecioAdquisicionjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPrecioAdquisicionjTextField() {
		if (PrecioAdquisicionjTextField == null) {
			PrecioAdquisicionjTextField = new JTextField();
			Validate.validateDigitAndComma(PrecioAdquisicionjTextField);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			PrecioAdquisicionjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicion())));
			PrecioAdquisicionjTextField.setBounds(new Rectangle(799, 172, 181, 26));
		}
		return PrecioAdquisicionjTextField;
	}
	

	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel1() {
		if (DatespinnerDateModel1  == null) {
			DatespinnerDateModel1 = new SpinnerDateModel();
		}
		return DatespinnerDateModel1;
	}
	
	
	private JSpinner getDatejSpinner1() {
		if (DatejSpinner1 == null) {
			DatejSpinner1 = new JSpinner(getDatespinnerDateModel1());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner1.setEditor(new JSpinner.DateEditor(DatejSpinner1,dateFormat.toPattern()));
			DatejSpinner1.setBounds(new Rectangle(407, 33, 136, 26));
			DatejSpinner1.setValue(mp.getFecha());
			}
		return DatejSpinner1;
	}
	
	
	
	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel() {
		if (DatespinnerDateModel  == null) {
			DatespinnerDateModel = new SpinnerDateModel();
		}
		return DatespinnerDateModel;
	}

	private JSpinner getDatejSpinner() {
		if (DatejSpinner == null) {
			DatejSpinner = new JSpinner(getDatespinnerDateModel() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner.setEditor(new JSpinner.DateEditor(DatejSpinner,dateFormat.toPattern()));
			DatejSpinner.setBounds(new Rectangle(231, 25, 136, 26));
			java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
			if(mp.getFechatasaconversionEURaUSD()!=null){
			DatejSpinner.setValue(mp.getFechatasaconversionEURaUSD());
			}else{
				DatejSpinner.setValue(sqlDate);
			}
		}		
		return DatejSpinner;
	}
	
	
	

	
	/**
	 * This method initializes ConversionjPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getConversionjPanel1() {
		if (ConversionjPanel1 == null) {
			PrecioCOnGAstosjLabel1 = new JLabel();
			PrecioCOnGAstosjLabel1.setText("Precio de Adquisición Convertido de EUR a USD con Gastos Inluido:");
			PrecioCOnGAstosjLabel1.setBounds(new Rectangle(416, 77, 388, 26));
			PrecioCOnGAstosjLabel1.setVisible(false);
			TasaCambiojLabel1 = new JLabel();
			TasaCambiojLabel1.setBounds(new Rectangle(9, 75, 222, 26));
			TasaCambiojLabel1.setText("Tasa de Cambio de EUR a USD:");
			ConversionjPanel1 = new JPanel();
			ConversionjPanel1.setLayout(null);
			ConversionjPanel1.setBackground(new Color(190,190,190));
			ConversionjPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos del Cambio de Moneda de EUR a USD", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			ConversionjPanel1.setVisible(false);
			ConversionjPanel1.add(FechaTasaConversionjLabel1, null);
			ConversionjPanel1.add(TasaCambiojLabel1, null);
			ConversionjPanel1.add(getTasaCAmbiojTextField(), null);
			ConversionjPanel1.add(getCAlcularPreciojButton(), null);
			ConversionjPanel1.add(PrecioCOnvertidojLabel1, null);
			ConversionjPanel1.add(getPrecioConvertidojTextField(), null);
			ConversionjPanel1.add(getDatejSpinner(), null);
			}
		return ConversionjPanel1;
	}

	/**
	 * This method initializes TasaCAmbiojTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTasaCAmbiojTextField() {
		if (TasaCAmbiojTextField == null) {
			TasaCAmbiojTextField = new JTextField();
			TasaCAmbiojTextField.setBounds(new Rectangle(231, 75, 136, 26));
			Validate.validateDigitAndComma(TasaCAmbiojTextField);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getTasaconversionEURaUSD()!=0){
				TasaCAmbiojTextField.setText(String.valueOf(dosDigitos.format(mp.getTasaconversionEURaUSD())));
				}else{
					TasaCAmbiojTextField.setText("");	
				}
		}
		return TasaCAmbiojTextField;
	}

	/**
	 * This method initializes CAlcularPreciojButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCAlcularPreciojButton() {
		if (CAlcularPreciojButton == null) {
			CAlcularPreciojButton = new JButton();
			CAlcularPreciojButton.setText("=");
			CAlcularPreciojButton.setBounds(new Rectangle(379, 47, 48, 40));
			CAlcularPreciojButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					if(getJComboBoxMoneda().getSelectedIndex()==2){
						double precio1 = Double.valueOf(PrecioAdquisicionjTextField.getText());
						double tasa = Double.valueOf(TasaCAmbiojTextField.getText());							
						double precio=precio1*tasa;
					PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(precio)));
					}else{
						JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "El Tipo de Moneda debe ser EUR", "Informacion", JOptionPane.ERROR_MESSAGE);
					}
								
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return CAlcularPreciojButton;
	}

	/**
	 * This method initializes PrecioConvertidojTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPrecioConvertidojTextField() {
		if (PrecioConvertidojTextField == null) {
			PrecioConvertidojTextField = new JTextField();
			PrecioConvertidojTextField.setBounds(new Rectangle(712, 49, 136, 26));
			Validate.validateDigitAndComma(PrecioConvertidojTextField);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioadqusicionconvertidoEURaUSD()!=0){
				PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadqusicionconvertidoEURaUSD())));
				}else{
					PrecioConvertidojTextField.setText("");	
				}
		}
		return PrecioConvertidojTextField;
	}

	/**
	 * This method initializes GastosdeFletejPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getGastosdeFletejPanel1() {
		if (GastosdeFletejPanel1 == null) {
			CantidadFAcuradajLabel1 = new JLabel();
			CantidadFAcuradajLabel1.setBounds(new Rectangle(9, 73, 150, 23));
			CantidadFAcuradajLabel1.setText("Cantidad Total Facturada:");
			GastosdeFletejLabel1 = new JLabel();
			GastosdeFletejLabel1.setBounds(new Rectangle(9, 27, 150, 23));
			GastosdeFletejLabel1.setText("Gastos de Flete y otros:");
			GastosdeFletejPanel1 = new JPanel();
			GastosdeFletejPanel1.setLayout(null);
			GastosdeFletejPanel1.setBackground(new Color(190,190,190));
			GastosdeFletejPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos de Gastos de Flete", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			GastosdeFletejPanel1.add(GastosdeFletejLabel1, null);
			GastosdeFletejPanel1.add(getGastosjTextField(), null);
			GastosdeFletejPanel1.add(CantidadFAcuradajLabel1, null);
			GastosdeFletejPanel1.add(getCantidadFacturadajTextField(), null);
			GastosdeFletejPanel1.add(getPrecioconGastosjTextField(), null);
			GastosdeFletejPanel1.add(PrecioCOnGAstosjLabel1, null);
			GastosdeFletejPanel1.add(PrecioenUSDconGAstosjLabel1, null);
			GastosdeFletejPanel1.add(getPrecioenUSDconGAstosjButton(), null);
			GastosdeFletejPanel1.add(getJTextField2(), null);
		}
		return GastosdeFletejPanel1;
	}
	
	

	/**
	 * This method initializes PrecioconGastosjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPrecioconGastosjTextField() {
		if (PrecioconGastosjTextField == null) {
			PrecioconGastosjTextField = new JTextField();
			Validate.validateDigitAndComma(PrecioconGastosjTextField);	
			PrecioconGastosjTextField.setVisible(false);
			PrecioconGastosjTextField.setBounds(new Rectangle(804, 78, 136, 26));
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioAdqusicionconvertidoEURaUSDconGastos()!=0){
				PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioAdqusicionconvertidoEURaUSDconGastos())));
				}else{
					PrecioconGastosjTextField.setText("");	
				}
		}
		return PrecioconGastosjTextField;
	}
	
	

	/**
	 * This method initializes GastosjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getGastosjTextField() {
		if (GastosjTextField == null) {
			GastosjTextField = new JTextField();
			GastosjTextField.setBounds(new Rectangle(159, 28, 141, 23));
			Validate.validateDigitAndComma(GastosjTextField);	
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getGastosvarios()!=0){
				GastosjTextField.setText(String.valueOf(dosDigitos.format(mp.getGastosvarios())));
				}else{
					GastosjTextField.setText("");	
				}
		}
		return GastosjTextField;
	}
	
	

	/**
	 * This method initializes CantidadFacturadajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantidadFacturadajTextField() {
		if (CantidadFacturadajTextField == null) {
			CantidadFacturadajTextField = new JTextField();
			CantidadFacturadajTextField.setBounds(new Rectangle(159, 73, 141, 23));
			Validate.validateDigitAndComma(CantidadFacturadajTextField);	
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getCantidadtotalfacturada()!=0){
				CantidadFacturadajTextField.setText(String.valueOf(dosDigitos.format(mp.getCantidadtotalfacturada())));
				}else{
					CantidadFacturadajTextField.setText("");	
				}
		}
		return CantidadFacturadajTextField;
	}
	
	

	/**
	 * This method initializes PrecioenUSDconGAstosjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getPrecioenUSDconGAstosjButton() {
		if (PrecioenUSDconGAstosjButton == null) {
			PrecioenUSDconGAstosjButton = new JButton();
			PrecioenUSDconGAstosjButton.setText("=");
			PrecioenUSDconGAstosjButton.setBounds(new Rectangle(321, 23, 67, 87));
			PrecioenUSDconGAstosjButton.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
							double gastosflete = Double.valueOf(GastosjTextField.getText());
							double cant = Double.valueOf(CantidadFacturadajTextField.getText());
							double div = gastosflete/cant;
							if(getJComboBoxMoneda().getSelectedIndex()!=0){
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
								double precio = Double.valueOf(PrecioAdquisicionjTextField.getText());
								jTextField2.setText(String.valueOf(dosDigitos.format(div + precio)));
								PrecioconGastosjTextField.setText("");
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
								double precioAdcon = Double.valueOf(PrecioConvertidojTextField.getText());
								PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
								jTextField2.setText("");
							}
							}else{
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Debe Elegir el Tipo de Moneda", "Error", JOptionPane.ERROR_MESSAGE);
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return PrecioenUSDconGAstosjButton;
	}
	
	
	

	/**
	 * This method initializes SalirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSalirjButton() {
		if (SalirjButton == null) {
			SalirjButton = new JButton();
			SalirjButton.setText("Listado de Materiales Importados");
			SalirjButton.setBounds(new Rectangle(374, 7, 265, 38));
			SalirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			SalirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMaterialesImportados().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return SalirjButton;
	}
	
	
	

	

	
	/**
	 * This method initializes jComboBoxRol	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxUnidad() {
		if (jComboBoxUnidad  == null) {
			jComboBoxUnidad = new JComboBox();
			jComboBoxUnidad.setBounds(new Rectangle(904, 33, 169, 26));
			jComboBoxUnidad.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxUnidad().getSelectedIndex()==4){
						ConvertiraGalonjButton.setVisible(true);
						CantidadConvertidajLabel1.setVisible(true);
						CantConveretidajTextField.setVisible(true);					
					}else{
						ConvertiraGalonjButton.setVisible(false);
						CantidadConvertidajLabel1.setVisible(false);
						CantConveretidajTextField.setVisible(false);
						CantConveretidajTextField.setText("");
						}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			}
		return jComboBoxUnidad;
	}

	
	/**
	 * This method initializes jComboBoxRol	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxMoneda() {
		if (jComboBoxMoneda == null) {
			jComboBoxMoneda = new JComboBox();
			jComboBoxMoneda.setBounds(new Rectangle(498, 174, 136, 26));
			jComboBoxMoneda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxMoneda().getSelectedIndex()==2){
						ConversionjPanel1.setVisible(true);
						PrecioCOnGAstosjLabel1.setVisible(true);
						PrecioconGastosjTextField.setVisible(true);
						jLabel3.setVisible(true);
						CostoDOPMoldejTextField.setVisible(true);
						PrecioenUSDconGAstosjLabel1.setVisible(false);
						jTextField2.setVisible(false);
						jLabel2.setVisible(false);
						jTextField1.setVisible(false);
						jTextField1.setText("");
						jTextField2.setText("");
					}else{					
							ConversionjPanel1.setVisible(false);
							PrecioCOnGAstosjLabel1.setVisible(false);
							PrecioconGastosjTextField.setVisible(false);
							jLabel3.setVisible(false);
							CostoDOPMoldejTextField.setVisible(false);
							PrecioenUSDconGAstosjLabel1.setVisible(true);
							jTextField2.setVisible(true);
							jLabel2.setVisible(true);
							jTextField1.setVisible(true);
							PrecioconGastosjTextField.setText("");
							CostoDOPMoldejTextField.setText("");
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			
		}
		return jComboBoxMoneda;
	}
	
	
	
	
	/**
	 * This method initializes ModificarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getModificarjButton() {
		if (ModificarjButton == null) {
			ModificarjButton = new JButton();
			ModificarjButton.setText("Modificar");
			ModificarjButton.setBounds(new Rectangle(37, 7, 149, 38));
			ModificarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			ModificarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0) &&  !(jComboBoxUnidad.getSelectedIndex()==0) && ProveedorjTextField.getText().length()!=0 && NumeropFacturajTextField.getText().length()!=0 && TipoMaterialjComboBox.getSelectedIndex()!=0
							&& DescripcionjTextArea.getText().length()!=0 && CantCompradajTextField.getText().length()!=0  && ImporteComprajTextField.getText().length()!=0 && PrecioAdquisicionjTextField.getText().length()!=0 ){
						//Condiciones con USD
						//1
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") &&  CantConveretidajTextField.getText().length()==0 && jTextField2.getText().length()==0 && jTextField1.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, 0, null, 0, 0, 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}							
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					//2
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && CantConveretidajTextField.getText().length()!=0 &&  jTextField2.getText().length()==0 && jTextField1.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, 0, null, 0, 0, 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}						
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					//3				
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()!=0 &&  CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate,  DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField2.getText()), 0, null, 0, 0, 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
								jTextField.setText("");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}									
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					//4
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()!=0 &&  CantConveretidajTextField.getText().length()!=0 && jTextField1.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),  Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()),  Float.valueOf(jTextField2.getText()), 0, null, 0, 0, 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jTextField.setText("");
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}						
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					//5
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()==0 &&  CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()!=0){
						
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(jTextField.getText()), 0, 0, 0, null, 0, 0, Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField1.getText()), 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
	                            CantidadFacturadajTextField.setText("");
	                            jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}						
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
					//6
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && jTextField1.getText().length()!=0){
						
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
					try {
						ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(jTextField.getText()), 0, 0, 0, null, 0, 0, Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField1.getText()), 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
						JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
						CantidadFacturadajTextField.setText("");
						jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
						UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
						TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					}
					
					//7
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()!=0  && CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()!=0 ){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(),  ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),  Float.valueOf(jTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField2.getText()), 0, null, 0, 0, Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField1.getText()), 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}					
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}else{
							JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
					//8
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && jTextField1.getText().length()!=0 ){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(),  ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(GastosjTextField.getText()),  Float.valueOf(jTextField2.getText()), 0, null, 0, 0,  Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField1.getText()), 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}else{
							JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
									
					//Condiciones con EUR
					//1
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.ModificarMaterialImportado(mp.getId_material(),  ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate,  DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0,  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					
					//2
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
											
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					
					//3
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") &&  CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate,  DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), 0,  Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1,  Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
								jTextField.setText("");	
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}												
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}					
					//4
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") &&  CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate,  DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), 0,  Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1,  Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), 0, 0, 0,((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
								jTextField.setText("");		
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}										
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}
					//5
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")  &&  CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(),  ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(jTextField.getText()), 0, 0,  Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, Float.valueOf(MoldejTextField.getText()), 0, Float.valueOf(CostoDOPMoldejTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
								CantidadFacturadajTextField.setText("");	
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}											
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}
					//6
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(),  ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(jTextField.getText()), 0, 0,  Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, Float.valueOf(MoldejTextField.getText()), 0, Float.valueOf(CostoDOPMoldejTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
								CantidadFacturadajTextField.setText("");		
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}											
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}
					
					//7
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") &&  CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(),  NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0,  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(GastosjTextField.getText()), 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(MoldejTextField.getText()), 0, Float.valueOf(CostoDOPMoldejTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}														
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}else{
							JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
							}
					//8
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.ModificarMaterialImportado(mp.getId_material(), ProveedorjTextField.getText(),  NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(GastosjTextField.getText()), 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(MoldejTextField.getText()), 0, Float.valueOf(CostoDOPMoldejTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Material Modificado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
								jLabel4.setText("*Tipo de Material:  " + ((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getTipomaterial());
								UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
								TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}														
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}else{
							JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
							}
					//////////////////////////
					}
					else{
						JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Los datos marcados con * son obligatorios", "Información", JOptionPane.ERROR_MESSAGE);	
					}
						System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ModificarjButton;
	}



	/**
	 * This method initializes ImprimirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getImprimirjButton() {
		if (ImprimirjButton == null) {
			ImprimirjButton = new JButton();
			ImprimirjButton.setText("Imprimir Datos");
			ImprimirjButton.setBounds(new Rectangle(208, 7, 149, 38));
			ImprimirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0)){
					//Condiciones con USD
					//1
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && CantConveretidajTextField.getText().length()==0 && jTextField2.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0 && jTextField1.getText().length()==0){			
					try {
						Reportes.getR().ImprimirMaterial(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();						
					}				
						}
				
				//2
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && CantConveretidajTextField.getText().length()!=0 &&  jTextField2.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0 && jTextField1.getText().length()==0){
					try {
						Reportes.getR().ImprimirMaterialconGalon(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//3					
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()!=0 &&  CantConveretidajTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0 && jTextField1.getText().length()==0){
					try {
						Reportes.getR().ImprimirMaterialconGastosUSDImportado(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//4
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()!=0 &&  CantConveretidajTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()==0 && jTextField1.getText().length()==0){
					try {
						Reportes.getR().ImprimirMaterialconUSDconGastosyGalonImportado(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//5
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()!=0){
						try {
							Reportes.getR().ImprimirMaterialImportadoconMolde(mp.getId_material());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				}
				
				//6
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")  && jTextField2.getText().length()==0 &&  CantConveretidajTextField.getText().length()!=0 && jTextField1.getText().length()!=0){
					
					try {
						Reportes.getR().ImprimirMaterialImportadoconMoldeyGalon(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
				//7
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField2.getText().length()!=0 &&  CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()!=0 ){
					if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
					try {
						Reportes.getR().ImprimirMaterialImportadoconMoldeygastos(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
					}
				}
				//8
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")  &&  jTextField2.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && jTextField1.getText().length()!=0 ){
					if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
					try {
						Reportes.getR().ImprimirMaterialImportadoconMoldeygastosyGalon(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
					}
				}
				
				
				
				
				//Condiciones con EUR
				//1
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
				try {
					Reportes.getR().ImprimirMaterialImportadoEUR(mp.getId_material());
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}
				
				//2
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
				try {
					Reportes.getR().ImprimirMaterialImportadoEURconGalon(mp.getId_material());
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}
						
				//3
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") &&  CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMaterialEURconGastos(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				
				//4
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMaterialEURconGastosyGalon(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				
						
				//5
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")  &&  CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMaterialImportadoEURconmolde(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				//6
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMaterialImporteEURconmoldeyGalon(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				
				//7
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") &&  CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMaterialImportadaEURconmoldeyGastos(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				//8
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR") &&  CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMaterialImportadoEURconmoldeyGastosyGalon(mp.getId_material());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
				else{
					JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Es necesario que elija el Tipo de Moneda", "Informacion", JOptionPane.ERROR_MESSAGE);
				}
				}
			});
		}
		return ImprimirjButton;
	}



	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Menú Principal");
			jButton.setBounds(new Rectangle(656, 7, 149, 38));
			jButton.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					Started i = new Started();
					new Principal(i).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton;
	}



	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(550, 33, 348, 99));
			jScrollPane.setViewportView(getDescripcionjTextArea());
		}
		return jScrollPane;
	}



	/**
	 * This method initializes moldejPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getMoldejPanel1() {
		if (moldejPanel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(12, 67, 151, 24));
			jLabel1.setText("Cantidad Total Facturada:");
			CosotjLabel1 = new JLabel();
			CosotjLabel1.setBounds(new Rectangle(49, 29, 114, 24));
			CosotjLabel1.setText("Costos del Molde:");
			moldejPanel1 = new JPanel();
			moldejPanel1.setLayout(null);
			moldejPanel1.setBackground(new Color(190, 190, 190));
			moldejPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos de Costos del Molde", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			moldejPanel1.add(CosotjLabel1, null);
			moldejPanel1.add(jLabel1, null);
			moldejPanel1.add(getMoldejTextField(), null);
			moldejPanel1.add(getJTextField(), null);
			moldejPanel1.add(getCostoDOPMoldejTextField(), null);
			moldejPanel1.add(jLabel3, null);
			moldejPanel1.add(jLabel2, null);
			moldejPanel1.add(getMoldejButton1(), null);
			moldejPanel1.add(getJTextField1(), null);
		}
		return moldejPanel1;
	}



	/**
	 * This method initializes MoldejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMoldejTextField() {
		if (MoldejTextField == null) {
			MoldejTextField = new JTextField();
			MoldejTextField.setBounds(new Rectangle(162, 29, 138, 24));
			Validate.validateDigitAndComma(MoldejTextField);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getCsotosMolde()!=0){
				MoldejTextField.setText(String.valueOf(dosDigitos.format(mp.getCsotosMolde())));
				}else{
					MoldejTextField.setText("");	
				}
			}
		return MoldejTextField;
	}



	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(162, 67, 138, 24));
			Validate.validateDigitAndComma(jTextField);		
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getCantidadtotalfacturada()!=0){
				jTextField.setText(String.valueOf(dosDigitos.format(mp.getCantidadtotalfacturada())));
				}else{
					jTextField.setText("");	
				}
		}
		return jTextField;
	}



	/**
	 * This method initializes MoldejButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMoldejButton1() {
		if (MoldejButton1 == null) {
			MoldejButton1 = new JButton();
			MoldejButton1.setText("=");
			MoldejButton1.setBounds(new Rectangle(308, 20, 67, 87));
			MoldejButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					double costomolde = Double.valueOf(MoldejTextField.getText());
					double cant = Double.valueOf(jTextField.getText());
					double div = costomolde/cant;
					if(getJComboBoxMoneda().getSelectedIndex()!=0){
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
						double precio = Double.valueOf(PrecioAdquisicionjTextField.getText());
						jTextField1.setText(String.valueOf(dosDigitos.format(div + precio)));
						CostoDOPMoldejTextField.setText("");
						UserInterfaceSuport.clearComponents(ConversionjPanel1);
					}
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
						double precioAdcon = Double.valueOf(PrecioConvertidojTextField.getText());
						CostoDOPMoldejTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
						jTextField1.setText("");
					}
					}else{
						JOptionPane.showMessageDialog(ModificarMaterialImportadoVisual.this, "Debe Elegir el Tipo de Moneda", "Error", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MoldejButton1;
	}






	/**
	 * This method initializes CostoDOPMoldejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoDOPMoldejTextField() {
		if (CostoDOPMoldejTextField == null) {
			CostoDOPMoldejTextField = new JTextField();
			CostoDOPMoldejTextField.setVisible(false);
			CostoDOPMoldejTextField.setBounds(new Rectangle(846, 81, 136, 26));
			Validate.validateDigitAndComma(CostoDOPMoldejTextField);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioAdquisicionconvertidoEURaUSDconMolde()!=0){
				CostoDOPMoldejTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioAdquisicionconvertidoEURaUSDconMolde())));
				}else{
					CostoDOPMoldejTextField.setText("");	
				}
		}
		return CostoDOPMoldejTextField;
	}



	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.add(getSalirjButton(), null);
			jPanel1.add(getJButton(), null);
			jPanel1.add(getImprimirjButton(), null);
			jPanel1.add(getModificarjButton(), null);
		}
		return jPanel1;
	}



	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(4, 78, 296, 26));
			jLabel4.setText("*Tipo de Material:  " + mp.getTipomaterial());
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.add(getPrecioAdquisicionjTextField(), null);
			jPanel2.add(PrecioAdquisicionjLabel1, null);
			jPanel2.add(getImporteComprajTextField(), null);
			jPanel2.add(ImporteComprajLabel1, null);
			jPanel2.add(getJComboBoxMoneda(), null);
			jPanel2.add(TipoMonedajLabel1, null);
			jPanel2.add(getCantConveretidajTextField(), null);
			jPanel2.add(CantidadConvertidajLabel1, null);
			jPanel2.add(getConvertiraGalonjButton(), null);
			jPanel2.add(getCantCompradajTextField(), null);
			jPanel2.add(CantCompradajLabel1, null);
			jPanel2.add(getProveedorjTextField(), null);
			jPanel2.add(jLabel, null);
			jPanel2.add(getNumeropFacturajTextField(), null);
			jPanel2.add(NumeroFacturajLabel1, null);
			jPanel2.add(getDatejSpinner1(), null);
			jPanel2.add(FechaFacturajLabel1, null);
			jPanel2.add(DescripcionjLabel1, null);
			jPanel2.add(getJComboBoxUnidad(), null);
			jPanel2.add(UnidadMedidajLabel1, null);
			jPanel2.add(getJScrollPane(), null);
			jPanel2.add(jLabel4, null);
			jPanel2.add(getTipoMaterialjComboBox(), null);
		}
		return jPanel2;
	}



	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(753, 20, 136, 26));
			Validate.validateDigitAndComma(jTextField1);
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioAdquisicionUSDconMolde()!=0){
				jTextField1.setText(String.valueOf(dosDigitos.format(mp.getPrecioAdquisicionUSDconMolde())));
				jTextField1.setBounds(new Rectangle(753, 20, 136, 26));
				}else{
					jTextField1.setText("");	
				}
		}
		return jTextField1;
	}



	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(804, 31, 136, 26));
			Validate.validateDigitAndComma(jTextField2);	
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioAdquisicionUSDconGAStos()!=0){
				jTextField2.setText(String.valueOf(dosDigitos.format(mp.getPrecioAdquisicionUSDconGAStos())));
				jTextField2.setBounds(new Rectangle(803, 31, 136, 26));
				}else{
					jTextField2.setText("");	
				}
		}
		return jTextField2;
	}



	/**
	 * This method initializes TipoMaterialjComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTipoMaterialjComboBox() {
		if (TipoMaterialjComboBox == null) {
			TipoMaterialjComboBox = new JComboBox();
			TipoMaterialjComboBox.setBounds(new Rectangle(4, 103, 251, 26));
		}
		return TipoMaterialjComboBox;
	}



	


	
	
}  //  @jve:decl-index=0:visual-constraint="10,16"
