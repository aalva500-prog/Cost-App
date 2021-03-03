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

import model.MateriaPrima;
import model.TipoMateria;
import model.TipoMoneda;
import model.UnidadMedida;
import net.sf.jasperreports.engine.JRException;
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

public class ModificarMateriaPrimaNacionalVisual extends JFrame {


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
	private JButton CostoUnitarioTotaljButton = null;
	private JTextField CostoUnitarioTotaljTextField = null;
	private JButton SalirjButton = null;
	private JLabel TipoMateriajLabel1 = null;
	private JPanel GastosdeLogisticajPanel1 = null;
	private JButton logisticajButton = null;
	private JLabel logisticajLabel1 = null;
	private JTextField LogisticajTextField = null;
	private JComboBox jComboBoxUnidad = null;
	private JComboBox jComboBoxMoneda= null;
	private JComboBox jComboBoxTipoMateria = null;
	private JButton ModificarjButton = null;
	private JButton ImprimirjButton = null;
	private MateriaPrima mp =null;
	private JButton jButton = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JTextField jTextField1 = null;
		
	
	public ModificarMateriaPrimaNacionalVisual(MateriaPrima mp) {
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
		this.setSize(new Dimension(1229, 709));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setTitle("Datos de la Materia Prima de Origen Nacional");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJPanel());
		
		if(mp.getTipomoneda().equals("DOP")){
			ConversionjPanel1.setVisible(true);
			PrecioCOnGAstosjLabel1.setVisible(true);
			PrecioconGastosjTextField.setVisible(true);
			PrecioenUSDconGAstosjLabel1.setVisible(false);
			jTextField1.setVisible(false);
		}
		
		if(mp.getUnidadmedida().equals("GALÓN")){
			ConvertiraGalonjButton.setVisible(true);
			CantidadConvertidajLabel1.setVisible(true);
			CantConveretidajTextField.setVisible(true);
		}
		
		
		 //Combobox Tipo Moneda
		LinkedList<TipoMoneda> list1 = new LinkedList<TipoMoneda>();
		try {
			list1= ServicioMoneda.getUnidades();
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
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.insets = new Insets(1, 9, 6, 6);
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.ipadx = 1195;
			gridBagConstraints4.ipady = 210;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(4, 9, 5, 6);
			gridBagConstraints3.gridy = 3;
			gridBagConstraints3.ipadx = 1195;
			gridBagConstraints3.ipady = 65;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(5, 9, 9, 6);
			gridBagConstraints2.gridy = 4;
			gridBagConstraints2.ipadx = 1195;
			gridBagConstraints2.ipady = 90;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(3, 9, 3, 6);
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.ipadx = 1195;
			gridBagConstraints1.ipady = 121;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(6, 9, 3, 6);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.ipadx = 1195;
			gridBagConstraints.ipady = 124;
			gridBagConstraints.gridx = 0;
			TipoMateriajLabel1 = new JLabel();
			TipoMateriajLabel1.setText("* Tipo de Materia Prima:  "+mp.getTipomateriaprima());
			TipoMateriajLabel1.setBounds(new Rectangle(15, 73, 253, 26));
			PrecioenUSDconGAstosjLabel1 = new JLabel();
			PrecioenUSDconGAstosjLabel1.setText("Precio de Adquisición en USD con Gastos de Flete y otros incluido:");
			PrecioenUSDconGAstosjLabel1.setBounds(new Rectangle(409, 31, 388, 26));
			PrecioCOnvertidojLabel1 = new JLabel();
			PrecioCOnvertidojLabel1.setText("Precio de Adquisición Convertido de DOP a USD:");
			PrecioCOnvertidojLabel1.setBounds(new Rectangle(435, 49, 278, 26));
			FechaTasaConversionjLabel1 = new JLabel();
			FechaTasaConversionjLabel1.setText("Fecha Tasa de Cambio de DOP a USD:");
			FechaTasaConversionjLabel1.setBounds(new Rectangle(9, 24, 222, 26));
			PrecioAdquisicionjLabel1 = new JLabel();
			PrecioAdquisicionjLabel1.setText("* Precio de Adquisición:");
			PrecioAdquisicionjLabel1.setBounds(new Rectangle(810, 143, 181, 26));
			ImporteComprajLabel1 = new JLabel();
			ImporteComprajLabel1.setText("* Importe de la Compra:");
			ImporteComprajLabel1.setBounds(new Rectangle(662, 143, 136, 26));
			TipoMonedajLabel1 = new JLabel();
			TipoMonedajLabel1.setText("* Tipo de Moneda:  " + mp.getTipomoneda());
			TipoMonedajLabel1.setBounds(new Rectangle(500, 143, 155, 26));
			CantidadConvertidajLabel1 = new JLabel();
			CantidadConvertidajLabel1.setText("Cantidad Comprada Convertida a Galón:");
			CantidadConvertidajLabel1.setBounds(new Rectangle(257, 143, 232, 26));
			CantidadConvertidajLabel1.setVisible(false);
			CantCompradajLabel1 = new JLabel();
			CantCompradajLabel1.setText("* Cantidad Comprada:");
			CantCompradajLabel1.setBounds(new Rectangle(15, 143, 171, 26));
			UnidadMedidajLabel1 = new JLabel();
			UnidadMedidajLabel1.setText("* Unidad de Medida:  " + mp.getUnidadmedida());
			UnidadMedidajLabel1.setBounds(new Rectangle(948, 4, 170, 26));
			DescripcionjLabel1 = new JLabel();
			DescripcionjLabel1.setText("* Descripción del Producto:");
			DescripcionjLabel1.setBounds(new Rectangle(587, 4, 348, 26));
			FechaFacturajLabel1 = new JLabel();
			FechaFacturajLabel1.setText("* Fecha Factura:");
			FechaFacturajLabel1.setBounds(new Rectangle(438, 4, 136, 26));
			NumeroFacturajLabel1 = new JLabel();
			NumeroFacturajLabel1.setText("* Número de Factura:");
			NumeroFacturajLabel1.setBounds(new Rectangle(288, 4, 136, 26));
			jLabel = new JLabel();
			jLabel.setText("* Nombre del Proveedor:");
			jLabel.setBounds(new Rectangle(15, 4, 251, 26));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getConversionjPanel1(), gridBagConstraints);
			jPanel.add(getGastosdeFletejPanel1(), gridBagConstraints1);
			jPanel.add(getGastosdeLogisticajPanel1(), gridBagConstraints2);
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
			ProveedorjTextField.setText(mp.getNombreproveedor());
			ProveedorjTextField.setBounds(new Rectangle(15, 28, 253, 26));
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
			NumeropFacturajTextField.setBounds(new Rectangle(288, 28, 136, 26));
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
			CantCompradajTextField.setText(String.valueOf(dosDigitos.format(mp.getCantcomprada())));
			CantCompradajTextField.setBounds(new Rectangle(15, 168, 172, 26));
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
			CantConveretidajTextField.setBounds(new Rectangle(257, 168, 136, 26));
			
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			Validate.validateDigitAndComma(CantConveretidajTextField);			
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
			ImporteComprajTextField.setText(String.valueOf(dosDigitos.format(mp.getImportecompra())));
			ImporteComprajTextField.setBounds(new Rectangle(663, 168, 136, 26));
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
			ConvertiraGalonjButton.setBounds(new Rectangle(198, 143, 46, 44));
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
			PrecioAdquisicionjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisisonUSD())));
			PrecioAdquisicionjTextField.setBounds(new Rectangle(810, 167, 181, 26));
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
			DatejSpinner1.setBounds(new Rectangle(438, 28, 136, 26));
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
			java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
			if(mp.getFechaconversionDOPaUSD()!=null){
			DatejSpinner.setValue(mp.getFechaconversionDOPaUSD());
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
			PrecioCOnGAstosjLabel1.setText("Precio de Adquisición Convertido de DOP a USD con Gastos Inluido:");
			PrecioCOnGAstosjLabel1.setBounds(new Rectangle(409, 77, 388, 26));
			PrecioCOnGAstosjLabel1.setVisible(false);
			TasaCambiojLabel1 = new JLabel();
			TasaCambiojLabel1.setBounds(new Rectangle(9, 75, 222, 26));
			TasaCambiojLabel1.setText("Tasa de Cambio de DOP a USD:");
			ConversionjPanel1 = new JPanel();
			ConversionjPanel1.setLayout(null);
			ConversionjPanel1.setBackground(new Color(190,190,190));
			ConversionjPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos del Cambio de Moneda de DOP a USD", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			ConversionjPanel1.setVisible(false);
			ConversionjPanel1.add(FechaTasaConversionjLabel1, null);
			ConversionjPanel1.add(TasaCambiojLabel1, null);
			ConversionjPanel1.add(getCAlcularPreciojButton(), null);
			ConversionjPanel1.add(PrecioCOnvertidojLabel1, null);
			ConversionjPanel1.add(getPrecioConvertidojTextField(), null);
			ConversionjPanel1.add(getDatejSpinner(), null);
			ConversionjPanel1.add(getTasaCAmbiojTextField(), null);
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
					float importe = Float.valueOf(ImporteComprajTextField.getText());					
					float tasa = Float.valueOf(TasaCAmbiojTextField.getText());
					float precio = importe/tasa;
					if(getJComboBoxMoneda().getSelectedIndex()==1){
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && CantConveretidajTextField.getText().length() == 0){
						float cantcomp = Float.valueOf(CantCompradajTextField.getText());
					PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(precio/cantcomp)));
					}
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && CantConveretidajTextField.getText().length() != 0){
						float cantconvert = Float.valueOf(CantConveretidajTextField.getText());
					PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(precio/cantconvert)));
					}
					}else{
						JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Debe Elegir el Tipo de Moneda", "Error", JOptionPane.ERROR_MESSAGE);
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
			if(mp.getPrecioadquisicionDOPaUSD()!=0){
				PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicionDOPaUSD())));
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
			GastosdeFletejPanel1.add(getJTextField1(), null);
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
			PrecioconGastosjTextField.setBounds(new Rectangle(797, 78, 136, 26));
			Validate.validateDigitAndComma(PrecioconGastosjTextField);	
			
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioadquisicionDOPyGastos()!=0){
				PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicionDOPyGastos())));
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
			PrecioenUSDconGAstosjButton.setBounds(new Rectangle(314, 23, 67, 87));
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
								jTextField1.setText(String.valueOf(dosDigitos.format(div + precio)));
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP")){
								float precioAdcon = Float.valueOf(PrecioConvertidojTextField.getText());
								PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
							}
							}else{
								JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Debe Elegir el Tipo de Moneda", "Error", JOptionPane.ERROR_MESSAGE);
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return PrecioenUSDconGAstosjButton;
	}
	
	
	
/**
	 * This method initializes CostoUnitarioTotaljButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCostoUnitarioTotaljButton() {
		if (CostoUnitarioTotaljButton == null) {
			CostoUnitarioTotaljButton = new JButton();
			CostoUnitarioTotaljButton.setText("* Costo Unitario Total en USD:");
			CostoUnitarioTotaljButton.setBounds(new Rectangle(9, 12, 204, 38));
			CostoUnitarioTotaljButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
							if(getJComboBoxMoneda().getSelectedIndex()!=0){
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()==0 ){
								float precioad = Float.valueOf(PrecioAdquisicionjTextField.getText());
								CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(precioad)));
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 ){
								float precioadcon = Float.valueOf(jTextField1.getText());
								CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(precioadcon)));
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && PrecioconGastosjTextField.getText().length()==0 ){
								float precioaddom = Float.valueOf(PrecioConvertidojTextField.getText());
								CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(precioaddom)));
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && PrecioconGastosjTextField.getText().length()!=0 ){
								float precioadcondom = Float.valueOf(PrecioconGastosjTextField.getText());
								CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(precioadcondom)));
							}
							}else{
								JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Debe Elegir el Tipo de Moneda", "Error", JOptionPane.ERROR_MESSAGE);
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return CostoUnitarioTotaljButton;
	}

	
	
	
	/**
	 * This method initializes CostoUnitarioTotaljTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoUnitarioTotaljTextField() {
		if (CostoUnitarioTotaljTextField == null) {
			CostoUnitarioTotaljTextField = new JTextField();
			
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(mp.getCostounitario())));
			CostoUnitarioTotaljTextField.setBounds(new Rectangle(211, 12, 151, 38));
		}
		return CostoUnitarioTotaljTextField;
	}
	
	
	

	/**
	 * This method initializes SalirjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSalirjButton() {
		if (SalirjButton == null) {
			SalirjButton = new JButton();
			SalirjButton.setText("Listado Materias primsa de Origen Nacional");
			SalirjButton.setBounds(new Rectangle(718, 12, 311, 38));
			SalirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			SalirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMateriasPrimasNacionales().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return SalirjButton;
	}
	
	
	

	/**
	 * This method initializes GastosdeLogisticajPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getGastosdeLogisticajPanel1() {
		if (GastosdeLogisticajPanel1 == null) {
			logisticajLabel1 = new JLabel();
			logisticajLabel1.setBounds(new Rectangle(14, 49, 437, 27));
			logisticajLabel1.setText("Costo Unitario Total en USD con 10% de incremento por Gastos de Logística:");
			GastosdeLogisticajPanel1 = new JPanel();
			GastosdeLogisticajPanel1.setLayout(null);
			GastosdeLogisticajPanel1.setBackground(new Color(190,190,190));
			GastosdeLogisticajPanel1.setBorder(BorderFactory.createTitledBorder(null, "Gastos de Logística", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			GastosdeLogisticajPanel1.add(getLogisticajButton(), null);
			GastosdeLogisticajPanel1.add(logisticajLabel1, null);
			GastosdeLogisticajPanel1.add(getLogisticajTextField(), null);
		}
		return GastosdeLogisticajPanel1;
	}

	
	
	/**
	 * This method initializes logisticajButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLogisticajButton() {
		if (logisticajButton == null) {
			logisticajButton = new JButton();
			logisticajButton.setBounds(new Rectangle(450, 23, 165, 27));
			logisticajButton.setText("=");
			logisticajButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					float costo = Float.valueOf(CostoUnitarioTotaljTextField.getText());
					float cal = (float) (costo*1.1);
					LogisticajTextField.setText(String.valueOf(dosDigitos.format(cal)));
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return logisticajButton;
	}
	
	
	

	/**
	 * This method initializes LogisticajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLogisticajTextField() {
		if (LogisticajTextField == null) {
			LogisticajTextField = new JTextField();
			LogisticajTextField.setBounds(new Rectangle(450, 49, 165, 27));
			Validate.validateDigitAndComma(LogisticajTextField);			
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getCostounitariologistica()!=0){
	        LogisticajTextField.setText(String.valueOf(dosDigitos.format(mp.getCostounitariologistica())));
			}else{
				LogisticajTextField.setText("");	
			}
		}
		return LogisticajTextField;
	}

	
	/**
	 * This method initializes jComboBoxRol	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxUnidad() {
		if (jComboBoxUnidad  == null) {
			jComboBoxUnidad = new JComboBox();
			jComboBoxUnidad.setBounds(new Rectangle(948, 28, 170, 26));
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
			jComboBoxMoneda.setBounds(new Rectangle(500, 169, 155, 26));
			jComboBoxMoneda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxMoneda().getSelectedIndex()==1){
						ConversionjPanel1.setVisible(true);
						PrecioCOnGAstosjLabel1.setVisible(true);
						PrecioconGastosjTextField.setVisible(true);
						PrecioenUSDconGAstosjLabel1.setVisible(false);
						jTextField1.setVisible(false);
						jTextField1.setText("");
						}else{					
							ConversionjPanel1.setVisible(false);
							PrecioCOnGAstosjLabel1.setVisible(false);
							PrecioconGastosjTextField.setVisible(false);
							PrecioenUSDconGAstosjLabel1.setVisible(true);
							jTextField1.setVisible(true);
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
			jComboBoxTipoMateria.setBounds(new Rectangle(15, 97, 171, 26));
		}
		return jComboBoxTipoMateria;
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
			ModificarjButton.setBounds(new Rectangle(393, 12, 149, 38));
			ModificarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			ModificarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0) && !(jComboBoxTipoMateria.getSelectedIndex()==0) && !(jComboBoxUnidad.getSelectedIndex()==0) && ProveedorjTextField.getText().length()!=0 && NumeropFacturajTextField.getText().length()!=0
							&& DescripcionjTextArea.getText().length()!=0 && CantCompradajTextField.getText().length()!=0  && ImporteComprajTextField.getText().length()!=0 && PrecioAdquisicionjTextField.getText().length()!=0 && CostoUnitarioTotaljTextField.getText().length()!=0){
						//Condiciones con USD
						//1
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()));
						JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && CantConveretidajTextField.getText().length()!=0 && LogisticajTextField.getText().length()==0 && jTextField1.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0, 0, 0, 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
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
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField1.getText()), 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					
					//5
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField1.getText()), 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
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
					//6
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()==0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 ){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0,0, 0, 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					//7
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField1.getText()), 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					//8
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(jTextField1.getText()), 0, null, 0, 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					//Condiciones con DOP
					//1
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0,0,0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()));
						JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0,0,0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()));
						JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
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
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0,0,0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()),Float.valueOf(LogisticajTextField.getText()));
						JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), 0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(GastosjTextField.getText()),0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(CostoUnitarioTotaljTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					
					//5
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()),  Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), 0,0,0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), 0, Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					//6
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrimaNacionalsinLogistica(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()),  Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(GastosjTextField.getText()),0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(CostoUnitarioTotaljTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
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
					//7
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()),  0, ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),  Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(GastosjTextField.getText()),0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					//8
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.ModificarMateriaPrima(mp.getId_Materia(), ((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()),  Float.valueOf(CantConveretidajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(GastosjTextField.getText()),0, Float.valueOf(PrecioConvertidojTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Materia Prima Modificada Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);	
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
					else{
						JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Los datos marcados con * son obligatorios", "Informacion", JOptionPane.ERROR_MESSAGE);	
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
			ImprimirjButton.setBounds(new Rectangle(555, 12, 149, 38));
			ImprimirjButton.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImprimirjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0)){
					//Condiciones con USD
					//1
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
			
					try {
						Reportes.getR().ImprimirMateriaPrima(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();						
					}				
						}
				
				//2
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && jTextField1.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMateriaPrimaconLogistica(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}
				
				//3
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && CantConveretidajTextField.getText().length()!=0 && LogisticajTextField.getText().length()==0 && jTextField1.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMateriaPrimaconGalon(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//4					
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMateriaPrimaconGastos(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//5
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMateriaPrimaconGastosyLogistica(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//6
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()==0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()==0 ){
					try {
						Reportes.getR().ImprimirMateriaPrimaconGalonyLogistica(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//7
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMateriaPrimaconUSDconGastosyGalon(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//8
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && jTextField1.getText().length()!=0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()==0){
					try {
						Reportes.getR().ImprimirMateriaPrimaNAcionalUSDCompleto(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//Condiciones con DOP
				//1
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
				try {
					Reportes.getR().ImprimirMateriaPrimaNAcionalDOP(mp.getId_Materia());
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}
				
				//2
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
				try {
					Reportes.getR().ImprimirMateriaPrimaNAcionalDOPconGalo(mp.getId_Materia());
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}
				
				//3
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
				try {
					Reportes.getR().ImprimirMateriaPrimaNAcionalDOPconLogistica(mp.getId_Materia());
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					}
				
				//4
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMateriaPrimaNAcionalDOPconGastos(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				
				//5
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMateriaPrimaNAcionalDOPconLogisticayGalon(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				//6
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMateriaPrimaNAcionalDOPconGastosyGalon(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				//7
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMateriaPrimaNAcionalDOPconGastosyLogistica(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				//8
				if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP") && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
					try {
						Reportes.getR().ImprimirMateriaPrimaNAcionalDOPCOmpleto(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
				
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
				else{
					JOptionPane.showMessageDialog(ModificarMateriaPrimaNacionalVisual.this, "Es necesario que elija el Tipo de Moneda", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			jButton.setBounds(new Rectangle(1040, 12, 149, 38));
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
			jScrollPane.setBounds(new Rectangle(586, 28, 348, 99));
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
			jPanel1.add(getJButton(), null);
			jPanel1.add(getSalirjButton(), null);
			jPanel1.add(getImprimirjButton(), null);
			jPanel1.add(getModificarjButton(), null);
			jPanel1.add(getCostoUnitarioTotaljTextField(), null);
			jPanel1.add(getCostoUnitarioTotaljButton(), null);
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
			jPanel2.add(getJComboBoxTipoMateria(), null);
			jPanel2.add(TipoMateriajLabel1, null);
			jPanel2.add(getPrecioAdquisicionjTextField(), null);
			jPanel2.add(PrecioAdquisicionjLabel1, null);
			jPanel2.add(getImporteComprajTextField(), null);
			jPanel2.add(ImporteComprajLabel1, null);
			jPanel2.add(getJComboBoxMoneda(), null);
			jPanel2.add(TipoMonedajLabel1, null);
			jPanel2.add(DescripcionjLabel1, null);
			jPanel2.add(getJComboBoxUnidad(), null);
			jPanel2.add(UnidadMedidajLabel1, null);
			jPanel2.add(CantidadConvertidajLabel1, null);
			jPanel2.add(getCantConveretidajTextField(), null);
			jPanel2.add(getDatejSpinner1(), null);
			jPanel2.add(FechaFacturajLabel1, null);
			jPanel2.add(getNumeropFacturajTextField(), null);
			jPanel2.add(NumeroFacturajLabel1, null);
			jPanel2.add(getProveedorjTextField(), null);
			jPanel2.add(jLabel, null);
			jPanel2.add(getConvertiraGalonjButton(), null);
			jPanel2.add(getCantCompradajTextField(), null);
			jPanel2.add(CantCompradajLabel1, null);
			jPanel2.add(getJScrollPane(), null);
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
			jTextField1.setBounds(new Rectangle(797, 30, 136, 26));
			Validate.validateDigitAndComma(jTextField1);				
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioadquisicionUSDyGastos()!=0){
				jTextField1.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicionUSDyGastos())));
				jTextField1.setBounds(new Rectangle(797, 30, 136, 26));
				}else{
					jTextField1.setText("");	
				}
		}
		return jTextField1;
	}



	
	
	
}  //  @jve:decl-index=0:visual-constraint="288,38"
