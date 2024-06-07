package objects;

/*
 * In this example, we have two classes: Person and Address. The Person class has a name, age, 
 * and an Address object as instance variables. The Address class has a street, city, and state as 
 * instance variables.
 * */

public class Main {
  public static void main(String[] args) {
      Address address = new Address("123 Main St", "Anytown", "CA");
      Person person = new Person("John Smith", 30, address);
      person.introduce();
  }
}