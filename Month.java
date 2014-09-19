import java.util.ArrayList;


public class Month {
	
	private ArrayList<Date> dates = new ArrayList<Date>();
	private int monthID = 0;
	private int startPointX;
	private int startPointY;
	private int startDate = 0;
	
	
	public Month(int month, int startDate){
		initializeMonth(month);
		this.startDate = startDate;
	}
	
	
	public ArrayList<Date> getDays(){
		return dates;
	}


	public int getStartDate() {
		return startDate;
	}
	
	public void initializeMonth(int monthID){
		this.monthID = monthID;
		if(monthID == 0){
			for(int x = 0; x <= 30; x++ ){
				dates.add(new Date(x));
			}
		} else if(monthID == 1){
			for(int x = 0; x <= 31; x++ ){
				dates.add(new Date(x));
			}
		}
		else {
			for(int x = 0; x <= 30; x++ ){
				dates.add(new Date(x));
			}
		}
	}
	
}
