import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class cls_calculator extends JFrame implements ActionListener{

	JTextField tff, viewf;
	JButton oneb, twob, threeb, fourb, fiveb, sixb, sevenb, eightb, nineb, zerob, sumb, subb, multb, divb, equlb, dotb, clearb, delb;
	JPanel btnP;
	String cmd, firsts, seconds;
	float firstf, secondf;
	int operator;
	boolean isDual = false;
	
	public cls_calculator() {
		
		super("Cal++");
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Font font = new Font("Serif", Font.PLAIN, 30);
		btnP = new JPanel();
		tff = new JTextField();
		tff.setEditable(false);
		viewf = new JTextField();
		viewf.setFont(font);
		viewf.setEditable(false);
		viewf.setHorizontalAlignment(JTextField.RIGHT);
		oneb = new JButton("1");
		oneb.addActionListener(this);
		twob = new JButton("2");
		twob.addActionListener(this);
		threeb = new JButton("3");
		threeb.addActionListener(this);
		fourb = new JButton("4");
		fourb.addActionListener(this);
		fiveb = new JButton("5");
		fiveb.addActionListener(this);
		sixb = new JButton("6");
		sixb.addActionListener(this);
		sevenb = new JButton("7");
		sevenb.addActionListener(this);
		eightb = new JButton("8");
		eightb.addActionListener(this);
		nineb = new JButton("9");
		nineb.addActionListener(this);
		zerob = new JButton("0");
		zerob.addActionListener(this);
		sumb = new JButton("+");
		subb = new JButton("-");
		multb = new JButton("*");
		divb = new JButton("/");
		clearb = new JButton("C");
		clearb.addActionListener(this);
		delb = new JButton("Del");
		dotb = new JButton(".");
		dotb.addActionListener(this);
		equlb = new JButton("=");
		
		btnP.setLayout(new GridLayout(5, 4, 5, 5));

		btnP.add(new Label(""));
		btnP.add(new Label(""));
		btnP.add(clearb);
		btnP.add(delb);
		btnP.add(sevenb);
		btnP.add(eightb);
		btnP.add(nineb);
		btnP.add(divb);
		btnP.add(fourb);
		btnP.add(fiveb);
		btnP.add(sixb);
		btnP.add(multb);
		btnP.add(oneb);
		btnP.add(twob);
		btnP.add(threeb);
		btnP.add(subb);
		btnP.add(dotb);
		btnP.add(zerob);
		btnP.add(equlb);
		btnP.add(sumb);
		
		add(viewf, BorderLayout.NORTH);
		add(btnP);
		
		firstf = 0;
		
		sumb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				sumbAction(ae);
			}
		});
		
		subb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				subbAction(ae);
			}
		});
		
		multb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				multbAction(ae);
			}
		});
		
		divb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				divbAction(ae);
			}
		});
		
		equlb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				equlbAction(ae);
			}
		});
		
		delb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				delbAction(ae);
			}
		});
		
	}
	
	private void sumbAction(ActionEvent ae){

		String viewopt = viewf.getText();
		char valiopt = viewopt.charAt(viewopt.length()-1);
		if(valiopt!='+'&&valiopt!='-'&&valiopt!='*'&&valiopt!='/'){
			viewf.setText(viewopt+"+");
		}
		
		if(operator == 1||operator == 2||operator == 3||operator == 4){
			dualOpt();
			operator = 1;
		}else{
			operator = 1;
			firstf = Float.parseFloat(tff.getText());
			tff.setText("");
		}
		
	}
	
	private void subbAction(ActionEvent ae){

		String viewopt = viewf.getText();
		char valiopt = viewopt.charAt(viewopt.length()-1);
		if(valiopt!='+'&&valiopt!='-'&&valiopt!='*'&&valiopt!='/'){
			viewf.setText(viewopt+"-");
		}
		
		if(operator == 1||operator == 2||operator == 3||operator == 4){
			dualOpt();
			operator = 2;
		}else{
			operator = 2;
			firstf = Float.parseFloat(tff.getText());
			tff.setText("");
		}
		
	}
	
	private void multbAction(ActionEvent ae){

		String viewopt = viewf.getText();
		char valiopt = viewopt.charAt(viewopt.length()-1);
		if(valiopt!='+'&&valiopt!='-'&&valiopt!='*'&&valiopt!='/'){
			viewf.setText(viewopt+"*");
		}
		
		if(operator == 1||operator == 2||operator == 3||operator == 4){
			dualOpt();
			operator = 3;
		}else{
			operator = 3;
			firstf = Float.parseFloat(tff.getText());
			tff.setText("");
		}
		
	}

	private void divbAction(ActionEvent ae){

		String viewopt = viewf.getText();
		char valiopt = viewopt.charAt(viewopt.length()-1);
		if(valiopt!='+'&&valiopt!='-'&&valiopt!='*'&&valiopt!='/'){
			viewf.setText(viewopt+"/");
		}
		
		if(operator == 1||operator == 2||operator == 3||operator == 4){
			dualOpt();
			operator = 4;
		}else{
			operator = 4;
			firstf = Float.parseFloat(tff.getText());
			tff.setText("");
		}
		
	}
	
	private void equlbAction(ActionEvent ae){

		float ans;
		try{
			secondf = Float.parseFloat(tff.getText());
		}catch(NumberFormatException nfe){
			secondf = 0;
		}
		
		if(operator==1){
			ans = firstf+secondf;
			tff.setText(""+ans);
			viewf.setText(""+ans);
			operator = 0;
		}

		if(operator==2){
			ans = firstf-secondf;
			tff.setText(""+ans);
			viewf.setText(""+ans);
			operator = 0;
		}

		if(operator==3){
			ans = firstf*secondf;
			tff.setText(""+ans);
			viewf.setText(""+ans);
			operator = 0;
		}

		if(operator==4){
			ans = firstf/secondf;
			tff.setText(""+ans);
			viewf.setText(""+ans);
			operator = 0;
		}
		
	}
	
	private void dualOpt(){
		
		isDual = true;
		
		if(operator == 1){
			try{
				secondf = Float.parseFloat(tff.getText());
			}catch(NumberFormatException nfe){
				secondf = 0;
			}
			
			firstf = firstf+secondf;
			
			tff.setText(""+(firstf));
			
		}

		if(operator == 2){
			try{
				secondf = Float.parseFloat(tff.getText());
			}catch(NumberFormatException nfe){
				secondf = 0;
			}
			
			firstf = firstf-secondf;
			
			tff.setText(""+(firstf));
			
		}

		if(operator == 3){
			try{
				secondf = Float.parseFloat(tff.getText());
			}catch(NumberFormatException nfe){
				secondf = 0;
			}
			
			firstf = firstf*secondf;
			
			tff.setText(""+(firstf));
			
		}

		if(operator == 4){
			try{
				secondf = Float.parseFloat(tff.getText());
			}catch(NumberFormatException nfe){
				secondf = 0;
			}
			
			firstf = firstf/secondf;
			
			tff.setText(""+(firstf));
			
		}
		
	}
	
	private void delbAction(ActionEvent ae){

		StringBuilder builder = new StringBuilder();
		StringBuilder builder2 = new StringBuilder();
		String temp = tff.getText();
		String temp2 = viewf.getText();
		builder.insert(0, temp);
		builder2.insert(0, temp2);
		try{
			builder.deleteCharAt(temp.length()-1);
			tff.setText(builder.toString());
			builder2.deleteCharAt(temp2.length()-1);
			viewf.setText(builder2.toString());
		}catch(StringIndexOutOfBoundsException siobe){
			;
		}
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		String txt="";
		cmd = ae.getActionCommand();
		
		String vtxt = viewf.getText();
		if(cmd == "1"){			
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"1");
				viewf.setText(vtxt+"1");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"1");
				viewf.setText(vtxt+"1");
			}
		}else if(cmd == "2"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"2");
				viewf.setText(vtxt+"2");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"2");
				viewf.setText(vtxt+"2");
			}
		}else if(cmd == "3"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"3");
				viewf.setText(vtxt+"3");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"3");
				viewf.setText(vtxt+"3");
			}
		}else if(cmd == "4"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"4");
				viewf.setText(vtxt+"4");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"4");
				viewf.setText(vtxt+"4");
			}
		}else if(cmd == "5"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"5");
				viewf.setText(vtxt+"5");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"5");
				viewf.setText(vtxt+"5");
			}
		}else if(cmd == "6"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"6");
				viewf.setText(vtxt+"6");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"6");
				viewf.setText(vtxt+"6");
			}
		}else if(cmd == "7"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"7");
				viewf.setText(vtxt+"7");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"7");
				viewf.setText(vtxt+"7");
			}
		}else if(cmd == "8"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"8");
				viewf.setText(vtxt+"8");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"8");
				viewf.setText(vtxt+"8");
			}
		}else if(cmd == "9"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"9");
				viewf.setText(vtxt+"9");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"9");
				viewf.setText(vtxt+"9");
			}
		}else if(cmd == "0"){
			if(!isDual){
				txt = tff.getText();
				tff.setText(txt+"0");
				viewf.setText(vtxt+"0");
			}else{
				tff.setText("");
				isDual = false;
				txt = tff.getText();
				tff.setText(txt+"0");
				viewf.setText(vtxt+"0");
			}
		}else if(cmd == "C"){
			tff.setText("");
			viewf.setText("");
			operator = 0;
		}else if(cmd == "."){

			txt = tff.getText();
			if(!txt.contains(".")){
				tff.setText(txt+".");
				viewf.setText(vtxt+".");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		cls_calculator cal = new cls_calculator();
		cal.setSize(300, 350);
		cal.setLocation(500, 200);
		cal.setResizable(false);
		cal.setVisible(true);
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
