import java.util.ArrayList;
import java.util.*;

public class collection {
    public static void main(String[] args) {
        // test program for collections and their methods.

        // iterator interface
//        Iterable <T> iterator();    - runs the iterator interface over elements of type T.
        List <Integer> ages = new ArrayList<>();

        ages.add(18);
        ages.add(21);
        ages.add(28);

        Iterator <Integer> iter = ages.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}