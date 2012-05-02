import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
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


public class DBMSysAdministrator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	JTextField usuariofield = null;
	JTextField contraseñafield = null;

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
		
		
		final Bidi bd = new Bidi("postgres", "132410jh");
		final JTable tablaempleados;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JInternalFrame internalFrame = new JInternalFrame("Empleados");
		internalFrame.setBounds(293, 194, 980, 600);
		internalFrame.setLocation(HEIGHT+150, WIDTH+100);
		internalFrame.setClosable(true);
		internalFrame.setResizable(true);
//		internalFrame.setMaximizable(true);
		contentPane.add(internalFrame);
		
		tablaempleados = new JTable();
		
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
				JPanel temp = contentPane;
				SwingUtilities.updateComponentTreeUI(temp);
				temp.validate();
				
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
				nombrefield.setBounds(151, 75, 114, 18);
				internalFrame.getContentPane().add(nombrefield);
				nombrefield.setColumns(10);
				
				final JTextField apellidopfield = new JTextField();
				apellidopfield.setBounds(151, 111, 114, 18);
				internalFrame.getContentPane().add(apellidopfield);
				apellidopfield.setColumns(10);
				
				JLabel label_3 = new JLabel("Apellido M");
				label_3.setBounds(57, 145, 99, 14);
				internalFrame.getContentPane().add(label_3);
				
				final JTextField apellidom = new JTextField();
				apellidom.setBounds(151, 141, 114, 18);
				internalFrame.getContentPane().add(apellidom);
				apellidom.setColumns(10);
				
				JLabel label_4 = new JLabel("Apellido P");
				label_4.setBounds(57, 115, 70, 14);
				internalFrame.getContentPane().add(label_4);
				
				final JTextField callefield = new JTextField();
				callefield.setBounds(151, 183, 114, 18);
				internalFrame.getContentPane().add(callefield);
				callefield.setColumns(10);
				
				JLabel label_5 = new JLabel("Calle");
				label_5.setBounds(57, 185, 70, 14);
				internalFrame.getContentPane().add(label_5);
				
				final JTextField ciudadfield = new JTextField();
				ciudadfield.setBounds(151, 212, 114, 18);
				internalFrame.getContentPane().add(ciudadfield);
				ciudadfield.setColumns(10);
				
				JLabel label_6 = new JLabel("Ciudad");
				label_6.setBounds(57, 214, 70, 14);
				internalFrame.getContentPane().add(label_6);
				
				final JTextField estadofield = new JTextField();
				estadofield.setBounds(151, 242, 114, 18);
				internalFrame.getContentPane().add(estadofield);
				estadofield.setColumns(10);
				
				JLabel label_7 = new JLabel("Estado");
				label_7.setBounds(57, 246, 70, 14);
				internalFrame.getContentPane().add(label_7);
				
				final JTextField cpfield = new JTextField();
				cpfield.setBounds(357, 77, 114, 18);
				internalFrame.getContentPane().add(cpfield);
				cpfield.setColumns(10);
				
				JLabel label_8 = new JLabel("CP");
				label_8.setBounds(289, 81, 70, 14);
				internalFrame.getContentPane().add(label_8);
				
				final JTextField paisfield = new JTextField();
				paisfield.setBounds(357, 111, 114, 18);
				internalFrame.getContentPane().add(paisfield);
				paisfield.setColumns(10);
				
				JLabel label_9 = new JLabel("Pais");
				label_9.setBounds(289, 113, 70, 14);
				internalFrame.getContentPane().add(label_9);
				
				final JTextField emailfield = new JTextField();
				emailfield.setBounds(357, 143, 114, 18);
				internalFrame.getContentPane().add(emailfield);
				emailfield.setColumns(10);
				
				JLabel label_10 = new JLabel("Email");
				label_10.setBounds(289, 147, 70, 14);
				internalFrame.getContentPane().add(label_10);
				
				final JRadioButton aprobacionboton = new JRadioButton("Aprobación de Uso de Sistema");
				aprobacionboton.setBounds(277, 242, 244, 18);
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
				usuariofield.setBounds(357, 183, 114, 18);
				internalFrame.getContentPane().add(usuariofield);
				usuariofield.setColumns(10);
				
				contraseñafield = new JTextField();
				contraseñafield.setBounds(357, 212, 114, 18);
				internalFrame.getContentPane().add(contraseñafield);
				contraseñafield.setColumns(10);
				
				JLabel lblContrasea = new JLabel("Contraseña");
				lblContrasea.setBounds(277, 216, 87, 14);
				internalFrame.getContentPane().add(lblContrasea);
				
				
				internalFrame.setVisible(true);
		
				JPanel temp = contentPane;
				SwingUtilities.updateComponentTreeUI(temp);
				temp.validate();
				
			}});
		menuBar.add(btnRegistro);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
		mnAyuda.add(mntmInstrucciones);
		
		JMenuItem mntmSoporte = new JMenuItem("Soporte");
		mnAyuda.add(mntmSoporte);
		internalFrame.setVisible(true);
		
		//Se crea la segunda grafica, y se convierte en un BufferedImage
		PieDataset datasetGraficados = createSampleDataset();
		BufferedImage graphidos = graphdos(datasetGraficados);
		
		JInternalFrame graficados = new JInternalFrame("Ventas Semanal");
		graficados.setBounds(12, 370, 322, 345);
		contentPane.add(graficados);
		graficados.getContentPane().setLayout(null);
		
		//Se pasa de bufferedImage a una imagen icono grandota y se agrega al label
		ImageIcon imagengraficados = new ImageIcon(graphidos);
		JLabel lblGraficados = new JLabel("Graficados");
		lblGraficados.setIcon(imagengraficados);
		lblGraficados.setBounds(6, 6, 298, 302);
		graficados.getContentPane().add(lblGraficados);
		
		
		BufferedImage graphuno = graphuno();
		
		
		JInternalFrame graficatres = new JInternalFrame("Otra graph");
		graficatres.setBounds(12, 12, 322, 353);
		contentPane.add(graficatres);
		graficatres.getContentPane().setLayout(null);
		
		ImageIcon grafiiconuno = new ImageIcon(graphuno);
		
		JLabel lblGraphuno = new JLabel("Graphuno");
		lblGraphuno.setBounds(6, 6, 330, 310);
		lblGraphuno.setIcon(grafiiconuno);
		graficatres.getContentPane().add(lblGraphuno);
		
		JInternalFrame graficacinco = new JInternalFrame("Lula ayudame!");
		graficacinco.setBounds(1017, 362, 269, 353);
		contentPane.add(graficacinco);
		
		JInternalFrame graficacuatro = new JInternalFrame("wa no manches");
		graficacuatro.setBounds(1017, 12, 269, 353);
		contentPane.add(graficacuatro);
		
		
		
		
		JButton btnIniciar = new JButton("Iniciar");
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
				btnProveedores.setBounds(807, 174, 145, 24);
				contentPane.add(btnProveedores);
				
				final JButton btnTransportistas = new JButton("Transportistas");
				btnTransportistas.setBorder(new RoundedBorder(20));
				btnTransportistas.setBounds(350, 283, 153, 24);
				contentPane.add(btnTransportistas);
				
				final JButton btnEmpledos = new JButton("Empledos");
				btnEmpledos.setBounds(842, 314, 117, 24);
				btnEmpledos.setBorder(new RoundedBorder(20));
				btnEmpledos.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						
					}});
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
		contentPane.add(btnIniciar);

//		graficauno.getContentPane().add(comp);
		
		graficacuatro.setVisible(true);
		graficacinco.setVisible(true);
		graficatres.setVisible(true);
		graficados.setVisible(true);
		
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
		            "Pie Chart 3D Demo 1",  // chart title
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

//Añade frame interna de registro de empleado
//JInternalFrame RegistroEmpleado = new JInternalFrame("Empleado");
//RegistroEmpleado.setClosable(true);
//RegistroEmpleado.setResizable(true);
//RegistroEmpleado.setBounds(293, 194, 980, 600);
//contentPane.add(RegistroEmpleado);
//RegistroEmpleado.getContentPane().setLayout(null);
//
//JLabel label = new JLabel("Registro Empleado");
//label.setBounds(208, 31, 140, 14);
//RegistroEmpleado.getContentPane().add(label);
//
//JLabel label_1 = new JLabel("Nombre");
//label_1.setBounds(57, 79, 70, 14);
//RegistroEmpleado.getContentPane().add(label_1);
//
//final JTextField nombrefield = new JTextField();
//nombrefield.setBounds(151, 75, 114, 18);
//RegistroEmpleado.getContentPane().add(nombrefield);
//nombrefield.setColumns(10);
//
//final JTextField apellidopfield = new JTextField();
//apellidopfield.setBounds(151, 111, 114, 18);
//RegistroEmpleado.getContentPane().add(apellidopfield);
//apellidopfield.setColumns(10);
//
//JLabel label_3 = new JLabel("Apellido M");
//label_3.setBounds(57, 145, 99, 14);
//RegistroEmpleado.getContentPane().add(label_3);
//
//final JTextField apellidom = new JTextField();
//apellidom.setBounds(151, 141, 114, 18);
//RegistroEmpleado.getContentPane().add(apellidom);
//apellidom.setColumns(10);
//
//JLabel label_4 = new JLabel("Apellido P");
//label_4.setBounds(57, 115, 70, 14);
//RegistroEmpleado.getContentPane().add(label_4);
//
//final JTextField callefield = new JTextField();
//callefield.setBounds(151, 183, 114, 18);
//RegistroEmpleado.getContentPane().add(callefield);
//callefield.setColumns(10);
//
//JLabel label_5 = new JLabel("Calle");
//label_5.setBounds(57, 185, 70, 14);
//RegistroEmpleado.getContentPane().add(label_5);
//
//final JTextField ciudadfield = new JTextField();
//ciudadfield.setBounds(151, 212, 114, 18);
//RegistroEmpleado.getContentPane().add(ciudadfield);
//ciudadfield.setColumns(10);
//
//JLabel label_6 = new JLabel("Ciudad");
//label_6.setBounds(57, 214, 70, 14);
//RegistroEmpleado.getContentPane().add(label_6);
//
//final JTextField estadofield = new JTextField();
//estadofield.setBounds(151, 242, 114, 18);
//RegistroEmpleado.getContentPane().add(estadofield);
//estadofield.setColumns(10);
//
//JLabel label_7 = new JLabel("Estado");
//label_7.setBounds(57, 246, 70, 14);
//RegistroEmpleado.getContentPane().add(label_7);
//
//final JTextField cpfield = new JTextField();
//cpfield.setBounds(357, 77, 114, 18);
//RegistroEmpleado.getContentPane().add(cpfield);
//cpfield.setColumns(10);
//
//JLabel label_8 = new JLabel("CP");
//label_8.setBounds(289, 81, 70, 14);
//RegistroEmpleado.getContentPane().add(label_8);
//
//final JTextField paisfield = new JTextField();
//paisfield.setBounds(357, 111, 114, 18);
//RegistroEmpleado.getContentPane().add(paisfield);
//paisfield.setColumns(10);
//
//JLabel label_9 = new JLabel("Pais");
//label_9.setBounds(289, 113, 70, 14);
//RegistroEmpleado.getContentPane().add(label_9);
//
//final JTextField emailfield = new JTextField();
//emailfield.setBounds(357, 143, 114, 18);
//RegistroEmpleado.getContentPane().add(emailfield);
//emailfield.setColumns(10);
//
//JLabel label_10 = new JLabel("Email");
//label_10.setBounds(289, 147, 70, 14);
//RegistroEmpleado.getContentPane().add(label_10);
//
//final JRadioButton aprobacionboton = new JRadioButton("Aprobación de Uso de Sistema");
//aprobacionboton.setBounds(277, 242, 244, 18);
//RegistroEmpleado.getContentPane().add(aprobacionboton);
//
//JButton registrarboton = new JButton("Registrar");
//registrarboton.setBounds(245, 287, 114, 27);
//registrarboton.addActionListener(new ActionListener(){
//
//	@Override 	
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//		String aprobado;
//		if(aprobacionboton.isSelected()== true){
//			aprobado = "1";
//		}else{
//			aprobado = "0";
//		}
//		try {
//			AbstractButton usuariofield = null;
//			AbstractButton contraseñafield = null;
//			bd.insertarempleado(nombrefield.getText(), apellidopfield.getText(), apellidom.getText(), callefield.getText(), ciudadfield.getText(), estadofield.getText(), cpfield.getText(), paisfield.getText(),  emailfield.getText(), aprobado, usuariofield.getText(), contraseñafield.getText());
//			JOptionPane.showMessageDialog((Component)arg0.getSource(), "Registro Exitoso");
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog((Component)arg0.getSource(), "Sin datos suficientes");
//			
//		}
//		
//	}});
//RegistroEmpleado.getContentPane().add(registrarboton);
//
//JLabel label_11 = new JLabel("Usuario");
//label_11.setBounds(289, 185, 70, 14);
//RegistroEmpleado.getContentPane().add(label_11);
//
//JTextField usuariofield = new JTextField();
//usuariofield.setBounds(357, 183, 114, 18);
//RegistroEmpleado.getContentPane().add(usuariofield);
//usuariofield.setColumns(10);
//
//JTextField contraseñafield = new JTextField();
//contraseñafield.setBounds(357, 212, 114, 18);
//RegistroEmpleado.getContentPane().add(contraseñafield);
//contraseñafield.setColumns(10);
//
//JLabel lblContrasea = new JLabel("Contraseña");
//lblContrasea.setBounds(277, 216, 87, 14);
//RegistroEmpleado.getContentPane().add(lblContrasea);
//
//
//RegistroEmpleado.setVisible(true);
//JPanel temp = contentPane;
//SwingUtilities.updateComponentTreeUI(temp);
//temp.validate();