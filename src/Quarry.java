/**
 * Only Building that doesn't require others to be built. It's entire behavior is defined in Building class.
 * @author Bogu
 *
 */
public class Quarry extends Building implements Buildable{

	public Quarry() {
		super(500, 200);
		this.setName("Kamynio³om"); 
	}

	@Override
	public void saySomething() {
		System.out.println("Te kamynie som fest twarde");
		setIncome(getIncome()+1);							
	}

	@Override
	public void eat(Player player) {
		System.out.println("Pierwej sort ta rolada");
		player.loseMoney(5);
	}

	@Override
	public void sleep() {
		System.out.println("Pieruna ale harówka");
		super.sleep();
	}

	@Override
	public Building beBuilt(Player player) {
		Building quarry = new Quarry();
		System.out.println("Zbudowano Kamynio³om.\n");
		return quarry;
	}
	//Since it doesn't require other buildings it always fulfills requirements, therefore it returns true
	@Override
	public boolean checkRequirements(Player player) {
		return true;
	}

}
