#include <stdio.h>

int main() {
  int x[3] = {23, 41, 17};

  printf("%d\n", x[0]); // array's first value
  printf("%d\n", x[1]); // array's second value
  printf("%d\n", x[2]); // array's third value
  printf("%p\n", x);  // address of the first element
  printf("%d\n", *x); // value held by the first element's address
  printf("%p\n", x+1); // address of the second element
  printf("%d\n", *(x+1)); // value held by the second element's address
  printf("%p\n", x+2); // address of the third element
  printf("%d\n", *(x+2)); // value held by the third element's address 
  printf("%p\n", &(x[0])); // address that holds the first element
  printf("%d\n", *&(x[0])); // value of the address of the first element
  // printf("%p\n", &*(x[0]));
  
  // the expression above is not valid since x[i] is the value of the array in the index i, which is another notation for (x+i)
}