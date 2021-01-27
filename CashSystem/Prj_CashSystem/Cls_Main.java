import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Cls_Main extends JFrame{

	JLabel lbAdmin, lbPass, lbTitle;
	JTextField tfAdmin;
	JPasswordField PfPass;
	JButton btnLogin;
	
	public Cls_Main(){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getContentPane().setBackground(Color.decode("#cc9966"));
		setLayout(null);
		
		lbTitle = new JLabel("Cashing System");
		lbAdmin = new JLabel("Admin Name:");
		lbPass = new JLabel("Admin Password:");
		
		tfAdmin = new JTextField();
		PfPass = new JPasswordField();
		
		btnLogin = new JButton("Login");
		
		lbTitle.setBounds(40, 10, 210, 35);
		lbTitle.setFont(new Font("Serif", Font.BOLD, 30));
		lbTitle.setForeground(Color.decode("#660022"));
		add(lbTitle);
		
		lbAdmin.setBounds(10, 110, 115, 23);
		lbAdmin.setFont(new Font("Serif", Font.PLAIN, 20));
		add(lbAdmin);
		
		tfAdmin.setBounds(10, 143, 270, 30);
		add(tfAdmin);
		
		lbPass.setBounds(10, 183, 150, 23);
		lbPass.setFont(new Font("Serif", Font.PLAIN, 20));
		add(lbPass);
		
		PfPass.setBounds(10, 216, 270, 30);
		add(PfPass);
		
		btnLogin.setBounds(150, 286, 130, 40);
		btnLogin.setFont(new Font("Serif", Font.PLAIN, 20));
		add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				login();
			}
		});
		
	}
	
	private void login(){
		String sadmin = tfAdmin.getText();
		String spass = PfPass.getText();
		if(sadmin.equals("a") && spass.equals("a")){
			ItemManage itm = new ItemManage();
			itm.setVisible(true);
			itm.setExtendedState(itm.getExtendedState()|JFrame.MAXIMIZED_BOTH);
			itm.setMinimumSize(new Dimension(1366, 730));
			itm.setTitle("Cash System");
			itm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dispose();
		}else{
			JOptionPane.showMessageDialog(this, "Invalid admin or password", "Login Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		Cls_Main main = new Cls_Main();
		main.setVisible(true);
		main.setSize(300, 450);
		main.setLocation(550, 150);
		main.setTitle("Cash System");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
