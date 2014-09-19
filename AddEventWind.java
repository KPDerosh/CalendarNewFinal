import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AddEventWind extends JPanel  implements ActionListener{

	private static JTextField nameField;
	private static JTextField locField;
	private static JTextField dayField;
	private static JRadioButton septButton;
	private static JRadioButton octButton;
	private static JRadioButton novButton;
	private static JButton done;
	private static String monthStr = "sept";

	public AddEventWind(){

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel name = new JLabel("Name of event");
		name.setText("Name of event");
		name.setVisible(true);
		add(name);
		
		nameField = new JTextField(20);
		nameField.setMaximumSize(new Dimension(500, 25));
		add(nameField);
		
		JLabel loc = new JLabel("Location");
		loc.setText("Location of event");
		loc.setVisible(true);
		add(loc);
		
		locField = new JTextField(20);
		locField.setMaximumSize(new Dimension(500, 25));
		add(locField);
		
		JLabel day = new JLabel("Day");
		day.setText("Day of event");
		day.setVisible(true);
		add(day);
		
		dayField = new JTextField(20);
		dayField.setMaximumSize(new Dimension(500, 25));
		add(dayField);
		
		
		septButton = new JRadioButton("sept");
		septButton.setActionCommand("sept");
		septButton.setSelected(true);
		add(septButton);

		octButton = new JRadioButton("oct");
		octButton.setActionCommand("oct");
		add(octButton);
		
		novButton = new JRadioButton("nov");
		novButton.setActionCommand("nov");
		add(novButton);
		
		//Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(septButton);
		group.add(octButton);
		group.add(novButton);
		
		septButton.addActionListener(this);
	    octButton.addActionListener(this);
	    novButton.addActionListener(this);
	    
		done = new JButton("Done");
		done.setEnabled(true);
		done.setVisible(true);
		done.setActionCommand("done");
		done.addActionListener(this);
		add(done);
		
		this.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 if ("done".equals(e.getActionCommand())) {
	        	//build date and add event
	        }
		 if(e.equals("sept")){
			 monthStr = "sept";
		 }
		 if(e.equals("oct")){
			 monthStr = "oct";
		 }
		 if(e.equals("nov")){
			 monthStr = "nov";
		 }

	}
	
//	@Override
//	public void paint(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g;
//		nameField.repaint();
//		locField.repaint();
//		dayField.repaint();
//		septButton.repaint();
//		octButton.repaint();
//		novButton.repaint();
//		done.repaint();
//		
//	}
}
