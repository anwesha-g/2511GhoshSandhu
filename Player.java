import java.util.Scanner;

class Player {
    private String name;  //private instance variable stores the player's name

    //constructor to initialize the player'sname
    public Player(String name) {
        this.name = name;
    }

    //getter method to retrieve the player's name
    public String getName() {
        return name;
    }
}
