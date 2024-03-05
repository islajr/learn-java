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
        boolean player1isRight = false;
        boolean player2isRight = false;
        boolean player3isRight = false;

        if (player1.guess == targetNumber) {
            player1isRight = true;
            System.out.println("Player 1 guessed right! ");
        }
        if (player2.guess == targetNumber) {
            player2isRight = true;
            System.out.println("Player 2 guessed right! ");
        }
        if (player3.guess == targetNumber) {
            player3isRight = true;
            System.out.println("Player 3 guessed right! ");
        }



    }
}
