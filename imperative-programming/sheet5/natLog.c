#include <stdio.h>

double serie_log(double x, int n) {
  double sum = 0;
  double xPower = 1;

  for (int i = 1; i <= n; i++) {
    // calc (-1) power
    double oneBase = -1;
    int oneExp = i + 1;
    while (oneExp > 1) {
      oneBase *= -1;
      
      oneExp--;
    }

    // calc new x powered to i
    xPower *= x;

    sum += oneBase * (xPower / i);
  }

  return sum;
}


int main() {
  double x;
  int n;

  scanf("%lf %d", &x, &n);
  printf("%lf\n", serie_log(x, n));

  return 0;
}