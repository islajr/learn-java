import java.util.ArrayList;
import java.util.*;

public class collection {
    public static void main(String[] args) {
        // test program for collections and their methods.

        // iterator interface
//        Iterable <T> iterator();    - runs the iterator interface over elements of type T.
        Stack <Integer> integers = new Stack<>();
        for (int i = 1; i <= 10; ++i) {
            integers.push(i);
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}