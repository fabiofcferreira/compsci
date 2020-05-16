#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int OP_i = 0;

void searchFile(char* word, char* filePath) {
  FILE* f;
  char* line;
  size_t len = 0;

  char* lowerCaseLine;
  char* lowerCaseWord = (char *) malloc(strlen(word) * sizeof(char)) ;

  // convert word to lowercase
  for (int i = 0; word[i] != '\0'; i++) lowerCaseWord[i] = tolower(word[i]);

  f = fopen(filePath, "r");
  if (f == NULL) {
    printf("./my_grep: %s: No such file or directory\n", filePath);
    exit(2);
  }

  while ( getline(&line, &len, f) != -1) {
    lowerCaseLine = (char *) malloc(strlen(line) * sizeof(char));
    // convert line to lowercase
    for (int i = 0; line[i] != '\0'; i++) lowerCaseLine[i] = tolower(line[i]);

    // normal use without -l flag
    if (!OP_i && strstr(line, word) != NULL) {
      printf("%s", line);
    }

    // only print file name which has a line with a match
    if (OP_i && strstr(lowerCaseLine, lowerCaseWord) != NULL) {
      printf("%s", line);
      break;
    }
  }

  return;
}

int main(int argc, char** argv) {
  int opt;
  extern char *optarg;
  extern int optind, opterr, optopt;

  char* word;

  // parse arguments
  while ((opt = getopt(argc, argv, ":if:l")) != -1) {
    switch (opt) {
      case 'i':
        OP_i = 1;
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