public class Sieve {
  static boolean isPrime(int n) {
    for(int d = 2; d*d <= n; d++) {
      if (n % d == 0) {
        return false;
      }
    }

    return true;
  }

  static void sieve(int n, boolean prime[]) {
    // all values are initially thought to be primes
    for (int i = 0; i <= n; i++) {
      prime[i] = true;
    }

    for(int a = 2; a <= n; a++) {
      if (prime[a] == true) {
        System.out.println("New base:" + a);
        int base = a;
        
        // find multiples from a to n
        for (int b = base+1; b <= n; b++) {
          if (b % base == 0) {
            System.out.println(base + " divides " +  b + ".");

            prime[b] = false;
          } 
        }
      }
    }
  }

  public static void main(String[] args) {
    int n = 1000;

    boolean[] prime = new boolean[n+1];

    sieve(n, prime);

    for (int i = 2; i <= n; i++) {
      if (prime[i]) System.out.println(i + ": " + prime[i]);
    }
  }
}