/*
 * Here is an example of polymorphism in Java:
 * 
 * */

public class PolymorphismExample {
	
  public static void main(String[] args) {
	  
    Animal a1 = new Dog("Dog", 4, true);
    Animal a2 = new Cat("Cat", 4, true);
    a1.makeNoise(); // prints "Bark"
    a2.makeNoise(); // prints "Meow"
  }
}
