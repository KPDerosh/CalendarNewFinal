import java.awt.Color;


public class Event {

	private String eventName;
	private String location; 
	private Date date;
	private Color color;
	
	public Event(String name, String loc){
		eventName = name;
		location = loc;
		color = Color.WHITE; //default to white
	}
	
	public Event(String name, String loc, Color col){
		eventName = name;
		location = loc;
		color = col;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		return eventName;
	}

}
