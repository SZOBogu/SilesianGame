/**
 * Sawmill building, requires Lumberjacks Hut
 * 
 */
public class Sawmill extends Building implements Buildable {

	public Sawmill() {
		super(3000, 500);
		this.setName("Tartak"); 
	}

	@Override
	public void saySomething() {
		System.out.println("Ale ¿ech by sie chcio³ zdrzimnonæ");
		this.sleep();												//easter egg, never invoked
	}

	@Override
	public void eat(Player player) {
		int i = 0;
		System.out.println("Tartakowa frela zdymfowa³a modro kapuste");
		//generates eating sounds, doesn't have any important purpose, I just wanted to see if something happens.
		if(i<10){													
			System.out.println("mlask");	
			i++;
		}
		player.loseMoney(12);
	}

	@Override
	public void work(Player player) {
		super.work(player);
		eat(player);					//Sawmill differs from other Buildings by eating 2 times
	}

	@Override
	public Building beBuilt(Player player) {
			Building sawmill = new Sawmill();
			System.out.println("Zbudowano Tartak.\n");
			return sawmill;
	}

	@Override
	public boolean checkRequirements(Player player) {
		Building lumber = new LumberjacksHut();
		if(player.checkForBuilding(lumber)){			//chceks for Lumberjacks Hut
			return true;	
		}
		else{
			System.out.println("Ni mosz cha³upy drwala\n");
			return false;
		}
	}
}
