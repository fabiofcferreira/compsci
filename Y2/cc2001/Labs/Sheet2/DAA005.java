public class DAA005 {
  static int n;
  static int[] energies;
  static int[] sum;

  static int f;


  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    n = in.nextInt();
    energies = new int[n];
    sum = new int[n+1];

    for (int i = 0; i < n; i++) {
      energies[i] = in.nextInt();
      sum[i+1] = energies[i] + sum[i];
    }

    f = in.nextInt();
    for (int i = 0; i < f; i++) {
      int start = in.nextInt();
      int end = in.nextInt();

      FastPrint.out.println(sum[end] - sum[start-1]);
    }

    FastPrint.out.close();
  }
}
