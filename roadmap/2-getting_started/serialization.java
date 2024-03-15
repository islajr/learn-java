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

        Demo newDemo = new Demo(92, "Archer");
        String filename = "file.ser";

        // Serialization Process
        try {
            FileOutputStream file = new FileOutputStream(filename); // first conversion step
            ObjectOutputStream out = new ObjectOutputStream(file);  // final conversion step

            out.writeObject(newDemo);   // method for serialization

            out.close();
            file.close();   // courtesy closing.

            System.out.println("Object has been serialized.");
        }
        catch (IOException ex) {
            System.out.println("Caught IOException. ");
        }

        // de-serialization process
        Demo second = null; // creating an instance for use in the try block
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            second = (Demo)in.readObject(); // method for de-serialization.

            in.close();
            file.close();

            System.out.println("Object has been de-serialized");
            System.out.println("a = " + second.a + ". ");
            System.out.println("b = " + second.b + ". ");
        }
        catch(IOException io) {
            System.out.println("Check your Serialization method. ");
        }
        catch(ClassNotFoundException cl) {
            System.out.println("There is a problem with the UID. ");
        }
    }
}