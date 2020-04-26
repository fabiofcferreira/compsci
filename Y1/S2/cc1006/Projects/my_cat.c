#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
// #include <unistd.h>

int printFile(char* filePath) {
  char c;
  FILE* f;
  
  // open file stream
  f = fopen(filePath, "r");
  if (f == NULL) {
    printf("./my_cat: %s: No such file or directory", filePath);
    exit(1);
  }

  // read every character and print it
  while ((c = fgetc(f)) != EOF) {
    fputc((char) c, stdout);
  }

  // close stream
  fclose(f);

  return 0;
}

int main(int argc, char **argv) {
  for (int i = 1; i < argc; i++) {
    printFile(argv[i]);
  }
  // int opt;

  // while ((opt = getopt(argc, argv, ":if:nbs")) != -1) {
  //   switch (opt) {
  //     case 'n':
  //       printf("n used\n");
  //       break;
  //     case 'b':
  //       printf("b used\n");
  //       break;
  //     case 's':
  //       printf("s used\n");
  //       break;
  //     case ':':
  //       printf("needs value\n");
  //       break;
  //     case '?':
  //       printf("Unknown option: %c\n", optopt);
  //       break;
  //   }
  // }

  // optind is for the extra arguments 
  // which are not parsed 
  // for(; optind < argc; optind++){      
  //     printf(“extra arguments: %s\n”, argv[optind]);  
  // } 
  // // read from stdin
  // if (argc < 2 || strcmp(argv[1], "-") == 0) {
  //   exit(0);
  // }

  // printFile(argv[1]);
  
  return 0;
}