# Exception Handling in Java
Exceptions that refer to things that may stop a program from running properly. They are similar to, but largely different from **errors** even if they have similar functionalities.

The major distinction comes from the fact that exceptions can typically be and are expected to be handled by programmers while errors can arise from situations and aspects beyond a programmer's reach.

Both exceptions and errors come from a similar ancestor, **throwable** which is the main class.

Exceptions can either be **in-built** or **user-defined**.

In-built exceptions can also either be **checked** or **unchecked**.
Checked Exceptions are checked by the compiler at compile-time while Unchecked Exceptions are NOT checked at compile time.

Exceptions are handled by programmers with the **try**, **catch**, **throw** or **throws** and **finally** keywords.

Lines of code that may cause exceptions are put inside a **try** block.
Once the exception occurs, it is **thrown** and the code can **catch** this exception using the **catch** block and handle it in a specified manner.

They can be printed to the standard output with the **.printStackTrace()** method that prints all information concering the exception in **name: description** format, the **.toString()** method that does the same thing but in string format, and the **.getMessage()** method which prints only the **description** of the exception.

To manually throw an exception, the keyword, **throw**, is used. Exceptions thrown out of a method use **throws** instead.

The **throw** keyword is typically inserted inside a **try** block. 
Whenever the compiler senses the thrown exception, it checks to see if there is a nearby, applicable **catch** statement.
It it finds one that matches, it transfers control to it, otherwise, it handles it the default way.

the syntax for using the **throw** keyword is **throw Instance**. For Example: **throw new ArithmeticException(/ by zero);**

Now, for the **throws** keyword, it is used when a method may raise some type of exception.
Whenever, there is a risk of an exception being raised, the compiler warns us about it by forcing us to potentially deal with it some way, either through a **try/catch block** or through the "**throws**" keyword.

In this situation, the "throws" keyword delegates the responsibility of handling the exception to the caller of the method.

What is clear is that this keyword gives a programmer freedom to customize exceptions as he would like.

Code that must be executed after an exception are put in the "**finally**" block.