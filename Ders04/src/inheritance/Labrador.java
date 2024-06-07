package inheritance;

public class Labrador extends Dog {
  public Labrador(String name, int age) {
      super(name, age, "Labrador");
  }
  
  public void swim() {
      System.out.println("This Labrador loves to swim.");
  }

	public String getBreed() {
		// TODO Auto-generated method stub
		return breed;
	}
}
