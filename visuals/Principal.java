package visuals;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.JRException;

import Utils.CurrentUser;
import Utils.Idioma;
import Utils.Reportes;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;



public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar mainMenuBar = null;

	private JMenu FileMenu = null;

	private JMenuItem jMenuItem1 = null;
	private Started owner = null;

	private JMenuItem jMenuItemAutenticar = null;

	private JMenu GestionjMenu1 = null;

	private JMenuItem UsuariosjMenuItem = null;

	private JLabel jLabel;

	private JMenuItem jMenuItemBackup = null;

	private JMenu OrigenjMenu = null;

	private JMenu OrigenExtranjerojMenu = null;

	private JMenuItem MateriaPrimajMenuItem = null;

	private JMenuItem MateriasPrimasjMenuItem = null;

	private JMenuItem MateriasPrimajMenuItem = null;

	private JMenuItem jMenuItem = null;

	private JMenu ListadosjMenu = null;

	private JMenuItem MateriasPrimasAlcoholicasjMenuItem2 = null;

	private JMenuItem MateriasPrimasNoAlcoholicasjMenuItem2 = null;

	private JMenuItem MateriasPrimasAlcoholicasNacionaljMenuItem2 = null;

	private JMenuItem MateriasPrimasAlcoholicasImportadasjMenuItem2 = null;

	private JMenuItem MateriasPrimasNoAlcoholicasNacionaljMenuItem2 = null;

	private JMenuItem MateriasPrimasNoAlcoholicasImportadasjMenuItem2 = null;

	private JMenuItem jMenuItem2 = null;

	private JMenuItem MaterialesImportadosjMenuItem3 = null;

	private JMenuItem TodoslosmaterialesjMenuItem3 = null;

	/**
	 * This is the default constructor
	 */
	public Principal(Started parent) {
		super();
		this.owner = parent;
		initialize();
		}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(new Dimension(814, 688));	
		this.setContentPane(getJContentPane());
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/descarga.png")));
		this.setJMenuBar(getMainMenuBar());
		this.setTitle("Principal");
		this.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowClosed(java.awt.event.WindowEvent e) {    
				getOwner().dispose();
			}
			public void windowOpened(java.awt.event.WindowEvent e) {
				if(CurrentUser.getCurrentUser().getSessionUser().getRol().equals("Administrador")){
					getUsuariosjMenuItem().setVisible(true);
				}
				if(CurrentUser.getCurrentUser().getSessionUser().getRol().equals("Invitado")){
					getUsuariosjMenuItem().setVisible(false);
				}
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
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("/Img/costes-de-produccion-5.jpg")));
			jContentPane.add(jLabel, gridBagConstraints);
			}
		return jContentPane;
	}

	/**
	 * This method initializes mainMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMainMenuBar() {
		if (mainMenuBar == null) {
			mainMenuBar = new JMenuBar();
			mainMenuBar.add(getFileMenu());
			mainMenuBar.add(getGestionjMenu1());
			mainMenuBar.add(getListadosjMenu());
			}
		return mainMenuBar;
	}

	/**
	 * This method initializes FileMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (FileMenu == null) {
			FileMenu = new JMenu();
			FileMenu.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_FilesAndFolders_32x32.png")));
			FileMenu.add(getUsuariosjMenuItem());
			FileMenu.add(getJMenuItemAutenticar());
			FileMenu.add(getJMenuItemBackup());
			FileMenu.add(getJMenuItem1());			
		}
		return FileMenu;
	}

	
	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Salir");
			jMenuItem1.setIcon(new ImageIcon(getClass().getResource("/Img/ico_alpha_Delete_16x16.png")));
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(DISPOSE_ON_CLOSE);
				}
			});
		}
		return jMenuItem1;
	}

	public void idioma(){
		if(Idioma.getInstance().getIdioma().equalsIgnoreCase("ingles")){
			FileMenu.setText("File");
			jMenuItem1.setText("Exit");
			jMenuItemAutenticar.setText("Change User");
			UsuariosjMenuItem.setText("Users");
			GestionjMenu1.setText("Management");
			this.setTitle("Main");
			}
		}

	public Principal returnThis(){
		return this;
	}

	public Started getOwner() {
		return owner;
	}

	/**
	 * This method initializes jMenuItemAutenticar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAutenticar() {
		if (jMenuItemAutenticar == null) {
			jMenuItemAutenticar = new JMenuItem();
			jMenuItemAutenticar.setText("Cambiar Usuario");
			jMenuItemAutenticar.setIcon(new ImageIcon(getClass().getResource("/Img/edit_user.png")));
			jMenuItemAutenticar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
					Started r = new Started();
					r.setVisible(true);
				}
			});
		}
		return jMenuItemAutenticar;
	}

	/**
	 * This method initializes GestionjMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getGestionjMenu1() {
		if (GestionjMenu1 == null) {
			GestionjMenu1 = new JMenu();
			GestionjMenu1.setIcon(new ImageIcon(getClass().getResource("/Img/ICONO-producto.png")));
			GestionjMenu1.add(getOrigenjMenu());
			GestionjMenu1.add(getOrigenExtranjerojMenu());
		}
		return GestionjMenu1;
	}

	/**
	 * This method initializes UsuariosjMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getUsuariosjMenuItem() {
		if (UsuariosjMenuItem == null) {
			UsuariosjMenuItem = new JMenuItem();
			UsuariosjMenuItem.setText("Usuarios");
			UsuariosjMenuItem.setIcon(new ImageIcon(getClass().getResource("/Img/add_user.png")));
			UsuariosjMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new Usuarios(Principal.this,true).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()	
				}
			});
		}
		return UsuariosjMenuItem;
	}

	/**
	 * This method initializes jMenuItemBackup	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemBackup() {
		if (jMenuItemBackup == null) {
			jMenuItemBackup = new JMenuItem();
			jMenuItemBackup.setText("Backup");
			jMenuItemBackup.setIcon(new ImageIcon(getClass().getResource("/Img/save_edit.png")));
			jMenuItemBackup.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new Backup(Principal.this,true).setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()					
				}
			});
		}
		return jMenuItemBackup;
	}

	/**
	 * This method initializes OrigenjMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getOrigenjMenu() {
		if (OrigenjMenu == null) {
			OrigenjMenu = new JMenu();
			OrigenjMenu.setText("Origen Nacional");
			OrigenjMenu.setIcon(new ImageIcon(getClass().getResource("/Img/images.png")));
			OrigenjMenu.add(getMateriaPrimajMenuItem());
			OrigenjMenu.add(getJMenuItem());
		}
		return OrigenjMenu;
	}

	/**
	 * This method initializes OrigenExtranjerojMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getOrigenExtranjerojMenu() {
		if (OrigenExtranjerojMenu == null) {
			OrigenExtranjerojMenu = new JMenu();
			OrigenExtranjerojMenu.setText("Origen Extranjero");
			OrigenExtranjerojMenu.setIcon(new ImageIcon(getClass().getResource("/Img/f_65554456-f21f48e2.png")));
			OrigenExtranjerojMenu.add(getMateriasPrimasjMenuItem());
			OrigenExtranjerojMenu.add(getMateriasPrimajMenuItem());
		}
		return OrigenExtranjerojMenu;
	}

	/**
	 * This method initializes MateriaPrimajMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriaPrimajMenuItem() {
		if (MateriaPrimajMenuItem == null) {
			MateriaPrimajMenuItem = new JMenuItem();
			MateriaPrimajMenuItem.setIcon(new ImageIcon(getClass().getResource("/Img/red-de-voley-md-materiales-deportivos-la-plata_MLA-F-2941178692_072012.png")));
			MateriaPrimajMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new InsertarMaterialNacionalVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MateriaPrimajMenuItem;
	}

	/**
	 * This method initializes MateriasPrimasjMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasjMenuItem() {
		if (MateriasPrimasjMenuItem == null) {
			MateriasPrimasjMenuItem = new JMenuItem();
			MateriasPrimasjMenuItem.setIcon(new ImageIcon(getClass().getResource("/Img/red-de-voley-md-materiales-deportivos-la-plata_MLA-F-2941178692_072012.png")));
			MateriasPrimasjMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
					new InsertarMaterialImportadoVisual().setVisible(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MateriasPrimasjMenuItem;
	}

	/**
	 * This method initializes MateriasPrimajMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimajMenuItem() {
		if (MateriasPrimajMenuItem == null) {
			MateriasPrimajMenuItem = new JMenuItem();
			MateriasPrimajMenuItem.setIcon(new ImageIcon(getClass().getResource("/Img/Materias_primas.png")));
			MateriasPrimajMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new InsertarMateriaPrimaExtranjeraVisual().setVisible(true);
					dispose();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return MateriasPrimajMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
     		jMenuItem.setIcon(new ImageIcon(getClass().getResource("/Img/Materias_primas.png")));
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new InsertarMateriaPrimaNacionalVisual().setVisible(true);
					dispose();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes ListadosjMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getListadosjMenu() {
		if (ListadosjMenu == null) {
			ListadosjMenu = new JMenu();
			ListadosjMenu.setIcon(new ImageIcon(getClass().getResource("/Img/ReportesAnuales.png")));
			ListadosjMenu.add(getMateriasPrimasAlcoholicasjMenuItem2());
			ListadosjMenu.add(getMateriasPrimasAlcoholicasNacionaljMenuItem2());
			ListadosjMenu.add(getMateriasPrimasAlcoholicasImportadasjMenuItem2());
			ListadosjMenu.add(getMateriasPrimasNoAlcoholicasjMenuItem2());
			ListadosjMenu.add(getMateriasPrimasNoAlcoholicasNacionaljMenuItem2());
			ListadosjMenu.add(getMateriasPrimasNoAlcoholicasImportadasjMenuItem2());
			ListadosjMenu.add(getJMenuItem2());
			ListadosjMenu.add(getMaterialesImportadosjMenuItem3());
			ListadosjMenu.add(getTodoslosmaterialesjMenuItem3());
		}
		return ListadosjMenu;
	}

	/**
	 * This method initializes MateriasPrimasAlcoholicasjMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasAlcoholicasjMenuItem2() {
		if (MateriasPrimasAlcoholicasjMenuItem2 == null) {
			MateriasPrimasAlcoholicasjMenuItem2 = new JMenuItem();
			MateriasPrimasAlcoholicasjMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/Las-bebidas-alcohólicas-y-sus-calorías.png")));
			MateriasPrimasAlcoholicasjMenuItem2.setText("Materias Primas Alcohólicas");
			MateriasPrimasAlcoholicasjMenuItem2.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().ListadoMateriasPrimasAlcoholicas();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MateriasPrimasAlcoholicasjMenuItem2;
	}

	/**
	 * This method initializes MateriasPrimasNoAlcoholicasjMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasNoAlcoholicasjMenuItem2() {
		if (MateriasPrimasNoAlcoholicasjMenuItem2 == null) {
			MateriasPrimasNoAlcoholicasjMenuItem2 = new JMenuItem();
			MateriasPrimasNoAlcoholicasjMenuItem2.setText("Materias Primas No Alcohólicas");
			MateriasPrimasNoAlcoholicasjMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/no-alcohol.png")));
			MateriasPrimasNoAlcoholicasjMenuItem2.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().ListadoMateriasPrimasNoAlcoholicas();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MateriasPrimasNoAlcoholicasjMenuItem2;
	}

	/**
	 * This method initializes MateriasPrimasAlcoholicasNacionaljMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasAlcoholicasNacionaljMenuItem2() {
		if (MateriasPrimasAlcoholicasNacionaljMenuItem2 == null) {
			MateriasPrimasAlcoholicasNacionaljMenuItem2 = new JMenuItem();
			MateriasPrimasAlcoholicasNacionaljMenuItem2.setText("Materias Primas Alcohólicas de Origen Nacional");
			MateriasPrimasAlcoholicasNacionaljMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/Las-bebidas-alcohólicas-y-sus-calorías.png")));
			MateriasPrimasAlcoholicasNacionaljMenuItem2.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().ListadoMateriasPrimasAlcoholicasdeOrigenNAcional();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MateriasPrimasAlcoholicasNacionaljMenuItem2;
	}

	/**
	 * This method initializes MateriasPrimasAlcoholicasImportadasjMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasAlcoholicasImportadasjMenuItem2() {
		if (MateriasPrimasAlcoholicasImportadasjMenuItem2 == null) {
			MateriasPrimasAlcoholicasImportadasjMenuItem2 = new JMenuItem();
			MateriasPrimasAlcoholicasImportadasjMenuItem2.setText("Materias Primas Alcohólicas Importadas");
			MateriasPrimasAlcoholicasImportadasjMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/Las-bebidas-alcohólicas-y-sus-calorías.png")));
			MateriasPrimasAlcoholicasImportadasjMenuItem2
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().ListadoMateriasPrimasAlcoholicasImportadas();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MateriasPrimasAlcoholicasImportadasjMenuItem2;
	}

	/**
	 * This method initializes MateriasPrimasNoAlcoholicasNacionaljMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasNoAlcoholicasNacionaljMenuItem2() {
		if (MateriasPrimasNoAlcoholicasNacionaljMenuItem2 == null) {
			MateriasPrimasNoAlcoholicasNacionaljMenuItem2 = new JMenuItem();
			MateriasPrimasNoAlcoholicasNacionaljMenuItem2.setText("Materias Primas  No Alcohólicas de Origen Nacional");
			MateriasPrimasNoAlcoholicasNacionaljMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/no-alcohol.png")));
			MateriasPrimasNoAlcoholicasNacionaljMenuItem2.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().ListadoMateriasPrimasNoAlcoholicasdeOrigenNAcional();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MateriasPrimasNoAlcoholicasNacionaljMenuItem2;
	}

	/**
	 * This method initializes MateriasPrimasNoAlcoholicasImportadasjMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMateriasPrimasNoAlcoholicasImportadasjMenuItem2() {
		if (MateriasPrimasNoAlcoholicasImportadasjMenuItem2 == null) {
			MateriasPrimasNoAlcoholicasImportadasjMenuItem2 = new JMenuItem();
			MateriasPrimasNoAlcoholicasImportadasjMenuItem2.setText("Materias Primas No Alcohólicas Importadas");
			MateriasPrimasNoAlcoholicasImportadasjMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/no-alcohol.png")));
			MateriasPrimasNoAlcoholicasImportadasjMenuItem2.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().ListadoMateriasPrimasNoAlcoholicasImportadas();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MateriasPrimasNoAlcoholicasImportadasjMenuItem2;
	}

	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Materiales de Origen Nacional");
			jMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Img/descarga (1).png")));
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Reportes.getR().MaterialesOrigenNacional();
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes MaterialesImportadosjMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMaterialesImportadosjMenuItem3() {
		if (MaterialesImportadosjMenuItem3 == null) {
			MaterialesImportadosjMenuItem3 = new JMenuItem();
			MaterialesImportadosjMenuItem3.setIcon(new ImageIcon(getClass().getResource("/Img/descarga (1).png")));
			MaterialesImportadosjMenuItem3.setText("Materiales Importados");
			MaterialesImportadosjMenuItem3.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().MaterialesImportados();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return MaterialesImportadosjMenuItem3;
	}

	/**
	 * This method initializes TodoslosmaterialesjMenuItem3	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getTodoslosmaterialesjMenuItem3() {
		if (TodoslosmaterialesjMenuItem3 == null) {
			TodoslosmaterialesjMenuItem3 = new JMenuItem();
			TodoslosmaterialesjMenuItem3.setIcon(new ImageIcon(getClass().getResource("/Img/descarga (1).png")));
			TodoslosmaterialesjMenuItem3.setText("Todos los Materiales");
			TodoslosmaterialesjMenuItem3.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							try {
								Reportes.getR().Materiales();
							} catch (JRException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
						}
					});
		}
		return TodoslosmaterialesjMenuItem3;
	}

	
}  //  @jve:decl-index=0:visual-constraint="364,-12"
