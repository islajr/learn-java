import java.util.Scanner;
public class FtToMetre {

    static void convert() {
        double height;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ft: ");
        double feet = scanner.nextInt();

        System.out.print("Inches: ");
        double inches = scanner.nextDouble();

        feet = feet * 30.48;
        inches = inches * 2.54;
        height = feet + inches;


        System.out.printf("You are %.1fcm tall. ", height);
        System.exit(0);

    }
}