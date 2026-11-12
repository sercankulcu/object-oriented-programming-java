// try-with-resources: AutoCloseable kaynaklar catch'ten once, acilis
// sirasinin tersiyle otomatik kapatilir.
public class KaynakOrnekleri {

	static class Kaynak implements AutoCloseable {
		private String ad;
		Kaynak(String ad) {
			this.ad = ad;
			System.out.println(ad + " acildi");
		}
		void kullan(int x) {
			System.out.println(ad + " kullaniliyor");
			int s = 10 / x;
		}
		@Override
		public void close() {
			System.out.println(ad + " kapatildi");
		}
	}

	// try-with-resources
	static void tekKaynak() {
		try (Kaynak k = new Kaynak("dosya")) {
			k.kullan(0);
		} catch (ArithmeticException e) {
			System.out.println("Hata: " + e.getMessage());
		}
		// dosya acildi, dosya kullaniliyor, dosya kapatildi, Hata: / by zero
	}

	// try-with-resources: Kod Izleme
	static void ikiKaynak() {
		try (Kaynak a = new Kaynak("dosya");
			 Kaynak b = new Kaynak("ag")) {
			b.kullan(0);
			System.out.println("try sonu");
		} catch (ArithmeticException e) {
			System.out.println("Hata: " + e.getMessage());
		} finally {
			System.out.println("finally");
		}
		// dosya acildi, ag acildi, ag kullaniliyor, ag kapatildi,
		// dosya kapatildi, Hata: / by zero, finally
	}

	public static void main(String[] args) {
		tekKaynak();
		ikiKaynak();
	}
}

/* Beklenen cikti:
dosya acildi
dosya kullaniliyor
dosya kapatildi
Hata: / by zero
dosya acildi
ag acildi
ag kullaniliyor
ag kapatildi
dosya kapatildi
Hata: / by zero
finally
*/
