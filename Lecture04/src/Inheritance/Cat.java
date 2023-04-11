package Inheritance;

public class Cat extends Animal {
	
	protected boolean isIndoor;
  
  public Cat(String name, int age, boolean isIndoor) {
  		super(name, age);
      this.isIndoor = isIndoor;
  }
  
  @Override
  public void speak() {
      System.out.println("Meow!");
  }
}
