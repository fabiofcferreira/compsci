import java.lang.Math;
import java.util.Scanner;


public class DAA002 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int tests = in.nextInt();

    for (int i = 0; i < tests; i++) {
      int n = in.nextInt();
      int k = in.nextInt();

      int number = n+1;
      while (digitSum(number) != k) {
        number++;
      }

      System.out.println(number);
    }
  }

  public static int digitSum(int number) {
    int n = number;
    int sum = 0;

    while (n != 0) {
      sum += n % 10;
      n /= 10;
    }

    return sum;
  }
}
