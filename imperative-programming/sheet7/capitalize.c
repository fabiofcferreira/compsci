#include <stdio.h>
#include <ctype.h>

void capitalizar(char str[]) {
  unsigned i = 0;
  while(str[i] != '\0') {
    if(isalpha(str[i]) && islower(str[i])) {
      str[i] = toupper(str[i]);
    }
    
    i++;
  }
}

int main() {
  char test[6] = "Hell0";

  capitalizar(test);
  
  return 0;
}