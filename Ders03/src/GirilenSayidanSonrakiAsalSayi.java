
import java.util.Scanner;

public class GirilenSayidanSonrakiAsalSayi {

	boolean asalMi(int sayi)
	{
		for(int i = 2; i < sayi; i++)
		{
			if(sayi % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		GirilenSayidanSonrakiAsalSayi asalSayiBulucu = new GirilenSayidanSonrakiAsalSayi();
		Scanner okuyucu = new Scanner(System.in);
		System.out.println("Bir sayı giriniz");
		int sayi = okuyucu.nextInt();
		okuyucu.close();
		System.out.println("Girilen sayi: " + sayi);

		while(true)
		{
			if(asalSayiBulucu.asalMi(++sayi) == true)
			{
				System.out.println(sayi + " asal sayıdır");
				break;
			}
			else
			{
				System.out.println(sayi + " asal sayı değildir");
			}
		}
	}
}
