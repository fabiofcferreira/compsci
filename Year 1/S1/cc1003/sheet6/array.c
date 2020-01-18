#include <stdio.h>

void range(int vec[], unsigned size, int inicio, int incr) {
  for(int i = 0; i < size; i++) {
    vec[i] = inicio;
    inicio += incr;
  }
}

int main() {
  int b[5];
  range(b, 5, 3, 2); /* a[] passa a conter { 3, 5, 7, 9, 11 } */


  return 0;
}