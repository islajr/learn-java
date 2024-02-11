# Generics in Java

### Introduction
Java, being a type-safe language, mandates users to declare the type of a variable before initialization.
As such, the type of a variable is known at compile-time.

However, this is not always straight-forward.
`int i = 5;` is a typical way to define variables in java.
When it comes to collective data types like lists, it is not so clear-cut.

Typically, in collections, different types can be stored together. 
That defeats the point of type-safety.

Generics solve this problem by making sure the error shows up at compile-time, instead of at run-time, thereby making the expression type-safe.

It does this by making sure that only objects of similar types may be stored together inside of a collection.

Before Generics
`List values = new ArrayList();`
`values.add(7);     // will work`
`values.add("yes?");    // while not type-safe, will also work`


After generics
`List<Integer> values = new ArrayList<Integer>();`
`values.add(7);      // will work`
`values.add("him");   // is not type-safe`

# Streams in Java

