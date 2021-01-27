import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import org.omg.CORBA.IntHolder;

public class cls_EditEmployee extends JFrame{

	JLabel num, name, em_id, phno, post, sal, title;
	JTextField numtf, nametf, em_idtf, phnotf, posttf, saltf, searchtf, hideIdtf;
	JButton Prevbtn, Nextbtn, searchbtn, viewallbtn, editbtn, delbtn;
	JPanel mainpnl;
	cls_Connection conn;
	List<cls_Employees> emps;
	int numOfEntry, currentIndex;
	cls_Employees currentEntry;
	
	public cls_EditEmployee(final String titles) {
		
		super(titles);
		
		setSize(350, 500);
		setResizable(false);
		setLocation(500,130);
		
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
		num = new JLabel("No.", SwingConstants.CENTER);
		name = new JLabel("Name", SwingConstants.CENTER);
		em_id = new JLabel("Employee ID", SwingConstants.CENTER);
		phno = new JLabel("Phone", SwingConstants.CENTER);
		post = new JLabel("Post", SwingConstants.CENTER);
		sal = new JLabel("Sal", SwingConstants.CENTER);
		
		numtf = new JTextField(15);
		numtf.setEditable(false);
		nametf = new JTextField(15);
		nametf.setEditable(false);
		em_idtf = new JTextField(15);
		em_idtf.setEditable(false);
		phnotf = new JTextField(15);
		phnotf.setEditable(false);
		posttf = new JTextField(15);
		posttf.setEditable(false);
		saltf = new JTextField(15);
		saltf.setEditable(false);
		searchtf = new JTextField(15);
		hideIdtf = new JTextField();
		
		Prevbtn = new JButton("<< Previous");
		Nextbtn = new JButton("Next >>");
		searchbtn = new JButton("Search Name");
		viewallbtn = new JButton("View All");
		editbtn = new JButton("Edit");
		delbtn = new JButton("Delete");
		
		Prevbtn.setEnabled(false);
		Nextbtn.setEnabled(false);
		editbtn.setEnabled(false);
		delbtn.setEnabled(false);
		
		viewallbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				viewallbtnActionListener();
			}
		});
		
		Nextbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				nextbtnActionListener();
			}
		});
		
		Prevbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				prevbtnActionListener();
			}
		});
		
		searchbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				searchbtnActionListener();
			}
		});
		
		delbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				delbtnActionListener();
			}
		});
		
		editbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				editbtnActionListener(ae);
			}
		});
		
		setLayout(new BorderLayout());
		mainpnl = new JPanel();
		mainpnl.setLayout(new GridLayout(10, 2, 5, 5));

		mainpnl.add(Prevbtn);
		mainpnl.add(Nextbtn);
		mainpnl.add(num);
		mainpnl.add(numtf);
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
		mainpnl.add(searchtf);
		mainpnl.add(searchbtn);
		mainpnl.add(delbtn);
		mainpnl.add(editbtn);
		mainpnl.add(new JLabel(""));
		mainpnl.add(viewallbtn);
		
		add(title, BorderLayout.NORTH);
		add(mainpnl, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	private void viewallbtnActionListener(){
		
		emps = conn.getAllEmployee();
		numOfEntry = emps.size();
		
		try{
			if(numOfEntry != 0){
				currentIndex = 0;
				currentEntry = emps.get(currentIndex);
				numtf.setText(""+(currentIndex+1)+" of total "+numOfEntry);
				hideIdtf.setText(""+currentEntry.getId());
				nametf.setText(currentEntry.getName());
				em_idtf.setText(currentEntry.getEmId());
				phnotf.setText(currentEntry.getPhone());
				posttf.setText(currentEntry.getPost());
				saltf.setText(""+currentEntry.getSalary());
				searchtf.setText("");
				Prevbtn.setEnabled(true);
				Nextbtn.setEnabled(true);
				editbtn.setEnabled(true);
				delbtn.setEnabled(true);
			}else{
				JOptionPane.showMessageDialog(this, "No Employees are added!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void nextbtnActionListener(){
		
		currentIndex++;
		
		if(currentIndex>=numOfEntry){
			currentIndex = 0;
		}
		
		indexActionListener(currentIndex);
		
	}
	
	private void prevbtnActionListener(){
		
		currentIndex--;
		
		if(currentIndex<0){
			currentIndex = numOfEntry-1;
		}
		
		indexActionListener(currentIndex);
		
	}
	
	private void indexActionListener(int currentId){
		
		currentIndex = currentId;
		
		if((numOfEntry != 0) && (currentIndex<numOfEntry)){
			currentEntry = emps.get(currentIndex);
			numtf.setText(""+(currentIndex+1)+" of total "+numOfEntry);
			hideIdtf.setText(""+currentEntry.getId());
			nametf.setText(currentEntry.getName());
			em_idtf.setText(currentEntry.getEmId());
			phnotf.setText(currentEntry.getPhone());
			posttf.setText(currentEntry.getPost());
			saltf.setText(""+currentEntry.getSalary());
			searchtf.setText("");
		}
		
	}
	
	private void searchbtnActionListener(){

		emps = conn.getSearchEmployee(searchtf.getText());
		numOfEntry = emps.size();
		
		try{
			if(numOfEntry != 0){
				currentIndex = 0;
				currentEntry = emps.get(currentIndex);
				numtf.setText(""+(currentIndex+1)+" of total "+numOfEntry);
				hideIdtf.setText(""+currentEntry.getId());
				nametf.setText(currentEntry.getName());
				em_idtf.setText(currentEntry.getEmId());
				phnotf.setText(currentEntry.getPhone());
				posttf.setText(currentEntry.getPost());
				saltf.setText(""+currentEntry.getSalary());
				Prevbtn.setEnabled(true);
				Nextbtn.setEnabled(true);
				editbtn.setEnabled(true);
				delbtn.setEnabled(true);
			}else{
				JOptionPane.showMessageDialog(this, "No Employees found!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void editbtnActionListener(ActionEvent ae){
		
		String cmd = ae.getActionCommand();
		
		if(cmd == "Edit"){
			Prevbtn.setEnabled(false);
			Nextbtn.setEnabled(false);
			searchbtn.setEnabled(false);
			delbtn.setEnabled(false);
			viewallbtn.setEnabled(false);
			nametf.setEditable(true);
			em_idtf.setEditable(true);
			phnotf.setEditable(true);
			posttf.setEditable(true);
			saltf.setEditable(true);
			searchtf.setEditable(false);
			editbtn.setText("Save");
		}else if(cmd == "Save"){

			int idi, salaryi;
			String names, em_ids, phones, posts;
			
			idi = Integer.parseInt(hideIdtf.getText());
			names = nametf.getText();
			em_ids = em_idtf.getText();
			phones = phnotf.getText();
			posts = posttf.getText();
			salaryi = Integer.parseInt(saltf.getText());
			
			int result = conn.editEmployee(idi, names, em_ids, phones, posts, salaryi);

			if(result == 1){
				JOptionPane.showMessageDialog(this, "1 Employee Edited", "Edit", JOptionPane.INFORMATION_MESSAGE);
				Prevbtn.setEnabled(true);
				Nextbtn.setEnabled(true);
				searchbtn.setEnabled(true);
				delbtn.setEnabled(true);
				viewallbtn.setEnabled(true);
				nametf.setEditable(false);
				em_idtf.setEditable(false);
				phnotf.setEditable(false);
				posttf.setEditable(false);
				saltf.setEditable(false);
				searchtf.setEditable(true);
				editbtn.setText("Edit");
				viewallbtnActionListener();
			}
			else
				JOptionPane.showMessageDialog(this, "no Employee Edited", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void delbtnActionListener(){
		
		searchtf.setText("");
		int id = Integer.parseInt(hideIdtf.getText());
		int result = conn.deleteEmployee(id);
		
		if(result == 1)
			JOptionPane.showMessageDialog(this, "1 Employee deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "no Employee deleted", "Error", JOptionPane.ERROR_MESSAGE);
		
		viewallbtnActionListener();
		
	}
	
}
