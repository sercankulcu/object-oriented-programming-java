package tictactoe;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * Cok oyunculu bir Tic Tac Toe oyunu icin sunucu.
 * TTTP (Tic Tac Toe Protocol) adinda bir protokol kullanir.
 */
public class TicTacToeServer {

    public static void main(String[] args) throws Exception {
    	
        try (var listener = new ServerSocket(58901)) {
            System.out.println("Tic Tac Toe Sunucusu Calisiyor...");
            var pool = Executors.newFixedThreadPool(200); // Maksimum 200 oyuncu desteklenir
            while (true) {
                Game game = new Game();
                // Iki oyuncuyu bagla: biri 'X', digeri 'O'
                pool.execute(game.new Player(listener.accept(), 'X'));
                pool.execute(game.new Player(listener.accept(), 'O'));
            }
        }
    }
}

class Game {

    // Tahta hucreleri 0-8 ile numaralandirilmis; bos hucreler null'dir
    private Player[] board = new Player[9];
    Player currentPlayer; // Su anki oyuncu

    // Kazanma durumunu kontrol eder
    public boolean hasWinner() {
        return (board[0] != null && board[0] == board[1] && board[0] == board[2]) // Ust satir
                || (board[3] != null && board[3] == board[4] && board[3] == board[5]) // Orta satir
                || (board[6] != null && board[6] == board[7] && board[6] == board[8]) // Alt satir
                || (board[0] != null && board[0] == board[3] && board[0] == board[6]) // Sol sutun
                || (board[1] != null && board[1] == board[4] && board[1] == board[7]) // Orta sutun
                || (board[2] != null && board[2] == board[5] && board[2] == board[8]) // Sag sutun
                || (board[0] != null && board[0] == board[4] && board[0] == board[8]) // Capraz (sol ustten sag alta)
                || (board[2] != null && board[2] == board[4] && board[2] == board[6]); // Capraz (sag ustten sol alta)
    }

    // Tahtanin tamamen dolup dolmadigini kontrol eder
    public boolean boardFilledUp() {
        return Arrays.stream(board).allMatch(p -> p != null); // Tum hucreler doluysa true doner
    }

    // Oyuncunun hamlesini isler
    public synchronized void move(int location, Player player) {
        if (player != currentPlayer) {
            throw new IllegalStateException("Sira sizde degil"); // Hatali sirada hamle denemesi
        } else if (player.opponent == null) {
            throw new IllegalStateException("Henuz bir rakibiniz yok"); // Rakip baglanmadiysa
        } else if (board[location] != null) {
            throw new IllegalStateException("Bu hucre zaten dolu"); // Hucre doluysa
        }
        board[location] = currentPlayer; // Hucreye hamleyi yerlestir
        currentPlayer = currentPlayer.opponent; // Sira rakibe gecer
    }

    /**
     * Oyuncu sinifi, oyuncunun karakterini (X veya O) ve baglanti bilgilerini icerir.
     */
    class Player implements Runnable {
    	
        char mark; // Oyuncunun isareti ('X' veya 'O')
        Player opponent; // Rakip oyuncu
        Socket socket; // Oyuncunun baglantisi
        Scanner input; // Gelen veri okuyucusu
        PrintWriter output; // Giden veri yazicisi

        public Player(Socket socket, char mark) {
            this.socket = socket;
            this.mark = mark;
        }

        @Override
        public void run() {
            try {
                setup(); // Oyunu kur
                processCommands(); // Gelen komutlari isle
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (opponent != null && opponent.output != null) {
                    opponent.output.println("OTHER_PLAYER_LEFT"); // Rakibe oyuncunun ayrildigini bildir
                }
                try {
                    socket.close(); // Oyuncunun baglantisini kapat
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Oyuncunun baglantisini kurar ve oyun icin hazirlar
        private void setup() throws IOException {
            input = new Scanner(socket.getInputStream());
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("WELCOME " + mark); // Oyuncuya hos geldin mesaji gonder
            if (mark == 'X') {
                currentPlayer = this; // Ilk hamle 'X' oyuncusuna verilir
                output.println("MESSAGE Rakibin baglanmasi bekleniyor...");
            } else {
                opponent = currentPlayer; // Rakip 'X' oyuncusudur
                opponent.opponent = this; // 'X' oyuncusuna rakip olarak 'O' atanir
                opponent.output.println("MESSAGE Hamle sira sizde");
            }
        }

        // Oyuncunun gonderdigi komutlari dinler ve isler
        private void processCommands() {
            while (input.hasNextLine()) {
                var command = input.nextLine();
                if (command.startsWith("QUIT")) { // Oyuncu cikmak istediginde
                    return;
                } else if (command.startsWith("MOVE")) { // Oyuncunun hamle yaptigi durumda
                    processMoveCommand(Integer.parseInt(command.substring(5)));
                }
            }
        }

        // Oyuncunun gonderdigi hamle komutunu isler
        private void processMoveCommand(int location) {
            try {
                move(location, this); // Hamleyi isler
                output.println("VALID_MOVE"); // Gecerli hamle mesaji
                opponent.output.println("OPPONENT_MOVED " + location); // Rakibe hamleyi bildir
                if (hasWinner()) {
                    output.println("VICTORY"); // Kazanma durumu
                    opponent.output.println("DEFEAT"); // Kaybetme durumu
                } else if (boardFilledUp()) {
                    output.println("TIE"); // Beraberlik durumu
                    opponent.output.println("TIE");
                }
            } catch (IllegalStateException e) {
                output.println("MESSAGE " + e.getMessage()); // Hata mesaji gonder
            }
        }
    }
}
