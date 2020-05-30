import java.util.Scanner;

public class TestBTree {
  public static void main(String[] args) {
    // Ler arvore de inteiros em preorder
    Scanner in = new Scanner(System.in);
    BTree<Integer> t = LibBTree.readIntTree(in);

    // Escrever resultado de chamada a alguns metodos
    int[] max = t.maxLevel();

    System.out.printf("Max: %d Occurrences: %d\n", max[0], max[1]);
  }
}