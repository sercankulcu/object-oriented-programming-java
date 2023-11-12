package Sorular;

public class MatematikFonksiyonlari {
  public static void intToplaminaEkle(int x, int eklenenMiktar) {
      x = x + eklenenMiktar;
  }

  public static void main(String[] args) {
      var a = 15;
      var b = 10;
      MatematikFonksiyonlari.intToplaminaEkle(a, b);
      System.out.println(a);
  }
}
