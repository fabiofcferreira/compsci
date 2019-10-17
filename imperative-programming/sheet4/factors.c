#include <stdio.h>

int main() {
  int a;
  int quocient = 2;

  scanf("%d", &a);

  printf("%d : " , a);

  int divided = 0;
  while (a) {
    if (a == 1) break;

    if (a % quocient == 0) {
      printf("%d ", quocient);

      a /= quocient;
      quocient = 2;
    } else {
      quocient++;
    }
  }

  printf("\n");

  return 0;
}