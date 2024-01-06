import java.util.InputMismatchException;
import java.util.Scanner;
public class FtToMetre {

    static void convert() {
        double height;
        double feet = 0;
        double inches = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ft: ");

        try {
            feet = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("That is not valid. ");
            FtToMetre.convert();
        }

        System.out.print("Inches: ");

        try {
            inches = scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("That is not valid. ");
            FtToMetre.convert();
        }

        feet = feet * 30.48;
        inches = inches * 2.54;
        height = feet + inches;


        System.out.printf("You are %.1fcm tall. ", height);
        System.exit(0);

    }
}