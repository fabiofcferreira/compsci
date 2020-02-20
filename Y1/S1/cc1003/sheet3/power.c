#include <stdio.h>

int potencia(int x, int n);

int main() {
  int x, n;

  printf("X:");
  scanf("%d", &x);
  printf("N:");
  scanf("%d", &n);

  printf("Power of x^n: %d\n", potencia(x, n));

  return 0;
}

int potencia(int x, int n) {
  // any number powered by 0 is 1
  if (n == 0) return 1;

  int power = x;

  while(n > 1) {
    power *= x;

    n--;
  }

  return x;
}