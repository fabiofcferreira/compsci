public class ED211 {
  public static int countEven(BTree<Integer> t) {
    return countEven(t.getRoot());
  }

  private static int countEven(BTNode<Integer> node) {
    if (node == null) return 0;

    if (node.getValue() % 2 == 0)
      return 1 + countEven(node.getLeft()) + countEven(node.getRight());
    else
      return countEven(node.getLeft()) + countEven(node.getRight());
  }
}