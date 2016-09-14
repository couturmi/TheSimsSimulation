package TheSimsPackage;

/**************************************************************************************
 * The clock that runs in the Sims universe. Runs on a 24-hour day, but each 
 * "Sim hour" is significantly shorter than a real hour (It is actually equal to one minute. Time 
 * speed changes are also available through SimTime. Used in the SimsGame class.
 * @author Mitchell
 * @version 2/16/2015
 **************************************************************************************/

public class SimTime {

	/** Sim Hours = minutes in real time**/
	private int SimHours;
	
	/** Sim Minutes = seconds in real time**/
	private int SimMins;
	
	private String timeOfDay;
	
	/********************************************************
	 * Constructor for the SimTime class
	 ********************************************************/
	public SimTime(){
		SimHours = 12;
		SimMins = 0;
		timeOfDay = "PM";
	}
	
	/**********************************************************
	 * Increments the SimTime by one SimMinute
	 **********************************************************/
	public void inc(){
		SimMins++;
		if(SimMins == 60){
			SimHours++;
			SimMins = 0;
			if(SimHours == 12){
				if(timeOfDay.equals("AM")){
					timeOfDay = "PM";
				}else{
					timeOfDay = "AM";
				}
			}else if(SimHours == 13){
				SimHours = 1;
			}
		}
	}
	/***********************************************************
	 * Returns a string that represents the SimTime
	 ***********************************************************/
	@Override
	public String toString(){
		//adds SimHours
		String s = "" + SimHours + ":";
		//adds SimMins
		if (SimMins < 10)
			s += "0" + SimMins + " ";
		else
			s += SimMins + " ";
		//adds timeOfDay
		s += timeOfDay;
		return s;
	}
}
