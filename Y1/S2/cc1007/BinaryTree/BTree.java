public class BTree<T> {   
  private BTNode<T> root; // raiz da arvore

  // Construtor
  BTree() {
    root = null;
  }

  // Getter e Setter para a raiz
  public BTNode<T> getRoot() {return root;}
  public void setRoot(BTNode<T> r) {root = r;}

  // Verificar se arvore esta vazia
  public boolean isEmpty() {
    return root == null;
  }

  // --------------------------------------------------------

  // Numero de nos da arvore   
  public int numberNodes() {
    return numberNodes(root);
  }

  private int numberNodes(BTNode<T> n) {
    if (n == null) return 0;
    return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
  }

  // --------------------------------------------------------

  // Leafs number
  public int numberLeafs() {
    return numberLeafs(root);
  }

  private int numberLeafs(BTNode<T> n) {
    // base cases
    if (root == null || n == null) return 0;
    // node is a leaf if there is no
    // left or right child
    if (n.getLeft() == null && n.getRight() == null) return 1;

    // keep browsing
    return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
  }

  // --------------------------------------------------------

  // Strict binary tree
  public boolean strict() {
    return strict(root);
  }

  private boolean strict(BTNode<T> n) {
    // base cases
    if (root == null || n == null) return true;

    if (n.getLeft() == null && n.getRight() == null) return true;
    else if (n.getLeft() != null && n.getRight() != null) return strict(n.getLeft()) && strict(n.getRight());
    
    return false;
  }

  // --------------------------------------------------------

  // Value held in the node given the path to it
  public T path(String s) {
    return path(root, s);
  }

  private T path(BTNode<T> n, String path) {
    // root edge case
    if (path == "R") return root.getValue();

    BTNode<T> node = n;
    for (int i = 0; i < path.length(); i++) {
      if (path.charAt(i) == 'E') n = n.getLeft();
      if (path.charAt(i) == 'D') n = n.getRight();
    }

    return n.getValue();
  }

  // --------------------------------------------------------

  // Number of nodes at a tree level
  public int nodesLevel(int k) {
    return nodesLevel(root, 0, k);
  }

  private int nodesLevel(BTNode<T> n, int depth, int level) {
    // base case
    if (depth == level && n != null) return 1;

    // edge case
    if (n == null) return 0;

    return nodesLevel(n.getLeft(), depth + 1, level) + nodesLevel(n.getRight(), depth + 1, level);
  }

  // --------------------------------------------------------

  public int internal() {
    return internal(root);
  }

  private int internal(BTNode<T> n) {
    // if node has left or right children nodes, then
    // it's already an internal node
    if (n == null) return 0;
    else if (n.getLeft() == null && n.getRight() == null) return 0;
    else return 1 + internal(n.getLeft()) + internal(n.getRight());
  }

  // --------------------------------------------------------

  public void cut(int d) {
    cut(root, 0, d);
  }

  private void cut(BTNode<T> n, int depth, int depthCut) {
    if (n == null) return;

    // remove children nodes if the current depth is the
    // deleted depth
    if (depthCut > 0) {
      if (depth == depthCut - 1) {
        n.setLeft(null);
        n.setRight(null);
      }
    } else root = null;

    cut(n.getLeft(), depth + 1, depthCut);
    cut(n.getRight(), depth + 1, depthCut);
  }

  // --------------------------------------------------------

  public int[] maxLevel() {
    // maximum of nodes array
    int[] nodeMax = new int[depth(root) + 1];
    for (int i = 0; i < nodeMax.length; i++) nodeMax[i] = 0;

    // calculate maximum num of nodes for each depth
    maxLevel(root, 0, nodeMax);

    // get absolute maximum num of nodes for all depths
    // and the number of occurrences
    int maxNum = 0;
    int maxOccurrences = 0;
    // find the maximum number of nodes
    for (int i = 0; i < nodeMax.length; i++) {
      maxNum = Math.max(maxNum, nodeMax[i]);
    }

    // find number of occurrences
    for (int i = 0; i < nodeMax.length; i++) {
      if (nodeMax[i] == maxNum) maxOccurrences++;
    }

    return new int[] {maxNum, maxOccurrences};
  }

  private void maxLevel(BTNode<T> n, int depth, int[] nodeMax) {
    // null nodes aren't countable nodes
    if (n == null) return;

    // count one more node
    nodeMax[depth]++;

    maxLevel(n.getLeft(), depth + 1, nodeMax);
    maxLevel(n.getRight(), depth + 1, nodeMax);
  }

  // --------------------------------------------------------

  // Altura da arvore
  public int depth() {
    return depth(root);
  }

  private int depth(BTNode<T> n) {
    if (n == null) return -1;
    return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
  }

  // --------------------------------------------------------
  
  // O elemento value esta contido na arvore?
  public boolean contains(T value) {
    return contains(root, value);
  }

  private boolean contains(BTNode<T> n, T value) {
    if (n==null) return false;
    if (n.getValue().equals(value)) return true;
    return contains(n.getLeft(), value) || contains(n.getRight(), value);
  }

  // --------------------------------------------------------

  // Imprimir arvore em PreOrder
  public void printPreOrder() {
    System.out.print("PreOrder:");
    printPreOrder(root);
    System.out.println();
  }

  private void printPreOrder(BTNode<T> n) {
    if (n==null) return;
    System.out.print(" " + n.getValue() );
    printPreOrder(n.getLeft());
    printPreOrder(n.getRight());
  }

  // --------------------------------------------------------
  
  // Imprimir arvore em InOrder
  public void printInOrder() {
    System.out.print("InOrder:");
    printInOrder(root);
    System.out.println();
  }

  private void printInOrder(BTNode<T> n) {
    if (n==null) return;
    printInOrder(n.getLeft());
    System.out.print(" " + n.getValue());
    printInOrder(n.getRight());
  }

  // --------------------------------------------------------

  // Imprimir arvore em PostOrder
  public void printPostOrder() {
    System.out.print("PostOrder:");
    printPostOrder(root);
    System.out.println();
  }

  private void printPostOrder(BTNode<T> n) {
    if (n==null) return;
    printPostOrder(n.getLeft());
    printPostOrder(n.getRight());
    System.out.print(" " + n.getValue());
  }

  // --------------------------------------------------------

  // Imprimir arvore numa visita em largura (usando TAD Fila)
  public void printBFS() {
    System.out.print("BFS:");
    
    MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
    q.enqueue(root);
    while (!q.isEmpty()) {
      BTNode<T> cur = q.dequeue();
      if (cur != null) {
        System.out.print(" " + cur.getValue());
        q.enqueue(cur.getLeft());
        q.enqueue(cur.getRight());
      }
    }
    System.out.println();
  }

  // --------------------------------------------------------
  
  // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
  public void printDFS() {
    System.out.print("DFS:");
    
    MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
    q.push(root);
    while (!q.isEmpty()) {
      BTNode<T> cur = q.pop();
      if (cur != null) {
        System.out.print(" " + cur.getValue());
        q.push(cur.getLeft());
        q.push(cur.getRight());
      }
    }
    System.out.println();
  }

}