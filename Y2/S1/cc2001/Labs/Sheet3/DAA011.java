public class DAA011 {
  public static void main(String[] args) {
    int n = 0;
    int[] distances;
    int q = 0;
    int qDays = 0;

    int sum = 0;

    FastScanner in = new FastScanner(System.in);

    n = in.nextInt();
    distances = new int[n];
    for (int i = 0; i < n; i++) {
      distances[i] = in.nextInt();

      sum += distances[i];
    }

    FastPrint.out.println(sum);

    q = in.nextInt();
    for (int i = 0; i < q; i++) {
      qDays = in.nextInt();

      FastPrint.out.println(qDays);
    }

    FastPrint.out.close();
  }
}
