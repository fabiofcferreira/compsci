import java.util.Scanner;

public class ed121 {
  public static boolean isPalindrome(String s) {
    String parsedStr = s.replace(" ", "")
      .replace("'", "")
      .replaceAll("\\p{P}", "")
      .toLowerCase();
    int length = parsedStr.length();

    for (int i = 0; i < length / 2; i++) {
      if (parsedStr.charAt(i) != parsedStr.charAt(length - 1 - i)) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int lines = Integer.parseInt(sc.nextLine());
    boolean[] palindromes = new boolean[lines];

    for (int i = 0; i < lines; i++) {
      String str = sc.nextLine();
      palindromes[i] = isPalindrome(str);
    }

    System.out.println(lines);
    for (int i = 0; i < lines; i++) {
      System.out.println(palindromes[i] ? "sim" : "nao");
    }
  }
}