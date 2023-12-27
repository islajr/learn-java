import java.util.Scanner;

public class Maths {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = input.nextDouble();

        System.out.print("Enter y: ");
        double y = input.nextDouble();

        double z = x*x + y*y;
        System.out.println(Math.sqrt(z));

        input.close();

    }
}

/* NOTES
 *
 *
 *
 * */