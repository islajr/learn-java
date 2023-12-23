import java.util.Scanner;

public class fizzbuzz {

    public static void main(String[] args) {
        // program to replicate the popular interview question, fizzbuzz
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.print("input a number ");
            int number = input.nextInt();

            if (number % 15 == 0) {
                System.out.println("FizzBuzz!");
            }
            else if (number % 3 == 0 && number % 5 != 0){
                System.out.println("Buzz!");
            }
            else if (number % 5 == 0 && number % 3 != 0){
                System.out.println("Fizz!");
            }
            else {
                System.out.println(number);
            }
        }    
    }
}