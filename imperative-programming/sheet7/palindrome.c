#include <stdio.h>
#include <string.h>

int palindromo(char str[]) {
  int i = 0, j, palindrome = 1;
  j = strlen(str) - 1; 
  // atenção: j pode ser negativo!
  while (i < j) {
    if (str[i] != str[j]) palindrome = 0;
    
    i++;
    j--;
  }

  return palindrome;
}

int main() {
  char test[7] = "HALALAH";

  printf("%d\n", palindromo(test));

  return 0;
}