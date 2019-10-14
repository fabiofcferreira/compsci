#include <stdio.h>

int prox_bissexto(int n);

int main() {
  int year;

  scanf("%d", &year);

  printf("%d\n", prox_bissexto(year));

  return 0;
}

int prox_bissexto(int n) {
  if (n % 4 == 0) return n;

  int i = n;

  while(1) {
    if (i % 4 == 0) return i; 
    
    i++;
  }
}