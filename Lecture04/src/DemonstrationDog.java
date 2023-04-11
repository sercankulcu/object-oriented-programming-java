/*
 * Here is a demonstration code that shows how to create a class, create objects 
 * of that class, and call methods on those objects:
 * 
 * When this code is run, it will output "Woof woof!" twice, once for each object 
 * of the Dog class that calls the bark method.
 * */

public class DemonstrationDog {
	
	public static void main(String[] args) {
		
		// Create an object of the Dog class
		Dog dog1 = new Dog();

		// Call the bark method on the dog1 object
		dog1.bark();

		// Create another object of the Dog class
		Dog dog2 = new Dog();

		// Call the bark method on the dog2 object
		dog2.bark();
	}
}

