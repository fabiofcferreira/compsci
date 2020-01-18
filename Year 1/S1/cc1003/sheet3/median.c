#include <stdio.h>

int main() {
  int first, second, third, middle;

  printf("First number:");
  scanf("%d", &first);
  printf("Second number:");
  scanf("%d", &second);
  printf("Third number:");
  scanf("%d", &third);

  if (first > second) {
    if (first > third) {
      if (third > second) middle = second;
      else middle = third;
    } else middle = first;
  } else {
    if (second > third) {
      middle = third;
    } else middle = second;
  }

  printf("Median value: %d\n", middle);

  return 0;
}