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
import services.ServicioMaterial;
import services.ServicioTipoMaterial;
import Utils.FormatoTabla;
import Utils.TableModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadodeMaterialesNacionales extends JFrame {

	
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
	private JPanel panel;
	private JLabel label;
	private JComboBox comboBox;

	public ListadodeMaterialesNacionales() {
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
		this.setTitle("Listado de Materiales de Origen Nacional");
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
			gbl_jContentPane.columnWidths = new int[]{1130, 0};
			gbl_jContentPane.rowHeights = new int[]{57, 547, 47, 0};
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
			CerrarjButton.setBounds(new Rectangle(360, 5, 153, 30));
			CerrarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/go-previous.png")));
			CerrarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new InsertarMaterialNacionalVisual().setVisible(true);
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
			VerDatosjButton.setText("Ver Datos");
			VerDatosjButton.setBounds(new Rectangle(217, 5, 127, 30));
			VerDatosjButton.setIcon(new ImageIcon(getClass().getResource("/Img/system-search.png")));
			VerDatosjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int pos = jTable.getSelectedRow();
					if(comboBox.getSelectedIndex()==10){
					LinkedList<Material> mediciones;
					try {
						mediciones = ServicioMaterial.getMaterialesNacionales();
						Material u = mediciones.get(pos);
						new ModificarMaterialNacionalVisual(u).setVisible(true);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					if(comboBox.getSelectedIndex()==1){
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesBotellas();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesCajas();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesCinturones();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesCordones();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesEstuches();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesEtiquetas();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesLibrito();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesMadera();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
						LinkedList<Material> mediciones;
						try {
							mediciones = ServicioMaterial.getMaterialesNacionalesSeparadores();
							Material u = mediciones.get(pos);
							new ModificarMaterialNacionalVisual(u).setVisible(true);
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
			EliminarjButton.setBounds(new Rectangle(67, 5, 127, 30));
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(ListadodeMaterialesNacionales.this, "Esta seguro que desea eliminar el Material?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
					int pos = jTable.getSelectedRow();
					if(comboBox.getSelectedIndex()==10){
					try {
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionales();
						Material u = mediciones.get(pos);
						ServicioMaterial.EliminarMaterial(u.getId_material());
						JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
						TableModel tb=new TableModel();
						LinkedList<Material> list = new LinkedList<Material>();
						try {
							list =ServicioMaterial.getMaterialesNacionales();
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
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesBotellas();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesBotellas();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesCajas();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesCajas();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesCinturones();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesCinturones();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesCordones();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesCordones();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesEstuches();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesEstuches();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesEtiquetas();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesEtiquetas();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesLibrito();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesLibrito();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesMadera();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesMadera();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
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
							LinkedList<Material> mediciones = ServicioMaterial.getMaterialesNacionalesSeparadores();
							Material u = mediciones.get(pos);
							ServicioMaterial.EliminarMaterial(u.getId_material());
							JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "Material Eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
							TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesSeparadores();
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
								JOptionPane.showMessageDialog(ListadodeMaterialesNacionales.this, "No se puede eliminar el Material porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					EliminarjButton.setEnabled(false);
					VerDatosjButton.setEnabled(false);
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
			jButton.setBounds(new Rectangle(525, 5, 143, 30));
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
		}
		return jPanel;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getComboBox());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Tipo Material:");
			label.setBounds(0, 0, 175, 16);
		}
		return label;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(0, 23, 232, 22);
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
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedIndex()==0){
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
					}
					if(comboBox.getSelectedIndex()==1){
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						TableModel tb=new TableModel();
							LinkedList<Material> list = new LinkedList<Material>();
							try {
								list =ServicioMaterial.getMaterialesNacionalesBotellas();
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
								list =ServicioMaterial.getMaterialesNacionalesCajas();
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
								list =ServicioMaterial.getMaterialesNacionalesCinturones();
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
								list =ServicioMaterial.getMaterialesNacionalesCordones();
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
								list =ServicioMaterial.getMaterialesNacionalesEstuches();
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
								list =ServicioMaterial.getMaterialesNacionalesEtiquetas();
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
								list =ServicioMaterial.getMaterialesNacionalesLibrito();
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
								list =ServicioMaterial.getMaterialesNacionalesMadera();
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
								list =ServicioMaterial.getMaterialesNacionalesSeparadores();
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
								list =ServicioMaterial.getMaterialesNacionales();
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
			
		}
		return comboBox;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
