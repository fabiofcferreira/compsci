#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int OP_n = 0;
int OP_b = 0;
int OP_s = 0;

int lineNumber = 1;
char *lastLine;
int lastLineEmpty = 0; 
char lastPrintedChar = '\0';

// read file and print every line according to options provided
int printFile(char* filePath) {
  FILE* f;
  
  // temporary character variables stats
  size_t lineSize = 0;
  size_t lineLength = 0;
  char *line;
  
  // open file stream
  if (strcmp(filePath, "-") == 0) f = stdin;
  else {
    f = fopen(filePath, "r");
    if (f == NULL) {
      printf("./my_cat: %s: No such file or directory\n", filePath);
      return 1;
    }
  }

  while ( (lineLength = getline(&line, &lineSize, f)) != -1 ) {
    int newline = (lastPrintedChar == '\n' || lineNumber == 1);
    int emptyline = strcmp(line, "\n") == 0 ? 1 : 0;

    // s flag basically serves to ignore consecutive empty lines
    if (OP_s) {
      if ( emptyline && lastLineEmpty ) continue;
    }

    // if there are more than 2 consecutive empty lines, do nothing
    if (OP_b && strcmp(line, "\n") != 0 && newline) {
      printf("%6d\t", lineNumber++);
    } else {
      if (OP_n && newline) {
        printf("%6d\t", lineNumber++);
      }
    }

    printf("%s", line);
    lastPrintedChar = line[strlen(line) - 1];
    lastLineEmpty = strcmp(line, "\n") == 0 ? 1 : 0;
  }

  // close stream
  fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  int opt;
  extern char *optarg;
  extern int optind, opterr, optopt;

  // parse arguments
  while ((opt = getopt(argc, argv, ":nbs")) != -1) {
    switch (opt) {
      case 'n':
        OP_n = 1;
        break;
      case 'b':
        OP_b = 1;
        break;
      case 's':
        OP_s = 1;
        break;
    }
  }

  for (int i = optind; i < argc; i++) {
    printFile(argv[i]);
  }

  return 0;
}