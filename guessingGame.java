import java.util.Random;

class Player {
    // instance variables
    int number;

    // method for making a guess
    void guess() {
        Random generator = new Random();
        number = generator.nextInt(10);
    }
}

class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    // method where the entire game takes place
    void startGame() {
        // creating player objects
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        // randomly generate number
        int targetNumber = (int) (Math.random() * 10);
        System.out.println("I'm thinking of a number between 0 and 9");

        // main loop.

        while (true) {
            System.out.println("Said number is " + targetNumber);
            // request for the guesses and keep in mind that it is stored in player.number
            p1.guess();
            p2.guess();
            p3.guess();

            // Display guess
            System.out.println("Player one guessed " + p1.number);
            System.out.println("Player two guessed " + p2.number);
            System.out.println("Player three guessed " + p3.number);
            
            // checking for correctness
            String winner = "";
            if (p1.number == targetNumber) {
                p1isRight = true;
                winner = "Player one";
            }
            else if (p2.number == targetNumber) {
                p2isRight = true;
                winner = "Player two";
            }
            else if (p3.number == targetNumber) {
                p3isRight = true;
                winner = "Player three";
            }

            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner! ");
                System.out.println(winner + " got it right");
                System.out.println("Game Over!");
                break;
            }
            else {
                System.out.println("Nobody got it right! ");
                System.out.println("Try again? ");
            }
        }
    }
}

class GameLauncher {
    public static void main (String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}