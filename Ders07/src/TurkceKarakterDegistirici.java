import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class TurkceKarakterDegistirici {

    // Dosyaların ve klasörlerin rekürsif olarak kontrol edilmesi için metod
    public static void dosyalariTarama(File klasor) {
        // Klasördeki tüm dosyaları ve alt klasörleri al
        File[] dosyalar = klasor.listFiles();

        if (dosyalar != null) {
            // Her bir dosya veya klasör üzerinde işlem yap
            for (File dosya : dosyalar) {
                // Eğer bu bir klasörse, rekürsif olarak içine gir
                if (dosya.isDirectory()) {
                    dosyalariTarama(dosya);  // Rekürsif çağrı
                } else if (dosya.isFile() && dosya.getName().endsWith(".java") && !dosya.getName().startsWith("Turkce")) {
                    try {
                        // Dosyanın içeriğini satır satır oku
                        List<String> satirlar = Files.readAllLines(dosya.toPath(), StandardCharsets.UTF_8);
                        boolean degisiklikYapildi = false;

                        // Her satırı kontrol et
                        for (int i = 0; i < satirlar.size(); i++) {
                            String orijinalSatir = satirlar.get(i);
                            // Türkçe karakterleri değiştirmek için satırı düzenle
                            String degistirilmisSatir = orijinalSatir
                                .replace("ü", "u")
                                .replace("Ü", "U")
                                .replace("ğ", "g")
                                .replace("Ğ", "G")
                                .replace("ı", "i")
                                .replace("İ", "I")
                                .replace("ş", "s")
                                .replace("Ş", "S")
                                .replace("ç", "c")
                                .replace("Ç", "C")
                                .replace("ö", "o")
                                .replace("Ö", "O");

                            // Eğer satırda bir değişiklik yapıldıysa
                            if (!orijinalSatir.equals(degistirilmisSatir)) {
                                satirlar.set(i, degistirilmisSatir);  // Satırı değiştirdik
                                // Değişiklik yapılan satırı ekrana yazdır
                                System.out.println("Dosya: " + dosya.getAbsolutePath() + " - Satır " + (i + 1) + " değiştirildi.");
                                degisiklikYapildi = true;
                            }
                        }

                        // Eğer herhangi bir değişiklik yapılmışsa, dosyayı güncelle
                        if (degisiklikYapildi) {
                            Files.write(dosya.toPath(), satirlar, StandardCharsets.UTF_8);
                        }
                    } catch (IOException e) {
                        // Hata durumunda ekrana hata mesajı yazdır
                        System.out.println("Hata: " + e.getMessage());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Bulunduğunuz dizinin bir üst dizini
        File klasor = new File(System.getProperty("user.dir")).getParentFile();
        // Üst dizindeki dosyaları ve klasörleri taramak için metodu çağır
        dosyalariTarama(klasor);
    }
}