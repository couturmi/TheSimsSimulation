package TheSimsPackage;

public class oFurniture extends SimObject{
	
	public oFurniture(SimObjectType t){
		super(t);
		super.setObjectClass("Furniture");
	}
	
	@Override
	public void setObject(){
		if(super.objectType() == SimObjectType.bed){
			setTitle("Sleep");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(90); 
			super.setForBladder(0);
			super.setForEnergy(80);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(3);
			setTimeToComplete(540);
		}
		else if(super.objectType() == SimObjectType.couch){
			setTitle("Relax");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(30);
			super.setForBladder(0);
			super.setForEnergy(5);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(5);
			setTimeToComplete(20);
		}
		else if(super.objectType() == SimObjectType.chair){
			setTitle("Sit");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(30);
			super.setForBladder(0);
			super.setForEnergy(5);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(1);
			setTimeToComplete(20);
		}
		else if(super.objectType() == SimObjectType.table){
			setTitle("No Action Available");
			setIsActionObject(false);
			super.setForEnvironment(5);
		}
		else if(super.objectType() == SimObjectType.stand){
			setTitle("No Action Available");
			setIsActionObject(false);
			super.setForEnvironment(5);
		}
		else if(super.objectType() == SimObjectType.counter){
			setTitle("No Action Available");
			setIsActionObject(false);
			super.setForEnvironment(2);
		}
		else{
			System.out.print("Error: SimObjectType in wrong ObjectClass");
		}
	}
}
