import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;


public class Sesion extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JTextField usetxt;
	private JPasswordField passwordField;
	Bidi bd;
	/**
	 * Launch the application.
	 * Clase que verifica las credenciales del usuario.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sesion frame = new Sesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Sesion() throws ClassNotFoundException, SQLException {
		final Bidi bd = new Bidi("postgres","132410jh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BufferedImage im = null;
		
		try {
			im = ImageIO.read(new File("bli.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon ic = new ImageIcon(im);
		
		JLabel lblImg = new JLabel("IMG");
		lblImg.setBounds(160, 12, 153, 102);
		lblImg.setIcon(ic);
		contentPane.add(lblImg);
		
		JLabel lblDbmsystem = new JLabel("DBMSystem");
		lblDbmsystem.setBounds(176, 137, 101, 14);
		contentPane.add(lblDbmsystem);
		
		JLabel lblVersion = new JLabel("Version 1.0");
		lblVersion.setBounds(186, 152, 91, 14);
		contentPane.add(lblVersion);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(116, 199, 70, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(116, 238, 101, 14);
		contentPane.add(lblContrasea);
		
		usetxt = new JTextField();
		usetxt.setBounds(222, 197, 114, 18);
		contentPane.add(usetxt);
		usetxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 236, 114, 18);
		contentPane.add(passwordField);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesiòn");
		btnIniciarSesin.setBounds(308, 277, 137, 18);
		btnIniciarSesin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String usuarioentrante = usetxt.getText();
				String contraentrante = passwordField.getText();
				String usernombre = "";
				try {
					usernombre = bd.damenombreusuario(usuarioentrante);
					System.out.println("Te llamas " + usernombre);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog((Component)arg0.getSource(), "El usuario no existe");
				}
				
				try {
					if(contraentrante.equals(bd.dameadmincontra(usuarioentrante))){
						JOptionPane.showMessageDialog((Component)arg0.getSource(), "Bienvenido(a): " +usernombre);
						DBMSysAdministrator sistemaborazones = new DBMSysAdministrator();
						sistemaborazones.setSize(Toolkit.getDefaultToolkit().getScreenSize());
						sistemaborazones.validate();
						sistemaborazones.setLocationRelativeTo(null);
						sistemaborazones.setVisible(true);
						dispose();
					}else{
						JOptionPane.showMessageDialog((Component)arg0.getSource(), "Lo sentimos, la contraseña que ingreso no existe, favor de verificarla, gracias");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog((Component)arg0.getSource(), "Problema de conexión");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Algo paso");
				}
				
			}});
		contentPane.add(btnIniciarSesin);
		
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int tecla = arg0.getID();
		if(tecla == KeyEvent.VK_ENTER){
			System.out.println("Si entre aqui...");
			String usuarioentrante = usetxt.getText();
			String contraentrante = passwordField.getText();
			String usernombre = "";
			try {
				usernombre = bd.damenombreusuario(usuarioentrante);
				System.out.println("Te llamas " + usernombre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog((Component)arg0.getSource(), "El usuario no existe");
			}
			
			try {
				if(contraentrante.equals(bd.dameadmincontra(usuarioentrante))){
					JOptionPane.showMessageDialog((Component)arg0.getSource(), "Bienvenido(a): " +usernombre);
					DBMSysAdministrator sistemaborazones = new DBMSysAdministrator();
					sistemaborazones.setSize(Toolkit.getDefaultToolkit().getScreenSize());
					sistemaborazones.validate();
					sistemaborazones.setLocationRelativeTo(null);
					sistemaborazones.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog((Component)arg0.getSource(), "Lo sentimos, la contraseña que ingreso no existe, favor de verificarla, gracias");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog((Component)arg0.getSource(), "Problema de conexión");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Algo paso");
			}

			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}