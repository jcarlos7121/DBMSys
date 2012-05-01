import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Canvas;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Login extends JFrame {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		try {
//		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//		        if ("Nimbus".equals(info.getName())) {
//		            UIManager.setLookAndFeel(info.getClassName());
//		            break;
//		        }
//		    }
//		} catch (UnsupportedLookAndFeelException e) {
//		    // handle exception
//		} catch (ClassNotFoundException e) {
//		    // handle exception
//		} catch (InstantiationException e) {
//		    // handle exception
//		} catch (IllegalAccessException e) {
//		    // handle exception
//		}
		frame = new JFrame();
		frame.setBounds(100, 100, 428, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BufferedImage im = null;
		
		try {
			im = ImageIO.read(new File("bli.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon ic = new ImageIcon(im);
		
		JLabel lblDbmsystem = new JLabel("DBMSystem");
		lblDbmsystem.setBounds(134, 12, 152, 97);
		lblDbmsystem.setIcon(ic);
		frame.getContentPane().add(lblDbmsystem);
		
		JLabel lblDbmsystem_1 = new JLabel("DBMSystem");
		lblDbmsystem_1.setBounds(164, 145, 122, 14);
		frame.getContentPane().add(lblDbmsystem_1);
		
		JLabel lblVersion = new JLabel("Version 1");
		lblVersion.setBounds(174, 158, 70, 14);
		frame.getContentPane().add(lblVersion);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(83, 195, 70, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(83, 233, 95, 14);
		frame.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 231, 122, 18);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(196, 201, 122, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesiòn");
		btnIniciarSesin.setBounds(263, 271, 140, 14);
		frame.getContentPane().add(btnIniciarSesin);
		
		
		
//		
//		JLabel Label_Imagen;
//		ImageIcon imagenes=new ImageIcon();
//
//
//
//		//Esto va en el init
//
//		Label_Imagen = new javax.swing.JLabel();
//		Label_Imagen.setBounds(10, 10, 300, 370);
//		add(Label_Imagen);
//
//		imagenes=new ImageIcon("bli.png");



		
	}
}

