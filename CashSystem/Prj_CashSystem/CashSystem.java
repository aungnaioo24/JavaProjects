import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

import javax.swing.table.*;

public class CashSystem extends JFrame{

	PrintJob pj;
	CashSystemDB db;
	JLabel lbTitle, lbCode, lbQty;
	JTextField tfCode, tfQty;
	JButton btnAdd, btnDelete, btnClear, btnPrint;
	JTable tbItemList;
	JTextArea taShowPrint;
	String[] col = {"No.", "Item Name", "Item Code", "Qty", "Price", "Discount", "Total"};
	DefaultTableModel tableModel;
	int code, qty;
	static int no = 0;
	ArrayList<Item> tablesaved;
	
	public CashSystem(){
		
		db = new CashSystemDB();
		
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
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we){
				db.closeConn();
				System.exit(0);
			}
			
		});
		
		getContentPane().setBackground(Color.decode("#cc9966"));
		setLayout(null);
		
		lbTitle = new JLabel("Cash System");
		lbTitle.setFont(new Font("Serif", Font.BOLD, 50));
		lbTitle.setForeground(Color.decode("#000000"));
		lbTitle.setBounds(10, 10, 700, 60);
		
		Font lblFont = new Font("Serif", Font.PLAIN, 25);
		Font txtFont = new Font("Serif", Font.PLAIN, 20);
		Font tbFont = new Font("Serif", Font.PLAIN, 18);
		
		lbCode = new JLabel("Item Code:");
		lbCode.setFont(lblFont);
		lbCode.setBounds(50, 150, 150, 30);
		
		tfCode = new JTextField("");
		tfCode.setFont(txtFont);
		tfCode.setBounds(200, 150, 200, 30);
		
		lbQty = new JLabel("Quantity:");
		lbQty.setFont(lblFont);
		lbQty.setBounds(450, 150, 150, 30);
		
		tfQty = new JTextField();
		tfQty.setFont(txtFont);
		tfQty.setBounds(600, 150, 200, 30);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(txtFont);
		btnAdd.setBounds(850, 145, 100, 40);
		
		tbItemList = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(col);
		tbItemList.setModel(tableModel);
		tbItemList.setRowHeight(30);
		JTableHeader tbHead = tbItemList.getTableHeader();
		tbHead.setFont(txtFont);
		tbHead.setReorderingAllowed(false);
		tbHead.setOpaque(false);
		tbHead.setBackground(Color.DARK_GRAY);
		tbHead.setForeground(Color.WHITE);
		tbItemList.setFont(txtFont);
		JScrollPane spScrollTable = new JScrollPane(tbItemList);
		spScrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spScrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		spScrollTable.setBounds(50, 200, 900, 400);
		
		String showTxt = "";
		
		taShowPrint = new JTextArea(""+showTxt);
		taShowPrint.setFont(tbFont);
		taShowPrint.setEditable(false);
		taShowPrint.setBounds(1000, 200, 300, 400);
		taShowPrint.setBorder(LineBorder.createBlackLineBorder());
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(txtFont);
		btnDelete.setBounds(50, 620, 100, 40);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(txtFont);
		btnClear.setBounds(170, 620, 100, 40);
		
		btnPrint = new JButton("Print (F11)");
		btnPrint.setFont(txtFont);
		btnPrint.setBounds(1000, 620, 120, 40);
		
		add(lbTitle);
		add(lbCode);
		add(tfCode);
		add(lbQty);
		add(tfQty);
		add(btnAdd);
		add(spScrollTable);
		add(taShowPrint);
		add(btnClear);
		
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				btnAddAction();
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				while(tableModel.getRowCount()>0){
					tableModel.removeRow(0);
				}
			}
		});
		
		btnPrint.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
	}
	
	private void btnPrintAction(){
		tablesaved = new ArrayList<Item>();
		for(int row=0; row<tableModel.getRowCount(); row++){
			tablesaved.add(new Item(""+tableModel.getValueAt(row, 1), Integer.parseInt(""+tableModel.getValueAt(row, 2)), Integer.parseInt(""+tableModel.getValueAt(row, 3)), Integer.parseInt(""+tableModel.getValueAt(row, 4)), Integer.parseInt(""+tableModel.getValueAt(row, 5))));
		}
		
		int result = db.addItem(tablesaved);
		if(result == 1){
			JOptionPane.showMessageDialog(this, "Item is added!", "Item Added", JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(this, "Error. Item can\'t added!", "Add Item Error", JOptionPane.ERROR_MESSAGE);
		};
	}
	
	private void btnAddAction(){
		code = Integer.parseInt(tfCode.getText());
		qty = Integer.parseInt(tfQty.getText());
		
		String nametb;
		int codetb;
		int prizetb;
		int discounttb;
		int total;		
		
		ResultSet result = db.getItem(code);
		
		try{
			if(result.next()){
				nametb = result.getString("item_name");
				codetb = result.getInt("item_code");
				prizetb = result.getInt("item_prize");
				discounttb = result.getInt("item_discount");
				total = ((prizetb-discounttb)*qty);
				no++;
				tableModel.addRow(new Object[]{no, nametb, codetb, qty, prizetb, discounttb, total});
				tfCode.setText("");
				tfQty.setText("");
			}else{
				JOptionPane.showMessageDialog(this, "Adding item to table Error!", "Add Item Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch(SQLException sqe){
			sqe.printStackTrace();
			db.closeConn();
		}finally{
			try{
				result.close();
			}catch(SQLException sqe){
				sqe.printStackTrace();
				db.closeConn();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		CashSystem cs = new CashSystem();
		cs.setVisible(true);
		cs.setTitle("Cash System");
	}

}
