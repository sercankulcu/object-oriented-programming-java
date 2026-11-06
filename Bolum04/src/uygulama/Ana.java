package uygulama;

import banka.Hesap;

// Paket ornegi: uygulama paketi banka.Hesap'i import ederek kullanir.
// > javac -d out src/banka/Hesap.java src/uygulama/Ana.java
// > java -cp out uygulama.Ana
public class Ana {
	public static void main(String[] args) {
		Hesap h = new Hesap();
		h.yatir(250.0);
		System.out.println("Bakiye: " + h.getBakiye());   // Bakiye: 250.0
	}
}
