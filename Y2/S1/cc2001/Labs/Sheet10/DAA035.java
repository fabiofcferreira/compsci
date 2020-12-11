import java.util.*;

public class DAA035{
	static void floydMarshall(int[][] matrix, int n) {
    boolean[][] connected = new boolean[n][n];
    for (int i = 0; i < n; i++)
      connected[i][i] = true;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        if(matrix[i][j] == 1) connected[i][j] = true;
    }
    
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++)
          if (connected[i][k] && connected[k][j]) connected[i][j] = true;
      }
    }
    
    System.out.print(" ");
    for (int i = 0; i < n; i++) {
      int tmp = 'A' + i;
      char c = (char) tmp;

      System.out.print(" " + c);
    }
    System.out.println();

		for (int i = 0; i < n; i++) {
			int tmp = 'A' + i;
      char a = (char) tmp;
      System.out.print(a);

      for (int j = 0; j < n; j++) {
        if (connected[i][j]) System.out.print(" 1");
        else System.out.print(" 0");
		  }

      System.out.println();
    }
  }

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		int n = in.nextInt();
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			char c = in.next().charAt(0);
			int pos1 = c - 'A';
			int numDist = in.nextInt();
			
      for (int j = 0; j < numDist; j++) {
				int pos2 = in.next().charAt(0) - 'A';
				matrix[pos1][pos2] = 1;
			}
		}

		floydMarshall(matrix, n);
	}
}