package TheSimsPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

/******************************************************************************
 * Creates the painted/clickable components for the SimsGame
 * @author Mitchell Couturier
 * @version 2/26/2015
 ******************************************************************************/
public class objectComponent extends JButton{

	/**the type of object this component represents**/
	private SimObjectType type;
	
	/**the x coordinate for the top left corner of this object**/
	private int xCoor;
	
	/**the y coordinate for the top left corner of this object**/
	private int yCoor;
	
	/**the x coordinate for the bottom right corner of this object**/
	private int xBound;
	
	/**the y coordinate for the bottom right corner of this object**/
	private int yBound;
	
	/**determines if this object is selected at this current moment**/
	private boolean isSelected;
	
	/**the angle of rotation of this object**/
	private double rotation;
	
	/** if the object is a lamp, determines if the lamp is on or off**/
	private boolean isTurnedOn;
	
	/************************************************************************
	 * Constructor for this class
	 * @param t
	 ************************************************************************/
	public objectComponent(SimObjectType t){
		super();
		type = t;
		setEnabled(true);
		isSelected = false;
		setVisible(true);
		setLayout(null);
		xCoor = 0;
		yCoor = 0;
		rotation = 0.0;
		setBoundValues();
		isTurnedOn = false;
	}
	
	/*************************************************************************
	 * Sets the coordinates for this object on the panel
	 * @param int x = xCoor
	 * @param int y = yCoor
	 ************************************************************************/
	public void setCoordinates(int x, int y){
		xCoor = x;
		yCoor = y;
	}
	
	/**************************************************************************
	 * adds 90 to the rotation
	 **************************************************************************/
	public void rotateObject(){
		rotation += 90.0;
		if(rotation == 360.0)
			rotation = 0.0;
		setBoundValues();
	}
	
	/*****************************************************************************
	 * Sets the values for the objectBounds, used for rotational purposes
	 *****************************************************************************/
	public void setBoundValues(){
		if(type == SimObjectType.bed){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 71;
				yBound = 151;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 151;
				yBound = 71;
			}
		}else if(type == SimObjectType.couch){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 151;
				yBound = 61;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 61;
				yBound = 151;
			}
		}else if(type == SimObjectType.chair){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 36;
				yBound = 46;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 46;
				yBound = 36;
			}
		}else if(type == SimObjectType.table){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 56;
				yBound = 101;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 101;
				yBound = 56;
			}
		}else if(type == SimObjectType.stand){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 41;
				yBound = 41;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 41;
				yBound = 41;
			}
		}else if(type == SimObjectType.counter){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 46;
				yBound = 46;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 46;
				yBound = 46;
			}
		}else if(type == SimObjectType.sink){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 46;
				yBound = 46;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 46;
				yBound = 46;
			}
		}else if(type == SimObjectType.toilet){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 51;
				yBound = 56;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 56;
				yBound = 51;
			}
		}else if(type == SimObjectType.bath){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 71;
				yBound = 121;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 121;
				yBound = 71;
			}
		}else if(type == SimObjectType.shower){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 71;
				yBound = 71;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 71;
				yBound = 71;
			}
		}else if(type == SimObjectType.hottub){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 101;
				yBound = 101;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 101;
				yBound = 101;
			}
		}else if(type == SimObjectType.lamp){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 36;
				yBound = 36;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 36;
				yBound = 36;
			}
		}else if(type == SimObjectType.radio){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 26;
				yBound = 11;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 11;
				yBound = 26;
			}
		}else if(type == SimObjectType.TV){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 121;
				yBound = 26;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 26;
				yBound = 121;
			}
		}else if(type == SimObjectType.computer){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 71;
				yBound = 31;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 31;
				yBound = 71;
			}
		}else if(type == SimObjectType.phone){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 16;
				yBound = 21;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 21;
				yBound = 16;
			}
		}else if(type == SimObjectType.fridge){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 71;
				yBound = 56;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 56;
				yBound = 71;
			}
		}else if(type == SimObjectType.microwave){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 41;
				yBound = 34;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 34;
				yBound = 41;
			}
		}else if(type == SimObjectType.pantry){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 71;
				yBound = 51;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 51;
				yBound = 71;
			}
		}else if(type == SimObjectType.coffee){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 26;
				yBound = 35;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 35;
				yBound = 26;
			}
		}else if(type == SimObjectType.painting){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 81;
				yBound = 11;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 11;
				yBound = 81;
			}
		}else if(type == SimObjectType.art){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 46;
				yBound = 46;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 46;
				yBound = 46;
			}
		}else if(type == SimObjectType.exercise){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 101;
				yBound = 47;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 47;
				yBound = 101;
			}
		}else if(type == SimObjectType.piano){
			if(rotation == 0.0 || rotation == 180.0){
				xBound = 121;
				yBound = 121;
			}else if(rotation == 90.0 || rotation == 270.0){
				xBound = 121;
				yBound = 121;
			}
		}
	}
	
	/***************************************************************************** 
	 * Sets the positioning of the Button on the panel
	 *****************************************************************************/
	public void setObjectBounds(){
		//only if the object is a painting
		if(type == SimObjectType.painting){
			if(rotation == 0.0){
				yCoor = 0;
			}else if(rotation == 90.0){
				xCoor = 490;
			}else if(rotation == 180.0){
				yCoor = 480;
			}else if(rotation == 270.0){
				xCoor = 0;
			}
		}
		
		//otherwise just setBounds
		setBounds(xCoor, yCoor, xBound, yBound);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.rotate(rotation * Math.PI/180);
		if(rotation == 90.0)
			g2.translate(0.0, -(xBound-1));
		else if(rotation == 180.0)
			g2.translate(-(xBound-1), -(yBound-1));
		else if(rotation == 270.0)
			g2.translate(-(yBound-1), 0.0);
		
		if(type == SimObjectType.bed){
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(0, 0, 70, 150);
			g2.setColor(Color.white);
			g2.fillRect(10, 3, 50, 30);
			g2.setColor(Color.blue);
			g2.fillRect(0, 40, 70, 110);
			//outlines object
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 70, 150);
			g2.drawRect(10, 3, 50, 30);
			g2.drawRect(0, 40, +70, 110);
			g2.drawLine(0, 50, 70, 50);
			setPreferredSize(new Dimension(70,150));
		}else if(type == SimObjectType.couch){
			g2.setColor(Color.pink);
			g2.fillRect(0, 0, 150, 60);
			//outlines object
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 150, 60);
			g2.drawLine(0, 20, 150, 20);
			g2.drawLine(15, 20, 15, 60);
			g2.drawLine(135, 20, 135, 60);
			g2.drawLine(55, 20, 55, 60);
			g2.drawLine(95, 20, 95, 60);
		}else if(type == SimObjectType.chair){
			g2.setColor(new Color(139,69,19));
			g2.fillRect(0, 10, 35, 35);
			g2.fillRect(0, 0, 35, 7);
			g2.fillRect(5, 7, 5, 3);
			g2.fillRect(25, 7, 5, 3);
			//outlines the object
			g2.setColor(Color.black);
			g2.drawRect(0,10,35,35);
			g2.drawRect(0, 0, 35, 7);
		}else if(type == SimObjectType.table){
			g2.setColor(new Color(139,69,19));
			g2.fillRect(0, 0, 55, 100);
			//outlines the object
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 55, 100);
		}else if(type == SimObjectType.stand){
			g2.setColor(new Color(210,105,30));
			g2.fillRect(0, 0, 40, 40);
			//outlines the object
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 40, 40);
		}else if(type == SimObjectType.counter){
			g2.setColor(new Color(238,232,170));
			g2.fillRect(0, 0, 45, 45);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.sink){
			g2.setColor(new Color(238,232,170));
			g2.fillRect(0, 0, 45, 45);
			g2.setColor(Color.white);
			g2.fillOval(5, 10, 35, 25);
			g2.setColor(Color.black);
			g2.drawOval(5, 10, 35, 25);
			g2.drawOval(20, 21, 5, 5);
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(20, 7, 4, 13);
			g2.setColor(Color.black);
			g2.drawRect(20, 7, 4, 13);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.toilet){
			g2.setColor(Color.white);
			g2.fillOval(13, 15, 25, 40);
			g2.setColor(Color.black);
			g2.drawOval(13, 15, 25, 40);
			g2.setColor(Color.white);
			g2.fillRect(3, 0, 45, 20);
			g2.setColor(Color.black);
			g2.drawRect(3, 0, 45, 20);
			g2.setColor(Color.gray);
			g2.fillRect(0, 5, 3, 10);
			g2.setColor(Color.black);
			g2.drawRect(0, 5, 3, 10);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.bath){
			g2.setColor(Color.white);
			g2.fillRect(0, 0, 70, 120);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 70, 120);
			g2.drawOval(15, 15, 40, 90);
			g2.setColor(Color.gray);
			g2.fillRect(30, 5, 10, 30);
			g2.setColor(Color.black);
			g2.drawRect(30, 5, 10, 30);
		}
		else if(type == SimObjectType.shower){
			g2.setColor(Color.white);
			g2.fillRect(0, 0, 70, 70);
			g2.setColor(Color.gray);
			g2.fillRect(10, 10, 5, 50);
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(33, 10, 4, 10);
			g2.fillOval(25, 15, 20, 10);
			g2.fillOval(8, 20, 9, 5);
			g2.fillOval(8, 30, 9, 5);
			g2.fillOval(8, 40, 9, 5);
			g2.fillOval(8, 50, 9, 5);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 70, 70);
			g2.drawRect(10, 10, 5, 50);
			g2.drawLine(0, 10, 60, 10);
			g2.drawLine(0, 60, 60, 60);
			g2.drawLine(60, 10, 60, 60);
			g2.drawOval(25, 15, 20, 10);
			g2.drawLine(33, 10, 33, 15);
			g2.drawLine(37, 10, 37, 15);
			g2.setColor(Color.white);
			g2.drawLine(0, 10, 0, 60);
		}
		else if(type == SimObjectType.hottub){
			g2.setColor(new Color(210, 105, 30));
			g2.fillArc(0, 0, 40, 40, 90, 90);
			g2.fillArc(0, 60, 40, 40, 180, 90);
			g2.fillArc(60, 0, 40, 40, 0, 90);
			g2.fillArc(60, 60, 40, 40, 270, 90);
			g2.fillRect(20, 0, 60, 100);
			g2.fillRect(0, 20, 105, 60);
			g2.setColor(Color.black);
			g2.drawArc(0, 0, 40, 40, 90, 90);
			g2.drawArc(0, 60, 40, 40, 180, 90);
			g2.drawArc(60, 0, 40, 40, 0, 90);
			g2.drawArc(60, 60, 40, 40, 270, 90);
			g2.drawLine(20, 0, 80, 0);
			g2.drawLine(20, 100, 80, 100);
			g2.drawLine(0, 20, 0, 80);
			g2.drawLine(100, 20, 100, 80);
			g2.setColor(new Color(0, 191, 255));
			g2.fillArc(10, 10, 40, 40, 90, 90);
			g2.fillArc(10, 50, 40, 40, 180, 90);
			g2.fillArc(50, 10, 40, 40, 0, 90);
			g2.fillArc(50, 50, 40, 40, 270, 90);
			g2.fillRect(30, 10, 40, 80);
			g2.fillRect(11, 30, 80, 40);
			g2.setColor(Color.white);
			g2.fillRect(10, 45, 5, 10);
			g2.setColor(Color.black);
			g2.drawArc(10, 10, 40, 40, 90, 90);
			g2.drawArc(10, 50, 40, 40, 180, 90);
			g2.drawArc(50, 10, 40, 40, 0, 90);
			g2.drawArc(50, 50, 40, 40, 270, 90);
			g2.drawLine(30, 10, 70, 10);
			g2.drawLine(30, 90, 70, 90);
			g2.drawLine(10, 30, 10, 70);
			g2.drawLine(90, 30, 90, 70);
			g2.drawLine(30, 15, 15, 30);
			g2.drawLine(30, 85, 15, 70);
			g2.drawLine(70, 15, 85, 30);
			g2.drawLine(70, 85, 85, 70);
			g2.drawLine(30, 15, 70, 15);
			g2.drawLine(30, 85, 70, 85);
			g2.drawLine(15, 30, 15, 70);
			g2.drawLine(85, 30, 85, 70);
			g2.drawArc(0, 0, 40, 40, 280, 70);
			g2.drawArc(60, 0, 40, 40, 190, 70);
			g2.drawArc(0, 60, 40, 40, 10, 70);
			g2.drawArc(60, 60, 40, 40, 100, 70);
			g2.drawLine(23, 40, 23, 59);
			g2.drawLine(77, 40, 77, 59);
			g2.drawLine(40, 23, 59, 23);
			g2.drawLine(40, 77, 59, 77);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.lamp){
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillOval(0, 0, 35, 35);
			if(isTurnedOn)
				g2.setColor(Color.yellow);
			else
				g2.setColor(new Color(218,165,32));
			g2.fillOval(2, 2, 31, 31);
			g2.setColor(Color.black);
			g2.drawOval(0, 0, 35, 35);
			g2.drawOval(2, 2, 31, 31);
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillOval(12, 12, 11, 11);
			if(isTurnedOn)
				g2.setColor(new Color(255,255,75));
			else
				g2.setColor(Color.gray);
			g2.fillOval(14, 14, 7, 7);
			g2.setColor(Color.black);
			g2.drawOval(12, 12, 11, 11);
			g2.drawOval(14, 14, 7, 7);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.radio){
			g2.setColor(Color.gray);
			g2.fillRect(0, 0, 20, 10);
			g2.setColor(Color.white);
			g2.fillRect(5, 5, 10, 5);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 20, 10);
			g2.drawRect(5, 5, 10, 5);
			g2.drawLine(15, 5, 25, 0);
			g2.setColor(Color.red);
			g2.drawLine(7, 7, 12, 7);
			setOpaque(false);
			setContentAreaFilled(false);
			//TODO when in play mode, set all non-action objects to disabled
			//TODO also, when placing a new object, set ALL objects to disabled, then re-enable them when clicked
		}
		else if(type == SimObjectType.TV){
			g2.setColor(Color.gray);
			g2.fillRect(25, 0, 70, 25);
			g2.setColor(Color.black);
			g2.drawRect(25, 0, 70, 25);
			g2.setColor(Color.gray);
			g2.fillRect(0, 0, 120, 20);
			g2.setColor(Color.cyan);
			g2.fillRect(5, 0, 110, 3);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 120, 20);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.computer){
			g2.setColor(Color.white);
			g2.fillRect(0, 20, 40, 10);
			int[] xvalues = {5, 10, 30, 35};
			int[] yvalues = {20, 0, 0, 20};
			int nPoint = 4;
			g2.fillPolygon(xvalues, yvalues, nPoint);
			g2.fillRect(50, 0, 20, 30);
			g2.setColor(Color.cyan);
			g2.fillRect(6, 27, 30, 3);
			g2.setColor(Color.black);
			g2.drawRect(0, 20, 40, 10);
			g2.drawPolygon(xvalues, yvalues, nPoint);
			g2.drawRect(50, 0, 20, 30);
			g2.drawRect(53, 25, 14, 5);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.phone){
			g2.setColor(Color.white);
			g2.fillRect(0, 0, 15, 20);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 15, 20);
			g2.drawOval(7, 3, 6, 5);
			g2.drawOval(7, 12, 6, 5);
			g2.setColor(Color.white);
			g2.fillRect(9, 5, 2, 8);
			g2.setColor(Color.black);
			g2.drawLine(9, 8, 9, 12);
			g2.drawLine(11, 8, 11, 12);
			g2.fillOval(2, 8, 5, 5);
			g2.setColor(new Color(0,255,0));
			g2.drawLine(3, 11, 6, 11);
		}
		else if(type == SimObjectType.fridge){
			g2.setColor(new Color(127,255,212));
			g2.fillRect(0, 0, 70, 50);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 70, 50);
			g2.drawRect(0, 40, 70, 10);
			g2.setColor(Color.gray);
			g2.fillRect(10, 50, 3, 5);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.microwave){
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(0, 0, 40, 30);
			g2.setColor(Color.white);
			g2.fillRect(5, 28, 20, 2);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 40, 30);
			g2.drawRect(0, 25, 30, 5);
			g2.drawRect(30, 25, 10, 5);
			g2.fillRect(25, 30, 3, 3);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.pantry){
			g2.setColor(new Color(205, 133, 63));
			g2.fillRect(0, 0, 70, 45);
			g2.fillRect(28, 45, 3, 5);
			g2.fillRect(41, 45, 3, 5);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 70, 45);
			g2.drawRect(0, 40, 35, 5);
			g2.drawRect(35, 40, 35, 5);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.coffee){
			g2.setColor(new Color(139, 69, 19));
			g2.fillOval(2, 5, 20, 20);
			g2.setColor(Color.black);
			g2.drawOval(2, 5, 20, 20);
			g2.drawOval(3, 5, 19, 19);
			g2.fillRect(12, 25, 2, 4);
			g2.setColor(new Color(255,0,0));
			g2.fillRect(0, 0, 25, 15);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 25, 15);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.painting){
			g2.setColor(new Color(210,105,30));
			g2.fillRect(0, 0, 80, 10);
			g2.setColor(Color.blue);
			g2.fillRect(5, 7, 70, 3);
			g2.setColor(Color.yellow);
			g2.fillRect(20, 7, 10, 3);
			g2.fillRect(45, 7, 20, 3);
			g2.setColor(Color.red);
			g2.fillRect(50, 7, 12, 3);
			g2.setColor(Color.black);
			g2.drawRect(0, 0, 80, 10);
		}
		else if(type == SimObjectType.art){
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(0, 0, 45, 45);
			g2.setColor(new Color(255,215,0));
			g2.fillOval(5, 17, 10, 10);
			g2.fillOval(30, 17, 10, 10);
			g2.setColor(Color.black);
			g2.drawOval(5, 17, 10, 10);
			g2.drawOval(30, 17, 10, 10);
			g2.setColor(new Color(255,215,0));
			g2.fillOval(10, 10, 25, 25);
			g2.setColor(Color.black);
			g2.drawOval(10, 10, 25, 25);
			g2.drawOval(15, 15, 15, 15);
			g2.drawRect(0, 0, 45, 45);
		}
		else if(type == SimObjectType.exercise){
			//width=100, height = 46
			int[] xvalues = {5,50,95,100,60,100,95,50,5, 0,40, 0};
			int[] yvalues = {0,20,0, 5,  23,41, 46,26,46,41,23,5};
			int nPoints = 12;
			g2.setColor(Color.gray);
			g2.fillPolygon(xvalues, yvalues, nPoints);
			g2.setColor(Color.black);
			g2.fillRect(50, 18, 30, 10);
			g2.setColor(Color.gray);
			g2.fillRect(85, 8, 5, 29);
			g2.setColor(Color.black);
			g2.drawRect(85, 8, 5, 29);
			g2.drawPolygon(xvalues, yvalues, nPoints);
			g2.setColor(new Color(220,20,60));
			g2.fillRect(20, 5, 40, 35);
			g2.setColor(Color.black);
			g2.drawRect(20, 5, 40, 35);
			g2.drawRect(20, 5, 10, 35);
			g2.fillRect(80, 10, 15, 25);
			g2.setColor(Color.cyan);
			g2.fillRect(80, 15, 3, 15);
			g2.setColor(Color.black);
			g2.drawRect(80, 10, 15, 25);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		else if(type == SimObjectType.piano){
			g2.setColor(Color.black);
			g2.fillRect(0, 0, 90, 120);
			g2.fillOval(50, 0, 70, 80);
			g2.setColor(Color.white);
			g2.fillArc(70, 80, 40, 50, 90, 180);
			g2.fillRect(3, 10, 9, 100);
			g2.setColor(Color.gray);
			g2.drawLine(25, 10, 25, 110);
			g2.setColor(Color.black);
			g2.drawLine(3, 15, 12, 15);
			g2.drawLine(3, 20, 12, 20);
			g2.drawLine(3, 25, 12, 25);
			g2.drawLine(3, 30, 12, 30);
			g2.drawLine(3, 35, 12, 35);
			g2.drawLine(3, 40, 12, 40);
			g2.drawLine(3, 45, 12, 45);
			g2.drawLine(3, 50, 12, 50);
			g2.drawLine(3, 55, 12, 55);
			g2.drawLine(3, 60, 12, 60);
			g2.drawLine(3, 65, 12, 65);
			g2.drawLine(3, 70, 12, 70);
			g2.drawLine(3, 75, 12, 75);
			g2.drawLine(3, 80, 12, 80);
			g2.drawLine(3, 85, 12, 85);
			g2.drawLine(3, 90, 12, 90);
			g2.drawLine(3, 95, 12, 95);
			g2.drawLine(3, 100, 12, 100);
			g2.drawLine(3, 105, 12, 105);
			g2.fillRect(7, 14, 5, 3);
			g2.fillRect(7, 24, 5, 3);
			g2.fillRect(7, 29, 5, 3);
			g2.fillRect(7, 34, 5, 3);
			g2.fillRect(7, 44, 5, 3);
			g2.fillRect(7, 49, 5, 3);
			g2.fillRect(7, 59, 5, 3);
			g2.fillRect(7, 64, 5, 3);
			g2.fillRect(7, 69, 5, 3);
			g2.fillRect(7, 79, 5, 3);
			g2.fillRect(7, 84, 5, 3);
			g2.fillRect(7, 94, 5, 3);
			g2.fillRect(7, 99, 5, 3);
			g2.fillRect(7, 104, 5, 3);
			setOpaque(false);
			setContentAreaFilled(false);
		}
		
		setBorderPainted(false);
		g2.dispose();
	}
	
	/*****************************************************************************
	 * Toggles the lamp object to on or off
	 *****************************************************************************/
	public void toggleIsTurnedOn(){
		if(isTurnedOn){
			isTurnedOn = false;
		}else{
			isTurnedOn = true;
		}
	}
}
