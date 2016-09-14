package TheSimsPackage;

public class oPlumbing extends SimObject{
	
	public oPlumbing(SimObjectType t){
		super(t);
		super.setObjectClass("Plumbing");
	}

	@Override
	public void setObject(){
		if(super.objectType() == SimObjectType.sink){
			setTitle("Wash Hands");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(0);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(35);
			super.setForEnvironment(0);
			setTimeToComplete(10);
		}
		else if(super.objectType() == SimObjectType.toilet){
			setTitle("Use Toilet");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(10);
			super.setForBladder(100);
			super.setForEnergy(0);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(0);
			setTimeToComplete(15);
		}
		else if(super.objectType() == SimObjectType.bath){
			setTitle("Take bath");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(30);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(70);
			super.setForEnvironment(0);
			setTimeToComplete(45);
		}
		else if(super.objectType() == SimObjectType.shower){
			setTitle("Take shower");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(5);
			super.setForBladder(10);
			super.setForEnergy(0);
			super.setForFun(0);
			super.setForSocial(0);
			super.setForHygiene(100);
			super.setForEnvironment(0);
			setTimeToComplete(40);
		}
		else if(super.objectType() == SimObjectType.hottub){
			setTitle("Use Hot Tub");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(70);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(25);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(30);
			setTimeToComplete(60);
		}
		else{
			System.out.print("Error: SimObjectType in wrong ObjectClass");
		}
	}
}
