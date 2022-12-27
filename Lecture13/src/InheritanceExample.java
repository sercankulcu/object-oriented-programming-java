/*
 * Here is a code sample demonstrating inheritance in Java:
 * 
 * In this example, we have a base class Animal with two fields: name and numLegs. It 
 * also has a method makeNoise() that prints a generic message. We then have two 
 * subclasses: Dog and Cat, which both inherit from Animal. The Dog class has an 
 * additional field hasTail and a method wagTail(), while the Cat class has an 
 * additional field hasWhiskers and a method scratchFurniture().
 * 
 * */

class Animal {
  protected String name;
  protected int numLegs;

  public Animal(String name, int numLegs) {
    this.name = name;
    this.numLegs = numLegs;
  }

  public void makeNoise() {
    System.out.println("Some noise");
  }
}

class Dog extends Animal {
  private boolean hasTail;

  public Dog(String name, int numLegs, boolean hasTail) {
    super(name, numLegs);
    this.hasTail = hasTail;
  }

  @Override
  public void makeNoise() {
    System.out.println("Bark");
  }

  public void wagTail() {
    if (hasTail) {
      System.out.println("Wagging tail");
    } else {
      System.out.println("No tail to wag");
    }
  }
}

class Cat extends Animal {
  private boolean hasWhiskers;

  public Cat(String name, int numLegs, boolean hasWhiskers) {
    super(name, numLegs);
    this.hasWhiskers = hasWhiskers;
  }

  @Override
  public void makeNoise() {
    System.out.println("Meow");
  }

  public void scratchFurniture() {
    System.out.println("Scratching furniture");
  }
}

public class InheritanceExample {
  public static void main(String[] args) {
    Animal a1 = new Animal("Animal", 4);
    a1.makeNoise(); // prints "Some noise"

    Dog d1 = new Dog("Fido", 4, true);
    d1.makeNoise(); // prints "Bark"
    d1.wagTail(); // prints "Wagging tail"

    Cat c1 = new Cat("Fluffy", 4, true);
    c1.makeNoise(); // prints "Meow"
    c1.scratchFurniture(); // prints "Scratching furniture"
  }
}
