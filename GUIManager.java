import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class GUIManager {

	private ArrayList<Theme> themes = new ArrayList<Theme>();
	private String currentTheme = "normal";
	private int themeIndex = 0;
	String[] monthArray = {"September", "October", "November"};
	
	public GUIManager(){
		
	}
	
	public void initializeThemes(){
		//initialize normal theme
		themes.add(new Theme(new Color(255, 255, 255),
				       		 new Color(0, 0, 0),
				       		 new Color(0, 0, 0),
				       		 new Color(0, 0, 0),
				       		 new Color(255, 255, 255)
				       		 ));
		//initialize christmas theme
		themes.add(new Theme(new Color(0, 190, 15), 
				   			 new Color(0, 0, 0),
				   			 new Color(0, 0, 0),
				   			 new Color(0, 0, 0),
				   			 new Color(255, 0, 0)
				   			 ));
		//initialize summer theme
		themes.add(new Theme(new Color(0, 225, 255),
							 new Color(0, 0, 0),
							 new Color(0, 0, 0),
							 new Color(0, 0, 0),
							 new Color(255, 191, 0)
				));
	}
	
	public void draw(String currentTheme, int currentMonth, ArrayList<Month> months, Graphics g){
		if(currentTheme.equalsIgnoreCase("normal")){
			this.themeIndex = 0;
		} else if(currentTheme.equalsIgnoreCase("Christmas")){
			this.themeIndex = 1;
		} else if(currentTheme.equalsIgnoreCase("summer")){
			this.themeIndex = 2;
		}
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(themes.get(themeIndex).getBackgroundColor());
		g2d.fillRect(0, 0, 1167,1040);			//Draw the background
		
		g2d.setColor(themes.get(themeIndex).getSideToolbarColor());
		g2d.drawRect(0, 0, 100, 1000);			// Draw the toolbar on the side.
		
		int pointX = 0;
		int pointY = 100;
		
		//Draw the top toolbar. the dimensions should bee 900 X 200. 
		g2d.setColor(themes.get(themeIndex).getTopToolbarColor());
		g2d.drawRect(100, 0, 1050, 50);		//OUTLINE OF THE TITLE BAR IS DRAWN HERE
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g2d.drawString(monthArray[currentMonth], 520, 50);
		
		g2d.setColor(themes.get(themeIndex).getDaysOfTheWeekBarColor());
		//Draw the outline for days of the week
		g2d.drawRect(100, 50, 1050, 50);
		
		
		String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int startX = 100;
		int drawStringX = 100;
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		
		for(int x = 0; x < 7; x++){
			g2d.drawRect(startX, 50, 150, 50);
			startX += 150;
			g2d.drawString(daysOfTheWeek[x], drawStringX, 85);
			drawStringX += 150;
		}
		
		int date = 1;
		int startDay = 0;
		
		startDay = 0;
		pointX = 100;
		for (int weeks = 0; weeks < 6; weeks++) {
			for (int days = 0; days < 7; days++) {
				if (startDay <= months.get(currentMonth).getStartDate()) {
					g2d.setColor(new Color(0, 0, 0));
					g2d.drawRect(pointX, pointY, 150, 150);
					g2d.setColor(new Color(240, 240, 240));
					g2d.fillRect(pointX + 1, pointY + 1, 149, 149);
					pointX += 150;
					startDay++;
				} else if (date <= 30 || (currentMonth == 1 && date <= 31)) {
					g2d.setColor(themes.get(themeIndex).getDaysColor());
					months.get(currentMonth).getDays().get(date).draw(g2d, pointX, pointY);
					pointX += 150;
					date++;
				} else {
					g2d.setColor(new Color(0, 0, 0));
					g2d.drawRect(pointX, pointY, 150, 150);
					g2d.setColor(new Color(240, 240, 240));
					g2d.fillRect(pointX + 1, pointY + 1, 149, 149);
					pointX += 150;
				}
				
			}
			pointY += 150;
			pointX = 100;
		}
	}
	
}
