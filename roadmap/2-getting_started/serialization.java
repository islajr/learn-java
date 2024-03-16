import java.io.*;

class Test implements Serializable {
    private static final long serialUID = 1234567890L;

    transient int a;
    static int b;
    String name;
    int age;

    // constructor
    Test(int a, int b, String name, int age) {
        this.a = a;
        Test.b = b;
        this.name = name;
        this.age = age;
    }
}

public class serialization {

    static void printData(Test sample) {
        System.out.println("a: " + sample.a);
        System.out.println("b: " + Test.b);
        System.out.println("name: " + sample.name);
        System.out.println("age: " + sample.age);
    }

    public static void main(String[] args) {
        Test first = new Test(1, 2, "Archer", 20);
        String filename = "mine.txt";

        try {
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(first);

        System.out.println("After Serialization...");
        printData(first);

        Test.b = 20;

        file.close();
        out.close();
        }
        catch (IOException io) {
            System.out.println("IOException caught. ");
        }

        // de-serialization
        first = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            first = (Test) in.readObject();

            System.out.println("After de-serialization...");
            printData(first);

            file.close();
            in.close();
        }
        catch (IOException io) {
            System.out.println("IOException caught. ");
        }
        catch (ClassNotFoundException cl) {
            System.out.println("Check your UID! ");
        }

    }
}