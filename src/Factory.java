/**
 * It uses simple Abstract Factory pattern
 * 
 * Works using simple scheme:
 * 1.Player in build() method creates Factory and uses getBuilding() method
 * 2.checkRequirements() checks if we have Buildings needed to build chosen one.
 * 3.loseMoney() returns TRUE if player has enough money, and spent it to build. Otherwise returns FALSE.
 * 4.Building is returned should everything go smoothly. Otherwise NULL is returned.
 * @author Bogu
 *
 */
public class Factory {
	public Building getBuilding(int choice, Player player){
		if(choice == 1){
			Building quarry = new Quarry();
			//checks if we can afford the Building
			if(player.loseMoney(quarry.getCost())){
				quarry.beBuilt(player);				//informs us about successful building process
				return quarry;						//returns quarry
			}
			else return null;						//if something goes wrong it returns null

		}
		else if(choice == 2){
			Building lumber = new LumberjacksHut();
			if (lumber.checkRequirements(player)){		//shamelessly copied from above, instead of money it checks for required building
				if(player.loseMoney(lumber.getCost())){
					lumber.beBuilt(player);
					return lumber;
				}
			}
			return null;
		}
		else if(choice == 3){
			Building sawmill = new Sawmill();
			if (sawmill.checkRequirements(player)){ 
				if(player.loseMoney(sawmill.getCost())){
					sawmill.beBuilt(player);
					return sawmill;
				}
			}
			return null;
		}
		else if(choice == 4){
			Building mine = new GoldMine();

			if (mine.checkRequirements(player)){ 
				if(player.loseMoney(mine.getCost())){
					mine.beBuilt(player);
					return mine;
				}
			}
			return null;
		}
		else if(choice == 5){
			Building mint = new Mint();
			if (mint.checkRequirements(player)){
				if(player.loseMoney(mint.getCost())){
					mint.beBuilt(player);
					return mint;
				}
			}
			return null;
		}
		else{
			System.out.println("Tyœ je gupi gorol \n");			//loosely translates to "please use the interface as it's intended to be".
			return null;
		}
	}
}
