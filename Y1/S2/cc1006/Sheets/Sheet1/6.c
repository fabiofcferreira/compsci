#include <stdio.h>
#include <stdlib.h>

int main(int n, char** argv) {
  if (n < 2) {
    printf("Minimum of 1 argument with the path for the input file.\n");
    return 1;
  }

  int lines = 0;
  int columns = 0;
  int nums[1000][1000];

  // open file read stream
  FILE *f;
  f = fopen(argv[1], "r");

  // read lines and columns integer
  fscanf(f, "%d", &lines);
  fscanf(f, " %d", &columns);

  // read all the lines
  for (int i = 0; i < lines; i++) {
    for (int j = 0; j <= columns - 1; j++) {
      int numRead;
      fscanf(f, " %d", &numRead);

      // insert integer to the array
      nums[i][j] = numRead;
    }
  }

  // close file stream
  fclose(f);

  // print lines and columns number
  printf("%d %d\n", lines, columns);

  // print all the lines with the input order
  for (int i = 0; i < lines; i++) {
    for (int j = 0; j < columns; j++) {
      printf("%d\t", nums[i][j]);
    }
    printf("\n");
  }

  return 0;
}