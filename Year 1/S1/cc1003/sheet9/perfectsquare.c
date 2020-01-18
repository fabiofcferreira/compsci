#include <stdio.h>

int magico(int a[9][9], int n) {
  int magicNumber = 0;

  // calculate magic number by performing sum of
  // all elements in first line
  for(int i = 0; i < n; i++) {
    magicNumber += a[0][i];
  }

  int leftDiagonalTotal = 0, rightDiagonalTotal = 0;
  // check diagonals elements' sum
  for(int i = 0; i < n; i++) {
    // left diagonal starts on the top left and ends on bottom right
    leftDiagonalTotal += a[i][i];
    // right diagonal is the reverse
    rightDiagonalTotal += a[i][n-i-1];
  }

  // if the sum differ from the magic number, it's not a magic square
  if (leftDiagonalTotal != magicNumber ||
    rightDiagonalTotal != magicNumber) return 0;

  // check lines and columns' elements sum
  int lineTotal = 0, columnTotal = 0;
  for(int i = 0; i < n; i++) {
    lineTotal = columnTotal = 0;

    for (int j = 0; j < n; j++) {
      lineTotal += a[i][j];
      columnTotal += a[j][i];
    }

    if (lineTotal != magicNumber) return 0;
    if (columnTotal != magicNumber) return 0;
  }

  return 1;
}

int main() {
  int a[9][9] = {
    {94,114,134,154,12,32,52,72,61},
    {116,136,156,14,34,54,56,76,83},
    {138,158,16,36,38,58,78,98,105},
    {160,18,20,40,60,80,100,120,127},
    {2,22,42,62,82,102,122,142,149},
    {24,44,64,84,104,124,144,146,-9},
    {46,66,86,106,126,128,148,6,13},
    {68,88,108,110,130,150,8,28,35},
    {90,92,112,132,152,10,30,50,57}
  };

  printf("%d\n", magico(a, 9));

  return 0;
}