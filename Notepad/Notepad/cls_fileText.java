import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class cls_fileText extends JPanel{

	private String text = "";
	private static File filename;
	private String filepath;
	
	public void setText(File fname){
		
		filename = fname;
		
		if(filename == null){
			
		}else{

			filepath = filename.getPath();
			
			if(!filename.exists()){
				JOptionPane.showMessageDialog(null, "File doesn't exit", "File Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(!filepath.endsWith(".txt")){
				JOptionPane.showMessageDialog(null, "It's not a text file", "File Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				
				try{
					
					BufferedReader bfr = new BufferedReader(new FileReader(filepath));
					
					String str;
					String ttext = "";
					
					while((str = bfr.readLine())!=null){
						
						ttext = ttext + str+"\n";
						
					}
					
					text = ttext;
					
					bfr.close();
					
				}catch(FileNotFoundException fnf){
					
					System.err.println(fnf);
					
				}catch(IOException ie){
					
					System.err.println(ie);
					
				}
				
			}
			
		}
		
	}
	
	public String getText(){
		
		return text;
		
	}
	
	public String getFileName(){
		
		return filepath;
		
	}
	
	public String getFilePath(){
		
		if(filename==null)	
			return "";
		else
			return filename.getPath();
		
	}
	
	public File getFile1(){
		
		return filename;
		
	}
	
	public File getFile(){
		
		JFileChooser jfc = new JFileChooser();		
		int file_buttom = jfc.showOpenDialog(null);
		
		if(file_buttom == JFileChooser.CANCEL_OPTION){
			
		}else{

			File filename = jfc.getSelectedFile();
			
			if(filename==null || filename.equals("")){
				JOptionPane.showMessageDialog(this, "Invalid File Name", "File Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			
			return filename;
			
		}
		
		return null;
		
	}
	
}
