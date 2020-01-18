#include <stdio.h>

int prox_bissexto(int n);

int main() {
  int year;

  scanf("%d", &year);

  printf("%d\n", prox_bissexto(year));

  return 0;
}

int prox_bissexto(int n) {
  int i = n;

  while((i % 4 != 0) || (i % 100 == 0 && i % 400 != 0)) i++;

  return i;
}