import java.io.*;

class Demo implements Serializable {
    int a;
    String b;

    Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

public class serialization {
    public static void main(String[] args) {
        Demo file1 = new Demo(92, "Archer");
        String filename = "file.ser";

        // Serialization Process.
        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);

            output.writeObject(file1);

            output.close();
            outputStream.close();

            System.out.println("The object has been serialized. ");
        }
        catch (IOException io) {
            System.out.println("IOException has been caught");
        }

        // De-serialization Process
        Demo newDemo = null;
        try {
            FileInputStream fileInput = new FileInputStream(filename);
            ObjectInputStream input = new ObjectInputStream(fileInput);

            newDemo = (Demo) input.readObject();

            fileInput.close();
            input.close();

            System.out.println("a: " + newDemo.a);
            System.out.println("b: " + newDemo.b);

        }
        catch (IOException io) {
            System.out.println("IOException has been caught! ");
        }
        catch (ClassNotFoundException cl) {
            System.out.println("Please check your UID! ");
        }
    }
}
