# Object-Oriented Programming in Java

Java code examples for the undergraduate **Object-Oriented Programming with Java (Java ile Nesneye Dayalı Programlama)** course at Giresun University. Each `BolumNN/src` folder holds chapter NN of the course and contains the code shown on that chapter's slides as small runnable programs. Class, method and variable names follow the slides, so each program's output can be compared directly with the slide examples.

Course page and slides: <https://sercankulcu.github.io/teaching/object-oriented-programming-with-java>

## Chapters

| Folder | Chapter | Programs |
|---|---|---|
| `Bolum01` | Computers, Computation and Algorithms | First program, number systems, characters, a toy computer and instruction encoding, Babylonian square root, Euclid, flowchart and pseudocode examples (sequence, selection, loops, sentinel value, nested loops, subprograms, desk checking) |
| `Bolum02` | Programming and Java Syntax | Programming paradigms, syntax and semantics, compile errors, bytecode, variables, limits and overflow, literals and constants, type conversion, `char` and `int`, increment/decrement, operators |
| `Bolum03` | Control Structures, Methods, Arrays, Strings, Recursion | `if`/`switch`, loops, `do-while` input, methods, overloading, scope and shadowing, arrays and array algorithms, mean/median/mode, multidimensional arrays, transpose, tic-tac-toe, string basics, comparison and formatting, recursion and Towers of Hanoi |
| `Bolum04` | Objects and Classes, Encapsulation, Inheritance, Polymorphism, Abstract Classes | One package per slide deck: `nesnesinif`, `sarmalama`, `kalitim`, `cokbicimlilik`, `soyutsiniflar`; the package examples from the slides (`banka`, `canli`, `evcil`, `tr.edu.giresun.banka`, `uygulama`) |
| `Bolum05` | Collections | `Collection` methods, lists, queues, sets, maps, iterators, sorting, `Collections` algorithms, streams, immutable collections, common mistakes |
| `Bolum06` | Exceptions | Exception hierarchy, `try`/`catch`/`finally`, `throw`/`throws`, checked and unchecked exceptions, try-with-resources, custom exceptions, stack traces, propagation |
| `Bolum07` | Testing and Debugging | Manual tests, JUnit 5 tests (assertions, exceptions, parameterized tests, lifecycle, property tests) and the `TestleriCalistir` runner, debugging, `jdb`, profiling, lint warnings |
| `Bolum08` | Input and Output | Byte and character streams, buffering, `Scanner` and `PrintWriter`, encodings, random access, serialization, NIO files, channels and buffers, selectors |
| `Bolum09` | Graphics and User Interfaces | Drawing with `Graphics`, `Point` and `Color`, frames and panels, layout managers, buttons, labels and text fields, mouse events, `invokeLater` |
| `Bolum10` | Threads | Creating threads, thread states, `join`, interruption, daemon threads, race conditions, `synchronized`, `volatile`, atomics, locks, deadlock, producer-consumer, `CountDownLatch`, `CyclicBarrier`, `Semaphore`, `Exchanger`, thread pools, `CompletableFuture`, `ThreadLocal` |
| `Bolum11` | Database Programming | JDBC steps with SQLite: creating tables, insert/select/update/delete, `PreparedStatement` and SQL injection, joins and grouping, transactions, batch updates, generated keys, mapping rows to objects |

## Running the examples

Requires **JDK 21**.

Every program has a `main` method and no program waits for keyboard input: programs that demonstrate `Scanner` read from a fixed string, and random numbers use a fixed seed. Code that does not compile on the slides is kept as comments next to a corrected version; runtime errors are caught and their messages printed. Programs that write files delete them before they finish. To compile and run one chapter:

```bash
cd Bolum05/src
javac -d ../bin *.java
java -cp ../bin MapOrnekleri
```

- **`Bolum04`** uses packages, so compile every file under `src` and run classes by their full name:

  ```bash
  javac -d ../bin $(find . -name '*.java')
  java -cp ../bin kalitim.ToStringMetodu
  ```

- **`Bolum07`** needs the JUnit 5 jars in `Bolum07/lib`. `TestleriCalistir` runs every test class and prints a summary. Some tests on the slides fail on purpose; the summary lists them.

  ```bash
  javac -cp "../lib/*" -d ../bin *.java
  java -cp "../bin;../lib/*" TestleriCalistir
  ```

  On macOS and Linux, use `:` instead of `;` in the classpath.

- **`Bolum09`** programs that start with the comment `// GUI` open a window. The other programs in the folder print their results to the console.

- **`Bolum11`** uses the SQLite JDBC driver in `Bolum11/lib`, for example:

  ```bash
  java -cp "../bin;../lib/*" SelectSorgusu
  ```

  The MySQL example only shows the connection code and reports that no server is available.

Each folder is also an Eclipse project (`File > Import > Existing Projects into Workspace`). The library jars are already on the project classpath.

Comments and identifiers are in Turkish, written without Turkish characters so the files compile with any platform encoding.

## Contact

For questions or suggestions, contact [Sercan Külcü](https://github.com/sercankulcu) or open an issue on GitHub.
