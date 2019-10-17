#include <stdio.h>

int main() {
  int a, max = 0;

  while (scanf("%d", &a) > -1) {
    if (a == 0) break;

    if (a > max) max = a;
  }

  printf("The greatest is: %d\n", max);
}