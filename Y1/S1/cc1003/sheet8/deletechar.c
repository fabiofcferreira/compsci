#include <stdio.h>
#include <string.h>

void eliminar(char str[], char ch) {
  for(int i = 0; i < strlen(str); i++) {
    if (str[i] == ch) {
      // shift all upcoming chars to the left
      for(int j = i+1; j < strlen(str); j++) str[j-1] = str[j];

      str[strlen(str)-1] = '\0';
    }
  }
}

int main() {
  char b[4] = "ABBA";

  eliminar(b, 'B');

  return 0; 
}