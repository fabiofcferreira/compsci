#include <stdio.h>

int main() {
  int l, w, h, v;

  printf("L=?"); scanf("%d", &l);
  printf("W=?"); scanf("%d", &w);
  printf("H=?"); scanf("%d", &h);
  v = l*w*h;

  printf("LxWxH: %d*%d*%d (cm)\n", l, w, h);
  printf("Volume: %d (cm^3)\n", v);
  return 0;
}