#include <stdio.h>

int nlower(int v[], int size, int k) {
  int x, j;

  // order with insertion sort algorithm
  for(int i = 1; i < size; i++) {
    x = v[i];
    j = i-1;

    while(j >= 0 && v[j] > x) {
      v[j+1] = v[j];
      j--;
    }

    v[j+1] = x;
  }

  return v[k];
}

int main() {
  int a[] = {5, 2, 3, 10, 4};

  printf("%d\n", nlower(a, 5, 2));

  return 0;
}