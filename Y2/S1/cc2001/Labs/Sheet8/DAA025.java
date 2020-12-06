public class DAA025 {
  static int n;              // Nodes number
  static boolean adj[][];    // Adjacent matrix
  static boolean visited[];  // Visited matrix

  static int circuitsCounter = 0;

  static void dfs(int v) {
    visited[v] = true;
    for (int i = 1; i <= n; i++) {
      if (adj[v][i] && !visited[i]) {
        dfs(i);
      }
    }
  }
    
  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);
    
    // Read number of nodes
    n = in.nextInt();
    
    // Create adjacent and visited arrays
	  adj = new boolean[n+1][n+1];
    visited = new boolean[n+1];
    
    // Read number of edges and read edges
	  int edges = in.nextInt();	
	  for (int i = 0; i < edges; i++) {
	    int a = in.nextInt();
      int b = in.nextInt();

	    adj[a][b] = adj[b][a] = true;
    }
    
    // Start a DFS on all unvisited nodes
    for (int i = 1; i < adj.length; i++) {
      if (!visited[i]) {
        circuitsCounter++;
        dfs(i);
      }
    }

    FastPrint.out.println(circuitsCounter);
    FastPrint.out.close();
  }
}
