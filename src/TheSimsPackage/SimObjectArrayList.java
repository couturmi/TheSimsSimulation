package TheSimsPackage;

import java.util.ArrayList;

/*****************************************************************************************
 * An ArrayList to hold SimObjects
 * @author Mitchell Couturier
 * @version 2/17/2015
 * @param <E>
 *****************************************************************************************/
public class SimObjectArrayList<SimObject> extends ArrayList<SimObject>{

	public SimObject findSimObjectOfType(String oClass, SimObjectType type){
		SimObject x;
		for(int i = 1; i <= this.size(); i++){
			x = this.get(i-1);
			//ADD AN IF STATEMENT HERE LATER FOR IF AN OBJECT IS CURRENTLY BEING USED BY ANOTHER SIM, THEN RETURN NULL
			//but do that in the SimsGame class and just add to the if statement
			if(oClass.equals("Furniture") && ((TheSimsPackage.SimObject) x).getObjectClass().equals("Furniture")){
				if(((oFurniture) x).objectType() == type){
					return x;
				}
			}else if(oClass.equals("Plumbing") && ((TheSimsPackage.SimObject) x).getObjectClass().equals("Plumbing")){
				if(((oPlumbing) x).objectType() == type){
					return x;
				}
			}else if(oClass.equals("Misc") && ((TheSimsPackage.SimObject) x).getObjectClass().equals("Misc")){
				if(((oMisc) x).objectType() == type){
					return x;
				}
			}else if(oClass.equals("Kitchen") && ((TheSimsPackage.SimObject) x).getObjectClass().equals("Kitchen")){
				if(((oKitchen)x).objectType() == type){
					return x;
				}
			}else if(oClass.equals("Electric") && ((TheSimsPackage.SimObject) x).getObjectClass().equals("Electric")){
				if(((oElectric) x).objectType() == type){
					return x;
				}
			}else if(oClass.equals("Decoration") && ((TheSimsPackage.SimObject) x).getObjectClass().equals("Decoration")){
				if(((oDecoration) x).objectType() == type){
					return x;
				}
			}
		}
		return null;
	}
}
