package visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import model.Aduana;
import model.Desaduanizacion;
import model.MateriaPrima;
import model.Tipo;
import model.TipoMoneda;
import model.TransportacionTerrestre;
import model.TransportaciónAerea;
import net.sf.jasperreports.engine.JRException;
import services.ServicioAduana;
import services.ServicioDesaduanizacion;
import services.ServicioMateriaPrima;
import services.ServicioMoneda;
import services.ServicioTerrestre;
import services.ServicioTipo;
import services.ServicioTransportacionAerea;
import Utils.Reportes;
import Utils.UserInterfaceSuport;
import Utils.Validate;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GestionarMateriaPrimaExtranjeraVisual extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton CostoUnitarioTotaljButton = null;
	private JTextField CostoUnitarioTotaljTextField = null;
	private JPanel GastosdeLogisticajPanel1 = null;
	private JRadioButton SijRadioButton = null;
	private JRadioButton NojRadioButton = null;
	private JButton logisticajButton = null;
	private JLabel logisticajLabel1 = null;
	private JTextField LogisticajTextField = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private MateriaPrima mp=null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextArea jTextArea = null;
	private JPanel jPanel5 = null;
	private JPanel jPanel6 = null;
	private JComboBox jComboBox = null;
	private JLabel TipoTransportacionjLabel = null;
	private JLabel NOmbreProveedorjLabel = null;
	private JTextField NombreProveedorjTextField = null;
	private JLabel NumeroFacturajLabel = null;
	private JTextField NumeroFacturajTextField = null;
	private JLabel FechaFacturajLabel = null;
	private JSpinner DatejSpinner = null;
	private SpinnerDateModel DatespinnerDateModel = null;
	private JLabel CantidadTransportadajLabel = null;
	private JTextField CantidadTransportadajTextField = null;
	private JLabel MonedajLabel = null;
	private JComboBox MonedajComboBox1 = null;
	private JLabel ImporteFacturajLabel = null;
	private JTextField ImporteFacturajTextField = null;
	private JLabel FechaConversionjLabel = null;
	private JLabel TasaConversionjLabel = null;
	private JLabel ImporteConvertidojLabel = null;
	private JTextField TasaConversionjTextField = null;
	private JTextField ImporteConvertidojTextField = null;
	private JButton jButton = null;
	private JButton CostojButton1 = null;
	private JLabel CostojLabel = null;
	private JTextField CostojTextField = null;
	private JButton InsertarjButton1 = null;
	private JButton RegresarjButton1 = null;
	private JSpinner DatejSpinner1 = null;
	private SpinnerDateModel DatespinnerDateModel1 = null;  //  @jve:decl-index=0:
	private JPanel jPanel7 = null;
	private JTextArea jTextArea1 = null;
	private JLabel jLabel = null;
	private JLabel jLabel3 = null;
	private JPanel jPanel8 = null;
	private JLabel jLabel4 = null;
	private JLabel NombreProveedorjLabel5 = null;
	private JTextField NombreProveedorDesjTextField1 = null;
	private JLabel jLabel5 = null;
	private JTextField NUmeroFacturaDesjTextField1 = null;
	private JLabel FechaFacturaDesjLabel6 = null;
	private JSpinner DatejSpinner2 = null;
	private SpinnerDateModel DatespinnerDateModel2 = null;  //  @jve:decl-index=0:
	private JLabel jLabel6 = null;
	private JComboBox MonedaDesjComboBox1 = null;
	private JLabel ImportejLabel7 = null;
	private JTextField ImportejTextField1 = null;
	private JLabel CantijLabel7 = null;
	private JTextField CantidadTransportadaDesjTextField1 = null;
	private JLabel jLabel7 = null;
	private JTextField TasaCambioDesjTextField1 = null;
	private JLabel jLabel8 = null;
	private JSpinner DatejSpinner3 = null;
	private SpinnerDateModel DatespinnerDateModel3 = null;  //  @jve:decl-index=0:
	private JButton jButton1 = null;
	private JLabel jLabel9 = null;
	private JTextField ImprteConvertidoDesjTextField1 = null;
	private JButton jButton2 = null;
	private JLabel jLabel10 = null;
	private JTextField CostoDesjTextField1 = null;
	private JButton RegistrarDesaduanizacionjButton3 = null;
	private JButton jButton3 = null;
	private JComboBox TipoDesjComboBox1 = null;
	private JPanel jPanel9 = null;
	private JPanel jPanel10 = null;
	private JLabel jLabel11 = null;
	private JTextField NombreProveedorTerrestrejTextField = null;
	private JLabel jLabel12 = null;
	private JTextField NumeroFacturaTerrestrejTextField = null;
	private JLabel jLabel13 = null;
	private JSpinner DatejSpinner4 = null;
	private SpinnerDateModel DatespinnerDateModel4 = null;  //  @jve:decl-index=0:
	private JLabel jLabel14 = null;
	private JComboBox MonedaTerrestrejComboBox1 = null;
	private JLabel jLabel15 = null;
	private JTextField ImporteTerrestrejTextField = null;
	private JLabel jLabel16 = null;
	private JTextField CAntidadTransportadajTextField = null;
	private JLabel jLabel17 = null;
	private JTextField TasaCAmbiojTextField = null;
	private JLabel jLabel18 = null;
	private JSpinner DatejSpinner6 = null;
	private SpinnerDateModel DatespinnerDateModel6 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JLabel jLabel19 = null;
	private JLabel CostojLabel20 = null;
	private JTextField ImportejTextField = null;
	private JTextField CostoTerrestrejTextField = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;
	private JTextArea jTextArea2 = null;
	private JLabel jLabel20 = null;
	private JLabel jLabel21 = null;
	private JPanel jPanel11 = null;
	private JPanel jPanel12 = null;
	private JLabel jLabel22 = null;
	private JLabel jLabel23 = null;
	private JLabel jLabel24 = null;
	private JTextField ImporteDOPjTextField = null;
	private JLabel jLabel25 = null;
	private JLabel jLabel26 = null;
	private JTextField TasaCAmbioADuanajTextField = null;
	private JLabel jLabel27 = null;
	private JLabel jLabel28 = null;
	private JButton jButton8 = null;
	private JButton jButton9 = null;
	private JButton RegitsrajButton10 = null;
	private JButton jButton10 = null;
	private JTextField ImporteAduanajTextField = null;
	private JTextField CostoAduanajTextField = null;
	private JSpinner DatejSpinner7 = null;
	private SpinnerDateModel DatespinnerDateModel7 = null;  //  @jve:decl-index=0:
	private JTextArea jTextArea3 = null;
	private JLabel jLabel29 = null;
	private JTextField CantidadTransportadaAduanajTextField = null;
	private JButton jButton11 = null;
	private JButton jButton12 = null;
	private JButton jButton13 = null;
	private JButton jButton14 = null;
	private JLabel jLabel30 = null;
	private JTextField PrecioAdquisicionUSDjTextField = null;
	private JLabel jLabel31 = null;
	private JTextField PrecioConvertidoDOPaUSDjTextField = null;
	private JLabel jLabel32 = null;
	private JTextField CostoTransportacionAereajTextField = null;
	private JLabel jLabel33 = null;
	private JTextField CsotoUnitarioDesadunaizacionjTextField = null;
	private JLabel jLabel34 = null;
	private JTextField CostoUnitariodelTarnasportacionTerrestrejTextField = null;
	private JLabel jLabel35 = null;
	private JTextField CostoUnitarioAdunajTextField = null;
	private JButton jButton15 = null;
	private JButton jButton16 = null;
	private JButton jButton17 = null;
	private JButton jButton18 = null;
	private JButton jButton19 = null;
	private JButton jButton20 = null;
	private JButton jButton21 = null;
	private JButton jButton22 = null;
	private JButton jButton23 = null;
	private JButton ImprimirjButton24 = null;
	private JButton jButton24 = null;
	private JPanel jPanel13 = null;
	private JPanel jPanel14 = null;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JScrollPane jScrollPane2 = null;
	private JScrollPane jScrollPane3 = null;
	private JButton jButton25 = null;
	private JPanel jPanel15 = null;
	private JPanel jPanel16 = null;
	
	public GestionarMateriaPrimaExtranjeraVisual(MateriaPrima mp) {
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
		this.setSize(new Dimension(1294, 519));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setContentPane(getJTabbedPane());
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Gestionar Datos de Transportación y Costo Unitario Total");		
		logisticajLabel1.setVisible(false);
		LogisticajTextField.setVisible(false);
		logisticajButton.setVisible(false);
		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	    simbolo.setDecimalSeparator('.');
		DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
		TransportaciónAerea ta = ServicioTransportacionAerea.getTransportacionMateria(mp.getId_Materia());
		
		if(ta.getNombreproveedor()!=null   || ta.getNumerofactura()!=null || ta.getFechfactura()!=null || ta.getFechaConversionEURaUSD()!=null){
		NombreProveedorjTextField.setText(ta.getNombreproveedor());
		NumeroFacturajTextField.setText(ta.getNumerofactura());
		DatejSpinner.setValue(ta.getFechfactura());
		CantidadTransportadajTextField.setText(String.valueOf(dosDigitos.format(ta.getCantidadtransportada())));
		CantidadTransportadaDesjTextField1.setText(String.valueOf(dosDigitos.format(ta.getCantidadtransportada())));
		CAntidadTransportadajTextField.setText(String.valueOf(dosDigitos.format(ta.getCantidadtransportada())));
		CantidadTransportadaAduanajTextField.setText(String.valueOf(dosDigitos.format(ta.getCantidadtransportada())));
		ImporteFacturajTextField.setText(String.valueOf(dosDigitos.format(ta.getImportefactura())));
		jButton18.setEnabled(true);
		InsertarjButton1.setEnabled(false);
		if(ta.getTasaconversion()!=0){
		TasaConversionjTextField.setText(String.valueOf(dosDigitos.format(ta.getTasaconversion())));	
		}else{
			TasaConversionjTextField.setText("");
		}
		if(ta.getImportefacturaconvertidoEURaUSD()!=0){
		ImporteConvertidojTextField.setText(String.valueOf(dosDigitos.format(ta.getImportefacturaconvertidoEURaUSD())));	
		}else{
			ImporteConvertidojTextField.setText("");
		}
		CostojTextField.setText(String.valueOf(dosDigitos.format(ta.getCostounitario())));
		if(ta.getFechaConversionEURaUSD()!=null){
		DatejSpinner1.setValue(ta.getFechaConversionEURaUSD());
		}else{
			DatejSpinner1.setValue(ta.getFechfactura());
		}
		}else{
			NombreProveedorjTextField.setText("");
			NumeroFacturajTextField.setText("");	
			CantidadTransportadajTextField.setText("");
			CantidadTransportadaDesjTextField1.setText("");
			CAntidadTransportadajTextField.setText("");
			CantidadTransportadaAduanajTextField.setText("");
			ImporteFacturajTextField.setText("");
			CostojTextField.setText("");
			jButton18.setEnabled(false);
			InsertarjButton1.setEnabled(true);
		}
		
		Desaduanizacion des=ServicioDesaduanizacion.getDesaduanizacion(mp.getId_Materia());
		if(des.getNombreproveedor()!=null|| des.getNumerofactura()!=null|| des.getFechafactura()!=null ||des.getFechatasacambio()!=null){
			NombreProveedorDesjTextField1.setText(des.getNombreproveedor());
			NUmeroFacturaDesjTextField1.setText(des.getNumerofactura());
			DatejSpinner2.setValue(des.getFechafactura());
			ImportejTextField1.setText(String.valueOf(dosDigitos.format(des.getImportefactura())));
			jButton19.setEnabled(true);
			RegistrarDesaduanizacionjButton3.setEnabled(false);
			CostoDesjTextField1.setText(String.valueOf(dosDigitos.format(des.getCostounitario())));
			if(des.getImportefacturaconvertido()!=0){
				ImprteConvertidoDesjTextField1.setText(String.valueOf(dosDigitos.format(des.getImportefacturaconvertido())));
			}else{
				ImprteConvertidoDesjTextField1.setText("");
			}
			
			if(des.getTasacambio()!=0){
				TasaCambioDesjTextField1.setText(String.valueOf(dosDigitos.format(des.getTasacambio())));
			}else{
				TasaCambioDesjTextField1.setText("");
			}
			
			
			if(des.getFechatasacambio()!=null){
				DatejSpinner3.setValue(des.getFechatasacambio());
			}
		}else{
			NombreProveedorDesjTextField1.setText("");
			NUmeroFacturaDesjTextField1.setText("");
			ImportejTextField1.setText("");
			CostoDesjTextField1.setText("");
			jButton19.setEnabled(false);
			RegistrarDesaduanizacionjButton3.setEnabled(true);
		}
		
		TransportacionTerrestre terrestre = ServicioTerrestre.getTransportacionTerrestreMateria(mp.getId_Materia());
		if(terrestre.getNombreproveedor()!=null|| terrestre.getNumerofactura()!=null|| terrestre.getFechafactura()!=null ||terrestre.getFechatasaCAmbio()!=null){
			NombreProveedorTerrestrejTextField.setText(terrestre.getNombreproveedor());
			NumeroFacturaTerrestrejTextField.setText(terrestre.getNumerofactura());
			DatejSpinner4.setValue(terrestre.getFechafactura());
			ImporteTerrestrejTextField.setText(String.valueOf(dosDigitos.format(terrestre.getImprtefactura())));
			jButton20.setEnabled(true);
			jButton6.setEnabled(false);
			
			if(terrestre.getImporteconvertido()!=0){
				ImportejTextField.setText(String.valueOf(dosDigitos.format(terrestre.getImporteconvertido())));
			}else{
				ImportejTextField.setText("");
			}
			
			if(terrestre.getTasaCAmbio()!=0){
				TasaCAmbiojTextField.setText(String.valueOf(dosDigitos.format(terrestre.getTasaCAmbio())));
			}else{
				TasaCAmbiojTextField.setText("");
			}
			
			CostoTerrestrejTextField.setText(String.valueOf(dosDigitos.format(terrestre.getCostounitario())));
			if(terrestre.getFechatasaCAmbio()!=null){
				DatejSpinner6.setValue(terrestre.getFechatasaCAmbio());
			}
		}else{
			NombreProveedorTerrestrejTextField.setText("");
			NumeroFacturaTerrestrejTextField.setText("");
			ImporteTerrestrejTextField.setText("");
			CostoDesjTextField1.setText("");
			jButton20.setEnabled(false);
			jButton6.setEnabled(true);
			
		}
		
		Aduana adu=ServicioAduana.getAduanaMateriaPrima(mp.getId_Materia());
		if(adu.getFecha()!=null){
			CostoAduanajTextField.setText(String.valueOf(dosDigitos.format(adu.getCostounitario())));
			ImporteAduanajTextField.setText(String.valueOf(dosDigitos.format(adu.getImporteconvertido())));
			ImporteDOPjTextField.setText(String.valueOf(dosDigitos.format(adu.getImprteDOP())));
			TasaCAmbioADuanajTextField.setText(String.valueOf(dosDigitos.format(adu.getTasacambio())));	
			jButton21.setEnabled(true);
			RegitsrajButton10.setEnabled(false);
			DatejSpinner7.setValue(adu.getFecha());
			}else{
				CostoAduanajTextField.setText("");			
				ImporteAduanajTextField.setText("");
				ImporteDOPjTextField.setText("");
				TasaCAmbioADuanajTextField.setText("");
				jButton21.setEnabled(false);
				RegitsrajButton10.setEnabled(true);
								}
		
		 //Combobox Tipo Transportacion
		LinkedList<Tipo> list1 = new LinkedList<Tipo>();
		try {
			list1= ServicioTipo.getUnidades();
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
		
		getJComboBox().setModel(boxModel1);
		
		 //Combobox Tipo Desaduanizacion
		LinkedList<Tipo> list3 = new LinkedList<Tipo>();
		try {
			list3= ServicioTipo.getUnidades();
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
		
		getTipoDesjComboBox1().setModel(boxModel3);
		
		 //Combobox Tipo Moneda
		LinkedList<TipoMoneda> list = new LinkedList<TipoMoneda>();
		try {
			list= ServicioMoneda.getMonedasInternacionales();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		boxModel.addElement(new String("<Seleccione>"));
		for (int i = 0; i < list.size(); i++) {
			boxModel.addElement(list.get(i));
		}
		
		getMonedajComboBox1().setModel(boxModel);
		
		 //Combobox Tipo Moneda
		LinkedList<TipoMoneda> list5 = new LinkedList<TipoMoneda>();
		try {
			list5= ServicioMoneda.getUnidades();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultComboBoxModel boxModel5 = new DefaultComboBoxModel();
		boxModel5.addElement(new String("<Seleccione>"));
		for (int i = 0; i < list5.size(); i++) {
			boxModel5.addElement(list5.get(i));
		}
		
		getMonedaTerrestrejComboBox1().setModel(boxModel5);
		
		 //Combobox Tipo Moneda
		LinkedList<TipoMoneda> list2 = new LinkedList<TipoMoneda>();
		try {
			list2= ServicioMoneda.getUnidades();
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
		
		getMonedaDesjComboBox1().setModel(boxModel2);
		
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - getWidth()) / 2,((screenSize.height - getHeight()) / 2));
		
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
			CostoUnitarioTotaljButton.setBounds(new Rectangle(347, 280, 183, 26));
			CostoUnitarioTotaljButton.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
							float adquisicion=Float.valueOf(PrecioAdquisicionUSDjTextField.getText());
							float gastos=Float.valueOf(PrecioConvertidoDOPaUSDjTextField.getText());
							float transportacionAerea=Float.valueOf(CostoTransportacionAereajTextField.getText());
							float desaduanizacion=Float.valueOf(CsotoUnitarioDesadunaizacionjTextField.getText());
							float terrestre=Float.valueOf(CostoUnitariodelTarnasportacionTerrestrejTextField.getText());
							float zonafranca= Float.valueOf(CostoUnitarioAdunajTextField.getText());
							float suma=0;
							if(gastos!=0){
								suma=gastos+transportacionAerea+desaduanizacion+terrestre+zonafranca;
								CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(suma)));
							}else{
								suma=adquisicion+transportacionAerea+desaduanizacion+terrestre+zonafranca;
								CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(suma)));
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
			CostoUnitarioTotaljTextField.setBounds(new Rectangle(528, 280, 183, 26));
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getCostounitario()!=0){
			CostoUnitarioTotaljTextField.setText(String.valueOf(dosDigitos.format(mp.getCostounitario())));
			}else{
				CostoUnitarioTotaljTextField.setText("");
			}
		}
		return CostoUnitarioTotaljTextField;
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
			LogisticajTextField.setEditable(false);
			}
		return LogisticajTextField;
	}



	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Transportación Aérea o Marítima", null, getJPanel(), null);
			jTabbedPane.addTab("Desaduanización", null, getJPanel1(), null);
			jTabbedPane.addTab("Transportación Terrestre", null, getJPanel2(), null);
			jTabbedPane.addTab("Aduana de la Zona Franca", null, getJPanel3(), null);
			jTabbedPane.addTab("Costo Unitario Total", null, getJPanel4(), null);
		}
		return jTabbedPane;
	}



	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(16, 14, 0, 0);
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.ipadx = 1256;
			gridBagConstraints1.ipady = 262;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(7, 14, 16, 147);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 1109;
			gridBagConstraints.ipady = 146;
			gridBagConstraints.gridx = 0;
			jLabel2 = new JLabel();
			jLabel2.setText("No. Factura:  " + mp.getNumerofactura());
			jLabel2.setBounds(new Rectangle(14, 67, 291, 29));
			jLabel1 = new JLabel();
			jLabel1.setText("Proveedor:  " + mp.getNombreproveedor());
			jLabel1.setBounds(new Rectangle(14, 33, 291, 29));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJPanel5(), gridBagConstraints);
			jPanel.add(getJPanel6(), gridBagConstraints1);
		}
		return jPanel;
	}



	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(10, 11, 12, 20);
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.ipadx = 1239;
			gridBagConstraints3.ipady = 262;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(8, 11, 9, 206);
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 1053;
			gridBagConstraints2.ipady = 141;
			gridBagConstraints2.gridx = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(getJPanel7(), gridBagConstraints2);
			jPanel1.add(getJPanel8(), gridBagConstraints3);
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
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.insets = new Insets(10, 11, 12, 20);
			gridBagConstraints5.gridy = 1;
			gridBagConstraints5.ipadx = 1239;
			gridBagConstraints5.ipady = 262;
			gridBagConstraints5.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.insets = new Insets(8, 11, 9, 206);
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.ipadx = 1053;
			gridBagConstraints4.ipady = 141;
			gridBagConstraints4.gridx = 0;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getJPanel9(), gridBagConstraints4);
			jPanel2.add(getJPanel10(), gridBagConstraints5);
		}
		return jPanel2;
	}



	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.insets = new Insets(10, 11, 12, 20);
			gridBagConstraints7.gridy = 1;
			gridBagConstraints7.ipadx = 1239;
			gridBagConstraints7.ipady = 262;
			gridBagConstraints7.gridx = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.insets = new Insets(8, 11, 9, 206);
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.ipadx = 1053;
			gridBagConstraints6.ipady = 141;
			gridBagConstraints6.gridx = 0;
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
			jPanel3.add(getJPanel11(), gridBagConstraints6);
			jPanel3.add(getJPanel12(), gridBagConstraints7);
		}
		return jPanel3;
	}



	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.insets = new Insets(8, 52, 1, 18);
			gridBagConstraints10.gridy = 0;
			gridBagConstraints10.ipadx = 760;
			gridBagConstraints10.ipady = 312;
			gridBagConstraints10.gridx = 0;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.insets = new Insets(13, 18, 86, 86);
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.ipadx = 335;
			gridBagConstraints9.ipady = 222;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.insets = new Insets(2, 119, 44, 97);
			gridBagConstraints8.gridy = 1;
			gridBagConstraints8.ipadx = 614;
			gridBagConstraints8.ipady = 75;
			gridBagConstraints8.gridx = 0;
			jLabel35 = new JLabel();
			jLabel35.setText("Costo Unitario de los Gastos en Aduana de la Zona Franca:");
			jLabel35.setBounds(new Rectangle(198, 233, 332, 26));
			jLabel34 = new JLabel();
			jLabel34.setText("Costo Unitario de la Transportación Terrestre:");
			jLabel34.setBounds(new Rectangle(269, 191, 261, 26));
			jLabel33 = new JLabel();
			jLabel33.setText("Costo Unitario de la Desaduanización:");
			jLabel33.setBounds(new Rectangle(315, 142, 215, 26));
			jLabel32 = new JLabel();
			jLabel32.setText("Costo Unitario de la Transportación Aérea o Marítima:");
			jLabel32.setBounds(new Rectangle(224, 100, 306, 26));
			jLabel31 = new JLabel();
			if(mp.getTipomoneda().equals("USD")){			
			jLabel31.setText("Precio de Adquisición en USD con Gastos de Flete y otros incluido:");
			jLabel31.setBounds(new Rectangle(154, 53, 374, 26));
		    }else{
		    	jLabel31.setText("Precio de Adquisición Convertido de EUR a USD con Gastos de Flete y otros incluido:");
		    	jLabel31.setBounds(new Rectangle(52, 55, 478, 26));
		    }
			jLabel30 = new JLabel();					
			if(mp.getTipomoneda().equals("USD")){
			jLabel30.setText("Precio de Adquisición en USD:");	
			jLabel30.setBounds(new Rectangle(355, 9, 173, 26));
			}else{
				jLabel30.setText("Precio de Adquisición Convertido de EUR a USD:");	
				jLabel30.setBounds(new Rectangle(254, 15, 274, 26));
			}
			jPanel4 = new JPanel();
			jPanel4.setLayout(new GridBagLayout());
			jPanel4.add(getGastosdeLogisticajPanel1(), gridBagConstraints8);
			jPanel4.add(getJPanel15(), gridBagConstraints9);
			jPanel4.add(getJPanel16(), gridBagConstraints10);
		}
		return jPanel4;
	}



	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setText("Descripción:  "+mp.getDescripcion()); 
			jTextArea.setEditable(false);
		}
		return jTextArea;
	}



	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(null);
			jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Datos de la Materia Prima", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel5.add(jLabel1, null);
			jPanel5.add(jLabel2, null);
			jPanel5.add(getJScrollPane(), null);
			
			JLabel lblTipoMateriaPrima = new JLabel("Tipo Materia Prima:  " + mp.getTipomateriaprima());
			lblTipoMateriaPrima.setBounds(14, 111, 291, 29);
			jPanel5.add(lblTipoMateriaPrima);
		}
		return jPanel5;
	}



	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			CostojLabel = new JLabel();
			CostojLabel.setText("*Costo Unitario de la Transportación:");
			CostojLabel.setBounds(new Rectangle(503, 145, 218, 25));
			ImporteConvertidojLabel = new JLabel();
			ImporteConvertidojLabel.setText("Importe de la Factura Convertido de EUR a USD:");
			ImporteConvertidojLabel.setBounds(new Rectangle(503, 109, 272, 25));
			TasaConversionjLabel = new JLabel();
			TasaConversionjLabel.setText("Tasa Conversión de EUR a USD:");
			TasaConversionjLabel.setBounds(new Rectangle(4, 111, 197, 23));
			FechaConversionjLabel = new JLabel();
			FechaConversionjLabel.setText("Fecha de la Tasa Conversión de EUR a USD:");
			FechaConversionjLabel.setBounds(new Rectangle(4, 148, 260, 23));
			ImporteFacturajLabel = new JLabel();
			ImporteFacturajLabel.setText("*Importe de la Factura:");
			ImporteFacturajLabel.setBounds(new Rectangle(1104, 25, 139, 23));
			MonedajLabel = new JLabel();
			MonedajLabel.setText("*Tipo de Moneda:");
			MonedajLabel.setBounds(new Rectangle(951, 25, 129, 23));
			CantidadTransportadajLabel = new JLabel();
			CantidadTransportadajLabel.setText("*Cantidad Transportada:");
			CantidadTransportadajLabel.setBounds(new Rectangle(778, 25, 149, 23));
			FechaFacturajLabel = new JLabel();
			FechaFacturajLabel.setText("Fecha Factura:");
			FechaFacturajLabel.setBounds(new Rectangle(602, 25, 142, 23));
			NumeroFacturajLabel = new JLabel();
			NumeroFacturajLabel.setText("*Número de la Factura:");
			NumeroFacturajLabel.setBounds(new Rectangle(442, 25, 136, 23));
			NOmbreProveedorjLabel = new JLabel();
			NOmbreProveedorjLabel.setText("*Nombre del Proveedor:");
			NOmbreProveedorjLabel.setBounds(new Rectangle(198, 25, 211, 23));
			TipoTransportacionjLabel = new JLabel();
			TipoTransportacionjLabel.setText("*Tipo de Transportación:");
			TipoTransportacionjLabel.setBounds(new Rectangle(4, 25, 166, 23));
			jPanel6 = new JPanel();
			jPanel6.setLayout(null);
			jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Datos de la Transportación", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel6.add(getJComboBox(), null);
			jPanel6.add(TipoTransportacionjLabel, null);
			jPanel6.add(NOmbreProveedorjLabel, null);
			jPanel6.add(getNombreProveedorjTextField(), null);
			jPanel6.add(NumeroFacturajLabel, null);
			jPanel6.add(getNumeroFacturajTextField(), null);
			jPanel6.add(FechaFacturajLabel, null);
			jPanel6.add(getDatejSpinner(), null);
			jPanel6.add(CantidadTransportadajLabel, null);
			jPanel6.add(getCantidadTransportadajTextField(), null);
			jPanel6.add(MonedajLabel, null);
			jPanel6.add(getMonedajComboBox1(), null);
			jPanel6.add(ImporteFacturajLabel, null);
			jPanel6.add(getImporteFacturajTextField(), null);
			jPanel6.add(FechaConversionjLabel, null);
			jPanel6.add(TasaConversionjLabel, null);
			jPanel6.add(ImporteConvertidojLabel, null);
			jPanel6.add(getTasaConversionjTextField(), null);
			jPanel6.add(getImporteConvertidojTextField(), null);
			jPanel6.add(getJButton(), null);
			jPanel6.add(getCostojButton1(), null);
			jPanel6.add(CostojLabel, null);
			jPanel6.add(getCostojTextField(), null);
			jPanel6.add(getDatejSpinner1(), null);
			jPanel6.add(getJPanel13(), null);
		}
		return jPanel6;
	}



	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(4, 48, 166, 25));
		}
		return jComboBox;
	}



	/**
	 * This method initializes NombreProveedorjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNombreProveedorjTextField() {
		if (NombreProveedorjTextField == null) {
			NombreProveedorjTextField = new JTextField();
			NombreProveedorjTextField.setBounds(new Rectangle(198, 48, 211, 25));
			Validate.validateLetter(NombreProveedorjTextField);
		}
		return NombreProveedorjTextField;
	}



	/**
	 * This method initializes NumeroFacturajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNumeroFacturajTextField() {
		if (NumeroFacturajTextField == null) {
			NumeroFacturajTextField = new JTextField();
			NumeroFacturajTextField.setBounds(new Rectangle(441, 48, 137, 25));
		}
		return NumeroFacturajTextField;
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
			DatejSpinner.setBounds(new Rectangle(602, 48, 142, 25));
		}
		return DatejSpinner;
	}



	/**
	 * This method initializes CantidadTransportadajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantidadTransportadajTextField() {
		if (CantidadTransportadajTextField == null) {
			CantidadTransportadajTextField = new JTextField();
			CantidadTransportadajTextField.setBounds(new Rectangle(780, 48, 149, 25));
			Validate.validateDigitAndComma(CantidadTransportadajTextField);
		}
		return CantidadTransportadajTextField;
	}



	/**
	 * This method initializes MonedajComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getMonedajComboBox1() {
		if (MonedajComboBox1 == null) {
			MonedajComboBox1 = new JComboBox();
			MonedajComboBox1.setBounds(new Rectangle(951, 47, 129, 25));
			MonedajComboBox1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(MonedajComboBox1.getSelectedIndex()==2){
						TasaConversionjLabel.setVisible(true);
						TasaConversionjTextField.setVisible(true);
						jButton.setVisible(true);
						ImporteConvertidojLabel.setVisible(true);
						ImporteConvertidojTextField.setVisible(true);
						FechaConversionjLabel.setVisible(true);
						DatejSpinner1.setVisible(true);
					}else{
						TasaConversionjLabel.setVisible(false);
						TasaConversionjTextField.setVisible(false);
						jButton.setVisible(false);
						ImporteConvertidojLabel.setVisible(false);
						ImporteConvertidojTextField.setVisible(false);
						FechaConversionjLabel.setVisible(false);
						ImporteConvertidojTextField.setText("");
						DatejSpinner1.setVisible(false);
						}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MonedajComboBox1;
	}



	/**
	 * This method initializes ImporteFacturajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImporteFacturajTextField() {
		if (ImporteFacturajTextField == null) {
			ImporteFacturajTextField = new JTextField();
			ImporteFacturajTextField.setBounds(new Rectangle(1104, 47, 139, 25));
			Validate.validateDigitAndComma(ImporteFacturajTextField);
		}
		return ImporteFacturajTextField;
	}



	/**
	 * This method initializes TasaConversionjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTasaConversionjTextField() {
		if (TasaConversionjTextField == null) {
			TasaConversionjTextField = new JTextField();
			TasaConversionjTextField.setBounds(new Rectangle(200, 111, 149, 23));
			Validate.validateDigitAndComma(TasaConversionjTextField);
		}
		return TasaConversionjTextField;
	}



	/**
	 * This method initializes ImporteConvertidojTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImporteConvertidojTextField() {
		if (ImporteConvertidojTextField == null) {
			ImporteConvertidojTextField = new JTextField();
			ImporteConvertidojTextField.setBounds(new Rectangle(775, 109, 178, 25));
			Validate.validateDigitAndComma(ImporteConvertidojTextField);
			}
		return ImporteConvertidojTextField;
	}



	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("=");
			jButton.setBounds(new Rectangle(448, 109, 44, 25));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					float importe = Float.valueOf(ImporteFacturajTextField.getText());
					if(getMonedajComboBox1().getSelectedIndex()==2){						
					float tasa = Float.valueOf(TasaConversionjTextField.getText());
					float conversion = importe*tasa;
					ImporteConvertidojTextField.setText(String.valueOf(dosDigitos.format(conversion)));					
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "El Tipo de Moneda debe ser EUR", "Información", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton;
	}



	/**
	 * This method initializes CostojButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCostojButton1() {
		if (CostojButton1 == null) {
     		CostojButton1 = new JButton();
			CostojButton1.setText("=");
			CostojButton1.setBounds(new Rectangle(448, 145, 44, 25));
			CostojButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					float cant = Float.valueOf(CantidadTransportadajTextField.getText());
					if(ImporteConvertidojTextField.getText().length()!=0){
						float con = Float.valueOf(ImporteConvertidojTextField.getText());
						float costo = con/cant;
						CostojTextField.setText(String.valueOf(dosDigitos.format(costo)));
					}else{
						float impor = Float.valueOf(ImporteFacturajTextField.getText());
						float cost = impor/cant;
						CostojTextField.setText(String.valueOf(dosDigitos.format(cost)));
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return CostojButton1;
	}



	/**
	 * This method initializes CostojTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostojTextField() {
		if (CostojTextField == null) {
			CostojTextField = new JTextField();
			Validate.validateDigitAndComma(CostojTextField);
			CostojTextField.setEditable(false);
			CostojTextField.setBounds(new Rectangle(720, 145, 214, 25));
		}
		return CostojTextField;
	}



	/**
	 * This method initializes InsertarjButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getInsertarjButton1() {
		if (InsertarjButton1 == null) {
			InsertarjButton1 = new JButton();
			InsertarjButton1.setText("Registrar Transportación");
			InsertarjButton1.setBounds(new Rectangle(11, 15, 202, 40));
			InsertarjButton1.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			InsertarjButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getMonedajComboBox1().getSelectedIndex()!=0 && getJComboBox().getSelectedIndex()!=0){
						if(((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getDescripcion().equals("EUR") && ImporteConvertidojTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
					try {
						ServicioTransportacionAerea.insertarTransportacionAereaMateriaPrima(NombreProveedorjTextField.getText(), NumeroFacturajTextField.getText(), sqlDate, Float.valueOf(CantidadTransportadajTextField.getText()), ((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteFacturajTextField.getText()), sqlDate1, Float.valueOf(TasaConversionjTextField.getText()), Float.valueOf(ImporteConvertidojTextField.getText()), Float.valueOf(CostojTextField.getText()), mp.getId_Materia(),  ((Tipo)getJComboBox().getSelectedItem()).getId_tipo());
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transportación Registrada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
						CostoTransportacionAereajTextField.setText(CostojTextField.getText());
						CantidadTransportadaDesjTextField1.setText(CantidadTransportadajTextField.getText());
						CAntidadTransportadajTextField.setText(CantidadTransportadajTextField.getText());
						CantidadTransportadaAduanajTextField.setText(CantidadTransportadajTextField.getText());
						jButton18.setEnabled(true);
						InsertarjButton1.setEnabled(false);
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Ya existe el Registro", "Información", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
						if(((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getDescripcion().equals("USD") && ImporteConvertidojTextField.getText().length()==0){
							java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
							//java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());	
							try {
								ServicioTransportacionAerea.insertarTransportacionAereaMateriaPrima(NombreProveedorjTextField.getText(), NumeroFacturajTextField.getText(), sqlDate, Float.valueOf(CantidadTransportadajTextField.getText()), ((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteFacturajTextField.getText()), null, 0, 0, Float.valueOf(CostojTextField.getText()), mp.getId_Materia(),  ((Tipo)getJComboBox().getSelectedItem()).getId_tipo());
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transportación Registrada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
								CostoTransportacionAereajTextField.setText(CostojTextField.getText());
								CantidadTransportadaDesjTextField1.setText(CantidadTransportadajTextField.getText());
								CAntidadTransportadajTextField.setText(CantidadTransportadajTextField.getText());
								CantidadTransportadaAduanajTextField.setText(CantidadTransportadajTextField.getText());
								jButton18.setEnabled(true);
								InsertarjButton1.setEnabled(false);
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Ya existe el Registro", "Información", JOptionPane.ERROR_MESSAGE);
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Debe seleccionar el Tipo de Moneda y El Tipo de Transportación", "Información", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return InsertarjButton1;
	}



	/**
	 * This method initializes RegresarjButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegresarjButton1() {
		if (RegresarjButton1 == null) {
			RegresarjButton1 = new JButton();
			RegresarjButton1.setText("Listado de Materias Primas Importadas");
			RegresarjButton1.setBounds(new Rectangle(647, 15, 297, 40));
			RegresarjButton1.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			RegresarjButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMateriasPrimasExtranjeras().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return RegresarjButton1;
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
			DatejSpinner1.setBounds(new Rectangle(262, 148, 99, 25));
		}
		return DatejSpinner1;
	}



	/**
	 * This method initializes jPanel7	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel7() {
		if (jPanel7 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Proveedor:  " + mp.getNombreproveedor());
			jLabel3.setBounds(new Rectangle(14, 33, 291, 29));
			jLabel = new JLabel(); 
			jLabel.setText("No. Factura:  " + mp.getNumerofactura());
			jLabel.setBounds(new Rectangle(14, 67, 291, 29));
			jPanel7 = new JPanel();
			jPanel7.setLayout(null);
			jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Datos de la Materia Prima", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel7.add(jLabel, null);
			jPanel7.add(jLabel3, null);
			jPanel7.add(getJScrollPane1(), null);
		}
		return jPanel7;
	}



	/**
	 * This method initializes jTextArea1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setText("Descripción:  " + mp.getDescripcion());
			jTextArea1.setEditable(false);
		}
		return jTextArea1;
	}



	/**
	 * This method initializes jPanel8	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel8() {
		if (jPanel8 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("*Costo Unitario de la Desaduanización:");
			jLabel10.setBounds(new Rectangle(657, 153, 220, 23));
			jLabel9 = new JLabel();
			jLabel9.setText("Importe de la Factura Convertido de DOP a USD:");
			jLabel9.setBounds(new Rectangle(657, 108, 275, 23));
			jLabel8 = new JLabel();
			jLabel8.setText("Fecha de la Tasa de Cambio de DOP a USD:");
			jLabel8.setBounds(new Rectangle(15, 153, 247, 23));
			jLabel7 = new JLabel();
			jLabel7.setText("Tasa de Cambio de DOP a USD:");
			jLabel7.setBounds(new Rectangle(15, 108, 186, 23));
			CantijLabel7 = new JLabel();
			CantijLabel7.setText("Cantidad Transportada:");
			CantijLabel7.setBounds(new Rectangle(1052, 25, 140, 23));
			ImportejLabel7 = new JLabel();
			ImportejLabel7.setText("*Importe de la Factura:");
			ImportejLabel7.setBounds(new Rectangle(907, 25, 131, 23));
			jLabel6 = new JLabel();
			jLabel6.setText("*Tipo de Moneda:");
			jLabel6.setBounds(new Rectangle(736, 25, 155, 23));
			FechaFacturaDesjLabel6 = new JLabel();
			FechaFacturaDesjLabel6.setText("Fecha Factura:");
			FechaFacturaDesjLabel6.setBounds(new Rectangle(565, 25, 155, 23));
			jLabel5 = new JLabel();
			jLabel5.setText("*Número de la Factura:");
			jLabel5.setBounds(new Rectangle(397, 25, 147, 23));
			NombreProveedorjLabel5 = new JLabel();
			NombreProveedorjLabel5.setText("*Nombre del Proveedor:");
			NombreProveedorjLabel5.setBounds(new Rectangle(198, 25, 177, 23));
			jLabel4 = new JLabel();
			jLabel4.setText("*Tipo de Desaduanización:");
			jLabel4.setBounds(new Rectangle(15, 25, 155, 23));
			jPanel8 = new JPanel();
			jPanel8.setLayout(null);
			jPanel8.setBorder(BorderFactory.createTitledBorder(null, "Datos de la Desaduanización", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel8.add(jLabel4, null);
			jPanel8.add(NombreProveedorjLabel5, null);
			jPanel8.add(getNombreProveedorDesjTextField1(), null);
			jPanel8.add(jLabel5, null);
			jPanel8.add(getNUmeroFacturaDesjTextField1(), null);
			jPanel8.add(FechaFacturaDesjLabel6, null);
			jPanel8.add(getDatejSpinner2(), null);
			jPanel8.add(jLabel6, null);
			jPanel8.add(getMonedaDesjComboBox1(), null);
			jPanel8.add(ImportejLabel7, null);
			jPanel8.add(getImportejTextField1(), null);
			jPanel8.add(CantijLabel7, null);
			jPanel8.add(getCantidadTransportadaDesjTextField1(), null);
			jPanel8.add(jLabel7, null);
			jPanel8.add(getTasaCambioDesjTextField1(), null);
			jPanel8.add(jLabel8, null);
			jPanel8.add(getDatejSpinner3(), null);
			jPanel8.add(getJButton1(), null);
			jPanel8.add(jLabel9, null);
			jPanel8.add(getImprteConvertidoDesjTextField1(), null);
			jPanel8.add(getJButton2(), null);
			jPanel8.add(jLabel10, null);
			jPanel8.add(getCostoDesjTextField1(), null);
			jPanel8.add(getTipoDesjComboBox1(), null);
			jPanel8.add(getJPanel14(), null);
		}
		return jPanel8;
	}



	/**
	 * This method initializes NombreProveedorDesjTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNombreProveedorDesjTextField1() {
		if (NombreProveedorDesjTextField1 == null) {
			NombreProveedorDesjTextField1 = new JTextField();
			NombreProveedorDesjTextField1.setBounds(new Rectangle(198, 48, 177, 25));
		}
		return NombreProveedorDesjTextField1;
	}



	/**
	 * This method initializes NUmeroFacturaDesjTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNUmeroFacturaDesjTextField1() {
		if (NUmeroFacturaDesjTextField1 == null) {
			NUmeroFacturaDesjTextField1 = new JTextField();
			NUmeroFacturaDesjTextField1.setBounds(new Rectangle(397, 48, 147, 25));
		}
		return NUmeroFacturaDesjTextField1;
	}
	
	
	
	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel2() {
		if (DatespinnerDateModel2  == null) {
			DatespinnerDateModel2 = new SpinnerDateModel();
		}
		return DatespinnerDateModel2;
	}

	private JSpinner getDatejSpinner2() {
		if (DatejSpinner2 == null) {
			DatejSpinner2 = new JSpinner(getDatespinnerDateModel2() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner2.setEditor(new JSpinner.DateEditor(DatejSpinner2,dateFormat.toPattern()));
			DatejSpinner2.setBounds(new Rectangle(564, 48, 155, 23));
		}
		return DatejSpinner2;
	}



	/**
	 * This method initializes MonedaDesjComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getMonedaDesjComboBox1() {
		if (MonedaDesjComboBox1 == null) {
			MonedaDesjComboBox1 = new JComboBox();
			MonedaDesjComboBox1.setBounds(new Rectangle(736, 48, 155, 23));
			MonedaDesjComboBox1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(MonedaDesjComboBox1.getSelectedIndex()==1){
						jLabel7.setVisible(true);
						TasaCambioDesjTextField1.setVisible(true);
						jButton1.setVisible(true);
						jLabel9.setVisible(true);
						ImprteConvertidoDesjTextField1.setVisible(true);
						jLabel8.setVisible(true);
						DatejSpinner3.setVisible(true);
					}else{
						jLabel7.setVisible(false);
						TasaCambioDesjTextField1.setVisible(false);
						jButton1.setVisible(false);
						jLabel9.setVisible(false);
						ImprteConvertidoDesjTextField1.setVisible(false);
						ImprteConvertidoDesjTextField1.setText("");
						jLabel8.setVisible(false);
						DatejSpinner3.setVisible(false);
						}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MonedaDesjComboBox1;
	}



	/**
	 * This method initializes ImportejTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImportejTextField1() {
		if (ImportejTextField1 == null) {
			ImportejTextField1 = new JTextField();
			ImportejTextField1.setBounds(new Rectangle(907, 48, 131, 25));
			Validate.validateDigitAndComma(ImportejTextField1);
		}
		return ImportejTextField1;
	}



	/**
	 * This method initializes CantidadTransportadaDesjTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantidadTransportadaDesjTextField1() {
		if (CantidadTransportadaDesjTextField1 == null) {
			CantidadTransportadaDesjTextField1 = new JTextField();
			Validate.validateDigitAndComma(CantidadTransportadaDesjTextField1);
			CantidadTransportadaDesjTextField1.setBounds(new Rectangle(1053, 48, 137, 25));
		}
		return CantidadTransportadaDesjTextField1;
	}



	/**
	 * This method initializes TasaCambioDesjTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTasaCambioDesjTextField1() {
		if (TasaCambioDesjTextField1 == null) {
			TasaCambioDesjTextField1 = new JTextField();
			TasaCambioDesjTextField1.setBounds(new Rectangle(199, 108, 128, 23));
			Validate.validateDigitAndComma(TasaCambioDesjTextField1);
		}
		return TasaCambioDesjTextField1;
	}



	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel3() {
		if (DatespinnerDateModel3  == null) {
			DatespinnerDateModel3 = new SpinnerDateModel();
		}
		return DatespinnerDateModel3;
	}

	private JSpinner getDatejSpinner3() {
		if (DatejSpinner3 == null) {
			DatejSpinner3 = new JSpinner(getDatespinnerDateModel3() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner3.setEditor(new JSpinner.DateEditor(DatejSpinner3,dateFormat.toPattern()));
			DatejSpinner3.setBounds(new Rectangle(261, 153, 91, 23));
		}
		return DatejSpinner3;
	}



	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("=");
			jButton1.setBounds(new Rectangle(606, 108, 42, 23));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					if(((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getDescripcion().equals("DOP")){
						if(TasaCambioDesjTextField1.getText().length()!=0){
				float importe = Float.valueOf(ImportejTextField1.getText());
				float tasa=Float.valueOf(TasaCambioDesjTextField1.getText());
				float convert=importe/tasa;
				ImprteConvertidoDesjTextField1.setText(String.valueOf(dosDigitos.format(convert)));
						}else{
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "El Campo Tasa de Conversión no puede estar vacío", "Información", JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "El Tipo de Moneda debe ser DOP", "Información", JOptionPane.ERROR_MESSAGE);
						}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton1;
	}



	/**
	 * This method initializes ImprteConvertidoDesjTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImprteConvertidoDesjTextField1() {
		if (ImprteConvertidoDesjTextField1 == null) {
			ImprteConvertidoDesjTextField1 = new JTextField();
			ImprteConvertidoDesjTextField1.setBounds(new Rectangle(932, 108, 158, 23));
			Validate.validateDigitAndComma(ImprteConvertidoDesjTextField1);
			}
		return ImprteConvertidoDesjTextField1;
	}



	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("=");
			jButton2.setBounds(new Rectangle(606, 153, 42, 23));
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					float cant = Float.valueOf(CantidadTransportadaDesjTextField1.getText());
					if(ImprteConvertidoDesjTextField1.getText().length()!=0){
						float con = Float.valueOf(ImprteConvertidoDesjTextField1.getText());
						float costo = con/cant;
						CostoDesjTextField1.setText(String.valueOf(dosDigitos.format(costo)));
					}else{
						float impor = Float.valueOf(ImportejTextField1.getText());
						float cost = impor/cant;
						CostoDesjTextField1.setText(String.valueOf(dosDigitos.format(cost)));
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton2;
	}



	/**
	 * This method initializes CostoDesjTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoDesjTextField1() {
		if (CostoDesjTextField1 == null) {
			CostoDesjTextField1 = new JTextField();
			Validate.validateDigitAndComma(CostoDesjTextField1);
			CostoDesjTextField1.setEditable(false);
			CostoDesjTextField1.setBounds(new Rectangle(876, 153, 212, 23));
		}
		return CostoDesjTextField1;
	}



	/**
	 * This method initializes RegistrarDesaduanizacionjButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegistrarDesaduanizacionjButton3() {
		if (RegistrarDesaduanizacionjButton3 == null) {
			RegistrarDesaduanizacionjButton3 = new JButton();
			RegistrarDesaduanizacionjButton3.setText("Registrar Desaduanización");
			RegistrarDesaduanizacionjButton3.setBounds(new Rectangle(27, 16, 218, 40));
			RegistrarDesaduanizacionjButton3.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			RegistrarDesaduanizacionjButton3.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if(getMonedaDesjComboBox1().getSelectedIndex()!=0 && getTipoDesjComboBox1().getSelectedIndex()!=0){
								if(((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getDescripcion().equals("DOP") && ImprteConvertidoDesjTextField1.getText().length()!=0){
							java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel2().getDate().getTime());
							java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel3().getDate().getTime());
							try {
								ServicioDesaduanizacion.insertarDesaduanizacionMateriaPrima(NombreProveedorDesjTextField1.getText(), NUmeroFacturaDesjTextField1.getText(), sqlDate, ((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getId_tipomoneda(),Float.valueOf(ImportejTextField1.getText()), sqlDate1, Float.valueOf(TasaCambioDesjTextField1.getText()), Float.valueOf(ImprteConvertidoDesjTextField1.getText()), Float.valueOf(CostoDesjTextField1.getText()), mp.getId_Materia(), ((Tipo)getTipoDesjComboBox1().getSelectedItem()).getId_tipo(), Float.valueOf(CantidadTransportadaDesjTextField1.getText()));
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Desaduanización Registrada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
							CsotoUnitarioDesadunaizacionjTextField.setText(CostoDesjTextField1.getText());
							jButton19.setEnabled(true);
							RegistrarDesaduanizacionjButton3.setEnabled(false);
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Ya existe el Registro", "Información", JOptionPane.INFORMATION_MESSAGE);
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								}
								if(((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getDescripcion().equals("USD") && ImprteConvertidoDesjTextField1.getText().length()==0){
									java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel2().getDate().getTime());
									try {
										ServicioDesaduanizacion.insertarDesaduanizacionMateriaPrima(NombreProveedorDesjTextField1.getText(), NUmeroFacturaDesjTextField1.getText(), sqlDate, ((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getId_tipomoneda(),Float.valueOf(ImportejTextField1.getText()), null, 0, 0, Float.valueOf(CostoDesjTextField1.getText()), mp.getId_Materia(), ((Tipo)getTipoDesjComboBox1().getSelectedItem()).getId_tipo(), Float.valueOf(CantidadTransportadaDesjTextField1.getText()));
										JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Desaduanización Registrada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
										CsotoUnitarioDesadunaizacionjTextField.setText(CostoDesjTextField1.getText());
										jButton19.setEnabled(true);
										RegistrarDesaduanizacionjButton3.setEnabled(false);
									} catch (NumberFormatException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Ya existe el Registro", "Información", JOptionPane.ERROR_MESSAGE);
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}else{
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Debe seleccionar el Tipo de Moneda y el Tipo de Desaduanización", "Información", JOptionPane.ERROR_MESSAGE);
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return RegistrarDesaduanizacionjButton3;
	}



	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Listado de Materias Primas Importadas");
			jButton3.setBounds(new Rectangle(687, 16, 287, 40));
			jButton3.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMateriasPrimasExtranjeras().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton3;
	}



	/**
	 * This method initializes TipoDesjComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTipoDesjComboBox1() {
		if (TipoDesjComboBox1 == null) {
			TipoDesjComboBox1 = new JComboBox();
			TipoDesjComboBox1.setBounds(new Rectangle(15, 48, 155, 25));
		}
		return TipoDesjComboBox1;
	}



	/**
	 * This method initializes jPanel9	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel9() {
		if (jPanel9 == null) {
			jLabel21 = new JLabel();
			jLabel21.setBounds(new Rectangle(14, 67, 291, 29));
			jLabel21.setText("No. Factura:  " + mp.getNumerofactura());
			jLabel20 = new JLabel();
			jLabel20.setBounds(new Rectangle(14, 33, 291, 29));
			jLabel20.setText("Proveedor:  " + mp.getNombreproveedor());
			jPanel9 = new JPanel();
			jPanel9.setLayout(null);
			jPanel9.setBorder(BorderFactory.createTitledBorder(null, "Datos de la Materia Prima", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel9.add(jLabel20, null);
			jPanel9.add(jLabel21, null);
			jPanel9.add(getJScrollPane2(), null);
		}
		return jPanel9;
	}



	/**
	 * This method initializes jPanel10	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel10() {
		if (jPanel10 == null) {
			CostojLabel20 = new JLabel();
			CostojLabel20.setBounds(new Rectangle(635, 153, 220, 23));
			CostojLabel20.setText("*Costo Unitario de la Transportación:");
			jLabel19 = new JLabel();
			jLabel19.setBounds(new Rectangle(635, 108, 275, 23));
			jLabel19.setText("Importe de la Factura Convertido de DOP a USD:");
			jLabel18 = new JLabel();
			jLabel18.setBounds(new Rectangle(15, 153, 250, 23));
			jLabel18.setText("Fecha de la Tasa de Cambio de DOP a USD:");
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(15, 108, 180, 23));
			jLabel17.setText("Tasa de Cambio de DOP a USD:");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(879, 24, 145, 23));
			jLabel16.setText("Cantidad Transportada:");
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(718, 24, 145, 23));
			jLabel15.setText("*Importe de la Factura:");
			jLabel14 = new JLabel();
			jLabel14.setBounds(new Rectangle(557, 24, 145, 23));
			jLabel14.setText("*Tipo de Moneda:");
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(395, 24, 145, 23));
			jLabel13.setText("Fecha de la Factura:");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(236, 24, 145, 23));
			jLabel12.setText("*Número de la Factura:");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(11, 24, 209, 23));
			jLabel11.setText("*Nombre del Proveedor:");
			jPanel10 = new JPanel();
			jPanel10.setLayout(null);
			jPanel10.setBorder(BorderFactory.createTitledBorder(null, "Datos de la Desaduanización", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel10.add(jLabel11, null);
			jPanel10.add(getNombreProveedorTerrestrejTextField(), null);
			jPanel10.add(jLabel12, null);
			jPanel10.add(getNumeroFacturaTerrestrejTextField(), null);
			jPanel10.add(jLabel13, null);
			jPanel10.add(getDatejSpinner4(), null);
			jPanel10.add(jLabel14, null);
			jPanel10.add(getMonedaTerrestrejComboBox1(), null);
			jPanel10.add(jLabel15, null);
			jPanel10.add(getImporteTerrestrejTextField(), null);
			jPanel10.add(jLabel16, null);
			jPanel10.add(getCAntidadTransportadajTextField(), null);
			jPanel10.add(jLabel17, null);
			jPanel10.add(getTasaCAmbiojTextField(), null);
			jPanel10.add(jLabel18, null);
			jPanel10.add(getDatejSpinner6(), null);
			jPanel10.add(getJButton4(), null);
			jPanel10.add(getJButton5(), null);
			jPanel10.add(jLabel19, null);
			jPanel10.add(CostojLabel20, null);
			jPanel10.add(getImportejTextField(), null);
			jPanel10.add(getCostoTerrestrejTextField(), null);
			jPanel10.add(getJButton6(), null);
			jPanel10.add(getJButton7(), null);
			jPanel10.add(getJButton13(), null);
			jPanel10.add(getJButton20(), null);
			jPanel10.add(getImprimirjButton24(), null);
		}
		return jPanel10;
	}



	/**
	 * This method initializes NombreProveedorTerrestrejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNombreProveedorTerrestrejTextField() {
		if (NombreProveedorTerrestrejTextField == null) {
			NombreProveedorTerrestrejTextField = new JTextField();
			NombreProveedorTerrestrejTextField.setBounds(new Rectangle(11, 46, 209, 23));
		}
		return NombreProveedorTerrestrejTextField;
	}



	/**
	 * This method initializes NumeroFacturaTerrestrejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNumeroFacturaTerrestrejTextField() {
		if (NumeroFacturaTerrestrejTextField == null) {
			NumeroFacturaTerrestrejTextField = new JTextField();
			NumeroFacturaTerrestrejTextField.setBounds(new Rectangle(236, 46, 145, 23));
		}
		return NumeroFacturaTerrestrejTextField;
	}

	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel4() {
		if (DatespinnerDateModel4  == null) {
			DatespinnerDateModel4 = new SpinnerDateModel();
		}
		return DatespinnerDateModel4;
	}

	private JSpinner getDatejSpinner4() {
		if (DatejSpinner4 == null) {
			DatejSpinner4 = new JSpinner(getDatespinnerDateModel4() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner4.setEditor(new JSpinner.DateEditor(DatejSpinner4,dateFormat.toPattern()));
			DatejSpinner4.setBounds(new Rectangle(395, 46, 145, 23));
		}
		return DatejSpinner4;
	}



	/**
	 * This method initializes MonedaTerrestrejComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getMonedaTerrestrejComboBox1() {
		if (MonedaTerrestrejComboBox1 == null) {
			MonedaTerrestrejComboBox1 = new JComboBox();
			MonedaTerrestrejComboBox1.setBounds(new Rectangle(557, 46, 145, 23));
			MonedaTerrestrejComboBox1.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if(MonedaTerrestrejComboBox1.getSelectedIndex()==1){
								jLabel17.setVisible(true);
								TasaCAmbiojTextField.setVisible(true);
								jButton4.setVisible(true);
								jLabel19.setVisible(true);
								ImportejTextField.setVisible(true);
								jLabel18.setVisible(true);
								DatejSpinner6.setVisible(true);
							}else{
								jLabel17.setVisible(false);
								TasaCAmbiojTextField.setVisible(false);
								jButton4.setVisible(false);
								jLabel19.setVisible(false);
								ImportejTextField.setVisible(false);
								ImportejTextField.setText("");
								jLabel18.setVisible(false);
								DatejSpinner6.setVisible(false);
								}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MonedaTerrestrejComboBox1;
	}



	/**
	 * This method initializes ImporteTerrestrejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImporteTerrestrejTextField() {
		if (ImporteTerrestrejTextField == null) {
			ImporteTerrestrejTextField = new JTextField();
			ImporteTerrestrejTextField.setBounds(new Rectangle(718, 46, 145, 23));
			
			Validate.validateDigitAndComma(ImporteTerrestrejTextField);
		}
		return ImporteTerrestrejTextField;
	}



	/**
	 * This method initializes CAntidadTransportadajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCAntidadTransportadajTextField() {
		if (CAntidadTransportadajTextField == null) {
			CAntidadTransportadajTextField = new JTextField();
			CAntidadTransportadajTextField.setBounds(new Rectangle(879, 46, 145, 23));
			}
		return CAntidadTransportadajTextField;
	}



	/**
	 * This method initializes TasaCAmbiojTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTasaCAmbiojTextField() {
		if (TasaCAmbiojTextField == null) {
			TasaCAmbiojTextField = new JTextField();
			TasaCAmbiojTextField.setBounds(new Rectangle(193, 108, 183, 23));
			Validate.validateDigitAndComma(TasaCAmbiojTextField);
		}
		return TasaCAmbiojTextField;
	}
	
	

	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel6() {
		if (DatespinnerDateModel6  == null) {
			DatespinnerDateModel6 = new SpinnerDateModel();
		}
		return DatespinnerDateModel6;
	}

	private JSpinner getDatejSpinner6() {
		if (DatejSpinner6 == null) {
			DatejSpinner6 = new JSpinner(getDatespinnerDateModel6() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner6.setEditor(new JSpinner.DateEditor(DatejSpinner6,dateFormat.toPattern()));
			DatejSpinner6.setBounds(new Rectangle(265, 153, 107, 23));
		}
		return DatejSpinner6;
	}



	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(584, 108, 42, 23));
			jButton4.setText("=");
			jButton4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					if(((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getDescripcion().equals("DOP")){
						if(TasaCAmbiojTextField.getText().length()!=0){
					float importe= Float.valueOf(ImporteTerrestrejTextField.getText()); 
					float tasa= Float.valueOf(TasaCAmbiojTextField.getText());
					float result= importe/tasa;
			        ImportejTextField.setText(String.valueOf(dosDigitos.format(result)));
						}else{
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "El Campo Tasa de Conversión no puede estar vacío", "Información", JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "El Tipo de Moneda debe ser DOP", "Información", JOptionPane.ERROR_MESSAGE);
						}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton4;
	}



	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(584, 153, 42, 23));
			jButton5.setText("=");
			jButton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
				   	DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);					
					float cant = Float.valueOf(CAntidadTransportadajTextField.getText());
					if(ImportejTextField.getText().length()!=0){
						float con = Float.valueOf(ImportejTextField.getText());
						float costo = con/cant;
						CostoTerrestrejTextField.setText(String.valueOf(dosDigitos.format(costo)));
					}else{
						float impor = Float.valueOf(ImporteTerrestrejTextField.getText());
						float cost = impor/cant;
						CostoTerrestrejTextField.setText(String.valueOf(dosDigitos.format(cost)));
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton5;
	}



	/**
	 * This method initializes ImportejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 * @throws ParseException 
	 */
	private JTextField getImportejTextField() {
		if (ImportejTextField == null) {
			ImportejTextField = new JTextField();
			ImportejTextField.setBounds(new Rectangle(910, 108, 235, 23));
			Validate.validateDigitAndComma(ImportejTextField);
			}
		return ImportejTextField;
	}



	/**
	 * This method initializes CostoTerrestrejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoTerrestrejTextField() {
		if (CostoTerrestrejTextField == null) {
			CostoTerrestrejTextField = new JTextField();
			CostoTerrestrejTextField.setBounds(new Rectangle(854, 153, 290, 23));
			Validate.validateDigitAndComma(CostoTerrestrejTextField);
			CostoTerrestrejTextField.setEditable(false);
		}
		return CostoTerrestrejTextField;
	}



	/**
	 * This method initializes jButton6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(10, 208, 261, 40));
			jButton6.setText("Registrar Transportación Terrestre");
			jButton6.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			jButton6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getMonedaTerrestrejComboBox1().getSelectedIndex()!=0){
						if(((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getDescripcion().equals("DOP") && ImportejTextField.getText().length()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel4().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel6().getDate().getTime());
				try {
						ServicioTerrestre.insertarTransportacionTerrestreMateriaPrima(NombreProveedorTerrestrejTextField.getText(), NumeroFacturaTerrestrejTextField.getText(), sqlDate, ((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteTerrestrejTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(ImportejTextField.getText()), Float.valueOf(CostoTerrestrejTextField.getText()), mp.getId_Materia(), Float.valueOf(CAntidadTransportadajTextField.getText()));
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transportación Terrestre Registrada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
				CostoUnitariodelTarnasportacionTerrestrejTextField.setText(CostoTerrestrejTextField.getText());
				jButton20.setEnabled(true);
				jButton6.setEnabled(false);
				} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Ya existe el Registro", "Información", JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
						if(((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getDescripcion().equals("USD") && ImportejTextField.getText().length()==0){
							
							java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel2().getDate().getTime());
							try {
								ServicioTerrestre.insertarTransportacionTerrestreMateriaPrima(NombreProveedorTerrestrejTextField.getText(), NumeroFacturaTerrestrejTextField.getText(), sqlDate, ((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getId_tipomoneda(), Float.valueOf(ImporteTerrestrejTextField.getText()), null, 0, 0, Float.valueOf(CostoTerrestrejTextField.getText()), mp.getId_Materia(), Float.valueOf(CAntidadTransportadajTextField.getText()));
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transportación Terrestre Registrada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
								CostoUnitariodelTarnasportacionTerrestrejTextField.setText(CostoTerrestrejTextField.getText());
								jButton20.setEnabled(true);
								jButton6.setEnabled(false);
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Ya existe el Registro", "Información", JOptionPane.ERROR_MESSAGE);
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Debe seleccionar el Tipo de Moneda", "Información", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton6;
	}



	/**
	 * This method initializes jButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(761, 208, 286, 40));
			jButton7.setText("Listado de Materias Primas Importadas");
			jButton7.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			jButton7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMateriasPrimasExtranjeras().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton7;
	}



	/**
	 * This method initializes jTextArea2	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setText("Descripción:  " + mp.getDescripcion());
			jTextArea2.setEditable(false);
		}
		return jTextArea2;
	}



	/**
	 * This method initializes jPanel11	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel11() {
		if (jPanel11 == null) {
			jLabel23 = new JLabel();
			jLabel23.setBounds(new Rectangle(14, 67, 291, 29));
			jLabel23.setText("No. Factura:  " + mp.getNumerofactura());
			jLabel22 = new JLabel();
			jLabel22.setBounds(new Rectangle(14, 33, 291, 29));
			jLabel22.setText("Proveedor:  " + mp.getNombreproveedor());
			jPanel11 = new JPanel();
			jPanel11.setLayout(null);
			jPanel11.setBorder(BorderFactory.createTitledBorder(null, "Datos de la Materia Prima", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel11.add(jLabel22, null);
			jPanel11.add(jLabel23, null);
			jPanel11.add(getJScrollPane3(), null);
		}
		return jPanel11;
	}



	/**
	 * This method initializes jPanel12	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel12() {
		if (jPanel12 == null) {
			jLabel29 = new JLabel();
			jLabel29.setBounds(new Rectangle(582, 28, 138, 23));
			jLabel29.setText("Cantidad Transportada:");
			jLabel28 = new JLabel();
			jLabel28.setBounds(new Rectangle(633, 114, 321, 23));
			jLabel28.setText("*Costo Unitario de los Gastos en Aduana de Zona Franca:");
			jLabel27 = new JLabel();
			jLabel27.setBounds(new Rectangle(633, 69, 245, 23));
			jLabel27.setText("*Importe Pagado Convertido de DOP a USD:");
			jLabel26 = new JLabel();
			jLabel26.setBounds(new Rectangle(13, 69, 186, 23));
			jLabel26.setText("*Tasa de Cambio de DOP a USD:");
			jLabel25 = new JLabel();
			jLabel25.setBounds(new Rectangle(13, 114, 250, 23));
			jLabel25.setText("Fecha de la Tasa de Cambio de DOP a USD:");
			jLabel24 = new JLabel();
			jLabel24.setBounds(new Rectangle(13, 28, 145, 23));
			jLabel24.setText("*Importe Pagado en DOP:");
			jPanel12 = new JPanel();
			jPanel12.setLayout(null);
			jPanel12.setBorder(BorderFactory.createTitledBorder(null, "Datos del Pago en Aduana de la Zona Franca ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel12.add(jLabel24, null);
			jPanel12.add(getImporteDOPjTextField(), null);
			jPanel12.add(jLabel25, null);
			jPanel12.add(jLabel26, null);
			jPanel12.add(getTasaCAmbioADuanajTextField(), null);
			jPanel12.add(jLabel27, null);
			jPanel12.add(jLabel28, null);
			jPanel12.add(getJButton8(), null);
			jPanel12.add(getJButton9(), null);
			jPanel12.add(getRegitsrajButton10(), null);
			jPanel12.add(getJButton10(), null);
			jPanel12.add(getImporteAduanajTextField(), null);
			jPanel12.add(getCostoAduanajTextField(), null);
			jPanel12.add(getDatejSpinner7(), null);
			jPanel12.add(jLabel29, null);
			jPanel12.add(getCantidadTransportadaAduanajTextField(), null);
			jPanel12.add(getJButton14(), null);
			jPanel12.add(getJButton21(), null);
			jPanel12.add(getJButton24(), null);
		}
		return jPanel12;
	}



	/**
	 * This method initializes ImporteDOPjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImporteDOPjTextField() {
		if (ImporteDOPjTextField == null) {
			ImporteDOPjTextField = new JTextField();
			ImporteDOPjTextField.setBounds(new Rectangle(158, 28, 216, 23));
			Validate.validateDigitAndComma(ImporteDOPjTextField);
			}
		return ImporteDOPjTextField;
	}



	/**
	 * This method initializes TasaCAmbioADuanajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTasaCAmbioADuanajTextField() {
		if (TasaCAmbioADuanajTextField == null) {
			TasaCAmbioADuanajTextField = new JTextField();
			TasaCAmbioADuanajTextField.setBounds(new Rectangle(198, 69, 176, 23));
			Validate.validateDigitAndComma(TasaCAmbioADuanajTextField);
		}
		return TasaCAmbioADuanajTextField;
	}



	/**
	 * This method initializes jButton8	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setBounds(new Rectangle(582, 69, 42, 23));
			jButton8.setText("=");
			jButton8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					float importe=Float.valueOf(ImporteDOPjTextField.getText());
					float tasa=Float.valueOf(TasaCAmbioADuanajTextField.getText());
					float convert= importe/tasa;
					ImporteAduanajTextField.setText(dosDigitos.format(convert));
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton8;
	}



	/**
	 * This method initializes jButton9	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setBounds(new Rectangle(582, 114, 42, 23));
			jButton9.setText("=");
			jButton9.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
					float importe=Float.valueOf(ImporteAduanajTextField.getText());
					float cant=Float.valueOf(CantidadTransportadaAduanajTextField.getText());
					float costo=importe/cant;
					CostoAduanajTextField.setText(String.valueOf(dosDigitos.format(costo)));
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton9;
	}



	/**
	 * This method initializes RegitsrajButton10	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getRegitsrajButton10() {
		if (RegitsrajButton10 == null) {
			RegitsrajButton10 = new JButton();
			RegitsrajButton10.setBounds(new Rectangle(6, 206, 236, 40));
			RegitsrajButton10.setText("Registrar Aduana Zona Franca");
			RegitsrajButton10.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			RegitsrajButton10.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(ImporteDOPjTextField.getText().length()!=0 && TasaCAmbioADuanajTextField.getText().length()!=0 && ImporteAduanajTextField.getText().length()!=0 && CostoAduanajTextField.getText().length()!=0){
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel7().getDate().getTime());
						try {
							ServicioAduana.insertarAduanaMateriaPrima(Float.valueOf(ImporteDOPjTextField.getText()), sqlDate, Float.valueOf(TasaCAmbioADuanajTextField.getText()), Float.valueOf(ImporteAduanajTextField.getText()), Float.valueOf(CantidadTransportadaAduanajTextField.getText()), Float.valueOf(CostoAduanajTextField.getText()), mp.getId_Materia());
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Pago en Aduana de la Zona Franca Registrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
						CostoUnitarioAdunajTextField.setText(CostoAduanajTextField.getText());
						jButton21.setEnabled(true);
						RegitsrajButton10.setEnabled(false);
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
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Los Datos señalados con * son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return RegitsrajButton10;
	}



	/**
	 * This method initializes jButton10	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton10() {
		if (jButton10 == null) {
			jButton10 = new JButton();
			jButton10.setBounds(new Rectangle(725, 206, 289, 40));
			jButton10.setText("Listado de Materias Primas Importadas");
			jButton10.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			jButton10.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMateriasPrimasExtranjeras().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton10;
	}



	/**
	 * This method initializes ImporteAduanajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getImporteAduanajTextField() {
		if (ImporteAduanajTextField == null) {
			ImporteAduanajTextField = new JTextField();
			ImporteAduanajTextField.setBounds(new Rectangle(877, 69, 195, 23));
			Validate.validateDigitAndComma(ImporteAduanajTextField);
			ImporteAduanajTextField.setEditable(false);
		}
		return ImporteAduanajTextField;
	}



	/**
	 * This method initializes CostoAduanajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoAduanajTextField() {
		if (CostoAduanajTextField == null) {
			CostoAduanajTextField = new JTextField();
			CostoAduanajTextField.setBounds(new Rectangle(953, 114, 121, 23));
			Validate.validateDigitAndComma(CostoAduanajTextField);
			}
		return CostoAduanajTextField;
	}
	

	/**
	 * This method initializes DatespinnerDateModel	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getDatespinnerDateModel7() {
		if (DatespinnerDateModel7  == null) {
			DatespinnerDateModel7 = new SpinnerDateModel();
		}
		return DatespinnerDateModel7;
	}

	private JSpinner getDatejSpinner7() {
		if (DatejSpinner7 == null) {
			DatejSpinner7 = new JSpinner(getDatespinnerDateModel7() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DatejSpinner7.setEditor(new JSpinner.DateEditor(DatejSpinner7,dateFormat.toPattern()));
			DatejSpinner7.setBounds(new Rectangle(263, 114, 111, 23));
		}
		return DatejSpinner7;
	}



	/**
	 * This method initializes jTextArea3	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea3() {
		if (jTextArea3 == null) {
			jTextArea3 = new JTextArea();
			jTextArea3.setText("Descripción:  " + mp.getDescripcion());
			jTextArea3.setEditable(false);
		}
		return jTextArea3;
	}



	/**
	 * This method initializes CantidadTransportadaAduanajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantidadTransportadaAduanajTextField() {
		if (CantidadTransportadaAduanajTextField == null) {
			CantidadTransportadaAduanajTextField = new JTextField();
			CantidadTransportadaAduanajTextField.setBounds(new Rectangle(720, 28, 156, 23));
			}
		return CantidadTransportadaAduanajTextField;
	}



	/**
	 * This method initializes jButton11	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setText("Menú Principal");
			jButton11.setBounds(new Rectangle(960, 15, 179, 40));
			jButton11.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			jButton11.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					Started i = new Started();
					new Principal(i).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton11;
	}



	/**
	 * This method initializes jButton12	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setText("Menú Principal");
			jButton12.setBounds(new Rectangle(982, 16, 179, 40));
			jButton12.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			jButton12.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					Started i = new Started();
					new Principal(i).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton12;
	}



	/**
	 * This method initializes jButton13	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton13() {
		if (jButton13 == null) {
			jButton13 = new JButton();
			jButton13.setBounds(new Rectangle(1054, 208, 179, 40));
			jButton13.setText("Menú Principal");
			jButton13.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			jButton13.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					Started i = new Started();
					new Principal(i).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton13;
	}



	/**
	 * This method initializes jButton14	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton14() {
		if (jButton14 == null) {
			jButton14 = new JButton();
			jButton14.setBounds(new Rectangle(1022, 206, 211, 40));
			jButton14.setText("Menú Principal");
			jButton14.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			jButton14.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					Started i = new Started();
					new Principal(i).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton14;
	}



	/**
	 * This method initializes PrecioAdquisicionUSDjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPrecioAdquisicionUSDjTextField() {
		if (PrecioAdquisicionUSDjTextField == null) {
			PrecioAdquisicionUSDjTextField = new JTextField();
			PrecioAdquisicionUSDjTextField.setEditable(false);
			PrecioAdquisicionUSDjTextField.setBounds(new Rectangle(528, 9, 183, 26));
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			
			if(mp.getPrecioadquisicioEUROaUSD()!=0){
				PrecioAdquisicionUSDjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicioEUROaUSD())));
			}else{
			PrecioAdquisicionUSDjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisisonUSD())));
			}
		}
		return PrecioAdquisicionUSDjTextField;
	}



	/**
	 * This method initializes PrecioConvertidoDOPaUSDjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPrecioConvertidoDOPaUSDjTextField() {
		if (PrecioConvertidoDOPaUSDjTextField == null) {
			PrecioConvertidoDOPaUSDjTextField = new JTextField();
			PrecioConvertidoDOPaUSDjTextField.setEditable(false);
			PrecioConvertidoDOPaUSDjTextField.setBounds(new Rectangle(528, 53, 183, 26));
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			if(mp.getPrecioadquisicionEURyGastos()!=0){
				PrecioConvertidoDOPaUSDjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicionEURyGastos())));
			}else{
				PrecioConvertidoDOPaUSDjTextField.setText(String.valueOf(dosDigitos.format(mp.getPrecioadquisicionUSDyGastos())));
			}
		}
		return PrecioConvertidoDOPaUSDjTextField;
	}



	/**
	 * This method initializes CostoTransportacionAereajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoTransportacionAereajTextField() {
		if (CostoTransportacionAereajTextField == null) {
			CostoTransportacionAereajTextField = new JTextField();
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			CostoTransportacionAereajTextField.setEditable(false);
			CostoTransportacionAereajTextField.setBounds(new Rectangle(528, 100, 183, 26));
			TransportaciónAerea ta = ServicioTransportacionAerea.getTransportacionMateria(mp.getId_Materia());
			CostoTransportacionAereajTextField.setText(String.valueOf(dosDigitos.format(ta.getCostounitario())));
		}
		return CostoTransportacionAereajTextField;
	}



	/**
	 * This method initializes CsotoUnitarioDesadunaizacionjTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCsotoUnitarioDesadunaizacionjTextField() {
		if (CsotoUnitarioDesadunaizacionjTextField == null) {
			CsotoUnitarioDesadunaizacionjTextField = new JTextField();
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			CsotoUnitarioDesadunaizacionjTextField.setEditable(false);
			CsotoUnitarioDesadunaizacionjTextField.setBounds(new Rectangle(528, 142, 183, 26));
			Desaduanizacion des=ServicioDesaduanizacion.getDesaduanizacion(mp.getId_Materia());
			CsotoUnitarioDesadunaizacionjTextField.setText(String.valueOf(dosDigitos.format(des.getCostounitario())));
		}
		return CsotoUnitarioDesadunaizacionjTextField;
	}



	/**
	 * This method initializes CostoUnitariodelTarnasportacionTerrestrejTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoUnitariodelTarnasportacionTerrestrejTextField() {
		if (CostoUnitariodelTarnasportacionTerrestrejTextField == null) {
			CostoUnitariodelTarnasportacionTerrestrejTextField = new JTextField();
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			CostoUnitariodelTarnasportacionTerrestrejTextField.setEditable(false);
			CostoUnitariodelTarnasportacionTerrestrejTextField.setBounds(new Rectangle(528, 191, 183, 26));
			TransportacionTerrestre terrestre = ServicioTerrestre.getTransportacionTerrestreMateria(mp.getId_Materia());
			CostoUnitariodelTarnasportacionTerrestrejTextField.setText(String.valueOf(dosDigitos.format(terrestre.getCostounitario())));
		}
		return CostoUnitariodelTarnasportacionTerrestrejTextField;
	}



	/**
	 * This method initializes CostoUnitarioAdunajTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCostoUnitarioAdunajTextField() {
		if (CostoUnitarioAdunajTextField == null) {
			CostoUnitarioAdunajTextField = new JTextField();
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
			DecimalFormat dosDigitos = new DecimalFormat( "####.#####",simbolo);
			CostoUnitarioAdunajTextField.setEditable(false);
			CostoUnitarioAdunajTextField.setBounds(new Rectangle(528, 233, 183, 26));
			Aduana adu=ServicioAduana.getAduanaMateriaPrima(mp.getId_Materia());
			CostoUnitarioAdunajTextField.setText(String.valueOf(dosDigitos.format(adu.getCostounitario())));
		}
		return CostoUnitarioAdunajTextField;
	}



	/**
	 * This method initializes jButton15	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton15() {
		if (jButton15 == null) {
			jButton15 = new JButton();
			jButton15.setText("Registrar Costo Unitario Total");
			jButton15.setBounds(new Rectangle(22, 7, 286, 35));
			jButton15.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_SysInfo_Unit1_ilInfoStates1_16x16.png")));
			jButton15.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(LogisticajTextField.getText().length()!=0){
						try {
							ServicioMateriaPrima.InsertarCostoMateriaPrimaImportada(mp.getId_Materia(), Float.valueOf(CostoUnitarioTotaljTextField.getText()), Float.valueOf(LogisticajTextField.getText()));
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Costo Registrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
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
					}else{
						try {
							ServicioMateriaPrima.InsertarCostoMateriaPrimaImportadasinLogistica(mp.getId_Materia(), Float.valueOf(CostoUnitarioTotaljTextField.getText()));
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Costo Registrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
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
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton15;
	}



	/**
	 * This method initializes jButton16	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton16() {
		if (jButton16 == null) {
			jButton16 = new JButton();
			jButton16.setText("Listado de Materias Primas Importadas");
			jButton16.setBounds(new Rectangle(22, 121, 286, 35));
			jButton16.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_ClipboardEdit_24x24.png")));
			jButton16.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new ListadodeMateriasPrimasExtranjeras().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton16;
	}



	/**
	 * This method initializes jButton17	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton17() {
		if (jButton17 == null) {
			jButton17 = new JButton();
			jButton17.setText("Menú Principal");
			jButton17.setBounds(new Rectangle(22, 173, 286, 35));
			jButton17.setIcon(new ImageIcon(getClass().getResource("/Img/go-homeeee.png")));
			jButton17.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					dispose();
					Started i = new Started();
					new Principal(i).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton17;
	}



	/**
	 * This method initializes jButton18	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton18() {
		if (jButton18 == null) {
			jButton18 = new JButton();
			jButton18.setText("Modificar Transportación");
			jButton18.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			jButton18.setBounds(new Rectangle(226, 15, 209, 40));
			jButton18.setEnabled(false);
			jButton18.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getJComboBox().getSelectedIndex()!=0 && getMonedajComboBox1().getSelectedIndex()!=0){
						java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel1().getDate().getTime());
						java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel().getDate().getTime());
						if(((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getDescripcion().equals("EUR") && ImporteConvertidojTextField.getText().length()!=0){
						try {
							ServicioTransportacionAerea.ModificarTransporteAereoMateriaPrima(mp.getId_Materia(), Float.valueOf(ImporteFacturajTextField.getText()), sqlDate1, Float.valueOf(TasaConversionjTextField.getText()), Float.valueOf(ImporteConvertidojTextField.getText()), Float.valueOf(CantidadTransportadajTextField.getText()), Float.valueOf(CostojTextField.getText()), NombreProveedorjTextField.getText(), NumeroFacturajTextField.getText(), sqlDate, ((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getId_tipomoneda(), ((Tipo)getJComboBox().getSelectedItem()).getId_tipo());
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transportación Modificada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
							 CostoTransportacionAereajTextField.setText(CostojTextField.getText());
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
						
						if(((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getDescripcion().equals("USD")){
							try {
								ServicioTransportacionAerea.ModificarTransporteAereoMateriaPrima(mp.getId_Materia(), Float.valueOf(ImporteFacturajTextField.getText()), null,0, 0, Float.valueOf(CantidadTransportadajTextField.getText()), Float.valueOf(CostojTextField.getText()), NombreProveedorjTextField.getText(), NumeroFacturajTextField.getText(), sqlDate, ((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getId_tipomoneda(), ((Tipo)getJComboBox().getSelectedItem()).getId_tipo());
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transportación Modificada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
								TasaConversionjTextField.setText("");
								ImporteConvertidojTextField.setText("");
								CostoTransportacionAereajTextField.setText(CostojTextField.getText());
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
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Debe Elegir el Tipo de Moneda y el Tipo de Transportación", "Información", JOptionPane.ERROR_MESSAGE);
						}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			}
		return jButton18;
	}



	/**
	 * This method initializes jButton19	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton19() {
		if (jButton19 == null) {
			jButton19 = new JButton();
			jButton19.setText("Modificar Desaduanización");
			jButton19.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			jButton19.setBounds(new Rectangle(259, 16, 218, 40));
			jButton19.setEnabled(false);
			jButton19.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getMonedaDesjComboBox1().getSelectedIndex()!=0 && getTipoDesjComboBox1().getSelectedIndex()!=0){
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel2().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel3().getDate().getTime());
					if(((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getDescripcion().equals("DOP") && ImprteConvertidoDesjTextField1.getText().length()!=0){
					try {
						ServicioDesaduanizacion.ModificarDesadunaizacionMateriaPrima(mp.getId_Materia(), Float.valueOf(ImportejTextField1.getText()), sqlDate1, Float.valueOf(TasaCambioDesjTextField1.getText()), Float.valueOf(ImprteConvertidoDesjTextField1.getText()), Float.valueOf(CantidadTransportadaDesjTextField1.getText()), Float.valueOf(CostoDesjTextField1.getText()), NombreProveedorDesjTextField1.getText(), NUmeroFacturaDesjTextField1.getText(), sqlDate, ((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getId_tipomoneda(), ((Tipo)getTipoDesjComboBox1().getSelectedItem()).getId_tipo());
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Desaduanización Modificada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
						CsotoUnitarioDesadunaizacionjTextField.setText(CostoDesjTextField1.getText());
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
					
					if(((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getDescripcion().equals("USD")){
						try {
							ServicioDesaduanizacion.ModificarDesadunaizacionMateriaPrima(mp.getId_Materia(), Float.valueOf(ImportejTextField1.getText()), null, 0, 0, Float.valueOf(CantidadTransportadaDesjTextField1.getText()), Float.valueOf(CostoDesjTextField1.getText()), NombreProveedorDesjTextField1.getText(), NUmeroFacturaDesjTextField1.getText(), sqlDate, ((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getId_tipomoneda(), ((Tipo)getTipoDesjComboBox1().getSelectedItem()).getId_tipo());
							JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Desaduanización Modificada con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
							TasaCambioDesjTextField1.setText("");
							ImprteConvertidoDesjTextField1.setText("");
							CsotoUnitarioDesadunaizacionjTextField.setText(CostoDesjTextField1.getText());
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
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Debe Elegir el Tipo de Moneda y el Tipo de Desaduanización", "Información", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			
		}
		return jButton19;
	}



	/**
	 * This method initializes jButton20	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton20() {
		if (jButton20 == null) {
			jButton20 = new JButton();
			jButton20.setBounds(new Rectangle(282, 208, 269, 40));
			jButton20.setText("Modificar Transportación Terrestre");
			jButton20.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			jButton20.setEnabled(false);
			jButton20.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel4().getDate().getTime());
					java.sql.Date sqlDate1 = new java.sql.Date(getDatespinnerDateModel6().getDate().getTime());
					if(getMonedaTerrestrejComboBox1().getSelectedIndex()!=0){
						if(((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getDescripcion().equals("DOP") && ImportejTextField.getText().length()!=0){
					try {
						ServicioTerrestre.ModificarTransporteTerrestreMateriaPrima(mp.getId_Materia(), Float.valueOf(ImporteTerrestrejTextField.getText()), sqlDate1, Float.valueOf(TasaCAmbiojTextField.getText()), Float.valueOf(ImportejTextField.getText()), Float.valueOf(CAntidadTransportadajTextField.getText()), Float.valueOf(CostoTerrestrejTextField.getText()), NombreProveedorTerrestrejTextField.getText(), NumeroFacturaTerrestrejTextField.getText(), sqlDate, ((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getId_tipomoneda());
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transporte Terrestre Modificado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
						CostoUnitariodelTarnasportacionTerrestrejTextField.setText(CostoTerrestrejTextField.getText());
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
						
						if(((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getDescripcion().equals("USD")){
							try {
								ServicioTerrestre.ModificarTransporteTerrestreMateriaPrima(mp.getId_Materia(), Float.valueOf(ImporteTerrestrejTextField.getText()), null, 0, 0, Float.valueOf(CAntidadTransportadajTextField.getText()), Float.valueOf(CostoTerrestrejTextField.getText()), NombreProveedorTerrestrejTextField.getText(), NumeroFacturaTerrestrejTextField.getText(), sqlDate, ((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getId_tipomoneda());
								JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Transporte Terrestre Modificado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
								TasaCAmbiojTextField.setText("");
								ImportejTextField.setText("");
								CostoUnitariodelTarnasportacionTerrestrejTextField.setText(CostoTerrestrejTextField.getText());
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
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Debe Elegir el Tipo de Moneda", "Información", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton20;
	}



	/**
	 * This method initializes jButton21	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton21() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setBounds(new Rectangle(254, 206, 236, 40));
			jButton21.setText("Modificar Aduana Zona Franca");
			jButton21.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Refresh_24x24.png")));
			jButton21.setEnabled(false);
			jButton21.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					java.sql.Date sqlDate = new java.sql.Date(getDatespinnerDateModel7().getDate().getTime());
					try {						
						ServicioAduana.ModificarAduanaMateriaPrima(mp.getId_Materia(),Float.valueOf( ImporteDOPjTextField.getText()), sqlDate, Float.valueOf(TasaCAmbioADuanajTextField.getText()), Float.valueOf(ImporteAduanajTextField.getText()), Float.valueOf(CantidadTransportadaAduanajTextField.getText()) ,Float.valueOf(CostoAduanajTextField.getText()));
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Pago en Aduana de la Zona Franca Modificado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
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
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton21;
	}



	/**
	 * This method initializes jButton22	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton22() {
		if (jButton22 == null) {
			jButton22 = new JButton();
			jButton22.setText("Imprimir");
			jButton22.setBounds(new Rectangle(450, 15, 179, 40));
			jButton22.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			jButton22.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getMonedajComboBox1().getSelectedIndex()!=0){
					if(((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getDescripcion().equals("USD") && TasaConversionjTextField.getText().length()==0){
						try {
							Reportes.getR().ImprimirTransportaciónAéreaoMarítima(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}
					if(((TipoMoneda)getMonedajComboBox1().getSelectedItem()).getDescripcion().equals("EUR") && TasaConversionjTextField.getText().length()!=0){
						try {
							Reportes.getR().ImprimirTransportaciónAéreaoMarítimaEUR(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}
					
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Es necesario que elija el Tipo de Moneda", "Informacion", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton22;
	}



	/**
	 * This method initializes jButton23	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton23() {
		if (jButton23 == null) {
			jButton23 = new JButton();
			jButton23.setText("Imprimir");
			jButton23.setBounds(new Rectangle(494, 16, 179, 40));
			jButton23.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			jButton23.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getMonedaDesjComboBox1().getSelectedIndex()!=0){
						if(((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getDescripcion().equals("USD") && TasaCambioDesjTextField1.getText().length()==0){
						try {
							Reportes.getR().ImprimirDesaduanizacionUSD(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
						if(((TipoMoneda)getMonedaDesjComboBox1().getSelectedItem()).getDescripcion().equals("DOP") && TasaCambioDesjTextField1.getText().length()!=0){
							try {
								Reportes.getR().ImprimirDesaduanizacionDOP(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Es necesario que elija el Tipo de Moneda", "Informacion", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton23;
	}



	/**
	 * This method initializes ImprimirjButton24	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getImprimirjButton24() {
		if (ImprimirjButton24 == null) {
			ImprimirjButton24 = new JButton();
			ImprimirjButton24.setBounds(new Rectangle(569, 208, 179, 40));
			ImprimirjButton24.setText("Imprimir");
			ImprimirjButton24.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			ImprimirjButton24.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(getMonedaTerrestrejComboBox1().getSelectedIndex()!=0){
					if(((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getDescripcion().equals("USD") && TasaCAmbiojTextField.getText().length()==0){
						try {
							Reportes.getR().ImprimirTransportaciónTerrestreUSD(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					if(((TipoMoneda)getMonedaTerrestrejComboBox1().getSelectedItem()).getDescripcion().equals("DOP") && TasaCAmbiojTextField.getText().length()!=0){
						try {
							Reportes.getR().ImprimirTransportaciónTerrestreDOP(mp.getId_Materia());
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Es necesario que elija el Tipo de Moneda", "Informacion", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ImprimirjButton24;
	}



	/**
	 * This method initializes jButton24	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton24() {
		if (jButton24 == null) {
			jButton24 = new JButton();
			jButton24.setBounds(new Rectangle(504, 206, 211, 40));
			jButton24.setText("Imprimir");
			jButton24.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			jButton24.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Reportes.getR().ImprimirAduanaZonaFranca(mp.getId_Materia());
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton24;
	}



	/**
	 * This method initializes jPanel13	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel13() {
		if (jPanel13 == null) {
			jPanel13 = new JPanel();
			jPanel13.setLayout(null);
			jPanel13.setBounds(new Rectangle(81, 176, 1163, 74));
			jPanel13.add(getJButton11(), null);
			jPanel13.add(getRegresarjButton1(), null);
			jPanel13.add(getJButton22(), null);
			jPanel13.add(getJButton18(), null);
			jPanel13.add(getInsertarjButton1(), null);
		}
		return jPanel13;
	}



	/**
	 * This method initializes jPanel14	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel14() {
		if (jPanel14 == null) {
			jPanel14 = new JPanel();
			jPanel14.setLayout(null);
			jPanel14.setBounds(new Rectangle(27, 180, 1176, 75));
			jPanel14.add(getJButton12(), null);
			jPanel14.add(getJButton3(), null);
			jPanel14.add(getJButton23(), null);
			jPanel14.add(getJButton19(), null);
			jPanel14.add(getRegistrarDesaduanizacionjButton3(), null);
		}
		return jPanel14;
	}



	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(436, 33, 590, 94));
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}



	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(436, 33, 590, 94));
			jScrollPane1.setViewportView(getJTextArea1());
		}
		return jScrollPane1;
	}



	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(436, 33, 590, 94));
			jScrollPane2.setViewportView(getJTextArea2());
		}
		return jScrollPane2;
	}



	/**
	 * This method initializes jScrollPane3	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setBounds(new Rectangle(436, 33, 590, 94));
			jScrollPane3.setViewportView(getJTextArea3());
		}
		return jScrollPane3;
	}



	/**
	 * This method initializes jButton25	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton25() {
		if (jButton25 == null) {
			jButton25 = new JButton();
			jButton25.setText("Imprimir");
			jButton25.setBounds(new Rectangle(22, 64, 286, 35));
			jButton25.setIcon(new ImageIcon(getClass().getResource("/Img/printer.png")));
			jButton25.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if((!CostoTransportacionAereajTextField.getText().equals("0")) && (!CsotoUnitarioDesadunaizacionjTextField.getText().equals("0")) && (!CostoUnitariodelTarnasportacionTerrestrejTextField.getText().equals("0")) && (!CostoUnitarioAdunajTextField.getText().equals("0")) ){
						if(mp.getTipomoneda().equals("USD") && PrecioConvertidoDOPaUSDjTextField.getText().equals("0") && LogisticajTextField.getText().length()==0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoUSDImportado(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						if(mp.getTipomoneda().equals("USD") && PrecioConvertidoDOPaUSDjTextField.getText().equals("0") && LogisticajTextField.getText().length()!=0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoUSDImportadoconLogistica(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						
						if(mp.getTipomoneda().equals("USD") && (!PrecioConvertidoDOPaUSDjTextField.getText().equals("0")) && LogisticajTextField.getText().length()==0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoUSDImportadoconGastos(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						
						if(mp.getTipomoneda().equals("USD") && (!PrecioConvertidoDOPaUSDjTextField.getText().equals("0")) && LogisticajTextField.getText().length()!=0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoUSDImportadoconGastosyLogistica(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						
						if(mp.getTipomoneda().equals("EUR") && PrecioConvertidoDOPaUSDjTextField.getText().equals("0") && LogisticajTextField.getText().length()==0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoEUR(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						
						if(mp.getTipomoneda().equals("EUR") && PrecioConvertidoDOPaUSDjTextField.getText().equals("0") && LogisticajTextField.getText().length()!=0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoEURconLogistica(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						
						if(mp.getTipomoneda().equals("EUR") && (!PrecioConvertidoDOPaUSDjTextField.getText().equals("0")) && LogisticajTextField.getText().length()==0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoEURconGastos(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						if(mp.getTipomoneda().equals("EUR") && (!PrecioConvertidoDOPaUSDjTextField.getText().equals("0")) && LogisticajTextField.getText().length()!=0){
							try {
								Reportes.getR().ImprimirMateriaPrimaCostoEURconGastosyLogistica(mp.getId_Materia());
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						
					}else{
						JOptionPane.showMessageDialog(GestionarMateriaPrimaExtranjeraVisual.this, "Antes de Imprimir se deben calcular los Costos de Transportación, Desaduanización y Pago en Aduana de la Zona Franca ", "Información", JOptionPane.ERROR_MESSAGE);
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton25;
	}



	/**
	 * This method initializes jPanel15	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel15() {
		if (jPanel15 == null) {
			jPanel15 = new JPanel();
			jPanel15.setLayout(null);
			jPanel15.add(getJButton17(), null);
			jPanel15.add(getJButton16(), null);
			jPanel15.add(getJButton25(), null);
			jPanel15.add(getJButton15(), null);
		}
		return jPanel15;
	}



	/**
	 * This method initializes jPanel16	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel16() {
		if (jPanel16 == null) {
			jPanel16 = new JPanel();
			jPanel16.setLayout(null);
			jPanel16.add(getPrecioAdquisicionUSDjTextField(), null);
			jPanel16.add(jLabel30, null);
			jPanel16.add(getPrecioConvertidoDOPaUSDjTextField(), null);
			jPanel16.add(jLabel31, null);
			jPanel16.add(getCostoTransportacionAereajTextField(), null);
			jPanel16.add(jLabel32, null);
			jPanel16.add(getCsotoUnitarioDesadunaizacionjTextField(), null);
			jPanel16.add(jLabel33, null);
			jPanel16.add(getCostoUnitariodelTarnasportacionTerrestrejTextField(), null);
			jPanel16.add(jLabel34, null);
			jPanel16.add(getCostoUnitarioAdunajTextField(), null);
			jPanel16.add(jLabel35, null);
			jPanel16.add(getCostoUnitarioTotaljTextField(), null);
			jPanel16.add(getCostoUnitarioTotaljButton(), null);
		}
		return jPanel16;
	}
}  //  @jve:decl-index=0:visual-constraint="168,-123"
