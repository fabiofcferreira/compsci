#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

// esp replaces the non-alphanumeric characters with a space in the string given
void esp(char* s) {
  int i = 0;

  // loop the string
  while (s[i] != '\0') {
    // replace all non-alphanumeric characters with a space
    if (isalpha(s[i]) == 0 && isdigit(s[i]) == 0) {
      s[i] = ' ';
    }

    i++;
  }
}

// esp1 doesn't change the string given, as it uses pass by reference. Thus 
// it creates a new string, performs the replacement and returns the result
char* esp1(char *s) {
  // allocate memory for the string
  char* mirrorStr;
  mirrorStr = (char*) malloc(strlen(s));

  // copy string from original to the mirror
  strcpy(mirrorStr, s);

  // perform actual replacement in the mirror string
  esp(mirrorStr);

  return mirrorStr;
}

int main() {
  char str[10] = "a, Ah Ah!";

  char* result = esp1(str);
  printf("%s\n", str);
  printf("%s\n", result);  

  return 0;
}