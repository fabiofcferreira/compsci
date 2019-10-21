#include <stdio.h>
#include <ctype.h>

int main() {
  long int counter = 0;
  char ch;

  int started = 0;

  while (1) {
    ch = getchar();
    if (ch == EOF) break;

    if (started == 0 && isspace(ch) == 0) started = 1;
    else {
      if (started == 1 && isspace(ch) != 0) {
        started = 0;
        counter++;
      }
    }
  }

  printf("%ld\n",counter);
}