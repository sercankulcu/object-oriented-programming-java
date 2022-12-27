/*
 * Here is a code that demonstrates access modifiers in Java:
 * 
 * In this code, we have a class AccessModifiersDemo that has four variables with 
 * different access modifiers: privateInt, publicInt, protectedInt, and defaultInt.
 * */

public class AccessModifiersDemo {

	private int privateInt = 1;
	public int publicInt = 2;
	protected int protectedInt = 3;
	int defaultInt = 4;

}

class Main {

	public static void main(String[] args) {

		AccessModifiersDemo obj = new AccessModifiersDemo();
		System.out.println(obj.publicInt); // 2
		System.out.println(obj.protectedInt); // 3
		System.out.println(obj.defaultInt); // 4
		//System.out.println(obj.privateInt); // error: privateInt has private access in AccessModifiersDemo
	}
}