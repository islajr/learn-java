# Build Tools - Gradle
A build tool is a CLI program that automates the process of compiling, assembling and deploying software.
However, they are not limited to these features.

Some build tools can help with package management, dependencies, unit-testing and CI/CD.

Build tools find their use case in large projects where it is complicated to keep track of or to manually execute the build process.
In these situations, build tools are employed to make the process more consistent and less confusing to manage.

## Gradle
Gradle is an open-source build automation tool that is capable of building almost any type of software.
It provides support for building, testing and deploying software on different platforms.

Gradle works by describing everything on the basis of **projects** and **tasks**.

A **project** may be anything from a web application to a JAR Library. Each project is made up of one or more tasks.

A **task** is a single piece of work that a build performs. It is a subdivision of a project. For example, it could be **compiling classes**, **generating a javadoc**, etc.

## Gradle vs. Maven

Let's discuss some key differences between Gradle and Maven:

- **Gradle** is a build automation system that uses a Groovy-based DSL (domain-specific language ) while **Maven** is a software project management system that is primarily used for java projects.

- **Gradle** does not use an XML file for declaring the project configuration while **Maven** uses an XML file for declaring the project, its dependencies, the build order, and its required plugin.

- **Gradle** is based on a graph of task dependencies that do the work, while **Maven** is based on the phases of the fixed and linear model.

- In **Gradle**, the main goal is to add functionality to the project. 	In **maven**, the main goal is related to the project phase.

- **Gradle** avoids the work by tracking input and output tasks and only runs the tasks that have been changed. Therefore, it gives a faster performance.
 **Maven** does not use the build cache; thus, its build time is slower than Gradle.

- **Gradle** is highly customizable; it provides a wide range of IDE support custom-builds. **Maven** has a limited number of parameters and requirements, so customization is a bit complicated.

- Gradle avoids the compilation of Java. 	The compilation is mandatory in Maven.

