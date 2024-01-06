import java.util.InputMismatchException;
import java.util.Scanner;
public class MetreToFt {

    static void convert() {
        double height = 0;
        double raw;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Height (cm):  ");

        try {
            height = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("That is not valid. ");
//            System.exit(0);
            MetreToFt.convert();
        }
        raw = height/30.48;

        int feet = (int)(raw);
        double inches = Math.ceil((raw - feet) * 12);

        System.out.printf("You are %d'%.0f\". ", feet, inches);
        System.exit(0);
    }
}