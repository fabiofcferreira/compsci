#include <stdio.h>

int ordenada(int vec[], int size) {
  int sortedasc = 1;

  for(int i = 1; i < size; i++) {
    if (vec[i-1] > vec[i]) sortedasc = 0;
  }

  return sortedasc;
}

int main() {
  int a[5] = {1, 2, 0, 4, 5};

  printf("%d\n", ordenada(a, 5));
  
  return 0;
}