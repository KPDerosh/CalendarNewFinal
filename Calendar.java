import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Calendar extends JPanel  implements ActionListener{
	

	private Theme currentTheme = new Theme();
	private int currentMonth = 0;
	private static ArrayList<Month> months = new ArrayList<Month>();
	private static JButton monthLeft;
	private static JButton monthRight;
	private static JButton addEvent;
	
	public static void main(String[] args) {
		initializeMonths();
		JFrame myFrame = new JFrame("Calendar");
		myFrame.setSize(1500,1000);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.add(new Calendar());
	}
	
	public Calendar(){
		this.setLayout(null);
		monthLeft = new JButton("Previous month");
		monthLeft.setLocation(350, 75);
		monthLeft.setSize(150, 25);
		monthLeft.setEnabled(true);
		monthLeft.setVisible(true);
		monthLeft.setActionCommand("decrement month");
		monthLeft.addActionListener(this);
		add(monthLeft);
		
		monthRight = new JButton("Next month");
		monthRight.setLocation(700, 75);
		monthRight.setSize(150, 25);
		monthRight.setEnabled(true);
		monthRight.setVisible(true);
		monthRight.setActionCommand("increment month");
		monthRight.addActionListener(this);
		add(monthRight);
		
		addEvent = new JButton("Add Event");
		addEvent.setLocation(0, 200);
		addEvent.setSize(100, 100);
		addEvent.setEnabled(true);
		addEvent.setVisible(true);
		addEvent.setActionCommand("add");
		addEvent.addActionListener(this);
		add(addEvent);
		
		this.repaint();

		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if("add".equals(e.getActionCommand())){
        	JFrame add = new JFrame("add");
    		add.setSize(500,300);
    		add.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    		add.setVisible(true);
    		add.add(new AddEventWind());
        }
         else if ("increment month".equals(e.getActionCommand())) {
        	if(currentMonth < 2){
        		currentMonth++;
        	}
        }
        else{
        	if(currentMonth > 0){
        		currentMonth--;
        	}
        }
        this.getParent().getParent().repaint();
        this.repaint();
    }
	 
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(currentTheme.getColor());
		g2d.drawRect(0, 0, 100, 900);			// Draw the toolbar on the side.
		int pointX = 0;
		int pointY = 150;
		
		//Draw the top toolbar. the dimensions should bee 900 X 200. 
		g2d.drawRect(100, 0, 1050, 100);		//OUTLINE OF THE TITLE BAR IS DRAWN HERE
		g2d.drawString("TOP TOOLBAR TEMPLATE OUTLINE", 500, 75);
		g2d.drawRect(100, 100, 1050, 50);
		g2d.drawString("DAYS OF THE WEEK TEMPLATE", 500, 125);
		
		int date = 1;
		int startDay = 0;
		monthRight.repaint();
		monthLeft.repaint();
		addEvent.repaint();
		
		startDay = 0;
		pointX = 100;
		for (int weeks = 0; weeks < 5; weeks++) {
			for (int days = 0; days < 7; days++) {
				if (startDay <= months.get(currentMonth).getStartDate()) {
					g2d.drawRect(pointX, pointY, 150, 150);
					pointX += 150;
					startDay++;
				} else if (date <= 30) {
					months.get(currentMonth).getDays().get(date).draw(g2d, pointX, pointY);
					pointX += 150;
					date++;
				}

			}
			pointY += 150;
			pointX = 100;
		}
	}
	public static void initializeMonths(){
		months.add(new Month(0, 0));
		months.add(new Month(1, 3));
		months.add(new Month(2, 1));
		
	}

}
