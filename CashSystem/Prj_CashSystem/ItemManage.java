import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class ItemManage extends JFrame{

	JLabel lbTitle, lbItCode, lbItName, lbItQty, lbItPrize, lbItDiscount, lbsCode, lbsName, lbsQty, lbsPrize, lbsDiscount, lbsDate, tfDate;
	JTextField tfItCode, tfItName, tfItQty, tfItPrize, tfItDiscount, tfCode, tfName, tfQty, tfPrize, tfDiscount;
	JButton btnEdit, btnSave, btnDelete, btnNext, btnPrevious, btnAdd;
	ItemManageDB db;
	List<Item> items;
	int numOfItems, currentIndex, rid, tfid;
	Item currentItem;
	
	public ItemManage(){

		db = new ItemManageDB();
		
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
		
		lbTitle = new JLabel("Item Management System");
		lbTitle.setFont(new Font("Serif", Font.BOLD, 50));
		lbTitle.setForeground(Color.decode("#660022"));
		lbTitle.setBounds(10, 10, 700, 60);
		
		Font lblFont = new Font("Serif", Font.PLAIN, 25);
		Font txtFont = new Font("Serif", Font.PLAIN, 20);
		
		lbItCode = new JLabel("Item Code:");
		lbItCode.setFont(lblFont);
		lbItCode.setBounds(50, 200, 200, 30);
		
		tfItCode = new JTextField();
		tfItCode.setFont(txtFont);
		tfItCode.setBounds(250, 200, 200, 30);
		
		lbItName = new JLabel("Item Name:");
		lbItName.setFont(lblFont);
		lbItName.setBounds(50, 250, 200, 30);
		
		tfItName = new JTextField();
		tfItName.setFont(txtFont);
		tfItName.setBounds(250, 250, 200, 30);
		
		lbItQty = new JLabel("Quantity:");
		lbItQty.setFont(lblFont);
		lbItQty.setBounds(50, 300, 200, 30);
		
		tfItQty = new JTextField();
		tfItQty.setFont(txtFont);
		tfItQty.setBounds(250, 300, 200, 30);
		
		lbItPrize = new JLabel("Prize:");
		lbItPrize.setFont(lblFont);
		lbItPrize.setBounds(50, 350, 200, 30);
		
		tfItPrize = new JTextField();
		tfItPrize.setFont(txtFont);
		tfItPrize.setBounds(250, 350, 200, 30);
		
		lbItDiscount = new JLabel("Discount:");
		lbItDiscount.setFont(lblFont);
		lbItDiscount.setBounds(50, 400, 200, 30);
		
		tfItDiscount = new JTextField();
		tfItDiscount.setFont(txtFont);
		tfItDiscount.setBounds(250, 400, 200, 30);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(txtFont);
		btnAdd.setBounds(350, 450, 100, 40);
		
		lbsCode = new JLabel("Item Code:");
		lbsCode.setFont(lblFont);
		lbsCode.setBounds(800, 200, 200, 30);
		
		tfCode = new JTextField();
		tfCode.setFont(txtFont);
		tfCode.setEditable(false);
		tfCode.setBounds(1000, 200, 200, 30);
		
		lbsName = new JLabel("Item Name:");
		lbsName.setFont(lblFont);
		lbsName.setBounds(800, 250, 200, 30);
		
		tfName = new JTextField();
		tfName.setFont(txtFont);
		tfName.setEditable(false);
		tfName.setBounds(1000, 250, 200, 30);
		
		lbsDate = new JLabel("Date:");
		lbsDate.setFont(lblFont);
		lbsDate.setBounds(800, 300, 200, 30);
		
		tfDate = new JLabel();
		tfDate.setFont(lblFont);
		tfDate.setBounds(1000, 300, 220, 30);
		
		lbsQty = new JLabel("Quantity: ");
		lbsQty.setFont(lblFont);
		lbsQty.setBounds(800, 350, 200, 30);
		
		tfQty = new JTextField();
		tfQty.setFont(txtFont);
		tfQty.setEditable(false);
		tfQty.setBounds(1000, 350, 200, 30);
		
		lbsPrize = new JLabel("Prize:");
		lbsPrize.setFont(lblFont);
		lbsPrize.setBounds(800, 400, 200, 30);
		
		tfPrize = new JTextField();
		tfPrize.setFont(txtFont);
		tfPrize.setEditable(false);
		tfPrize.setBounds(1000, 400, 200, 30);
		
		lbsDiscount = new JLabel("Discount:");
		lbsDiscount.setFont(lblFont);
		lbsDiscount.setBounds(800, 450, 200, 30);
		
		tfDiscount = new JTextField();
		tfDiscount.setFont(txtFont);
		tfDiscount.setEditable(false);
		tfDiscount.setBounds(1000, 450, 200, 30);
		
		btnPrevious = new JButton("<<");
		btnPrevious.setFont(lblFont);
		btnPrevious.setBounds(800, 500, 100, 40);
		
		btnNext = new JButton(">>");
		btnNext.setFont(lblFont);
		btnNext.setBounds(1100, 500, 100, 40);
		
		btnEdit = new JButton("Edit");
		btnEdit.setFont(txtFont);
		btnEdit.setBounds(800, 560, 100, 40);
		
		btnSave = new JButton("Save");
		btnSave.setFont(txtFont);
		btnSave.setEnabled(false);
		btnSave.setBounds(950, 560, 100, 40);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(txtFont);
		btnDelete.setBounds(1100, 560, 100, 40);
		
		add(lbTitle);
		add(lbItCode);
		add(tfItCode);
		add(lbItName);
		add(tfItName);
		add(lbItQty);
		add(tfItQty);
		add(lbItPrize);
		add(tfItPrize);
		add(lbItDiscount);
		add(tfItDiscount);
		add(btnAdd);
		add(lbsCode);
		add(tfCode);
		add(lbsName);
		add(tfName);
		add(lbsDate);
		add(tfDate);
		add(lbsQty);
		add(tfQty);
		add(lbsPrize);
		add(tfPrize);
		add(lbsDiscount);
		add(tfDiscount);
		add(btnPrevious);
		add(btnNext);
		add(btnEdit);
		add(btnSave);
		add(btnDelete);
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				btnAddAction();
			}
		});

		loadItems();
		viewItem();
		
		btnNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				btnNextAction();
			}
		});
		
		btnPrevious.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				btnPreviousAction();
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				btnEditAction();
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				btnSaveAction();
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				btnDeleteAction();
			}
		});
		
	}
	
	private void loadItems(){
		items = db.getAllItems();
		numOfItems = items.size();
		
		currentIndex = 0;
	}
	
	private void viewItem(){
		
		if(items.isEmpty()){
			tfCode.setText("");
			tfName.setText("");
			tfQty.setText("");
			tfPrize.setText("");
			tfDiscount.setText("");
			tfDate.setText("");
			btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);
			btnPrevious.setEnabled(false);
			btnNext.setEnabled(false);
		}else{
			if(numOfItems > 0 && currentIndex<numOfItems){
				
				currentItem = items.get(currentIndex);
				
				tfid = currentItem.getId();
				tfCode.setText(""+currentItem.getCode());
				tfName.setText(currentItem.getName());
				tfDate.setText(currentItem.getDate().substring(0, 19));
				tfQty.setText(""+currentItem.getQty());
				tfPrize.setText(""+currentItem.getPrize());
				tfDiscount.setText(""+currentItem.getDiscount());
			}
		}
		
	}
	
	private void btnDeleteAction(){
		
		int result = db.deleteItem(tfid);
		loadItems();
		viewItem();
		
		if(result == 1)
			JOptionPane.showMessageDialog(this, "1 Item deleted", "Delete Item", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "no Item deleted", "Delete Item", JOptionPane.ERROR_MESSAGE);
		
	}
	
	private void btnNextAction(){
		currentIndex++;
		
		if(currentIndex >= numOfItems){
			currentIndex = 0;
		}
		
		viewItem();
	}
	
	private void btnPreviousAction(){
		currentIndex--;
		
		if(currentIndex<0){
			currentIndex = numOfItems-1;
		}
		
		viewItem();
	}
	
	private void btnAddAction(){
		String name;
		int code, qty, prize, discount;
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		name = tfItName.getText();
		code = Integer.parseInt(tfItCode.getText());
		qty = Integer.parseInt(tfItQty.getText());
		prize = Integer.parseInt(tfItPrize.getText());
		discount = Integer.parseInt(tfItDiscount.getText());
		
		rid = db.addItem(name, currentTime, code, qty, prize, discount);
		
		if(rid>0){
			JOptionPane.showMessageDialog(this, "Item is added!", "Item Added", JOptionPane.INFORMATION_MESSAGE);
			items.add(new Item(rid, name, code, qty, prize, discount, currentTime));
			currentIndex = numOfItems++;
			viewItem();
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
			tfItName.setText("");
			tfItCode.setText("");
			tfItQty.setText("");
			tfItPrize.setText("");
			tfItDiscount.setText("");
		}else{
			JOptionPane.showMessageDialog(this, "Error. Item can\'t added!", "Add Item Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void btnEditAction(){
		btnEdit.setEnabled(false);
		btnSave.setEnabled(true);
		btnPrevious.setEnabled(false);
		btnNext.setEnabled(false);
		btnDelete.setEnabled(false);
		tfCode.setEditable(true);
		tfName.setEditable(true);
		tfQty.setEditable(true);
		tfPrize.setEditable(true);
		tfDiscount.setEditable(true);
	}
	
	private void btnSaveAction(){
		String name, date;
		int code, qty, prize, discount;
		
		name = tfName.getText();
		date = tfDate.getText();
		code = Integer.parseInt(tfCode.getText());
		qty = Integer.parseInt(tfQty.getText());
		prize = Integer.parseInt(tfPrize.getText());
		discount = Integer.parseInt(tfDiscount.getText());
		
		int result = db.updateItem(tfid, name, date, code, qty, prize, discount);
		if(result == 1){
			items.set(currentIndex, new Item(tfid, name, code, qty, prize, discount, date));
			JOptionPane.showMessageDialog(this, "Item successfully Edited!", "Edit Item", JOptionPane.INFORMATION_MESSAGE);
			btnEdit.setEnabled(true);
			btnSave.setEnabled(false);
			btnPrevious.setEnabled(true);
			btnNext.setEnabled(true);
			btnDelete.setEnabled(true);
			tfCode.setEditable(false);
			tfName.setEditable(false);
			tfQty.setEditable(false);
			tfPrize.setEditable(false);
			tfDiscount.setEditable(false);
		}else{
			JOptionPane.showMessageDialog(this, "Error item editing!", "Edit Item", JOptionPane.ERROR_MESSAGE);
		}
	}

}
