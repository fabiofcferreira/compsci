class TestBSTree {
  public static void main(String[] args) {
    BSTree<Integer> t = new BSTree<Integer>();

    // int[] data = {5, 3, 1, 4, 10, 7, 42};
    // int[] data = {7, 5, 6, 9, 8, 10};
    int[] data = {6, 3, 2, 5, 10, 8, 25};
    // int[] data = {5, 3, 1, 2, 7, 6, 8};
    for (int i=0; i<data.length; i++) t.insert(data[i]);

    // Escrever resultado de chamada a alguns metodos
    t.printPreOrder();
    t.printInOrder();
    t.printPostOrder();
  }
}