package tictactoe;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Cok oyunculu bir Tic Tac Toe oyunu icin istemci.
 * TTTP (Tic Tac Toe Protocol) adinda bir protokol kullanir.
 */
public class TicTacToeClient {

	private JFrame frame = new JFrame("Tic Tac Toe"); // Ana pencere
	private JLabel messageLabel = new JLabel("..."); // Bilgi etiketi

	private Square[] board = new Square[9]; // Oyun tahtasi
	private Square currentSquare; // Su anki secili kare

	private Socket socket; // Sunucu ile baglanti
	private Scanner in; // Gelen mesajlar icin
	private PrintWriter out; // Giden mesajlar icin

	// Istemci baslatildiginda sunucuya baglanir
	public TicTacToeClient(String serverAddress) throws Exception {

		socket = new Socket(serverAddress, 58901); // Sunucuya baglan
		in = new Scanner(socket.getInputStream()); // Gelen mesajlari al
		out = new PrintWriter(socket.getOutputStream(), true); // Mesajlari gonder

		messageLabel.setBackground(Color.lightGray); // Bilgi etiketi arka plan rengi
		frame.getContentPane().add(messageLabel, BorderLayout.SOUTH); // Ekranin altina ekle

		// Tahta paneli olustur
		var boardPanel = new JPanel();
		boardPanel.setBackground(Color.black); // Tahta paneli arka plan rengi
		boardPanel.setLayout(new GridLayout(3, 3, 2, 2)); // 3x3 grid yapisi
		for (var i = 0; i < board.length; i++) {
			final int j = i;
			board[i] = new Square(); // Kareleri olustur
			board[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					currentSquare = board[j];
					out.println("MOVE " + j); // Hareket mesajini gonder
				}
			});
			boardPanel.add(board[i]); // Kareyi tahtaya ekle
		}
		frame.getContentPane().add(boardPanel, BorderLayout.CENTER); // Paneli pencereye ekle
	}

	/**
	 * Istemcinin ana thread'i sunucudan gelen mesajlari dinler.
	 * Gelen mesajlara gore oyunun durumu guncellenir.
	 */
	public void play() throws Exception {
		try {
			var response = in.nextLine(); // Ilk mesaji al
			var mark = response.charAt(8); // Oyuncu isaretini al
			var opponentMark = mark == 'X' ? 'O' : 'X'; // Rakip isareti
			frame.setTitle("Tic Tac Toe: Oyuncu " + mark); // Pencere basligini ayarla
			while (in.hasNextLine()) {
				response = in.nextLine(); // Yeni mesajlari al
				if (response.startsWith("VALID_MOVE")) {
					messageLabel.setText("Gecerli hamle, bekleyin"); // Gecerli hamle mesaji
					currentSquare.setText(mark); // Kareye isareti koy
					currentSquare.repaint(); // Ekrani guncelle
				} else if (response.startsWith("OPPONENT_MOVED")) {
					var loc = Integer.parseInt(response.substring(15));
					board[loc].setText(opponentMark); // Rakibin hamlesini tahtada goster
					board[loc].repaint();
					messageLabel.setText("Rakip oynadi, sira sizde");
				} else if (response.startsWith("MESSAGE")) {
					messageLabel.setText(response.substring(8)); // Sunucudan mesaj al
				} else if (response.startsWith("VICTORY")) {
					JOptionPane.showMessageDialog(frame, "Kazandiniz!");
					break; // Oyun biter
				} else if (response.startsWith("DEFEAT")) {
					JOptionPane.showMessageDialog(frame, "Kaybettiniz!");
					break;
				} else if (response.startsWith("TIE")) {
					JOptionPane.showMessageDialog(frame, "Berabere!");
					break;
				} else if (response.startsWith("OTHER_PLAYER_LEFT")) {
					JOptionPane.showMessageDialog(frame, "Rakip oyundan ayrildi");
					break;
				}
			}
			out.println("QUIT"); // Oyundan cikma mesaji gonder
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close(); // Baglantiyi kapat
			frame.dispose(); // Pencereyi kapat
		}
	}

	// Tahta karelerini temsil eden sinif
	static class Square extends JPanel {
		private static final long serialVersionUID = 499000751608489234L;
		JLabel label = new JLabel(); // Karedeki yaziyi gosterir

		public Square() {
			setBackground(Color.white); // Arka plan beyaz
			setLayout(new GridBagLayout());
			label.setFont(new Font("Arial", Font.BOLD, 40)); // Yazinin fontu
			add(label); // Yaziyi kareye ekle
		}

		public void setText(char text) {
			label.setForeground(text == 'X' ? Color.BLUE : Color.RED); // 'X' mavi, 'O' kirmizi
			label.setText(text + ""); // Yaziyi ayarla
		}
	}

	// Ana metot, istemciyi calistirir
	public static void main(String[] args) throws Exception {
		
		TicTacToeClient client = new TicTacToeClient("localhost");
		client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pencereyi kapatma davranisi
		client.frame.setSize(320, 320); // Pencere boyutu
		client.frame.setVisible(true); // Pencereyi gorunur yap
		client.frame.setResizable(false); // Boyutlandirmayi kapat
		client.play(); // Oyunu baslat
	}
}
