// Tree node
class Node {
  boolean isBlack;
  boolean isNull;
  int value;
  Node left, right;

  Node(int v) {
    isNull  = (v==0);
    isBlack = (v>=0);
    value   = Math.abs(v);
  }
}

class DAA022 {

  // Ler input em preorder
  static Node readPreOrder(FastScanner in) {
    int v = in.nextInt();
    Node aux = new Node(v);
    if (v!=0) {
      aux.left  = readPreOrder(in);
      aux.right = readPreOrder(in);
    }
    return aux;
  }

  // Menor valor da arvore
  static int minimum(Node t) {
    if (t.isNull) return Integer.MAX_VALUE;
    int minLeft  = minimum(t.left);
    int minRight = minimum(t.right);
    return Math.min(t.value, Math.min(minLeft, minRight));
  }

  // Maior valor da arvore
  static int maximum(Node t) {
    if (t.isNull) return Integer.MIN_VALUE;
    int minLeft  = maximum(t.left);
    int minRight = maximum(t.right);
    return Math.max(t.value, Math.max(minLeft, minRight));
  }

  // Quantidade de nos (internos)
  static int size(Node t) {
    if (t.isNull) return 0;
    return 1 + size(t.left) + size(t.right);
  }

  // ---------------------------------------------------

  static boolean isBST(Node t, int min, int max) {
    if (t.isNull) return true;

    if (t.value < min)
      return false;
    
    if (t.value > max)
      return false;

    return isBST(t.left, min, t.value) && isBST(t.right, t.value, max);
  }

  static boolean isRootBlack(Node t) {
    if (t.isBlack) return true;
    else return false;
  }

  static boolean hasRedProperty(Node t) {
    if (t.isNull) return true;

    if (!t.isBlack) {
      if (!(t.left.isBlack && t.right.isBlack)) return false;
      else return hasRedProperty(t.left) && hasRedProperty(t.right);
    } else {
      return hasRedProperty(t.left) && hasRedProperty(t.right);
    }
  }

  static boolean hasLeafProperty(Node t) {
    if (t.isNull) {
      if (t.isBlack) return true;
      else return false;
    } else return hasLeafProperty(t.left) && hasLeafProperty(t.right);
  }

  static int blackNodesUntilLeaf(Node t) {
    if (t.isNull) return 0;

    // Count black nodes from left and right nodes to leafs
    int left = blackNodesUntilLeaf(t.left);
    int right = blackNodesUntilLeaf(t.right);

    // If the current node is black, it is counted too
    if (t.isBlack) {
      left++;
      right++;
    }

    // FastPrint.out.printf("From node %d to its lefts there are %d black nodes\n", t.left.value, left);
    // FastPrint.out.printf("From node %d to its lefts there are %d black nodes\n", t.right.value, right);

    if (left != right) return -1;
    else return left;
  }

  static boolean hasBlackProperty(Node t) {
    if (t.isNull) return true;

    // Count black nodes from left and right nodes to leafs
    int left = blackNodesUntilLeaf(t.left);
    int right = blackNodesUntilLeaf(t.right);

    // If the current node is black, it is counted too
    if (t.isBlack) {
      left++;
      right++;
    }

    if (left != right) return false;
    else return true;
  }

  static boolean isRedBlack(Node t) {
    return isBST(t, -1000000, 1000000) &&
      isRootBlack(t) &&
      hasRedProperty(t) &&
      hasLeafProperty(t) &&
      hasBlackProperty(t);
  }
  
  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);

    Node root;
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      root = readPreOrder(in);
    
      if (isRedBlack(root)) {
        FastPrint.out.println("SIM");
      } else {
        FastPrint.out.println("NAO");
      }
    }

    FastPrint.out.close();
  }
}