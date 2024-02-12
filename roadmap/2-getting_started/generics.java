import java.util.ArrayList;
import java.util.List;

public class generics {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(23);

        System.out.println(myList);
    }
}