package TheSimsPackage;

import java.awt.Frame;

import javax.swing.JFrame;

public class SimsTest {

	private static JFrame frame;
	
	public static void main(String [] args){
		frame = new JFrame("Sims Tester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SimsPanelTest panel = new SimsPanelTest();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	/*************************************************************************
	 * Called in the SimPanelTest class to resize the frame when needed
	 *************************************************************************/
	public static void reset(){
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
}
