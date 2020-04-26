#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int OP_c = 0;
int OP_l = 0;
int OP_w = 0;
int OP_L = 0;

int bytes,
  words,
  lines,
  thisLine,
  longestLine;

// read input from stdin and print every line according to options provided
int countStdin() {
  char c, previousC;
  size_t size;

  // read a char at a time
  for(; (c = getc(stdin)) != -1; ++bytes) {
    // increment line character counter
    thisLine++;

    if(c =='\n') {
      lines++;
      longestLine = (thisLine > longestLine ? thisLine : longestLine);
      thisLine = 0;
      if (previousC != ' ' && previousC != '\n' && previousC != '\t') words++;
    } else if (c == ' ' || c == '\t') words++;

    // save current character to be used as previous character
    previousC = c;
  }
  longestLine = thisLine > longestLine ? thisLine : longestLine;

  printf(" ");
  if (OP_l) printf("%d ", lines);
  if (OP_w) printf("%d ", words);
  if (OP_c) printf("%d ", bytes);
  if (OP_L) printf("%d ", longestLine - 1);

  printf("-\n");

  return 0;
}

// read file and print every line according to options provided
int countFile(char* filePath) {
  char c, previousC;
  size_t size;
  FILE* f;
  
  // open file stream
  f = fopen(filePath, "r");
  if (f == NULL) {
    printf("./my_cat: %s: No such file or directory\n", filePath);
    return 1;
  }

  // read a char at a time
  for(; (c = getc(f)) != -1; ++bytes) {
    // increment line character counter
    thisLine++;

    if(c =='\n') {
      lines++;
      longestLine = (thisLine > longestLine ? thisLine : longestLine);
      thisLine = 0;
      if (previousC != ' ' && previousC != '\n' && previousC != '\t') words++;
    } else if (c == ' ' || c == '\t') words++;

    // save current character to be used as previous character
    previousC = c;
  }
  longestLine = thisLine > longestLine ? thisLine : longestLine;

  printf(" ");
  if (OP_l) printf("%d ", lines);
  if (OP_w) printf("%d ", words);
  if (OP_c) printf("%d ", bytes);
  if (OP_L) printf("%d ", longestLine - 1);

  printf("%s\n", filePath);

  // close stream
  fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  int opt;
  extern char *optarg;
  extern int optind, opterr, optopt;

  // parse arguments
  while ((opt = getopt(argc, argv, ":if:clwL")) != -1) {
    switch (opt) {
      case 'c':
        OP_c = 1;
        break;
      case 'l':
        OP_l = 1;
        break;
      case 'w':
        OP_w = 1;
        break;
      case 'L':
        OP_L = 1;
        break;
    }
  }

  // if there are extra arguments not parsed
  if (optind < argc) {
    for(; optind < argc; optind++){      
      if (strcmp(argv[optind], "-") == 0) {
        countStdin();
      } else {
        countFile(argv[optind]);
      }
    }
  } else {
    countStdin();
  }
  
  return 0;
}