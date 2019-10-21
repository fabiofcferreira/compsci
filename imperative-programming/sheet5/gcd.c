#include <stdio.h>

long mdc(long a, long b) {
  long r;
  long i = 0;
  
  while(b != 0) {
    printf("mdc(%ld, %ld) = ", a, b);
    
    r = a%b;
    a = b;
    b = r;

    i++;
  }

  // print gcd
  printf("%ld\n", a);
  
  return i;
}

int main() {
  long m, n;
  
  scanf("%ld %ld", &m, &n);

  printf("%ld iterations.\n", mdc(m, n));
}