#include <stdio.h>

int gcd(int a, int b);

int main() {
  int num, den, commonDivisor;

  printf("Numerator:");
  scanf("%d", &num);

  printf("Denominator:");
  scanf("%d", &den);

  commonDivisor = gcd(num, den);

  printf("%d/%d simplified is %d/%d\n", num, den, num/commonDivisor, den/commonDivisor);
  
  return 0;
}

int gcd(int a, int b) { 
  if (a == 0) 
    return b; 
  return gcd(b%a, a); 
} 