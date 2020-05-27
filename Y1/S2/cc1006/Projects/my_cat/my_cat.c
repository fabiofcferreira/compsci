#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int useStdin = 0;

int printFile(char* filePath) {
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

  while ( (ch = fgetc(f)) != EOF ) {
    fputc(ch, stdout);
    lastPrintedCh = ch;
  }

  if ( lastPrintedCh != '\n' && ch == EOF ) printf("\n");

  // close stream
  fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  // read from stdin when there are
  // no arguments
  if (argc == 1) {
    useStdin++;
    printFile("");
    useStdin--;
    return 0;
  }

  for(int i = 1; i < argc; i++) {
    if (argv[i][0] == '-') {
      useStdin++;
      printFile("");
      useStdin--;
    }
    else printFile(argv[i]);
  }

  return 0;
}