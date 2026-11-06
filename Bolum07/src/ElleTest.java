// Elle test: sonucu ekrana yazip dogru olup olmadigina kendimiz karar veririz.
public class ElleTest {
	public static void main(String[] args) {
		HesapMakinesi hm = new HesapMakinesi();
		System.out.println("topla(2, 3) = " + hm.topla(2, 3));   // topla(2, 3) = 5
		System.out.println("carp(2, -3) = " + hm.carp(2, -3));   // carp(2, -3) = -6
		// Dogru mu? Ekrana bakip kendimiz karar veriyoruz.
	}
}
