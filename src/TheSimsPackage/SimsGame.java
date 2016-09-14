package TheSimsPackage;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/***********************************************************************
 * Handles all of the game activities of the Sims Simulation
 * @author Mitchell
 * @version 2/16/2015
 ***********************************************************************/

public class SimsGame {

	/** The collection of all Sims being played during this game**/
	private ArrayList<Sim> mySims;
	
	/** The collection of all SimObjects that are in the house**/
	private SimObjectArrayList<SimObject> mySimObjects;
	
	/** When adding new SimObject, contains the most recently selected ObjectClass**/
	private String currentObjectClass;
	
	/** The internal clock that runs during the game**/
	private SimTime time;
	
	/** the time remaining that a Sim will do an action on a specific object**/
	private int objectTimeRemaining;
	
	/** a SimObject used to throw around in this class**/
	private SimObject thing;
	
	/** A ButtonListener for the SimPrompt**/
	private PromptListener p1;
	/** For the Sim prompt**/
	private Color c;
	/** For the Sim prompt**/
	private Gender g;
	/** For the Sim prompt**/
	private Age a;
	/** For the Sim prompt**/
	private String f;
	/** For the Sim prompt**/
	private String l;
	/** JButton for the Sim prompt**/
	JButton bBlue;
	/** JButton for the Sim prompt**/
	JButton bGreen;
	/** JButton for the Sim prompt**/
	JButton bYellow;
	/** JButton for the Sim prompt**/
	JButton bPink;
	/** JButton for the Sim prompt**/
	JButton bTeal;
	/** JButton for the Sim prompt**/
	JButton bMale;
	/** JButton for the Sim prompt**/
	JButton bFemale;
	/** JButton for the Sim prompt**/
	JButton bChild;
	/** JButton for the Sim prompt**/
	JButton bAdult;
	
	
	/***************************************************************
	 * Constructor for the SimsGame class
	 ***************************************************************/
	public SimsGame(){
		mySims = new ArrayList<Sim>();
		mySimObjects = new SimObjectArrayList<SimObject>();
		time = new SimTime();
		createButtons();
		//prompt the user for the first Sim
		addSim();
	}
	
	/********************************************************************
	 * Sets the currentObjectClass. This will be done from the SimsPanel
	 ********************************************************************/
	public void setCurrentObjectClass(String s){
		currentObjectClass = s;
	}
	
	/********************************************************************
	 * Returns the current SimTime
	 * @return SimTime time
	 ********************************************************************/
	public SimTime getTime(){
		return time;
	}
	
	/*******************************************************************
	 * Increment the game's SimTime by 1
	 ******************************************************************/
	public void incTime(){
		time.inc();
	}
	
	/**********************************************************************
	 * Adds a new Sim to the SimsGame
	 **********************************************************************/
	public void addSim(){
		if(mySims.size() == 5){
			JOptionPane.showMessageDialog(null, "You cannot have more than 5 Sims");
			return;
		}
		
		f = JOptionPane.showInputDialog("Enter the First name of your Sim");
		l = JOptionPane.showInputDialog("Enter the Last name of your Sim");
		JOptionPane.showOptionDialog(null, "Choose a Color for your Sim", "Sim Color", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{bBlue, bGreen, bYellow, bPink, bTeal}, bBlue);
		JOptionPane.showOptionDialog(null, "Choose a Gender for your Sim", "Sim Gender", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{bMale, bFemale}, bMale);
		JOptionPane.showOptionDialog(null, "Choose a Age for your Sim", "Sim Age", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{bChild, bAdult}, bChild);
		Sim newSim = new Sim(f, l, g, a, c);
		mySims.add(newSim);
	}
	
	/*******************************************************************************************
	 * Removes the Sim from the game, in the case that it's needs fall too low and the Sim dies.
	 *******************************************************************************************/
	public void killSim(int SimID){
		mySims.remove(findSim(SimID));
		Sim.decNumSim();
		for (int i = 1;i <= 5; i++){
			if(i <= SimID){
				//no change is made to SimIDs <= to the Sim's being deleted
			}else if(i > SimID){
				try{ 
					findSim(SimID).setSimID(SimID - 1); 		//decreased the current SimId by 1
				}catch(NullPointerException e){
					return; 		//simple error. there are more than SimID sims. Just return.
				}
			}
		}
	}
	
	/****************************************************************************************
	 * Adds a new SimObject into the SimsGame world
	 ***************************************************************************************/
	public void addSimObject(SimObjectType t){
		if(currentObjectClass.equals("Furniture")){
			mySimObjects.add(new oFurniture(t));
		}else if(currentObjectClass.equals("Electric")){
			mySimObjects.add(new oElectric(t));
		}else if(currentObjectClass.equals("Plumbing")){
			mySimObjects.add(new oPlumbing(t));
		}else if(currentObjectClass.equals("Kitchen")){
			mySimObjects.add(new oKitchen(t));
		}else if(currentObjectClass.equals("Decoration")){
			mySimObjects.add(new oDecoration(t));
		}else if(currentObjectClass.equals("Misc")){
			mySimObjects.add(new oMisc(t));
		}else{
			System.out.print("Error: currentObjectClass is invalid String");
		}
	}
	
	/*********************************************************************************
	 * removes the specified SimsObject from the SimsGame world
	 * @param o SimObject
	 *********************************************************************************/
	public void removeSimObject(SimObject o){
		mySimObjects.remove(o);
	}
	
	/********************************************************************
	 * With a SimID being entered, returns the Sim with that SimID
	 * @param SimIdD
	 * @return Sim
	 *******************************************************************/
	public Sim findSim(int SimID){
		return (Sim) mySims.get(SimID - 1);
	}
	
	/*****************************************************************************************
	 * Here's the big one. The method that truly connects the Sim and SimObject classes by
	 * having a Sim perform and action on a specific object for a specific amount of time,
	 * and gaining Needs from that object where necessary.
	 * Make this method run in SimsPanel every time the clock inc();
	 * @param int SimID
	 ******************************************************************************************/
	public void performAction(int SimID){
		
		if(findSim(SimID).checkIfAnyAction()){
			if(!findSim(SimID).isActionDone()){
				//continue action, decrement the objectTime by 1
				objectTimeRemaining--;
				//when action is done(object time is 0), use cancelAction() method.
				if(objectTimeRemaining == 0){
					findSim(SimID).setNeedsByObject(findSim(SimID).getAction());
					findSim(SimID).cancelAction();
					findSim(SimID).setActionDone(true);
				}
			}else{
				//start performing the next action in the queue
				findSim(SimID).performAction();
				//set the objects time to a variable
				objectTimeRemaining = findSim(SimID).getAction().getTimeToComplete();
				findSim(SimID).setActionDone(false);
			}
		}else{
			//if there are no items in the queue, the Sim will automatically find a new action to perform
			SimObject newAction = findNewAction(SimID);
			if(newAction == null){
				return;							// if there was no action to perform, return.
			}
			findSim(SimID).addAction(newAction);
		}
	}
	
	/*********************************************************************************************************
	 * This method is used when a Sim's action queue is empty, in order to find a new action to
	 * perform. In this method, the Needs of the Sim will be checked, and a SimObject will be chosen to
	 * address the lowest Need. If no needs fall below 50, this method will end. (This does not include the
	 * Environment Need, which is not affected by using objects.
	 * @param int SimID
	 *********************************************************************************************************/
	public SimObject findNewAction(int SimID){
		int index;
		
		if(findSim(SimID).getnHunger() < 50){
			thing = mySimObjects.findSimObjectOfType("Kitchen", SimObjectType.fridge);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Kitchen", SimObjectType.microwave);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Kitchen", SimObjectType.pantry);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Kitchen", SimObjectType.coffee);
			if(thing != null)
				return thing;
			
		}if(findSim(SimID).getnBladder() < 40){
			thing = mySimObjects.findSimObjectOfType("Plumbing", SimObjectType.toilet);
			if(thing != null)
				return thing;
			
		}if(findSim(SimID).getnEnergy() < 20){
			thing = mySimObjects.findSimObjectOfType("Furniture", SimObjectType.bed);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Kitchen", SimObjectType.coffee);
			if(thing != null)
				return thing;
			
		}if(findSim(SimID).getnHygiene() < 40){
			thing = mySimObjects.findSimObjectOfType("Plumbing", SimObjectType.shower);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Plumbing", SimObjectType.bath);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Plumbing", SimObjectType.sink);
			if(thing != null)
				return thing;
			
		}if(findSim(SimID).getnFun() < 60){
			thing = mySimObjects.findSimObjectOfType("Electric", SimObjectType.TV);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Electric", SimObjectType.computer);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Electric", SimObjectType.radio);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Electric", SimObjectType.phone);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Misc", SimObjectType.piano);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Plumbing", SimObjectType.hottub);
			if(thing != null)
				return thing;
			
		}if(findSim(SimID).getnComfort() < 60){
			thing = mySimObjects.findSimObjectOfType("Furniture", SimObjectType.couch);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Furniture", SimObjectType.chair);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Plumbing", SimObjectType.hottub);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Plumbing", SimObjectType.bath);
			if(thing != null)
				return thing;
			thing = mySimObjects.findSimObjectOfType("Kitchen", SimObjectType.coffee);
			if(thing != null)
				return thing;
			
		}if(findSim(SimID).getnSocial() < 60){
			thing = mySimObjects.findSimObjectOfType("Electric", SimObjectType.phone);
			if(thing != null)
				return thing;
			
			//add in here stuff about talking with other Sims later
		}
		
		return null; //when all else fails, return null.
	}
	
	/*******************************************************************************************************
	 * Method used in the SimsPanelTest class to cancel an action early, and distribute 
	 * the earned Needs points
	 * @param SimID the ID of the current Sim
	 *******************************************************************************************************/
	public void cancelAction(int SimID){
		int timeCompleted = findSim(SimID).getAction().getTimeToComplete() - objectTimeRemaining;
		double percent = (double)timeCompleted / findSim(SimID).getAction().getTimeToComplete();
		//set Needs by the percent earned
		findSim(SimID).setnHunger(findSim(SimID).getnHunger() + (int)(findSim(SimID).getAction().getForHunger() * percent));
		if(findSim(SimID).getnHunger() > 100)
			findSim(SimID).setnHunger(100);
		findSim(SimID).setnComfort(findSim(SimID).getnComfort() + (int)(findSim(SimID).getAction().getForComfort() * percent));
		if(findSim(SimID).getnComfort() > 100)
			findSim(SimID).setnComfort(100);
		findSim(SimID).setnBladder(findSim(SimID).getnBladder() + (int)(findSim(SimID).getAction().getForBladder() * percent));
		if(findSim(SimID).getnBladder() > 100)
			findSim(SimID).setnBladder(100);
		findSim(SimID).setnEnergy(findSim(SimID).getnEnergy() + (int)(findSim(SimID).getAction().getForEnergy() * percent));
		if(findSim(SimID).getnEnergy() > 100)
			findSim(SimID).setnEnergy(100);
		findSim(SimID).setnFun(findSim(SimID).getnFun() + (int)(findSim(SimID).getAction().getForFun() * percent));
		if(findSim(SimID).getnFun() > 100)
			findSim(SimID).setnFun(100);
		findSim(SimID).setnSocial(findSim(SimID).getnSocial() + (int)(findSim(SimID).getAction().getForSocial() * percent));
		if(findSim(SimID).getnSocial() > 100)
			findSim(SimID).setnSocial(100);
		findSim(SimID).setnHygiene(findSim(SimID).getnHygiene() + (int)(findSim(SimID).getAction().getForHygiene() * percent));
		if(findSim(SimID).getnHygiene() > 100)
			findSim(SimID).setnHygiene(100);
		//cancel the action
		findSim(SimID).cancelAction();
		findSim(SimID).setActionDone(true);
	}
	
	/************************************************************************************
	 * Adds points to a Sim's Environment need based on the SimObjects owned
	 ************************************************************************************/
	public void makenEnvironment(int SimID){
		if(findSim(SimID).getNumOfObjects() != mySimObjects.size()){
			findSim(SimID).setNumOfObject(mySimObjects.size());
			findSim(SimID).setnEnvironment(0);
			for(int i = 0; i < mySimObjects.size(); i++){
				findSim(SimID).setnEnvironment(findSim(SimID).getnEnvironment() + mySimObjects.get(i).getForEnvironment());
			}
		}
	}
	
	/**********************************************************
	 * Creates the JButtons needed for the SimPrompt
	 **********************************************************/
	public void createButtons(){
		//creates Sim Color choices
		bBlue = new JButton("Blue");
		bGreen = new JButton("Green");
		bYellow = new JButton("Yellow");
		bPink = new JButton("Pink");
		bTeal = new JButton("Teal");
		bMale = new JButton("Male");
		bFemale = new JButton("Female");
		bChild = new JButton("Child");
		bAdult = new JButton("Adult");
		
//adds listeners to the JButtons
		p1 = new PromptListener();
		bBlue.addActionListener(p1);
		bGreen.addActionListener(p1);
		bYellow.addActionListener(p1);
		bPink.addActionListener(p1);
		bTeal.addActionListener(p1);
		bMale.addActionListener(p1);
		bFemale.addActionListener(p1);
		bChild.addActionListener(p1);
		bAdult.addActionListener(p1);
	}
	
	/**************************************************************************
	 * Used in the SimsTestPanel as a toString to display all the objects in
	 * the mySimObjects list
	 * @return String All SimObjects
	 **************************************************************************/
	public String displayAllObjects(){
		int count = 0;
		String s = "\nObjects Owned: \n";
		for(int i = 1; i <= mySimObjects.size(); i++){
			if(i == mySimObjects.size()){
				s += mySimObjects.get(i - 1).toString();
			}else{
				if(count%5 == 0)
					s += "\n";
				s += mySimObjects.get(i - 1).toString() + ", ";
			}
			count++;
		}
		if(mySimObjects.size() < 1){
			s += "None";
		}
		return s;
	}
	
	/*******************************************************************
	 * The Button Listener for the SimPrompt
	 * @author Mitchell Couturier
	 * @version 2/16/2015
	 *******************************************************************/
	private class PromptListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		if(e.getSource()==bBlue)
			c = Color.blue;
		else if(e.getSource()==bGreen)
			c = Color.green;
		else if(e.getSource()==bYellow)
			c = Color.yellow;
		else if(e.getSource()==bPink)
			c = Color.pink;
		else if(e.getSource()==bTeal)
			c = Color.cyan;
		else if(e.getSource()==bMale)
			g = Gender.Male;
		else if(e.getSource()==bFemale)
			g = Gender.Female;
		else if(e.getSource()==bChild)
			a = Age.Child;
		else if(e.getSource()==bAdult)
			a = Age.Adult;
		
		Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JDialog) {
                JDialog dialog = (JDialog) window;
                if (dialog.getContentPane().getComponentCount() == 1
                        && dialog.getContentPane().getComponent(0) instanceof JOptionPane) {
                    dialog.dispose();
                }
            }
        }
		}
	}
	
	public SimObjectArrayList getMySimObjects(){
		return mySimObjects;
		
	}
	
	public String getCurrentObjectClass(){
		return currentObjectClass;
	}

}
