package inheritance;

public class HayvanatBahcesi {

	public static void main(String[] args) {

		// Kedi sinifindan bir nesne olustur
		Kedi kedi = new Kedi("Mavi", 3);
		kedi.konus();
		kedi.avlan();
		kedi.yemekYe(5.0);
		kedi.uyu();
		kedi.yasHesapla();
		System.out.println(kedi.toString());

		// Kopek sinifindan bir nesne olustur
		Kopek kopek = new Kopek("Karabas", 4);
		kopek.konus();
		kopek.topOyna();
		kopek.yemekYe(10.0);
		kopek.uyu();
		kopek.yasHesapla();
		System.out.println(kopek.toString());

		// Kus sinifindan bir nesne olustur
		Kus kus = new Kus("Sirin", 2);
		kus.konus();
		kus.ucmak();
		kus.yemekYe(3.0);
		kus.uyu();
		kus.yasHesapla();
		System.out.println(kus.toString());

		// At sinifindan bir nesne olustur
		At at = new At("Karakoc", 5);
		at.konus();
		at.kos();
		at.yemekYe(7.0);
		at.uyu();
		at.yasHesapla();
		System.out.println(at.toString());
	}
}