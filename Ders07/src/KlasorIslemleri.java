import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KlasorIslemleri {

	// Klasorleri listele
	public static File[] klasorleriListele(String yol) {
		return new File(yol).listFiles(File::isDirectory);
	}

	// Klasordeki dosyalari listele
	public static File[] klasordekiDosyalariListele(final File klasor) {
		return klasor.listFiles(File::isFile);
	}

	// Klasordeki tum dosyalari rekursif olarak listele
	public static List<File> tumDosyalariListele(String yol) {
		List<File> tumDosyalar = new ArrayList<>();
		File[] liste = new File(yol).listFiles();

		if (liste != null) { // Erisim hatasi durumunda liste null olabilir
			for (File dosya : liste) {
				if (dosya.isDirectory()) {
					tumDosyalar.addAll(tumDosyalariListele(dosya.getAbsolutePath()));
				} else {
					tumDosyalar.add(dosya.getAbsoluteFile());
				}
			}
		}
		return tumDosyalar;
	}

	// Belirli bir dosyayi sil
	public static boolean dosyaSil(String dosyaYolu) {
		File dosya = new File(dosyaYolu);
		return dosya.delete();
	}

	// Yeni bir klasor olustur
	public static boolean klasorOlustur(String yol) {
		File yeniKlasor = new File(yol);
		return yeniKlasor.mkdir();
	}

	// Bir klasoru ve icindekileri sil
	public static boolean klasoruSil(File klasor) {
		if (klasor.isDirectory()) {
			File[] icerik = klasor.listFiles();
			if (icerik != null) {
				for (File dosya : icerik) {
					klasoruSil(dosya); // Icindeki dosyalari/klasorleri sil
				}
			}
		}
		return klasor.delete(); // Bos klasoru sil
	}

	// Dosya bilgilerini yazdir
	public static void dosyaBilgileri(File dosya) {
		System.out.println("Dosya adi: " + dosya.getName());
		System.out.println("Tam yol: " + dosya.getAbsolutePath());
		System.out.println("Boyut (byte): " + dosya.length());
		System.out.println("Yazilabilir: " + dosya.canWrite());
		System.out.println("Okunabilir: " + dosya.canRead());
		System.out.println("Son degistirilme: " + dosya.lastModified());
	}

	public static void main(String[] args) {
		// Proje klasorunun yolunu al
		String projeKlasoru = System.getProperty("user.dir");
		System.out.println("Proje klasoru: " + projeKlasoru);

		// Proje klasoru altindaki klasorleri listele
		File[] klasorler = klasorleriListele(projeKlasoru);
		if (klasorler != null) {
			System.out.println("Klasor sayisi: " + klasorler.length);
			for (File klasor : klasorler) {
				System.out.println(klasor.toString());
			}
		} else {
			System.out.println("Klasor bulunamadi veya erisim hatasi.");
		}

		// Proje klasoru altindaki dosyalari listele
		if (klasorler != null && klasorler.length > 0) {
			File[] dosyalar = klasordekiDosyalariListele(klasorler[0]);
			if (dosyalar != null) {
				System.out.println("Dosya sayisi: " + dosyalar.length);
				for (File dosya : dosyalar) {
					System.out.println(dosya.toString());
				}
			} else {
				System.out.println("Dosya bulunamadi veya erisim hatasi.");
			}
		}

		// Proje klasoru altindaki tum dosyalari rekursif olarak listele
		List<File> dosyaListesi = tumDosyalariListele(projeKlasoru);
		System.out.println("Proje klasorundeki tum dosyalar:");
		for (File dosya : dosyaListesi) {
			System.out.println(dosya.toString());
		}

		// Yeni bir klasor olusturma
		String yeniKlasorYolu = projeKlasoru + File.separator + "YeniKlasor";
		if (klasorOlustur(yeniKlasorYolu)) {
			System.out.println("Yeni klasor olusturuldu: " + yeniKlasorYolu);
		} else {
			System.out.println("Klasor olusturulamadi veya zaten mevcut.");
		}

		// Yeni klasorun icine bir dosya olustur
		String yeniDosyaYolu = yeniKlasorYolu + File.separator + "TestDosyasi.txt";
		try {
			File yeniDosya = new File(yeniDosyaYolu);
			if (yeniDosya.createNewFile()) {
				System.out.println("Yeni dosya olusturuldu: " + yeniDosyaYolu);
			}
		} catch (IOException e) {
			System.out.println("Dosya olusturma hatasi: " + e.getMessage());
		}

		// YeniKlasor'u ve icindeki dosyayi sil
		File yeniKlasor = new File(yeniKlasorYolu);
		if (klasoruSil(yeniKlasor)) {
			System.out.println("YeniKlasor ve icindekiler silindi.");
		} else {
			System.out.println("YeniKlasor silinemedi veya mevcut degil.");
		}
	}
}
