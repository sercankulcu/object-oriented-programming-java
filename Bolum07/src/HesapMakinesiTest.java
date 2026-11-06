import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Ilk JUnit testi: sonucu assertEquals denetler, ekrana bakmaya gerek kalmaz.
// Gradle bagimliligi (sunumda): testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
class HesapMakinesiTest {

	@Test
	void ikiSayiyiToplar() {
		HesapMakinesi hm = new HesapMakinesi();
		assertEquals(5, hm.topla(2, 3));
	}

	@Test
	void negatifSayiylaCarpar() {
		HesapMakinesi hm = new HesapMakinesi();
		assertEquals(-6, hm.carp(2, -3));
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(HesapMakinesiTest.class);   // 2 test, 2 gecti
	}
}
