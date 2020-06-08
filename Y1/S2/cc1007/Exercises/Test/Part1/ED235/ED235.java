import java.util.Scanner;

public class ED235 {
  static int n;

  public static void printTriangle(int lines) {
    int columns = lines;

    // loop for each row
    for (int r = 0; r < lines; r++) {
      // loop for each column
      for (int c = 0; c < columns; c++) {
        if (c >= columns - lines + r) System.out.printf("#");
        else System.out.printf(".");
      }

      System.out.printf("\n");
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    n = in.nextInt();
    for (int i = 0; i < n; i++) {
      printTriangle(in.nextInt()); 
    }
    
    in.close();
  }
}