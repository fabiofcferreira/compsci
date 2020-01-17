#include <stdio.h>

int max(int a, int b) {
  return a > b ? a : b;
}

int main() {
  char ch, lastCh = '\0';
  int currMax = 0, absoluteMax = 0;

  while( (ch = getchar()) != EOF) {
    if (ch != lastCh) currMax = 0;

    currMax++;
    lastCh = ch;
    absoluteMax = max(currMax, absoluteMax);
  }

  printf("%d\n", absoluteMax);

  return 0;
}