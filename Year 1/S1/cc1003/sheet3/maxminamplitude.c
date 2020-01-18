#include <stdio.h>
#include <math.h>

int main() {
  int first, second, third, max, min, amp;

  printf("First number:");
  scanf("%d", &first);
  printf("Second number:");
  scanf("%d", &second);
  printf("Third number:");
  scanf("%d", &third);


  // find maximum value
  if (first > second) {
    if (first > third) {
      max = first;
    } else max = third;
  } else {
    if (second > third) {
      max = second;
    } else max = third;
  }

  // find minimum valued
  min = first;
  if (second < min) min = second;
  if (third < min) min = third;

  printf("Maximum number: %d\n", max);
  printf("Minimum number: %d\n", min);
  printf("Amplitude: %d\n", max - min);

  return 0;
}