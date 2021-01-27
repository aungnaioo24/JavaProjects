package javaMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller{
	
	public Controller(View view, Model model) {
		
		view.add_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int fnum = Integer.parseInt(view.fnum_tf.getText());
				int snum = Integer.parseInt(view.snum_tf.getText());
				int ans = model.add_btnListener(fnum, snum);
				
				view.ans_tf.setText(""+ans);
				
			}
		});
		
	}
	
}

public class MVC {

	public static void main(String[] args) {
		
		View view = new View();
		Model model = new Model();
		new Controller(view, model);
		
	}

}
