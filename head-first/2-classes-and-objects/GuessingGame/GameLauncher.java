import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        // Game Starts here
        int targetNumber = (int) (Math.random() * 10);
        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        System.out.println("I am thinking of a number. ");
        System.out.println("Player 1, what do you think it is? ");
        player1.guess = scanner.nextInt();

        System.out.println("I am thinking of a number. ");
        System.out.println("Player 2, what do you think it is? ");
        player2.guess = scanner.nextInt();

        System.out.println("I am thinking of a number. ");
        System.out.println("Player 3, what do you think it is? ");
        player3.guess = scanner.nextInt();

        // checking for correctness

        if (player1.guess == targetNumber) {
            System.out.println("Player 1 guessed right! ");
        }
        if (player2.guess == targetNumber) {
            System.out.println("Player 2 guessed right! ");
        }
        if (player3.guess == targetNumber) {
            System.out.println("Player 3 guessed right! ");
        }



    }
}
