#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

long m = 0;
long n = 0;
int useStdin = 0;

int printFileSlice(long m, long n, char* filePath) {
  long line = 1;
  char ch;
  char lastPrintedCh;
  FILE* f;
  
  // open file stream
  if (useStdin) f = stdin;
  else {
    f = fopen(filePath, "r");
    if (f == NULL) {
      printf("./my_cat: %s: No such file or directory\n", filePath);
      return 1;
    }
  }

  while ( (ch = getc(f)) != EOF ) {
    if (line >= m && line < n) {
      fputc(ch, stdout);
      lastPrintedCh = ch;
    } else if (line > n) break;

    if (ch == '\n') {
      line++;
    }
  }

  if ( lastPrintedCh != '\n' && ch == EOF ) printf("\n");

  // close stream
  fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  // use stdin if no file was provided
  if (argc < 4) useStdin++;

  // get arguments
  m = strtol(argv[1], NULL, 10);
  n = strtol(argv[2], NULL, 10);

  // check if m < n
  if (m > n) {
    printf("Argumentos trocados?\n");
  }

  // print parts of the file/stdin
  printFileSlice(m, n, argv[3]);

  return 0;
}