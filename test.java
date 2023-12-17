import java.awt.*;
import java.util.Arrays;

public class test {

    public static void main(String[] args){
        int[][] numbers = new int[2][3];
        numbers[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers));
    }
}

/* Java notes */
/* 
 * INTRO
 * In order to use a package, it has to be imported.
 * java.util.Arrays is a package that takes care of arrays
 * the String package is imported by default
 * 
 * DATA TYPES
 * there are two types of data types: value types (built-ins) and reference types.
 * any data type except int, float, double, short, long, bool, byte or char is a reference type data type and as such is not "built-in"
 * 
 */