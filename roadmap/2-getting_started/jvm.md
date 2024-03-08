# How JVM Works
JVM stands for Java Virtual Machine, and it's purpose is to execute programs.

It is a platform-dependent specification that provides a runtime environment in which java byte code can be executed.
The JVM runs on the host's operating system and places its demands for resources from the system.

Since the JVM is a 'specification', it can have various implementations, as long as they adhere to the specifications.

## JVM Architecture
![img.png](img.png)

*Picture showing the JVM architecture*

## Garbage Collection
This is java's automatic process of freeing up memory.
It finds objects that are no longer in use and clears them, thereby reclaiming their memory from the heap.

Java does all of this automatically, without any user input.

Garbage collection helps greatly in providing massive performance boosts to applications and they are of different types, namely:
- Serial Collector
- Throughput Collector
- CMS Collector
- G1 Collector

