// Banka ornegi icin ozel istisna: mesajin yaninda eksik tutari da tasir.
class YetersizBakiyeHatasi extends Exception {
	private static final long serialVersionUID = 1L;   // -Xlint serial uyarisi icin eklendi
	private double eksik;

	public YetersizBakiyeHatasi(String mesaj, double eksik) {
		super(mesaj);          // mesaj Throwable'da saklanir
		this.eksik = eksik;
	}

	public double getEksik() {
		return eksik;
	}
}
