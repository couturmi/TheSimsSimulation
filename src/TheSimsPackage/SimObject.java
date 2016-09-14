package TheSimsPackage;

/*************************************************************
 * The base class for all Sims objects.
 * @author Mitchell Couturier
 * @version 2/16/2015
 *************************************************************/

public abstract class SimObject {

	/** The type of Object that the Sim Object is: bed, chair, lamp, TV, fridge, etc.**/
	private SimObjectType oType;
	
	/** The class of Object that the SimObject is: Furniture, Electrical, Plumbing, Kitchen, 
	 * Decoration, or Misc **/
	private String oClass;
	
	/** The title of the action performed on this object **/
	private String title;
	
	/** Determines if the object can be used for actions**/
	private boolean isActionObject;
	
	/** The time in SimMinutes that it takes to complete an action on this object**/
	private int timeToComplete;
	
	/** Gives the amount the SimObject affects a Sim's Hunger Needs for the time it takes to complete**/
	private int forHunger;
	
	/** Gives the amount the SimObject affects a Sim's Comfort Needs for the time it takes to complete**/
	private int forComfort;
	
	/** Gives the amount the SimObject affects a Sim's Bladder Needs for the time it takes to complete**/
	private int forBladder;
	
	/** Gives the amount the SimObject affects a Sim's Energy Needs for the time it takes to complete**/
	private int forEnergy;
	
	/** Gives the amount the SimObject affects a Sim's Fun Needs for the time it takes to complete**/
	private int forFun;
	
	/** Gives the amount the SimObject affects a Sim's Social Needs for the time it takes to complete**/
	private int forSocial;
	
	/** Gives the amount the SimObject affects a Sim's Hygiene Needs for the time it takes to complete**/
	private int forHygiene;
	
	/** Gives the amount the SimObject affects a Sim's Environment Needs**/
	private int forEnvironment;
	
	//add a time instances variable for the length of time that it takes to perform
	
	/********************************************************************
	 * Constructor for the SimObject class
	 * @param t the type of object
	 ********************************************************************/
	public SimObject(SimObjectType t){
		oType = t;
		setObject();
	}
	
	/***************************************************************************************************
	 * Sets all the necessary information about the object, such as what Needs it addresses and what 
	 * the title of its action is.
	 ***************************************************************************************************/
	public abstract void setObject();
	
	/****************************************************************
	 * Returns the SimObjectType for this object
	 * @return SimObjectType
	 ****************************************************************/
	public SimObjectType objectType(){
		return oType;
	}
	
	/***************************************************************
	 * Sets the ObjectClass of the SimObject
	 * @param s ObjectClass
	 ***************************************************************/
	public void setObjectClass(String s){
		oClass = s;
	}
	
	/*****************************************************************
	 * Returns the ObjectClass of the SimObject
	 * @return oClass
	 *****************************************************************/
	public String getObjectClass(){
		return oClass;
	}
	
	/****************************************************************
	 * Sets the title for the action of the SimObject
	 * @param s title of the action
	 ****************************************************************/
	public void setTitle(String s){
		title = s;
	}
	
	/****************************************************************
	 * Returns the title for the action of the SimObject
	 * @return title
	 ****************************************************************/
	public String getTitle(){
		return title;
	}
	
	/****************************************************************
	 * Sets an object to being able to perform an action or not
	 * @param x boolean
	 ****************************************************************/
	public void setIsActionObject(boolean x){
		isActionObject = x;
	}
	
	/****************************************************************
	 * Returns if an object can perform and action or not
	 * @return isActionObject
	 ****************************************************************/
	public boolean getIsActionObect(){
		return isActionObject;
	}
	
	/****************************************************************
	 * Sets the time an action on this object takes
	 * @param timeToComplete
	 ****************************************************************/
	public void setTimeToComplete(int timeToComplete){
		this.timeToComplete = timeToComplete;
	}
	
	/*****************************************************************
	 * Returns the time an action on this object takes
	 * @return timeToComplete
	 *****************************************************************/
	public int getTimeToComplete(){
		return timeToComplete;
	}

	public int getForHunger() {
		return forHunger;
	}

	public void setForHunger(int forHunger) {
		this.forHunger = forHunger;
	}

	public int getForComfort() {
		return forComfort;
	}

	public void setForComfort(int forComfort) {
		this.forComfort = forComfort;
	}

	public int getForBladder() {
		return forBladder;
	}

	public void setForBladder(int forBladder) {
		this.forBladder = forBladder;
	}

	public int getForEnergy() {
		return forEnergy;
	}

	public void setForEnergy(int forEnergy) {
		this.forEnergy = forEnergy;
	}

	public int getForFun() {
		return forFun;
	}

	public void setForFun(int forFun) {
		this.forFun = forFun;
	}

	public int getForSocial() {
		return forSocial;
	}

	public void setForSocial(int forSocial) {
		this.forSocial = forSocial;
	}

	public int getForHygiene() {
		return forHygiene;
	}

	public void setForHygiene(int forHygiene) {
		this.forHygiene = forHygiene;
	}

	public int getForEnvironment() {
		return forEnvironment;
	}

	public void setForEnvironment(int forEnvironment) {
		this.forEnvironment = forEnvironment;
	}
	
	/****************************************************************
	 * Returns the SimObjectType as a String
	 ****************************************************************/
	public String toString(){
		if(objectType() == SimObjectType.bed)
			return "bed";
		else if(objectType() == SimObjectType.couch)
			return "couch";
		else if(objectType() == SimObjectType.chair)
			return "chair";
		else if(objectType() == SimObjectType.table)
			return "table";
		else if(objectType() == SimObjectType.stand)
			return "stand";
		else if(objectType() == SimObjectType.counter)
			return "counter";
		else if(objectType() == SimObjectType.sink)
			return "sink";
		else if(objectType() == SimObjectType.toilet)
			return "toilet";
		else if(objectType() == SimObjectType.bath)
			return "bath";
		else if(objectType() == SimObjectType.shower)
			return "shower";
		else if(objectType() == SimObjectType.hottub)
			return "hottub";
		else if(objectType() == SimObjectType.lamp)
			return "lamp";
		else if(objectType() == SimObjectType.radio)
			return "radio";
		else if(objectType() == SimObjectType.TV)
			return "TV";
		else if(objectType() == SimObjectType.computer)
			return "computer";
		else if(objectType() == SimObjectType.phone)
			return "phone";
		else if(objectType() == SimObjectType.fridge)
			return "fridge";
		else if(objectType() == SimObjectType.microwave)
			return "microwave";
		else if(objectType() == SimObjectType.pantry)
			return "pantry";
		else if(objectType() == SimObjectType.coffee)
			return "coffee";
		else if(objectType() == SimObjectType.painting)
			return "painting";
		else if(objectType() == SimObjectType.art)
			return "art";
		else if(objectType() == SimObjectType.exercise)
			return "exercise";
		else if(objectType() == SimObjectType.piano)
			return "piano";
		
		System.out.println("SimObject toString error: Returned null");
		return null;
	}
}