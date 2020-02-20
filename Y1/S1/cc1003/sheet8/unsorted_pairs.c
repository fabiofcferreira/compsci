#include <stdio.h>

int desordem(int vec[], int size) {
  int pairs = 0;

  for(int i = 1; i < size; i++) {
    if (vec[i-1] > vec[i]) pairs++;
  }

  return pairs;
}

int main() {
  int b[6] = {3, 1, 2, 2, 4, 0};

  printf("%d\n", desordem(b, 6));

  return 0;
}