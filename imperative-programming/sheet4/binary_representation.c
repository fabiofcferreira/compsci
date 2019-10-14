#include <stdio.h>

int main() {
  int n;
  
  scanf("%d", &n);

  int quocient = n;
  while (quocient) {
    printf("%d", quocient % 2);

    quocient /= 2;
  }

  printf("\n");
  return 0;
}