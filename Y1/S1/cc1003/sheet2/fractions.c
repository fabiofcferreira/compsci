#include <stdio.h>

int main() {
  int fn, fd, sn, sd, rn, rd;
  
  printf("Primeiro numerador? ");
  scanf("%d", &fn);
  printf("Primeiro denominador? ");
  scanf("%d", &fd);
  printf("Segundo numerador? ");
  scanf("%d", &sn);
  printf("Segundo denominador? ");
  scanf("%d", &sd);

  rn = (fn * sd) + (sn * fd);  
  rd = fd * sd; 

  printf("%d/%d + %d/%d = %d/%d\n", fn, fd, sn, sd, rn, rd);

  return 0;
}