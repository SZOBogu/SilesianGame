/**
 * Sleeper is created to delay functions easy way without pasting exception handler every time I use it.
 * @author Bogu
 *
 */
public class Sleeper {
	
	public void sleep(int delay){
		try{
			    Thread.sleep(delay);
			} 
		catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			};
	}
	
}
