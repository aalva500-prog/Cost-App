package visuals;

import java.awt.Dimension;
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

import model.MateriaPrima;
import model.TipoMateria;
import services.ServicioAduana;
import services.ServicioDesaduanizacion;
import services.ServicioMateriaPrima;
import services.ServicioTerrestre;
import services.ServicioTipoMateria;
import services.ServicioTransportacionAerea;
import Utils.FormatoTabla;
import Utils.TableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadodeMateriasPrimasExtranjeras extends JFrame {

	
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
	private MateriaPrima mp=null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JPanel jPanel = null;
	private JPanel panel;
	private JLabel lblTipoDeMateria;
	private JComboBox comboBox;

	public ListadodeMateriasPrimasExtranjeras() {
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
		this.setSize(new Dimension(1174, 759));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setTitle("Listado de Materias Primas Importadas");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJContentPane());
		EliminarjButton.setEnabled(false);
		VerDatosjButton.setEnabled(false);
		jButton1.setEnabled(false);
		TableModel tb=new TableModel();
		ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
		ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
		ArrayList<Object> columnDataFactura = new ArrayList<Object>();
		ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
		ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
		ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
		ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();		
		tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
			gbl_jContentPane.columnWidths = new int[]{1121, 0};
			gbl_jContentPane.rowHeights = new int[]{80, 527, 62, 0};
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
			CerrarjButton.setText("Insertar Materia Prima");
			CerrarjButton.setBounds(new Rectangle(715, 17, 183, 30));
			CerrarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/go-previous.png")));
			CerrarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new InsertarMateriaPrimaExtranjeraVisual().setVisible(true);
					dispose();
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
			VerDatosjButton.setText("Gestionar Datos de Transportación y Costo Total");
			VerDatosjButton.setBounds(new Rectangle(370, 17, 334, 30));
			VerDatosjButton.setIcon(new ImageIcon(getClass().getResource("/Img/system-search.png")));
			VerDatosjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int pos = jTable.getSelectedRow();	
					if(comboBox.getSelectedIndex()==3){
						LinkedList<MateriaPrima> toneles;
						try {
							toneles = ServicioMateriaPrima.getMateriasPrimasExtranjeras();
							MateriaPrima t = toneles.get(pos);	
							mp=t;
							dispose();
							new GestionarMateriaPrimaExtranjeraVisual(mp).setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==1){
						LinkedList<MateriaPrima> toneles;
						try {
							toneles = ServicioMateriaPrima.getMateriasPrimasExtranjerasAlcoholicas();
							MateriaPrima t = toneles.get(pos);	
							mp=t;
							dispose();
							new GestionarMateriaPrimaExtranjeraVisual(mp).setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==2){
						LinkedList<MateriaPrima> toneles;
						try {
							toneles = ServicioMateriaPrima.getMateriasPrimasExtranjerasNoAlcoholicas();
							MateriaPrima t = toneles.get(pos);	
							mp=t;
							dispose();
							new GestionarMateriaPrimaExtranjeraVisual(mp).setVisible(true);
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
			EliminarjButton.setBounds(new Rectangle(14, 17, 144, 30));
			EliminarjButton.setIcon(new ImageIcon(getClass().getResource("/Img/edit-cut.png")));
			EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(ListadodeMateriasPrimasExtranjeras.this, "Esta seguro que desea eliminar la Materia Prima?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION){
						if(comboBox.getSelectedIndex()==3){
					int pos = jTable.getSelectedRow();
					try {
						DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
					    simbolo.setDecimalSeparator(',');
					    simbolo.setGroupingSeparator('.');
						DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
						LinkedList<MateriaPrima> mediciones = ServicioMateriaPrima.getMateriasPrimasExtranjeras();
						MateriaPrima u = mediciones.get(pos);
						ServicioTransportacionAerea.EliminarTransportacionAereaMateriaPrima(u.getId_Materia());
						ServicioTerrestre.EliminarTransportacionTerrestreMateriaPrima(u.getId_Materia());
						ServicioAduana.EliminarAduanaMateriaPrima(u.getId_Materia());
						ServicioDesaduanizacion.EliminarDesaduanizacionMateriaPrima(u.getId_Materia());
						ServicioMateriaPrima.EliminarMateriaPrima(u.getId_Materia());
						JOptionPane.showMessageDialog(ListadodeMateriasPrimasExtranjeras.this, "Materia Prima Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
						TableModel tb=new TableModel();
						LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
						try {
							list =ServicioMateriaPrima.getMateriasPrimasExtranjeras();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();
						
						for (int i = 0; i < list.size(); i++) {
							columnDataTipoMateria.add(list.get(i).getTipomateriaprima());
							columnDataProveedor.add(list.get(i).getNombreproveedor());					
							columnDataFactura.add(list.get(i).getNumerofactura());
							columnDataFechaFactura.add(list.get(i).getFechafactura());
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
						tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
							JOptionPane.showMessageDialog(ListadodeMateriasPrimasExtranjeras.this, "No se puede eliminar el Producto porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						}
						if(comboBox.getSelectedIndex()==1){
							int pos = jTable.getSelectedRow();
							try {
								DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
							    simbolo.setDecimalSeparator(',');
							    simbolo.setGroupingSeparator('.');
								DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
								LinkedList<MateriaPrima> mediciones = ServicioMateriaPrima.getMateriasPrimasExtranjerasAlcoholicas();
								MateriaPrima u = mediciones.get(pos);
								ServicioTransportacionAerea.EliminarTransportacionAereaMateriaPrima(u.getId_Materia());
								ServicioTerrestre.EliminarTransportacionTerrestreMateriaPrima(u.getId_Materia());
								ServicioAduana.EliminarAduanaMateriaPrima(u.getId_Materia());
								ServicioDesaduanizacion.EliminarDesaduanizacionMateriaPrima(u.getId_Materia());
								ServicioMateriaPrima.EliminarMateriaPrima(u.getId_Materia());
								JOptionPane.showMessageDialog(ListadodeMateriasPrimasExtranjeras.this, "Materia Prima Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
								TableModel tb=new TableModel();
								LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
								try {
									list =ServicioMateriaPrima.getMateriasPrimasExtranjerasAlcoholicas();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
								ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
								ArrayList<Object> columnDataFactura = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
								ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
								ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
								ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();
								
								for (int i = 0; i < list.size(); i++) {
									columnDataTipoMateria.add(list.get(i).getTipomateriaprima());
									columnDataProveedor.add(list.get(i).getNombreproveedor());					
									columnDataFactura.add(list.get(i).getNumerofactura());
									columnDataFechaFactura.add(list.get(i).getFechafactura());
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
								tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
									JOptionPane.showMessageDialog(ListadodeMateriasPrimasExtranjeras.this, "No se puede eliminar el Producto porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								}
						if(comboBox.getSelectedIndex()==2){
							int pos = jTable.getSelectedRow();
							try {
								DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
							    simbolo.setDecimalSeparator(',');
							    simbolo.setGroupingSeparator('.');
								DecimalFormat dosDigitos = new DecimalFormat( "###,###.#####",simbolo);
								LinkedList<MateriaPrima> mediciones = ServicioMateriaPrima.getMateriasPrimasExtranjerasNoAlcoholicas();
								MateriaPrima u = mediciones.get(pos);
								ServicioTransportacionAerea.EliminarTransportacionAereaMateriaPrima(u.getId_Materia());
								ServicioTerrestre.EliminarTransportacionTerrestreMateriaPrima(u.getId_Materia());
								ServicioAduana.EliminarAduanaMateriaPrima(u.getId_Materia());
								ServicioDesaduanizacion.EliminarDesaduanizacionMateriaPrima(u.getId_Materia());
								ServicioMateriaPrima.EliminarMateriaPrima(u.getId_Materia());
								JOptionPane.showMessageDialog(ListadodeMateriasPrimasExtranjeras.this, "Materia Prima Eliminada", "Información", JOptionPane.INFORMATION_MESSAGE);
								TableModel tb=new TableModel();
								LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
								try {
									list =ServicioMateriaPrima.getMateriasPrimasExtranjerasNoAlcoholicas();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
								ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
								ArrayList<Object> columnDataFactura = new ArrayList<Object>();
								ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
								ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
								ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
								ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();
								
								for (int i = 0; i < list.size(); i++) {
									columnDataTipoMateria.add(list.get(i).getTipomateriaprima());
									columnDataProveedor.add(list.get(i).getNombreproveedor());					
									columnDataFactura.add(list.get(i).getNumerofactura());
									columnDataFechaFactura.add(list.get(i).getFechafactura());
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
								tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
									JOptionPane.showMessageDialog(ListadodeMateriasPrimasExtranjeras.this, "No se puede eliminar el Producto porque Existen relaciones con el mismo", "Error", JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								}
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
			jButton.setBounds(new Rectangle(909, 17, 165, 30));
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
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Ver Datos Principales");
			jButton1.setBounds(new Rectangle(167, 17, 186, 30));
			jButton1.setIcon(new ImageIcon(getClass().getResource("/Img/system-search.png")));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int pos = jTable.getSelectedRow();	
					if(comboBox.getSelectedIndex()==3){
					LinkedList<MateriaPrima> toneles;
					try {
						toneles = ServicioMateriaPrima.getMateriasPrimasExtranjeras();
						MateriaPrima t = toneles.get(pos);	
						mp=t;
						dispose();
						new ModificarMateriaPrimaExtranjeraVisual(mp).setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					if(comboBox.getSelectedIndex()==1){
						LinkedList<MateriaPrima> toneles;
						try {
							toneles = ServicioMateriaPrima.getMateriasPrimasExtranjerasAlcoholicas();
							MateriaPrima t = toneles.get(pos);	
							mp=t;
							dispose();
							new ModificarMateriaPrimaExtranjeraVisual(mp).setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					if(comboBox.getSelectedIndex()==2){
						LinkedList<MateriaPrima> toneles;
						try {
							toneles = ServicioMateriaPrima.getMateriasPrimasExtranjerasNoAlcoholicas();
							MateriaPrima t = toneles.get(pos);	
							mp=t;
							dispose();
							new ModificarMateriaPrimaExtranjeraVisual(mp).setVisible(true);
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
			jPanel.add(getEliminarjButton(), null);
			jPanel.add(getVerDatosjButton(), null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblTipoDeMateria());
			panel.add(getComboBox());
		}
		return panel;
	}
	private JLabel getLblTipoDeMateria() {
		if (lblTipoDeMateria == null) {
			lblTipoDeMateria = new JLabel();
			lblTipoDeMateria.setText(" Tipo de Materia Prima:");
			lblTipoDeMateria.setBounds(new Rectangle(995, 150, 144, 26));
			lblTipoDeMateria.setBounds(12, 13, 144, 26);
		}
		return lblTipoDeMateria;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedIndex()==0){
						EliminarjButton.setEnabled(false);
						VerDatosjButton.setEnabled(false);
						jButton1.setEnabled(false);
						TableModel tb=new TableModel();
						ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
						ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
						ArrayList<Object> columnDataFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
						ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
						ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();		
						tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
                		LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
                		try {
                			list =ServicioMateriaPrima.getMateriasPrimasExtranjerasAlcoholicas();
                		} catch (SQLException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		} catch (ClassNotFoundException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		}
                		ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
                		ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
                		ArrayList<Object> columnDataFactura = new ArrayList<Object>();
                		ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
                		ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
                		ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
                		ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();
                		
                		for (int i = 0; i < list.size(); i++) {
                			columnDataTipoMateria.add(list.get(i).getTipomateriaprima());
                			columnDataProveedor.add(list.get(i).getNombreproveedor());					
                			columnDataFactura.add(list.get(i).getNumerofactura());
                			columnDataFechaFactura.add(list.get(i).getFechafactura());
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
                		tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
                		LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
                		try {
                			list =ServicioMateriaPrima.getMateriasPrimasExtranjerasNoAlcoholicas();
                		} catch (SQLException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		} catch (ClassNotFoundException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		}
                		ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
                		ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
                		ArrayList<Object> columnDataFactura = new ArrayList<Object>();
                		ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
                		ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
                		ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
                		ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();
                		
                		for (int i = 0; i < list.size(); i++) {
                			columnDataTipoMateria.add(list.get(i).getTipomateriaprima());
                			columnDataProveedor.add(list.get(i).getNombreproveedor());					
                			columnDataFactura.add(list.get(i).getNumerofactura());
                			columnDataFechaFactura.add(list.get(i).getFechafactura());
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
                		tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
                		LinkedList<MateriaPrima> list = new LinkedList<MateriaPrima>();
                		try {
                			list =ServicioMateriaPrima.getMateriasPrimasExtranjeras();
                		} catch (SQLException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		} catch (ClassNotFoundException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		}
                		ArrayList<Object> columnDataTipoMateria = new ArrayList<Object>();
                		ArrayList<Object> columnDataProveedor = new ArrayList<Object>();					
                		ArrayList<Object> columnDataFactura = new ArrayList<Object>();
                		ArrayList<Object> columnDataFechaFactura = new ArrayList<Object>();
                		ArrayList<Object> columnDataDescripcion= new ArrayList<Object>();
                		ArrayList<Object> columnDataCostoUnitario= new ArrayList<Object>();
                		ArrayList<Object> columnDataCostoUnitarioLogistica= new ArrayList<Object>();
                		
                		for (int i = 0; i < list.size(); i++) {
                			columnDataTipoMateria.add(list.get(i).getTipomateriaprima());
                			columnDataProveedor.add(list.get(i).getNombreproveedor());					
                			columnDataFactura.add(list.get(i).getNumerofactura());
                			columnDataFechaFactura.add(list.get(i).getFechafactura());
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
                		tb.addColumn("Tipo Materia Prima",columnDataTipoMateria.toArray());
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
			comboBox.setBounds(new Rectangle(995, 174, 144, 26));
			comboBox.setBounds(12, 37, 144, 26);
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
			
			comboBox.setModel(boxModel2);
		}
		return comboBox;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
