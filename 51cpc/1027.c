#include <stdio.h>
#define PI 3.1415926

int main() {
    int type;
    double a, b, r;
    scanf("%d", &type);

    switch (type) {
        case 1:
            scanf("%lf%lf", &a, &b);
            printf("%d\n", (int) (a * b));
            break;
        case 2:
            scanf("%lf%lf", &a, &b);
            printf("%d\n", (int) (a * b * 0.5));
            break;
        case 3:
            scanf("%lf%lf", &r);
            printf("%d\n", (int) (PI * r * r));
            break;
    }
    return 0;
}