package overriding;

// Kisi sinifi
public class Kisi {

    private String ad;
    private int yas;

    // Kisi yapilandirici metodu
    public Kisi(String ad, int yas) {
        this.ad = ad;
        this.yas = yas;
    }

    // Equals metodu ozellestirilmistir
    @Override
    public boolean equals(Object obj) {
        // Ayni referansa sahipse, esittir
        if (this == obj) return true;

        // Null kontrolu yapilir ve nesne turu karsilastirilir
        if (obj == null || getClass() != obj.getClass()) return false;

        // Kisi nesnelerinin alanlari karsilastirilir
        Kisi kisi = (Kisi) obj;
        return yas == kisi.yas && ad.equals(kisi.ad);
    }

    // Ad alani icin getter metodu
    public String getAd() {
        return ad;
    }

    // Yas alani icin getter metodu
    public int getYas() {
        return yas;
    }

    // toString metodu
    @Override
    public String toString() {
        return "Kisi[Ad=" + ad + ", Yas=" + yas + "]";
    }

    public static void main(String[] args) {
        // Iki farkli Kisi nesnesi olusturulur
        Kisi kisi1 = new Kisi("Ali", 25);
        Kisi kisi2 = new Kisi("Ali", 25);

        // == operatoru ile esitlik kontrolu yapilir
        if (kisi1 == kisi2) {
            System.out.println("Iki kisi nesnesi esittir.");
        } else {
            System.out.println("Iki kisi nesnesi esit degildir.");
        }

        // equals metodu kullanilarak esitlik kontrolu yapilir
        if (kisi1.equals(kisi2)) {
            System.out.println("Iki kisi nesnesi esittir.");
        } else {
            System.out.println("Iki kisi nesnesi esit degildir.");
        }

        // Kisi nesnesinin bilgileri yazdirilir
        System.out.println(kisi1.toString());
    }
}
