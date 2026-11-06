import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// NotSerializableException: Serializable olmayan bir nesneyi yazmak.
// Duzeltme: sinif Serializable'i uygular.

class Nokta {               // Serializable degil
	int x = 3, y = 4;
}

public class NotSerializableOrnegi {

	// Duzeltilmis surum (ayni adla cakismasin diye ic sinif)
	static class Duzeltilmis {
		static class Nokta implements Serializable {
			private static final long serialVersionUID = 1L;
			int x = 3, y = 4;
		}
	}

	public static void main(String[] args) {
		try (ObjectOutputStream outputStream =
				new ObjectOutputStream(new ByteArrayOutputStream())) {
			// Nesneyi ObjectOutputStream ile serilestirmeye calisma
			Nokta notSerializableObj = new Nokta();
			outputStream.writeObject(notSerializableObj);
		} catch (NotSerializableException e) {
			System.out.println(e);   // java.io.NotSerializableException: Nokta
		} catch (IOException e) {
			System.out.println("Diger G/C hatasi: " + e);
		}

		try (ObjectOutputStream outputStream =
				new ObjectOutputStream(new ByteArrayOutputStream())) {
			outputStream.writeObject(new Duzeltilmis.Nokta());
			System.out.println("Serializable Nokta yazildi");   // Serializable Nokta yazildi
		} catch (IOException e) {
			System.out.println("Diger G/C hatasi: " + e);
		}
	}
}
