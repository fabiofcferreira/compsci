#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int strlern(char str);

// Handmade strlen function
int strlenalt(char* str) {
  int i = 0;

  while ((str[i]) != '\0') i++;

  return i;
}

int main(int n, char** argv) {
  for(int i = 1; i < n; i++) {
    // Using handamade strlen function
    // printf("%d\n", strlenalt(argv[i]));

    // Using libraries strlen function
    // printf("%ld\n", strlen(argv[i]));
  }

  return 0;
}

