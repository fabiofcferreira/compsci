public class ED212 {
  public static int[] sumLevels(BTree<Integer> t) {
    int[] sum = new int[t.depth() + 1];

    sumLevels(t.getRoot(), 0, sum);

    return sum;
  }

  private static void sumLevels(BTNode<Integer> node, int depth, int[] sum) {
    if (node == null) return;

    sum[depth] += node.getValue();

    sumLevels(node.getLeft(), depth + 1, sum);
    sumLevels(node.getRight(), depth + 1, sum);
  }
}