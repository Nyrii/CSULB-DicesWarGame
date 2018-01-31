import java.util.Scanner;

public class Game {

    private Entity player;
    private Entity computer;
    private int    gamesNumber;

    public Game() {
        this.player = new Entity();
        this.computer = new Entity();
        this.gamesNumber = 0;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("1 - Play the dice war game");
        System.out.println("2 - Display statistics");
        System.out.println("3 - Exit the game");
        String line = scanner.next();

        try {
            choice = Integer.parseInt(line);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Sorry, your request has not been understood.");
            this.displayMenu();
        }

        switch (choice) {
            case 1:
                this.play();
                break;
            case 2:
                System.out.println("Number of played games : " + this.gamesNumber);
                System.out.println("The player won " + this.player.getWonGames() + " game(s).");
                System.out.println("The AI won " + this.computer.getWonGames() + " game(s).");
                this.displayMenu();
                break;
            case 3:
                return;
            default:
                System.out.println("Sorry, your request has not been understood.");
                this.displayMenu();
                break;
        }
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to play ? [yes/no]");
        String line = scanner.nextLine();

        if (line.toLowerCase().equals("yes")) {
            this.play();
        } else if (line.toLowerCase().equals("no")) {
            System.out.println("Goodbye !");
            this.displayMenu();
            return;
        } else {
            System.out.println("Sorry, your request has not been understood.");
            this.init();
        }
    }

    public void play() {
        int playerValue = 0;
        int computerValue = 0;
        this.player.rollDice();
        this.computer.rollDice();

        System.out.print("Player has drawn : (");
        for (int i = 0 ; i < this.player.getDices().length; i++) {
            playerValue += this.player.getDices()[i].getValue();
            System.out.print(this.player.getDices()[i].getValue());
            if (i + 1 < this.player.getDices().length) {
                System.out.print(", ");
            }
        }
        System.out.println(") = " + playerValue);


        System.out.print("Computer has drawn : (");
        for (int i = 0 ; i < this.computer.getDices().length; i++) {
            computerValue += this.computer.getDices()[i].getValue();
            System.out.print(this.computer.getDices()[i].getValue());
            if (i + 1 < this.computer.getDices().length) {
                System.out.print(", ");
            }
        }
        System.out.println(") = " + computerValue);

        if (playerValue < computerValue) {
            this.computer.gameWon();
            System.out.println("Computer WON.");
        } else if (playerValue > computerValue) {
            this.player.gameWon();
            System.out.println("Player WON.");
        } else {
            System.out.println("This is a TIE.");
        }

        this.gamesNumber += 1;

        this.init();
    }

}
