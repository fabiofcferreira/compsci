#include <stdio.h>

int repetidos(int vec[], int size) {
  int found = 0;

  for(int i = 0; i < size; i++) {
    for(int j = i+1; j < size; j++) {
      if (vec[j] == vec[i]) {
        found = 1;
        break;
      }
    }
  }

  return found;
}

int main() {

  return 0;
}