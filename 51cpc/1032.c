#include "math.h"
#include "stdio.h"

int main() {
    double a, b, c, delta;
    scanf("%lf%lf%lf", &a, &b, &c);

    delta = b * b - 4 * a * c;

    if (delta < 0) {
        printf("error");
    } else if (delta == 0) {
        printf("%.lf", -b / (2 * a));
    } else {
        double x1 = (-b + sqrt(delta)) / (2 * a);
        double x2 = (-b - sqrt(delta)) / (2 * a);
        printf("%.lf %.lf", x1 < x2 ? x1 : x2, x1 < x2 ? x2 : x1);
    }
    return 0;
}
