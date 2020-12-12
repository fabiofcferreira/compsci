import java.util.*;

public class DAA029 {
  static boolean adj[][] = new boolean[26][26];
  static boolean visited[] = new boolean[26];
  static boolean[] chars = new boolean[26];

  static LinkedList<Integer> arr = new LinkedList<Integer>();

  static void dfs(int v) {
    visited[v] = true;

    for (int i = 1; i <= 25; i++) {
      if (adj[v][i] && !visited[i]) 
		    dfs(i);
    }

    arr.addFirst(v);
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int words = in.nextInt();
    String prevWord = "";
    String word = "";
    for (int i = 0; i < words; i++) {
      word = in.next();

      for (int c = 0; c < word.length(); c++)
        chars[word.charAt(c) - 'A'] = true;

      // If no previous word is set, set it as the current word and continue
      // to next iteration
      if (prevWord.length() == 0) {
        prevWord = word;
        continue;
      }

      // Navigate forward until the characters in the same index of the last
      // and current words are different
      int start = 0;
      while (start < prevWord.length() && start < word.length() && prevWord.charAt(start) == word.charAt(start))
        start++;

      if (start == prevWord.length() || start == word.length()) {
        prevWord = word;
        continue;
      }

      adj[prevWord.charAt(start) - 'A'][word.charAt(start) - 'A'] = true;
      prevWord = word;
    }

    // Start DFS on all nodes
    for (int i = 0; i < 26; i++) {
      if (chars[i] && !visited[i])
        dfs(i);
    }

    // Print order
    while (!arr.isEmpty())
      FastPrint.out.printf("%c", (char) ('A' + arr.pop()));

    FastPrint.out.println();
    FastPrint.out.close();
  }
}