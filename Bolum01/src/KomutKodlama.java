// Komutlarin Kodlanmasi: 8 bitlik bir komutu islem kodu, hedef ve iki
// kaynak alanina boler (2'ser bit).
public class KomutKodlama {
	public static void main(String[] args) {
		int komut = 0b00110010;
		int islemKodu = komut / 64;     // ilk 2 bit
		int hedef = (komut / 16) % 4;   // sonraki 2 bit
		int kaynak1 = (komut / 4) % 4;  // sonraki 2 bit
		int kaynak2 = komut % 4;        // son 2 bit
		System.out.println(komut);  // 50
		System.out.println(islemKodu + " " + hedef
				+ " " + kaynak1 + " " + kaynak2);  // 0 3 0 2
	}
}
