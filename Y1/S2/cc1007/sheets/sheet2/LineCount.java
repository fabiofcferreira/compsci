import java.util.Scanner;

public class LineCount {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // holds number of lines
    int counter = 0;
    while (sc.hasNextLine()) {
      counter++;

      String s = sc.nextLine();
      System.out.println(counter + ": " + s);
    }

    sc.close();
  }
}