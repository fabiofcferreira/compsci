#include <stdio.h>
#include <ctype.h>
#include <string.h>

int todos_letras(char str[]) {
  int i = 0;
  // atenção: j pode ser negativo!
  while (i <= (strlen(str) - 1)) {
    if (str[i] <= 'a' && str[i] >= 'Z') return 0;
    
    i++;
  }

  return 1;
}

int main() {
  char test[7] = "HALALAH";

  printf("%d\n", todos_letras(test));

  return 0;
}