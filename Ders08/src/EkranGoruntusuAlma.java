// Gerekli Java kutuphaneleri iceri aktar
import java.awt.AWTException; 
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Ekran goruntusunu yakalayan ve kaydeden bir sinif
public class EkranGoruntusuAlma {

    // Ekran goruntusunu yakalayip verilen dosya adiyla kaydeder
    public static void ekranGoruntusuAl(String dosyaAdi) throws AWTException, IOException {
        
        // Ekranin boyutlarini alir
        Dimension ekranBoyutu = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Ekran Boyutu: " + ekranBoyutu);

        // Ekranin tamamini kapsayan bir dikdortgen tanimlanir
        Rectangle ekranDikdortgeni = new Rectangle(ekranBoyutu);

        // Robot nesnesi kullanilarak ekran goruntusu alinir
        Robot robot = new Robot();
        BufferedImage goruntu = robot.createScreenCapture(ekranDikdortgeni);

        // Ekran goruntusu verilen dosya adiyla kaydedilir
        ImageIO.write(goruntu, "png", new File(dosyaAdi));
    }

    // Programin giris noktasi
    public static void main(String[] args) throws AWTException, IOException {
        // Ekran goruntusunu al ve "ekran.png" dosyasina kaydet
        ekranGoruntusuAl("ekran.png");
    }
}
