import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("How old are you? ");
        int age = input.nextInt();

        // clearing the stream
        input.nextLine();
        System.out.print("What is your best food? ");
        String food = input.nextLine();

        System.out.println("Your name is " + name);
        System.out.println("You are " + age + " years old.");
        System.out.println("Your favourite food is " + food);
    }
}

/* NOTES
* When using the scanner class to request for input, it is imperative to note that after using the .nextInt() method,
* a new line (\n) character is left behind in the stream and as such, if it is followed by a .nextLine(), it will
* entirely skip without requesting the input at all!
* In order to fix this, the stream has to be flushed with a bare *inputVariable*.nextLine() before the main one.
* */