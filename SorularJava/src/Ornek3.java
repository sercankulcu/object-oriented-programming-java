
public class Ornek3 {
    private String renk;
    
    public Ornek3() {
        this("beyaz");
    }
    
    public Ornek3(String renk) {
        this.renk = renk;
    }
    
    public static void main(String[] args) {
        Ornek3 e = new Ornek3();
        System.out.println("Renk:" + e.renk);
        Ornek3 ee = new Ornek3("kırmızı");
        System.out.println("Renk:" + ee.renk);
    }
}
