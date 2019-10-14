#include <stdio.h>

int main() {
  int first, second, third, distinct;

  printf("First number:");
  scanf("%d", &first);
  printf("Second number:");
  scanf("%d", &second);
  printf("Third number:");
  scanf("%d", &third);


  if (first == second && first == third) {
    printf("0 distinct values.\n");
  } else if (first != second && first != third && second != third) {
    printf("3 distinct values.\n");
  } else if (
    first == second && first != third ||
    first == third && first != second ||
    second == third && second != first
  ) {
    printf("2 distinct values.\n");
  }

  return 0;
}