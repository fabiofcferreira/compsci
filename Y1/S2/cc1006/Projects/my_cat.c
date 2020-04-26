#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int OP_n = 0;
int OP_b = 0;
int OP_s = 0;

int isNumbered(char* line) {
  // non-empty lines that don't contain the \n only
  if (strlen(line) > 0 && line[0] != '\n') {
    if (OP_n || OP_b) {
      return 1;
    }
  } else {
    if (!OP_b && OP_n) {
      return 1;
    }
  }

  return 0;
}

int printStdin() {
  char* line = NULL;
  size_t size;

  int lineNum = 1;
  while (getline(&line, &size, stdin) != -1) {
    if (isNumbered(line)) printf("%6d\t", lineNum++);

    printf("%s", line);
  }

  return 0;
}

int printFile(char* filePath) {
  char* line;
  size_t size;
  FILE* f;
  
  // open file stream
  f = fopen(filePath, "r");
  if (f == NULL) {
    printf("./my_cat: %s: No such file or directory\n", filePath);
    return 1;
  }

  int lineNum = 1;
  while (getline(&line, &size, f) != -1) {
    if (isNumbered(line)) printf("%6d\t", lineNum++);

    fputs(line, stdout);
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
  while ((opt = getopt(argc, argv, ":if:nbs")) != -1) {
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

  // if there are extra arguments not parsed
  if (optind < argc) {
    for(; optind < argc; optind++){      
      if (strcmp(argv[optind], "-") == 0) {
        printStdin();
      } else {
        printFile(argv[optind]);
      }
    }
  } else {
    printStdin();
  }
  
  return 0;
}