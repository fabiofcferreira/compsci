// Classe principal com a função main
public class TestGeometry {
   public static void main (String[] args){
      Point p1 = new Point();
	
      System.out.println("p1 original: " + p1);
      p1.x = 1;
      System.out.println("p1 modificado: " + p1);

      Point p2 = new Point(2,3);
      System.out.println("p2: " + p2);
   }
}