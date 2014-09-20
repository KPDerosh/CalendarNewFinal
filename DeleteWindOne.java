import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class DeleteWindOne extends JPanel  implements ActionListener{
	private static JTextField dayField;
	private static JRadioButton septButton;
	private static JRadioButton octButton;
	private static JRadioButton novButton;
	private static JButton done;
	private static String monthStr = "sept";
	private static JFrame thisWindow;
	
	public DeleteWindOne(JFrame thisWind){

		thisWindow = thisWind;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel day = new JLabel("Day");
		day.setText("Day of event");
		day.setVisible(true);
		add(day);

		dayField = new JTextField(20);
		dayField.setMaximumSize(new Dimension(500, 25));
		add(dayField);


		septButton = new JRadioButton("September");
		septButton.setActionCommand("sept");
		septButton.setSelected(true);
		add(septButton);

		octButton = new JRadioButton("October");
		octButton.setActionCommand("oct");
		add(octButton);

		novButton = new JRadioButton("November");
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
		//done.setAlignmentY(BOTTOM_ALIGNMENT);
		//done.setAlignmentX(RIGHT_ALIGNMENT);
		done.setActionCommand("done");
		done.addActionListener(this);
		add(done);

		this.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("done".equals(e.getActionCommand())) {
			int day;
			try{
				day = Integer.parseInt(dayField.getText()); 
			}
			catch (NumberFormatException exception){
				day = -1;

			}
			int topday = 30;
			if(monthStr.equals("oct"))
				topday = 31;

			
			int month = 0;
			if(monthStr.equals("sept"))
				month = 0;
			else if(monthStr.equals("oct"))
				month = 1;
			else
				month = 2;
			
			if(day > 0 && day <= topday){
				JFrame delWindow = new JFrame("Delete Window");
	        	delWindow.setSize(500,300);
	        	delWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	        	delWindow.setVisible(true);
	        	delWindow.add(new DeleteWindTwo(Calendar.getMonths().get(month).getDays().get(day), thisWindow, delWindow));
				
			}
			else{
				dayField.setText("Must enter vaild day between 1 and " + topday);
				dayField.setBackground(Color.RED);
			}
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

	
}
