#include <stdio.h>

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

int calc(char str[]) {
  char operand1 = chartonum(str[0]), operation = str[1], operand2 = chartonum(str[2]);

  switch (operation) {
    case '+': return operand1 + operand2;
    case '-': return operand1 - operand2;
    case '*': return operand1 * operand2;
    default: break;
  }

  return 0;
}

int main() {
  char test[3] = "3*2";

  printf("%d\n", calc(test));

  return 0;
}