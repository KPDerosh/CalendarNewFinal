import java.awt.Graphics2D;
import java.util.ArrayList;


public class Date {

	ArrayList<Event> events = new ArrayList<Event>();
	private int date = 0;
	public Date(int date){
		this.date = date;
	}
	
	public void addEvent(Event event){
		events.add(event);
		
		//TODO: add event to event file
	}

	public void draw(Graphics2D g2d, int pointX, int pointY) {
		g2d.drawRect(pointX, pointY, 150, 150);
		g2d.drawString(date + "", pointX + 10, pointY + 15);
	}
	
	public void setDate(int date){
		this.date = date;
	}
}
