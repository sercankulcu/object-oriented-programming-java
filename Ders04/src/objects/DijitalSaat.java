package objects;

public class DijitalSaat {
	
	private int saat = 0;
	private int dakika = 0;
	private int saniye = 0;
	
	public int getSaniye() {
		return this.saniye;
	}
	
	public void setSaniye(int saniye) {
		if(saniye >= 0 && saniye < 60) {
			this.saniye = saniye;
		}
	}
	
	public void goster() {
		System.out.println(saat + ":" + dakika + ":" + saniye);
	}
	
	private void saatiArttir()
	{
		saat++;
		if(saat > 23)
		{
			saat = 0;
		}
	}
	
	private void dakikayiArttir()
	{
		dakika++;
		if(dakika > 59)
		{
			dakika = 0;
			saatiArttir();
		}
	}
	
	public void saniyeyiArttir()
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
