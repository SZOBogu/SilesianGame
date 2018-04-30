import java.util.Scanner;
/**
 * In this class is main function (obviously), it creates Player instance and begins the game.
 * @author Bogu
 *
 */

public class Main {

	public static void main(String[] args) {
		System.out.println("Jok sie zowiesz?.\n");	//"what's your name", further passed to Player constructor
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();

		Player player = new Player(str);
		player.play();
	}

}
