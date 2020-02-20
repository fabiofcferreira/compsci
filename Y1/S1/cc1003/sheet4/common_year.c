#include <stdio.h>

int bissexto(int n);

int main() {
  int y;

  scanf("%d", &y);

  if (bissexto(y) == 0) printf("The year %d is a common year\n", y);
  else printf("The year %d is not a common year\n", y);
}

int bissexto(int n) {
  return n % 4 == 0 ? 0 : 1;
}