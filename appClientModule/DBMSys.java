import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;


public class DBMSys extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBMSys frame = new DBMSys();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DBMSys() {
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame graficauno = new JInternalFrame("Ventas Semanal");
		graficauno.setBounds(12, 370, 269, 345);
		contentPane.add(graficauno);
		
		JInternalFrame graficatres = new JInternalFrame("Otra graph");
		graficatres.setBounds(12, 12, 269, 353);
		contentPane.add(graficatres);
		
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
				btnTransportistas.setBounds(293, 283, 153, 24);
				contentPane.add(btnTransportistas);
				
				final JButton btnEmpledos = new JButton("Empledos");
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
		contentPane.add(btnIniciar);
		
		
		
		
		graficacuatro.setVisible(true);
		graficacinco.setVisible(true);
		graficatres.setVisible(true);
		graficauno.setVisible(true);
		
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
