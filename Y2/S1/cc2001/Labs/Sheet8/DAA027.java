import java.util.*;

public class DAA027 {
  static int cases;
  static int nodes;
  static int edges;

  static boolean adj[][];
  static boolean visited[];
  static int colors[];

  static boolean dfs(int v) {
    for (int i = 1; i <= nodes; i++) {
      if (adj[v][i]) {
        if (!visited[i]) {
          visited[i] = true;
          colors[i] = colors[v] == 1 ? 2 : 1;

          if (!dfs(i)) return false;
        } else if (colors[i] == colors[v]) return false;
      }
    }

    return true;
  }

  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);

    // Read number of cases
    cases = in.nextInt();
    for (int i = 0; i < cases; i++) {
      nodes = in.nextInt();
      edges = in.nextInt();
      
      adj = new boolean[nodes+1][nodes+1];
      visited = new boolean[nodes+1];
      colors = new int[nodes+1];

      // Read edges
      for (int e = 0; e < edges; e++) {
        int a = in.nextInt();
        int b = in.nextInt();

        adj[a][b] = adj[b][a] = true;
      }

      // Set first node color and visited status
      visited[1] = true;
      colors[1] = 1;

      // Check if graph can be bipartite
      boolean bipartite = dfs(1);
      if (bipartite) FastPrint.out.println("sim");
      else FastPrint.out.println("nao");
    }

    FastPrint.out.close();
  }
}
