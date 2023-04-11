package ClassesAndObjects;

public class Person {
  private String name;
  private int age;
  private Address address;
  
  public Person(String name, int age, Address address) {
      this.name = name;
      this.age = age;
      this.address = address;
  }
  
  public void introduce() {
      System.out.println("My name is " + name + ", I am " + age + " years old, and I live at " + address.getFullAddress());
  }
}


