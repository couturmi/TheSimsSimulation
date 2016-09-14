package TheSimsPackage;

public class oElectric extends SimObject{
	
	public oElectric(SimObjectType t){
		super(t);
		super.setObjectClass("Electric");
	}

	@Override
	public void setObject(){
		if(super.objectType() == SimObjectType.lamp){
			setTitle("Flip Switch");
			super.setForEnvironment(2);
		}
		else if(super.objectType() == SimObjectType.radio){
			setTitle("Listen to radio");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(20);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(20);
		}
		else if(super.objectType() == SimObjectType.TV){
			setTitle("Watch TV");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(50);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(60);
		}
		else if(super.objectType() == SimObjectType.computer){
			setTitle("Use Computer");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(40);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(45);
		}
		else if(super.objectType() == SimObjectType.phone){
			setTitle("Call Someone");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(20);
			super.setForSocial(30);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(30);
		}
		else{
			System.out.print("Error: SimObjectType in wrong ObjectClass");
		}
	}
}
