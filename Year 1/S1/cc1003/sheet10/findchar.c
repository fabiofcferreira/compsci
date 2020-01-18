#include <stdio.h>
#include <string.h>

char *procurar(char *str, char ch) {
  int i = 0;
  while(str[i] != '\0') {
    if (str[i] == ch) {
      return &(str[i]);
    }

    i++;
  }

  return NULL;
}

int main() {
  char str[6] = "halo2";

  char* c = procurar(str, 'a');
  
  printf("%s\n", c);
  
  return 0;
}