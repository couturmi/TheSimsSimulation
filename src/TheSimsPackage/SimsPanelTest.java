package TheSimsPackage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * This class is for testing all of the classes besides the SimsPanel. This will be basically a 
 * way to watch to game without actually seeing visuals.
 * @author Mitchell Couturier
 *
 */
public class SimsPanelTest extends JPanel{

	/** The SimsGame that will run in this GUI**/
	private SimsGame game;
	
	/** Holds the SimObject of the most recently selected item**/
	private SimObjectType selectedObject;
	
	/** Holds the number of SimsCreated. Used to update number of Sim Buttons**/
	private int SimCounter;
	
	/** Contains the SimID of the most recently click on Sim**/
	private int recentSim;
	
	/** Contains the SimObject of the last selected SimObject**/
	private SimObject recentObject;
	
	/** Contains the position of the recentObject in the list of objects**/
	private int recentObjectNumber;
	
	/** Button listener for all JButtons**/
	private ButtonListener m1;
	
	/** Timer listener for the game's timer**/
	private TimerListener t1;
	
	/** Mouse listener for the visual aspect of the SimsGame**/
	private MouseEventListener e1;
	
	/** JButton that represents a specific SimObjectClass **/
	private JButton Furniture, Electric, Kitchen, Plumbing, Decoration, Misc;
	
	/** JButton that represents a specific SimObjectType**/
	private JButton bed, couch, chair, table, stand, counter, sink, toilet, bath, shower, 
	hottub, lamp, radio, TV, computer, phone, fridge, microwave, 
	pantry, coffee, painting, art, exercise, piano;
	
	/** Button used to go back to the previous JPanel when in Buy Mode**/
	private JButton Fback, Eback, Kback, Pback, Dback, Mback;
	
	/** Button used to finalize a purchase of a new SimObject**/
	private JButton buy;
	
	/** JButton that represents the speed of the SimTime**/
	private JButton x0, x1, x2, x4;
	
	/** Buttons for each Sim added**/
	private JButton Sim1, Sim2, Sim3, Sim4, Sim5;
	
	/** Button to add a new Sim into the SimGame**/
	private JButton addSimButton;
	
	/** JButton used to cancel the selected action**/
	private JButton cancelActionButton;
	
	/** JButton used to remove a SimObject from the game**/
	private JButton removeSimObjectButton;
	
	/** JButton used to move a SimObject to a different position**/
	private JButton moveSimObjectButton;
	
	/** JButton used to rotate a SimObject **/
	private JButton rotateSimObjectButton;
	
	/** returns true if an object is currently being positioned **/
	private boolean isPositioning;
	
	/** JButton used to make a Sim perform an action on a SimObject**/
	private JButton performActionOnButton;
	
	/** the timer that moves the gameplay forward**/
	private Timer timer;
	
	/** the speed of the timer**/
	private int speed;
	
	/** a Pane with multiple tabs to represent the different game modes**/
	private JTabbedPane tabs;
	
	/** JPanel that swaps through other panels**/
	private JPanel cardPanel;
	
	/** CardLayout to swap through panels**/
	private CardLayout c1;
	
	/** a tab that represent a specific game mode**/
	private JPanel buyModePanel, playModePanel;
	
	/** a Jpanel that holds the Sims JButtons**/
	private JPanel SimButtonPanel;
	
	/** a JPanel that holds the JButton - addSimButton**/
	private JPanel addSimPanel;
	
	/** JPanel that displays SimObjects of a specific SimObjectClass**/
	private JPanel FurniturePanel, ElectricPanel, KitchenPanel, PlumbingPanel, DecorationPanel, MiscPanel;
	
	/** a JPanel that displays all information information**/
	private JPanel InfoPanel;
	
	/** a JPanel that holds all components for SimTime**/
	private JPanel TimePanel;
	
	/** a JPanel that holds all of the JButtons to change the SimTime's speed**/
	private JPanel TimeSpeedPanel;
	
	/** a JPanel that contains the buy JButton**/
	private JPanel buyButtonPanel;
	
	/** a JPanel that contains the SimObject action JButtons in play mode**/
	private JPanel objectButtonPlayPanel;
	
	/** a JPanel that contains the SimObject action JButtons in play mode**/
	private JPanel objectButtonBuyPanel;
	
	/** a JPanel that contains the rotate JButton **/
	private JPanel rotateButtonPanel;
	
	/** JLabel that shows the current time**/
	private JLabel TimeLabel;
	
	/** a JPanel that contains descriptions in the InfoPanel**/
	private JPanel descriptionPanel;
	
	/** used to contain InfoTextArea and the cancelActionButton in the same area**/
	private JPanel InfoTextPanel;
	
	/** JTextArea that displays info on a Sim's info**/
	private JTextArea InfoTextArea;
	
	/** JTextArea that displays the SimObjectList**/
	private JTextArea ObjectListTextArea;
	
	/** JTextArea that displays info on a SimObject**/
	private JTextArea ObjectTextArea;
	
	/** a JPanel that would display the actual SimsGame**/
	private JPanel mainDisplayPanel;
	
	/** the actual grid that contains the SimsGame, stored in mainDisplayPanel**/
	private SimsGrid grid;
	
	/** Panel that contains all other panels**/
	private JPanel masterPanel;
	
	/******************************************************************************************
	 * The Constructor class for SimsPanelTest that instantiates all the JPanels, 
	 * JButtons, etc.
	 ******************************************************************************************/
	public SimsPanelTest(){
		game = new SimsGame();
		SimCounter = 1;
		recentSim = 1;
		Sim1 = new JButton(game.findSim(1).getName());
		Sim2 = new JButton(); //Sim not made yet
		Sim3 = new JButton(); //Sim not made yet
		Sim4 = new JButton(); //Sim not made yet
		Sim5 = new JButton(); //Sim not made yet
		addSimButton = new JButton("New Sim");
		addSimPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		SimButtonPanel = new JPanel();
		m1 = new ButtonListener();
		t1 = new TimerListener();
		e1 = new MouseEventListener();
		speed = 1000;
		timer = new Timer(speed, t1);
		
		tabs = new JTabbedPane();
		cardPanel = new JPanel(new CardLayout());
		c1 = (CardLayout)(cardPanel.getLayout());
		playModePanel = new JPanel();
		buyModePanel = new JPanel();
		tabs.add("Play", playModePanel);
		tabs.add("Buy", cardPanel);
		
		masterPanel = new JPanel();
		mainDisplayPanel = new JPanel();
		grid = new SimsGrid(game);
		InfoPanel = new JPanel();
		InfoTextPanel = new JPanel();
		FurniturePanel = new JPanel();
		ElectricPanel = new JPanel();
		KitchenPanel = new JPanel();
		PlumbingPanel = new JPanel();
		DecorationPanel = new JPanel();
		MiscPanel = new JPanel();
		TimePanel = new JPanel();
		TimeSpeedPanel = new JPanel();
		descriptionPanel = new JPanel();
		buyButtonPanel = new JPanel();
		objectButtonPlayPanel = new JPanel();
		objectButtonBuyPanel = new JPanel();
		rotateButtonPanel = new JPanel();
		
		TimeLabel = new JLabel("Time: " + game.getTime(), SwingConstants.CENTER);
		InfoTextArea = new JTextArea(game.findSim(1).toString());
		ObjectListTextArea = new JTextArea(game.displayAllObjects());
		ObjectTextArea = new JTextArea();
		
		buy = new JButton("Buy");
		cancelActionButton = new JButton("Cancel Action");
		removeSimObjectButton = new JButton("Remove");
		moveSimObjectButton = new JButton("Move");
		rotateSimObjectButton = new JButton("Rotate");
		performActionOnButton = new JButton();
		isPositioning = false;
		
		Furniture = new JButton("Furniture");
		Electric = new JButton("Electric");
		Kitchen = new JButton("Kitchen");
		Plumbing = new JButton("Plumbing");
		Decoration = new JButton("Decoration");
		Misc = new JButton("Misc");
		
		bed = new JButton("bed");
		couch = new JButton("couch");
		chair = new JButton("chair");
		table = new JButton("table");
		stand = new JButton("stand");
		counter = new JButton("counter");
		sink = new JButton("sink");
		toilet = new JButton("toilet");
		bath = new JButton("bath");
		shower = new JButton("shower");
		hottub = new JButton("hottub");
		lamp = new JButton("lamp");
		radio = new JButton("radio");
		TV = new JButton("TV");
		computer = new JButton("computer");
		phone = new JButton("phone");
		fridge = new JButton("fridge");
		microwave = new JButton("microwave");
		pantry = new JButton("pantry");
		coffee = new JButton("coffee");
		painting = new JButton("painting");
		art = new JButton("art");
		exercise = new JButton("exercise");
		piano = new JButton("piano");
		Fback = new JButton("<- Back");
		Eback = new JButton("<- Back");
		Pback = new JButton("<- Back");
		Kback = new JButton("<- Back");
		Dback = new JButton("<- Back");
		Mback = new JButton("<- Back");
		
		x0 = new JButton("||");
		x1 = new JButton("x1");
		x2 = new JButton("x2");
		x4 = new JButton("x4");
		
		//adds ActionListener to all JButtons
		Sim1.addActionListener(m1);
		Sim2.addActionListener(m1);
		Sim3.addActionListener(m1);
		Sim4.addActionListener(m1);
		Sim5.addActionListener(m1);
		addSimButton.addActionListener(m1);
		
		Furniture.addActionListener(m1);
		Electric.addActionListener(m1);
		Kitchen.addActionListener(m1);
		Plumbing.addActionListener(m1);
		Decoration.addActionListener(m1);
		Misc.addActionListener(m1);
		
		bed.addActionListener(m1);
		couch.addActionListener(m1);
		chair.addActionListener(m1);
		table.addActionListener(m1);
		stand.addActionListener(m1);
		counter.addActionListener(m1);
		sink.addActionListener(m1);
		toilet.addActionListener(m1);
		bath.addActionListener(m1);
		shower.addActionListener(m1);
		hottub.addActionListener(m1);
		lamp.addActionListener(m1);
		radio.addActionListener(m1);
		TV.addActionListener(m1);
		computer.addActionListener(m1);
		phone.addActionListener(m1);
		fridge.addActionListener(m1);
		microwave.addActionListener(m1);
		pantry.addActionListener(m1);
		coffee.addActionListener(m1);
		painting.addActionListener(m1);
		art.addActionListener(m1);
		exercise.addActionListener(m1);
		piano.addActionListener(m1);
		Fback.addActionListener(m1);
		Eback.addActionListener(m1);
		Pback.addActionListener(m1);
		Kback.addActionListener(m1);
		Dback.addActionListener(m1);
		Mback.addActionListener(m1);
		buy.addActionListener(m1);
		cancelActionButton.addActionListener(m1);
		removeSimObjectButton.addActionListener(m1);;
		moveSimObjectButton.addActionListener(m1);
		rotateSimObjectButton.addActionListener(m1);
		performActionOnButton.addActionListener(m1);;
		
		x0.addActionListener(m1);
		x1.addActionListener(m1);
		x2.addActionListener(m1);
		x4.addActionListener(m1);
		
		//adds MouseListener to the game Panel
		mainDisplayPanel.addMouseListener(e1);
		mainDisplayPanel.addMouseMotionListener(e1);
		
		//sets the layouts, sizes and BackgroundColors for JPanels
		masterPanel.setLayout(new BorderLayout(10,10));
		masterPanel.setBackground(Color.black);
		mainDisplayPanel.setPreferredSize(new Dimension(500,500));
		mainDisplayPanel.setBackground(Color.white);
		grid.setBackground(Color.white);
		grid.setPreferredSize(new Dimension(500,500));
		grid.setLayout(null);
		InfoPanel.setLayout(new BorderLayout());
		InfoPanel.setPreferredSize(new Dimension(225, 500));
		TimePanel.setLayout(new BorderLayout());
		TimePanel.setBackground(Color.YELLOW);
		TimeSpeedPanel.setBackground(Color.YELLOW);
		TimeSpeedPanel.setLayout(new FlowLayout());
		descriptionPanel.setLayout(new BorderLayout());
		InfoPanel.setBackground(Color.white);
		SimButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		playModePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		SimButtonPanel.setPreferredSize(new Dimension(625, 40));
		InfoTextArea.setBackground(Color.CYAN);
		InfoTextPanel.setBackground(Color.CYAN);
		InfoTextPanel.setLayout(new BoxLayout(InfoTextPanel, BoxLayout.Y_AXIS));
		setBackground(Color.black);
		
		//sets the sizes, layout, and colors for JButtons
		x0.setPreferredSize(new Dimension(48,30));
		x1.setPreferredSize(new Dimension(48,30));
		x1.setBackground(Color.GREEN);
		x2.setPreferredSize(new Dimension(48,30));
		x4.setPreferredSize(new Dimension(48,30));
		
		//adds all the JButtons to their designated JPanels
		buyModePanel.add(Furniture);
		buyModePanel.add(Electric);
		buyModePanel.add(Kitchen);
		buyModePanel.add(Plumbing);
		buyModePanel.add(Decoration);
		buyModePanel.add(Misc);
		FurniturePanel.add(Fback);
		FurniturePanel.add(bed);
		FurniturePanel.add(couch);
		FurniturePanel.add(chair);
		FurniturePanel.add(table);
		FurniturePanel.add(stand);
		FurniturePanel.add(counter);
		PlumbingPanel.add(Pback);
		PlumbingPanel.add(sink);
		PlumbingPanel.add(toilet);
		PlumbingPanel.add(bath);
		PlumbingPanel.add(shower);
		PlumbingPanel.add(hottub);
		ElectricPanel.add(Eback);
		ElectricPanel.add(lamp);
		ElectricPanel.add(radio);
		ElectricPanel.add(TV);
		ElectricPanel.add(computer);
		ElectricPanel.add(phone);
		KitchenPanel.add(Kback);
		KitchenPanel.add(fridge);
		KitchenPanel.add(microwave);
		KitchenPanel.add(pantry);
		KitchenPanel.add(coffee);
		DecorationPanel.add(Dback);
		DecorationPanel.add(painting);
		DecorationPanel.add(art);
		MiscPanel.add(Mback);
		MiscPanel.add(exercise);
		MiscPanel.add(piano);
		TimeSpeedPanel.add(x0);
		TimeSpeedPanel.add(x1);
		TimeSpeedPanel.add(x2);
		TimeSpeedPanel.add(x4);
		SimButtonPanel.add(Sim1);
		addSimPanel.add(addSimButton);
		buyButtonPanel.add(buy);
		objectButtonPlayPanel.add(performActionOnButton);
		objectButtonBuyPanel.add(removeSimObjectButton);
		objectButtonBuyPanel.add(moveSimObjectButton);
		rotateButtonPanel.add(rotateSimObjectButton);
		
		//adds other components to panels
		cardPanel.add(buyModePanel, "Main");
		cardPanel.add(FurniturePanel, "Furniture");
		cardPanel.add(ElectricPanel, "Electric");
		cardPanel.add(PlumbingPanel, "Plumbing");
		cardPanel.add(KitchenPanel, "Kitchen");
		cardPanel.add(DecorationPanel, "Decoration");
		cardPanel.add(MiscPanel, "Misc");
		
		//adds all panels to the contentPane
		playModePanel.add(SimButtonPanel);
		playModePanel.add(addSimPanel);
		InfoPanel.add(BorderLayout.NORTH, TimePanel);
		TimePanel.add(BorderLayout.NORTH, TimeLabel);
		TimePanel.add(BorderLayout.CENTER, TimeSpeedPanel);
		InfoPanel.add(BorderLayout.CENTER, descriptionPanel);
		InfoTextPanel.add(InfoTextArea);
		descriptionPanel.add(BorderLayout.NORTH, InfoTextPanel);
		descriptionPanel.add(BorderLayout.CENTER, ObjectListTextArea);
		descriptionPanel.add(BorderLayout.SOUTH, ObjectTextArea);
		mainDisplayPanel.add(grid);
		masterPanel.add(BorderLayout.NORTH, tabs);
		masterPanel.add(BorderLayout.CENTER, mainDisplayPanel);
		masterPanel.add(BorderLayout.WEST, InfoPanel);
		add(masterPanel);
		
		timer.start();
	}
	
	/**********************************************************************************************
	 * Used to add a JButton for a New Sim
	 * to the PlayModePanel tab.
	 **********************************************************************************************/
	private void addNewSim(){
		if(SimCounter == Sim.getNumSims()){
			return;
		}else{
			SimCounter++;
			if(SimCounter == 2){
				Sim2.setText(game.findSim(2).getName());
				SimButtonPanel.add(Sim2);
			}else if(SimCounter == 3){
				Sim3.setText(game.findSim(3).getName());
				SimButtonPanel.add(Sim3);
			}
			else if(SimCounter == 4){
				Sim4.setText(game.findSim(4).getName());
				SimButtonPanel.add(Sim4);
			}
			else if(SimCounter == 5){
				Sim5.setText(game.findSim(5).getName());
				SimButtonPanel.add(Sim5);
			}
		}
	}
	/*****************************************************************************
	 * The ActionListener for JButtons
	 * @author Mitchell Couturier
	 * @version 2/15/2015
	 *****************************************************************************/
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//if anything is clicked besides rotate, set to false
			if(e.getSource() != rotateSimObjectButton)
				isPositioning = false;
			//For Sims Buttons
			if(e.getSource() == Sim1){
				InfoTextArea.setText(game.findSim(1).toString());
				recentSim = 1;
			}else if(e.getSource() == Sim2){
				InfoTextArea.setText(game.findSim(2).toString());
				recentSim = 2;
			}else if(e.getSource() == Sim3){
				InfoTextArea.setText(game.findSim(3).toString());
				recentSim = 3;
			}else if(e.getSource() == Sim4){
				InfoTextArea.setText(game.findSim(4).toString());
				recentSim = 4;
			}else if(e.getSource() == Sim5){
				InfoTextArea.setText(game.findSim(5).toString());
				recentSim = 5;
			}else if(e.getSource() == addSimButton){
				game.addSim();
				//also, check if a new Sim was added
				addNewSim();
				SimsTest.reset();
			}
			//For SimObjectClass
			else if(e.getSource() == Furniture){
				game.setCurrentObjectClass("Furniture");
				c1.show(cardPanel, "Furniture");
			}
			else if(e.getSource() == Electric){
				game.setCurrentObjectClass("Electric");
				c1.show(cardPanel, "Electric");
			}
			else if(e.getSource() == Plumbing){
				game.setCurrentObjectClass("Plumbing");
				c1.show(cardPanel, "Plumbing");
			}
			else if(e.getSource() == Kitchen){
				game.setCurrentObjectClass("Kitchen");
				c1.show(cardPanel, "Kitchen");
			}
			else if(e.getSource() == Decoration){
				game.setCurrentObjectClass("Decoration");
				c1.show(cardPanel, "Decoration");
			}
			else if(e.getSource() == Misc){
				game.setCurrentObjectClass("Misc");
				c1.show(cardPanel, "Misc");
			}
			else if(e.getSource() == Fback || e.getSource() == Eback || e.getSource() == Pback 
					|| e.getSource() == Kback || e.getSource() == Dback || e.getSource() == Mback){
				game.setCurrentObjectClass("");
				ObjectTextArea.setText(null);
				if(buyButtonPanel.getParent() == InfoPanel)
					InfoPanel.remove(buyButtonPanel);
				if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
				}
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
				}
				repaint();
				c1.show(cardPanel, "Main");
			}
			
			//for SimObjectType
			else if(e.getSource() == bed){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.bed;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == couch){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.couch;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == chair){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.chair;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == table){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.table;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == stand){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.stand;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == counter){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.counter;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == sink){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.sink;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == toilet){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.toilet;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == bath){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.bath;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == shower){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.shower;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == hottub){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.hottub;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == lamp){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.lamp;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == radio){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.radio;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == TV){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.TV;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == computer){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.computer;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == phone){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.phone;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == fridge){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.fridge;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == microwave){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.microwave;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == pantry){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.pantry;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == coffee){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.coffee;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == painting){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.painting;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == art){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.art;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == exercise){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.exercise;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			else if(e.getSource() == piano){
				if(objectButtonBuyPanel.getParent() == InfoPanel){
					InfoPanel.remove(objectButtonBuyPanel);
					repaint();
				}if(rotateButtonPanel.getParent() == InfoPanel){
					InfoPanel.remove(rotateButtonPanel);
					repaint();
				}
				selectedObject = SimObjectType.piano;
				ObjectTextArea.setText(SimObjectDescription.getFor(selectedObject));
				InfoPanel.add(BorderLayout.SOUTH, buyButtonPanel);
			}
			//for buying an object
			else if(e.getSource() == buy){
				game.addSimObject(selectedObject);
				grid.addComponent((SimObject)game.getMySimObjects().findSimObjectOfType(game.getCurrentObjectClass(), selectedObject), m1);
				ObjectTextArea.setText("Move the object to the\ndesired spot by moving\nthe mouse and clicking\n\n");
				InfoPanel.remove(buyButtonPanel);
				InfoPanel.add(BorderLayout.SOUTH, rotateButtonPanel);
				recentObjectNumber = grid.getListSize() - 1;
				isPositioning = true;
				repaint();
			}
			//for cancelling an action
			else if(e.getSource() == cancelActionButton){
				game.cancelAction(recentSim);
			}
			//for game speed
			else if(e.getSource() == x0){
				speed = 0;
				x0.setBackground(Color.GREEN);
				x1.setBackground(buy.getBackground()); //buy has the default background color
				x2.setBackground(buy.getBackground());
				x4.setBackground(buy.getBackground());
			}
			else if(e.getSource() == x1){
				speed = 1000;
				timer.setDelay(speed);
				x0.setBackground(buy.getBackground());
				x1.setBackground(Color.GREEN);
				x2.setBackground(buy.getBackground());
				x4.setBackground(buy.getBackground());
			}
			else if(e.getSource() == x2){
				speed = 500;
				timer.setDelay(speed);
				x0.setBackground(buy.getBackground());
				x1.setBackground(buy.getBackground());
				x2.setBackground(Color.GREEN);
				x4.setBackground(buy.getBackground());
			}
			else if(e.getSource() == x4){
				speed = 250;
				timer.setDelay(speed);
				x0.setBackground(buy.getBackground());
				x1.setBackground(buy.getBackground());
				x2.setBackground(buy.getBackground());
				x4.setBackground(Color.GREEN);
			}
			
			//for object Buttons
			else if(e.getSource() == removeSimObjectButton){
				game.removeSimObject(recentObject);
				grid.remove(recentObjectNumber);
				grid.decListSize();
				InfoPanel.remove(objectButtonBuyPanel);
			}
			else if(e.getSource() == moveSimObjectButton){
				ObjectTextArea.setText("Move the object to the\ndesired spot by moving\nthe mouse and clicking\n\n");
				InfoPanel.remove(objectButtonBuyPanel);
				InfoPanel.add(BorderLayout.SOUTH, rotateButtonPanel);
				//TODO change below to: set ALL objectComponents in myList to setEnabled(false). make a separate method for this
				((objectComponent)grid.getComponent(recentObjectNumber)).setEnabled(false);
				isPositioning = true;
				repaint();
			}
			else if(e.getSource() == rotateSimObjectButton){
				((objectComponent)grid.getComponent(recentObjectNumber)).rotateObject();
				((objectComponent)grid.getComponent(recentObjectNumber)).setObjectBounds();
			}
			else if(e.getSource() == performActionOnButton){
				if(recentObject.objectType() == SimObjectType.lamp){
					((objectComponent)grid.getComponent(recentObjectNumber)).toggleIsTurnedOn();
					repaint();
				}
				else if(recentObject.getIsActionObect()){
					game.findSim(recentSim).addAction(recentObject);
					InfoPanel.remove(objectButtonPlayPanel);
				}
			}
			
			//for click-able objects
			else for(int i = 1; i <= grid.getListSize(); i++){
				if(e.getSource() == grid.getComponent(i -1)){
					recentObject = (SimObject)game.getMySimObjects().get(i-1);
					recentObjectNumber = i - 1;
					//depends which tab is open
					if(tabs.getSelectedIndex() == 0){
						InfoPanel.add(BorderLayout.SOUTH, objectButtonPlayPanel);
						performActionOnButton.setText(recentObject.getTitle());
					}else if(tabs.getSelectedIndex() == 1){
						if(buyButtonPanel.getParent() == InfoPanel){
							InfoPanel.remove(buyButtonPanel);
							ObjectTextArea.setText("");
							repaint();
						}
						InfoPanel.add(BorderLayout.SOUTH, objectButtonBuyPanel);
					}
				}
			}
		}
	}
	
	/****************************************************************************
	 * Action Listener for the Timer
	 * @author Mitchell Couturier
	 * @version 2/18/2015
	 ****************************************************************************/
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//if in play mode, SimTime will run
			if(tabs.getSelectedIndex() == 0){
				if(isPositioning){
					((objectComponent)grid.getComponent(recentObjectNumber)).setEnabled(true);
					isPositioning = false;
				}
				//because this method will run every SimMinute, increment the SimTime
				if(speed != 0)
					game.incTime();
				//check for Sim actions
				for(int i = 1; i <= Sim.getNumSims(); i++){
					if(speed != 0){
						game.performAction(i);
						//decreases needs by 5 every SimHour
						game.findSim(i).checkIfDecNeeds();
					}
					game.makenEnvironment(i);
				}
				
				TimeLabel.setText("Time: " + game.getTime());
				InfoTextArea.setText(game.findSim(recentSim).toString());
				if(game.findSim(recentSim).getAction() != null)
					InfoTextPanel.add(cancelActionButton);
				else if(cancelActionButton.getParent() == InfoTextPanel)
					InfoTextPanel.remove(cancelActionButton);
				
				if(speed == 0){
					x0.setBackground(Color.GREEN);
					x1.setBackground(buy.getBackground());
					x2.setBackground(buy.getBackground());
					x4.setBackground(buy.getBackground());
				}else if(speed == 1000){
					x0.setBackground(buy.getBackground());
					x1.setBackground(Color.GREEN);
					x2.setBackground(buy.getBackground());
					x4.setBackground(buy.getBackground());
				}else if(speed == 500){
					x0.setBackground(buy.getBackground());
					x1.setBackground(buy.getBackground());
					x2.setBackground(Color.GREEN);
					x4.setBackground(buy.getBackground());
				}else if(speed == 250){
					x0.setBackground(buy.getBackground());
					x1.setBackground(buy.getBackground());
					x2.setBackground(buy.getBackground());
					x4.setBackground(Color.GREEN);
				}
				//clear any text about buying objects
				ObjectTextArea.setText(null);
				if(buyButtonPanel.getParent() == InfoPanel)
					InfoPanel.remove(buyButtonPanel);
				if(objectButtonBuyPanel.getParent() == InfoPanel)
					InfoPanel.remove(objectButtonBuyPanel);
			}
			//if in buy mode, SimTime will not run
			else if(tabs.getSelectedIndex() == 1){
				InfoTextArea.setText("");
				ObjectListTextArea.setText(game.displayAllObjects());
				x0.setBackground(Color.GREEN);
				x1.setBackground(buy.getBackground());
				x2.setBackground(buy.getBackground());
				x4.setBackground(buy.getBackground());
				
				if(objectButtonPlayPanel.getParent() == InfoPanel)
					InfoPanel.remove(objectButtonPlayPanel);
			}	
			
			grid.repaint();
			SimsTest.reset();
		}
	}
	
	/*****************************************************************************
	 * Used for mouse events
	 * @author Mitchell Couturier
	 * @version 2/28/2015
	 *****************************************************************************/
	private class MouseEventListener extends MouseMotionAdapter implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(isPositioning){
				((objectComponent)grid.getComponent(recentObjectNumber)).setEnabled(true);
				ObjectTextArea.setText("");
				isPositioning = false;
				if(rotateButtonPanel.getParent() == InfoPanel)
					InfoPanel.remove(rotateButtonPanel);
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
		@Override
		public void mouseMoved(MouseEvent arg0){
			if(isPositioning){
				((objectComponent)grid.getComponent(recentObjectNumber)).setCoordinates(arg0.getX(),arg0.getY());
				((objectComponent)grid.getComponent(recentObjectNumber)).setObjectBounds();
			}
		}
	}
}
