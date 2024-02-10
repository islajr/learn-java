# Generics in Java

### Introduction
Java, being a type-safe language, mandates users to declare the type of a variable before initialization.
As such, the type of a variable is known at compile-time.

However, this is not always straight-forward.
`int i = 5;` is a typical way to define variables in java.
When it comes to collective data types like lists, it is not so clear-cut.
With ArrayLists, the default data-type is **int**.
Passing a string into this array list defeats the purpose of type-safety.

Generics solve this problem by making sure the error shows up at compile-time, instead of at run-time, thereby making the expression type-safe.


`List<Integer> values = new ArrayList<Integer>();`
`values.add(7);      // will work`
`values.add("him");   // is not type-safe`
