package forloop;

public class CarpimTablosu {

    public static void main(String[] args) {

        // Baslik yazdirilir
        System.out.println("Carpim Tablosu:");
        
        // Dis dongu: Satirlari temsil eder
        for (int i = 1; i <= 10; i++) {

            // Ic dongu: Sutunlari temsil eder
            for (int j = 1; j <= 10; j++) {

                // Carpim sonucu yazdirilir, tab ile hizalama yapilir
                System.out.print(i + "x" + j + "=" + (i * j) + "\t");
            }

            // Her satir tamamlandiginda yeni satira gecilir
            System.out.println();
        }
    }
}
