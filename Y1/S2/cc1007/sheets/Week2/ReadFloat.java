import java.util.Scanner;

public class ReadFloat {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    float a = sc.nextFloat();
    float b = sc.nextFloat();

    sc.close();

    System.out.println(a + b);
  }
}