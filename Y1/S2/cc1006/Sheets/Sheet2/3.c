#include <stdio.h>

int fileCharacterCount(char* path) {
  int charCount = 0;
  
  // open read stream
  FILE* f;
  f = fopen(path, "r");

  char ch;
  while(fscanf(f, "%c", &ch) != EOF) charCount++;

  // close file stream
  fclose(f);

  return charCount;
}

void writeIntInFile(char* path, int charCount) {
  FILE* f;
  f = fopen(path, "w");

  fprintf(f, "The file has %d characters.", charCount);

  fclose(f);
}

int main(int n, char** argv) {
  if (n < 3) {
    printf("Input and output file paths are required.\n");
    return 1;
  }

  writeIntInFile(argv[2], fileCharacterCount(argv[1]));

  return 0;
}