import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class cls_AddEmployee extends JFrame{

	JLabel name, em_id, phno, post, sal, title;
	JTextField nametf, em_idtf, phnotf, posttf, saltf;
	JButton addbtn, clearbtn;
	JPanel mainpnl;
	cls_Connection conn;
	
	public cls_AddEmployee(final String titles) {
		
		super(titles);
		
		setSize(400, 350);
		setLocation(500,200);
		setResizable(false);

		conn = new cls_Connection();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				new cls_intro(titles);
				conn.closeConn();
			}
		});

		Font font1 = new Font("Serif", Font.BOLD, 30);
		title = new JLabel("Employee List", SwingConstants.CENTER);
		title.setFont(font1);
		title.setForeground(Color.GRAY);
		name = new JLabel("Name", SwingConstants.CENTER);
		em_id = new JLabel("Employee ID", SwingConstants.CENTER);
		phno = new JLabel("Phone", SwingConstants.CENTER);
		post = new JLabel("Post", SwingConstants.CENTER);
		sal = new JLabel("Sal", SwingConstants.CENTER);
		
		nametf = new JTextField(15);
		em_idtf = new JTextField(15);
		phnotf = new JTextField(15);
		posttf = new JTextField(15);
		saltf = new JTextField(15);

		addbtn = new JButton("Add Employee");
		addbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				addbtnActionListener();
			}
		});
		
		clearbtn = new JButton("Clear");
		clearbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				clearActionListener();
			}
		});
		
		setLayout(new BorderLayout());
		mainpnl = new JPanel();
		mainpnl.setLayout(new GridLayout(6, 2, 5, 5));

		mainpnl.add(name);
		mainpnl.add(nametf);
		mainpnl.add(em_id);
		mainpnl.add(em_idtf);
		mainpnl.add(phno);
		mainpnl.add(phnotf);
		mainpnl.add(post);
		mainpnl.add(posttf);
		mainpnl.add(sal);
		mainpnl.add(saltf);
		mainpnl.add(clearbtn);
		mainpnl.add(addbtn);
		
		add(title, BorderLayout.NORTH);
		add(mainpnl, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	private void clearActionListener(){
		
		nametf.setText("");
		em_idtf.setText("");
		phnotf.setText("");
		posttf.setText("");
		saltf.setText("");
		
	}
	
	private void addbtnActionListener(){
		
		String names, em_ids, phnos, posts;
		int sali;
		int result;
		
		names = nametf.getText();
		em_ids = em_idtf.getText();
		phnos = phnotf.getText();
		posts = posttf.getText();
		sali = Integer.parseInt(saltf.getText());
		
		result = conn.addEmployee(names, em_ids, phnos, posts, sali);
		
		if (result == 1) {
			JOptionPane.showMessageDialog(null, "Employee added!", "Person added", JOptionPane.INFORMATION_MESSAGE);
			clearActionListener();
		}else{
			JOptionPane.showMessageDialog(null, "Employee doesn't added", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
