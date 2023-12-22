import java.text.NumberFormat;
import java.util.Scanner;

public class mortgage {
    
    public static void main(String[] args){
        // program to calculate the mortgage payment
        Scanner input = new Scanner(System.in);

        System.out.print("What is the Principal? ");
        int principal = input.nextInt();

        System.out.print("At how much percent? ");
        double rate = input.nextInt();
        rate = rate/12;

        System.out.print("For how many years? ");
        byte years = input.nextByte();

        double bracket = Math.pow(1 + rate, years);
        double top = rate * bracket;
        double bottom = bracket - 1;

        double mortgage = principal * (top/bottom);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}