import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class index extends JFrame{
	
	JButton mnyb, salb, emb, posb, bnsb, exitb;
	
	public index(){
		
		super("Company System");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1366, 735);
		setLocation(0, 0);
		setResizable(false);
		
		Font fontt = new Font("Serif", Font.PLAIN, 20);
		mnyb = new JButton("Money In/Out");
		mnyb.setFont(fontt);
		mnyb.setBackground(Color.decode("#03d8bc"));
		salb = new JButton("Salaries");
		salb.setFont(fontt);
		salb.setBackground(Color.decode("#34f6ab"));
		emb = new JButton("Employees");
		emb.setFont(fontt);
		emb.setBackground(Color.decode("#e3ff8f"));
		posb = new JButton("Positions");
		posb.setFont(fontt);
		posb.setBackground(Color.decode("#ffa2a2"));
		bnsb = new JButton("Bonus");
		bnsb.setFont(fontt);
		bnsb.setBackground(Color.decode("#f79aff"));
		exitb = new JButton("Exit");
		exitb.setFont(fontt);
		exitb.setBackground(Color.decode("#cb4242"));
		
		posb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new postion();
			}
		});
		
		exitb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		mnyb.setBounds(800, 100, 400, 60);
		salb.setBounds(800, 160, 400, 60);
		emb.setBounds(800, 220, 400, 60);
		posb.setBounds(800, 280, 400, 60);
		bnsb.setBounds(800, 340, 400, 60);
		exitb.setBounds(800, 500, 400, 60);
		
		bgPanel bgP = new bgPanel();
		bgP.setLayout(null);
		
		add(mnyb);
		add(salb);
		add(emb);
		add(posb);
		add(bnsb);
		add(exitb);
		
		add(bgP, BorderLayout.CENTER);

		setVisible(true);
		
	}
	
}
