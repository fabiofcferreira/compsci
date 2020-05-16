#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int OP_v = 0;

void searchFile(char* word, char* filePath) {
  FILE* f;
  char* line;
  size_t len = 0;


  f = fopen(filePath, "r");
  if (f == NULL) {
    printf("./my_grep: %s: No such file or directory\n", filePath);
    exit(2);
  }

  while ( getline(&line, &len, f) != -1) {
    // normal use without -v flag
    if (!OP_v && strstr(line, word) != NULL) {
      printf("%s", line);
    }

    // reverse matching (print lines without the word)
    if (OP_v && strstr(line, word) == NULL) {
      printf("%s", line);
    }
  }

  printf("\n");

  return;
}

int main(int argc, char** argv) {
  int opt;
  extern char *optarg;
  extern int optind, opterr, optopt;

  char* word;

  // parse arguments
  while ((opt = getopt(argc, argv, ":if:v")) != -1) {
    switch (opt) {
      case 'v':
        OP_v = 1;
        break;
    }
  }

  // if there are extra arguments not parsed
  if (optind < argc) {
    word = argv[optind];

    for(optind++; optind < argc; optind++) {
      searchFile(word, argv[optind]);
    }
  }
  
  return 0;
}