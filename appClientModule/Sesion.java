//Holo!!!dsad
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


public class Sesion extends JFrame {

	private JPanel contentPane;
	private JTextField usetxt;
	private JPasswordField passwordField;
	Bidi bd;
	String aproval;
	/**
	 * Launch the application.
	 * Clase que verifica las credenciales del usuario.
	 */

	/**
	 * Create the frame.
	 * @param password 
	 * @param user 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Sesion(final String user, final String password) throws ClassNotFoundException, SQLException {
		final Bidi bd = new Bidi(user,password);
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
					aproval = bd.regresaprobadoo(usuarioentrante);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("No existe el usuario quiza ");
					e1.printStackTrace();
				}
				try {
					if(contraentrante.equals(bd.dameadmincontra(usuarioentrante)) && aproval.equals("1")){
						JOptionPane.showMessageDialog((Component)arg0.getSource(), "Bienvenido(a): " +usernombre);
						DBMSysAdministrator sistemaborazones = new DBMSysAdministrator(user, password);
						sistemaborazones.setSize(Toolkit.getDefaultToolkit().getScreenSize());
						sistemaborazones.validate();
						sistemaborazones.setLocationRelativeTo(null);
						sistemaborazones.setVisible(true);
						dispose();
					}else{
						JOptionPane.showMessageDialog((Component)arg0.getSource(), "Lo sentimos, no esta autorizado o la contraseña que ingreso no existe, favor de verificarla, gracias");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog((Component)arg0.getSource(), "Problema de conexión");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Algo paso");
				}
				
			}});
		contentPane.add(btnIniciarSesin);
		
		
		
		
	}

}
