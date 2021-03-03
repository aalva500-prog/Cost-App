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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import model.TipoMateria;
import model.TipoMoneda;
import model.UnidadMedida;
import services.ServicioMateriaPrima;
import services.ServicioMoneda;
import services.ServicioTipoMateria;
import services.ServicioUnidadMedida;
import Utils.UserInterfaceSuport;
import Utils.Validate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InsertarMateriaPrimaNacionalVisual extends JFrame {


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
	private JTextField PreciodeAdquisicionconGAstosjTextField = null;
	private JButton CostoUnitarioTotaljButton = null;
	private JTextField CostoUnitarioTotaljTextField = null;
	private JButton RegistrarProductojButton = null;
	private JButton SalirjButton = null;
	private JLabel TipoMateriajLabel1 = null;
	private JPanel GastosdeLogisticajPanel1 = null;
	private JRadioButton SijRadioButton = null;
	private JRadioButton NojRadioButton = null;
	private JButton logisticajButton = null;
	private JLabel logisticajLabel1 = null;
	private JTextField LogisticajTextField = null;
	private JComboBox jComboBoxUnidad = null;
	private JComboBox jComboBoxMoneda= null;
	private JComboBox jComboBoxTipoMateria = null;
	private JButton jButton = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	public InsertarMateriaPrimaNacionalVisual() {
		super();
		initialize();
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private void initialize() {
		this.setSize(new Dimension(1176, 704));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setTitle("Introducir  Datos de las Materias Primas de Origen Nacional");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJPanel());
		logisticajLabel1.setVisible(false);
		LogisticajTextField.setVisible(false);
		logisticajButton.setVisible(false);
		
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
			gridBagConstraints4.insets = new Insets(6, 7, 3, 10);
			gridBagConstraints4.gridy = 3;
			gridBagConstraints4.ipadx = 1140;
			gridBagConstraints4.ipady = 75;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(6, 7, 1, 10);
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.ipadx = 1140;
			gridBagConstraints3.ipady = 214;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(3, 7, 0, 10);
			gridBagConstraints2.gridy = 4;
			gridBagConstraints2.ipadx = 1140;
			gridBagConstraints2.ipady = 90;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(4, 7, 5, 10);
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.ipadx = 1140;
			gridBagConstraints1.ipady = 121;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(2, 7, 4, 10);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.ipadx = 1140;
			gridBagConstraints.ipady = 124;
			gridBagConstraints.gridx = 0;
			TipoMateriajLabel1 = new JLabel();
			TipoMateriajLabel1.setText("* Tipo de Materia Prima:");
			TipoMateriajLabel1.setBounds(new Rectangle(1000, 146, 136, 26));
			PrecioenUSDconGAstosjLabel1 = new JLabel();
			PrecioenUSDconGAstosjLabel1.setText("Precio de Adquisición en USD con Gastos de Flete y otros incluido:");
			PrecioenUSDconGAstosjLabel1.setBounds(new Rectangle(415, 31, 388, 26));
			PrecioCOnvertidojLabel1 = new JLabel();
			PrecioCOnvertidojLabel1.setText("Precio de Adquisición Convertido de DOP a USD:");
			PrecioCOnvertidojLabel1.setBounds(new Rectangle(435, 49, 278, 26));
			FechaTasaConversionjLabel1 = new JLabel();
			FechaTasaConversionjLabel1.setText("Fecha Tasa de Cambio de DOP a USD:");
			FechaTasaConversionjLabel1.setBounds(new Rectangle(9, 24, 222, 26));
			PrecioAdquisicionjLabel1 = new JLabel();
			PrecioAdquisicionjLabel1.setText("* Precio de Adquisición:");
			PrecioAdquisicionjLabel1.setBounds(new Rectangle(803, 146, 181, 26));
			ImporteComprajLabel1 = new JLabel();
			ImporteComprajLabel1.setText("* Importe de la Compra:");
			ImporteComprajLabel1.setBounds(new Rectangle(655, 146, 136, 26));
			TipoMonedajLabel1 = new JLabel();
			TipoMonedajLabel1.setText("* Tipo de Moneda:");
			TipoMonedajLabel1.setBounds(new Rectangle(502, 146, 136, 26));
			CantidadConvertidajLabel1 = new JLabel();
			CantidadConvertidajLabel1.setText("Cantidad Comprada Convertida a Galón:");
			CantidadConvertidajLabel1.setBounds(new Rectangle(250, 146, 232, 26));
			CantidadConvertidajLabel1.setVisible(false);
			CantCompradajLabel1 = new JLabel();
			CantCompradajLabel1.setText("* Cantidad Comprada:");
			CantCompradajLabel1.setBounds(new Rectangle(7, 146, 171, 26));
			UnidadMedidajLabel1 = new JLabel();
			UnidadMedidajLabel1.setText("* Unidad de Medida:");
			UnidadMedidajLabel1.setBounds(new Rectangle(941, 7, 136, 26));
			DescripcionjLabel1 = new JLabel();
			DescripcionjLabel1.setText("* Descripción del Producto:");
			DescripcionjLabel1.setBounds(new Rectangle(580, 7, 348, 26));
			FechaFacturajLabel1 = new JLabel();
			FechaFacturajLabel1.setText("* Fecha Factura:");
			FechaFacturajLabel1.setBounds(new Rectangle(431, 7, 136, 26));
			NumeroFacturajLabel1 = new JLabel();
			NumeroFacturajLabel1.setText("* Número de Factura:");
			NumeroFacturajLabel1.setBounds(new Rectangle(281, 7, 136, 26));
			jLabel = new JLabel();
			jLabel.setText("* Nombre del Proveedor:");
			jLabel.setBounds(new Rectangle(8, 7, 251, 26));
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
			ProveedorjTextField.setBounds(new Rectangle(7, 31, 253, 26));
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
			NumeropFacturajTextField.setBounds(new Rectangle(281, 31, 136, 26));
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
			CantCompradajTextField.setBounds(new Rectangle(6, 171, 172, 26));
			Validate.validateDigitAndComma(CantCompradajTextField);
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
			CantConveretidajTextField.setEditable(false);
			CantConveretidajTextField.setBounds(new Rectangle(250, 171, 136, 26));
			CantConveretidajTextField.setVisible(false);
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
			ImporteComprajTextField.setBounds(new Rectangle(656, 171, 136, 26));
			Validate.validateDigitAndComma(ImporteComprajTextField);
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
			ConvertiraGalonjButton.setText("=");
			ConvertiraGalonjButton.setBounds(new Rectangle(191, 146, 46, 44));
			ConvertiraGalonjButton.setVisible(false);
			ConvertiraGalonjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					if(((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo().equals("GALÓN")){
						float lts = Float.valueOf(CantCompradajTextField.getText());
						CantConveretidajTextField.setText(String.valueOf(dosDigitos.format(lts*3.7853)));
					}else{
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "La Unidad de Medida debe ser GALÓN", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			PrecioAdquisicionjTextField.setBounds(new Rectangle(803, 170, 181, 26));
			Validate.validateDigitAndComma(PrecioAdquisicionjTextField);
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
			DatejSpinner1.setBounds(new Rectangle(431, 31, 136, 26));
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
			PrecioCOnGAstosjLabel1.setBounds(new Rectangle(415, 77, 388, 26));
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
					if(TasaCAmbiojTextField.getText().length()!=0){
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP")){
					if(CantConveretidajTextField.getText().length() == 0){
						float cantcomp = Float.valueOf(CantCompradajTextField.getText());
					PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(precio/cantcomp)));
					}
					if( CantConveretidajTextField.getText().length() != 0){
						float cantconvert = Float.valueOf(CantConveretidajTextField.getText());
					PrecioConvertidojTextField.setText(String.valueOf(dosDigitos.format(precio/cantconvert)));
					}				   
					}else{
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "El Tipo de Moneda debe ser DOP", "Informacion", JOptionPane.ERROR_MESSAGE);
					}		
					}else{
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "El campo Tasa de Cambio de DOP a USD no debe estar vacío", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			GastosdeFletejPanel1.add(getPreciodeAdquisicionconGAstosjTextField(), null);
			GastosdeFletejPanel1.add(PrecioenUSDconGAstosjLabel1, null);
			GastosdeFletejPanel1.add(getPrecioenUSDconGAstosjButton(), null);
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
			PrecioconGastosjTextField.setBounds(new Rectangle(803, 78, 136, 26));
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
			PrecioenUSDconGAstosjButton.setBounds(new Rectangle(320, 23, 67, 87));
			PrecioenUSDconGAstosjButton.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
							float gastosflete = Float.valueOf(GastosjTextField.getText());
							float cant = Float.valueOf(CantidadFacturadajTextField.getText());
							float div = gastosflete/cant;
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
								float precio = Float.valueOf(PrecioAdquisicionjTextField.getText());
								PreciodeAdquisicionconGAstosjTextField.setText(String.valueOf(dosDigitos.format(div + precio)));
								PrecioconGastosjTextField.setText("");
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP")){
								float precioAdcon = Float.valueOf(PrecioConvertidojTextField.getText());
								PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
								PreciodeAdquisicionconGAstosjTextField.setText("");
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return PrecioenUSDconGAstosjButton;
	}
	
	
	

	/**
	 * This method initializes PreciodeAdquisicionconGAstosjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPreciodeAdquisicionconGAstosjTextField() {
		if (PreciodeAdquisicionconGAstosjTextField == null) {
			PreciodeAdquisicionconGAstosjTextField = new JTextField();
			PreciodeAdquisicionconGAstosjTextField.setBounds(new Rectangle(803, 30, 136, 26));
			Validate.validateDigitAndComma(PreciodeAdquisicionconGAstosjTextField);
			}
		return PreciodeAdquisicionconGAstosjTextField;
	}
	
	
	

	/**
	 * This method initializes CostoUnitarioTotaljButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCostoUnitarioTotaljButton() {
		if (CostoUnitarioTotaljButton == null) {
			CostoUnitarioTotaljButton = new JButton();
			CostoUnitarioTotaljButton.setText("* Costo Unitario Total USD:");
			CostoUnitarioTotaljButton.setBounds(new Rectangle(7, 12, 189, 38));
			CostoUnitarioTotaljButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && PreciodeAdquisicionconGAstosjTextField.getText().length()==0 ){
								float precioad = Float.valueOf(PrecioAdquisicionjTextField.getText());
								CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(precioad)));
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD") && PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 ){
								float precioadcon = Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText());
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
			CostoUnitarioTotaljTextField.setEditable(false);
			CostoUnitarioTotaljTextField.setBounds(new Rectangle(196, 12, 151, 38));
		}
		return CostoUnitarioTotaljTextField;
	}
	
	
	

	/**
	 * This method initializes RegistrarProductojButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegistrarProductojButton() {
		if (RegistrarProductojButton == null) {
			RegistrarProductojButton = new JButton();
			RegistrarProductojButton.setText("Registrar Materia Prima");
			RegistrarProductojButton.setBounds(new Rectangle(461, 11, 198, 38));
			RegistrarProductojButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			RegistrarProductojButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0) && !(jComboBoxTipoMateria.getSelectedIndex()==0) && !(jComboBoxUnidad.getSelectedIndex()==0) && ProveedorjTextField.getText().length()!=0 && NumeropFacturajTextField.getText().length()!=0
							&& DescripcionjTextArea.getText().length()!=0 && CantCompradajTextField.getText().length()!=0  && ImporteComprajTextField.getText().length()!=0 && PrecioAdquisicionjTextField.getText().length()!=0 && CostoUnitarioTotaljTextField.getText().length()!=0){
					//Condiciones con USD
						//1
						if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
					if(LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PreciodeAdquisicionconGAstosjTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.insertarMateriaNacionalUSDsinGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()));
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UserInterfaceSuport.clearComponents(jPanel1);
						DescripcionjTextArea.setText("");
						UserInterfaceSuport.clearComponents(jPanel2);
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
					if( LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PreciodeAdquisicionconGAstosjTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalUSDsinGalonyConLogistica(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);		
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if( CantConveretidajTextField.getText().length()!=0 && LogisticajTextField.getText().length()==0 && PreciodeAdquisicionconGAstosjTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalUSDconGalony(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalUSDconGAstos(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if( PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalUSDconGAstosyLogistica(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
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
					if( PreciodeAdquisicionconGAstosjTextField.getText().length()==0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 ){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalUSDconGAstosyLogistica(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 && LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalUSDconGAstosyGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if( PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 && LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalUSDconGAstosGalonyLOg(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()),Float.valueOf(LogisticajTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("DOP")){
					//Condiciones con DOP
					//1
					if(LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.insertarMateriaNacionalDOP(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()));
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UserInterfaceSuport.clearComponents(jPanel1);
						UserInterfaceSuport.clearComponents(ConversionjPanel1);
						DescripcionjTextArea.setText("");
						UserInterfaceSuport.clearComponents(jPanel2);
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
					if( LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.insertarMateriaNacionalDOPyGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UserInterfaceSuport.clearComponents(jPanel1);
						UserInterfaceSuport.clearComponents(ConversionjPanel1);
						DescripcionjTextArea.setText("");
						UserInterfaceSuport.clearComponents(jPanel2);
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
					if( LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.insertarMateriaNacionalDOPyLogistica(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(LogisticajTextField.getText()));
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UserInterfaceSuport.clearComponents(jPanel1);
						UserInterfaceSuport.clearComponents(ConversionjPanel1);
						UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
						DescripcionjTextArea.setText("");
						UserInterfaceSuport.clearComponents(jPanel2);
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
					if(LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalDOPyGastos(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(GastosjTextField.getText()),Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(PrecioconGastosjTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if( LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalDOPyGalonconLogistica(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()),Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if( LogisticajTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalDOPyGastosconGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(GastosjTextField.getText()),Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(PrecioconGastosjTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if( LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalDOPyGastosconLogistica(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(GastosjTextField.getText()),Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(PrecioconGastosjTextField.getText()),Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
					if( LogisticajTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaNacionalDOPyGastosconLogisticayGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),Float.valueOf(CostoUnitarioTotaljTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(GastosjTextField.getText()),Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(PrecioconGastosjTextField.getText()),Float.valueOf(LogisticajTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
							DescripcionjTextArea.setText("");
							UserInterfaceSuport.clearComponents(jPanel2);
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
						JOptionPane.showMessageDialog(InsertarMateriaPrimaNacionalVisual.this, "Los datos marcados con * son obligatorios", "Informacion", JOptionPane.ERROR_MESSAGE);	
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
			SalirjButton.setBounds(new Rectangle(973, 11, 165, 38));
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
			GastosdeLogisticajPanel1.setBorder(BorderFactory.createTitledBorder(null, "¿Aplicar 10% de incremento por Gastos de Logística?", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			GastosdeLogisticajPanel1.add(getSijRadioButton(), null);
			GastosdeLogisticajPanel1.add(getNojRadioButton(), null);
			GastosdeLogisticajPanel1.add(getLogisticajButton(), null);
			GastosdeLogisticajPanel1.add(logisticajLabel1, null);
			GastosdeLogisticajPanel1.add(getLogisticajTextField(), null);
		}
		return GastosdeLogisticajPanel1;
	}

	
	
	/**
	 * This method initializes SijRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSijRadioButton() {
		if (SijRadioButton == null) {
			SijRadioButton = new JRadioButton();
			SijRadioButton.setBounds(new Rectangle(16, 20, 62, 21));		
			SijRadioButton.setText("Si");
			SijRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(SijRadioButton.isSelected()){
						NojRadioButton.setSelected(false);
						logisticajLabel1.setVisible(true);
						LogisticajTextField.setVisible(true);
						logisticajButton.setVisible(true);
					}
				    System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
			
		}
		return SijRadioButton;
	}
	
	
	

	/**
	 * This method initializes NojRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getNojRadioButton() {
		if (NojRadioButton == null) {
			NojRadioButton = new JRadioButton();
			NojRadioButton.setBounds(new Rectangle(90, 20, 68, 21));			
			NojRadioButton.setText("No");
			NojRadioButton.setSelected(true);
			NojRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(NojRadioButton.isSelected()){
					SijRadioButton.setSelected(false);
					logisticajLabel1.setVisible(false);
					LogisticajTextField.setVisible(false);
					logisticajButton.setVisible(false);
					UserInterfaceSuport.clearComponents(GastosdeLogisticajPanel1);
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
					}
					}
			});
		}
		return NojRadioButton;
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
			LogisticajTextField.setEditable(false);
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
			jComboBoxUnidad.setBounds(new Rectangle(941, 31, 136, 26));
			jComboBoxUnidad.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxUnidad().getSelectedIndex()!=4){
						CantConveretidajTextField.setText("");
						ConvertiraGalonjButton.setVisible(false);
						CantidadConvertidajLabel1.setVisible(false);
						CantConveretidajTextField.setVisible(false);
					}else{
						ConvertiraGalonjButton.setVisible(true);
						CantidadConvertidajLabel1.setVisible(true);
						CantConveretidajTextField.setVisible(true);
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
			jComboBoxMoneda.setBounds(new Rectangle(502, 172, 136, 26));
			jComboBoxMoneda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxMoneda().getSelectedIndex()==1){
						ConversionjPanel1.setVisible(true);
						PrecioCOnGAstosjLabel1.setVisible(true);
						PrecioconGastosjTextField.setVisible(true);
						PrecioenUSDconGAstosjLabel1.setVisible(false);
						PreciodeAdquisicionconGAstosjTextField.setVisible(false);
						}else{					
							ConversionjPanel1.setVisible(false);
							PrecioCOnGAstosjLabel1.setVisible(false);
							PrecioconGastosjTextField.setVisible(false);
							PrecioenUSDconGAstosjLabel1.setVisible(true);
							PreciodeAdquisicionconGAstosjTextField.setVisible(true);
							UserInterfaceSuport.clearComponents(getConversionjPanel1());
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
			jComboBoxTipoMateria.setBounds(new Rectangle(1000, 170, 136, 26));
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
			jButton.setText("Listado de Materias Primas Nacionales");
			jButton.setBounds(new Rectangle(669, 11, 294, 38));
		    jButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
		    jButton.addActionListener(new java.awt.event.ActionListener() {
		    	public void actionPerformed(java.awt.event.ActionEvent e) {
		    		dispose();
		    		new ListadodeMateriasPrimasNacionales().setVisible(true);
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
			jScrollPane.setBounds(new Rectangle(580, 33, 348, 101));
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
			jPanel2.add(getRegistrarProductojButton(), null);
			jPanel2.add(getCostoUnitarioTotaljTextField(), null);
			jPanel2.add(getCostoUnitarioTotaljButton(), null);
		}
		return jPanel2;
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="257,16"
