import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cls_intro extends JFrame{
	
	JLabel adminName, adminPass, title;
	JTextField adminNametf;
	JPasswordField adminPasstf;
	JButton addb, viewb;
	JPanel mainpnl;
	
	public cls_intro(final String titles) {
		
		super(titles);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setSize(400, 300);
		setLocation(500, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font1 = new Font("Serif", Font.BOLD, 30);
		Font font = new Font("Serif", Font.BOLD, 15);
		Font font2 = new Font("Serif", Font.PLAIN, 15);
		
		title = new JLabel("Employee List", SwingConstants.CENTER);
		title.setFont(font1);
		title.setForeground(Color.GRAY);
		adminName = new JLabel("Admin Name");
		adminName.setFont(font);
		adminNametf = new JTextField(15);
		adminNametf.setFont(font);
		adminPass = new JLabel("Password");
		adminPass.setFont(font);
		adminPasstf = new JPasswordField(15);
		adminNametf.setFont(font);
		addb = new JButton("Add Employee");
		addb.setFont(font2);
		viewb = new JButton("View List");
		viewb.setFont(font2);
		
		mainpnl = new JPanel();
		
		mainpnl.setLayout(null);
		
		adminName.setBounds(50, 108, 120, 15);
		adminNametf.setBounds(165, 100, 180, 30);
		adminPass.setBounds(50, 158, 120, 15);
		adminPasstf.setBounds(165, 150, 180, 30);
		addb.setBounds(40, 200, 150, 40);
		
		addb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if((adminNametf.getText().trim()).equals("Admin") && ((adminPasstf.getText().trim()).toLowerCase()).equals("adminadmin")){
					new cls_AddEmployee(titles);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Invalid user!", titles, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		viewb.setBounds(210, 200, 150, 40);
		
		viewb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if((adminNametf.getText().trim()).equals("Admin") && ((adminPasstf.getText().trim()).toLowerCase()).equals("adminadmin")){
					new cls_EditEmployee(titles);
					dispose();	
				}else{
					JOptionPane.showMessageDialog(null, "Invalid user!", titles, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		add(adminName);
		add(adminNametf);
		add(adminPass);
		add(adminPasstf);
		add(addb);
		add(viewb);
		
		add(title, BorderLayout.NORTH);
		add(mainpnl, BorderLayout.CENTER);
				
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new cls_intro("Employee List");
		
	}

}
