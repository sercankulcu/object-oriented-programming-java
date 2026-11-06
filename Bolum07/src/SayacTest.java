import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Ornek problem 4: testler static sayaci paylasir; sonuc calisma sirasina baglidir.
// Hangi test once calisirsa calissin ikincisi kalir (bilerek).
class SayacTest {
	static int sayac = 0;

	@Test void artir() {
		sayac++;
		assertEquals(1, sayac);
	}

	@Test void ikiKezArtir() {
		sayac += 2;
		assertEquals(2, sayac);
	}

	public static void main(String[] args) {
		TestleriCalistir.calistir(SayacTest.class);
		// artir gecer; ikiKezArtir kalir: expected: <2> but was: <3> (JUnit 5.10.2 sirasiyla)
	}
}
