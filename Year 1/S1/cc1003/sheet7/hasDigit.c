#include <stdio.h>
#include <ctype.h>
#include <string.h>

int algum_digito(char str[]) {
  int i = 0;
  // atenção: j pode ser negativo!
  while (i <= strlen(str) - 1) {
    if (isdigit(str[i])) return 1;
    
    i++;
  }

  return 0;
}

int main() {
  char test[7] = "test";

  printf("%d\n", algum_digito(test));

  return 0;
}