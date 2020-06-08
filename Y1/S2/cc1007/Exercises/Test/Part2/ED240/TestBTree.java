import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);
      
      String[] paths = ED240.paths(t);

      for (int i = 0; i < paths.length; i++) {
        System.out.println(paths[i]);
      }
   }
}