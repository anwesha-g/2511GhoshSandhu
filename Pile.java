import java.util.Random;

class Pile {
    private int size;  // private instance variable stores the size of the pile

    // constructor initialize the pile w/ random size
    public Pile() {
        generateRandomSize();
    }

    // getter method to retrieve the current size of the pile
    public int getSize() {
        return size;
    }

    // setter method to update the size of the pile
    public void setSize(int newSize) {
        size = newSize;
    }

    // private method to generate a random size for the pile
    private void generateRandomSize() {
        Random random = new Random();
        // random size between 10 and 50 that is inclusive
        size = random.nextInt(41) + 10;
    }
}
