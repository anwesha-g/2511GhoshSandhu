import java.util.Random;
import java.util.Scanner;

class NimGame {
    // nnstance variables
    private Pile pile;
    private Player[] players;
    private int currentPlayerIndex;
    private boolean playAgainstComputer;
    private Scanner scanner;

    // constructor for initializing the game
    public NimGame(String player1Name, String player2Name, boolean playAgainstComputer) {
        // creates a new pile and initialize players
        this.pile = new Pile();
        this.players = new Player[]{new Player(player1Name), new Player(player2Name)};
        // randomly chooses the first plasyer
        this.currentPlayerIndex = new Random().nextInt(2);
        this.playAgainstComputer = playAgainstComputer;
        this.scanner = new Scanner(System.in);
    }

    // main game loop
    public void play() {
        // contineus playing until the pile is empty
        while (pile.getSize() > 0) {
            displayGameStatus();  // displayus the current game status
            // determines if its the human or computer playing and actjs accordingly
            if (currentPlayerIndex == 1 && playAgainstComputer) {
                playComputerTurn();
            } else {
                playPlayerTurn();
            }
            switchPlayer();  // swithces to the next player
        }
        announceWinner();  // anounces the winner when the game is over
    }

    // displays the current game status
    private void displayGameStatus() {
        System.out.println("Pile size: " + pile.getSize());
        System.out.println("Current Player: " + players[currentPlayerIndex].getName());
    }

    // human's turn
    private void playPlayerTurn() {
        int maxPieces = Math.min(pile.getSize() / 2, 4);
        System.out.println("Enter the number of pieces to take (1-" + maxPieces + "): ");
        int pieces = scanner.nextInt();

        // vlaidates user input
        while (pieces < 1 || pieces > maxPieces) {
            System.out.println("Invalid input. Enter a number between 1 and " + maxPieces + ": ");
            pieces = scanner.nextInt();
        }

        // updates pile size based on player's move
        int currentPileSize = pile.getSize();
        currentPileSize -= pieces;
        pile.setSize(currentPileSize);
        System.out.println(players[currentPlayerIndex].getName() + " took " + pieces + " pieces.");
    }

    // Computer's turn
    private void playComputerTurn() {
        Random random = new Random();
        int maxPieces = Math.min(pile.getSize() / 2, 4);
        int pieces = random.nextInt(maxPieces) + 1;

        // upates pile size based on computer's move
        int currentPileSize = pile.getSize();
        currentPileSize -= pieces;
        pile.setSize(currentPileSize);
        System.out.println("Computer took " + pieces + " pieces.");
    }

    // switches to the next player
    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    // anounces the winner
    private void announceWinner() {
        System.out.println("Game Over!");
        System.out.println(players[currentPlayerIndex].getName() + " is the winner!");
    }
}
