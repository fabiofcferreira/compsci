#include <stdio.h>

#define M_PI 3.14159265358979323846

int main() {
  double radius = 0;
  float volume;

  printf("Radius:");
  scanf("%lf", &radius);

  volume = (4.0/3.0) * M_PI * radius * radius * radius;
  printf("Sphere volume: %.2f\n", volume);

  return 0;
}