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

public class InsertarMateriaPrimaExtranjeraVisual extends JFrame {


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
	private JButton RegistrarProductojButton = null;
	private JButton SalirjButton = null;
	private JLabel TipoMateriajLabel1 = null;
	private JComboBox jComboBoxUnidad = null;
	private JComboBox jComboBoxMoneda= null;
	private JComboBox jComboBoxTipoMateria = null;
	private JButton ListajButton = null;
	private JScrollPane jScrollPane = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	public InsertarMateriaPrimaExtranjeraVisual() {
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
		this.setSize(new Dimension(1174, 593));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setContentPane(getJPanel());
		this.setTitle("Insertar Datos Principales de las Materias Primas Importadas");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
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
			gridBagConstraints3.insets = new Insets(10, 4, 2, 4);
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.ipadx = 1147;
			gridBagConstraints3.ipady = 208;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(3, 4, 4, 4);
			gridBagConstraints2.gridy = 3;
			gridBagConstraints2.ipadx = 1147;
			gridBagConstraints2.ipady = 55;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(5, 4, 2, 4);
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.ipadx = 1147;
			gridBagConstraints1.ipady = 121;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(3, 4, 5, 4);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.ipadx = 1147;
			gridBagConstraints.ipady = 124;
			gridBagConstraints.gridx = 0;
			TipoMateriajLabel1 = new JLabel();
			TipoMateriajLabel1.setText("* Tipo de Materia Prima:");
			TipoMateriajLabel1.setBounds(new Rectangle(995, 150, 144, 26));
			PrecioenUSDconGAstosjLabel1 = new JLabel();
			PrecioenUSDconGAstosjLabel1.setText("Precio de Adquisición en USD con Gastos de Flete y otros incluido:");
			PrecioenUSDconGAstosjLabel1.setBounds(new Rectangle(413, 29, 388, 26));
			PrecioCOnvertidojLabel1 = new JLabel();
			PrecioCOnvertidojLabel1.setText("Precio de Adquisición Convertido de EUR a USD:");
			PrecioCOnvertidojLabel1.setBounds(new Rectangle(435, 49, 278, 26));
			FechaTasaConversionjLabel1 = new JLabel();
			FechaTasaConversionjLabel1.setText("Fecha Tasa de Cambio de EUR a USD:");
			FechaTasaConversionjLabel1.setBounds(new Rectangle(9, 24, 222, 26));
			PrecioAdquisicionjLabel1 = new JLabel();
			PrecioAdquisicionjLabel1.setText("* Precio de Adquisición:");
			PrecioAdquisicionjLabel1.setBounds(new Rectangle(806, 150, 181, 26));
			ImporteComprajLabel1 = new JLabel();
			ImporteComprajLabel1.setText("* Importe de la Compra:");
			ImporteComprajLabel1.setBounds(new Rectangle(638, 150, 157, 26));
			TipoMonedajLabel1 = new JLabel();
			TipoMonedajLabel1.setText("* Tipo de Moneda:");
			TipoMonedajLabel1.setBounds(new Rectangle(490, 148, 136, 26));
			CantidadConvertidajLabel1 = new JLabel();
			CantidadConvertidajLabel1.setText("Cantidad Comprada Convertida a Galón:");
			CantidadConvertidajLabel1.setBounds(new Rectangle(253, 150, 232, 26));
			CantidadConvertidajLabel1.setVisible(false);
			CantCompradajLabel1 = new JLabel();
			CantCompradajLabel1.setText("* Cantidad Comprada:");
			CantCompradajLabel1.setBounds(new Rectangle(10, 150, 171, 26));
			UnidadMedidajLabel1 = new JLabel();
			UnidadMedidajLabel1.setText("* Unidad de Medida:");
			UnidadMedidajLabel1.setBounds(new Rectangle(944, 11, 136, 26));
			DescripcionjLabel1 = new JLabel();
			DescripcionjLabel1.setText("* Descripción del Producto:");
			DescripcionjLabel1.setBounds(new Rectangle(583, 11, 348, 26));
			FechaFacturajLabel1 = new JLabel();
			FechaFacturajLabel1.setText("* Fecha Factura:");
			FechaFacturajLabel1.setBounds(new Rectangle(434, 11, 136, 26));
			NumeroFacturajLabel1 = new JLabel();
			NumeroFacturajLabel1.setText("* Número de Factura:");
			NumeroFacturajLabel1.setBounds(new Rectangle(284, 11, 136, 26));
			jLabel = new JLabel();
			jLabel.setText("* Nombre del Proveedor:");
			jLabel.setBounds(new Rectangle(11, 11, 251, 26));
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
			ProveedorjTextField.setBounds(new Rectangle(10, 35, 253, 26));
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
			NumeropFacturajTextField.setBounds(new Rectangle(284, 35, 136, 26));
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
			CantCompradajTextField.setBounds(new Rectangle(9, 175, 172, 26));
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
			CantConveretidajTextField.setBounds(new Rectangle(253, 175, 136, 26));
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
			ImporteComprajTextField.setBounds(new Rectangle(639, 175, 156, 26));
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
			ConvertiraGalonjButton.setBounds(new Rectangle(194, 150, 46, 44));
			ConvertiraGalonjButton.setVisible(false);
			ConvertiraGalonjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);			
					if(((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo().equals("GALÓN")){
						double lts = Double.valueOf(CantCompradajTextField.getText());
						double calculo=(lts*3.7853);
						CantConveretidajTextField.setText(String.valueOf(dosDigitos.format(calculo)));
					}else{
						JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "La Unidad de Medida debe ser GALÓN", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			PrecioAdquisicionjTextField.setBounds(new Rectangle(806, 174, 181, 26));
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
			DatejSpinner1.setBounds(new Rectangle(434, 35, 136, 26));
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
			PrecioCOnGAstosjLabel1.setText("Precio de Adquisición Convertido de EUR a USD con Gastos Inluido:");
			PrecioCOnGAstosjLabel1.setBounds(new Rectangle(413, 75, 388, 26));
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
						JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "El Tipo de Moneda debe ser EUR", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			PrecioconGastosjTextField.setBounds(new Rectangle(801, 76, 136, 26));
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
			PrecioenUSDconGAstosjButton.setBounds(new Rectangle(318, 21, 67, 87));
			PrecioenUSDconGAstosjButton.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);						
							
							if(GastosjTextField.getText().length()!=0 && CantidadFacturadajTextField.getText().length()!=0){
								float gastosflete = Float.valueOf(GastosjTextField.getText());
								float cant = Float.valueOf(CantidadFacturadajTextField.getText());
								float div = gastosflete/cant;								
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
								float precio = Float.valueOf(PrecioAdquisicionjTextField.getText());
								
								PreciodeAdquisicionconGAstosjTextField.setText(String.valueOf(dosDigitos.format(div + precio)));
								PrecioconGastosjTextField.setText("");
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
								float precioAdcon = Float.valueOf(PrecioConvertidojTextField.getText());
								PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
								PreciodeAdquisicionconGAstosjTextField.setText("");
							}
							}else{
								JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "No pueden estar Vacíos los campos Cantidad Total Facturada y Gastos de Flete y otros", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			PreciodeAdquisicionconGAstosjTextField.setBounds(new Rectangle(801, 28, 136, 26));
			Validate.validateDigitAndComma(PreciodeAdquisicionconGAstosjTextField);
			}
		return PreciodeAdquisicionconGAstosjTextField;
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
			RegistrarProductojButton.setBounds(new Rectangle(194, 8, 197, 38));
			RegistrarProductojButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			RegistrarProductojButton.addActionListener(new java.awt.event.ActionListener() {				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0) && !(jComboBoxTipoMateria.getSelectedIndex()==0) && !(jComboBoxUnidad.getSelectedIndex()==0) && ProveedorjTextField.getText().length()!=0 && NumeropFacturajTextField.getText().length()!=0
							&& DescripcionjTextArea.getText().length()!=0 && CantCompradajTextField.getText().length()!=0  && ImporteComprajTextField.getText().length()!=0 && PrecioAdquisicionjTextField.getText().length()!=0 ){
					//Condiciones con USD
						//1
						if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
					if( CantConveretidajTextField.getText().length()==0 && PreciodeAdquisicionconGAstosjTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioMateriaPrima.insertarMateriaPrimaImportadaUSD(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()));
						JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						UserInterfaceSuport.clearComponents(jPanel2);
						DescripcionjTextArea.setText("");
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
					if( CantConveretidajTextField.getText().length()!=0 &&  PreciodeAdquisicionconGAstosjTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaImportadaUSDconGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel2);
							DescripcionjTextArea.setText("");
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaImportadaUSDconGAstos(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel2);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							ServicioMateriaPrima.insertarMateriaImportadaUSDconGAstosyGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel2);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
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
						ServicioMateriaPrima.insertarMateriaIMportadEUR(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()));
						JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UserInterfaceSuport.clearComponents(jPanel2);
						UserInterfaceSuport.clearComponents(ConversionjPanel1);
						DescripcionjTextArea.setText("");
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
						ServicioMateriaPrima.insertarMateriaImportadaEURyGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
						JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
						UserInterfaceSuport.clearComponents(jPanel2);
						UserInterfaceSuport.clearComponents(ConversionjPanel1);
						UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
						DescripcionjTextArea.setText("");
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
							ServicioMateriaPrima.insertarMateriaImportadaEURyGastos(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(GastosjTextField.getText()),Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(PrecioconGastosjTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel2);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
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
							ServicioMateriaPrima.insertarMateriaImportadaEURyGastosconGalon(((TipoMateria)getJComboBoxTipoMateria().getSelectedItem()).getId_tipo(), ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate1, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),sqlDate,Float.valueOf(TasaCAmbiojTextField.getText()),Float.valueOf(PrecioConvertidojTextField.getText()),Float.valueOf(GastosjTextField.getText()),Float.valueOf(CantidadFacturadajTextField.getText()),Float.valueOf(PrecioconGastosjTextField.getText()),Float.valueOf(CantConveretidajTextField.getText()));
							JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Producto Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							UserInterfaceSuport.clearComponents(jPanel2);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							DescripcionjTextArea.setText("");
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
						JOptionPane.showMessageDialog(InsertarMateriaPrimaExtranjeraVisual.this, "Los datos marcados con * son obligatorios", "Informacion", JOptionPane.ERROR_MESSAGE);	
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
			SalirjButton.setBounds(new Rectangle(698, 8, 166, 38));
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
			jComboBoxUnidad.setBounds(new Rectangle(944, 35, 136, 26));
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
			jComboBoxMoneda.setBounds(new Rectangle(490, 174, 136, 26));
			jComboBoxMoneda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxMoneda().getSelectedIndex()==2){
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
			jComboBoxTipoMateria.setBounds(new Rectangle(995, 174, 144, 26));
		}
		return jComboBoxTipoMateria;
	}



	/**
	 * This method initializes ListajButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getListajButton() {
		if (ListajButton == null) {
			ListajButton = new JButton();
			ListajButton.setText("Lista de Materias Primas Importadas");
			ListajButton.setBounds(new Rectangle(406, 8, 277, 38));
			ListajButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			ListajButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new ListadodeMateriasPrimasExtranjeras().setVisible(true);
					dispose();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ListajButton;
	}



	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(583, 37, 348, 99));
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
			jPanel1.add(getSalirjButton(), null);
			jPanel1.add(getListajButton(), null);
			jPanel1.add(getRegistrarProductojButton(), null);
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
		}
		return jPanel2;
	}



	
	
	
}  //  @jve:decl-index=0:visual-constraint="185,49"
