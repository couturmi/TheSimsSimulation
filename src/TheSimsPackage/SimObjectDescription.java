package TheSimsPackage;

public class SimObjectDescription {

	public SimObjectDescription(){}
	
	public static String getFor(SimObjectType t){
		String s = "A " + t.toString() + "\n\n";
		if(t.toString().equals("bed")){
			return s + "Nothing more comfortable than a bed! \n\nThe best way to gain Energy.\n";
		}else if(t.toString().equals("couch")){
			return s + "A comfy place to sit and relax. \n\nIncreases Comfort\n";
		}else if(t.toString().equals("chair")){
			return s + "Tired of standing? Get a chair! \n\nIncreases Comfort\n";
		}else if(t.toString().equals("table")){
			return s + "Stop putting things on the ground. Buy \na table! \n\n";
		}else if(t.toString().equals("stand")){
			return s + "No place to put stuff? But a small stand! \n\n\n";
		}else if(t.toString().equals("counter")){
			return s + "Every Kitchen needs a countertop! \n\n\n";
		}else if(t.toString().equals("sink")){
			return s + "You don't want dirty hands, do you? \n\nIncreases Hygiene\n";
		}else if(t.toString().equals("toilet")){
			return s + "If you gotta go, here's the place. \n\nRelieves Bladder\n";
		}else if(t.toString().equals("bath")){
			return s + "A great way to clean yourself. \n\nIncreases Hygiene\n";
		}else if(t.toString().equals("shower")){
			return s + "For the best clean, buy a shower! \n\nThe best way to gain Hygiene\n";
		}else if(t.toString().equals("hottub")){
			return "A hot tub\n\n" + "It's fun, warm, and relaxing. \n\nIncreases Comfort + Fun\n";
		}else if(t.toString().equals("lamp")){
			return s + "Unless you are blind, you might \nneed one of these. \n\n";
		}else if(t.toString().equals("light")){
			return s + "The best way to light up your room is \nfrom above! \n\n";
		}else if(t.toString().equals("radio")){
			return s + "There's nothing like jamming out to your \nfavorite tunes. \nIncreases Fun\n";
		}else if(t.toString().equals("TV")){
			return s + "If you hook it up quick enough, you might \nbe just in time for Breaking Bad. \nA great way to have Fun\n";
		}else if(t.toString().equals("computer")){
			return s + "Play some games, scroll through \nFacebook, or watch YouTube. \nIncreases Fun\n";
		}else if(t.toString().equals("phone")){
			return s + "Call up your friends with the revolutionary \nhouse phone! \nIncreases Social\n";
		}else if(t.toString().equals("fridge")){
			return s + "The most efficient way to eat a meal is \nto eat one from the fridge. \nRelieves Hunger\n";
		}else if(t.toString().equals("microwave")){
			return s + "If you like HotPockets and Pizza Rolls, \nyou need one of these. \nRelieves Hunger\n";
		}else if(t.toString().equals("pantry")){
			return s + "The quickest way to get a snack. \n\nRelieves Hunger\n";
		}else if(t.toString().equals("coffee")){
			return "A coffee machine\n\n" + "If you're really tired, sometimes you just \nneed a cup of coffee. \nIncreases Energy\n";
		}else if(t.toString().equals("painting")){
			return s + "Your walls look bare. Buy a painting! \n\nIncreases Environment\n";
		}else if(t.toString().equals("art")){
			return "A piece of art\n\n" + "You'll be the envy of all your friends with \nan art sculpture like this! \nIncreases Environment\n";
		}else if(t.toString().equals("exercise")){
			return "An exercise machine\n\n" + "You may not want it, but an exercise \nmachine is great for working out. \nIncreases Fun\n";
		}else if(t.toString().equals("piano")){
			return s + "Make some beautiful music with this \nGrand Piano! \nIncreases Fun\n";
		}
		
		System.out.println("SimObjectDescription error: returned null");
		return null;
	}
	
}
