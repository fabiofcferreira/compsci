#include <stdio.h>

int main() {
  double untaxed;

  printf("Valor sem IVA? ");
  scanf("%lf", &untaxed);

  printf("Valor com IVA: %.2f\n", 1.23 * untaxed);

  return 0;  
}