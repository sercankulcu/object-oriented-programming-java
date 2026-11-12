import javax.swing.*;

// JTextArea ve JScrollPane: cok satirli metin alani, setText/append ve satir sayisi.
// Pencere acilmaz; metin alani yalnizca bellekte olusturulur.
public class MetinAlaniOrnegi {
	public static void main(String[] args) {
		JTextArea alan = new JTextArea(5, 20);
		alan.setText("Birinci satir\n");
		alan.append("Ikinci satir\n");
		JScrollPane kaydirma = new JScrollPane(alan);
		System.out.print(alan.getText());
		System.out.println(alan.getLineCount());
		// Birinci satir
		// Ikinci satir
		// 3   (sondaki satir sonundan sonraki bos satir da sayilir)
		System.out.println(kaydirma.getViewport().getView() == alan);  // true
	}
}

/* Beklenen cikti:
Birinci satir
Ikinci satir
3
true
*/
