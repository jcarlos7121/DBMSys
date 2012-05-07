import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import javax.swing.JLabel;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;
import java.awt.*;
import java.beans.PropertyVetoException;


public class DBMSysAdministrator extends JFrame {

	//Hola!
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	JTextField usuariofield = null;
	JTextField contraseñafield = null;
	 int sel;
	 JTable tablaempleados = new JTable();
	 JInternalFrame internalFrame;
	 JInternalFrame graficatres;
	 JInternalFrame graficados;
	 JInternalFrame graficacinco;
	 JInternalFrame graficacuatro;
	 Bidi bd;
	 private JTextField textField_1;
	 private JTable table_1;
	 JTable table_2;
	 JTable table_3;
	 int Estado;
	 private JTextField nombretext;
	 private JTextField apellidotext;
	 private JTextField apellidom;
	 private JTextField calletext;
	 private JTextField ciudadtext;
	 private JTextField estadotext;
	 private JTextField paistext;
	 private JTextField emailtext;
	 private JTextField rfctext;
	 private JTextField idtext;
	 private JTextField cargotext;
	 private JTextField empresatext;
	 private JTextField telefonotext;
	 private JTextField paginatext;
	 private JTextField cptext;
	 JRadioButton rdbtnEsEmpresa;
	 JButton btnTransportistas;
	 JButton btnEmpledos;
	 private JTextField textField_2;
	 private JTable table_4;
	 private JTable table_5;
	 private JTable table_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBMSysAdministrator frame = new DBMSysAdministrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DBMSysAdministrator() throws ClassNotFoundException, SQLException {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		
		
		bd = new Bidi("postgres", "132410jh");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Comienza la creaciòn del internal frame de empleado
		
		
		//Termina la creaciòn del internal frame de empleado
		
		//Se crea la segunda grafica, y se convierte en un BufferedImage
		PieDataset datasetGraficados = createSampleDataset();
		BufferedImage graphidos = graphdos(datasetGraficados);
		
		//Se pasa de bufferedImage a una imagen icono grandota y se agrega al label
		ImageIcon imagengraficados = new ImageIcon(graphidos);
		
		
		BufferedImage graphuno = graphuno();
		
		ImageIcon grafiiconuno = new ImageIcon(graphuno);
		
		
		final JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(595, 314, 117, 24);
		btnIniciar.setBorder(new RoundedBorder(35));
		btnIniciar.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				final JButton btnPedidos = new JButton("Pedidos");
				btnPedidos.setBorder(new RoundedBorder(10));
				btnPedidos.setBounds(348, 174, 117, 24);
				contentPane.add(btnPedidos);
				
				final JButton btnClientes = new JButton("Clientes");
				btnClientes.setBorder(new RoundedBorder(20));
				btnClientes.setBounds(581, 117, 117, 24);
				contentPane.add(btnClientes);
				
				final JButton btnProveedores = new JButton("Proveedores");
				btnProveedores.setBorder(new RoundedBorder(20));
				btnProveedores.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						contentPane.removeAll();
						final JInternalFrame proveedoresFrame = new JInternalFrame("Proveedores");
						proveedoresFrame.setClosable(true);
						proveedoresFrame.setResizable(true);
						proveedoresFrame.setBounds(152, 101, 980, 535);
						contentPane.add(proveedoresFrame);
						
						JMenuBar menuBar = new JMenuBar();
						proveedoresFrame.setJMenuBar(menuBar);
						proveedoresFrame.getContentPane().setLayout(null);
						

						
						JButton btnConsultar = new JButton("Consultar");
						btnConsultar.addActionListener(new ActionListener(){
												
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								proveedoresFrame.getContentPane().removeAll();
								
								textField_1 = new JTextField();
								textField_1.setBounds(6, 6, 215, 26);
								proveedoresFrame.getContentPane().add(textField_1);
								textField_1.setColumns(10);
								
								JButton btnBuscar_1 = new JButton("Buscar");
								btnBuscar_1.setBounds(244, 6, 100, 26);
								proveedoresFrame.getContentPane().add(btnBuscar_1);
								
								//Tablas de cada uno
								//General
								table_1 = new JTable();
								table_1.setBounds(12, 41, 947, 422);
								try {
									table_1.setModel(bd.regresamodeloproveedor());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								table_1.setShowGrid(true);
								table_1.setShowVerticalLines(true);
								table_1.setGridColor(Color.black);
								table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
								    public void valueChanged(ListSelectionEvent e) {
								        sel = table_1.getSelectedRow();
								        
								    }
								});
								//Telefonos
								
								table_2 = new JTable();
								table_2 .setBounds(12, 41, 947, 422);
								try {
									table_2.setModel(bd.regresamodeloproveedortels());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								table_2.setShowGrid(true);
								table_2.setShowVerticalLines(true);
								table_2.setGridColor(Color.black);
								
								//Empresa
								table_3 = new JTable();
								table_3 .setBounds(12, 41, 947, 422);
								try {
									table_3.setModel(bd.regresamodeloempresa());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								table_3.setShowGrid(true);
								table_3.setShowVerticalLines(true);
								table_3.setGridColor(Color.black);
								
								JButton btnTelefonos = new JButton("Telefonos");
								btnTelefonos.setBounds(610, 6, 100, 26);
								btnTelefonos.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										
										
										if(Estado == 0){
											proveedoresFrame.getContentPane().remove(table_1);
										}else if(Estado == 3){
											proveedoresFrame.getContentPane().remove(table_3);
										}

										proveedoresFrame.getContentPane().add(table_2);
										Container bli = proveedoresFrame.getContentPane();
										SwingUtilities.updateComponentTreeUI(bli);
										bli.validate();
										Estado = 1;
									}});
								
								proveedoresFrame.getContentPane().add(btnTelefonos);
								
								JButton btnGeneral = new JButton("General");
								btnGeneral.setBounds(466, 6, 100, 26);
								btnGeneral.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										
										if(Estado == 1){
										proveedoresFrame.getContentPane().remove(table_2);
										}else if(Estado == 3){
											proveedoresFrame.getContentPane().remove(table_3);
										}
										
										proveedoresFrame.getContentPane().add(table_1);
										Container bli = proveedoresFrame.getContentPane();
										SwingUtilities.updateComponentTreeUI(bli);
										bli.validate();
										Estado = 0;
										
									}});
								proveedoresFrame.getContentPane().add(btnGeneral);
								
								JButton btnEmpresas = new JButton("Empresas");
								btnEmpresas.setBounds(750, 6, 100, 26);
								btnEmpresas.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										if(Estado == 0){
											proveedoresFrame.getContentPane().remove(table_1);
											}else if(Estado == 1){
												proveedoresFrame.getContentPane().remove(table_2);
											}
										
										proveedoresFrame.getContentPane().add(table_3);
										Container bli = proveedoresFrame.getContentPane();
										SwingUtilities.updateComponentTreeUI(bli);
										bli.validate();
										Estado = 3;
										
									}});
								proveedoresFrame.getContentPane().add(btnEmpresas);
								
								Container bli = proveedoresFrame.getContentPane();
								SwingUtilities.updateComponentTreeUI(bli);
								bli.validate();
							}});
						menuBar.add(btnConsultar);
						
						JButton btnRegistrar = new JButton("Registrar");
						btnRegistrar.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								proveedoresFrame.getContentPane().removeAll();
								
								JLabel lblNombre = new JLabel("Nombre");
								lblNombre.setBounds(40, 54, 60, 14);
								proveedoresFrame.getContentPane().add(lblNombre);
								
								nombretext = new JTextField();
								nombretext.setBounds(128, 48, 122, 26);
								proveedoresFrame.getContentPane().add(nombretext);
								nombretext.setColumns(10);
								
								JLabel lblNewLabel = new JLabel("Apellido P");
								lblNewLabel.setBounds(40, 101, 81, 14);
								proveedoresFrame.getContentPane().add(lblNewLabel);
								
								apellidotext = new JTextField();
								apellidotext.setBounds(128, 95, 122, 26);
								proveedoresFrame.getContentPane().add(apellidotext);
								apellidotext.setColumns(10);
								
								apellidom = new JTextField();
								apellidom.setBounds(128, 145, 122, 26);
								proveedoresFrame.getContentPane().add(apellidom);
								apellidom.setColumns(10);
								
								JLabel lblApellidoM = new JLabel("Apellido M");
								lblApellidoM.setBounds(40, 157, 81, 14);
								proveedoresFrame.getContentPane().add(lblApellidoM);
								
								JLabel lblNewLabel_1 = new JLabel("Calle");
								lblNewLabel_1.setBounds(40, 203, 60, 14);
								proveedoresFrame.getContentPane().add(lblNewLabel_1);
								
								calletext = new JTextField();
								calletext.setBounds(128, 197, 122, 26);
								proveedoresFrame.getContentPane().add(calletext);
								calletext.setColumns(10);
								
								JLabel lblCiudad = new JLabel("Ciudad");
								lblCiudad.setBounds(40, 249, 60, 14);
								proveedoresFrame.getContentPane().add(lblCiudad);
								
								ciudadtext = new JTextField();
								ciudadtext.setBounds(128, 243, 122, 26);
								proveedoresFrame.getContentPane().add(ciudadtext);
								ciudadtext.setColumns(10);
								
								JLabel lblEstado = new JLabel("Estado");
								lblEstado.setBounds(40, 298, 60, 14);
								proveedoresFrame.getContentPane().add(lblEstado);
								
								JLabel lblNewLabel_2 = new JLabel("Pais");
								lblNewLabel_2.setBounds(40, 348, 60, 14);
								proveedoresFrame.getContentPane().add(lblNewLabel_2);
								
								estadotext = new JTextField();
								estadotext.setBounds(128, 292, 122, 26);
								proveedoresFrame.getContentPane().add(estadotext);
								estadotext.setColumns(10);
								
								paistext = new JTextField();
								paistext.setBounds(128, 348, 122, 26);
								proveedoresFrame.getContentPane().add(paistext);
								paistext.setColumns(10);
								
								JLabel lblEmail = new JLabel("Email");
								lblEmail.setBounds(320, 54, 60, 14);
								proveedoresFrame.getContentPane().add(lblEmail);
								
								emailtext = new JTextField();
								emailtext.setBounds(392, 48, 122, 26);
								proveedoresFrame.getContentPane().add(emailtext);
								emailtext.setColumns(10);
								
								JLabel lblNotas = new JLabel("Notas");
								lblNotas.setBounds(320, 107, 60, 14);
								proveedoresFrame.getContentPane().add(lblNotas);
								
								final JTextArea notastext = new JTextArea();
								notastext.setBounds(392, 95, 158, 135);
								proveedoresFrame.getContentPane().add(notastext);
								
								JLabel lblRfc = new JLabel("RFC");
								lblRfc.setBounds(320, 249, 60, 14);
								proveedoresFrame.getContentPane().add(lblRfc);
								
								rfctext = new JTextField();
								rfctext.setBounds(392, 243, 122, 26);
								proveedoresFrame.getContentPane().add(rfctext);
								rfctext.setColumns(10);
								
								JLabel lblIdNum = new JLabel("ID Num");
								lblIdNum.setBounds(40, 16, 60, 14);
								proveedoresFrame.getContentPane().add(lblIdNum);
								
								idtext = new JTextField();
								idtext.setBounds(128, 10, 122, 26);
								proveedoresFrame.getContentPane().add(idtext);
								idtext.setColumns(10);
								
								final JRadioButton rdbtnEsEmpresa = new JRadioButton("Es Empresa");
								rdbtnEsEmpresa.setBounds(394, 372, 130, 18);
								proveedoresFrame.getContentPane().add(rdbtnEsEmpresa);
								
								JButton btnRegistrar_1 = new JButton("Registrar");
								btnRegistrar_1.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										
										if(rdbtnEsEmpresa.isSelected()==true){
											try {
												System.out.println(bd.insertaProveedor(idtext.getText(),nombretext.getText(),apellidotext.getText(),apellidom.getText(),calletext.getText(),ciudadtext.getText(),estadotext.getText(),cptext.getText(),paistext.getText(),emailtext.getText(),notastext.getText(),rfctext.getText(),paginatext.getText()));
												System.out.println(bd.insertaempresa(idtext.getText(),nombretext.getText(),cargotext.getText(),empresatext.getText()));
												System.out.println(bd.insertatelefono(idtext.getText(),telefonotext.getText()));
												JOptionPane.showMessageDialog((Component)e.getSource(), "Registro exitoso");
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
										else{
										try {
											System.out.println(bd.insertaProveedor(idtext.getText(),nombretext.getText(),apellidotext.getText(),apellidom.getText(),calletext.getText(),ciudadtext.getText(),estadotext.getText(),cptext.getText(),paistext.getText(),emailtext.getText(),notastext.getText(),rfctext.getText(),paginatext.getText()));
											System.out.println(bd.insertatelefono(idtext.getText(),telefonotext.getText()));
											JOptionPane.showMessageDialog((Component)e.getSource(), "Registro Exitoso");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											JOptionPane.showMessageDialog((Component)e.getSource(), "Datos Faltantes o Erroneos");
											e1.printStackTrace();
										}
										}
									}});
								btnRegistrar_1.setBounds(724, 310, 100, 26);
								proveedoresFrame.getContentPane().add(btnRegistrar_1);
								
								JLabel lblCargo = new JLabel("Cargo");
								lblCargo.setBounds(639, 54, 60, 14);
								proveedoresFrame.getContentPane().add(lblCargo);
								
								cargotext = new JTextField();
								cargotext.setBounds(711, 48, 122, 26);
								proveedoresFrame.getContentPane().add(cargotext);
								cargotext.setColumns(10);
								
								empresatext = new JTextField();
								empresatext.setBounds(711, 95, 122, 26);
								proveedoresFrame.getContentPane().add(empresatext);
								empresatext.setColumns(10);
								
								JLabel lblEmpresa = new JLabel("Empresa");
								lblEmpresa.setBounds(639, 101, 60, 14);
								proveedoresFrame.getContentPane().add(lblEmpresa);
								
								telefonotext = new JTextField();
								telefonotext.setBounds(392, 292, 122, 26);
								proveedoresFrame.getContentPane().add(telefonotext);
								telefonotext.setColumns(10);
								
								JLabel lblTelefono = new JLabel("Telefono");
								lblTelefono.setBounds(320, 298, 60, 14);
								proveedoresFrame.getContentPane().add(lblTelefono);
								
								paginatext = new JTextField();
								paginatext.setBounds(392, 330, 122, 26);
								proveedoresFrame.getContentPane().add(paginatext);
								paginatext.setColumns(10);
								
								JLabel lblEmail_1 = new JLabel("Pagina Web");
								lblEmail_1.setBounds(280, 336, 100, 14);
								proveedoresFrame.getContentPane().add(lblEmail_1);
								
								JLabel lblCp = new JLabel("CP");
								lblCp.setBounds(40, 407, 60, 14);
								proveedoresFrame.getContentPane().add(lblCp);
								
								cptext = new JTextField();
								cptext.setBounds(128, 401, 122, 26);
								proveedoresFrame.getContentPane().add(cptext);
								cptext.setColumns(10);
								
								//JPanel temp = contentPane;
								Container bli = proveedoresFrame.getContentPane();
								SwingUtilities.updateComponentTreeUI(bli);
								bli.validate();
								
							}});
						menuBar.add(btnRegistrar);
						
						JButton btnModificar_1 = new JButton("Modificar");
						btnModificar_1.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								final String indice = (String) table_1.getValueAt(sel, 0);
								
								proveedoresFrame.getContentPane().removeAll();
								
								JLabel lblNombre = new JLabel("Nombre");
								lblNombre.setBounds(40, 54, 60, 14);
								proveedoresFrame.getContentPane().add(lblNombre);
								
								nombretext = new JTextField();
								nombretext.setBounds(128, 48, 122, 26);
								try {
									nombretext.setText(bd.regresaPNombre(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(nombretext);
								nombretext.setColumns(10);
								
								JLabel lblNewLabel = new JLabel("Apellido P");
								lblNewLabel.setBounds(40, 101, 81, 14);
								proveedoresFrame.getContentPane().add(lblNewLabel);
								
								apellidotext = new JTextField();
								apellidotext.setBounds(128, 95, 122, 26);
								try {
									apellidotext.setText(bd.regresaPApellidoM(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(apellidotext);
								apellidotext.setColumns(10);
								
								apellidom = new JTextField();
								apellidom.setBounds(128, 145, 122, 26);
								try {
									apellidom.setText(bd.regresaPApellidoP(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(apellidom);
								apellidom.setColumns(10);
								
								JLabel lblApellidoM = new JLabel("Apellido M");
								lblApellidoM.setBounds(40, 157, 81, 14);
								proveedoresFrame.getContentPane().add(lblApellidoM);
								
								JLabel lblNewLabel_1 = new JLabel("Calle");
								lblNewLabel_1.setBounds(40, 203, 60, 14);
								proveedoresFrame.getContentPane().add(lblNewLabel_1);
								
								calletext = new JTextField();
								calletext.setBounds(128, 197, 122, 26);
								try {
									calletext.setText(bd.regresaPCalle(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(calletext);
								calletext.setColumns(10);
								
								JLabel lblCiudad = new JLabel("Ciudad");
								lblCiudad.setBounds(40, 249, 60, 14);
								proveedoresFrame.getContentPane().add(lblCiudad);
								
								ciudadtext = new JTextField();
								ciudadtext.setBounds(128, 243, 122, 26);
								try {
									ciudadtext.setText(bd.regresaPCiudad(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(ciudadtext);
								ciudadtext.setColumns(10);
								
								JLabel lblEstado = new JLabel("Estado");
								lblEstado.setBounds(40, 298, 60, 14);
								proveedoresFrame.getContentPane().add(lblEstado);
								
								JLabel lblNewLabel_2 = new JLabel("Pais");
								lblNewLabel_2.setBounds(40, 348, 60, 14);
								proveedoresFrame.getContentPane().add(lblNewLabel_2);
								
								estadotext = new JTextField();
								estadotext.setBounds(128, 292, 122, 26);
								try {
									estadotext.setText(bd.regresaPEstado(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(estadotext);
								estadotext.setColumns(10);
								
								paistext = new JTextField();
								paistext.setBounds(128, 348, 122, 26);
								try {
									paistext.setText(bd.regresaPPais(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(paistext);
								paistext.setColumns(10);
								
								JLabel lblEmail = new JLabel("Email");
								lblEmail.setBounds(320, 54, 60, 14);
								proveedoresFrame.getContentPane().add(lblEmail);
								
								emailtext = new JTextField();
								emailtext.setBounds(392, 48, 122, 26);
								try {
									emailtext.setText(bd.regresaPEmail(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(emailtext);
								emailtext.setColumns(10);
								
								JLabel lblNotas = new JLabel("Notas");
								lblNotas.setBounds(320, 107, 60, 14);
								proveedoresFrame.getContentPane().add(lblNotas);
								
								final JTextArea notastext = new JTextArea();
								notastext.setBounds(392, 95, 158, 135);
								try {
									notastext.setText(bd.regresaPNotas(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(notastext);
								
								JLabel lblRfc = new JLabel("RFC");
								lblRfc.setBounds(320, 249, 60, 14);
								proveedoresFrame.getContentPane().add(lblRfc);
								
								rfctext = new JTextField();
								rfctext.setBounds(392, 243, 122, 26);
								try {
									rfctext.setText(bd.regresaPRFC(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(rfctext);
								rfctext.setColumns(10);
								
								JLabel lblIdNum = new JLabel("ID Num");
								lblIdNum.setBounds(40, 16, 60, 14);
								proveedoresFrame.getContentPane().add(lblIdNum);
								
								idtext = new JTextField();
								idtext.setBounds(128, 10, 122, 26);
								try {
									idtext.setText(bd.regresaID(indice));
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								
								proveedoresFrame.getContentPane().add(idtext);
								idtext.setColumns(10);
								idtext.setDisabledTextColor(Color.GRAY);
								idtext.disable();
								
								
								rdbtnEsEmpresa = new JRadioButton("Es Empresa");
								rdbtnEsEmpresa.setBounds(394, 372, 130, 18);
								proveedoresFrame.getContentPane().add(rdbtnEsEmpresa);
								
								try {
									if(bd.regresaPEmpresa(indice)!=null){
										rdbtnEsEmpresa.setSelected(true);
									}
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								rdbtnEsEmpresa.disable();
								
								JButton btnRegistrar_1 = new JButton("Modificar");
								btnRegistrar_1.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										
										if(rdbtnEsEmpresa.isSelected()==true){
											try {
												bd.actualizaProveedor(idtext.getText(),nombretext.getText(),apellidotext.getText(),apellidom.getText(),calletext.getText(),ciudadtext.getText(),estadotext.getText(),cptext.getText(),paistext.getText(),emailtext.getText(),notastext.getText(),rfctext.getText(),paginatext.getText(),indice);
												bd.actualizaempresa(idtext.getText(),nombretext.getText(),cargotext.getText(),empresatext.getText(),indice);
												bd.actualizatelefono(idtext.getText(),telefonotext.getText(),indice);
												table_1.setModel(bd.regresamodeloproveedor());
												table_2.setModel(bd.regresamodeloproveedortels());
												table_3.setModel(bd.regresamodeloempresa());
												JOptionPane.showMessageDialog((Component)e.getSource(), "Actualizacion exitosa");
											} catch (Exception e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
										else{
										try {
											bd.actualizaProveedor(idtext.getText(),nombretext.getText(),apellidotext.getText(),apellidom.getText(),calletext.getText(),ciudadtext.getText(),estadotext.getText(),cptext.getText(),paistext.getText(),emailtext.getText(),notastext.getText(),rfctext.getText(),paginatext.getText(),indice);
											bd.actualizatelefono(idtext.getText(),telefonotext.getText(),indice);
											table_1.setModel(bd.regresamodeloproveedor());
											table_2.setModel(bd.regresamodeloproveedortels());
											table_3.setModel(bd.regresamodeloempresa());
											JOptionPane.showMessageDialog((Component)e.getSource(), "Actualizacion exitosa");
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											JOptionPane.showMessageDialog((Component)e.getSource(), "Datos Faltantes o Erroneos");
											e1.printStackTrace();
										}
										}
									}});
								btnRegistrar_1.setBounds(724, 310, 100, 26);
								proveedoresFrame.getContentPane().add(btnRegistrar_1);
								
								JLabel lblCargo = new JLabel("Cargo");
								lblCargo.setBounds(639, 54, 60, 14);
								proveedoresFrame.getContentPane().add(lblCargo);
								
								cargotext = new JTextField();
								cargotext.setBounds(711, 48, 122, 26);
								try {
									cargotext.setText(bd.regresaPCargo(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(cargotext);
								cargotext.setColumns(10);
								
								empresatext = new JTextField();
								empresatext.setBounds(711, 95, 122, 26);
								try {
									empresatext.setText(bd.regresaPEmpresa(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(empresatext);
								empresatext.setColumns(10);
								
								JLabel lblEmpresa = new JLabel("Empresa");
								lblEmpresa.setBounds(639, 101, 60, 14);
								proveedoresFrame.getContentPane().add(lblEmpresa);
								
								telefonotext = new JTextField();
								telefonotext.setBounds(392, 292, 122, 26);
								try {
									telefonotext.setText(bd.regresaPTelefono(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(telefonotext);
								telefonotext.setColumns(10);
								
								JLabel lblTelefono = new JLabel("Telefono");
								lblTelefono.setBounds(320, 298, 60, 14);
								proveedoresFrame.getContentPane().add(lblTelefono);
								
								paginatext = new JTextField();
								paginatext.setBounds(392, 330, 122, 26);
								try {
									paginatext.setText(bd.regresaPPagina(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(paginatext);
								paginatext.setColumns(10);
								
								JLabel lblEmail_1 = new JLabel("Pagina Web");
								lblEmail_1.setBounds(280, 336, 100, 14);
								proveedoresFrame.getContentPane().add(lblEmail_1);
								
								JLabel lblCp = new JLabel("CP");
								lblCp.setBounds(40, 407, 60, 14);
								proveedoresFrame.getContentPane().add(lblCp);
								
								cptext = new JTextField();
								cptext.setBounds(128, 401, 122, 26);
								try {
									cptext.setText(bd.regresaPCP(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								proveedoresFrame.getContentPane().add(cptext);
								cptext.setColumns(10);
								
								Container bli = proveedoresFrame.getContentPane();
								SwingUtilities.updateComponentTreeUI(bli);
								bli.validate();
								
								
							}});
						menuBar.add(btnModificar_1);
						
						JButton btnBorrar = new JButton("Borrar");
						btnBorrar.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub

								final String indice = (String) table_1.getValueAt(sel, 0);
								
							
										try {
											bd.borrarProveedorEmpresa(indice);
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
										try {
											table_1.setModel(bd.regresamodeloproveedor());
											table_2.setModel(bd.regresamodeloproveedortels());
											table_3.setModel(bd.regresamodeloempresa());
											table_1.repaint();
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
																				
								
							}});
						menuBar.add(btnBorrar);
						try {
							proveedoresFrame.setSelected(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						contentPane.add(btnIniciar);
						contentPane.add(btnEmpledos);
						contentPane.add(btnTransportistas);
						contentPane.add(btnProveedores);
						contentPane.add(btnClientes);
						contentPane.add(btnPedidos);
						contentPane.add(graficados);
						contentPane.add(graficatres);
						contentPane.add(graficacuatro);
						contentPane.add(graficacinco);

						proveedoresFrame.toFront();
						proveedoresFrame.setVisible(true);
						
						JPanel temp1 = contentPane;
						SwingUtilities.updateComponentTreeUI(temp1);
						temp1.validate();

						contentPane.repaint();

					}});
				btnProveedores.setBounds(807, 174, 145, 24);
				contentPane.add(btnProveedores);
				
				btnTransportistas = new JButton("Transportistas");
				btnTransportistas.setBorder(new RoundedBorder(20));
				btnTransportistas.setBounds(350, 283, 153, 24);
				contentPane.add(btnTransportistas);
				
				btnEmpledos = new JButton("Empleados");
				btnEmpledos.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						contentPane.removeAll();
						JPanel temp = contentPane;
						SwingUtilities.updateComponentTreeUI(temp);
						temp.validate();
						
						internalFrame = new JInternalFrame("Empleados");
						internalFrame.setClosable(true);
						internalFrame.setResizable(true);
						internalFrame.setBounds(152, 101, 980, 535);
						contentPane.add(internalFrame);
						internalFrame.getContentPane().setLayout(null);
						
						//internalFrame.setLocation(HEIGHT+150, WIDTH+100);
					
						
						
						JMenuBar menuBar = new JMenuBar();
						internalFrame.setJMenuBar(menuBar);
						internalFrame.getContentPane().setLayout(null);
						
						
						JButton btnConsulta = new JButton("Consulta");
						btnConsulta.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub

								internalFrame.getContentPane().removeAll();
								
								textField = new JTextField();
								textField.setBounds(6, 6, 239, 26);
								internalFrame.getContentPane().add(textField);
								textField.setColumns(10);
								
								JButton btnBuscar = new JButton("Buscar");
								btnBuscar.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										String busqueda = textField.getText();
										try {
											tablaempleados.setModel(bd.regresabusqueda(busqueda));
											tablaempleados.repaint();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											System.out.println("ui que pena");
											e1.printStackTrace();
										}
										;
										
									}});
								btnBuscar.setBounds(267, 6, 100, 26);
								internalFrame.getContentPane().add(btnBuscar);
								
								
								try {
									tablaempleados.setModel(bd.regresamodelo());
									tablaempleados.setToolTipText("mmmm");
									tablaempleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tablaempleados.setBounds(12, 41, 947, 422);
								tablaempleados.setShowGrid(true);
								tablaempleados.setShowVerticalLines(true);
								tablaempleados.setGridColor(Color.black);
								
								//contentPane.add(tablaempleados);
								internalFrame.getContentPane().add(tablaempleados);
//								JPanel temp = contentPane;
//								SwingUtilities.updateComponentTreeUI(temp);
//								temp.validate();
								Container bli = internalFrame.getContentPane();
								SwingUtilities.updateComponentTreeUI(bli);
								bli.validate();
								
							}});
						menuBar.add(btnConsulta);
						
						JButton btnRegistro = new JButton("Registro");
						btnRegistro.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								internalFrame.getContentPane().removeAll();
								
								JLabel label = new JLabel("Registro Empleado");
								label.setBounds(208, 31, 140, 14);
								internalFrame.getContentPane().add(label);
								
								JLabel label_1 = new JLabel("Nombre");
								label_1.setBounds(57, 79, 70, 14);
								internalFrame.getContentPane().add(label_1);
								
								final JTextField nombrefield = new JTextField();
								nombrefield.setBounds(151, 75, 114, 22);
								internalFrame.getContentPane().add(nombrefield);
								nombrefield.setColumns(10);
								
								final JTextField apellidopfield = new JTextField();
								apellidopfield.setBounds(151, 111, 114, 22);
								internalFrame.getContentPane().add(apellidopfield);
								apellidopfield.setColumns(10);
								
								JLabel label_3 = new JLabel("Apellido M");
								label_3.setBounds(57, 145, 99, 14);
								internalFrame.getContentPane().add(label_3);
								
								final JTextField apellidom = new JTextField();
								apellidom.setBounds(151, 141, 114, 22);
								internalFrame.getContentPane().add(apellidom);
								apellidom.setColumns(10);
								
								JLabel label_4 = new JLabel("Apellido P");
								label_4.setBounds(57, 115, 70, 14);
								internalFrame.getContentPane().add(label_4);
								
								final JTextField callefield = new JTextField();
								callefield.setBounds(151, 183, 114, 22);
								internalFrame.getContentPane().add(callefield);
								callefield.setColumns(10);
								
								JLabel label_5 = new JLabel("Calle");
								label_5.setBounds(57, 185, 70, 14);
								internalFrame.getContentPane().add(label_5);
								
								final JTextField ciudadfield = new JTextField();
								ciudadfield.setBounds(151, 212, 114, 22);
								internalFrame.getContentPane().add(ciudadfield);
								ciudadfield.setColumns(10);
								
								JLabel label_6 = new JLabel("Ciudad");
								label_6.setBounds(57, 214, 70, 14);
								internalFrame.getContentPane().add(label_6);
								
								final JTextField estadofield = new JTextField();
								estadofield.setBounds(151, 242, 114, 22);
								internalFrame.getContentPane().add(estadofield);
								estadofield.setColumns(10);
								
								JLabel label_7 = new JLabel("Estado");
								label_7.setBounds(57, 246, 70, 14);
								internalFrame.getContentPane().add(label_7);
								
								final JTextField cpfield = new JTextField();
								cpfield.setBounds(357, 77, 114, 22);
								internalFrame.getContentPane().add(cpfield);
								cpfield.setColumns(10);
								
								JLabel label_8 = new JLabel("CP");
								label_8.setBounds(289, 81, 70, 14);
								internalFrame.getContentPane().add(label_8);
								
								final JTextField paisfield = new JTextField();
								paisfield.setBounds(357, 111, 114, 22);
								internalFrame.getContentPane().add(paisfield);
								paisfield.setColumns(10);
								
								JLabel label_9 = new JLabel("Pais");
								label_9.setBounds(289, 113, 70, 14);
								internalFrame.getContentPane().add(label_9);
								
								final JTextField emailfield = new JTextField();
								emailfield.setBounds(357, 143, 114, 22);
								internalFrame.getContentPane().add(emailfield);
								emailfield.setColumns(10);
								
								JLabel label_10 = new JLabel("Email");
								label_10.setBounds(289, 147, 70, 14);
								internalFrame.getContentPane().add(label_10);
								
								final JRadioButton aprobacionboton = new JRadioButton("Aprobación de Uso de Sistema");
								aprobacionboton.setBounds(277, 242, 244, 22);
								internalFrame.getContentPane().add(aprobacionboton);
								
								JButton registrarboton = new JButton("Registrar");
								registrarboton.setBounds(245, 287, 114, 27);
								
								
								registrarboton.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										String aprobado;
										if(aprobacionboton.isSelected()== true){
											aprobado = "1";
										}else{
											aprobado = "0";
										}
										try {
											bd.insertarempleado(nombrefield.getText(), apellidopfield.getText(), apellidom.getText(), callefield.getText(), ciudadfield.getText(), estadofield.getText(), cpfield.getText(), paisfield.getText(),  emailfield.getText(), aprobado, usuariofield.getText(), contraseñafield.getText());
											JOptionPane.showMessageDialog((Component)arg0.getSource(), "Registro Exitoso");
											
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											JOptionPane.showMessageDialog((Component)arg0.getSource(), "Sin datos suficientes");
											
										}
										
									}});
								internalFrame.getContentPane().add(registrarboton);
								
								JLabel label_11 = new JLabel("Usuario");
								label_11.setBounds(289, 185, 70, 14);
								internalFrame.getContentPane().add(label_11);
								
								usuariofield = new JTextField();
								usuariofield.setBounds(357, 183, 114, 22);
								internalFrame.getContentPane().add(usuariofield);
								usuariofield.setColumns(10);
								
								contraseñafield = new JTextField();
								contraseñafield.setBounds(364, 212, 114, 22);
								internalFrame.getContentPane().add(contraseñafield);
								contraseñafield.setColumns(10);
								
								JLabel lblContrasea = new JLabel("Contraseña");
								lblContrasea.setBounds(277, 216, 87, 14);
								internalFrame.getContentPane().add(lblContrasea);
								
								//
								
								
								internalFrame.toFront();
								internalFrame.setVisible(true);
						
//								JPanel temp = contentPane;
//								SwingUtilities.updateComponentTreeUI(temp);
//								temp.validate();
								Container bli = internalFrame.getContentPane();
								SwingUtilities.updateComponentTreeUI(bli);
								bli.validate();
							}});
						menuBar.add(btnRegistro);
						
						tablaempleados.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
						    public void valueChanged(ListSelectionEvent e) {
						        sel = tablaempleados.getSelectedRow();
						        
						    }
						});
						
						JButton borrar = new JButton("Borrar");
						borrar.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub	
								
								System.out.println("escogiste: "+ sel);
								try {
									String numero = (String) tablaempleados.getValueAt(sel, 0);
									bd.borrarempleado(numero);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									System.out.println("No se pudo borrar");
									e.printStackTrace();
								}
								try {
									tablaempleados.setModel(bd.regresamodelo());
									tablaempleados.repaint();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}});
						
						JButton btnModificar = new JButton("Modificar");
						btnModificar.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								final String indice = (String)tablaempleados.getValueAt(sel, 0);
								
								internalFrame.getContentPane().removeAll();
								
								JLabel label = new JLabel("Modifica Empleado");
								label.setBounds(208, 31, 140, 14);
								internalFrame.getContentPane().add(label);
								
								JLabel label_1 = new JLabel("Nombre");
								label_1.setBounds(57, 79, 70, 14);
								internalFrame.getContentPane().add(label_1);
								
								final JTextField nombrefield = new JTextField();
								nombrefield.setBounds(151, 75, 114, 22);
								try {
									nombrefield.setText(bd.regresanombreempleado(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(nombrefield);
								nombrefield.setColumns(10);
								
								final JTextField apellidopfield = new JTextField();
								apellidopfield.setBounds(151, 111, 114, 22);
								try {
									apellidopfield.setText(bd.regresapellidop(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(apellidopfield);
								apellidopfield.setColumns(10);
								
								JLabel label_3 = new JLabel("Apellido M");
								label_3.setBounds(57, 145, 99, 14);
								internalFrame.getContentPane().add(label_3);
								
								final JTextField apellidom = new JTextField();
								apellidom.setBounds(151, 141, 114, 22);
								try {
									apellidom.setText(bd.regresapellidom(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(apellidom);
								apellidom.setColumns(10);
								
								JLabel label_4 = new JLabel("Apellido P");
								label_4.setBounds(57, 115, 70, 14);
								internalFrame.getContentPane().add(label_4);
								
								final JTextField callefield = new JTextField();
								callefield.setBounds(151, 183, 114, 22);
								try {
									callefield.setText(bd.regresacalle(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(callefield);
								callefield.setColumns(10);
								
								JLabel label_5 = new JLabel("Calle");
								label_5.setBounds(57, 185, 70, 14);
								internalFrame.getContentPane().add(label_5);
								
								final JTextField ciudadfield = new JTextField();
								ciudadfield.setBounds(151, 212, 114, 22);
								try {
									ciudadfield.setText(bd.regresaciudad(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(ciudadfield);
								ciudadfield.setColumns(10);
								
								JLabel label_6 = new JLabel("Ciudad");
								label_6.setBounds(57, 214, 70, 14);
								internalFrame.getContentPane().add(label_6);
								
								final JTextField estadofield = new JTextField();
								estadofield.setBounds(151, 242, 114, 22);
								try {
									estadofield.setText(bd.regresaestado(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(estadofield);
								estadofield.setColumns(10);
								
								JLabel label_7 = new JLabel("Estado");
								label_7.setBounds(57, 246, 70, 14);
								internalFrame.getContentPane().add(label_7);
								
								final JTextField cpfield = new JTextField();
								cpfield.setBounds(357, 77, 114, 22);
								try {
									cpfield.setText(bd.regresacp(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(cpfield);
								cpfield.setColumns(10);
								
								JLabel label_8 = new JLabel("CP");
								label_8.setBounds(289, 81, 70, 14);
								internalFrame.getContentPane().add(label_8);
								
								final JTextField paisfield = new JTextField();
								paisfield.setBounds(357, 111, 114, 22);
								try {
									paisfield.setText(bd.regresapais(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(paisfield);
								paisfield.setColumns(10);
								
								JLabel label_9 = new JLabel("Pais");
								label_9.setBounds(289, 113, 70, 14);
								internalFrame.getContentPane().add(label_9);
								
								final JTextField emailfield = new JTextField();
								emailfield.setBounds(357, 143, 114, 22);
								try {
									emailfield.setText(bd.regresaemail(indice));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(emailfield);
								emailfield.setColumns(10);
								
								JLabel label_10 = new JLabel("Email");
								label_10.setBounds(289, 147, 70, 14);
								internalFrame.getContentPane().add(label_10);
								
								final JRadioButton aprobacionboton = new JRadioButton("Aprobación de Uso de Sistema");
								aprobacionboton.setBounds(277, 242, 244, 18);
								try {
									String aproba = bd.regresaprobacion(indice);
									if(aproba.equals("1")){
										aprobacionboton.setSelected(true);
									}else{
										aprobacionboton.setSelected(false);
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								internalFrame.getContentPane().add(aprobacionboton);
								
								
								
								JButton registrarboton = new JButton("Modificar");
								registrarboton.setBounds(245, 287, 114, 27);
								
								
								registrarboton.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent arg0) {
										// TODO Auto-generated method stub
										String aprobado;
										if(aprobacionboton.isSelected()== true){
											aprobado = "1";
										}else{
											aprobado = "0";
										}
										try {
											bd.modificarempleado(indice,nombrefield.getText(), apellidopfield.getText(), apellidom.getText(), callefield.getText(), ciudadfield.getText(), estadofield.getText(), cpfield.getText(), paisfield.getText(),  emailfield.getText(), aprobado, usuariofield.getText(), contraseñafield.getText());
											JOptionPane.showMessageDialog((Component)arg0.getSource(), "Modificado Exitosamente");
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											JOptionPane.showMessageDialog((Component)arg0.getSource(), "Faltan Datos");
											e.printStackTrace();
											
										}
										
									}});
								internalFrame.getContentPane().add(registrarboton);
								
								JLabel label_11 = new JLabel("Usuario");
								label_11.setBounds(289, 185, 70, 14);
								internalFrame.getContentPane().add(label_11);
								
								usuariofield = new JTextField();
								usuariofield.setBounds(357, 183, 114, 22);
								try {
									usuariofield.setText(bd.regresausuario(indice));
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								internalFrame.getContentPane().add(usuariofield);
								usuariofield.setColumns(10);
								
								contraseñafield = new JTextField();
								contraseñafield.setBounds(364, 212, 114, 22);
								try {
									contraseñafield.setText(bd.regresapassword(indice));
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								internalFrame.getContentPane().add(contraseñafield);
								contraseñafield.setColumns(10);
								
								JLabel lblContrasea = new JLabel("Contraseña");
								lblContrasea.setBounds(277, 216, 87, 14);
								internalFrame.getContentPane().add(lblContrasea);
								
								
								internalFrame.setVisible(true);
						
//								JPanel temp = contentPane;
//								SwingUtilities.updateComponentTreeUI(temp);
//								temp.validate();
								Container bli = internalFrame.getContentPane();
								SwingUtilities.updateComponentTreeUI(bli);
								bli.validate();
								
							}});
						menuBar.add(btnModificar);
						menuBar.add(borrar);
						
						JMenu mnAyuda = new JMenu("Ayuda");
						menuBar.add(mnAyuda);
						
						JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
						mnAyuda.add(mntmInstrucciones);
						
						JMenuItem mntmSoporte = new JMenuItem("Soporte");
						mnAyuda.add(mntmSoporte);
						
						try {
							internalFrame.setSelected(true);
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						contentPane.add(btnIniciar);
						contentPane.add(btnEmpledos);
						contentPane.add(btnTransportistas);
						contentPane.add(btnProveedores);
						contentPane.add(btnClientes);
						contentPane.add(btnPedidos);
						contentPane.add(graficados);
						contentPane.add(graficatres);
						contentPane.add(graficacuatro);
						contentPane.add(graficacinco);

						internalFrame.toFront();
						internalFrame.setVisible(true);
						
						JPanel temp1 = contentPane;
						SwingUtilities.updateComponentTreeUI(temp1);
						temp1.validate();

						contentPane.repaint();
						
					}});
				btnEmpledos.setBounds(842, 314, 117, 24);
				btnEmpledos.setBorder(new RoundedBorder(20));
				
				contentPane.add(btnEmpledos);
				
				final JButton button = new JButton("Atras");
				button.setBounds(361, 63, 80, 24);
				button.setBorder(new RoundedBorder(20));
				button.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						contentPane.remove(btnClientes);
						contentPane.remove(btnPedidos);
						contentPane.remove(btnProveedores);
						contentPane.remove(btnTransportistas);
						contentPane.remove(btnEmpledos);
						
						JPanel temp = contentPane;
						SwingUtilities.updateComponentTreeUI(temp);
						temp.validate();
						contentPane.remove(button);
					}});
				contentPane.add(button);
				
				JPanel temp = contentPane;
				SwingUtilities.updateComponentTreeUI(temp);
				temp.validate();
			}});
		
		//Comienza el modulo de Clientes
		final JInternalFrame internalFrame_1 = new JInternalFrame("New JInternalFrame");
		internalFrame_1.setBounds(274, 146, 976, 517);
		contentPane.add(internalFrame_1);
		
		JMenuBar menuBar = new JMenuBar();
		internalFrame_1.setJMenuBar(menuBar);
		
		JButton btnConsulta_1 = new JButton("Consulta");
		btnConsulta_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				internalFrame_1.getContentPane().removeAll();
				
				textField_2 = new JTextField();
				textField_2.setBounds(6, 6, 122, 26);
				internalFrame_1.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.setBounds(140, 6, 100, 26);
				internalFrame_1.getContentPane().add(btnNewButton);
				
				table_4 = new JTable();
				try {
					table_4.setModel(bd.regresamodelocliente());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table_4.setBounds(12, 41, 947, 422);
				table_4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_4.setShowGrid(true);
				table_4.setShowHorizontalLines(true);
				table_4.setGridColor(Color.black);
				table_4.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				    public void valueChanged(ListSelectionEvent e) {
				        sel = table_4.getSelectedRow();
				        
				    }
				});
				
				table_5 = new JTable();
				try {
					table_5.setModel(bd.regresamodeloclientetels());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table_5.setBounds(12, 41, 947, 422);
				table_5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_5.setShowGrid(true);
				table_5.setShowHorizontalLines(true);
				table_5.setGridColor(Color.black);
				
				
				table_6 = new JTable();
				try {
					table_6.setModel(bd.regresamodeloclienteempresa());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table_6.setBounds(12, 41, 947, 422);
				table_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table_6.setShowGrid(true);
				table_6.setShowHorizontalLines(true);
				table_6.setGridColor(Color.black);
				
				
				internalFrame_1.getContentPane().add(table_4);
				
				JButton btnGeneral_1 = new JButton("General");
				btnGeneral_1.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}});
				btnGeneral_1.setBounds(604, 6, 100, 26);
				internalFrame_1.getContentPane().add(btnGeneral_1);
				
				JButton btnTels = new JButton("Tels");
				btnTels.setBounds(716, 6, 100, 26);
				internalFrame_1.getContentPane().add(btnTels);
				
				JButton btnNewButton_1 = new JButton("Empresa");
				btnNewButton_1.setBounds(828, 6, 100, 26);
				internalFrame_1.getContentPane().add(btnNewButton_1);
				internalFrame_1.setVisible(true);
				
				Container temp = internalFrame_1.getContentPane();
				SwingUtilities.updateComponentTreeUI(temp);
				temp.validate();
				
			}});
		menuBar.add(btnConsulta_1);
		
		JButton btnRegistrar_2 = new JButton("Registrar");
		menuBar.add(btnRegistrar_2);
		
		JButton btnModificar_2 = new JButton("Modificar");
		menuBar.add(btnModificar_2);
		
		JButton btnBorrar_1 = new JButton("Borrar");
		menuBar.add(btnBorrar_1);
		internalFrame_1.getContentPane().setLayout(null);
		

//Acaba el modulo de clientes
		contentPane.add(btnIniciar);
		
		
		graficatres = new JInternalFrame("Venta Productos");
		graficatres.setBounds(12, 12, 322, 353);
		contentPane.add(graficatres);
		graficatres.getContentPane().setLayout(null);
		
		JLabel lblGraphuno = new JLabel("Graphuno");
		lblGraphuno.setBounds(6, 6, 330, 310);
		lblGraphuno.setIcon(grafiiconuno);
		graficatres.getContentPane().add(lblGraphuno);
		
		graficados = new JInternalFrame("Ventas Semanal");
		graficados.setBounds(12, 370, 322, 345);
		contentPane.add(graficados);
		graficados.getContentPane().setLayout(null);
		JLabel lblGraficados = new JLabel("Graficados");
		lblGraficados.setIcon(imagengraficados);
		lblGraficados.setBounds(6, 6, 298, 302);
		graficados.getContentPane().add(lblGraficados);
		
		graficacinco = new JInternalFrame("Lista Pedidos");
		graficacinco.setBounds(1017, 362, 269, 353);
		contentPane.add(graficacinco);
		
		graficacuatro = new JInternalFrame("Lista Productos");
		graficacuatro.setBounds(1017, 12, 269, 353);
		contentPane.add(graficacuatro);
		
		//		graficauno.getContentPane().add(comp);
				
		graficacuatro.setVisible(true);
		graficacinco.setVisible(true);
		graficados.setVisible(true);
		graficatres.setVisible(true);
		
	}
	
	
	
	//Metodos de graficas
	
	//Grafica Uno como Buffered Image
	/**
	 * @return BufferedImage
	 * Creamos la primera grafica como un buffered image insertando las series en XY
	 */
	public BufferedImage graphuno(){
		XYSeries series = new XYSeries("Evolucion");
        series.add(1, 23);
        series.add(2, 34);
        series.add(3, 51);
        series.add(4, 67);
        series.add(5, 89);
        series.add(6, 121);
        series.add(7, 137);
        XYDataset juegoDatos= new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart
        ("Ventas",
        "Meses","Ingresos",juegoDatos,PlotOrientation.VERTICAL,
        false,
        false,
        true                // Show legend
        );

         BufferedImage image = chart.createBufferedImage(300,300);
        return image;
	}
	
	//Creamos la segunda grafica como una BufferedImage
	
	/**
	 * @param dataset
	 * @return
	 * Toma como parametro un dataset, con el cual nos creara el set para el pie gigante
	 * nos creara un BufferedImage la cual despues insertaeremos en el JLabel
	 */
	public BufferedImage graphdos(final PieDataset dataset){
		 
		JFreeChart chart = ChartFactory.createPieChart3D(
		            "Ventas de Articulos",  // chart title
		            dataset,                // data
		            true,                   // include legend
		            true,
		            false
		        );

		        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
		        plot.setStartAngle(290);
		        plot.setDirection(Rotation.CLOCKWISE);
		        plot.setForegroundAlpha(0.5f);
		        plot.setNoDataMessage("No data to display");
		        

         BufferedImage image = chart.createBufferedImage(300,300);
        return image;
	}
	
	//Los datos dentro de la segunda grafica
	
	 private PieDataset createSampleDataset() {
	        
	        final DefaultPieDataset result = new DefaultPieDataset();
	        result.setValue("Tijeras", new Double(43.2));
	        result.setValue("Toshiba 3E", new Double(10.0));
	        result.setValue("Cortadoras", new Double(17.5));
	        result.setValue("Motor SDE", new Double(32.5));
	        result.setValue("Sharpers DR", new Double(1.0));
	        return result;
	        
	    }
}

class RoundedBorder implements Border {
	int radius;

	RoundedBorder(int radius) {
		this.radius = radius;
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(this.radius + 1, this.radius + 1, this.radius + 2,
				this.radius);
	}

	public boolean isBorderOpaque() {
		return true;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
	}
}



//Backport de codigo

