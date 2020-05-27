#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <unistd.h>

char* string0 = "";
char* string1 = "";
int useStdin = 0;

char *replaceStr(char* orig, char* old, char *with) {
  char *result; // the return string
  char *ins;    // the next insert point
  char *tmp;    // varies
  int len_old;  // length of the old substring (the string to remove)
  int len_with; // length of with (the string to replace rep with)
  int len_front; // distance between old and end of last old
  int occurrences;    // number of replacements

  // sanity checks and initialization
  if (!orig || !old) return NULL;
  len_old = strlen(old);
  
  if (len_old == 0) return NULL; // empty rep causes infinite loop during occurrences
  if (!with)
    with = "";
  len_with = strlen(with);

  // count the number of replacements needed
  ins = orig;
  for (occurrences = 0; (tmp = strstr(ins, old)); ++occurrences) {
    ins = tmp + len_old;
  }

  tmp = result = malloc(strlen(orig) + (len_with - len_old) * occurrences + 1);

  if (!result) return NULL;

  // first time through the loop, all the variable are set correctly
  // from here on,
  //    tmp points to the end of the result string
  //    ins points to the next occurrence of old in orig
  //    orig points to the remainder of original after "end of old"
  while (occurrences--) {
      ins = strstr(orig, old);
      len_front = ins - orig;
      tmp = strncpy(tmp, orig, len_front) + len_front;
      tmp = strcpy(tmp, with) + len_with;
      orig += len_front + len_old; // move to next "end of old"
  }

  strcpy(tmp, orig);


  return result;
}

int printFile(char* filePath) {
  FILE* f;
  
  char* line = NULL;
  size_t lineSize_buf = 0;
  size_t lineSize = 0;

  // char lastPrintedCh;
  
  // open file stream
  if (useStdin) f = stdin;
  else {
    f = fopen(filePath, "r");
    if (f == NULL) {
      printf("./my_cat: %s: No such file or directory\n", filePath);
      return 1;
    }
  }

  while ( (lineSize = getline(&line, &lineSize_buf, f)) != -1 ) {
    if (lineSize > 0) printf("%s", replaceStr(line, string0, string1));

    lastPrintedCh = line[0] != '\n' ? line[strlen(line) - 3] : '\n';
  }

  // if ( lastPrintedCh != '\n' ) printf("\n");

  // close stream
  if (!useStdin) fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  if (argc < 4 || argv[3][0] == '-') {
    useStdin++;
  }

  // get arguments
  string0 = argv[1];
  string1 = argv[2];

  // print parts of the file/stdin
  if (argc > 4) {
    for(int i = 3; i < argc; i++) {
      if (argv[i][0] == '-') {
        useStdin++;
        printFile(argv[i]);
        useStdin--;
      }
      else printFile(argv[i]);
    }
  } else printFile(argv[3]);

  return 0;
}