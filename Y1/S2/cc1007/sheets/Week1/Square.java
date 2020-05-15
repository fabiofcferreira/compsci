public class Square {
  public static void line(char a, char b, int length) {
    System.out.print(a);

    for (int i = 0; i < length - 1; i++) System.out.print(b);

    System.out.println(a);
  }

  public static void square(int sideLength) {
    line('*', '-', sideLength);

    for (int i = 1; i < sideLength - 1; i++) line('|', '.', sideLength);
    
    line('*', '-', sideLength);
  }

  public static void main(String[] args) {
    square(5);
  }
}