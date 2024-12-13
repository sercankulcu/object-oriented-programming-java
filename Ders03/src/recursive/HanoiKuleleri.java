package recursive;

public class HanoiKuleleri {

    // Disk sayisini belirle
    public static final int NUM_DISKS = 3;

    public static void main(String[] args) {

        coz(NUM_DISKS, 'A', 'B', 'C');
    }

    // Hanoi Kuleleri bulmacasini cozen rekursif metod
    public static void coz(int diskSayisi, char kaynak, char hedef, char yardimci) {
        // Eger sadece bir disk varsa
        if (diskSayisi == 1) {
            // Ustteki diski kaynak'tann hedef'e tasi
            System.out.println("Disk " + diskSayisi + " direk " + kaynak + "'den direk " + hedef + "'e tasi.");
        } else {
            // Ustteki diskSayisi - 1 diski kaynak'tan yardimci'ya, hedef'i yardimci olarak kullanarak tasi
        	coz(diskSayisi - 1, kaynak, yardimci, hedef);
            // Kalan diski kaynak'tan hedef'e tasi
            System.out.println("Disk " + diskSayisi + " direk " + kaynak + "'den direk " + hedef + "'e tasi.");
            // diskSayisi - 1 diski yardimci'dan hedef'e, kaynak'i yardimci olarak kullanarak tasi
            coz(diskSayisi - 1, yardimci, hedef, kaynak);
        }
    }

}
