# Object-Oriented Programming in Java

Welcome to the **Object-Oriented Programming in Java** repository! This project provides clear and concise Java implementations of core object-oriented programming (OOP) concepts. It serves as an educational resource for students, beginners, and developers looking to understand and apply OOP principles in Java.

## Overview

This repository contains Java code examples demonstrating fundamental OOP concepts, including encapsulation, inheritance, polymorphism, and abstraction. Each concept is implemented in a separate Java file, designed to be simple, readable, and easy to understand. The code is ideal for learning purposes or as a reference for building object-oriented applications.

## Introduction to Java Programming

Before diving into object-oriented programming, it’s helpful to understand some fundamental Java programming concepts. This section covers the basics of variables, functions (methods), loops, and if-else statements, which are essential for working with the OOP examples in this repository.

### Variables
Variables in Java are used to store data. Each variable has a type, a name, and a value. Common types include `int` (integers), `double` (floating-point numbers), `String` (text), and `boolean` (true/false).

```java
int age = 25;           // Integer variable
double price = 19.99;   // Floating-point variable
String name = "Alice";  // String variable
boolean isStudent = true; // Boolean variable
```

### Functions (Methods)
In Java, functions are called **methods** and are defined within classes. A method performs a specific task and can take parameters and return values.

```java
public class Example {
    // Method to calculate square of a number
    public int square(int number) {
        return number * number;
    }
}
```

### Loops
Loops allow you to repeat code. Java supports `for`, `while`, and `do-while` loops.

```java
// For loop: Print numbers 1 to 5
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}

// While loop: Same as above
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}
```

### If-Else Statements
If-else statements control the flow of execution based on conditions.

```java
int score = 85;
if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else {
    System.out.println("Grade: C or below");
}
```

These concepts are the building blocks for the OOP examples in this repository. Refer to Java documentation or tutorials for more details.

## Implemented OOP Concepts

The following OOP concepts are covered in this repository:

- **Encapsulation**: Bundling data and methods within a class, with access control using private fields and public methods (e.g., getter/setter methods).
- **Inheritance**: Creating class hierarchies where subclasses inherit properties and behaviors from a parent class.
- **Polymorphism**: Implementing method overriding and overloading to allow flexible behavior based on object types.
- **Abstraction**: Using abstract classes and interfaces to define common behaviors without implementation details.
- **Classes and Objects**: Defining classes and creating instances to model real-world entities.
- **Composition**: Building complex objects by combining simpler ones (e.g., "has-a" relationships).

Each concept is implemented in a separate file under the `src/` directory, often with example classes to demonstrate usage.

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with a Java compiler.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/sercankulcu/object-oriented-programming-java.git
   ```
2. Navigate to the project directory:
   ```bash
   cd object-oriented-programming-java
   ```
3. Compile the desired Java file(s) using a Java compiler or IDE:
   ```bash
   javac src/<Example>.java
   ```
   Note: Most files are standalone examples without a `main` method. You may need to create a test class to run the code.

### Usage
Each OOP concept is implemented as a Java class or set of classes. To use an example:

1. Import the desired class into your Java project.
2. Create instances or call methods to explore the OOP concept. For example:
   ```java
   // Example of inheritance
   Animal animal = new Dog();
   animal.makeSound(); // Demonstrates polymorphism
   ```
3. Refer to the source code in `src/` for detailed implementations and comments.

## Contributing
Contributions are welcome! If you'd like to add new OOP examples, improve existing code, or fix bugs, please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m "Add your feature"`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

Please ensure your code follows Java coding conventions and includes clear comments or documentation.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or suggestions, feel free to contact the repository owner, [Sercan Kulcu](https://github.com/sercankulcu), or open an issue on GitHub.

Happy coding!
