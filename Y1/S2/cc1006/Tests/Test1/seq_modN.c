#include <stdio.h>
#include <stdlib.h>
#include <string.h>

long n = 0;
long first = 1;
long last = 0;
long increment = 1;

char* delimiter = "\n";

void loop() {
  while ((increment > 0 && first <= last) ||
    (increment < 0 && first >= last)) {
    printf("%ld\n", first % n);

    first += increment;
  }
}

int main(int argc, char** argv) {
  switch (argc) {
    case 3:
      n = strtol(argv[1], NULL, 10);
      last = strtol(argv[2], NULL, 10);
      break;
    case 4:
      n = strtol(argv[1], NULL, 10);
      first = strtol(argv[2], NULL, 10);
      last = strtol(argv[3], NULL, 10);
      break;
    case 5:
      n = strtol(argv[1], NULL, 10);
      first = strtol(argv[2], NULL, 10);
      increment = strtol(argv[3], NULL, 10);
      last = strtol(argv[4], NULL, 10);
      break;
  }

  loop();

  return 0;
}