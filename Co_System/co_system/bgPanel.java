import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class bgPanel extends JPanel{
	
	private ImageIcon bg;
	
	public bgPanel(){
		bg = new ImageIcon("CS_bg.jpg");
	}
	
	public void paintComponent(Graphics gp){
		super.paintComponent(gp);
		bg.paintIcon(this, gp, 0, 0);
	}
	
}