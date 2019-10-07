#include <stdio.h>

int main() {
  int first, second, third;

  printf("First side:");
  scanf("%d", &first);
  printf("Second side:");
  scanf("%d", &second);
  printf("Third side:");
  scanf("%d", &third);

  if (first == second && first == third) {
    printf("The triangle is equilateral.\n");
  } else if (first != second && first != third) {
    printf("The triangle is scalene.\n");
  } else if (
    first == second && first != third ||
    first == third && first != second ||
    second == third && second != first
  ) {
    printf("The triangle is isosceles.\n");
  }

  return 0;
}