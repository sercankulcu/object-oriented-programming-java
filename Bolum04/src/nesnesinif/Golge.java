package nesnesinif;

// this anahtar sozcugu: this unutulunca parametre alani golgeler,
// atama parametrenin kendisine yapilir ve alan null kalir.
public class Golge {
	private String ad;

	public Golge(String ad) {
		ad = ad;            // this unutuldu!
	}

	public static void main(String[] args) {
		Golge g = new Golge("Ali");
		System.out.println(g.ad);   // null
	}
}

/* Beklenen cikti:
null
*/
