# Exception Handling in Java
Exceptions are things that stop a program from running. They are similar to, but largely different from **errors** even if they have similar functionalities.

The major distinction comes from the fact that exceptions can typically be and are expected to be handled by programmers while errors can arise from situations and aspects beyond a programmer's reach.

Both exceptions and errors come from a similar ancestor, **throwable** which is the main class.

Exceptions can either be **in-built** or **user-defined**.

In-built exceptions can also either be **checked** or **unchecked**.
Checked Exceptions are checked by the compiler at compile-time while Unchecked Exceptions are NOT checked at compile time.

Exceptions are handled by programmers with the **try**, **catch**, **throw** or **throws** and **finally** keywords.

They can be printed to the standard output with the **.printStackTrace()** method that prints all information concering the exception in **name: description** format, the **.toString()** method that does the same thing but in string format, and the **.getMessage()** method which prints only the **description** of the exception.