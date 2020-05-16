#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void searchFile(char* word, char* filePath) {
  FILE* f;
  char* line;
  size_t len = 0;


  f = fopen(filePath, "r");
  if (f == NULL) exit(2);

  while ( getline(&line, &len, f) != -1) {
    if (strstr(line, word) != NULL) printf("%s", line);
  }

  return;
}

int main(int argc, char** argv) {
  if (argc < 3) exit(2);

  char* word = argv[1];

  // search in every file
  for (int i = 2; i < argc; i++) {
    searchFile(word, argv[i]);
  }
  
  return 0;
}