import java.util.*;

class Edge {
  int to;
  double weight;
    
  Edge(int t, double w) {
	  to = t;
	  weight = w;
  }
}

class Node {
  public LinkedList<Edge> adj;
  public boolean visited;
  public double distance;
    
  Node() {
	  adj = new LinkedList<>();
  } 
}

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
  public double cost;
  public int node;

  NodeQ(double c, int n) {
	  cost = c;
	  node = n;
  }

  @Override
  public int compareTo(NodeQ nq) { 
    if (cost < nq.cost) return -1; 
    if (cost > nq.cost) return +1;
    if (node < nq.node) return -1; 
	  if (node > nq.node) return +1;
    
    return 0; 
  } 
}

// Classe que representa um grafo
class Graph {
  int n;          // Numero de nos do grafo
  Node[] nodes;   // Array para conter os nos
    
  Graph(int n) {
    this.n = n;
    nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
    
    for (int i=1; i<=n; i++)
	    nodes[i] = new Node();
  }
    
  void addLink(int a, int b, double c) {
	  nodes[a].adj.add(new Edge(b, c));
    nodes[b].adj.add(new Edge(a, c));
  }

  // Dijkstra's algorithm
  double dijkstra(int s, int t) {
    double bestDistance = Integer.MAX_VALUE;

    // Reset visited status and set maximum distance
    for (int i = 1; i <= n; i++) {
	    nodes[i].distance = Integer.MAX_VALUE;
	    nodes[i].visited  = false;
  	}
	
    // Start queue on the current node
    nodes[s].distance = 0;
    TreeSet<NodeQ> q = new TreeSet<>();
    q.add(new NodeQ(0, s));

    // Dijkstra's main cycle
    while (!q.isEmpty()) {  
      // Remove the first item with the smallest distance     
	    NodeQ nq = q.pollFirst();
      int currNodeIndex = nq.node;
	    nodes[currNodeIndex].visited = true;

	    for (Edge e : nodes[currNodeIndex].adj) {
        int possibleNextNodeIndex = e.to;
        double cost = e.weight;

        if (!nodes[possibleNextNodeIndex].visited && nodes[currNodeIndex].distance + cost < nodes[possibleNextNodeIndex].distance) {
          // Remove node with outdated distance
          q.remove(new NodeQ(nodes[possibleNextNodeIndex].distance, possibleNextNodeIndex));
          
          if (possibleNextNodeIndex == t) bestDistance = Math.min(bestDistance, nodes[currNodeIndex].distance + cost);

          // Add updated node to queue
          nodes[possibleNextNodeIndex].distance = nodes[currNodeIndex].distance + cost;
          q.add(new NodeQ(nodes[possibleNextNodeIndex].distance, possibleNextNodeIndex));
        }
	    }
	  }

    return bestDistance;
  }
}

public class DAA033 {
  static int n;
  static int e;
  static Graph g;
  static int lastNodeNumber = 1;

  static TreeMap<String, Integer> nodesName = new TreeMap<String, Integer>();

  // Find node number by its name
  public static int findNodeNumberByName(String name) {
    if (nodesName.get(name) != null) return nodesName.get(name);
    else {
      nodesName.put(name, lastNodeNumber);
      return lastNodeNumber++;
    }
  }

  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);

    // Read number of nodes and edges
    n = in.nextInt();
    e = in.nextInt();
    g = new Graph(n);

    // Source and destination string and weight
    String pathSrc;
    String pathDest;
    String src;
    String dest;
    double weight;

    // Read origin and destination
    pathSrc = in.next();
    pathDest = in.next();
    findNodeNumberByName(pathSrc);
    findNodeNumberByName(pathDest);

    for (int i = 0; i < e; i++) {
      src = in.next();
      dest = in.next();
      weight = in.nextDouble();

      g.addLink(findNodeNumberByName(src), findNodeNumberByName(dest), weight);
    }

    // Dijkstra starting on node 1
    double srcToDest = g.dijkstra(findNodeNumberByName(pathSrc), findNodeNumberByName(pathDest));
    double destToSrc = g.dijkstra(findNodeNumberByName(pathDest), findNodeNumberByName(pathSrc));

    if (srcToDest < destToSrc) FastPrint.out.printf("%.1f\n",srcToDest);
    else FastPrint.out.printf("%.1f\n", destToSrc);

    FastPrint.out.close();
  }
}