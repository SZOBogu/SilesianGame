import java.util.ArrayList;
import java.util.Scanner;
/**
 * Player class. Far too large, i admit it, should've divide it into couple classes.
 * @author Bogu
 *
 */
public class Player {
	public Player(String name){
		this.name = name;							//player name
		this.treasury=2500;							//initial money, stated in the task
		this.kingdom = new ArrayList<Building>();	//arraylist of built Buildings
		this.saves = new Caretaker();				//caretaker, containing mementos, and allowing to use them
	}
	/*
	 * Building interface, we choose building here, the Factory creates it, then building is added to our kingdom
	 */
	public void build(){
		System.out.println("Panie Szefie co pan by chcio³ se zrobiæ? \n1.Kamienio³om\n2.Cha³upe drwala\n3.Tartak\n4.Gruba z³ota\n5.Mennice\n");
		Scanner s = new Scanner(System.in);			//for getting building number
		int i = s.nextInt();
		Factory factory = new Factory();			//creates Factory
		
		/*
		 * Factory creates and returns Building we wished for.
		 * If for whatever reason Building wasn't created, it returns null
		 */
		Building building = factory.getBuilding(i, this);	
		if(building !=null){
			this.kingdom.add(building);				//appending Building to kingdom
			System.out.println("Na slunsku wybudowano " +building.getName() + ".");	//confirmation of build
			building.work(this);					//activating 1 working cycle
		}
		else 	System.out.println("Na slunsku nic nie wybudowano.");
		this.play();								//return to main interface
	}
	/* "super loop" in which "game" happens, also main interface
	 *  To end the game you have to admit you're not Silesian (last option).
	 */
	public void play(){
		System.out.println("\nCo tera chcesz?\n1.Budowaæ\n2.Badnonæ swój geld\n3.Zapisoæ\n4.Wczytoæ\n5.Popatrzeæ na nasz pikny Œlunsk\n6.Zmusic hanysow do roboty\n7.Przyznaæ siê i¿e je¿eœ gorol\n");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		if(i==1){
			build();	//goes to Building interface
		}
		if(i==2){
			this.checkTreasury();		//returns how much money we have.
			this.play();
		}
		if(i==3){
		    saves.addMemento(save());	//saves how much money we have
			this.play();
		}
		if(i==4){
		    restore(saves.getMemento());	//returns first saved treasury state
			this.play();
		}
		if(i==5){
		    this.showKingdom();			//prints names of every building built so far
			this.play();
		}
		if(i==6){
		    this.forceToWork(this);		//Commences 1 working cycle in each of built buildings
			this.play();
		}		
		if(i==7){
			System.out.println("Chopy! To je gorol! <Przegra³eœ>");	//ends game
		    System.exit( 0 );
		}
		else{
			System.out.println("Tyœ je gupi gorol \n");	//if you fail to use simple interface
			this.play();
		}
	}
	//w zasadzie powinna nazywac sie earnMoney czy cos, dodaje do skarbca kwote wyslana w argumencie funkcji
	public void getMoney(int money){
		System.out.println("Hanys " + this.name + " erbnon³ " + money + " œlusnkmarek");
		this.treasury+=money;
	}
	/*
	 * Metoda zwraca TRUE jesli gracza stac na wydanie kwoty przeslanej w argumencie i odejmuje ta kwote
	 * zwraca FALSE jesli gracza nie stac na taki wydatek
	 */
	public boolean loseMoney(int money){
		if(this.treasury-money >= 0){
			System.out.println("Hanys " + this.name + " wydo³ " + money + " œlusnkmarek");
			this.treasury-=money;
			return true;
		}
		else{
			System.out.println("Ni mosz geldu\n");
			return false;
		}
	}
	
	public void checkTreasury(){
		System.out.println("Hanys " + this.name + " mo " + this.treasury + " œlusnkmarek");	
	}
	//Iteruje po arrayliscie kingdom, bierze od budynkow w niej zawartych nazwe i wypisuje w konsoli
	public void showKingdom(){
		if(kingdom.isEmpty()){
			System.out.println("Bida.\n");		//jesli nie ma zadnych budynkow
		}
		for(int i=0;i<kingdom.size();i++){
			Building building = kingdom.get(i);
			System.out.println(i+1 +". "+ building.getName());
		}
	}
	//zapisuje aktualny stan skarbca do pamiatki
	public Memento save(){
        System.out.println("Zapisuja do pamyjountki\n");
        Memento save = new Memento(this.treasury);
        return save;
	}
	//wczytuje z pamiatki stan skarbca i nadpisuje aktualny
	public void restore(Memento memento){
		int state = memento.getState();
		this.treasury = state;
        System.out.println("Wczytuja\n");
	}
	
	//Funkcja zwraca TRUE jesli gracz posiada taki sam budynek jak przeslany w argumencie
	public boolean checkForBuilding(Building building){
		for(int i=0;i<kingdom.size();i++){
			Building build = this.kingdom.get(i);
			//z jakiegos powodu porownywanie samych obiektow nie dzialalo, dlatego porownuje imiona
			if(build.getName()==building.getName()){
				return true;
			}
		}
		return false;
	}
	/*
	 * jako ze budynki nie pracuja automatycznie (bo z tym jest masa roboty, jesli mialby jeszcze dzialac interfejs
	 * to do pracy w cyklach po pierwszym budynki zmuszami recznie, z glownego interfejsu
	 * idziemy po arrayliscie kingdom i na kazdym budynku wywlojemy metode work()
	 */
	public void forceToWork(Player player){				
		for(int i=0;i<kingdom.size();i++){
			Building building = kingdom.get(i);
			building.work(this);
		}
	}
	
	private int treasury;							//przechowuje aktualny stan finansowy gracza
	private String name;
	private ArrayList<Building> kingdom;			//arraylist wybudowanych budynkow
	private Caretaker saves;						//caretaker, przechowujacy pamiatki i umozliwiajacy korzystanie z nich
}
