import java.util.Scanner;

public class TestBTree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BTree<Integer> t = LibBTree.readIntTree(in);

    int[] sum = ED212.sumLevels(t);

    for (int i = 0; i < sum.length; i++) System.out.println(sum[i]);

    in.close();
  }
}