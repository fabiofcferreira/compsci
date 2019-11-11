#include <stdio.h>
#include <string.h>
#include <ctype.h>

int forte(char str[]) {
  int i, hasUpper, hasLower, hasLength, hasDigit;
  i = hasUpper = hasLower = hasDigit = hasLength = 0;

  // check digit and upper and lower case characters
  while(str[i] != '\0') {
    if(str[i] >= 'A' && str[i] <= 'Z') hasUpper = 1;
    if(str[i] >= 'a' && str[i] <= 'z') hasLower = 1;
    if(str[i] >= '0' && str[i] <= '9') hasDigit = 1;

    i++;
  }

  // check length
  if(i >= 6) hasLength = 1;

  return (hasLength && hasUpper && hasLower && hasDigit);
}

int main() {
  char pwd[] = "aaa1Aa";

  printf("%d\n", forte(pwd));

  return 0;
}