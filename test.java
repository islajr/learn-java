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
 * CONSTRUCTOR OVERLOADING
 * This is a concept similar to that of operator and method overloading where two constructors can have the
 * same name but different parameters in order to have different signatures.
 *
 * An important use case of this is when defining a constructor that can take in optional arguments.
 *
 * TO STRING()
 * This is a special method that all objects import that prints a textual representation of an object.
 * Note that this effect can be obtained either implicitly or explicitly
 *
 * Doing this explicitly is the conventional way as the stock .toString() method only returns the memory
 * address of the given object.
 *
 * To combat this, a technique known as METHOD OVERLOADING is used.
 * Here, a default method is re-defined in the context of a specific class to do something different from
 * what the language set it up to do.
 *
 * All of this, however, is just semantics as the main point to this is to define the default method in the
 * target class with the exact same name and the body of the method should contain procedural information as to
 * what it is supposed to do.
 *
 * Implicit use of the .toString() method occurs when the object of the class is called within a 'print' statement.
 *
 * OBJECT ARRAY
 * since arrays can hold elements as long as they are within the set limit and have the specified type, it
 * is also possible to define arrays that can hold objects as elements.
 *
 * it may sound bizarre but it is actually quite easy.
 * class-name[] variable-name = new class-name[length]
 *
 * STATIC KEYWORD
 * The static keyword is a modifier that indicates that the variable or method which it points to belongs to
 * the parent class and as such, need to be instantiated for it to be used.
 *
 * ABSTRACT KEYWORD
 * Any class declared as 'abstract', as a security measure, cannot be instantiated.
 * This used when defining a class that by itself, is too vague to have meaning but comes into life when
 * specific features are being focused on.
 * This means that abstract classes are only used as a container to hold more useful, specific classes.
 *
 * An example might be a 'vehicle'. It is an abstract word that can refer to anything from a bicycle to an airplane.
 * Trying to create an instance of a vehicle is useless cos it has no specific meaning or use.
 * However, a car is a type of vehicle with a real world use and as such, is a sub-class of vehicle.
 *
 * You can also have abstract methods - methods without a body.
 * At first glance, it seems useless but it forces the programmer to override such a method in one of the child
 * classes for it have a more specific meaning, hereby tying in with the 'abstract' idea.
 *
 * ACCESS MODIFIERS: PRIVATE, PUBLIC, PROTECTED
 * This is a concept that adds security to the class which it points to.
 * In a case where there is no access modifier included, the default modifier is used and it grants access
 * only within a class and a package; anything outside of this is not recognized.
 *
 * with the modifier, public, the class, package, subclass and anything else has access.    EVERYTHING
 * with the modifier, protected, the class, package and subclass have access. no one else does.
 * with the modifier, private, only the class has access. nothing else does.    CLASS
 *
 * in order of increasing protection, access levels are as follows: public, protected, default, private,
 * with private being the highest level of protection available.
 *
 * import statements do not affect the visibility of these access modifiers.
 *
 * INHERITANCE
 * This is a process where a class (child) acquires the attributes and methods of another class (parent) in
 * addition to its own.
 *
 * This is done with the keyword 'extends'.
 * See example:
 * public class *child* extends *parent* {}
 *
 * SUPER KEYWORD
 * Building on the inheritance note, the "super" keyword comes into play when defining context in constructors.
 * usually, the "this" keyword tells the compiler that you are referring to a variable present in the current class
 * However, the "super" keyword tells the compiler that you wish to deal with the super (parent) class.
 *
 * See Example:
 * String instanceVariable;
 *
 * Constructor(...) {
 *  super(parent variables);
 *  ...
 * }
 *
 * the super ting there simply tells the compiler to look for those variables in constructor of the super class.
 * 
 *
 * METHOD OVERRIDING / OVERLOADING
 * This is the process of declaring the same method in two different classes, usually a parent and child with
 * the original method present in the parent class, overriding would be declaring a similarly-named method
 * to the child class in order for the child class to have a different or more specific implementation of
 * the class.
 *
 * When overriding a method, it is good method to preface it with the @override identifier to hint
 * anyone reading the code in the future of your intentions.
 *
 * Also, since the static variable/method is shared by all members of the class, there can only be one copy
 * of that variable within the class.
 *
 * it may also be worth noting that static methods can be referenced in a non-static way, i.e: with instances
 * but this is not recommended.
 *
 * ENCAPSULATION
 * Building on the concept of security, when dealing with private classes that can only be seen and used
 * within the same file, it creates a problem of compartmentalization and reusability where we are unable to
 * use private classes in other parts of our code.
 *
 * This can easily be solved by encapsulation.
 * This provides a way to use and change private methods without relating with them directly through the use of
 * setters and getters.
 *
 * Setters and getters are usually defined in the class with a public modifier.
 * Getters help fetch variables or methods in a private class while setters help change or create new methods.
 *
 * An example would be:
 * public class Whatever {
 *  private String name = "name"
 *
 *  // getter
 *  public getName() {
 *      return name;
 *  }
 *
 *  // setter
 *  public setName(String new) {
 *      name = new;
 *  }
 * }
 *
 * POLYMORPHISM
 * This is the ability of an object to identify as more than one type.
 * In other words, an object displaying polymorphism can take in more than one type.
 * This is shown in the principle of inheritance where a sub class identifies as both a member of its class
 * and that of its super class.
 * This creates a scenario where the super class can be used as a container for all of its sub classes and
 * methods belonging to the super class can be used by any of it's subclasses and can even be overriden, despite
 * them not owning it directly.
 *
 * DYNAMIC POLYMORPHISM
 * is simply polymorphism after the fact. In other words, it is polymorphism occuring during runtime.
 * The object change and adjust based on the requirements of the program to work seamlessly, hence the 'dynamic'.
 *
 * A use case of this is when defining an onject and you do not know, beforehand, what sort of object it is
 * going to be.
 * A good example, which is also present in this commit can be established by employing the principle of inheritance.
 * A subclass is a type of its class, it's super class and the Object type and as such, can be used to initialize
 * any variable of that type.
 *
 * This information can be used to create a scenario where a program is expecting user input and depending on the type
 * of input received, the type of a object in use responds differently.
 *
 * INTERFACES
 * An interface is a blueprint for a class.
 * It works in the same way as abstract classes but the difference lies in that interfaces can be implemented
 * across various classes, meanwhile, a class can only have one 'super'.
 *
 * In other words, a class can implement more than one interface, while it can only have one super class.
 *
 * Interfaces are defined in their own separate class in the following way:
 * modifier interface name{
 *      *method*
 *      usually do not contain a body as it is only a blueprint.
 *      each implementing class overrides this as it sees fit.
 * }
 *
 * defined interfaces can be used in classes with the 'implement' keyword as in:
 * modifier class implements interface{}
 *
 * EXCEPTION HANDLING
 * Exceptions are events that disrupts a program's execution. They are also called errors.
 * exceptions can be predicted and therefore handled in a way that they do not cause a program
 * to break down and this is called 'Exception Handling'.
 *
 * There are different types of exceptions and they can be handled with a try-catch block to catch those exceptions.
 * See below:
 * try {
 *      piece of unsafe code
 * }
 * catch(exceptionType variable) {
 *      expression to be carried out upon exception.
 * }
 * finally {
 *      this block will always run whether you catch an exception or not.
 *      a use case for this could be to close any open scanners and free up memory.
 * }
 *
 * FILE HANDLING
 * This is done with the java.io.file class and a common use case us to check if a file exists in a directory.
 * See example below:
 * File file = new File("file name");
 * if(file.exists()) {
 *      do whatever
 * }
 * else {
 *      do whatever
 * }
 * not specifying any path causes the compiler to look for this file in the project directory
 * this behaviour can easily be applied to any other folder by preceding it with the required path.
 *
 * some other useful file methods:
 * file.getPath() - returns the pathname argument passed upon instantialization
 * file.getAbsolutePath - returns the complete path to the file.
 * file.delete() - deletes specified file.
 *
 * FILE WRITER CLASS
 * This is a class created to help to write to a file
 * it is contained in the java.io.FileWriter
 *
 * typically, to use this class, you should invoke some sort of error handling after instantialization.
 * some useful methods of this class are as follows:
 * .write() - takes in a string message and writes it to a file
 * .append() - adds to a current
 *
 * file writers should also be closed after use to free up memory with the .close() method.
 *
 * FILE READER
 * This allows us to read the contents of a file as a character stream.
 * .read() returns an int value that contains the byte value.
 * whenever .read() returns -1, there is no more data to be read.
 *
 * The returning int of the .read(method) can be projected on to the standard output via a while loop but has
 * to be converted into a character value for it to make sense.
 *
 * while (int != -1) {
 *     print((char) int);
 * }
 * reader.close();
 *
 * As usual, this has to be wrapped in a try-catch block which can be generated automatically with the catch block
 * containing directives to print the stack trace of the error.
 *
 * GRAPHICAL USER INTERFACE
 * JFRAME
 * is a class from the java swing framework that creates a window frame to add components to.
 * In order to use this, the import.javax.swing.Jframe import statement must be utilized.
 * 
 * After creating an instance of a frame, it won't be visible until the .setVisible() method is set to 'true'.
 * To change the size of the frame, the .setSize() method is used.
 * It has variations that take in either an x, y value or a raw value.
 * .setTitle() names the jframe after whatever is passed into it.
 *
 * Also, the close button does not actually close the frame; it hides it by default.
 * To correct this setting, the .setDefaultCloseOperation() method must be set to Jframe.EXIT_ON_CLOSE, which also has the value of 3.
 * In other words, the argument for the aforementioned can simply be set to 3 to achieve the same effect.
 *
 * .setResizable() - controls whether the frame can be resized.
 * .setIconImage() - takes in a method of an imageicon instance for use as the image's icon.
 * .setBackgroundColor() - changes the default background color of a content pane.
 * .getContentPane().setBackgroundColor() - is the typical way to change the background color as the .setBackgroundColor() needs to be chained to the content pane either directly or indirectly.
 * .setLocationRelativeTo(null) - sets the frame directly in the center of the screen.
 * 
 * It takes in an instance of the java.awt.Color class that must also be imported.
 * New colors can also be created within the argument parenthesis with the new Color() command.
 *
 * frames can be closed automatically with the JFrame.dispose() method.
 *
 * JLABEL
 * Is a componen of a jframe that displays things like texts and images. It is a class contained in the javax.swing package.
 * It can be added to the frame with the Jframe.add() method.
 * .setText() - takes in a string of text that is displayed in the frame.
 * .setIcon() - takes in an image icon instance and displays it in the frame.
 *
 * Typically, java swing tends to display texts to the right of images but this behaviour can, of course, be altered!
 * .setHorizontalTextPosition() - takes in a jlable.left, right, or center method that aligns text to the specified direction.
 * .setVerticalTextPosition() - takes in a jlabel.top, center or bottom method that aligns text to the specified direction.
 * .setForegroundColor() -  can change the color of text with the Color class as an argument.
 * .setBackgroundColor() - can change the background color of the label to the specified instance of the color class.
 * However, this will not take effect unless followed up with the .setOpaque() method that takes in a boolean value.
 * .setFont() - takes in an instance of the font class with the name, type and size of the font as arguments.
 * .setIconTextGap() - takes in an integer that can alter the padding between text and image.
 * .setVerticalalignment(JLabel.top, center or bottom) - sets the vertical position of text + icon within a label
 * .setHorizontalAlignment(JLabel.left, center, right) - sets the horizontal position of text + icon within a label
 * .getX() - provides the horizontal position of the label within the context of the frame.
 * .getY() - provides the vertical position of the label within the context of the frame.
 *
 * Borders can be set with the Border class
 * Border border = BorderFactory.createLineBorder(color, thickness);
 * Labels like to take up as much room as possible but that becomes a problem when creating a program with multiple labels.
 * This behaviour occurs as a result of the default layout being used.
 * To correct this, the frame layout has to be reset with frame.setLayout(null);
 * Then new bounds for the label should be specified with label.setBounds(xposition, yposition, xwidth, ywidth);
 *
 * JFRAME.pack() - adjusts the frame to accordingly to accomodate whatever is inside of a label.
 * JFrame.add() - can take in positions alongside a component, specifying where within the frame the component will stay.
 *
 * JPANEL
 * Similar to Labels, panels are also frame components but they serve mainly as a container for other components.
 * Think of it as a 'div' tag.
 * Their methods work in the same way the frame and label methods work.
 *
 * Since panels serve as containers, they can hold almost anything as long as the dimensions and layout are suitable.
 * They can hold even labels. i.e: labels can be fit into panels, which in turn can be added to the frame.
 *
 * .setPreferredSize(dimension) - takes in a dimension class that takes in width and height arguments.
 *
 * interestingly, panels can also contain other panels. (see code in Layout.java)
 *
 * LAYOUTS
 * Layouts refer to the structure of a component.
 * As mentioned earlier, the default layout of a frame is the border layout.
 * There are other types, namely: box, spring, overlay, flow, etc; and they differ from each other based on the arrangement of elements.
 * Border - by default aligns elements to the left from top to bottom in a vertical manner (stacking)
 * Flow - by default aligns elements to the center of the top from left to right in a horizontal manner. (used by panels)
 *
 * in cases where yuo are not using a layout manager, you can manually set the bounds for the component with the .setBounds() method
 * and spring will position the relative to the container it is in.
 *
 * BORDER LAYOUT
 * Is a layout designed to place elements in one of five major areas: north, south, east, west, center.
 * Whatever is put in the center expands and contracts relative to the size and proportion of the frame.
 * top and bottom components respond to horizontal changes.
 * east and west components respond to vertical changes.
 * when setting a border layout for a frame, it is possible to add margins between horizontal and vertical components.
 * this is done by passing the required pixels for width and height accordingly as arguments.
 *
 * FLOW LAYOUT
 * places components horizontally in a row from left to right, relative to the dimension of the frame.
 * if the row gets too small, or too tight, the components overflowing move to the next row automatically.
 * by default, components are aligned to the center but this can be changed with the .setHorizontalAlignment() method.
 * alignment can be to the left, right, center, leading (extreme left) or trailing (extreme right).
 *
 * when creating an instance of a flow layout, arguments for alignment, hgap and vgap can be passed in that order.
 *
 * GRID LAYOUT
 * places components in a 'grid of cells', i.e: each cell is the same size and each component takes up all available
 * space within its cell
 * when defining a grid layout, arguments for rows and columns (in that order) can be passed and no matter how small
 * the frame gets, this rule is always obeyed, even at the expense of reducing the size of each individual cell.
 * horizontal and vertical spacing between cells can also be set after the rows and columns arguments.
 *
 * JBUTTON
 * a jbutton is java is a gui component that functions as a button.
 * it can do anything from displaying content to update website and web servers.
 * Buttons are usually associated with an event. i.e: when you push a button, you expect something to happen.
 * In order to recreate this, action listeners are used.
 *
 * A button is defined in java via the JButton class from the javax.swing package.
 * it is defined and initialized the same way as any object type.
 * when initializing a button instance, some text you want the button to bear may be passed as string arguments.
 * since buttons are also customizable components, it is logical for them to have bounds.
 * and as usual, button bounds take in x-position, y-position, width and height attributes.
 *
 * the twist comes in when you try to make the button 'do something'.
 * for a button to 'do something' you have to make the button listen for an event that will trigger the action.
 * such event may be a click, a hover or even a specific key combination.
 * you can achieve this with the Action Listener interface in the java.awt.event.ActionListener class.
 * this class is attached to the button instance by some sort of callback function (see Main.java in this commit)
 * but the easy way to do this is to usee an anonymous function.
 * An anonymous function is usually a one-liner function, similar to javascript arrow functions.
 * it takes the syntax: instance.method(variable -> expression);
 *
 * --- new ---
 * to add an action to a button, the ActionListener interface needs to be imported and implemented by the class.
 * to make it work, the actionPerformed method must be overridden within the class with an ActionEvent argument passed in.
 * inside of the actionPerformed method, a condition for a button click must be inserted and it is usually (ActionEvent.getSource() == button).
 * in other words, if the source of the trigger is the specified button, carry out a specific order.
 *
 * while all of this is good, it means nothing if the button is not listening for clicks to trigger the event.
 * as such, an actionListener needs to be added to the button with the .addActionListener(this) method with the 'this' passed as an argument.
 * this means that a trigger listener is added to 'THIS' particular button.
 *
 * this can be a way to make the button do whatever is in the expression part of the line.
 *
 * .setText("string") takes in a text display label for the button.
 * .setFocusable(boolean) controls whether the button is in focus or not.
 * the icon of the button can be set with the .setIcon(imageIcon) method.
 * .setFont(new Font("Hack", style, size)) helps in adjusting the font
 * .setIconTextGap() adjusts the distance between the icon and the text.
 * .setForeground(color) - adjusts text colour
 * .setBackground(color) - adjusts the background colour of a button.
 * .setBorder(BorderFactory.createWhateverBorder) helps you add a border to your button
 * .setEnables(boolean) - enables or disables a button.
 *
 * JLAYEREDPANE
 * is a swing container that provides a third dimension for positioning components.
 * quite similar to the jpanel, it can hold 2D components but unlike the JPanel, it accepts a 3D argument.
 * in a layered pane, the first added component is fitted on top and the rest are arranged below it in an orderly fashion.
 * this order can be altered.
 * there are names for each layer in order of appearance and stacking: default, palette, modal, popup, drag, with
 * default being the bottom layer and drag being the top-most layer.
 * to alter the default stacking process, when adding a component to a layeredpane, the desired layer should be added as an extra argument.
 * i.e: JLayeredPane.add(JPanel, JLayeredPane.DEFAULT_LAYER);
 *
 * it is challenging to master the various layer names and their order and as thus, integer wrapper classes can be used
 * to represent each layer.
 * in other words, instead of JLayeredPane.DEFAULT_LAYER, an integer wrapper class can be used. Integer.valueOf(number);
 *
 * is a standard dialog pop-up box that serves as a prompt for a user.
 * JOPTIONPANE
 * it is contained in the java.swing.JOptionPane class and this needs to be imported accordingly.
 * it does not need to be instantiated as its methods can be used directly in a main method.
 * see example: JOptionPane.showMessage(parentComponent, message, title, type);
 * in event of a lack of a parent component, null will suffice.
 * types of JOptionPanes greatly affect the look of the pane:
 * JOptionPane.PLAIN_MESSAGE, INFORMATION, ERROR, QUESTION, WARNING and they seek to perform different functions.
 * typically, with varying types of option pane messages come varying types of icons beside the text.
 *
 * JOptionPane.showConfirmDialog is another method that can be used.
 * similar to the one before it, it takes in the same arguments; the distinction comes in when passing the 'type' argument.
 * the options available are: JOptionPane.YES_NO_CANCEL_OPTION (yes - 0, no - 1, cancel - 2, x - -1);
 * JOptionPane.showInputDialog(string) - prompts the user for a string response and returns a string.
 * JOptionPane.showOptionDialog(parent, message, title, paneType, meassageType, icon, options, initialValue): this method
 * combines all of the above methods into one.
 * the options argument is an array of strings containing possible override options for the default options.
 * for example, insted of yes_no_cancel, it could be anything you want.
 *
 * JTEXTFIELD
 * is a GUI textbox component used to add, set, or get text.
 * When setting up a text field, it is possible to specifty the preferred dimension with the .setPreferredSize() method
 * that takes in a dimension type of width and height respectively.
 *
 * Useful JTextField functions include: .getText() returns whatever text is in the textfield.
 * .setText() sets a placeholder text for the field
 * .setEditable(boolean) - makes a field editable or not.
 * .setPreferredSize(new Dimension) - sets the size for the text field
 * .setFont(new Font) - sets the font to be used in the text field.
 * .setBorder() - selects the type of border for the text field.
 *
 * JCHECKBOX
 * checkboxes are pretty self-explanatory.
 * they work similarly to how text field work in terms of having the same methods.
 * JCheckBox.isSelected() returns a boolean showing if the checkbox has or hasn't been ticked.
 *
 * it is possible to edit the appearance of a checkbox with the .setIcon(icon) method
 * .setSelectedicon(icon) changes the appearance of a checkbox when it is selected.
 *
 * JRADIOBUTTONS
 * are groups of one or more buttons where only one may be selected per group.
 * typically, when radio buttons are defined, they can be more than one of them can be selected at a time.
 * this defeats the entire point and as such, non-contingent options need to be grouped into similar button groups.
 *
 * A button group is a type (ButtonGroup) that takes in buttons and groups them together.
 * similar to checkboxes, specific icons can be set with the .setIcon(icon) method.
 *
 * JCOMBOBOXES
 * a combo box is one that contains a dropdown list of objects and an editable field or button.
 * it is used to cycle between selections.
 * a new combo box is created by creating an instance of the class JComboBox.
 * when defining it, a list of objects can be passed in at the moment of instantiation.
 * some useful methods are:
 * .addItem(object) for adding new items to the list in the combo box
 * .getSelectedItem() returns a string version of the currently selected item of the combo box.
 * .getSelectedIndex() returns an integer of the index of the currently selected item of the combo box.
 * .setEditable(boolean) controls the editability and selectability of the combo box.
 * .getItemCount() returns an integer of the total current items in the combo box.
 * .insertItemAt(string, int) inserts a new item into a specified index point.
 * .setSelectedIndex(int) sets the default selected index at run time.
 * .removeItem(item) removes an item from the combo box.
 * .removeItemAt(int) removes the item at the specified index.
 * .removeAllItems() - resets the combo box.
 *
 * it is important to note that combo boxes only accept arrays of reference data types (strings, other types).
 * primitive data types wont work and if they need to be used, the wrapper classes of such types would need to be used instead.
 *
 * JSLIDER
 * is a gui component that lets users enter values by using an adjustable slider.
 * it can be found in the javax.swing.JSlider class.
 *
 * for JSliders to work, a change listener that listens for any change must be added to any instance of the class.
 * Change Listeners, when implemented as an interface, have a stateChanged method that needs to be overriden.
 * the stateChanged method takes in a ChangeEvent argument that is used to listen for particular changes.
 *
 * when defining a JSlider, it takes in a minimum, maximum and starting point value, all in integers.
 * .setPaintTicks(boolean) is a prelude to .setMinorTickSpacing(boolean) and this sets the little ticks in the slider
 * .setPaintTrack(boolean) is a prelude to .setMajorTickSpacing(integer) and this prints the cummulative value at the specified interval.
 * .setPaintLabels(boolean) displays the numbers at the intervals specified by .setMajorTickSpacing().
 * .setOrientation(SwingConstants.VERTICAL) changes the orientation vertically.
 * JSlider.getValue() returns the current value of the JSlider.
 *
 * JPROGRESSBAR
 * A JProgressBar is one that indicates the progress level of a particular operation, typically on a scale of 1-100.
 * it can be found in the package javax.swing.JProgressBar.
 * all other methods remain as you would expect but here are a few worth noting:
 * .setValue(int) - sets the value of the bar.
 * .setStringPainted(true) - gives the bar a string percentage in the centre.
 *
 * a progress bar may be filled in a number of ways, most popularly through a loop which ideally should be placed at the
 * bottom of the program, after the frame has been made visible.
 * text can be added to the progress bar with the .setString() method.
 * the default progress bar colour is 'blue' but can be changed with the .setForegroundColor() and the .setBackgroundColor() methods as appropriate.
 *
 * when instatiating a progress bar, it takes in minimum and maximum values and throw exceptions when these values are exceeded.
 *
 * JMENUBAR
 * different from a MenuBar, a JMenuBar is a java-specific menu bar housing the most important file methods.
 * it is contained in the javax.swing package.
 * it is instantiated in pretty much the same way as anything else but a JMenuBar is special in that while other components
 * need to be the added to the JFrame, a JMenuBar needs to be 'set'.
 * it follows the procedure: JFrame.setJMenuBar(mb);
 *
 * a JMenuBar will be empty if no menus are added.
 * menus are instances of the JMenu class and are added to the parent JMenuBar component to be held in a bar.
 * inside of menus are menu items which are instances of JMenuItems.
 *
 * .setMnemonic(KeyEvent) - sets a keyboard combination to trigger the object to which it is attached.
 * .setIcon(Icon) - sets the icon for the menu item.
 *
 * JFILECHOOSER
 * a java class that lets a user interact with files with a gui. it enables choosing, opening, saving, etc of files.
 * it is defined in the javax.swing.JFileChooser class and it has a bunch of cool methods.
 * .showOpenDialog() - brings up a dialog box enabling a user to browse through the computer's files. (to open)
 * .getSelectedFile() - returns the path to a selected file.
 * .showSaveDialog() - brings up a dialog box so user can select file to save.
 * .setCurrentDirectory(File) - sets a default directory to open and save files.
 *
 * JCOLORCHOOSER
 * is a gui mechanism that lets a user pick a colour.
 * it is contained in the javax.swing.JColorChooser.
 * .showDialog(parent, title, default) brings up a color chooser menu and returns a Color.
 *
 *
 * KEY LISTENER INTERFACE
 * similar to the action listener interface, the key listener interface is an event driven interface that responds to
 * certain triggers (the pressing of a key on the keyboard.)
 *
 * with the key listener interface, there are methods that need to be implemented by default: keyTyped, keyPressed and keyReleased.
 * they are all distinct, serve different purposes and take in a keyEvent argument.
 * keyTyped - is triggered when a key is 'typed'. it returns a char and uses a keyChar
 * keyPressed - is triggered when a key is pressed on a keyboard; it returns an int and uses a keyCode.
 * keyReleased - is triggered when a key is released.
 * 
 * arrow keys do not give off a key character. hence, to listen for them, key codes need to be used under the keyPressed method.
 *
 * MOUSE LISTENER INTERFACE
 * this is an event driven interface that responds to triggers related to the mouse.
 * there are five associated methods with this interface: mouseClicked, mousePressed, mouseReleased, mouseEntered, mouseExited.
 * mouseClicked - fires off when a mouse has been 'clicked' (pressed and released) on a target.
 * mousePressed - fires off when a mouse has been 'pressed' on a component.
 * mouseReleased - fires off when a mouse has been released on a component.
 * mouseEntered - fires off when a mouse enters the area of a component.
 * mouseExited - fires off when a mouse leaves the area of a component.
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
 * KEY BINDINGS IN JAVA
 * Key bindings, similar to key listeners, bind an action to a specific keystroke. however, unlike key listeners, key bindings don't require you to click a component to provide focus as they are natively active within the frame.
 * keystrokes can be applied to specific components within a frame.
 * they provide a better way to use key-triggered events.
 * 
 *
 * INDEXING FOR STRINGS AND ARRAYS
 * The typical method of indexing with square brackets does not work with strings in java.
 * to index strings in java, the string.charAt() method is used and it takes in an index number to return the character at that index.
 * However, arrays can be indexed with the [] notation as normal.
 *
 * Object[] can serve as the type for an array when trying to create an array of sibling classes(classes belonging
 * to the same super class).
 *
 * Also, when instantiating an object of a class, it may be a better programming technique to create a method returning
 * an instance of that class and insside of the method, write all of the code that could have been written in the main
 * method and at the end return the instance.
 *
 * Then, in the main method, simply create an instance of the intended class and on the R.H.S, call the method.
 * It all makes complete sense when you take a critical look at it.
 * I'm fairly positive there's a name for this method.
 *
 *
 * IMAGEICON CLASS
 * An image can be directly put into java for the use and formatting as an icon with the image icon class.
 * Upon instantialization, this takes in the absolute path to the image.
 *
 * IMPORTANT NOTE ON OOP
 * When using pre-built classes like jframe and others, an alternative to instantiating the classes is to create a
 * class for the supposed instance and make it a sub-class of the pre-built class.
 *
 * Inside this class, the entirely of the code is written within the constructor, with the this keyword indicating context.
 * A major advantage to this is that the super class' properties and methods are directly available without any form
 * of boring instantialization.
 *
 * Also, to deploy this sub-class in the main method, one needs only instantiate the sub class.
 * If there is nothing to be edited, the instantiation can be carried out without the usual LHS of the statement.
 * In other words, instead of Myframe frame = new MyFrame();, new MyFrame(); would work!
 *
 * JButtons - you seemingly need only add the conditional statement to the method of an listener interface if there are several 
 * components that the listener has been added to.
 * if it is only the one, it is not necessary.
 *
 */