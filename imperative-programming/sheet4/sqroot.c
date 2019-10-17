#include <stdio.h>

int main() {
  double a;
  double initDiv;

  printf("Square root of:");
  scanf("%lf", &a);

  initDiv = a / 2.0;

  for (int i = 1; i < 10; i++) {
    double nextPrecisionValue = (1.0/2.0) * (initDiv + (a / initDiv));

    initDiv = nextPrecisionValue;
  }

  printf("%f\n", initDiv);

  return 0;
}