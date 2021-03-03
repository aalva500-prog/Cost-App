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

import model.TipoMaterial;
import model.TipoMoneda;
import model.UnidadMedida;
import services.ServicioMaterial;
import services.ServicioMoneda;
import services.ServicioTipoMateria;
import services.ServicioTipoMaterial;
import services.ServicioUnidadMedida;
import Utils.UserInterfaceSuport;
import Utils.Validate;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InsertarMaterialImportadoVisual extends JFrame {


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
	private JComboBox jComboBoxUnidad = null;
	private JComboBox jComboBoxMoneda= null;
	private JButton jButton = null;
	private JScrollPane jScrollPane = null;
	private JPanel moldejPanel1 = null;
	private JLabel CosotjLabel1 = null;
	private JLabel jLabel1 = null;
	private JButton MoldejButton1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField costoMoldeUSDjTextField = null;
	private JTextField CostoDOPMoldejTextField = null;
	private JTextField MoldejTextField = null;
	private JTextField jTextField = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JLabel jLabel4 = null;
	private JComboBox TipoMaterialjComboBox = null;
	public InsertarMaterialImportadoVisual() {
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
		this.setSize(new Dimension(1108, 722));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setTitle("Introducir  Datos de los Materiales Importados");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJPanel());
		
		
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
			gridBagConstraints4.insets = new Insets(2, 5, 10, 5);
			gridBagConstraints4.gridy = 4;
			gridBagConstraints4.ipadx = 1079;
			gridBagConstraints4.ipady = 51;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(4, 5, 3, 5);
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.ipadx = 1079;
			gridBagConstraints3.ipady = 213;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(6, 5, 2, 5);
			gridBagConstraints2.gridy = 3;
			gridBagConstraints2.ipadx = 1079;
			gridBagConstraints2.ipady = 113;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(6, 5, 6, 5);
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.ipadx = 1079;
			gridBagConstraints1.ipady = 121;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(3, 5, 6, 5);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.ipadx = 1079;
			gridBagConstraints.ipady = 124;
			gridBagConstraints.gridx = 0;
			jLabel3 = new JLabel();
			jLabel3.setText("Precio de Adquisición Convertido de EUR a USD con Costos del Molde incluido:");
			jLabel3.setBounds(new Rectangle(437, 78, 449, 26));
			jLabel3.setVisible(false);
			jLabel2 = new JLabel();
			jLabel2.setText("Precio de Adquisición en USD con Costos del Molde incluido:");
			jLabel2.setBounds(new Rectangle(437, 17, 349, 26));
			PrecioenUSDconGAstosjLabel1 = new JLabel();
			PrecioenUSDconGAstosjLabel1.setText("Precio de Adquisición en USD con Gastos de Flete y otros incluido:");
			PrecioenUSDconGAstosjLabel1.setBounds(new Rectangle(501, 28, 388, 26));
			PrecioCOnvertidojLabel1 = new JLabel();
			PrecioCOnvertidojLabel1.setText("Precio de Adquisición Convertido de EUR a USD:");
			PrecioCOnvertidojLabel1.setBounds(new Rectangle(435, 49, 278, 26));
			FechaTasaConversionjLabel1 = new JLabel();
			FechaTasaConversionjLabel1.setText("Fecha Tasa de Cambio de EUR a USD:");
			FechaTasaConversionjLabel1.setBounds(new Rectangle(9, 24, 222, 26));
			PrecioAdquisicionjLabel1 = new JLabel();
			PrecioAdquisicionjLabel1.setText("* Precio de Adquisición:");
			PrecioAdquisicionjLabel1.setBounds(new Rectangle(802, 147, 181, 26));
			ImporteComprajLabel1 = new JLabel();
			ImporteComprajLabel1.setText("* Importe de la Compra:");
			ImporteComprajLabel1.setBounds(new Rectangle(654, 147, 136, 26));
			TipoMonedajLabel1 = new JLabel();
			TipoMonedajLabel1.setText("* Tipo de Moneda:");
			TipoMonedajLabel1.setBounds(new Rectangle(501, 147, 136, 26));
			CantidadConvertidajLabel1 = new JLabel();
			CantidadConvertidajLabel1.setText("Cantidad Comprada Convertida a Galón:");
			CantidadConvertidajLabel1.setBounds(new Rectangle(249, 147, 232, 26));
			CantidadConvertidajLabel1.setVisible(false);
			CantCompradajLabel1 = new JLabel();
			CantCompradajLabel1.setText("* Cantidad Comprada:");
			CantCompradajLabel1.setBounds(new Rectangle(6, 147, 171, 26));
			UnidadMedidajLabel1 = new JLabel();
			UnidadMedidajLabel1.setText("* Unidad de Medida:");
			UnidadMedidajLabel1.setBounds(new Rectangle(940, 8, 136, 26));
			DescripcionjLabel1 = new JLabel();
			DescripcionjLabel1.setText("* Descripción del Producto:");
			DescripcionjLabel1.setBounds(new Rectangle(579, 8, 348, 26));
			FechaFacturajLabel1 = new JLabel();
			FechaFacturajLabel1.setText("* Fecha Factura:");
			FechaFacturajLabel1.setBounds(new Rectangle(430, 8, 136, 26));
			NumeroFacturajLabel1 = new JLabel();
			NumeroFacturajLabel1.setText("* Número de Factura:");
			NumeroFacturajLabel1.setBounds(new Rectangle(280, 8, 136, 26));
			jLabel = new JLabel();
			jLabel.setText("* Nombre del Proveedor:");
			jLabel.setBounds(new Rectangle(7, 8, 251, 26));
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
			NumeropFacturajTextField.setBounds(new Rectangle(280, 32, 136, 26));
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
			CantCompradajTextField.setBounds(new Rectangle(5, 172, 172, 26));
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
			CantConveretidajTextField.setBounds(new Rectangle(249, 172, 136, 26));
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
			ImporteComprajTextField.setBounds(new Rectangle(655, 172, 136, 26));
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
			ConvertiraGalonjButton.setBounds(new Rectangle(190, 147, 46, 44));
			ConvertiraGalonjButton.setVisible(false);
			ConvertiraGalonjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					if(((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getTipo().equals("GALÓN")){
						double lts = Double.valueOf(CantCompradajTextField.getText());
						CantConveretidajTextField.setText(String.valueOf(dosDigitos.format(lts*3.7853)));
					}else{
						JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "La Unidad de Medida debe ser GALÓN", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			PrecioAdquisicionjTextField.setBounds(new Rectangle(802, 171, 181, 26));
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
			DatejSpinner1.setBounds(new Rectangle(430, 32, 136, 26));
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
			PrecioCOnGAstosjLabel1.setBounds(new Rectangle(501, 81, 388, 26));
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
						JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "El Tipo de Moneda debe ser EUR", "Informacion", JOptionPane.ERROR_MESSAGE);
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
			PrecioconGastosjTextField.setBounds(new Rectangle(889, 81, 136, 26));
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
			PrecioenUSDconGAstosjButton.setBounds(new Rectangle(406, 20, 67, 87));
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
								PreciodeAdquisicionconGAstosjTextField.setText(String.valueOf(dosDigitos.format(div + precio)));
								PrecioconGastosjTextField.setText("");
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
							}
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
								double precioAdcon = Double.valueOf(PrecioConvertidojTextField.getText());
								PrecioconGastosjTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
								PreciodeAdquisicionconGAstosjTextField.setText("");
							}
							}else{
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Debe Elegir el Tipo de Moneda", "Error", JOptionPane.ERROR_MESSAGE);
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
			PreciodeAdquisicionconGAstosjTextField.setBounds(new Rectangle(889, 27, 136, 26));
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
			RegistrarProductojButton.setText("Registrar Material");
			RegistrarProductojButton.setBounds(new Rectangle(380, 7, 171, 38));
			RegistrarProductojButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			RegistrarProductojButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!(jComboBoxMoneda.getSelectedIndex()==0)  && !(jComboBoxUnidad.getSelectedIndex()==0) && ProveedorjTextField.getText().length()!=0 && NumeropFacturajTextField.getText().length()!=0 && TipoMaterialjComboBox.getSelectedIndex()!=0
							&& DescripcionjTextArea.getText().length()!=0 && CantCompradajTextField.getText().length()!=0  && ImporteComprajTextField.getText().length()!=0 && PrecioAdquisicionjTextField.getText().length()!=0){
					//Condiciones con USD
						//1
						if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
					if(CantConveretidajTextField.getText().length()==0 && PreciodeAdquisicionconGAstosjTextField.getText().length()==0 && costoMoldeUSDjTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.insertarMaterialImportadoUSD(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							DescripcionjTextArea.setText("");
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
					if( CantConveretidajTextField.getText().length()!=0 &&  PreciodeAdquisicionconGAstosjTextField.getText().length()==0&& costoMoldeUSDjTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialImportadoUSDconGalon(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								DescripcionjTextArea.setText("");
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 &&  CantConveretidajTextField.getText().length()==0 && costoMoldeUSDjTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialImportadoUSDconGAstos(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								DescripcionjTextArea.setText("");
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()==0 &&  CantConveretidajTextField.getText().length()==0 && costoMoldeUSDjTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
						try {
							ServicioMaterial.insertarMaterialImportadoUSDconMolde(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate,  DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(costoMoldeUSDjTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
							UserInterfaceSuport.clearComponents(moldejPanel1);
							DescripcionjTextArea.setText("");
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 &&  CantConveretidajTextField.getText().length()!=0 && costoMoldeUSDjTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialImportadaUSDconGAstosyGalon(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								DescripcionjTextArea.setText("");
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()==0 && CantConveretidajTextField.getText().length()!=0 && costoMoldeUSDjTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialImportadaUSDconMoldeyGalon(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(costoMoldeUSDjTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								UserInterfaceSuport.clearComponents(moldejPanel1);
								DescripcionjTextArea.setText("");
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
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 &&  CantConveretidajTextField.getText().length()==0 && costoMoldeUSDjTextField.getText().length()!=0 ){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialImportadaUSDconMoldeyGastos(ProveedorjTextField.getText(),  NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField.getText()),  Float.valueOf(costoMoldeUSDjTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								UserInterfaceSuport.clearComponents(moldejPanel1);
								DescripcionjTextArea.setText("");
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
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
					
					//8
					if(PreciodeAdquisicionconGAstosjTextField.getText().length()!=0 && CantConveretidajTextField.getText().length()!=0 && costoMoldeUSDjTextField.getText().length()!=0 ){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialImportadaUSDconMoldeyGastosGalon(ProveedorjTextField.getText(),  NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(),  Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(costoMoldeUSDjTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(PreciodeAdquisicionconGAstosjTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								UserInterfaceSuport.clearComponents(moldejPanel1);	
								DescripcionjTextArea.setText("");
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
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}						
						}else{
							if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
					//Condiciones con EUR
					//1
					if( CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.insertarMaterialImportadoEUR(ProveedorjTextField.getText(),  NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()),  Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioConvertidojTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							DescripcionjTextArea.setText("");
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
					if(CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.insertarMaterialImportadaEURyGalon(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioConvertidojTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							DescripcionjTextArea.setText("");
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
					if(CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialEURyGastos(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1,  Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioConvertidojTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								DescripcionjTextArea.setText("");
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
					if( CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()==0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialImportadoEURyGastosconGalon(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioConvertidojTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(CantidadFacturadajTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								DescripcionjTextArea.setText("");
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
					if( CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.insertarMaterialImportadoEURconMolde(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioConvertidojTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(CostoDOPMoldejTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(moldejPanel1);
							DescripcionjTextArea.setText("");
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
					if( CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()==0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						try {
							ServicioMaterial.insertarMaterialImportadoEURconMoldeyGalon(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()), Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()),  Float.valueOf(PrecioConvertidojTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(CostoDOPMoldejTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
							UserInterfaceSuport.clearComponents(jPanel1);
							UserInterfaceSuport.clearComponents(ConversionjPanel1);
							UserInterfaceSuport.clearComponents(moldejPanel1);
							DescripcionjTextArea.setText("");
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
					if( CantConveretidajTextField.getText().length()==0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialEURyGastosconMolde(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(),  ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteComprajTextField.getText()),  Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1,  Float.valueOf(TasaCAmbiojTextField.getText()),  Float.valueOf(PrecioConvertidojTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(CostoDOPMoldejTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
								UserInterfaceSuport.clearComponents(moldejPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								DescripcionjTextArea.setText("");
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
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
							}
					//8
					if( CantConveretidajTextField.getText().length()!=0 && PrecioconGastosjTextField.getText().length()!=0 && PrecioConvertidojTextField.getText().length()!=0 && CostoDOPMoldejTextField.getText().length()!=0){
						if(CantidadFacturadajTextField.getText().equals(jTextField.getText())){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						try {
							try {
								ServicioMaterial.insertarMaterialEURCompleto(ProveedorjTextField.getText(), NumeropFacturajTextField.getText(), sqlDate, DescripcionjTextArea.getText(), ((UnidadMedida)getJComboBoxUnidad().getSelectedItem()).getId_unidad(), Float.valueOf(CantCompradajTextField.getText()), ((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getId_tipomoneda(),  Float.valueOf(ImporteComprajTextField.getText()),  Float.valueOf(PrecioAdquisicionjTextField.getText()), sqlDate1,  Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(PrecioConvertidojTextField.getText()), Float.valueOf(GastosjTextField.getText()), Float.valueOf(PrecioconGastosjTextField.getText()), Float.valueOf(jTextField.getText()), Float.valueOf(MoldejTextField.getText()), Float.valueOf(CostoDOPMoldejTextField.getText()), Float.valueOf(CantConveretidajTextField.getText()),((TipoMaterial)getTipoMaterialjComboBox().getSelectedItem()).getId_tipomaterial());
								JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Material Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);	
								UserInterfaceSuport.clearComponents(jPanel1);
								UserInterfaceSuport.clearComponents(ConversionjPanel1);
								UserInterfaceSuport.clearComponents(moldejPanel1);
								UserInterfaceSuport.clearComponents(GastosdeFletejPanel1);
								DescripcionjTextArea.setText("");
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
							JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "La Cantidad Total Facturada debe ser la misma en los Costos del Molde y en los Gastos de Flete y otros", "Error", JOptionPane.ERROR_MESSAGE);	
						}
							}
				//////////////////////
					}
						}
					}
					else{
						JOptionPane.showMessageDialog(InsertarMaterialImportadoVisual.this, "Los datos marcados con * son obligatorios", "Informacion", JOptionPane.ERROR_MESSAGE);	
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
			SalirjButton.setBounds(new Rectangle(843, 7, 165, 38));
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
			jComboBoxUnidad.setBounds(new Rectangle(940, 32, 136, 26));
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
			jComboBoxMoneda.setBounds(new Rectangle(501, 173, 136, 26));
			jComboBoxMoneda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBoxMoneda().getSelectedIndex()==2){
						ConversionjPanel1.setVisible(true);
						PrecioCOnGAstosjLabel1.setVisible(true);
						PrecioconGastosjTextField.setVisible(true);
						jLabel3.setVisible(true);
						CostoDOPMoldejTextField.setVisible(true);
						jLabel2.setVisible(false);
						costoMoldeUSDjTextField.setVisible(false);
						costoMoldeUSDjTextField.setText("");
						PrecioenUSDconGAstosjLabel1.setVisible(false);
						PreciodeAdquisicionconGAstosjTextField.setVisible(false);
						PreciodeAdquisicionconGAstosjTextField.setText("");
						}else{					
							ConversionjPanel1.setVisible(false);
							PrecioCOnGAstosjLabel1.setVisible(false);
							PrecioconGastosjTextField.setVisible(false);
							PrecioconGastosjTextField.setText("");
							jLabel3.setVisible(false);
							CostoDOPMoldejTextField.setVisible(false);
							CostoDOPMoldejTextField.setText("");
							jLabel2.setVisible(true);
							costoMoldeUSDjTextField.setVisible(true);
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
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Listado de Materiales Importados");
			jButton.setBounds(new Rectangle(572, 7, 256, 38));
		    jButton.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
		    jButton.addActionListener(new java.awt.event.ActionListener() {
		    	public void actionPerformed(java.awt.event.ActionEvent e) {
		    		dispose();
		    		new ListadodeMaterialesImportados().setVisible(true);
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
			jScrollPane.setBounds(new Rectangle(579, 34, 348, 101));
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
			CosotjLabel1.setText("Costo del Molde:");
			moldejPanel1 = new JPanel();
			moldejPanel1.setLayout(null);
			moldejPanel1.setBackground(new Color(190,190,190));
			moldejPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos de Costos del Molde", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			moldejPanel1.add(CosotjLabel1, null);
			moldejPanel1.add(jLabel1, null);
			moldejPanel1.add(getMoldejTextField(), null);
			moldejPanel1.add(getJTextField(), null);
			moldejPanel1.add(getCostoMoldeUSDjTextField(), null);
			moldejPanel1.add(getCostoDOPMoldejTextField(), null);
			moldejPanel1.add(jLabel3, null);
			moldejPanel1.add(getMoldejButton1(), null);
			moldejPanel1.add(jLabel2, null);
		}
		return moldejPanel1;
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
			MoldejButton1.setBounds(new Rectangle(342, 17, 67, 87));
			MoldejButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					double costomolde = Double.valueOf(MoldejTextField.getText());
					double cant = Double.valueOf(jTextField.getText());
					double div = costomolde/cant;
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("USD")){
						double precio = Double.valueOf(PrecioAdquisicionjTextField.getText());
						costoMoldeUSDjTextField.setText(String.valueOf(dosDigitos.format(div + precio)));
						CostoDOPMoldejTextField.setText("");
						UserInterfaceSuport.clearComponents(ConversionjPanel1);
					}
					if(((TipoMoneda)getJComboBoxMoneda().getSelectedItem()).getDescripcion().equals("EUR")){
						double precioAdcon = Double.valueOf(PrecioConvertidojTextField.getText());
						CostoDOPMoldejTextField.setText(String.valueOf(dosDigitos.format(div+precioAdcon)));
						costoMoldeUSDjTextField.setText("");
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MoldejButton1;
	}



	/**
	 * This method initializes costoMoldeUSDjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoMoldeUSDjTextField() {
		if (costoMoldeUSDjTextField == null) {
			costoMoldeUSDjTextField = new JTextField();
			costoMoldeUSDjTextField.setBounds(new Rectangle(784, 17, 136, 26));
			}
		return costoMoldeUSDjTextField;
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
			CostoDOPMoldejTextField.setBounds(new Rectangle(886, 78, 136, 26));
		}
		return CostoDOPMoldejTextField;
	}



	/**
	 * This method initializes MoldejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMoldejTextField() {
		if (MoldejTextField == null) {
			MoldejTextField = new JTextField();
			MoldejTextField.setBounds(new Rectangle(162, 29, 139, 24));
			Validate.validateDigitAndComma(MoldejTextField);
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
			jTextField.setBounds(new Rectangle(162, 67, 139, 24));
			Validate.validateDigitAndComma(jTextField);
		}
		return jTextField;
	}



	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(7, 75, 253, 26));
			jLabel4.setText("*Tipo de Material:");
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
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
			jPanel1.add(jLabel4, null);
			jPanel1.add(getTipoMaterialjComboBox(), null);
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
		}
		return jPanel2;
	}



	/**
	 * This method initializes TipoMaterialjComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTipoMaterialjComboBox() {
		if (TipoMaterialjComboBox == null) {
			TipoMaterialjComboBox = new JComboBox();
			TipoMaterialjComboBox.setBounds(new Rectangle(7, 101, 253, 26));
		}
		return TipoMaterialjComboBox;
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="258,51"
