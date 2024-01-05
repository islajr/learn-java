import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        /* Program that effectively converts height from metre to ft and vice-versa */
        System.out.println("Height Converter");
        int response;
        while (true) {
            System.out.println("Follow the instructions below: ");
            System.out.println("(1) - cm to ft\n(2) - ft to cm.");
            Scanner scanner = new Scanner(System.in);
            response = scanner.nextInt();

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