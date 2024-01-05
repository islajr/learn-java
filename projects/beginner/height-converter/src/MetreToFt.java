import java.util.Scanner;
public class MetreToFt {

    static void convert() {
        double height, raw;
        Scanner scanner = new Scanner(System.in);
        System.out.print("How tall are you? ");
        height = scanner.nextInt();
        raw = height/30.48;

        int feet = (int)(raw);
        double inches = Math.ceil((raw - feet) * 12);

        System.out.printf("You are %d'%.0f. ", feet, inches);
        System.exit(0);
    }
}