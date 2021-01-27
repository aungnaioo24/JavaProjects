import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class AddressBookDisplay extends JFrame{

	private List<Person> results;
	private Person currentEntry;
	private PersonQueries personqueries;
	private int numberOfEntries;
	private int currentIndex;
	
	private JButton browseButton;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel idLabel;
	private JTextField idTextField;
	private JTextField indexTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextfield;
	private JTextField maxTextField;
	private JButton nextButton;
	private JLabel ofLabel;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	private JButton previousButton;
	private JButton queryButton;
	private JLabel queryLabel;
	private JPanel queryPanel;
	private JPanel navigatePanel;
	private JPanel displayPanel;
	private JTextField queryTextField;
	private JButton insertButton;
	
	public AddressBookDisplay(){
		
		super("Address Book");
		
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
		
		personqueries = new PersonQueries();
		
		navigatePanel = new JPanel();
		previousButton = new JButton();
		indexTextField = new JTextField(2);
		ofLabel = new JLabel();
		maxTextField = new JTextField(2);
		nextButton = new JButton();
		displayPanel = new JPanel();
		idLabel = new JLabel();
		idTextField = new JTextField(10);
		firstNameLabel = new JLabel();
		firstNameTextField = new JTextField(10);
		lastNameLabel = new JLabel();
		lastNameTextfield = new JTextField(10);
		emailLabel = new JLabel();
		emailTextField = new JTextField(10);
		phoneLabel = new JLabel();
		phoneTextField = new JTextField(10);
		queryPanel = new JPanel();
		queryLabel = new JLabel();
		queryTextField = new JTextField(10);
		queryButton = new JButton();
		browseButton = new JButton();
		insertButton = new JButton();
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		setSize(350, 300);
		setLocation(450, 250);
		setResizable(false);
		
		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
		
		previousButton.setText("Previous");
		previousButton.setEnabled(false);
		previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				previousButtonActionPerformed(evt);
				
			}
			
		});
		
		navigatePanel.add(previousButton);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		indexTextField.setHorizontalAlignment(JTextField.CENTER);
		indexTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				indexTextFieldActionPerformed(evt);
				
			}
			
		});
		
		navigatePanel.add(indexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		ofLabel.setText("of");
		navigatePanel.add(ofLabel);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		maxTextField.setHorizontalAlignment(JTextField.CENTER);
		maxTextField.setEditable(false);
		navigatePanel.add(maxTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		nextButton.setText("Next");
		nextButton.setEnabled(false);
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				nextButtonActionPerformed(evt);
				
			}
		});
		
		navigatePanel.add(nextButton);
		
		add(navigatePanel);
		
		displayPanel.setLayout(new GridLayout(5, 2, 4, 4));
		
		idLabel.setText("Address ID:");
		displayPanel.add(idLabel);
		
		idTextField.setEditable(false);
		displayPanel.add(idTextField);
		
		firstNameLabel.setText("First Name: ");
		displayPanel.add(firstNameLabel);
		displayPanel.add(firstNameTextField);
		
		lastNameLabel.setText("Last Name: ");
		displayPanel.add(lastNameLabel);
		displayPanel.add(lastNameTextfield);
		
		emailLabel.setText("Email: ");
		displayPanel.add(emailLabel);
		displayPanel.add(emailTextField);
		
		phoneLabel.setText("Phone Number: ");
		displayPanel.add(phoneLabel);
		displayPanel.add(phoneTextField);
		
		add(displayPanel);
		
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
		queryPanel.setBorder(BorderFactory.createTitledBorder("Find an entry by last name"));
		queryLabel.setText("Last Name: ");
		queryLabel.add(Box.createHorizontalStrut(5));
		queryPanel.add(queryLabel);
		queryLabel.add(Box.createHorizontalStrut(10));
		queryPanel.add(queryTextField);
		queryLabel.add(Box.createHorizontalStrut(10));
		queryButton.setText("Find");
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
			
				queryButtonActionPerformed(evt);
				
			}
		});
		
		queryPanel.add(queryButton);
		queryLabel.add(Box.createHorizontalStrut(5));
		add(queryPanel);
		
		browseButton.setText("Browse all Entries");
		browseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
				browseButtonActionPerformed(evt);
				
			}
		});
		
		add(browseButton);
		
		insertButton.setText("Insert New Entry");
		insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt){
				// TODO Auto-generated method stub
				
				insertButtonActionPerformed(evt);
			
			}
		});
		
		add(insertButton);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we){
				
				personqueries.close();
				System.exit(0);
				
			}
			
		});
		
	}
	
	private void previousButtonActionPerformed(ActionEvent evt){
		
		currentIndex--;
		
		if(currentIndex<0){
			
			currentIndex = numberOfEntries-1;
			
		}
		
		indexTextField.setText(""+(currentIndex+1));
		indexTextFieldActionPerformed(evt);
		
	}

	private void nextButtonActionPerformed(ActionEvent evt){
		
		currentIndex++;
		
		if(currentIndex>=numberOfEntries){
			
			currentIndex = 0;
			
		}
		
		indexTextField.setText(""+(currentIndex+1));
		indexTextFieldActionPerformed(evt);
		
	}
	
	private void indexTextFieldActionPerformed(ActionEvent evt){
		
		currentIndex = 	(Integer.parseInt(indexTextField.getText())-1);

		if(numberOfEntries != 0 && currentIndex<numberOfEntries){
			
			currentEntry = results.get(currentIndex);
			idTextField.setText(""+currentEntry.getAddressId());
			firstNameTextField.setText(currentEntry.getFirstName());
			lastNameTextfield.setText(currentEntry.getLastName());
			emailTextField.setText(currentEntry.getEmail());
			phoneTextField.setText(currentEntry.getPhoneNumber());
			maxTextField.setText(""+numberOfEntries);
			indexTextField.setText(""+(currentIndex+1));
			
		}
		
	}
	
	private void browseButtonActionPerformed(ActionEvent evt){
		
		try{
			
			results = personqueries.getAllPeople();
			numberOfEntries = results.size();
			
			if(numberOfEntries != 0){
				
				currentIndex = 0;
				currentEntry = results.get(currentIndex);
				idTextField.setText(""+currentEntry.getAddressId());
				firstNameTextField.setText(currentEntry.getFirstName());
				lastNameTextfield.setText(currentEntry.getLastName());
				emailTextField.setText(currentEntry.getEmail());
				phoneTextField.setText(currentEntry.getPhoneNumber());
				maxTextField.setText(""+numberOfEntries);
				indexTextField.setText(""+(currentIndex+1));
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	private void queryButtonActionPerformed(ActionEvent evt){
		
		results = personqueries.getPeopleByLastName(queryTextField.getText());
		numberOfEntries = results.size();
		
		if(numberOfEntries != 0){
			
			currentIndex = 0;
			currentEntry = results.get(currentIndex);
			idTextField.setText(""+currentEntry.getAddressId());
			firstNameTextField.setText(currentEntry.getFirstName());
			lastNameTextfield.setText(currentEntry.getLastName());
			emailTextField.setText(currentEntry.getEmail());
			phoneTextField.setText(currentEntry.getPhoneNumber());
			maxTextField.setText(""+numberOfEntries);
			indexTextField.setText(""+(currentIndex+1));
			nextButton.setEnabled(true);
			previousButton.setEnabled(true);
			
		}
		
	}
	
	private void insertButtonActionPerformed(ActionEvent evt){
		
		int result = personqueries.addPerson(firstNameTextField.getText(), lastNameTextfield.getText(),
				emailTextField.getText(), phoneTextField.getText());
		
		if(result == 1){
			
			JOptionPane.showMessageDialog(this, "Person added!"+result, "Person added", JOptionPane.PLAIN_MESSAGE);
			
		}else{
			
			JOptionPane.showMessageDialog(this, "Person not added!", "Error", JOptionPane.PLAIN_MESSAGE);
			
		}
		
		browseButtonActionPerformed(evt);
		
	}
	
	public static void main(String[] args) {
		
		AddressBookDisplay a = new AddressBookDisplay();
		a.setVisible(true);
		
	}
	
}
