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

            Scanner scanner = new Scanner(System.in);
            System.out.print("I have thought of a number; what is it? ");
            int guess = 0;

            while (true) {
                
                try {
                    guess = scanner.nextInt();
                }
                catch(InputMismatchException e) {
                    System.out.println("Please input a proper whole number ");
                }

                check(number, guess);

            }
            

        }

    }

    static int generate() {
        // generates and returns a random number
        double raw = Math.random() * 100;
        return (int)raw;

    }
    static void check(int number, int guess){
        if(guess == number){
            System.out.println("You got it right! ");
        }
        else if(guess > number) {
            System.out.println("Try lower! ");
        }
        else if(guess < number) {
            System.out.println("Try higher! ");
        }
    }
}