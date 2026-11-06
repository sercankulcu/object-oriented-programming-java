// Zincirleme catch'te sira: ozel istisna genelden once gelmeli,
// yoksa ozel catch'e hic ulasilamaz ve derleyici hata verir.
public class SiraHatasi {
	public static void main(String[] args) {
		// Hatali sira:
		// try {
		//   int sonuc = 10 / 0;
		// } catch (Exception e) {
		//   System.out.println("Genel hata");
		// } catch (ArithmeticException e) {
		//   System.out.println("Aritmetik hata");
		// }
		// derleme hatasi: exception ArithmeticException has already been caught

		// Dogru sira:
		try {
			int sonuc = 10 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Aritmetik hata");   // Aritmetik hata
		} catch (Exception e) {
			System.out.println("Genel hata");
		}
	}
}
