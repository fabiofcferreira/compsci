#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

int printStdin() {
  char* line = NULL;
  size_t size;

  while (getline(&line, &size, stdin) != -1) {
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

  while (getline(&line, &size, f) != -1) {
    fputs(line, stdout);
  }

  // close stream
  fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  if (argc < 2) {
    printStdin();
  } else {
    for(int i = 1; i < argc; i++) {
      if (argv[i][0] == '-') printStdin();
      else printFile(argv[i]);
    }
  }

  return 0;
}