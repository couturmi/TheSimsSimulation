package TheSimsPackage;

import java.awt.Color;
import java.util.LinkedList;

/*******************************************************************************
 * A character in the game, a "Sim", which has many individual characteristics 
 * and needs, and can complete actions with game objects.
 * @author Mitchell
 * @version 2/15/2015
 *******************************************************************************/

public class Sim {
	
	/** the first name given to the Sim**/
	private String Fname;
	
	/** the last name given to the Sim**/
	private String Lname;

	/** the gender of the Sim: Male or Female **/
	private Gender gender;
	
	/** the age of the Sim: Child or Adult **/
	private Age age;
	
	/** the color of the dot that represents the Sim **/
	private Color color;
	
	/** determines if the Sim is awake or asleep**/
	private boolean isAwake;
	
	/** is true if not performing an action, is false if performing an action**/
	private boolean actionDone;
	
	/** holds values from 0-59 and determines if it is time to decrement the Sim's Needs**/
	private int needCountDown;
	
	/** measurement of the "hunger" aspect of a Sim's needs **/
	private int nHunger;
	
	/** measurement of the "comfort" aspect of a Sim's needs **/
	private int nComfort;
	
	/** measurement of the "bladder" aspect of a Sim's needs **/
	private int nBladder;
	
	/** measurement of the "energy" aspect of a Sim's needs **/
	private int nEnergy;
	
	/** measurement of the "fun" aspect of a Sim's needs **/
	private int nFun;
	
	/** measurement of the "social" aspect of a Sim's needs **/
	private int nSocial;
	
	/** measurement of the "hygiene" aspect of a Sim's needs **/
	private int nHygiene;
	
	/** measurement of the "enjoyment of environment" aspect of a Sim's needs **/
	private int nEnvironment;
	
	/** total measurement of Sim's needs as a whole, on a scale from {0,100}.**/
	private int nTotal;
	
	/** used in the SimsGame class: the number of objects in the mySimObjects List**/
	private int numOfObjects;
	
	/** list of actions that are in queue of being performed **/
	private LinkedList actionList;
	
	/** Current action being performed **/
	private SimObject action;
	
	/** the simID is a number that represents this specific Sim**/
	private int simID;
	
	/** the total number of Sims being played in the SimsGame**/
	private static int numSims;
	
	/******************************************************
	 * The Constructor for the Sim class
	 * @param fname First name
	 * @param lname Last name
	 * @param g Gender
	 * @param a Age
	 * @param c Color of Sim's dot
	 ******************************************************/
	public Sim(String fname, String lname, Gender g, Age a, Color c){
		Fname = fname;
		Lname = lname;
		gender = g;
		age = a;
		color = c;
		isAwake = true;
		needCountDown = 11;
		numSims++;
		simID = numSims;
		//all default Needs values are set to 75
		nHunger = 75;
		nComfort = 75;
		nBladder = 75;
		nEnergy = 75;
		nFun = 75;
		nSocial = 75;
		nHygiene = 75;
		nEnvironment = 0;
		calcnTotal();
		
		numOfObjects = 0;
		
		actionList = new LinkedList();
		action = null;		//No actions are being performed immediately
		actionDone = true;
	}
	
	public int getNumOfObjects(){
		return numOfObjects;
	}
	
	public void setNumOfObject(int x){
		numOfObjects = x;
	}
	
	/**************************************************************************************
	 * Returns the current action being performed
	 * @return the current action being performed
	 **************************************************************************************/
	public SimObject getAction(){
		return action;
	}
	
	/*************************************************************************************
	 * Adds an action for an object to the queue, which will eventually be performed
	 * @param o Object that the action is to be performed with
	 ************************************************************************************/
	public void addAction(SimObject o){
		actionList.add(o);
	}
	
	/*************************************************************************************
	 * Removes the most recent action in the queue. Will be done either when an action is 
	 * completed or if the user cancels that action.
	 *************************************************************************************/
	public void cancelAction(){
		actionList.remove();
		//and if queue is empty, set the current action to null
		action = null;
	}
	
	/*************************************************************************************
	 * Removes a specified action in the queue. Will be done only if the user cancels 
	 * that action.
	 *************************************************************************************/
	public void cancelAction(SimObject o){
		actionList.remove(o);
		//and if queue is empty, set the current action to null
		action = null;
	}
	
	/************************************************************************************
	 * Method used in the SimsGame class to check if any actions are in the queue
	 * @return boolean
	 ************************************************************************************/
	public boolean checkIfAnyAction(){
		if(actionList.size() == 0)
			return false;
		else
			return true;
	}
	/**************************************************************************************
	 * Method used in the SimsGame class to check if a new action can be performed
	 * @return boolean
	 **************************************************************************************/
	public boolean isActionDone(){
		return actionDone;
	}
	
	/*************************************************************************************
	 * Method used in the SimsGame class to set the value of actionDone
	 *************************************************************************************/
	public void setActionDone(boolean b){
		actionDone = b;
	}
	
	/****************************************************************************************
	 * Changes the current action to the first action in the LinkedList
	 ****************************************************************************************/
	public void performAction(){
		action = (SimObject) actionList.getFirst();
	}
	
	/********************************************************************************************
	 * After every SimHour, this method will run and decrease every SimNeed (except
	 * nEnvironment) by 5. Cannot exceed below 0;
	 ********************************************************************************************/
	private void decNeeds(){
		if(nHunger > 0)
			nHunger -= 1;
		else
			nHunger = 0;
		
		if(nComfort > 0)
			nComfort -= 1;
		else
			nComfort = 0;
		
		if(nBladder > 0)
			nBladder -= 1;
		else
			nBladder = 0;
		
		if(nEnergy > 0)
			nEnergy -= 1;
		else
			nEnergy = 0;
		
		if(nFun > 0)
			nFun -= 1;
		else
			nFun = 0;
		
		if(nSocial > 0)
			nSocial -= 1;
		else
			nSocial = 0;
		
		if(nHygiene > 0)
			nHygiene -= 1;
		else
			nHygiene = 0;
	}
	
	/***************************************************************************
	 * Used in the SimsPanelTest class to check if 12 SimMinutes in this 
	 * Sim's life has passed
	 ***************************************************************************/
	public void checkIfDecNeeds(){
		if(needCountDown == 0){
			decNeeds();
			needCountDown = 11;
		}else{
			needCountDown--;
		}
	}
	
	/***********************************************************************************
	 * Used at the end of an action, to update the Needs for the Sim. Needs cannot
	 * exceed 100.
	 * @param type action object
	 ***********************************************************************************/
	public void setNeedsByObject(SimObject o){
		nHunger += o.getForHunger();
		if(nHunger > 100)
			nHunger = 100;
		nComfort += o.getForComfort();
		if(nComfort > 100)
			nComfort = 100;
		nBladder += o.getForBladder();
		if(nBladder > 100)
			nBladder = 100;
		nEnergy += o.getForEnergy();
		if(nEnergy > 100)
			nEnergy = 100;
		nFun += o.getForFun();
		if(nFun > 100)
			nFun = 100;
		nSocial += o.getForSocial();
		if(nSocial > 100)
			nSocial = 100;
		nHygiene += o.getForHygiene();
		if(nHygiene > 100)
			nHygiene = 100;
	}

	public int getnHunger() {
		return nHunger;
	}

	public void setnHunger(int nHunger) {
		this.nHunger = nHunger;
	}

	public int getnComfort() {
		return nComfort;
	}

	public void setnComfort(int nComfort) {
		this.nComfort = nComfort;
	}

	public int getnBladder() {
		return nBladder;
	}

	public void setnBladder(int nBladder) {
		this.nBladder = nBladder;
	}

	public int getnEnergy() {
		return nEnergy;
	}

	public void setnEnergy(int nEnergy) {
		this.nEnergy = nEnergy;
	}

	public int getnFun() {
		return nFun;
	}

	public void setnFun(int nFun) {
		this.nFun = nFun;
	}

	public int getnSocial() {
		return nSocial;
	}

	public void setnSocial(int nSocial) {
		this.nSocial = nSocial;
	}

	public int getnHygiene() {
		return nHygiene;
	}

	public void setnHygiene(int nHygiene) {
		this.nHygiene = nHygiene;
	}

	public int getnEnvironment() {
		return nEnvironment;
	}

	public void setnEnvironment(int nEnvironment) {
		this.nEnvironment = nEnvironment;
	}
	
	/*********************************************************************************************
	 * Calculates nTotal, which is the average of all of the Sim's Needs
	 *********************************************************************************************/
	public void calcnTotal(){
		int x = nHunger + nComfort + nBladder + nEnergy + nFun + nSocial + nHygiene + nEnvironment;
		nTotal = x / 8;
	}

	/********************************************************************
	 * Returns this Sim's simID
	 * @return simID
	 ********************************************************************/
	public int getSimID() {
		return simID;
	}
	
	/************************************************************************
	 * Sets a new SimID in the case that another Sim is removed or killed
	 * @param x
	 ************************************************************************/
	public void setSimID(int x){
		simID = x;
	}

	/********************************************************************
	 * Returns the total number of Sims created
	 * @return numSims
	 ********************************************************************/
	public static int getNumSims() {
		return numSims;
	}
	
	/*********************************************************************
	 * Decreases the total number of Sims created by 1
	 *********************************************************************/
	public static void decNumSim(){
		numSims--;
	}
	
	/*********************************************************************
	 * Returns the Fname of this Sim
	 * @return Fname
	 *********************************************************************/
	public String getName(){
		return Fname;
	}
	/************************************************************************
	 * Displays all information about the Sim
	 ************************************************************************/
	public String toString(){
		String s = "\n" + Fname +" "+ Lname + "\n";
		s += "Gender: " + gender + "\n";
		s += "Age: " + age + "\n\n";
		s += "Hunger: " + "\t" + nHunger + "\n";
		s += "Energy: " + "\t" + nEnergy + "\n";
		s += "Bladder: " + "\t" + nBladder + "\n";
		s += "Comfort: " + "\t" + nComfort + "\n";
		s += "Fun: " + "\t" + nFun + "\n";
		s += "Social: " + "\t" + nSocial + "\n";
		s += "Hygiene: " + "\t" + nHygiene + "\n";
		s += "Environment: " + "\t" + nEnvironment + "\n";
		if(action != null){
			s += "\nPerforming action with the " + action.toString() + "\n";
		}else{
			s += "\n\n";
		}
		return s;
	}
}
