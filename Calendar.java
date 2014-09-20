import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Calendar extends JPanel  implements ActionListener{
	
	private static ArrayList<Month> months = new ArrayList<Month>();
	private static GUIManager guiManager = new GUIManager();
	private int currentMonth = 0;
	private static JButton monthLeft;
	private static JButton monthRight;
	private static JButton addEvent;
	private static JButton deleteEvent;
	private static JButton normalTheme;
	private static JButton christmasTheme;
	private static JButton fallOrSummerTheme;
	private static JFrame eventWindow;
	private String currentTheme = "normal";
	public static Calendar self;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		initializeMonths();
		guiManager.initializeThemes();
		loadEventsFromFile();
		JFrame myFrame = new JFrame("Calendar");
		myFrame.setSize(1167,1040);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.add(new Calendar());
	}
	
	
	/**
	 * Method to load the events into the calendar from the events file that stores events from previous sessions
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void loadEventsFromFile() throws FileNotFoundException, IOException {
		
		File eventsTxt = new File("events.txt");
		if(!eventsTxt.exists()){
			eventsTxt.createNewFile();
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader("events.txt"))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            
	            String[] objects = line.split(",");
	            for(int x = 0; x < 4; x++){
	            }
	            int monthIndex = 0;
	            int dayIndex = 0;
	            if(objects[1].equalsIgnoreCase("sept")){
	            	monthIndex = 0;
	            } else if(objects[1].equalsIgnoreCase("oct")){
	            	monthIndex = 1;
	            } else {
	            	monthIndex = 2;
	            }
	            dayIndex = Integer.parseInt(objects[0]);
	            months.get(monthIndex).getDays().get(dayIndex).addEvent(new Event(objects[2], objects[3]));
	            line = br.readLine();
	        }
	    }
	}

	public Calendar(){
		this.setLayout(null);
		monthLeft = new JButton("Previous month");
		monthLeft.setLocation(350, 25);
		monthLeft.setSize(150, 25);
		monthLeft.setEnabled(true);
		monthLeft.setVisible(true);
		monthLeft.setActionCommand("decrement month");
		monthLeft.addActionListener(this);
		add(monthLeft);
		
		monthRight = new JButton("Next month");
		monthRight.setLocation(700, 25);
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
		
		deleteEvent = new JButton("Delete event");
		deleteEvent.setLocation(-4, 300);
		deleteEvent.setSize(104, 100);
		deleteEvent.setEnabled(true);
		deleteEvent.setVisible(true);
		deleteEvent.setActionCommand("del");
		deleteEvent.addActionListener(this);
		add(deleteEvent);
		
		normalTheme = new JButton("Default");
		normalTheme.setLocation(0, 450);
		normalTheme.setSize(100, 100);
		normalTheme.setEnabled(true);
		normalTheme.setVisible(true);
		normalTheme.setActionCommand("normalTheme");
		normalTheme.addActionListener(this);
		add(normalTheme);
		
		christmasTheme = new JButton("Christmas");
		christmasTheme.setLocation(0, 550);
		christmasTheme.setSize(100, 100);
		christmasTheme.setEnabled(true);
		christmasTheme.setVisible(true);
		christmasTheme.setActionCommand("christmasTheme");
		christmasTheme.addActionListener(this);
		add(christmasTheme);
		
		fallOrSummerTheme = new JButton("Fall/Summer");
		fallOrSummerTheme.setLocation(0, 650);
		fallOrSummerTheme.setSize(100, 100);
		fallOrSummerTheme.setEnabled(true);
		fallOrSummerTheme.setVisible(true);
		fallOrSummerTheme.setActionCommand("fallOrSummerTheme");
		fallOrSummerTheme.addActionListener(this);
		add(fallOrSummerTheme);
		
		self = this;
		
		this.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if("add".equals(e.getActionCommand())){
        	eventWindow = new JFrame("add");
        	eventWindow.setSize(500,300);
        	eventWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        	eventWindow.setVisible(true);
        	eventWindow.add(new AddEventWind());
        } else if ("del".equals(e.getActionCommand())){
        	eventWindow = new JFrame("Delete Window");
        	eventWindow.setSize(500,300);
        	eventWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        	eventWindow.setVisible(true);
        	eventWindow.add(new DeleteWindOne(eventWindow));
        
        } else if ("increment month".equals(e.getActionCommand())) {
        	if(currentMonth < 2){
        		currentMonth++;
        	}
        } 
        else if ("normalTheme".equals(e.getActionCommand())) {
        	currentTheme = "normal";
        }
        else if ("christmasTheme".equals(e.getActionCommand())) {
        	currentTheme = "Christmas";
        }
        else if ("fallOrSummerTheme".equals(e.getActionCommand())) {
        	currentTheme = "Summer";
        }else {
        	if(currentMonth > 0){
        		currentMonth--;
        	}
        }
		
        this.getParent().getParent().repaint();
        this.repaint();
    }
	 
	@Override
	public void paint(Graphics g) {
		monthRight.repaint();
		monthLeft.repaint();
		addEvent.repaint();
		deleteEvent.repaint();
		normalTheme.repaint();
		christmasTheme.repaint();
		fallOrSummerTheme.repaint();
		
		guiManager.draw(currentTheme, currentMonth, months, g);

	}
	
	public static void addEvent(int day, String monthStr, String loc, String name) throws IOException{
		int month;
		if (monthStr.equalsIgnoreCase("sept")) {
			month = 0;
		} else if (monthStr.equalsIgnoreCase("oct")) {
			month = 1;
		} else {
			month = 2;
		}
		months.get(month).getDays().get(day).addEvent(new Event(name, loc));
		
		FileWriter printWrite = new FileWriter("events.txt", true);
		printWrite.append(day + "," + monthStr + "," + loc + "," + name + "\n");
		printWrite.close();
		eventWindow.dispose();
	}
	
	public static void removeWindow(JFrame oldWindow){
		oldWindow.dispose();
	}
	
	public static ArrayList<Month> getMonths(){

		return months;
	}

	
	public static void initializeMonths(){
		months.add(new Month(0, 0));
		months.add(new Month(1, 2));
		months.add(new Month(2, 5));
		
	}

}
