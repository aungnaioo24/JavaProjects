import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class mainFrame extends JFrame{
	
	JMenuBar mnb;
	JMenu mn_file, mn_format, mn_help;
	JMenuItem file_new, file_open, file_save, file_saveas, file_exit, format_wrap, help_about, help_vhelp;
	Container conpan;
	JTextArea t_area;
	
	mainFrame(final String title){

		super(title);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setSize(700, 450);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocation(350, 150);
		mnb = new JMenuBar();
		setJMenuBar(mnb);

		mn_file = new JMenu("File");
		mn_format = new JMenu("Format");
		mn_help = new JMenu("Help");
		
		file_new = new JMenuItem("New");
		file_open = new JMenuItem("Open");
		file_save = new JMenuItem("Save");
		file_save.setEnabled(false);
		file_saveas = new JMenuItem("Save as");
		file_exit = new JMenuItem("Exit");
		file_exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				exitActionListener();
				
			}
			
		});
		
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		mn_file.add(file_saveas);
		mn_file.addSeparator();
		mn_file.add(file_exit);
		
		format_wrap = new JMenuItem("Wrap - off");
		
		mn_format.add(format_wrap);
		
		help_vhelp = new JMenuItem("View help");
		help_about = new JMenuItem("About");
		help_about.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
			
				aboutActionListener();
				
			}
			
		});
		
		mn_help.add(help_vhelp);
		mn_help.add(help_about);
		
		mnb.add(mn_file);
		mnb.add(mn_format);
		mnb.add(mn_help);
		
		t_area = new JTextArea();
		
		Color col = new Color(234, 250, 255);
		t_area.setBackground(col);
		t_area.setWrapStyleWord(true);
		t_area.setLineWrap(true);
		
		JScrollPane jp = new JScrollPane(t_area);
		
		boolean wrapb = true;
		
		format_wrap.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				String cmd = ae.getActionCommand();
				if(cmd == "Wrap - off"){
					
					t_area.setWrapStyleWord(false);
					t_area.setLineWrap(false);
					format_wrap.setText("Wrap - on");
					
				}else if(cmd == "Wrap - on"){
					
					t_area.setWrapStyleWord(true);
					t_area.setLineWrap(true);
					format_wrap.setText("Wrap - off");
					
				}
				
			}
			
		});
		
		file_open.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				cls_fileText ft = new cls_fileText();
				File filename = ft.getFile();
				ft.setText(filename);
				
				t_area.setText(ft.getText());
				
				if(ft.getFilePath().equals("")||!ft.getFilePath().endsWith(".txt"))
					setTitle(title);
				else{
					
					setTitle(ft.getFilePath()+" - "+title);
					file_save.setEnabled(true);
					
				}
					
			}
			
		});
		
		file_saveas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				cls_saveFile sf = new cls_saveFile();
				try {
					
					File fname = sf.saveFile();
					sf.setText(t_area.getText(), fname);

					File filename = sf.getFile();
					
					cls_fileText ft = new cls_fileText();
					ft.setText(filename);
					
					if(ft.getFilePath().equals("")||!ft.getFilePath().endsWith(".txt"))
						setTitle(title);
					else{
						
						setTitle(ft.getFilePath()+" - "+title);
						file_save.setEnabled(true);
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		file_save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				cls_saveFile sf = new cls_saveFile();
				cls_fileText ft = new cls_fileText();
				try {

					File fname = ft.getFile1();
					sf.setText(t_area.getText(), fname);
					ft.setText(fname);
					
					if(ft.getFilePath().equals("")||!ft.getFilePath().endsWith(".txt"))
						setTitle(title);
					else
						setTitle(ft.getFilePath()+" - "+title);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we){
				
				exitActionListener();
				
			}
			
		});
		
		file_new.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				t_area.setText("");
				setTitle(title);
				file_save.setEnabled(false);
				
			}
			
		});
		
		conpan = getContentPane();
		conpan.add(jp);
		
		setVisible(true);
		
	}
	
	private void aboutActionListener(){
		
		JOptionPane.showMessageDialog(this, "Developed by Aung Nai Oo\nVersion - My Note 1.0 :P Blah Blah Blah", "About My Note", JOptionPane.PLAIN_MESSAGE);
		
	}
	
	public void exitActionListener(){
		
		int result = JOptionPane.showConfirmDialog(this, "Are you sure to exit?\nCheck your file have been saved.", "My Note", JOptionPane.OK_CANCEL_OPTION
				, JOptionPane.PLAIN_MESSAGE);
		
		if(result == JOptionPane.OK_OPTION)
			System.exit(0);
			
	}
	
}

class cls_notepad{
	
	public static void main(String[] args) {
		
		new mainFrame("My Note");
		
	}

}
