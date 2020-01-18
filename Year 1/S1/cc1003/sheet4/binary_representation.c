#include <stdio.h>

int binary(int n) {
  int v = 0, tens = 1;

  int quocient = n;
  while (quocient) {
    v += (quocient % 2) * tens;

    quocient /= 2;
    tens *= 10;
  }

  return v;
}

int main() {
  int n;
  
  scanf("%d", &n);

  printf("%d\n", binary(n));
  return 0;
}