#include <stdio.h>

int contar_maiores(int vec[], int size, int val) {
  int numGreat = 0;

  for(int i = 0; i < size; i++) {
    if(vec[i] > val) numGreat++;
  }

  return numGreat;
}

int main() {
  int test[5] = {1, 5, 3, 10, 7};

  printf("%d\n", contar_maiores(test, 5, 4));

  return 0;
}