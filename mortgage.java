import java.util.Scanner;

public class mortgage {
    
    public static void main(String[] args){
        // program to calculate the mortgage payment
        Scanner input = new Scanner(System.in);

        System.out.print("What is the Principal? ");
        byte principal = input.nextByte();

        System.out.print("At how much percent? ");
        int rate = input.nextInt();
        rate = rate/12;

        System.out.print("For how many years? ");
        byte years = input.nextByte();

        double bracket = Math.pow(1 + rate, years);
        double top = rate * bracket;
        double bottom = bracket - 1;

        double mortgage = principal * (top/bottom);

        System.out.println("Mortgage: " + mortgage);
    }
}