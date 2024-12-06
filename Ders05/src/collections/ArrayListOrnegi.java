package collections;
import java.util.ArrayList;

public class ArrayListOrnegi {

	public static void main(String[] args) {

		// ArrayList tanimla ve isimler listesi olustur
		ArrayList<String> isimler = new ArrayList<>();

		// Listeye eleman ekle
		isimler.add("Alice");
		isimler.add("Bob");
		isimler.add("Charlie");
		isimler.add("Dave");
		isimler.add("Eve");

		// Orijinal listeyi ekrana yazdir
		System.out.println("Orijinal liste: " + isimler);

		// "Dave" yerine "Carol" ekle
		isimler.set(3, "Carol");
		System.out.println("Degistirilmis liste: " + isimler);

		// "Eve"yi listeden kaldir
		isimler.remove(4);
		System.out.println("Degistirilmis liste: " + isimler);

		// "Frank"i index 2'ye ekle
		isimler.add(2, "Frank");
		System.out.println("Degistirilmis liste: " + isimler);

		// "Bob"un index'ini bul
		int index = isimler.indexOf("Bob");
		System.out.println("Bob'un index'i: " + index);

		// Liste "Eve"yi iceriyor mu kontrol et
		boolean iceriyorMu = isimler.contains("Eve");
		System.out.println("Liste 'Eve'yi iceriyor mu: " + iceriyorMu);

		// Listenin boyutunu al
		int boyut = isimler.size();
		System.out.println("Listenin boyutu: " + boyut);
	}
}
