#include <stdio.h>

void sort_desc(int vec[], int n) {
  int i, j;

  for(i = 1; i < n; i++) {
    int x = vec[i];
    j = i-1;
    while(j>=0 && vec[j] < x) {
      vec[j+1] = vec[j];
      j--;
    }
    vec[j+1] = x;
  }
}

int main() {
  int a[5] = {1, 2, 0, 4, 5};

  sort_desc(a, 5);
  
  return 0;
}