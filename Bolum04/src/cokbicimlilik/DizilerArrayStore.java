package cokbicimlilik;

import cokbicimlilik.OrnekHiyerarsi.Hayvan;
import cokbicimlilik.OrnekHiyerarsi.Kedi;
import cokbicimlilik.OrnekHiyerarsi.Kopek;

// Diziler kovaryanttir: Kopek[] bir Hayvan[] degiskenine atanabilir, ama
// yanlis tipte oge yazmak calisirken ArrayStoreException verir. Jenerikler buna izin vermez.
public class DizilerArrayStore {

	public static void main(String[] args) {
		try {
			Kopek[] kopekler = new Kopek[2];
			Hayvan[] hayvanlar = kopekler;   // derlenir
			hayvanlar[0] = new Kopek();
			System.out.println("ilk atama tamam");   // ilk atama tamam
			hayvanlar[1] = new Kedi();       // derlenir ama...
			System.out.println("buraya gelinmez");
		} catch (ArrayStoreException e) {
			System.out.println("java.lang.ArrayStoreException: " + e.getMessage());
			// java.lang.ArrayStoreException: cokbicimlilik.OrnekHiyerarsi$Kedi   (sunumda: Kedi)
		}

		// List<Hayvan> l = new ArrayList<Kopek>();
		// derleme hatasi: incompatible types: ArrayList<Kopek>
		//   cannot be converted to List<Hayvan>

		// Ornek Problem 4: Object[] d = new String[1]; d[0] = 1;
		try {
			Object[] d = new String[1];
			d[0] = 1;
		} catch (ArrayStoreException e) {
			System.out.println("ArrayStoreException: " + e.getMessage());   // ArrayStoreException: java.lang.Integer
		}
	}
}
