import java.util.Scanner;

public class ed183 {
  public static void main(String[] args) {
    int nOperands = 0;
    float sum = 0;
    int min = 1000000;
    int max = -1000000;

    Scanner sc = new Scanner(System.in);

    // read number of operands
    nOperands = sc.nextInt();

    // read operands values
    for (int i = 0; i < nOperands; i++) {
      int a = sc.nextInt();

      if (a < min) {
        min = a;
      }
      if (a > max) {
        max = a;
      }

      sum += a;
    }

    System.out.printf("%.2f\n", sum / nOperands);
    System.out.println(Math.abs(max - min));

    sc.close();
  }
}