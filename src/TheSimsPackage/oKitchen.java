package TheSimsPackage;

public class oKitchen extends SimObject{

	public oKitchen(SimObjectType t){
		super(t);
		super.setObjectClass("Kitchen");
	}
	
	@Override
	public void setObject(){
		if(super.objectType() == SimObjectType.fridge){
			setTitle("Eat food");
			setIsActionObject(true);
			super.setForHunger(40);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(5);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(20);
		}
		else if(super.objectType() == SimObjectType.microwave){
			setTitle("Eat food");
			setIsActionObject(true);
			super.setForHunger(35);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(5);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(25);
		}
		else if(super.objectType() == SimObjectType.pantry){
			setTitle("Eat food");
			setIsActionObject(true);
			super.setForHunger(20);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(5);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(5);
		}
		else if(super.objectType() == SimObjectType.coffee){
			setTitle("Drink Coffee");
			setIsActionObject(true);
			super.setForHunger(10);
			super.setForComfort(15);
			super.setForBladder(0);
			super.setForEnergy(20);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(10);
		}
		else{
			System.out.print("Error: SimObjectType in wrong ObjectClass");
		}
	}
}
