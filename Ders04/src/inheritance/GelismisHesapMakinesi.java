package inheritance;

public class GelismisHesapMakinesi extends HesapMakinesi {

    public GelismisHesapMakinesi() {
        super();  // Ust sinifin kurucusunu cagir
    }

    // Karekok fonksiyonu 
    public double kareKok(double sayi) {
        if (sayi < 0) {
            throw new IllegalArgumentException("Negatif sayilarin karekoku hesaplanamaz.");
        }
        double t = sayi;
        double epsilon = 0.0001;  // Hata payi (yaklasiklik)
        while (true) {
            double karekokTahmin = (t + sayi / t) / 2;  // Newton-Raphson metodu
            if (Math.abs(t - karekokTahmin) < epsilon) {  // Hata payi belirli bir sinira dusene kadar hesaplama devam eder
                break;
            }
            t = karekokTahmin;
        }
        return t;
    }

    // Us alma fonksiyonu 
    public double us(double taban, double us) {
        if (us < 0) {
            return 1 / us(taban, -us);  // Negatif us icin tersini al
        }
        double sonuc = 1.0;
        for (int i = 0; i < us; i++) {
            sonuc *= taban;  // Tabani us kadar carparak sonuca ulasiriz
        }
        return sonuc;
    }

    // Logaritma fonksiyonu 
    public double logaritma(double sayi) {
        if (sayi <= 0) {
            throw new IllegalArgumentException("Pozitif sayi girmelisiniz");  // Logaritma negatif sayilar icin tanimsizdir
        }
        double x = (sayi - 1) / (sayi + 1);
        double logaritma = 0.0;
        for (int i = 1; i < 1000; i += 2) {
            logaritma += (1.0 / i) * us(x, i);  // Gregory-Leibniz serisi ile hesaplama
        }
        return 2 * logaritma;  // Sonucu 2 ile carparak dogru logaritma degeri elde edilir
    }

    // Faktoriyel fonksiyonu 
    public double faktoriyel(double sayi) {
        if (sayi == 0) {
            return 1;  // 0'in faktoriyeli 1'dir
        } else {
            double sonuc = 1;
            for (int i = 1; i <= sayi; i++) {
                sonuc *= i;  // Faktoriyel hesaplamak icin her sayiyi carpariz
            }
            return sonuc;
        }
    }

    public static void main(String[] args)
    {
        GelismisHesapMakinesi hesap = new GelismisHesapMakinesi();

        // Sabit sayilarla hesaplama yapiliyor
        double sayi1 = 16.0;
        double sayi2 = 2.0;
        double sayi3 = 5.0;

        // Karekok Hesaplama
        System.out.println("Karekok Hesaplama:");
        System.out.println(sayi1 + "'in karekoku: " + hesap.kareKok(sayi1));

        // Us Alma
        System.out.println("\nUs Alma:");
        System.out.println(sayi2 + "'nin " + sayi3 + " ussu: " + hesap.us(sayi2, sayi3));

        // Logaritma Hesaplama
        System.out.println("\nLogaritma Hesaplama:");
        System.out.println(sayi1 + "'in logaritmasi: " + hesap.logaritma(sayi1));

        // Faktoriyel Hesaplama
        System.out.println("\nFaktoriyel Hesaplama:");
        System.out.println(sayi3 + "'in faktoriyeli: " + hesap.faktoriyel(sayi3));
    }

}
