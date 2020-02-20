#include <stdio.h>

int mediana (int a, int b, int c);

int main() {
  int first, second, third, middle;

  printf("First number:");
  scanf("%d", &first);
  printf("Second number:");
  scanf("%d", &second);
  printf("Third number:");
  scanf("%d", &third);

  printf("Median value: %d\n", mediana(first, second, third));

  return 0;
}


int mediana(int a, int b, int c) {
  int sum, min, max;

  // find maximum value
  if (a > b) {
    if (a > c) {
      max = a;
    } else max = c;
  } else {
    if (b > c) {
      max = b;
    } else max = c;
  }

  // find minimum valued
  min = a;
  if (b < min) min = b;
  if (c < min) min = c;

  sum = a + b + c;

  return sum - max - min;
}