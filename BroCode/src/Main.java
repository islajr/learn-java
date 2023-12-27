import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Press 'q' to quit. ");
        String quit = scanner.next();

        if (quit.equals("q") || quit.equals("Q")) {
            System.out.println("Alright, bye-bye!");
        }
        else {
            System.out.println("Please input a letter q!");
        }
    }
}