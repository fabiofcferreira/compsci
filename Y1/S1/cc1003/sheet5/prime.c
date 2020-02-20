#include <stdio.h>

void printPrime(long n) {
  if (n <= 1) return;

  for (long i = 2; i < n; i++) {
    if (i == 2) printf("2 ");

    if (i % 2 != 0) {
      printf("%ld ", i);
    }
  }
}

int main() {
  long int n;
  scanf("%ld", &n);

  printPrime(n);

  printf("\n");

  return 0;
}