import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);

      // Escrever resultado de chamada a alguns metodos
      System.out.println("Strict = " + (t.strict() ? "true" : "false"));

      // Escrever nos da arvore seguindo varias ordens possiveis
      // t.printPreOrder();      
      // t.printInOrder();
      // t.printPostOrder();
      // t.printBFS();
      // t.printDFS();
   }
}