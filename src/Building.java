/**
 * Building, most of the Template Method implementation is here. Roughly defines algorithm of Buildings behavior.
 * @author Bogu
 *
 */
public abstract class Building implements Buildable{
	public Building(int cost, int income){
		this.cost=cost;
		this.income=income;
		this.name = "Cha³upa";
	}

	public abstract void saySomething();				//not used
	//returns itself and informs us about it
	public abstract Building beBuilt(Player player);
	public abstract void eat(Player player);			//informs us about eating and steals some money from treasury
	
	//generates income directly to the Player. Amount of money returned defined in specific Building subclass constructors.
	public void generateIncome(Player player){			
		player.getMoney(this.income);
	};
	//Stills program for a second
	public void sleep(){
		Sleeper s = new Sleeper();
		s.sleep(1000);
	}
	/*Algorithm of Building behavior.
	 * 
	 * The initial working cycle is defined here, which can be altered on subclasses, 
	 * but even of we do so, most implementation is done here. 
	 * In subclasses i tried to differ every Building type apart from Quarry in some way.
	 */
	public void work(Player player){
		eat(player);
		generateIncome(player);
		sleep();
	};
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	//fields
	private int cost;
	private int income;
	private String name;
}

