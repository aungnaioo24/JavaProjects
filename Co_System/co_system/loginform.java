import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class loginform extends JFrame{

	JLabel namel, passl;
	JTextField namet;
	JPasswordField passt;
	JButton loginb;
	
	public loginform(){
		
		super("Company System");
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		Font font = new Font("Serif", Font.PLAIN, 30);
		Font fontt = new Font("Serif", Font.PLAIN, 20);
		
		namel = new JLabel("Admin Name :");
		namel.setFont(font);
		namel.setHorizontalAlignment(JLabel.RIGHT);
		namet = new JTextField();
		namet.setFont(fontt);
		passl = new JLabel("Password :");
		passl.setFont(font);
		passl.setHorizontalAlignment(JLabel.RIGHT);
		passt = new JPasswordField();
		passt.setFont(fontt);
		loginb = new JButton("Login");
		loginb.setFont(fontt);
		
		loginb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				loginbAction();
			}
		});
		
		namel.setBounds(700, 200, 200, 30);
		namet.setBounds(930, 200, 250, 35);
		passl.setBounds(700, 270, 200, 30);
		passt.setBounds(930, 270, 250, 35);
		loginb.setBounds(930, 340, 150, 40);
		
		bgPanel bgP = new bgPanel();
		bgP.setLayout(null);

		add(namel);
		add(namet);
		add(passl);
		add(passt);
		add(loginb);
		
		add(bgP, BorderLayout.CENTER);
	}
	
	private void loginbAction(){
		
		String names = namet.getText();
		String passs = passt.getText();
		
		if(names.equals("")||passs.equals("")){
			JOptionPane.showMessageDialog(this, "Please type name and password", "Company System", JOptionPane.ERROR_MESSAGE);
		}else if(!names.equals("a")||!passs.equals("a")){
			JOptionPane.showMessageDialog(this, "Wrong Admin", "Company System", JOptionPane.ERROR_MESSAGE);
		}else{
			dispose();
			new index();
		}
		
	}
	
	public static void main(String[] args) {
		
		loginform lgf = new loginform();
		lgf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		lgf.setSize(1366, 735);
		lgf.setLocation(0, 0);
		lgf.setVisible(true);
		lgf.setResizable(false);
		
	}

}
