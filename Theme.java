import java.awt.Color;

public class Theme {

	Color backGround;
	Color sideToolbar;
	Color topToolbar;
	Color daysOfTheWeek;
	Color daysColor;
	
	public Theme(){
		
	}
	
	public Theme(Color backGround, Color sideToolbarColor, Color topToolbarColor, Color daysOfTheWeekBar, Color daysColor){
		this.backGround = backGround;
		this.sideToolbar = sideToolbarColor;
		this.topToolbar = topToolbarColor;
		this.daysOfTheWeek = daysOfTheWeekBar;
		this.daysColor = daysColor;
	}
	
	public Color getBackgroundColor(){
		return this.backGround;
	}

	public Color getSideToolbarColor() {
		return this.sideToolbar;
	}

	public Color getTopToolbarColor() {
		// TODO Auto-generated method stub
		return this.topToolbar;
	}
	
	public Color getDaysOfTheWeekBarColor(){
		return this.daysOfTheWeek;
	}

	public Color getDaysColor() {
		return this.daysColor;
	}
}
