import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Splash spl = new Splash(5000);
		spl.mostrarSplash();
		Login in = new Login();
		in.setVisible(true);
		
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
//		 Color oraRed = new Color(156, 20, 20,  255);
//		 content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

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
