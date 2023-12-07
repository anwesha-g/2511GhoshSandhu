import java.util.Scanner;
//Gets both players names, asks if you want to play against the computer, creates a new NimGame instance with player names and computer player, starts the game.
public class NimGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      System.out.println("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();

        System.out.println("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();

        System.out.println("Do you want to play against the computer? (yes/no): ");
        boolean playAgainstComputer = scanner.nextLine().equalsIgnoreCase("yes");

        NimGame nimGame = new NimGame(player1Name, player2Name, playAgainstComputer);

        nimGame.play();

        scanner.close();
    }
}
