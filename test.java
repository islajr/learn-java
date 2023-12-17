import java.awt.;
import java.util.Arrays;

public class test {

    public static void main(String[] args){
        int[][] numbers = new int[2][3];
        String name = "Ronaldo";
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
 * a stark difference between value and reference types is that reference value types, when copied, are duplicated but reference types, in contrast, point to the value from which they were copied and as such, do not occupy a separate point in memory.
 * 
 * ARRAYS
 * arrays can either be 2-d or 3-d
 * they can be initialised in two ways: type[] variable_name = new type[length] or type[] variable = {value}
 * however, printing to standard output takes a turn as the array needs to be overloaded to a string with the Arrays,toString() method and as a result, the java.util.Arrays package needs to be imported.
 * arrays have other methods like .sort() that arranges the values in ascending order and .toDeepString() that overloads multi-dimensional arrays to strings and these methods are present in the java.util.Arrays package
 * 
 * STRINGS
 * strings are a very important reference type data type.
 * They are imported by default and can be used in the normal way inbuilt data-types are used.
 * String methods, however, are included in the java.awt.String package
 * 
 */