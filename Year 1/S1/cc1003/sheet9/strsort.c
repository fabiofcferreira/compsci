#include <stdio.h>
#include <string.h>

void insert_sort(char vec[], int n) {
  int i, j;

  for(i = 1; i < n; i++) {
    int x = vec[i];
    j = i-1;
    while(j>=0 && vec[j] > x) {
      vec[j+1] = vec[j];
      j--;
    }
    vec[j+1] = x;
  }
}

int anagramas(char str1[], char str2[]) {
  insert_sort(str1, strlen(str1));
  insert_sort(str2, strlen(str2));

  int max = strlen(str1);
  if (strlen(str2) > strlen(str1)) max = strlen(str2);

  for(int i = 0; i < max; i++) {
    if(str1[i] != str2[i]) return 0;
  }

  return 1;
}


int main() {
  char ch1[3] = "a";
  char ch2[3] = "aa";
  int r = anagramas(ch1, ch2);

  printf("%d\n", r);

  return 0;
}

