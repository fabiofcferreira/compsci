#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int OP_v = 0;
int OP_l = 0;
int OP_i = 0;
int OP_c = 0;
int OP_multipleFiles = 0;

void searchFile(char* word, char* filePath) {
  FILE* f;
  char* line;
  size_t len = 0;
  int count = 0;

  f = fopen(filePath, "r");
  if (f == NULL) {
    printf("./my_grep: %s: No such file or directory\n", filePath);
    exit(2);
  }

  while ( getline(&line, &len, f) != -1 ) {
    if (OP_i) {
      // convert word to lowercase
      for (int i = 0; word[i] != '\0'; i++) word[i] = tolower(word[i]);
      // convert line to lowercase
      for (int i = 0; line[i] != '\0'; i++) line[i] = tolower(line[i]);
    }

    if (OP_l && strstr(line, word) != NULL) {
      printf("%s\n", filePath);
      break;
    } else {
      if (OP_c && strstr(line, word) != NULL) count++;
      else {
        // normal use without -v flag
        if (!OP_v && strstr(line, word) != NULL) {
          if (OP_multipleFiles == 1) printf("%s:", filePath);
          printf("%s", line);
          count++;
        }

        // reverse matching (print lines without the word)
        if (OP_v && strstr(line, word) == NULL) {
          if (OP_multipleFiles == 1) printf("%s:", filePath);
          printf("%s", line);
          count++;
        }
      }
    }
  }

  // print counter of matches
  if (OP_c) {
    if (OP_multipleFiles == 1) printf("%s:", filePath);
    printf("%d", count);
  }

  // if there are any matches, a newline must be printed in order
  // for the next terminal text not to be in the same line
  if (count) printf("\n");

  return;
}

int main(int argc, char** argv) {
  int opt;
  extern char *optarg;
  extern int optind, opterr, optopt;

  char* word;

  // parse arguments
  while ((opt = getopt(argc, argv, ":if:vlci")) != -1) {
    switch (opt) {
      case 'v':
        OP_v = 1;
        break;
      case 'l':
        OP_l = 1;
        break;
      case 'c':
        OP_c = 1;
        break;
      case 'i':
        OP_i = 1;
        break;
    }
  }

  // if there are extra arguments not parsed
  if (optind < argc) {
    word = argv[optind];

    if (argc - optind > 2) OP_multipleFiles = 1;

    for(optind++; optind < argc; optind++) {
      searchFile(word, argv[optind]);
    }
  }
  
  return 0;
}