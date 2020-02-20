#include <stdio.h>

int main() {
  int money, twenty, ten, five, one;

  printf("Quantia em EUR? ");
  scanf("%d", &money);

  twenty = money / 20;
  money %= 20;

  ten = money / 10;
  money %= 10;

  five = money / 5;
  money %= 5;

  one = money / 1;

  printf("Notas EUR 20: %d\n", twenty);
  printf("Notas EUR 10: %d\n", ten);
  printf("Notas EUR 5: %d\n", five);
  printf("Moedas EUR 1: %d\n", one);

  return 0;
}