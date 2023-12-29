import java.awt.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class test {

    public static void main(String[] args){
        String[] fruits = {"Apples", "Oranges", "Mangoes", "Crayons"};

        for (String fruit: fruits)
            System.out.println(fruit);
        
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
 * It is good practice to always close the instance of the scanner class after use with the instance.close() method.
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
 * DO-WHILE LOOP
 * this is a loop that must run at least, once before the condition is checked.
 * it has the syntax:
 * do {
 *  expressions
 * } while (statement);
 * 
 * FOR-EACH LOOP
 * This is one that is popular in javascript.
 * it presents an easier and quicker way to iterate through iterables
 * it has syntax resembling that of a conventional 'for loop' but the statement is different
 * the syntax is as follows: for (type variable : iterable) {}
 * the logic here is that the variable initialised in the loop serves as the iterator and typically, it is a string
 *
 * TYPICAL PROBLEMS WITH SCANNER CLASS
 * When using the scanner class to request for input, it is imperative to note that after using the .nextInt() method,
 * a new line (\n) character is left behind in the stream and as such, if it is followed by a .nextLine(), it will
 * entirely skip without requesting the input at all!
 * In order to fix this, the stream has to be flushed with a bare *inputVariable*.nextLine() before the main one.
 * This problem occurs when we try to use .nextLine() after any method that is not .nextLine().
 *
 * WRAPPER CLASSES
 * These are classes that provide a way to use primitive data types as reference data types.
 * this uses the principle of autoboxing - automatic conversion of primitive types into reference types.
 * for knowledge, 'unboxing' is the opposite of autoboxing and it is the conversion of reference types into primitive types.
 *
 * autoboxing can be achieved by capitalizing the first letter of the data type declaration and
 * using them as you would use a primitive data type.
 *
 * See Example:
 * PRIMITIVE        REFERENCE
 * int              Int         Int age = 92
 * char             Char        Char at = "@"
 * boolean          Boolean     Boolean yes = true
 * double           Double      Double pi = 3.14
 *
 * why anyone would like to do this, i do not know as of yet
 *
 * ARRAY LISTS
 * This is a reference data-type that is resizable, i.e: elements can be added to and removed from them
 * they also store only reference data types so this creates a use for wrapper classes.
 * they are contained in the java.util package.
 *
 * they can be used as follows:
 * ArrayList<Int> numbers = new ArrayList<Int>();
 * numbers.add() adds elements to the array.
 * numbers.get(index) displays an element from the array - it takes the index number as an argument
 * numbers.set(index, value) - sets or edits the value of the array at a specified index.
 * numbers.remove(index) - removes whatever element is contained in the specified index
 * numbers.clear() - clears all elements from the array.
 *
 * These Arraylists can be nested into one another to create a 2d-list or a list of lists.
 * the only tricky bit is that when declaring the container list, the type specification must include
 * everything, i.e: ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
 * internal lists can be indexed with the .get method and this can also be chained, one to another to
 * produce more specific results.
 *
 * when looping through an array list, we use variable.size() as opposed to variable.length()
 *
 * FUNCTIONS IN JAVA (METHODS)
 * In a way, functions are always methods in java since everything is always inside of a class.
 * to define a function, you need to step out of the main method, preferably under it.]
 * definition of functions in java follows a specific syntax:
 * return-type name(parameters) {
 *      whatever the fuck you want.
 * }
 *
 * typically, since the main method is almost always static, we need to make whatever function we're defining
 * static too.
 * so before the return-type, we need to insert the keyword, 'static'.
 *
 * METHOD OVERLOADING
 * This is a phenomenon where two methods share the same name but have different parameters and as a result, different
 * signatures.
 *
 * a typical example of this is in OOP where depending on the return value and use case, two or three methods can share
 * names. (Operaator Overloading)
 *
 * it is also note-worthy that changing the return-type and keeping the name without altering the parameters will
 * lead to a compile-time error.
 *
 * NOTES
 * what is the difference between ++x and x++
 * typically, they both do the same thing (increment a variable marginally) but the difference arises when assigning them to variables
 *  int x = 2;
 *  int y = ++x     // the value of x is incremented before it is assigned to y. (x, y = 3, 3)
 *  
 *  int x = 2;
 *  int y = x++;    // x is assigned to y before it is incremented. (x, y = 3, 2)
 *
 * INDEXING FOR STRINGS AND ARRAYS
 * The typical method of indexing with square brackets does not work with strings in java.
 * to index strings in java, the string.charAt() method is used and it takes in an index number to return the character at that index.
 * However, arrays can be indexed with the [] notation as normal.
 *
 */