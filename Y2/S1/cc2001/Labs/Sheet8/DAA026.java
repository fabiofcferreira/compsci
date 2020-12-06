import java.util.*;

public class DAA026 {
  static int cases;
  static int rows;
  static int columns;
  static boolean map[][];

  static int currentBlobSize;
  static int maximumBlobSize;
  static boolean visited[][];

  static void dfs(int x, int y) {
    if (!(x >= 0 && x < rows && y >= 0 && y < columns)) return;

    if (!visited[x][y]) {
      visited[x][y] = true;

      if (map[x][y]) {
        currentBlobSize++;

        // Left and right
        dfs(x+1, y);
        dfs(x-1, y);

        // Up and down
        dfs(x, y+1);
        dfs(x, y-1);

        // Diagonal
        dfs(x-1, y-1);
        dfs(x+1, y-1);
        dfs(x-1, y+1);
        dfs(x+1, y+1);
      }
    }
  }

  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);

    String line;

    // Read number of cases
    cases = in.nextInt();
    for (int i = 0; i < cases; i++) {
      rows = in.nextInt();
      columns = in.nextInt();
      maximumBlobSize = 0;

      // Create graph map and visited map
      map = new boolean[rows][columns];
      visited = new boolean[rows][columns];
      for (int r = 0; r < rows; r++) {
        line = in.nextLine();

        for (int c = 0; c < columns; c++) {
          if (line.charAt(c) == '.') map[r][c] = false;
          else map[r][c] = true;
        }
      }
      
      // Start DFS on all unvisited occupied cells
      int blobCounter = 1;
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < columns; c++) {
          if (!visited[r][c] && map[r][c]) {
            currentBlobSize = 0;
            dfs(r, c);
            
            // Update current map's maximum blob size
            maximumBlobSize = Math.max(maximumBlobSize, currentBlobSize);
          }
        }
      }
      
      // Print maximum blob size
      FastPrint.out.println(maximumBlobSize);
    }

    FastPrint.out.close();
  }
}
