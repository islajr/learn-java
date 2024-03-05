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
The java stream API brings functional programming to java since java is, by default, object-oriented.
They make use of lambda expressions heavily.

A stream consists of a source, followed by intermediate operations and finally a terminal operation.

A stream source can either be a collection, list, set, anything that can hold data.

The intermediate function can be a filter, map or sort function; basically a function that returns a stream.

A terminal function returns a non-stream result. Examples my be: forEach, reduce, etc.
