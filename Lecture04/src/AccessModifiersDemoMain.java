
class AccessModifiersDemoMain {

	public static void main(String[] args) {

		AccessModifiersDemo obj = new AccessModifiersDemo();
		System.out.println(obj.publicInt); // 2
		System.out.println(obj.protectedInt); // 3
		System.out.println(obj.defaultInt); // 4
		//System.out.println(obj.privateInt); // error: privateInt has private access in AccessModifiersDemo
	}
}