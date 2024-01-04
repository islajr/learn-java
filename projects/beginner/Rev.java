import java.util.Scanner;

public class Rev{
    public static void main(String[] args){
        /* program to request a string from the user, reverse it and return it to the standard output. */
        Scanner scanner = new Scanner(System.in);

        System.out.print("give me a string and i will flip it: ");
        String input = scanner.nextLine();
        int length = input.length() - 1;

        while (length >= 0) {
            System.out.print(input.charAt(length));
            --length;
        }
        
        scanner.close();

    }
}