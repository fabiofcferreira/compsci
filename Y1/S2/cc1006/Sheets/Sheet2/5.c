#include <stdio.h>
#include <stdlib.h>

FILE* open_file(char* path) {
  if (fopen(path, "r") == NULL) {
    return NULL;
  }

  return fopen(path, "r");
}

char* newWord(FILE* f) {
  char* word;
  word = (char *) malloc(1000);

  if (fscanf(f, "%s", word) != EOF) {
    return word;
  }

  return NULL;
}


int main(int n, char** argv) {
  FILE* f;
  char* word;

  if (n < 2) {
    printf("Input file required.\n\nUsage: %s input.txt\n", argv[0]);
    return 1;
  }

  // open file stream
  f = open_file(argv[1]);

  // read and print all the words
  while( (word = newWord(f)) != NULL) {
    printf("%s\n", word);
    free(word);
  }

  // close file stream
  fclose(f);
  return 0;
}