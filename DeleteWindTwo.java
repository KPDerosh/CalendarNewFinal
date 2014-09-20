import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class DeleteWindTwo extends JPanel  implements ActionListener{

	private static DefaultListModel<Event> eventList;
	private static JList<Event> chooser;
	private static JButton done;
	private static Date day;
	private static JFrame thisWindow;
	
	public DeleteWindTwo(Date day, JFrame oldWind, JFrame thisWind){
		
		JLabel select = new JLabel("Select");
		select.setText("Select Event");
		select.setVisible(true);
		add(select);
		
		thisWindow = thisWind;
		oldWind.dispose();
		this.day = day;
		ArrayList<Event> arr = day.events;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		eventList = new DefaultListModel<Event>();
		
		for(Event temp: arr){
			eventList.addElement(temp);
		}
		
		chooser = new JList<Event>(eventList);
		chooser.setAlignmentX(LEFT_ALIGNMENT);
		//chooser.
		chooser.setBackground(Color.white);
		//chooser.
		chooser.setMinimumSize(new Dimension(500, 500 ));
		add(chooser);

		
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
		int index = chooser.getSelectedIndex();
		day.events.remove(chooser.getSelectedValue());
		thisWindow.dispose();
		Calendar.self.repaint();
		
	}
}
