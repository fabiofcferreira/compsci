#include <stdio.h>
#include <stdlib.h>

struct element {
  int value;
  int reps;
};

typedef struct element ELEMENTS;

int findElement(ELEMENTS* els, int size, int value) {
  for (int i = 0; i < size; i++) {
    if (els[i].value == value) return i;
  }

  return -1;
}


int main() {
  ELEMENTS* els;
  int lines;
  int a;
  int valueElementIndex;

  // default values
  lines = a = valueElementIndex = 0;
  
  // read number of lines
  scanf("%d", &lines);

  // allocate memory for the array of elements
  els = (ELEMENTS*) malloc( sizeof(ELEMENTS) * lines);

  for (int i = 0; i < lines; i++) {
    scanf("%d", &a);

    valueElementIndex = findElement(els, lines, a); 
    
    // value not found
    if (valueElementIndex == -1) {
      els[i].value = a;
      els[i].reps = 1;
    } else {
      els[valueElementIndex].reps++;
    }
  }

  printf("\n");

  for (int i = 0; i < lines; i++) {
    if (els[i].reps > 1) {
      printf("%d\n", els[i].value);
    }
  }

  printf("\n");

  return 0;
}

