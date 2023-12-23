import java.awt.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class test {

    public static void main(String[] args){
        boolean hasHighIncome = true;
        boolean hasGoodCredit = false;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasGoodCredit || hasHighIncome) && !hasCriminalRecord;

        if (isEligible)
            System.out.println("This is possible! ");
        
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
 * CONSTANTS
 * constants can be defined as follows: final data-type name = value. e.g: final float PI = 3.142;
 * 
 * TYPE CASTING AND CONVERSION
 * casting occurs from byte or int to float or double implicitly.
 * casting from double to int can be done explicitly with the int keyword. (int)value
 * conversion from string to integer (incompatible types) can occur with the Integer.parseInt() in the java.lang package.
 * Short.parseShort() takes in a short and returns a short. 
 * the same is present for float and double;
 * 
 * READING INPUT
 * input is read with the scanner class found in java.util.Scanner
 * see example: Scanner variable = new Scanner(system.in)   // to read data from the standard input
 *              int new_variable = variable.nextint();      // looking to store any integer value found in the standard input in the new_variable
 *              System.out.println("You are " + age);
 * .next - returns the next string
 * .nextLine - returns a string of the next line, whatever it is.
 * 
 * FORMATTING NUMBERS
 * Numbers can be formatted with the NumberFormat abstract class.
 * the appropriate abstract method .getPercentInstance(), .getCurrencyInstance() or other is called
 * after that, the .format method is chained to the expression with the value to be formatted as a parameter.
 * See Example: String result = NumberFormat.getPercentInstance.format(0.1);  // it is advisable to always make the type of this variable a string
 * 
 * TERNARY OPERATOR
 * ternary operators provide a way to simplify if-statements. 
 * they follow the syntax: condition ? expression1 : expression2
 * In other words, if the condtion returns true, expression1 is executed; else, expression2 is executed.
 * 
 * SWITCH-CASE 
 * this is another way to represent conditional information
 * it follows the syntax:
 *  switch(statement) {
 *      case 1:
 *          expression
 *          break;
 *      case 2:
 *          expression
 *          break;
 *      default:
 *          expression
 *  }
 * bear in mind that the break statement must always be included.
 * 
 * NOTES
 * what is the difference between ++x and x++
 * typically, they both do the same thing (increment a variable marginally) but the difference arises when assigning them to variables
 *  int x = 2;
 *  int y = ++x     // the value of x is incremented before it is assigned to y. (x, y = 3, 3)
 *  
 *  int x = 2;
 *  int y = x++;    // x is assigned to y before it is incremented. (x, y = 3, 2)
 */