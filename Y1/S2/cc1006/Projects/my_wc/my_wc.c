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

    previousC = c;
  }
  longestLine = thisLine > longestLine ? thisLine : longestLine;

  printf(" %d %d %d %d -\n", lines, words, bytes, longestLine - 1);

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

    previousC = c;
  }
  longestLine = thisLine > longestLine ? thisLine : longestLine;

  printf(" %d %d %d %d %s\n", lines, words, bytes, longestLine - 1, filePath);

  // close stream
  fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  if (argc < 2) {
    countStdin();
  } else {
    for(int i = 1; i < argc; i++) {
      if (argv[i][0] == '-') countStdin();
      else countFile(argv[i]);
    }
  }
  
  return 0;
}