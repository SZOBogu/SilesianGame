/**
 * Mint class, requires Gold Mine to be built.
 * @author Bogu
 *
 */
public class Mint extends Building  implements Buildable {

	public Mint() {
		super(10000, 3000);
		this.setName("Mennica"); 
	}

	@Override
	public void saySomething() {
		System.out.println("Mennicu mennicu");

	}
	//see: https://www.youtube.com/watch?v=rDDmy_as3t8
	@Override
	public void eat(Player player) {
		Sleeper s = new Sleeper();
		System.out.println("Mmm wodzionka");
		s.sleep(200);
		System.out.println("Suchy chlyb i wody szklonka");
		s.sleep(200);
		System.out.println("Mmm wodzionka");
		s.sleep(200);
		System.out.println("To najlepsza z wszystkich œlunskich zup");
		s.sleep(200);
		System.out.println("Mmm wodzionka");
		s.sleep(200);
		System.out.println("To je ósmy œwiata cud\n");
		player.loseMoney(100);
	}
	/*
	 * work() method differs in this building by sleeping 2 times. Change for the sake of change.
	 * (non-Javadoc)
	 * @see Building#work(Player)
	 */
	@Override
	public void work(Player player) {
		sleep();
		super.work(player);
	}

	@Override
	public Building beBuilt(Player player) {
		Building mint = new Mint();
		System.out.println("Zbudowano Mennice.");
		return mint;
	}

	@Override
	public boolean checkRequirements(Player player) {
		Building mine = new GoldMine();
		//checks for goldmine
		if(player.checkForBuilding(mine)){
			return true;
		}		
		else{
			System.out.println("Ni mosz gruby\n");
			return false;
		}
	}

}
