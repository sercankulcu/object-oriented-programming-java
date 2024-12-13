import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Hesap Makinesi GUI uygulamasi
public class HesapMakinesi extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JTextField metinKutusu; // Sayi ve sonuclarin gosterilecegi metin kutusu
    private String operator; // Secilen matematiksel operator (+, -, x, /)
    private double birinciSayi; // Ilk operand
    private boolean operatorTiklandi; // Operator secildiginde durumu tutar

    // Yapici metot: Arayuz olusturulur
    public HesapMakinesi() {
        setTitle("Hesap Makinesi"); // Pencere basligi
        setSize(300, 400); // Pencere boyutu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cikis islemi
        setLayout(new BorderLayout()); // Cerceve duzeni

        operator = "";
        birinciSayi = 0;
        operatorTiklandi = false;

        // Metin kutusunu olustur ve ust bolgeye ekle
        metinKutusu = new JTextField();
        metinKutusu.setEditable(false); // Kullanici dogrudan metin kutusuna yazamaz
        metinKutusu.setFont(new Font("Arial", Font.PLAIN, 24)); // Daha buyuk bir yazi tipi
        metinKutusu.setPreferredSize(new Dimension(0, 50)); // Metin kutusunun yuksekligini arttir
        add(metinKutusu, BorderLayout.NORTH);

        // Buton panelini olustur
        JPanel butonPaneli = new JPanel();
        butonPaneli.setLayout(new GridLayout(4, 4)); // 4x4 duzen

        // Butonlarin metinlerini tanimla
        String[] butonlar = {
                "7", "8", "9", "/",
                "4", "5", "6", "x",
                "1", "2", "3", "-",
                "0", "AC", "=", "+"
        };

        // Her buton icin dongu ile islem yap
        for (String buton : butonlar) {
            JButton btn = new JButton(buton); // Butonu olustur
            btn.addActionListener(new ButonTiklamaDinleyicisi()); // Tiklama olayini dinle
            butonPaneli.add(btn); // Butonu panele ekle
        }

        add(butonPaneli, BorderLayout.CENTER); // Buton panelini orta bolgeye ekle
    }

    // Butonlara tiklandiginda yapilacak islemler
    private class ButonTiklamaDinleyicisi implements ActionListener {
    	
        public void actionPerformed(ActionEvent e) {
        	
            String komut = e.getActionCommand(); // Tiklanan butonun metni alinir

            if (komut.matches("[0-9]")) { // Eger bir sayi ise
                if (operatorTiklandi) { // Eger daha once operator tiklandiysa
                    metinKutusu.setText(""); // Metin kutusunu temizle
                    operatorTiklandi = false;
                }
                metinKutusu.setText(metinKutusu.getText() + komut); // Sayiyi ekle
            } else if (komut.equals("AC")) { // Eger "AC" (Temizle) tiklandiysa
                metinKutusu.setText(""); // Metin kutusunu temizle
            } else if (komut.matches("[+\\-x/]")) { // Eger bir operator tiklandiysa
                operator = komut; // Operatoru kaydet
                birinciSayi = Double.parseDouble(metinKutusu.getText()); // Ilk sayiyi kaydet
                operatorTiklandi = true; // Operator tiklandigini isaretle
            } else if (komut.equals("=")) { // Eger "=" tiklandiysa
                double ikinciSayi = Double.parseDouble(metinKutusu.getText()); // Ikinci sayiyi al
                double sonuc = 0; // Sonuc degiskeni

                // Operatore gore islem yap
                switch (operator) {
                    case "+":
                        sonuc = birinciSayi + ikinciSayi;
                        break;
                    case "-":
                        sonuc = birinciSayi - ikinciSayi;
                        break;
                    case "x":
                        sonuc = birinciSayi * ikinciSayi;
                        break;
                    case "/":
                        sonuc = birinciSayi / ikinciSayi;
                        break;
                }

                metinKutusu.setText(String.valueOf(sonuc)); // Sonucu goster
                operatorTiklandi = true; // Yeni islem icin hazirla
            }
        }
    }

    // Ana metot: Uygulamayi baslatir
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HesapMakinesi hesapMakinesi = new HesapMakinesi(); // Hesap makinesi olustur
                hesapMakinesi.setVisible(true); // Gorunur yap
            }
        });
    }
}
