package Inheritance;

public class Siamese extends Cat {
  public Siamese(String name, int age) {
      super(name, age, true);
  }
  
  public void scratch() {
      System.out.println("This Siamese cat loves to scratch things.");
  }

	public boolean isIndoor() {
		// TODO Auto-generated method stub
		return isIndoor;
	}
}