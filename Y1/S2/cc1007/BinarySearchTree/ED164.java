import java.util.Scanner;

public class ED164 {
  public static void main(String[] args) {
    BSTree<String> tree = new BSTree<String>();
    
    Scanner in = new Scanner(System.in);

    int lines = in.nextInt();

    while(lines-- > 0) {
      String word = in.next();

      tree.insert(word);
    }

    System.out.println(tree.numberNodes());

    in.close();
  }
}