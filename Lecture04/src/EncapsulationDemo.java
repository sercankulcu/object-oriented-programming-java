public class EncapsulationDemo {
	// private variables are only accessible within the class
	private int age;
	private String name;

	// public getters and setters allow external access to the private variables
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args)
	{
		// to access the variables from outside the class, we use the getters and setters:
		EncapsulationDemo demo = new EncapsulationDemo();
		demo.setAge(30);
		demo.setName("John");

		int age = demo.getAge();
		String name = demo.getName();

		System.out.println("Age: " + age);
		System.out.println("Name: " + name);
	}
}

