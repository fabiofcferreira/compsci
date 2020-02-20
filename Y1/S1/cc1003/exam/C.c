#include <stdio.h>
#include <ctype.h>
#include <string.h>

int twoPow(int n) {
  int r = 1;

  while(n--) {
    r *= 2;
  }

  return r;
}

int binary(char str[]) {
  int num = 0;
  int size = strlen(str);
  int exp = size-1;

  for(int i = 0; i < size; i++) {
    if (str[i] == '1') num += twoPow(exp);

    exp--; 
  }

  return num;
}

int main() {
  char str[] = "10";

  printf("%d\n", binary(str));

  return 0;
}