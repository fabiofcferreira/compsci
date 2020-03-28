#include <stdio.h>
#include <stdlib.h>

int* readarray(int n) {
  int i;
  int* v;

  // allocate space in memory
  v = (int*) malloc(sizeof(int) * n);

  for (i = 0; i < n; i++) {
    scanf(" %d", v+i);
  }

  return v;
}


int* arraysum(int* a, int* b, int n) {
  int* resultArray;
  resultArray = (int*) malloc(sizeof(int) * n);
  
  for (int i = 0; i < n; i++) {
    resultArray[i] = a[i] + b[i];
  }

  return resultArray;
}

int arrayprint(int* v, int n) {
  for (int i = 0; i < n-1; i++) {
    printf("%d,", v[i]);
  }

  printf("%d\n", v[n-1]);

  return 0;
}

int main() {
  int n;
  int *va, *vb, *vr;
  scanf("%d", &n);

  // read arrays
  va = readarray(n);
  vb = readarray(n);

  // sum arrays
  vr = arraysum(va, vb, n);

  // print arrays
  arrayprint(va, n);
  arrayprint(vb, n);
  arrayprint(vr, n);

  return 0;
}