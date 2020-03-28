#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int abs(int a) {
  return a > 0 ? a : -a;
}

struct fraction {
  int sign;
  int numerator;
  int denominator;
  int error;
};

typedef struct fraction FRAC;

FRAC simp(FRAC f) {
  // if numerator is divideable by denominator
  if (f.numerator % f.denominator == 0) {
    f.numerator /= f.denominator;

    // denominator will become 1
    f.denominator /= f.denominator;

    return f;
  }


  // try finding a divisor of the numerator and denominator
  for (int div = f.denominator; div > 1; div--) {
    if (f.numerator % div == 0 && f.denominator % div == 0) {
      f.numerator /= div;
      f.denominator /= div;
    }
  }

  return f;
}

FRAC sum(FRAC a, FRAC b) {
  FRAC result;

  // temporarily change the numerator to the real value (negative if sign is -1)
  if (a.sign == -1) a.numerator = -a.numerator;
  if (b.sign == -1) b.numerator = -b.numerator;

  // easiest case
  // if denominator is the same, we just have to sum the numerators
  if (a.denominator == b.denominator) {
    result.numerator = a.numerator + b.numerator;
    result.denominator = a.denominator;
  } else {
    // a/b + c/d = (ad + cb)/bd
    result.numerator = (a.numerator * b.denominator) + (b.numerator + a.denominator);
    result.denominator = a.denominator * b.denominator;
  }

  // save sign
  if (result.numerator >= 0) {
    result.sign = 1;
  } else {
    result.sign = -1;
  }

  result.numerator = abs(result.numerator);

  return simp(result);
}

FRAC subtract(FRAC a, FRAC b) {
  FRAC result;

  // temporarily change the numerator to the real value (negative if sign is -1)
  if (a.sign == -1) a.numerator = -a.numerator;
  if (b.sign == -1) b.numerator = -b.numerator;

  // easiest case
  // if denominator is the same, we just have to sum the numerators
  if (a.denominator == b.denominator) {
    result.numerator = a.numerator - b.numerator;
    result.denominator = a.denominator;
  } else { // if denominator is not the same in both fractions
    // a/b - c/d = (ad - cb)/bd
    result.numerator = (a.numerator * b.denominator) - (b.numerator + a.denominator);
    result.denominator = a.denominator * b.denominator;
  }

  // save sign
  if (result.numerator >= 0) {
    result.sign = 1;
  } else {
    result.sign = -1;
  }

  // save numerator as absolute number
  result.numerator = abs(result.numerator);

  return simp(result);
}

FRAC multiply(FRAC a, FRAC b) {
  FRAC result;

  result.sign = a.sign * b.sign;
  result.numerator = a.numerator * b.numerator;
  result.denominator = a.denominator * b.denominator;

  return simp(result);
}

FRAC division(FRAC a, FRAC b) {
  FRAC result;

  result.sign = a.sign * b.sign;
  result.numerator = a.numerator * b.denominator;
  result.denominator = a.denominator * b.numerator;

  return simp(result);
}

FRAC readFraction() {
  FRAC frac = {
    1,
    0,
    0,
    0
  };
  int numerator;
  int denominator;

  printf("Enter fraction: ");

  // read fraction numerator and denominator
  scanf("%d/%d", &numerator, &denominator);

  // set numerator and change sign to negative if given numerator is negative
  if (numerator > 0) {
    frac.numerator = numerator;
  } else {
    frac.sign *= -1;
    frac.numerator = -numerator;
  }

  // valide the denominator value
  if (denominator == 0) {
    frac.error = 1;
    printf("The fraction is invalid.\n");
  }

  // set denominator and change sign to negative if given denominator is negative
  if (denominator > 0) {
    frac.denominator = denominator;
  } else {
    frac.sign *= -1;
    frac.denominator = -denominator;
  }

  return frac;
}

void printFraction(FRAC a) {
  if (a.error == 1) {
    printf("The fraction is invalid.\n");
  } else {
    if (a.sign == -1) printf("-");
    printf("%d/%d\n", a.numerator, a.denominator);
  }
}

void logOperation(FRAC a, FRAC b, FRAC res, char op) {
  if (a.error == 1 || b.error == 1) {
    printf("The operation is invalid.\n");
  } else {
    if (a.sign == -1) printf("-");
    printf("%d/%d", a.numerator, a.denominator);

    printf(" %c ", op);

    if (b.sign == -1) printf("-");
    printf("%d/%d = ", b.numerator, b.denominator);
    
    if (res.sign == -1) printf("-");
    printf("%d/%d\n", res.numerator, res.denominator);
  }
}

int main () {
  // used to select operations
  char* operation;
  operation = (char*) malloc(sizeof(char) * 256);

  FRAC a = {
    -1,
    1,
    4
  };
  FRAC b;

  while (operation[0] != 'q') {
    // a fraction current value
    printf("A = ");
    printFraction(a);

    // available operations
    printf("Avaialble operations:\n");
    printf("  1. +\n");
    printf("  2. -\n");
    printf("  3. /\n");
    printf("  4. *\n");
    printf("  5. q to quit\n");
    printf("$ ");

    // read operation
    scanf("%s", operation);

    switch (operation[0]) {
      case '+':
        printf("Please enter the fraction you want to sum with A:\n");
        b = readFraction();

        logOperation(a, b, sum(a, b), '+');

        // sum a fraction with b fraction
        a = sum(a, b);
        break;
      case '-':
        printf("Please enter the fraction you want to subtract from A:\n");
        b = readFraction();

        logOperation(a, b, subtract(a, b), '-');

        // sub a fraction with b fraction
        a = subtract(a, b);
        break;
      case '/':
        printf("Please enter the fraction you want to divide A:\n");
        b = readFraction();

        logOperation(a, b, division(a, b), '/');

        // divide a fraction with b fraction
        a = division(a, b);
        break;
      case '*':
        printf("Please enter the fraction you want to multiply by A:\n");
        b = readFraction();

        logOperation(a, b, multiply(a, b), '*');

        // multiply a fraction with b fraction
        a = multiply(a, b);
        break;
      default:
        break;
    }
  }

  return 0;
}