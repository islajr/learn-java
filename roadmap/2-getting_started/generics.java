import java.util.ArrayList;
import java.util.List;

public class generics {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 1.2, 1.3, 1.4, 1.5};
        Character[] charArray = {'a', 'b', 'c', 'd', 'e'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }

    // Example of a generic method
    public static < E > void printArray (E[] inputArray) {
        // method to display an array's elements.
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}