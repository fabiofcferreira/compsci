#include <stdio.h>

int main() {
  double x;

  scanf("%lf", &x);

  printf("Result of 3x⁵ + 2x⁴ - 5x³ - x² + 7x - 6: ");

  // printf("%.2lf\n", (x -6) * (x + 7 * ((x -1) * ((x - 5) * (3*x + 2)))));

  printf("%.2lf\n", (x -6) * ( (x + 7) * ( (x - 1) * ((x - 5) * (3 * x + 2)))));

  return 0;
}