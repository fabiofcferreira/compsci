#include <stdio.h>

int soma_divisores(int n);

int main() {
  int a;

  scanf("%d", &a);

  printf("%d\n", soma_divisores(a));

  return 0;
}

int soma_divisores(int n) {
  int sum = 0;

  // if n == 1, then there are no smaller divisors of 1
  if (n == 1) return 0;
  
  for (int i = 1; i < n; i++) {
    if (n % i == 0) {
      sum += i;
    }
  }

  return sum;
}

