#include <stdio.h>

int main() {
  double x;

  scanf("%lf", &x);

  printf("Result of 3x⁵ + 2x⁴ - 5x³ - x² + 7x - 6: ");
  printf("%.2lf\n", (3 * (x*x*x*x*x) + 2 * (x*x*x*x) - 5 *(x*x*x) - (x*x) + 7*x - 6));

  return 0;
}