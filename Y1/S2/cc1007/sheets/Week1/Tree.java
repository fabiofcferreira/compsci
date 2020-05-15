import java.util.Scanner;

public class Tree {
  static void line(int spaces, int hashtags) {
    // print spaces before hashtags
    for (int i = 0; i < spaces; i++) System.out.print('.');
    // print hashtags
    for (int i = 0; i < hashtags; i++) System.out.print('#');
    // print spaces after hashtags
    for (int i = 0; i < spaces; i++) System.out.print('.');

    System.out.println();
  }

  static void tree(int maxHashtag) {
    int lineSize = maxHashtag;

    for(int i = 1; i <= maxHashtag; i += 2) {
      line((lineSize - i) / 2, i);
    }

    for(int i = maxHashtag-2; i >= 1; i -= 2) {
      line((lineSize - i) / 2, i);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.close();

    tree(n);
  }
}