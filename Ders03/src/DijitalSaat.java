
public class DijitalSaat {
	
	int saat = 23;
	int dakika = 59;
	int saniye = 10;
	
	void goster() {
		System.out.println(saat + ":" + dakika + ":" + saniye);
	}
	
	void saatiArttir()
	{
		saat++;
		if(saat > 23)
		{
			saat = 0;
		}
	}
	
	void dakikayiArttir()
	{
		dakika++;
		if(dakika > 59)
		{
			dakika = 0;
			saatiArttir();
		}
	}
	
	void saniyeyiArttir()
	{
		saniye++;
		if(saniye > 59)
		{
			saniye = 0;
			dakikayiArttir();
		}
	}
	
	public static void main(String[] args)
	{
		DijitalSaat saat = new DijitalSaat();
		for(int i = 0; i < 70; i++) {
			saat.saniyeyiArttir();
			saat.goster();
		}
	}
}
