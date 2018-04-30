/**
 * Building interface
 * @author Bogu
 *
 */
public interface Buildable {
	Building beBuilt(Player player);		//Building returns itself and informs us about being built.
	abstract void saySomething();			//not invoked, ever. Someday i'll have some sort idea how to use it.
	abstract void eat(Player player);		//informs about eating, and takes away small amount of money
	void generateIncome(Player player);		//genereates income, as you'd expect
	void sleep();							//delays for some time
	void work(Player player);				//begins working cycle: eat -> generateIncome -> sleep
	boolean checkRequirements(Player player);//checks if Player has Buildings required to build what he wants to be built
	
	String getName();
	void setName(String name);
	int getCost();
	void setCost(int cost);
	int getIncome();
	void setIncome(int income);

}
