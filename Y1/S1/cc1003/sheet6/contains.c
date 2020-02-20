#include <stdio.h>

int ocorre(int vec[], int size, int val) {
  int i, ocorre = 0;

  for(i = 0; i < size; i++) {
    if (val == vec[i]) {
      ocorre = 1;
      break;
    }
  }

  return ocorre;
}

int main() {
  int a[4] = {2, 3, 4, 7};

  printf("%d\n", ocorre(a, 4, 10));

  return 0;
}