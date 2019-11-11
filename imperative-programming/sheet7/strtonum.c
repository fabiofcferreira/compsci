#include <stdio.h>
#include <string.h>
#include <math.h>

int chartonum(char ch) {
  switch (ch) {
    case '0': return 0;
    case '1': return 1;
    case '2': return 2;
    case '3': return 3;
    case '4': return 4;
    case '5': return 5;
    case '6': return 6;
    case '7': return 7;
    case '8': return 8;
    case '9': return 9;
    default: return -1;
  }
}

int tenpower(int exp) {
  int res = 10;

  if (exp == 0) return 1;
  for(int i = 2; i <= exp; i++) res *= 10;

  return res;
}

int decimal(char str[]) {
  int magnitude = strlen(str) - 1;
  int dec = 0, i = 0;

  while(i <= strlen(str) - 1) {
    // convert char to int and multiply by base 10
    dec += chartonum(str[i]) * tenpower(magnitude);

    i++;
    magnitude--;
  }

  return dec;
}

int main() {
  char test[4] = "1234";

  printf("%d\n", decimal(test));
  return 0; 
}