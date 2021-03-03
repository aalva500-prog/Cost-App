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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;

import model.MateriaPrima;
import model.TipoMateria;
import model.TipoMoneda;
import model.UnidadMedida;
import services.ServicioMateriaPrima;
import services.ServicioMoneda;
import services.ServicioTipoMateria;
import services.ServicioUnidadMedida;
import Utils.Reportes;
import Utils.UserInterfaceSuport;
import Utils.Validate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ModificarMateriaPrimaExtranjeraVisual extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JTextField ProveedorjTextField = null;
	private JLabel NumeroFacturajLabel1 = null;
	private JTextField NumeropFacturajTextField = null;
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
	private JButton RegistrarProductojButton = null;
	private JButton SalirjButton = null;
	private JLabel TipoMateriajLabel1 = null;
	private JComboBox jComboBoxUnidad = null;
	private JComboBox jComboBoxMoneda= null;
	private JComboBox jComboBoxTipoMateria = null;
	private MateriaPrima mp=null;
	private JButton jButton = null;
	private JButton ImpjButton1 = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JTextField jTextField = null;
	
	public ModificarMateriaPrimaExtranjeraVisual(MateriaPrima mp) {
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
		this.setSize(new Dimension(1172, 606));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setContentPane(getJPanel());
		this.setTitle("Datos de la Materia Prima Importada");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		if(mp.getTipomoneda().equals("EUR")){
			ConversionjPanel1.setVisible(true);
			PrecioCOnGAstosjLabel1.setVisible(true);
			PrecioconGastosjTextField.setVisible(true);
			PrecioenUSDconGAstosjLabel1.setVisible(false);
			jTextField.setVisible(false);
			}
		
		if(mp.getUnidadmedida().equals("GALÓN")){
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
		
		
		 //Combobox Tipo Materia Prima
		LinkedList<TipoMateria> list2 = new LinkedList<TipoMateria>();
		try {
			list2 = ServicioTipoMateria.getTiposMateria();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModel2 = new DefaultComboBoxModel();
		boxModel2.addElement(new String("<Seleccione>"));
		for (int i = 0; i < list2.size(); i++) {
			boxModel2.addElement(list2.get(i));
		}
		
		getJComboBoxTipoMateria().setModel(boxModel2);
		
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
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(3, 2, 0, 9);
			gridBagConstraints3.gridy = 3;
			gridBagConstraints3.ipadx = 1142;
			gridBagConstraints3.ipady = 60;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(4, 2, 8, 9);
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 1142;
			gridBagConstraints2.ipady = 212;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(11, 2, 2, 9);
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.ipadx = 1142;
			gridBagConstraints1.ipady = 121;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(9, 2, 10, 9);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.ipadx = 1142;
			gridBagConstraints.ipady = 117;
			gridBagConstraints.gridx = 0;
			TipoMateriajLabel1 = new JLabel();
			TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+mp.getTipomateriaprima());
			TipoMateriajLabel1.setBounds(new Rectangle(6, 77, 253, 26));
			PrecioenUSDconGAstosjLabel1 = new JLabel();
			PrecioenUSDconGAstosjLabel1.setText("Precio de Adquisición en USD con Gastos de Flete y otros incluido:");
			PrecioenUSDconGAstosjLabel1.setBounds(new Rectangle(416, 32, 388, 26));
			PrecioCOnvertidojLabel1 = new JLabel();
			PrecioCOnvertidojLabel1.setText("Precio de Adquisición Convertido de EUR a USD:");
			PrecioCOnvertidojLabel1.setBounds(new Rectangle(435, 49, 278, 26));
			FechaTasaConversionjLabel1 = new JLabel();
			FechaTasaConversionjLabel1.setText("Fecha Tasa de Cambio de EUR a USD:");
			FechaTasaConversionjLabel1.setBounds(new Rectangle(9, 24, 222, 26));
			PrecioAdquisicionjLabel1 = new JLabel();
			PrecioAdquisicionjLabel1.setText("* Precio de Adquisición:");
			PrecioAdquisicionjLabel1.setBounds(new Rectangle(803, 147, 181, 26));
			ImporteComprajLabel1 = new JLabel();
			ImporteComprajLabel1.setText("* Importe de la Compra:");
			ImporteComprajLabel1.setBounds(new Rectangle(655, 147, 136, 26));
			TipoMonedajLabel1 = new JLabel();
			TipoMonedajLabel1.setText("* Tipo de Moneda:  " + mp.getTipomoneda());
			TipoMonedajLabel1.setBounds(new Rectangle(492, 147, 155, 26));
			CantidadConvertidajLabel1 = new JLabel();
			CantidadConvertidajLabel1.setText("Cantidad Comprada Convertida a Galón:");
			CantidadConvertidajLabel1.setBounds(new Rectangle(250, 147, 232, 26));
			CantidadConvertidajLabel1.setVisible(false);
			CantCompradajLabel1 = new JLabel();
			CantCompradajLabel1.setText("* Cantidad Comprada:");
			CantCompradajLabel1.setBounds(new Rectangle(6, 147, 171, 26));
			UnidadMedidajLabel1 = new JLabel();
			UnidadMedidajLabel1.setText("* Unidad de Medida:  " + mp.getUnidadmedida());
			UnidadMedidajLabel1.setBounds(new Rectangle(941, 8, 185, 26));
			DescripcionjLabel1 = new JLabel();
			DescripcionjLabel1.setText("* Descripción del Producto:");
			DescripcionjLabel1.setBounds(new Rectangle(580, 8, 348, 26));
			FechaFacturajLabel1 = new JLabel();
			FechaFacturajLabel1.setText("* Fecha Factura:");
			FechaFacturajLabel1.setBounds(new Rectangle(431, 8, 136, 26));
			NumeroFacturajLabel1 = new JLabel();
			NumeroFacturajLabel1.setText("* Número de Factura:");
			NumeroFacturajLabel1.setBounds(new Rectangle(281, 8, 136, 26));
			jLabel = new JLabel();
			jLabel.setText("* Nombre del Proveedor:");
			jLabel.setBounds(new Rectangle(6, 8, 251, 26));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getConversionjPanel1(), gridBagConstraints);
			jPanel.add(getGastosdeFletejPanel1(), gridBagConstraints1);
			jPanel.add(getJPanel1(), gridBagConstraints2);
			jPanel.add(getJPanel2(), gridBagConstraints3);
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
			ProveedorjTextField.setText(mp.getNombreproveedor());
			ProveedorjTextField.setBounds(new Rectangle(6, 32, 253, 26));
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
			NumeropFacturajTextField.setText(mp.getNumerofactura());
			NumeropFacturajTextField.setBounds(new Rectangle(281, 32, 136, 26));
		}
		return NumeropFacturajTextField;
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
			DescripcionjTextArea.setRows(3);
			DescripcionjTextArea.setColumns(3);
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
			CantCompradajTextField.setText(String.valueOf(dosDigitos.format(mp.getCantcomprada())));
			CantCompradajTextField.setBounds(new Rectangle(6, 172, 172, 26));
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
			Validate.validateDigitAndComma(CantConveretidajTextField);
			CantConveretidajTextField.setVisible(false);
			CantConveretidajTextField.setBounds(new Rectangle(250, 172, 136, 26));
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getCantconvertgalon()!=0){
				CantConveretidajTextField.setText(String.valueOf(dosDigitos.format(mp.getCantconvertgalon())));
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
			if(mp.getImportecompra()!=0){
				ImporteComprajTextField.setText(String.valueOf(dosDigitos.format(mp.getImportecompra())));
				ImporteComprajTextField.setBounds(new Rectangle(656, 172, 136, 26));
			}else{
				ImporteComprajTextField.setText("");
			}
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
			ConvertiraGalonjButton.setBounds(new Rectangle(191, 147, 46, 44));
			ConvertiraGalonjButton.setText("=");
			ConvertiraGalonjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					if(((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo().equals("GALÓN")){
						float lts = Float.valueOf(CantCompradajTextField.getText());
						CantConveretidajTextField.setText(String.valueOf(dosDigitos.format(lts*3.7853)));
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
			if(mp.getPrecioadquisisonUSD()!=0){
				PrecioAdquisicionjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisisonUSD())));
				PrecioAdquisicionjTextField.setBounds(new Rectangle(803, 171, 181, 26));
			}else{
				PrecioAdquisicionjTextField.setText("");
			}
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
			DatejSpinner1.setBounds(new Rectangle(431, 32, 136, 26));
			DatejSpinner1.setValue(mp.getFechafactura());
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
			if(mp.getFechaconversionEURaUSD()!=null){
				DatejSpinner.setValue(mp.getFechaconversionEURaUSD());
			}
			else{
				DatejSpinner.setValue(mp.getFechafactura());
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
			PrecioCOnGAstosjLabel1.setBounds(new Rectangle(416, 78, 388, 26));
			PrecioCOnGAstosjLabel1.setVisible(false);
			TasaCambiojLabel1 = new JLabel();
			TasaCambiojLabel1.setBounds(new Rectangle(9, 75, 222, 26));
			TasaCambiojLabel1.setText("Tasa de Cambio de EUR a USD:");
			ConversionjPanel1 = new JPanel();
			ConversionjPanel1.setLayout(null);
			ConversionjPanel1.setBackground(new Color(190,190,190));
			ConversionjPanel1.setVisible(false);
			ConversionjPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos del Cambio de Moneda de EUR a USD", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
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
						JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "El Tipo de Moneda debe ser EUR", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			if(mp.getPrecioadquisicioEUROaUSD()!=0){
				PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicioEUROaUSD())));				
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
			GastosdeFletejPanel1.add(getJTextField(), null);
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
			PrecioconGastosjTextField.setVisible(false);
			PrecioconGastosjTextField.setBounds(new Rectangle(804, 79, 136, 26));
			Validate.validateDigitAndComma(PrecioconGastosjTextField);
			
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioadquisicionEURyGastos()!=0){
				PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicionEURyGastos())));
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
			PrecioenUSDconGAstosjButton.setBounds(new Rectangle(321, 24, 67, 87));
			PrecioenUSDconGAstosjButton.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
							float gastosflete = Float.valueOf(GastosjTextField.getText());
							float cant = Float.valueOf(CantidadFacturadajTextField.getText());
							float div = gastosflete/cant;
							if(getJComboBoxMoneda().getSelectedIndex()!=0){
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
								float precio = Float.valueOf(PrecioAdquisicionjTextField.getText());
								jTextField.setText(String.valueOf(dosDigitos.format(div + precio)));
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
								float precioAdcon = Float.valueOf(PrecioConvertidojTextField.getText());
								PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
							}
							}else{
								JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Debe Elegir el Tipo de Moneda", "Informacion", JOptionPane.ERROR_MESSAGE);
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return PrecioenUSDconGAstosjButton;
	}
	
	
	

	/**
	 * This method initializes RegistrarProductojButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegistrarProductojButton() {
		if (RegistrarProductojButton == null) {
			RegistrarProductojButton = new JButton();
			RegistrarProductojButton.setText("Modificar");
			RegistrarProductojButton.setBounds(new Rectangle(86, 15, 166, 38));
			RegistrarProductojButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			RegistrarProductojButton.addActionListener(new java.awt.event.ActionListener() {				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0) && !(jComboBoxTipoMateria.getSelectedIndex()==0) && !(jComboBoxUnidad.getSelectedIndex()==0) && ProveedorjTextField.getText().length()!=0 && NumeropFacturajTextField.getText().length()!=0
							&& DescripcionjTextArea.getText().length()!=0 && CantCompradajTextField.getText().length()!=0  && ImporteComprajTextField.getText().length()!=0 && PrecioAdquisicionjTextField.getText().length()!=0 ){
					//Condiciones con USD
						//1
						if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
					if( CantConveretidajTextField.getText().length()==0 && jTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, 0, null, 0, 0);
						JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
						TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
						TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					
					//2
					if( CantConveretidajTextField.getText().length()!=0 &&  jTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()),  Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, 0, null, 0, 0);
							JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					//3					
					if(jTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField.getText()), 0, null, 0, 0);
							JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					//4
					if(jTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField.getText()), 0, null, 0, 0);
							JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
					    } catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
						}else{
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
					//Condiciones con EUR
					//1
					if(CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate, Float.valueOf(TasaCAmbiojTextField.getText()), 0);
						JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
						TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
						TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					
					//2
					if(  CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(),  ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate, Float.valueOf(TasaCAmbiojTextField.getText()), 0);
						JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
						TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
						TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					
					//3
					if(CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(),  ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}
					
					//4
					if(  CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaExtranjera(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), 0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Materia Prima Modificada Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							UnidadMedidajLabel1.setText("* Unidad de Medida:  " + ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo());
							TipoMonedajLabel1.setText("* Tipo de Moneda:  " +  ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion());
							TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+ ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getDescripcion());
							
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}
					
									
					}
						}
					}
					else{
						JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Los datos marcados con * son obligatorios", "Informacion", JOptionPane.ERROR_MESSAGE);	
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()	
				}
			});
		}
		return RegistrarProductojButton;
	}
	
	
	
	

	/**
	 * This method initializes SalirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSalirjButton() {
		if (SalirjButton == null) {
			SalirjButton = new JButton();
			SalirjButton.setText("Menú Principal");
			SalirjButton.setBounds(new Rectangle(773, 15, 166, 38));
			SalirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			SalirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Started i = new Started();
					dispose();
					new Principal(i).setVisible(true);
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
			jComboBoxUnidad.setBounds(new Rectangle(941, 32, 185, 26));
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
			jComboBoxMoneda.setBounds(new Rectangle(492, 173, 155, 26));
			jComboBoxMoneda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxMoneda().getSelectedIndex()==2){
						ConversionjPanel1.setVisible(true);
						PrecioCOnGAstosjLabel1.setVisible(true);
						PrecioconGastosjTextField.setVisible(true);
						PrecioenUSDconGAstosjLabel1.setVisible(false);
						jTextField.setVisible(false);
						jTextField.setText("");
						}else{					
							ConversionjPanel1.setVisible(false);
							PrecioCOnGAstosjLabel1.setVisible(false);
							PrecioconGastosjTextField.setVisible(false);
							PrecioenUSDconGAstosjLabel1.setVisible(true);
							jTextField.setVisible(true);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							PrecioconGastosjTextField.setText("");
							}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			
		}
		return jComboBoxMoneda;
	}
	
	
	
	
	/**
	 * This method initializes jComboBoxRol	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxTipoMateria() {
		if (jComboBoxTipoMateria  == null) {
			jComboBoxTipoMateria = new JComboBox();
			jComboBoxTipoMateria.setBounds(new Rectangle(6, 101, 171, 26));
			
		}
		return jComboBoxTipoMateria;
	}



	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Listado de Materias Primas Importadas");
			jButton.setBounds(new Rectangle(455, 15, 303, 38));
			jButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMateriasPrimasExtranjeras().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton;
	}






	/**
	 * This method initializes ImpjButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getImpjButton1() {
		if (ImpjButton1 == null) {
			ImpjButton1 = new JButton();
			ImpjButton1.setText("Imprimir");
			ImpjButton1.setBounds(new Rectangle(267, 15, 166, 38));
			ImpjButton1.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImpjButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0)){
						//Condiciones con USD
						//1
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && CantConveretidajTextField.getText().length()==0 && jTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
				
						try {
							Reportes.getR().ImprimirMateriaPrimaImportadaUSD(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();						
						}				
							}
					
					//2
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && CantConveretidajTextField.getText().length()!=0  && jTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
						try {
							Reportes.getR().ImprimirMateriaPrimaconUSDGalon(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					//3				
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField.getText().length()!=0 &&  CantConveretidajTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
						try {
							Reportes.getR().ImprimirMateriaPrimaconGastosUSD(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					//4
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField.getText().length()!=0  && CantConveretidajTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()==0){
						try {
							Reportes.getR().ImprimirMateriaPrimaconUSDconGastosyGalonImportada(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					//Condiciones con EUR
					//1
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")  && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMateriaPrimaImportadaEUR(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					
					//2
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")  && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMateriaPrimaImpoprtadaEURconGalo(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
					
					//3
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")  && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						try {
							Reportes.getR().ImprimirMateriaPrimaImportadaEURconGastos(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}
					
					
					//4
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")  && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						try {
							Reportes.getR().ImprimirMateriaPrimaImportadaEURconGastosyGalon(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							}
					
					
					
						System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					}
					else{
						JOptionPane.showMessageDialog(ModificarMateriaPrimaExtranjeraVisual.this, "Es necesario que elija el Tipo de Moneda", "Informacion", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
		}
		return ImpjButton1;
	}



	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(580, 34, 348, 102));
			jScrollPane.setViewportView(getDescripcionjTextArea());
		}
		return jScrollPane;
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
			jPanel1.add(getJComboBoxTipoMateria(), null);
			jPanel1.add(TipoMateriajLabel1, null);
			jPanel1.add(getPrecioAdquisicionjTextField(), null);
			jPanel1.add(PrecioAdquisicionjLabel1, null);
			jPanel1.add(getImporteComprajTextField(), null);
			jPanel1.add(ImporteComprajLabel1, null);
			jPanel1.add(getJComboBoxMoneda(), null);
			jPanel1.add(TipoMonedajLabel1, null);
			jPanel1.add(getCantConveretidajTextField(), null);
			jPanel1.add(CantidadConvertidajLabel1, null);
			jPanel1.add(getConvertiraGalonjButton(), null);
			jPanel1.add(getCantCompradajTextField(), null);
			jPanel1.add(CantCompradajLabel1, null);
			jPanel1.add(getProveedorjTextField(), null);
			jPanel1.add(jLabel, null);
			jPanel1.add(getNumeropFacturajTextField(), null);
			jPanel1.add(NumeroFacturajLabel1, null);
			jPanel1.add(getDatejSpinner1(), null);
			jPanel1.add(FechaFacturajLabel1, null);
			jPanel1.add(DescripcionjLabel1, null);
			jPanel1.add(getJComboBoxUnidad(), null);
			jPanel1.add(UnidadMedidajLabel1, null);
			jPanel1.add(getJScrollPane(), null);
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
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.add(getSalirjButton(), null);
			jPanel2.add(getJButton(), null);
			jPanel2.add(getImpjButton1(), null);
			jPanel2.add(getRegistrarProductojButton(), null);
		}
		return jPanel2;
	}



	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(804, 32, 136, 26));
			Validate.validateDigitAndComma(jTextField);			
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioadquisicionUSDyGastos()!=0){
				jTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicionUSDyGastos())));
				jTextField.setBounds(new Rectangle(804, 31, 136, 26));
			}else{
				jTextField.setText("");
			}
		}
		return jTextField;
	}



	
	
	
}  //  @jve:decl-index=0:visual-constraint="193,-78"
