import java.text.NumberFormat;
import java.util.Scanner;

public class mortgage {
    
    public static void main(String[] args){
        // program to calculate the mortgage payment
        Scanner input = new Scanner(System.in);
        int years, principal;
        double rate;

        while (true) {
            System.out.print("What is the Principal? ");
            principal = input.nextInt();

            if (principal < 10 || principal > 1000000) {
                System.out.println("input a value between %10 and $1,000,000");
                continue;
            } else {
                break;
            }
        }

        while(true) {
            System.out.print("At how much percent? ");
            rate = input.nextDouble();

            if (rate > 0 && rate <= 30) {
            rate = rate/100;
            rate = rate/12;
            break;

            } else {
                System.out.println("Input a value between 0 and 30. ");
                continue;
            }
        }

        while(true) {
            System.out.print("For how many years? ");
            years = input.nextInt();

            if (years >= 1 && years <= 30) {
                years = years * 12;
                break;
            } else {
                System.out.println("We do not support options above 30 years. ");
                continue;
            }
        
        }

        double bracket = Math.pow(1 + rate, years);
        double top = rate * bracket;
        double bottom = bracket - 1;

        double mortgage = principal * (top/bottom);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}