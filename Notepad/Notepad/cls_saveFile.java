import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class cls_saveFile extends JPanel{
	
	String filePath;
	File file1;
	
	public void setText(String text, File fname) throws IOException{
		
		file1 = fname;
		if(file1==null){
			
		}else{
			
			filePath = file1.getPath();
			
			if(!filePath.endsWith(".txt")){

				JOptionPane.showMessageDialog(null, "File extension must be (.txt)", "File Error", JOptionPane.ERROR_MESSAGE);
				
			}else{

				PrintWriter pw = new PrintWriter(new FileWriter(filePath));
				pw.print(text);
				pw.close();

			}
			
		}
		
	}
	
	public File getFile(){
		
		return file1;
		
	}
	
	public File saveFile(){
		
		JFileChooser jfc = new JFileChooser();
		int file_button = jfc.showSaveDialog(null);
		
		if(file_button == JFileChooser.CANCEL_OPTION){
			
		}else{
			
			File filename = jfc.getSelectedFile();
			
			if(filename==null||(filename.getName()).equals("")){
				JOptionPane.showMessageDialog(this, "Invalid File Name", "File Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			
			return filename;
			
		}
		
		return null;
		
	}
	
}
