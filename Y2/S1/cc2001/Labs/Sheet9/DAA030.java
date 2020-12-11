import java.io.*;
import java.util.*;

class Node {
  public LinkedList<Integer> adj; // Adjacent nodes list
  public boolean visited;         // Visited boolean status
  public int distance;            // Distance to origin node

  Node() {
	  adj = new LinkedList<Integer>();
  }
}

class Graph {
  int n;           // Nodes number
  Node nodes[];    // Nodes array

  // Constructor
  Graph(int n) {
	  this.n = n;

    // Read nodes
    nodes  = new Node[n+1];
	  for (int i = 1; i <= n; i++)
	    nodes[i] = new Node();
  }

  // Link two nodes
  public void addLink(int a, int b) {
	  nodes[a].adj.add(b);
	  nodes[b].adj.add(a);
  }

  // BFS algorithm
  public int bfs(int v) {
    // Create list of unvisited nodes
	  LinkedList<Integer> q = new LinkedList<Integer>();
	  for (int i = 1; i<=n; i++) nodes[i].visited = false;

    // Maximum distance
    int maxDistance = 0;

    // Add current node but tag it as visited
	  q.add(v);
	  nodes[v].visited = true;
	  nodes[v].distance = 0;

    while (q.size() > 0) {
	    int u = q.removeFirst();
      maxDistance = Math.max(maxDistance, nodes[u].distance);
	   
      for (int w : nodes[u].adj) {
        if (!nodes[w].visited) {
		      q.add(w);
		      nodes[w].visited = true;
		      nodes[w].distance = nodes[u].distance + 1; 
		    }
      }
    }

    return maxDistance;
  }
}

public class DAA030 {
  public static void main(String args[]) {
	  FastScanner in = new FastScanner(System.in);

    // Read number of nodes and create new graph
	  int nodes = in.nextInt();
    Graph g = new Graph(nodes);

    // Read number of edges and read all connections
    int e = in.nextInt();
    for (int i = 0; i < e; i++)
	    g.addLink(in.nextInt(), in.nextInt());

	  int diameter = 0;
    int radius = nodes+1;
    int[] centralNodes;
    int[] periphericalNodes;

    // Start BFS at all nodes until the whole graph has been searched
    for (int i = 1; i <= nodes; i++) {
      diameter = Math.max(diameter, g.bfs(i));
      radius = Math.min(radius, g.bfs(i));
    }

    // Print diameter and radius
    FastPrint.out.println(diameter);
    FastPrint.out.println(radius);

    // Print the central and peripherical nodes
    boolean firstValue = true;
    for (int i = 1; i <= nodes; i++) {
      if (g.bfs(i) == radius) {
        if (!firstValue) FastPrint.out.printf(" ");
        else firstValue = false;

        FastPrint.out.printf("%d", i);
      }
    }
    FastPrint.out.println();

    firstValue = true;
    for (int i = 1; i <= nodes; i++) {
      if (g.bfs(i) == diameter) {
        if (!firstValue) FastPrint.out.printf(" ");
        else firstValue = false;

        FastPrint.out.printf("%d", i);
      }
    }
    FastPrint.out.println();

    // Close print buffer
    FastPrint.out.close();
  }
}