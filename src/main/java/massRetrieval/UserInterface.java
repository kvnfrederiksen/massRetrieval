package massRetrieval;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.fasterxml.jackson.core.JsonProcessingException;

public class UserInterface extends JFrame {
	
	protected UserInterface(){
		initUI();		
	}
	
	private void initUI(){
		
		JTextField bhRestToken = new JTextField();
		JTextField restUrl = new JTextField();
		JTextField criteria = new JTextField();
		String[] sChoice = {"Appointment", "Candidate", "ClientContact", "JobOrder", "JobSubmission", "Lead", "Note",
				"Opportunity", "Task", "Tearsheet"};
		JComboBox jcbChoice = new JComboBox(sChoice);
		ImageIcon msgicon = new ImageIcon("bullicon.png");
		JLabel toklbl = new JLabel("bhRestToken:");
		JLabel urllbl = new JLabel("REST Url:");
		JLabel critlbl = new JLabel("Criteria:");
		JLabel entlbl = new JLabel("Entity:");
		JButton go = new JButton("Go!");
		jcbChoice.setSelectedIndex(0);
		
		go.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				try {
					Retrieval retrieval = new Retrieval(restUrl.getText(), bhRestToken.getText(), 
							jcbChoice.getSelectedItem().toString(), criteria.getText());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		createLayout(toklbl, bhRestToken, urllbl, restUrl, critlbl, criteria, entlbl, jcbChoice, go);
		
		setIconImage(msgicon.getImage());
		setTitle("Mass Retrieval");
		setSize(300, 245);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void createLayout(JComponent... arg){
		
		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);
		
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGap(50)
				.addGroup(gl.createParallelGroup()
						.addComponent(arg[0])
						.addComponent(arg[1])
						.addComponent(arg[2])
						.addComponent(arg[3])
						.addComponent(arg[4])
						.addComponent(arg[5])
						.addComponent(arg[6])
						.addComponent(arg[7])
						.addComponent(arg[8]))
				.addGap(50)
		);
		
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createSequentialGroup()
						.addComponent(arg[0],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 
								GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[1])
						.addComponent(arg[2],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 
								GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[3])
						.addComponent(arg[4],GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 
								GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[5])
						.addComponent(arg[6])
						.addComponent(arg[7], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 
								GroupLayout.PREFERRED_SIZE)
						.addComponent(arg[8]))
		);
		
		pack();
		
	}
	
}