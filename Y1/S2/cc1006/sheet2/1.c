#include <stdlib.h>
#include <stdio.h>

int main(int argc,char* argv[]) {
  int sum = 0;

  for (int i = 1; argv[i] != NULL; i++) {
    sum += atoi(argv[i]);
  }

  printf("%d\n", sum);
}