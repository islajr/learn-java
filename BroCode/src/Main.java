import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("poem.txt");
            writer.write("I am isla; I am him.\n Isla Archer! ");
            writer.append("nobody comes close!");
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        }
    }
