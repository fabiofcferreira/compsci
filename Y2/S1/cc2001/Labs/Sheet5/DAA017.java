public class DAA017 {
  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int lines = 0;
    int d = 0;
    long[][] paths;
    boolean[][] deteriorated;

    int rockLayer = 0, rockIndex = 0;

    // Read number of layers
    lines = in.nextInt();
    deteriorated = new boolean[lines][lines];
    paths = new long[lines][lines];

    // Read number of deteriorated rocks
    d = in.nextInt();
    for (int i = 0; i < d; i++) {
      rockLayer = in.nextInt();
      rockIndex = in.nextInt();

      deteriorated[lines - rockLayer][rockIndex-1] = true;
    }

    for (int i = lines-1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        if (deteriorated[i][j]) paths[i][j] = 0;
        else if (i == lines-1) paths[i][j] = 1;
        else paths[i][j] = paths[i][j] + paths[i+1][j] + paths[i+1][j+1];
      }
    }

    FastPrint.out.println(paths[0][0]);
    FastPrint.out.close();
  }
}
