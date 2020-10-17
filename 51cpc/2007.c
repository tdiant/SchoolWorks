#include "math.h"
#include "stdio.h"

int main() {
    double a, b, c, delta;
    scanf("%lf%lf%lf", &a, &b, &c);

    delta = b * b - 4 * a * c;

    if (a == 0) {
        double x = -c / b;
        printf("%.2lf", x);
    } else {
        if (delta < 0) {
            double m = -b / (2 * a);
            double n = sqrt(-delta) / (2 * a);
            printf("x1=%.2lf+%.2lfj\nx2=%.2lf-%.2lfj", m, n, m, n);
        } else {
            double x1 = (-b + sqrt(delta)) / (2 * a);
            double x2 = (-b - sqrt(delta)) / (2 * a);
            printf("x1=%.2lf\nx2=%.2lf", x1 > x2 ? x1 : x2, x1 > x2 ? x2 : x1);
        }
    }

    return 0;
}
