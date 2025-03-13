import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGame{
    public static void main(String[] args){
        /*
         *  program that randomly determines a number and prompts a user to guess. 
         * if correct, the program confirms it and if otherwise, the program gives
         * basic hints to that effect, i.e: hinting when to guess lower or higher.
         */

        while (true) {
            int number = generate();
            int difficulty;
            int guess;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I have thought of a number between 1 - 10\n");
            System.out.println("Please select the difficulty level:\n1. Easy (10 chances)\n2. Medium (5 chances)\n3. Hard (3 chances)");
            System.out.print("Enter your choice: ");

            while (true) {
                
                try {
                    difficulty = scanner.nextInt();
                    int chances = difficultyChoice(difficulty); 
                    int counter = chances;
                    boolean isCorrect;

                    while (counter > 0) {
                        System.out.println("Guesses left: " + counter);
                        System.out.print("Enter your guess: ");
                        try {
                            guess = scanner.nextInt();

                             isCorrect = check(number, guess, counter);
                            if (isCorrect) {
                                System.out.println("Congratulations! You guessed the correct numer in " + (chances - counter) + " attempts!");
                                scanner.close();
                                System.exit(0);
                            }
                            else if (!isCorrect && guess > number) {
                                System.out.println("Incorrect! The number is less than " + guess + ".\n");
                                System.out.println(number);
                                counter -= 1;
                            }
                            else if (!isCorrect && guess < number) {
                                System.out.println("Incorrect! The number is greater than " + guess + ".\n");
                                counter -= 1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(e);
                        }
                        
                        // counter -= 1;
                    }
                    if (counter <= 0) {
                        System.out.println("You've run out of guesses. Try again later!");
                        scanner.close();
                        System.exit(0);
                    }

                    
                }
                catch(InputMismatchException e) {
                    System.out.println("Please input a proper whole number ");
                    break;
                }

            }
        }

    }

    static int generate() {
        // generates and returns a random number
        double raw = Math.random() * 10;
        return (int)Math.round(raw);

    }
    private static boolean check(int number, int guess, int counter){

        if(guess == number && counter > 0){
            return true;
        }
        else if(guess > number || guess < number && counter > 0) {
            return false;
        }
        /* else if(guess < number) {
            return false;
        } */
        else {
            return false;
        }
    }

    static int difficultyChoice(int difficulty) {
        switch (difficulty) {
            case 1 -> {
                System.out.println("You have selected the Easy difficulty level.\nLet's start the game!");
                return 10;
            }

            case 2 -> {
                System.out.println("You have selected the Medium difficulty level.\nLet's start the game!");
                return 5;
            }
            case 3 -> {
                System.out.println("You have selected the Hard difficulty level.\nLet's start the game!");
                return 3;
            }
            default -> {
                return 0;
            }
        }
    }
}