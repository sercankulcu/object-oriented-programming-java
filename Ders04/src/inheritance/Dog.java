package inheritance;

public class Dog extends Animal {
	
	protected String breed;
  
  public Dog(String name, int age, String breed) {
  		super(name, age);
      this.breed = breed;
  }
  
  @Override
  public void speak() {
      System.out.println("Woof!");
  }
}