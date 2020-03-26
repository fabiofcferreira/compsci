#include <stdio.h>
#include <stdlib.h>

int main(int n, char** argv) {
  int lines = 0;
  int columns = 0;

  if (n < 4) {
    printf("Minimum of 3 arguments. 2 numbers for lines and columns and 1 file path for the output.\n");
    return 1;
  }

  lines = atoi(argv[1]);
  columns = atoi(argv[2]);

  // open file write stream
  FILE *f;
  f = fopen(argv[3], "w");

  // write lines and columns first
  fprintf(f, "%d ", lines);
  fprintf(f, "%d ", columns);

  // write all the lines with the input order
  for (int i = 0; i < lines; i++) {
    for (int j = 0; j < columns; j++) {
      // read integer
      int a;
      scanf("%d", &a);

      // write numbers in output file
      fprintf(f, "%d", a);

      // if it's not the last item of all
      // write a space to separate the number
      if ( !(i == lines - 1 && j == columns -1)) {
        fprintf(f, "%c", ' ');
      }
    }
  }

  // close file stream
  fclose(f);

  return 0;
}