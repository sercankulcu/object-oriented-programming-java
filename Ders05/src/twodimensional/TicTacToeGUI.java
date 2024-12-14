package twodimensional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {

    private JFrame cerceve; // Ana pencere cercevesi
    private JButton[][] butonlar; // Oyun tahtasindaki butonlar
    private char mevcutOyuncu; // Siradaki oyuncunun sembolu ('X' veya 'O')

    public TicTacToeGUI() {
        cerceve = new JFrame("Tic-Tac-Toe"); // Pencere basligi
        butonlar = new JButton[3][3]; // 3x3 boyutunda buton dizisi olusturuluyor
        mevcutOyuncu = 'X'; // Ilk baslayan oyuncu 'X'
        arayuzuBaslat(); // Arayuzu baslatan metot cagriliyor
    }

    private void arayuzuBaslat() {
        cerceve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerceve kapandiginda uygulamayi sonlandir
        cerceve.setSize(400, 400); // Pencere boyutunu ayarla
        cerceve.setLayout(new GridLayout(3, 3)); // 3x3 izgara duzeni

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                butonlar[i][j] = new JButton(" "); // Her buton baslangicta bos olacak
                butonlar[i][j].setFont(new Font("Arial", Font.PLAIN, 60)); // Buton fontu ve boyutu
                cerceve.add(butonlar[i][j]); // Butonu cerceveye ekle

                final int satir = i; // Satir bilgisi
                final int sutun = j; // Sutun bilgisi
                butonlar[i][j].addActionListener(new ActionListener() { // Butona tiklama dinleyicisi ekleniyor
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        butonaTiklamaIsle(satir, sutun); // Tiklama islemi icin metot cagriliyor
                    }
                });
            }
        }

        cerceve.setVisible(true); // Pencereyi gorunur yap
    }

    private void butonaTiklamaIsle(int satir, int sutun) {
        // Eger buton bossa islem yap
        if (butonlar[satir][sutun].getText().equals(" ")) {
            butonlar[satir][sutun].setText(String.valueOf(mevcutOyuncu)); // Mevcut oyuncunun sembolunu yerlestir
            if (kazanmaKontrolu()) {
                // Oyuncu kazandiysa mesaj goster ve tahtayi sifirla
                JOptionPane.showMessageDialog(cerceve, "Tebrikler, " + mevcutOyuncu + " kazandi!");
                tahtayiSifirla();
            } else if (beraberlikKontrolu()) {
                // Oyun berabere bittiginde mesaj goster ve tahtayi sifirla
                JOptionPane.showMessageDialog(cerceve, "Oyun berabere bitti!");
                tahtayiSifirla();
            } else {
                // Siradaki oyuncuyu degistir
                mevcutOyuncu = (mevcutOyuncu == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean kazanmaKontrolu() {
        // Satir, sutun ve capraz kazanma durumlarini kontrol et
        for (int i = 0; i < 3; i++) {
            // Satir kontrolu
            if (butonlar[i][0].getText().equals(String.valueOf(mevcutOyuncu)) &&
                butonlar[i][1].getText().equals(String.valueOf(mevcutOyuncu)) &&
                butonlar[i][2].getText().equals(String.valueOf(mevcutOyuncu))) {
                return true;
            }
            // Sutun kontrolu
            if (butonlar[0][i].getText().equals(String.valueOf(mevcutOyuncu)) &&
                butonlar[1][i].getText().equals(String.valueOf(mevcutOyuncu)) &&
                butonlar[2][i].getText().equals(String.valueOf(mevcutOyuncu))) {
                return true;
            }
        }
        // Capraz kontrolu
        if (butonlar[0][0].getText().equals(String.valueOf(mevcutOyuncu)) &&
            butonlar[1][1].getText().equals(String.valueOf(mevcutOyuncu)) &&
            butonlar[2][2].getText().equals(String.valueOf(mevcutOyuncu))) {
            return true;
        }
        if (butonlar[0][2].getText().equals(String.valueOf(mevcutOyuncu)) &&
            butonlar[1][1].getText().equals(String.valueOf(mevcutOyuncu)) &&
            butonlar[2][0].getText().equals(String.valueOf(mevcutOyuncu))) {
            return true;
        }
        return false; // Hicbir kazanma durumu bulunmadi
    }

    private boolean beraberlikKontrolu() {
        // Tum hucreler doluysa ve kazanan yoksa beraberlik
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (butonlar[i][j].getText().equals(" ")) {
                    return false; // Bos hucre bulundu, oyun devam edebilir
                }
            }
        }
        return true; // Tum hucreler dolu, oyun berabere
    }

    private void tahtayiSifirla() {
        // Tum hucreleri sifirla ve baslangic oyuncusunu 'X' yap
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                butonlar[i][j].setText(" ");
            }
        }
        mevcutOyuncu = 'X';
    }

    public static void main(String[] args) {
        new TicTacToeGUI(); // Uygulamayi baslat
    }
}
