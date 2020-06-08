public class ED240 {
  static String[] paths;
  static int index = 0;

  static int minValue = 0;
  static int occurrences = 0;

  public static String[] paths(BTree<Integer> t) {
    index = 0;
    occurrences = 0;

    // find minimum value using bst
    minValue = minValue(t.getRoot());
    paths = new String[t.numberNodes()];

    // find paths
    findPaths(t.getRoot(), "");

    // return the correctly-sized string array
    String[] shrinkedPaths = new String[occurrences];
    for (int i = 0; i < occurrences; i++) shrinkedPaths[i] = paths[i];

    return shrinkedPaths;
  }

  public static int minValue(BTNode<Integer> node) {
    if (node == null) return Integer.MAX_VALUE;

    int min = node.getValue();
    int leftMin = minValue(node.getLeft());
    int rightMin = minValue(node.getRight());

    if (leftMin < min) min = leftMin;
    if (rightMin < min) min = rightMin;
    return min;
  }

  public static void findPaths(BTNode<Integer> node, String currPath) {
    if (node == null) return;

    // compare node value and add new path
    if (node.getValue().equals(minValue)) {
      paths[index++] = currPath.length() == 0 ? "R" : currPath;
      occurrences++;
    }

    findPaths(node.getLeft(), currPath + "E");
    findPaths(node.getRight(), currPath + "D");
  }
}