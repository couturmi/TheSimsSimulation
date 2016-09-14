package TheSimsPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SimsGrid extends JPanel{

	/**the SimsGame being played that displays in this JPanel**/
	private SimsGame game;
	
	/** the last known size of the list of SimObjects in the SimsGame**/
	int listSize;
	
	private objectComponent component;
	
	/*******************************************************
	 * Constructor for the SimsGrid
	 * @param sg
	 *******************************************************/
	public SimsGrid(SimsGame sg){
		game = sg;
		listSize = 0;	//there are no objects owned at the start of the game
	}
	
	/*****************************************************************************
	 * Used to add a component to the list
	 * @param o SimObject
	 ****************************************************************************/
	public void addComponent(SimObject o, ActionListener l){
		objectComponent comp = new objectComponent(o.objectType());
		comp.addActionListener(l);
		add(comp);
		listSize++;
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(500,500);
	}
	
	public int getListSize(){
		return listSize;
	}
	
	public void decListSize(){
		listSize--;
	}
}
