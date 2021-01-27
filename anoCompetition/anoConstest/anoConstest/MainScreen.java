package anoConstest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainScreen extends JFrame{

	JLabel nameLb, passLb;
	JTextField nameTf;
	JPasswordField passTf;
	JButton loginBtn;
	
	public MainScreen() {
		
		nameLb = new JLabel("Adminstrator:");
		passLb = new JLabel("Password:");
		nameTf = new JTextField(25);
		passTf = new JPasswordField(25);
		loginBtn = new JButton("Login");
		
		setLayout(null);
		nameLb.setBounds(100, 100, 100, 30);
		nameTf.setBounds(200, 100, 200, 30);
		passLb.setBounds(100, 150, 100, 30);
		passTf.setBounds(200, 150, 200, 30);
		loginBtn.setBounds(300, 200, 100, 40);
		loginBtn.setBackground(Color.BLUE);
		loginBtn.setForeground(Color.WHITE);
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AdminPage ap = new AdminPage();
				ap.setSize(1300, 720);
				ap.setLocation(10, 10);
				ap.setTitle("Adminstratoin Page");
				ap.setVisible(true);
				
			}
		});
		
		add(nameLb);
		add(nameTf);
		add(passLb);
		add(passTf);
		add(loginBtn);
	}
	
}
