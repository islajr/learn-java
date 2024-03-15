# Serialization and De-Serialization in Java
**Serialization** is the process of turning an object into a byte stream (sequence of bytes) for saving or transfer purposes.
**Deserialization** is the reverse process where byte streams are used to create an actual object in memory.

![img_3.png](img_3.png)

The process is platform-independent as streams that have been serialized on one computer can be de-serialized on another computer.

Serializable objects must implement the **java.io.Serializable** interface.
The **ObjectOutputStream** class exists in this package and contains a "**writeObject()**" method for serializing an object.

Similarly, the **ObjectInputStream** class also exists in this package and contains a "**readObject()**" method for de-serializing an object.

It must the noted that the **serializable** interface is only a 'marker' interface used to 'mark' classes so that objects of those classes may get a certain capability.

## Serialization UID
The serialization runtime associates a version number with each serializable class called a **SerialVersionUID**, used during Deserialization to verify that both senders and receivers of that serialized object have loaded the class present in the object.

If a receiver loads a class with a UID different from the one present in the sender's class, the Deserialization process will result in an **InvalidClassException**.

A serializable class can declare its own UID by declaring a field name that must be static, final and of type **long**.
For example, `static final long nameUID = 422L`.

If a UID is not explicitly declared, the runtime will declare one for it based on the various aspects of the class.

It is also worth noting that when declaring a serialUID, it is recommended that the 'private' access modifier is used.


### Process of Serialization
After going through the process, myself, here is a detailed process of how serialization can be implemented in java.

- A test class is created that will implement **serializable** and will hold details that need to be serialized.
- An instance of that class is created in main
- A file output stream is instantiated and stored inside a file at a determined location
- An object output stream is instantiated and takes the file output stream as an argument, all of which is still part of the preparatory process.
- The content of the test class is written to the created file with the .writeObject() method of the ObjectOutputStream.
- Both streams are closed and the IOException is caught.

De-serialization follows the same process but in a different way:

- A new instance of the test class is created but left empty for the purpose of storing our de-serialized object.
- Inside the try block, this time, instances of the FileInputStreams and ObjectInputStream classes are created to read from the already serialized file.
- The .readObject() method then reads the serialized file and stores it in the new test class instance created at the beginning of this process.
- Both streams are then closed and the test class is checked to see if the output stored matches the input.
- IOException and ClassNotFoundExceptions are caught and the program is concluded.