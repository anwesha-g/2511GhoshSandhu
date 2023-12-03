import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize heaps
        int[] heaps = {3, 5, 7};

        // Game loop
        while (true) {
            // Display current state of heaps
            displayHeaps(heaps);

            // Get player's move or let the computer play
            if (isPlayerTurn(heaps)) {
                int heapIndex = getPlayerMove(scanner);
                int objectsToRemove = getObjectsToRemove(scanner, heaps, heapIndex);

                // Update heaps
                heaps[heapIndex] -= objectsToRemove;
            } else {
                System.out.println("Computer's turn:");
                computerPlay(heaps, random);
            }

            // Check for game end
            if (isGameOver(heaps)) {
                displayHeaps(heaps);
                if (isPlayerTurn(heaps)) {
                    System.out.println("Player wins!");
                } else {
                    System.out.println("Computer wins!");
                }
                break;
            }
        }

        scanner.close();
    }

    private static void displayHeaps(int[] heaps) {
        System.out.print("Heaps: ");
        for (int i = 0; i < heaps.length; i++) {
            System.out.print("Heap " + (i + 1) + ": " + heaps[i] + "   ");
        }
        System.out.println();
    }

    private static boolean isPlayerTurn(int[] heaps) {
        for (int heap : heaps) {
            if (heap > 0) {
                return true; // Player's turn
            }
        }
        return false; // Computer's turn
    }

    private static int getPlayerMove(Scanner scanner) {
        int heapIndex;
        do {
            System.out.print("Enter the heap number (1, 2, or 3): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            heapIndex = scanner.nextInt();
        } while (heapIndex < 1 || heapIndex > 3);

        return heapIndex - 1; // Convert to array index
    }

    private static int getObjectsToRemove(Scanner scanner, int[] heaps, int heapIndex) {
        int maxObjects = heaps[heapIndex];
        int objectsToRemove;
        do {
            System.out.print("Enter the number of objects to remove (1-" + maxObjects + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            objectsToRemove = scanner.nextInt();
        } while (objectsToRemove < 1 || objectsToRemove > maxObjects);

        return objectsToRemove;
    }

    private static void computerPlay(int[] heaps, Random random) {
        int heapIndex;
        do {
            heapIndex = random.nextInt(heaps.length);
        } while (heaps[heapIndex] == 0);

        int objectsToRemove = random.nextInt(heaps[heapIndex]) + 1;

        System.out.println("Computer removes " + objectsToRemove + " objects from Heap " + (heapIndex + 1));

        heaps[heapIndex] -= objectsToRemove;
    }

    private static boolean isGameOver(int[] heaps) {
        for (int heap : heaps) {
            if (heap > 0) {
                return false; // Game not over
            }
        }
        return true; // All heaps are empty
    }
}
