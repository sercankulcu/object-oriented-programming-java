package Inheritance;

public class Main {
  public static void main(String[] args) {
      Animal animal = new Animal("Generic Animal", 5);
      System.out.println(animal.getName() + " is " + animal.getAge() + " years old.");
      animal.speak();
      
      Dog dog = new Dog("Fido", 3, "Sokak");
      System.out.println(dog.getName() + " is " + dog.getAge() + " years old.");
      dog.speak();
      
      Cat cat = new Cat("Whiskers", 2, false);
      System.out.println(cat.getName() + " is " + cat.getAge() + " years old.");
      cat.speak();
      
      Labrador labrador = new Labrador("Buddy", 3);
      System.out.println(labrador.getName() + " is a " + labrador.getBreed() + " and is " + labrador.getAge() + " years old.");
      labrador.speak();
      labrador.swim();
      
      Siamese siamese = new Siamese("Mittens", 2);
      System.out.println(siamese.getName() + " is " + siamese.getAge() + " years old, and is an indoor cat: " + siamese.isIndoor());
      siamese.speak();
      siamese.scratch();
  }
}