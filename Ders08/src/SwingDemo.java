import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class SwingDemo {

    public static void main(String[] args) {
        // Yeni bir JFrame (pencere) olustur
        JFrame frame = new JFrame("Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pencere kapandiginda uygulama sonlansin
        frame.setSize(600, 600); // Pencere boyutunu ayarla
        frame.setLocationRelativeTo(null); // Pencereyi ekranin ortasina yerlestir

        // Yeni bir JPanel (container - konteyner) olustur ve duzeni ayarla
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Dikey yerlesim
        panel.setBackground(new Color(240, 240, 240)); // Acik gri arka plan

        // Paneli tasimasi icin bir JScrollPane ekle
        JScrollPane scrollPane = new JScrollPane(panel);

        // Metin gostermek icin bir JLabel olustur
        JLabel label = new JLabel("Swing'e Hos Geldiniz!");
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortalanmis yazi
        label.setFont(new Font("Arial", Font.BOLD, 18)); // Etiket fontunu ayarla
        label.setForeground(new Color(50, 50, 50)); // Yazi rengini koyu gri yap
        label.setBorder(new EmptyBorder(10, 0, 20, 0)); // Etiketin ustune ve altina bosluk ekle

        // Kullanicidan metin almak icin bir JTextField (metin alani) olustur
        JTextField textField = new JTextField(15); // 15 karakter uzunlugunda bir alan
        textField.setToolTipText("Bir mesaj yazin");
        textField.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya yerlestir
        textField.setFont(new Font("Arial", Font.PLAIN, 16)); // Fontu ayarla
        textField.setBackground(Color.WHITE); // Arka plan rengini beyaz yap
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Kenarlik ekle

        // Bir JComboBox (acilir liste) olustur
        String[] colors = {"Kirmizi", "Yesil", "Mavi", "Sari"};
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        colorComboBox.setToolTipText("Bir renk secin");
        colorComboBox.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya yerlestir
        colorComboBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Fontu ayarla
        colorComboBox.setBackground(new Color(255, 255, 255)); // Arka plani beyaz yap
        colorComboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Kenarlik ekle

        // Bir JCheckBox (onay kutusu) olustur
        JCheckBox checkBox = new JCheckBox("Mesaji gizle");
        checkBox.setToolTipText("Mesaji gizlemek icin tiklayin");
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya yerlestir
        checkBox.setFont(new Font("Arial", Font.PLAIN, 16)); // Fontu ayarla

        // Bir JButton olustur
        JButton button = new JButton("Beni Tikla!");
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya yerlestir
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Buton fontunu ayarla
        button.setBackground(new Color(60, 179, 113)); // Buton arka plan rengini yesil yap
        button.setForeground(Color.WHITE); // Buton yazi rengini beyaz yap
        button.setFocusPainted(false); // Butonun odak cizgisi olmasin
        button.setBorder(BorderFactory.createRaisedBevelBorder()); // Yukseltilmis kenarlik ekle

        // JButton tiklandiginda yapilacak islem
        button.addActionListener(e -> {
            String text = textField.getText(); // JTextField'den girilen metni al
            String selectedColor = (String) colorComboBox.getSelectedItem(); // JComboBox'dan secilen rengi al
            boolean mesajiGizle = checkBox.isSelected(); // JCheckBox'tan secili olup olmadigini kontrol et

            if (mesajiGizle) {
                label.setText("Mesaj Gizlendi!");
            } else {
                label.setText("Girilen Mesaj: " + text + " | Secilen Renk: " + selectedColor);
            }
        });

        // Bilesenleri panel'e ekle
        panel.add(label);
        panel.add(Box.createVerticalStrut(20)); // Araya bosluk ekle
        panel.add(textField);
        panel.add(Box.createVerticalStrut(10)); // Araya bosluk ekle
        panel.add(colorComboBox);
        panel.add(Box.createVerticalStrut(10)); // Araya bosluk ekle
        panel.add(checkBox);
        panel.add(Box.createVerticalStrut(10)); // Araya bosluk ekle
        panel.add(button);

        // Paneli frame'e ekle
        frame.add(scrollPane);

        // Pencereyi gorunur hale getir
        frame.setVisible(true);
    }
}
