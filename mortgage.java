import java.text.NumberFormat;
import java.util.Scanner;

public class mortgage {
    
    public static void main(String[] args){
        // program to calculate the mortgage payment
        Scanner input = new Scanner(System.in);

        System.out.print("What is the Principal? ");
        int principal = input.nextInt();

        System.out.print("At how much percent? ");
        double rate = input.nextDouble();
        rate = rate/100;
        rate = rate/12;

        System.out.print("For how many years? ");
        int years = input.nextInt();
        years = years * 12;

        double bracket = Math.pow(1 + rate, years);
        double top = rate * bracket;
        double bottom = bracket - 1;

        double mortgage = principal * (top/bottom);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}