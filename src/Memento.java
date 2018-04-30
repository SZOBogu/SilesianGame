/**
 * Memento is part of Memento design pattern (duh).
 * It remembers how much money we have on the moment of saving.
 * Remembering kingdom was troublesome at the time i made it (also deadline was drawing near), might change it someday.
 * @author Bogu
 *
 */

public class Memento {
	
	public Memento(int treasury){
		this.treasury=treasury;
	}
	//returns saved money
	public int getState(){
		return treasury;
	}
	
	private int treasury;
}
