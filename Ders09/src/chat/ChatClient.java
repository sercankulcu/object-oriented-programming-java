package chat; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ChatClient {

    String serverAddress; // Sunucu adresi
    Scanner in; // Girdi akisi
    PrintWriter out; // Cikti akisi
    JFrame frame = new JFrame("Chatter"); // Chat penceresi
    JTextField textField = new JTextField(50); // Mesaj girmek icin alan
    JTextArea messageArea = new JTextArea(16, 50); // Mesajlari gosteren alan

    // Constructor: ChatClient nesnesi olusturur
    public ChatClient(String serverAddress) {
        this.serverAddress = serverAddress;

        textField.setEditable(false); // Mesaj girmek baslangicta kapali
        messageArea.setEditable(false); // Mesajlari gormek icin alani degistirilemez
        frame.getContentPane().add(textField, BorderLayout.SOUTH); // Mesaj girme alanini ekler
        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER); // Mesajlari gosterme alanini ekler
        frame.pack();

        // Enter tusuna basildiginda mesaj gonderir, sonra textField'i temizler
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText()); // Mesaji server'a gonder
                textField.setText(""); // Girdiyi temizle
            }
        });
    }

    // Kullaniciya ekran ismi secmesi icin dialog penceresi gosterir
    private String getName() {
        return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
    }

    // Chat client'ini baslatan ana metod
    private void run() throws IOException {
        try (var socket = new Socket(serverAddress, 59001)) { // Sunucuya baglanir
            in = new Scanner(socket.getInputStream()); // Sunucudan veri alir
            out = new PrintWriter(socket.getOutputStream(), true); // Sunucuya veri gonderir

            // Sunucudan gelen her satir icin islemleri yapar
            while (in.hasNextLine()) {
                var line = in.nextLine(); // Gelen satiri al
                if (line.startsWith("SUBMITNAME")) { // Ekran ismi istegini alir
                    out.println(getName()); // Kullaniciya ekran ismini sorar
                } else if (line.startsWith("NAMEACCEPTED")) { // Isim kabul edildiginde
                    this.frame.setTitle("Chatter - " + line.substring(13)); // Frame basligini gunceller
                    textField.setEditable(true); // Mesaj girmeye izin verir
                } else if (line.startsWith("MESSAGE")) { // Mesaj geldiyse
                    messageArea.append(line.substring(8) + "\n"); // Mesaji ekler
                }
            }
        } finally {
            frame.setVisible(false); // Frame'i gizler
            frame.dispose(); // Frame'i kapatir
        }
    }

    // Programi baslatan main metod
    public static void main(String[] args) throws Exception {

        var client = new ChatClient("localhost"); // Client'i olustur
        client.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cikis yapildiginda programi kapat
        client.frame.setVisible(true); // Frame'i gorunur hale getir
        client.run(); // Chat client'ini calistir
    }
}
