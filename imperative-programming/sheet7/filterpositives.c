#include <stdio.h>

int filtrar_positivos(int vec[], int size) {
  int positives = 0;

  for (int i = 0; i < size; i++) {
    if (vec[i] <= 0) {
      for(int j = i+1; j < size; j++) {
        if (vec[j] > 0) {
          vec[i] = vec[j];
          vec[j] = 0;
          break;
        }
      }
    }
  }

  for(int a = 0; a < size; a++) {
    if (vec[a] > 0) positives++;
  }

  return positives;
}

int main() {
  int b[2] = {1, 2};

  printf("%d\n", filtrar_positivos(b, 2));

  return 0;
}