#include <stdio.h>

int main() {
  int a, b, c, greatest;

  scanf("%d %d %d", &a, &b, &c);

  if (a > b) {
    if (a > c) {
      greatest = a;
    } else greatest = c;
  } else {
    if (b > c) greatest = b;
    else greatest = c;
  }

  printf("%d\n", greatest);

  return 0;
}