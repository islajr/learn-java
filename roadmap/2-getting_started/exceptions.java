import java.util.InputMismatchException;
import java.util.Scanner;

public class exceptions {
    public static void main(String[] args) {
        // program to test exception handling

        Scanner scanner = new Scanner(System.in);
        System.out.print("How old are you? ");
        int age = 0;

        try {
            age = scanner.nextInt();
        }
        catch (InputMismatchException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.toString());
//            e.printStackTrace();
            System.out.println("This is not a valid input. ");
            scanner.close();
            System.exit(1);
        }
        finally {
            System.out.println("You are " + age + " years old.");
        }


    }
}