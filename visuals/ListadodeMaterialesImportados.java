package visuals;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Material;
import model.TipoMaterial;
import services.ServicioAduana;
import services.ServicioDesaduanizacion;
import services.ServicioMaterial;
import services.ServicioTerrestre;
import services.ServicioTipoMaterial;
import services.ServicioTransportacionAerea;
import Utils.FormatoTabla;
import Utils.TableModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadodeMaterialesImportados extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton CerrarjButton = null;
	private JButton VerDatosjButton = null;
	private JButton EliminarjButton = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton = null;
	private JPanel jPanel = null;
	private JButton jButton1 = null;
	private JPanel panel;
	private JComboBox comboBox=null;

	public ListadodeMaterialesImportados() {
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
		this.setSize(new Dimension(1172, 744));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setTitle("Listado de Materiales Importados");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJContentPane());
		EliminarjButton.setEnabled(false);
		VerDatosjButton.setEnabled(false);
		TableModel tb=new TableModel();
		ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
		ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
		ArrayList<Object> columnDataFactura = new ArrayList<Object>();
		ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
		ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
		ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
		ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
		tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
		tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
		tb.addColumn("No. Factura",columnDataFactura.toArray());
		tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
		tb.addColumn("Descripción",columnDataDescripcion.toArray());		
		tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
		tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
		getJTable().setModel(tb);
		getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
		getJTable().setRowHeight(20);
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					EliminarjButton.setEnabled(true);
					VerDatosjButton.setEnabled(true);
					jButton1.setEnabled(true);				
					}
			});	
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation((screenSize.width - getWidth()) / 2,((screenSize.height - getHeight()) / 2));
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			GridBagLayout gbl_jContentPane = new GridBagLayout();
			gbl_jContentPane.columnWidths = new int[]{1154, 0};
			gbl_jContentPane.rowHeights = new int[]{68, 572, 47, 0};
			gbl_jContentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_jContentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			jContentPane.setLayout(gbl_jContentPane);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			jContentPane.add(getPanel(), gbc_panel);
			GridBagConstraints gbc_jScrollPane = new GridBagConstraints();
			gbc_jScrollPane.fill = GridBagConstraints.BOTH;
			gbc_jScrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_jScrollPane.gridx = 0;
			gbc_jScrollPane.gridy = 1;
			jContentPane.add(getJScrollPane(), gbc_jScrollPane);
			GridBagConstraints gbc_jPanel = new GridBagConstraints();
			gbc_jPanel.fill = GridBagConstraints.BOTH;
			gbc_jPanel.gridx = 0;
			gbc_jPanel.gridy = 2;
			jContentPane.add(getJPanel(), gbc_jPanel);
		}
		return jContentPane;
	}

	/**
	 * This method initializes CerrarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCerrarjButton() {
		if (CerrarjButton == null) {
			CerrarjButton = new JButton();
			CerrarjButton.setText("Insertar Material");
			CerrarjButton.setBounds(new Rectangle(749, 3, 153, 30));
			CerrarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/go-previous.png")));
			CerrarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new InsertarMaterialImportadoVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return CerrarjButton;
	}

	/**
	 * This method initializes VerDatosjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getVerDatosjButton() {
		if (VerDatosjButton == null) {
			VerDatosjButton = new JButton();
			VerDatosjButton.setText("Ver Datos Principales");
			VerDatosjButton.setBounds(new Rectangle(198, 3, 177, 30));
			VerDatosjButton.setIcon(new ImageIcon(getClass().getResource("/Img/system-search.png")));
			VerDatosjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int pos = jTable.getSelectedRow();
				if(comboBox.getSelectedIndex()==1){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosBotellas();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==2){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosCajas();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==3){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosCinturones();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==4){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosCordonesPlasticos();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==5){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosEstuches();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==6){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosEtiquetas();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==7){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosLibrito();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==8){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosMadera();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==9){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportadosSeparadores();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					}
				}
				if(comboBox.getSelectedIndex()==10){	
					try{
					LinkedList<Material> mediciones= ServicioMaterial.getMaterialesImportados();
					Material u = mediciones.get(pos);
					new ModificarMaterialImportadoVisual(u).setVisible(true);
					dispose();
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
		return VerDatosjButton;
	}

	/**
	 * This method initializes EliminarjButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getEliminarjButton() {
		if (EliminarjButton == null) {
			EliminarjButton = new JButton();
			EliminarjButton.setText("Eliminar");
			EliminarjButton.setBounds(new Rectangle(50, 3, 127, 30));
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(ListadodeMaterialesImportados.this, "Esta seguro que desea eliminar el Material?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					if(comboBox.getSelectedIndex()==10){
					try {
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportados();
						Material u = mediciones.get(pos);
						ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
						ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
						ServicioAduana.EliminarAduanaMaterial(u.getId_material());
						ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
						ServicioMaterial.EliminarMaterial(u.getId_material());
						JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportados();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					if(comboBox.getSelectedIndex()==1){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosBotellas();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosBotellas();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==2){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosCajas();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosCajas();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==3){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosCinturones();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosCinturones();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==4){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosCordonesPlasticos();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosCordonesPlasticos();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==5){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosEstuches();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosEstuches();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==6){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosEtiquetas();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosEtiquetas();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==7){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosLibrito();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosLibrito();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==8){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosMadera();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosMadera();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==9){
						try {
							DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
						    simbolo.setDecimalSeparator(',');
						    simbolo.setGroupingSeparator('.');
							DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosSeparadores();
							Material u = mediciones.get(pos);
							ServicioTransportacionAerea.EliminarTransportacionAereaMaterial(u.getId_material());
							ServicioTerrestre.EliminarTransportacionTerrestreMaterial(u.getId_material());
							ServicioAduana.EliminarAduanaMaterial(u.getId_material());
							ServicioDesaduanizacion.EliminarDesaduanizacionMaterial(u.getId_material());
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesImportadosSeparadores();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
							ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
							ArrayList<Object> columnDataFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
							ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
							ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
							for (int i = 0; i < list.size(); i++) {
								columnDataTipoMaterial.add(list.get(i).getTipomaterial());
								columnDataProveedor.add(list.get(i).getProveedor());					
								columnDataFactura.add(list.get(i).getFactura());
								columnDataFechaFactura.add(list.get(i).getFecha());
								columnDataDescripcion.add(list.get(i).getDescripcion());
								if(list.get(i).getCostounitario()!=0){
									columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
								}else{
									columnDataCostoUnitario.add(null);
								}
								
								if(list.get(i).getCostounitariologistica()!=0){
								columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
								}else{
									columnDataCostoUnitarioLogistica.add(null);	
								}
								}
							tb.setRowCount(list.size());
							tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
							tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
							tb.addColumn("No. Factura",columnDataFactura.toArray());
							tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
							tb.addColumn("Descripción",columnDataDescripcion.toArray());		
							tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
							tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
							getJTable().setModel(tb);
							getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
							getJTable().setRowHeight(20);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(ListadodeMaterialesImportados.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					EliminarjButton.setEnabled(false);
					VerDatosjButton.setEnabled(false);
					jButton1.setEnabled(false);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					}
				}
			});
		}
		return EliminarjButton;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
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
			jButton.setBounds(new Rectangle(921, 3, 143, 30));
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
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJButton(), null);
			jPanel.add(getCerrarjButton(), null);
			jPanel.add(getVerDatosjButton(), null);
			jPanel.add(getEliminarjButton(), null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(395, 3, 332, 30));
			jButton1.setText("Gestionar Datos de Transportación y Costo Total");
			jButton1.setIcon(new ImageIcon(getClass().getResource("/Img/system-search.png")));
			jButton1.setEnabled(false);
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int pos = jTable.getSelectedRow();
					if(comboBox.getSelectedIndex()==1){
					try {
					LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosBotellas();
						Material u = mediciones.get(pos);
						new GestionarMaterialExtranjeroVisual(u).setVisible(true);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					if(comboBox.getSelectedIndex()==2){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosCajas();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==3){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosCinturones();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==4){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosCordonesPlasticos();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==5){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosEstuches();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==6){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosEtiquetas();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==7){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosLibrito();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==8){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosMadera();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==9){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportadosSeparadores();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==10){
						try {
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesImportados();
							Material u = mediciones.get(pos);
							new GestionarMaterialExtranjeroVisual(u).setVisible(true);
							dispose();
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
		return jButton1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);		
			JLabel lblTipoMaterial = new JLabel("Tipo Material:");
			lblTipoMaterial.setBounds(12, 13, 175, 16);
			panel.add(lblTipoMaterial);
			panel.add(comBox());
			
		}
		return panel;
	}
	
	private JComboBox comBox(){
		comboBox = new JComboBox();
		comboBox.setBounds(12, 36, 232, 22);
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
		comboBox.setModel(boxModelTipo);
	
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==0){
					EliminarjButton.setEnabled(false);
					VerDatosjButton.setEnabled(false);
					jButton1.setEnabled(false);
					TableModel tb=new TableModel();
					ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
					ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
					ArrayList<Object> columnDataFactura = new ArrayList<Object>();
					ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
					ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
					ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
					ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
					tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
					tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
					tb.addColumn("No. Factura",columnDataFactura.toArray());
					tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
					tb.addColumn("Descripción",columnDataDescripcion.toArray());		
					tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
					tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
					getJTable().setModel(tb);
					getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
					getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==1){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosBotellas();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==2){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosCajas();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==3){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosCinturones();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==4){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosCordonesPlasticos();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==5){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosEstuches();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==6){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosEtiquetas();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==7){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosLibrito();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==8){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosMadera();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				
				if(comboBox.getSelectedIndex()==9){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportadosSeparadores();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
				if(comboBox.getSelectedIndex()==10){
					DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
				    simbolo.setDecimalSeparator(',');
				    simbolo.setGroupingSeparator('.');
					DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
					TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesImportados();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ArrayList<Object>  columnDataTipoMaterial = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();			
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMaterial.add(list.get(i).getTipomaterial());
							columnDataProveedor.add(list.get(i).getProveedor());					
							columnDataFactura.add(list.get(i).getFactura());
							columnDataFechaFactura.add(list.get(i).getFecha());
							columnDataDescripcion.add(list.get(i).getDescripcion());
							if(list.get(i).getCostounitario()!=0){
								columnDataCostoUnitario.add(dosDigitos.format(list.get(i).getCostounitario()));
							}else{
								columnDataCostoUnitario.add(null);
							}
							
							if(list.get(i).getCostounitariologistica()!=0){
							columnDataCostoUnitarioLogistica.add(dosDigitos.format(list.get(i).getCostounitariologistica()));
							}else{
								columnDataCostoUnitarioLogistica.add(null);	
							}
							}
						tb.setRowCount(list.size());
						tb.addColumn("Tipo Material",columnDataTipoMaterial.toArray());
						tb.addColumn("Nombre del Proveedor",columnDataProveedor.toArray());					
						tb.addColumn("No. Factura",columnDataFactura.toArray());
						tb.addColumn("Fecha Factura",columnDataFechaFactura.toArray());
						tb.addColumn("Descripción",columnDataDescripcion.toArray());		
						tb.addColumn("Costo Unitario",columnDataCostoUnitario.toArray());
						tb.addColumn("Costo con 10% por Gastos de Logística",columnDataCostoUnitarioLogistica.toArray());		
						getJTable().setModel(tb);
						getJTable().setDefaultRenderer (Object.class, new FormatoTabla());	
						getJTable().setRowHeight(20);
				}
			}
		});
		return comboBox;
		
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
