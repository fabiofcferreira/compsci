#include <stdio.h>

void max_min(int vec[], int size, int *pmax, int *pmin) {
  *pmax = *pmin = vec[0];

  for (int i = 0; i < size; i++) {
    if (vec[i] >= *pmax) *pmax = vec[i];
    if (vec[i] <= *pmin) *pmin = vec[i];
  }
}

int main() {
  int a[2] = {-1, -1};

  int min = 0, max = 0;

  max_min(a, 2, &max, &min);

  printf("Min: %d\nMax: %d\n", min, max);

  return 0;
}