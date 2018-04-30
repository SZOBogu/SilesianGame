import java.util.ArrayList;
/**
 * Care taker is a part of Memento implementation. Stores Mementos and allows us to save to them and return them.
 * @author Bogu
 *
 */
public class Caretaker {
    public void addMemento(Memento m) {
        mementos.add(m);
        System.out.println("Dodano pamyjontek \n");       
    }

    public Memento getMemento() {
    	if(mementos.isEmpty()){							//returns null if there are no mementos
            System.out.println("Ni mo pamyjontek \n");
            return null;
    	}
    	else {
    		//returns first saved memento, copied it form somewhere, didn't bother to change it.
            System.out.println("Wczytano pamyjontek \n");    
    		return mementos.get(0);						
    	}

    }
    private ArrayList<Memento> mementos = new ArrayList<>();
}
