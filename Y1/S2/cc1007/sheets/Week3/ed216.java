import java.util.Scanner;

class Matrix {
  int data[][];
  int rows;
  int columns;

  // constructor
  Matrix(int r, int c) {
    data = new int[r][c];
    rows = r;
    columns = c;
  }

  // Read all rows and columns of data
  public void read(Scanner in) {
    int n = rows;
    while (in.hasNextLine() && n > 0) {
      String line = in.nextLine();
      System.out.println(line.charAt(0) == '\n');
      System.out.println(line);

      n--;
    }
  }

  // User frienddly Matrix string representation
  public String toString() {
    String ans = "";
    for (int i=0; i<rows; i++) {
       for (int j=0; j<columns; j++)
          ans += data[i][j];
       ans += "\n";
    }

    return ans;
  }

  private static void calcBiggestSegment() {

  }
}

public class ed216 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int rows = sc.nextInt();
    int columns = sc.nextInt();

    Matrix m = new Matrix(rows, columns);

    m.read(sc);

    System.out.println(m);
  }
}