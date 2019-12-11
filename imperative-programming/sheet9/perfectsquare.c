#include <stdio.h>

int magico(int a[3][3], int n) {
  int magicNumber = 0;

  // calculate magic number by performing sum of
  // all elements in first line
  for(int i = 0; i < n; i++) {
    magicNumber += a[0][i];
  }

  // check lines and columns' elements sum
  int lineTotal = 0, columnTotal = 0, leftDiagonalTotal = 0, rightDiagonalTotal = 0;
  for(int i = 0; i < n; i++) {
    lineTotal = columnTotal = 0;

    for (int j = 0; j < n; j++) {
      lineTotal += a[i][j];
      columnTotal += a[j][i];
    }


    if (lineTotal != magicNumber) return 0;
    if (columnTotal != magicNumber) return 0;
  }

  // check diagonals elements' sum
  for(int i = 0; i < n; i++) {
    // left diagonal starts on the top left and ends on bottom right
    leftDiagonalTotal += a[i][i];
    // right diagonal is the reverse
    rightDiagonalTotal += a[n-i-1][n-i-1];
  }

  if (leftDiagonalTotal != magicNumber ||
    rightDiagonalTotal != magicNumber) return 0;


  return 1;
}

int main() {
  int a[3][3] = {
    {2, 7, 6},
    {9, 5, 1},
    {4, 3, 8}
  };

  printf("%d\n", magico(a, 3));

  return 0;
}