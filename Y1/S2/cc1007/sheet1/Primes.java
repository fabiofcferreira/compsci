public class Primes {
  static boolean isPrime(int n) {
    for(int d = 2; d*d <= n; d++) {
      if (n % d == 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int n = 1000;

    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) System.out.println(i);
    }
  }
}