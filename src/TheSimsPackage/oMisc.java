package TheSimsPackage;

public class oMisc extends SimObject{
	
	public oMisc(SimObjectType t){
		super(t);
		super.setObjectClass("Misc");
	}

	@Override
	public void setObject(){
		if(super.objectType() == SimObjectType.exercise){
			setTitle("Excercise");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(-5);
			super.setForBladder(0);
			super.setForEnergy(-5);
			super.setForFun(30);
			super.setForSocial(0);
			super.setForHygiene(-5);
			super.setForEnvironment(5);
			setTimeToComplete(60);
		}
		else if(super.objectType() == SimObjectType.piano){
			setTitle("Play piano");
			setIsActionObject(true);
			super.setForHunger(0);
			super.setForComfort(20);
			super.setForBladder(0);
			super.setForEnergy(0);
			super.setForFun(35);
			super.setForSocial(0);
			super.setForHygiene(0);
			super.setForEnvironment(10);
			setTimeToComplete(30);
		}
		else{
			System.out.print("Error: SimObjectType in wrong ObjectClass");
		}
	}
}
