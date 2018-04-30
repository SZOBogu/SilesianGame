/**
 * LumberjacksHut, requires Quarry
 * @author Bogu
 *
 */
public class LumberjacksHut extends Building implements Buildable{

	public LumberjacksHut() {
		super(500, 300);
		this.setName("Cho³upa Drwala"); 
	}

	@Override
	public void saySomething() {				//not invoked
		System.out.println("Drwalu Drwalu");
	}

	@Override
	public void eat(Player player) {			//takes some money
		System.out.println("Pyszne kluski");
		player.loseMoney(7);
	}

	@Override
	public Building beBuilt(Player player) {
		Building lumber = new LumberjacksHut();
		System.out.println("Zbudowano Cho³upe Drwala.");	
		return lumber;
	}

	@Override
	public boolean checkRequirements(Player player) {
		Building quarry = new Quarry();
		if(player.checkForBuilding(quarry)){			//checks kingdom for Quarry
			return true;	
		}
		else{
			System.out.println("Ni mosz kamynio³omu\n");
			return false;
		}
	}

}
