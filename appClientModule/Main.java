//Holo!!!dsad

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;



public class Main {

	/**
	 * @param args
	 * Clase la cual inicia el todo, primero el Splash, seguido del login.
	 */ 
//holo
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = args[0];
		String password = args[1];
		
		Splash spl = new Splash(5000);
		spl.mostrarSplash();
		Sesion ses = null;
		try {
			ses = new Sesion(user, password);
			ses.setLocationRelativeTo(null);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch blockJOptionPane.showMessageDialog((Component)e.getSource(), "Registro Exitoso");
			e.printStackTrace();
			
		}catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(ses, "Correr el jar desde consola con 'java -jar DBMSys.jar (usuario) (contraseña)' de la base de datos", null, 0);
		}
		ses.setVisible(true);
	}
}

class Splash extends JWindow {
	
	private int duración;
		
	public Splash(int dur){
		duración = dur;
	}
	
	public void mostrarSplash(){
		JPanel content = (JPanel)getContentPane();
		 int width = 510;
		 int height =115;
		 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 int x = (screen.width-width)/2;
		 int y = (screen.height-height)/2;
		 setBounds(x,y,width,height);
		 
		 JLabel label = new JLabel(new ImageIcon("Splash.png"));
		 JLabel copyrt = new JLabel
		 ("Copyright 2012, Prog Coders S.A de C.V", JLabel.CENTER);
		 copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		 content.add(label, BorderLayout.CENTER);
		 content.add(copyrt, BorderLayout.SOUTH);

		 setVisible(true);
		 
		 try{
			  Thread.sleep(duración);  
		 }catch (Exception e){
			 
		 }
		 setVisible(false);
	}
	
	public void salidaSplash(){
		mostrarSplash();
		System.exit(0);
	}

}
