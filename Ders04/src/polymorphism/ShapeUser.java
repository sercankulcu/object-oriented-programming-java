package polymorphism;

public class ShapeUser {
	
  public static void main(String[] args) {
  	
      Shape shape1 = new Circle(5);
      Shape shape2 = new Square(4);
      Shape shape3 = new Rectangle(6, 8);
      Shape shape4 = new Triangle(5, 4, 3, 4, 5);
      
      System.out.println("Area of shape1: " + shape1.area());
      System.out.println("Perimeter of shape1: " + shape1.perimeter());
      System.out.println("Area of shape2: " + shape2.area());
      System.out.println("Perimeter of shape2: " + shape2.perimeter());
      System.out.println("Area of shape3: " + shape3.area());
      System.out.println("Perimeter of shape3: " + shape3.perimeter());
      System.out.println("Area of shape4: " + shape4.area());
      System.out.println("Perimeter of shape4: " + shape4.perimeter());
  }
}
