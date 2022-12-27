import java.io.*;

/*
 * Here is a code sample that demonstrates serialization and deserialization in Java:
 * 
 * In this code, we have a class Employee that implements the Serializable interface. 
 * This allows us to serialize an instance of the Employee class to a binary file 
 * using the ObjectOutputStream class. We can then deserialize the object by reading 
 * it from the file using the ObjectInputStream class. When the deserialized object 
 * is printed, we can see that the original object's state has been restored.
 * 
 * */

public class SerializationDemo {
	
  public static void main(String[] args) {
	  
    Employee employee = new Employee("John Smith", 12345, "Software Engineer");
    
    // Serialize the object
    try {
      FileOutputStream fileOut = new FileOutputStream("employee.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(employee);
      out.close();
      fileOut.close();
      System.out.println("Serialized employee to employee.ser");
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // Deserialize the object
    Employee deserializedEmployee = null;
    try {
      FileInputStream fileIn = new FileInputStream("employee.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      deserializedEmployee = (Employee) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    } catch (ClassNotFoundException c) {
      System.out.println("Employee class not found");
      c.printStackTrace();
      return;
    }
    
    // Print the deserialized employee information
    System.out.println("Deserialized Employee...");
    System.out.println("Name: " + deserializedEmployee.getName());
    System.out.println("ID: " + deserializedEmployee.getID());
    System.out.println("Title: " + deserializedEmployee.getTitle());
  }
}

class Employee implements Serializable {
  private String name;
  private int ID;
  private String title;
  
  public Employee(String name, int ID, String title) {
    this.name = name;
    this.ID = ID;
    this.title = title;
  }
  
  public String getName() {
    return name;
  }
  
  public int getID() {
    return ID;
  }
  
  public String getTitle() {
    return title;
  }
}
