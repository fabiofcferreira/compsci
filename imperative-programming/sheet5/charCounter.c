#include <stdio.h>
#include <ctype.h>

int main() {
  long int counter;
  char ch;

  while(1) {
    ch = getchar();
    if (ch == '\n') break;

    if (isalpha(ch) != 0) counter++;
  }

  printf("Phrase contains %ld characters\n", counter);
}