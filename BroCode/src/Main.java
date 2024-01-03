import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scanner.nextInt();

        System.out.print("Enter another number: ");
        int y = scanner.nextInt();

        try {
            System.out.printf("%.2f", (double)x/y);
        }
        catch (ArithmeticException e) {
            System.out.println("This will not work! ");
        }
        catch (InputMismatchException e) {
            System.out.println("Check your inputs! ");
        }
        }
    }
