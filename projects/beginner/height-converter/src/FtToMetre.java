import java.util.Scanner;
public class FtToMetre {

    static void convert() {
        String height = "nothing";      // pseudo-initialization
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your height in the format: f'i\". (e.g: 5'9\" ");

        height = scanner.nextLine();

        double one = height.charAt(0) * 30.48;
        double two = height.charAt(2) * 2.54;

        System.out.printf("You are %.1fcm tall. ", one + two);
        System.exit(0);

    }
}