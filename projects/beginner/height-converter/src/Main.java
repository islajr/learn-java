import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        /* Program that effectively converts height from metre to ft and vice-versa */
        System.out.println("Height Converter");
        int response = 0;   // random initialization to get the program to run.
        while (true) {
            System.out.println("Follow the instructions below: ");
            System.out.println("(1) - cm to ft\n(2) - ft to cm.");
            Scanner scanner = new Scanner(System.in);

            try {
                response = scanner.nextInt();
            }
            catch(NoSuchElementException e) {
                System.out.println("That was not a valid response. ");
                break;
            }
            catch (Exception e) {
                System.out.println("Something went wrong. ");
                break;
            }

            switch (response) {
                case 1:
                    MetreToFt.convert();
                    break;

                case 2:
                    break;

                default:
                    scanner.close();
                    break;

            }


        }
    }
}