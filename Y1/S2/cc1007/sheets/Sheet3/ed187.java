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
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < columns; j++)
        data[i][j] = in.nextInt();
  }

  // User frienddly Matrix string representation
  public String toString() {
    String ans = "";
    for (int i=0; i<rows; i++) {
       for (int j=0; j<columns; j++)
          ans += data[i][j] + " ";
       ans += "\n";
    }

    return ans;
  }

  // Identity Matrix
  public static Matrix identity(int n) {
    Matrix i = new Matrix(n, n);

    for (int pointer = 0; pointer < n; pointer++) {
      i.data[pointer][pointer] = 1;
    }

    return i;
  }

  // Transpose Matrix
  public Matrix transpose() {
    Matrix t = new Matrix(columns, rows);

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        t.data[c][r] = data[r][c];
      }
    }

    return t;
  }

  // Matrix sum
  public Matrix sum(Matrix m) {
    int sMrows = m.rows;
    int sMcolumns = m.columns;
    Matrix sM = new Matrix(sMrows, sMcolumns);

    for (int r = 0; r < sMrows; r++) {
      for (int c = 0; c < sMcolumns; c++) {
        sM.data[r][c] = data[r][c] + m.data[r][c];
      }
    }

    return sM;
  }

  // Multiply matrix
  public Matrix multiply(Matrix m) {
    int mMrows = rows;
    int mMcolumns = m.columns;
    int sum = 0;

    Matrix multiply = new Matrix(mMrows, mMcolumns);

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < m.columns; c++) {
        sum = 0;

        for (int i = 0; i < columns; i++) {
          sum += (data[r][i] * m.data[i][c]);
        }
        
        multiply.data[r][c] = sum;
      }
    }

    return multiply;
  }
}