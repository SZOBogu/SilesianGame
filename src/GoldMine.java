//import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Gold mine, requires Sawmill
 * @author Bogu
 *
 */
public class GoldMine extends Building  implements Buildable{

	public GoldMine() {
		super(5000, 1000);
		this.setName("Gruba Z³ota"); 
	}

	@Override
	public void saySomething() {
		System.out.println("Nie godom z gorolami.");
	}

	@Override
	public void eat(Player player) {
		System.out.println("To je fest szfarno rolada.");
	}
	
	/*
	 *  To make things more interesting, our gold mines refuse to work sometimes, and protests, which slows down production
	 *  Not intended to mock miners.
	 */
	@Override
	public void work(Player player) {
		super.work(player);
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
		if (randomNum == 10){
			protest();
		}
	}
	
	void protest(){
		int randomNum = (ThreadLocalRandom.current().nextInt(0, 10 + 1))*1000;
		System.out.println("Te gorole ino biero nosz geld z naszej gruby.\nGrubiorze strajkujo przez:" + randomNum);
		//TODO: use Sleeper
		try{
		    Thread.sleep(randomNum);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		};
	}

	@Override
	public Building beBuilt(Player player) {
			Building mine = new GoldMine();
			System.out.println("Zbudowano grube z³ota.\n");
			return mine;
	}

	@Override
	public boolean checkRequirements(Player player) {
		Building sawmill = new Sawmill();
		//checks for Sawmill
		if(player.checkForBuilding(sawmill)){
			return true;
		}		
		else{
			System.out.println("Ni mosz tartaku\n");
			return false;
		}
	}
}
