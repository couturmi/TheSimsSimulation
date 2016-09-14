package TheSimsPackage;

public class oDecoration extends SimObject{
	
	public oDecoration(SimObjectType t){
		super(t);
		super.setObjectClass("Decoration");
	}
	
	@Override
	public void setObject(){
		if(super.objectType() == SimObjectType.painting){
			setTitle("No Action Available");
			setIsActionObject(false);
			super.setForEnvironment(20);
		}
		else if(super.objectType() == SimObjectType.art){
			setTitle("No Action Available");
			setIsActionObject(false);
			super.setForEnvironment(25);
		}
		else{
			System.out.print("Error: SimObjectType in wrong ObjectClass");
		}
	}
}
