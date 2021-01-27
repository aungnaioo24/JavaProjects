
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class bgPanel2 extends JPanel{
	
	private ImageIcon bg;
	
	public bgPanel2(){
		bg = new ImageIcon("CS_bg2.jpg");
	}
	
	public void paintComponent(Graphics gp){
		super.paintComponent(gp);
		bg.paintIcon(this, gp, 0, 0);
	}
	
}