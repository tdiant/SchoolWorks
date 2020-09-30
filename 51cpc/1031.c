#include "stdio.h"
#include "string.h"
#include "math.h"
#define PI 3.1415926
#define HALF_PI PI/2

double getCos(int a,int b,int c){
    return (a*a+b*b-c*c)*1.0/(2*a*b);
}

int main() {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    double cosA = getCos(b, c, a);
    double cosB = getCos(c, a, b);
    double cosC = getCos(a, b, c);

    double p = 0.5 * (a + b + c);
    double s = sqrt(p * (p - a) * (p - b) * (p - c) * 1.0);

    int flag = 0;

    if (a + b > c && a + c > b && b + c > a) {
        if (cosA == 0 || cosB == 0 || cosC == 0) {
            printf("直角三角形");
            flag = 1;
        } else if (cosA < 0 || cosB < 0 || cosC < 0) {
            printf("钝角三角形");
            flag = 1;
        } else if (cosA > 0 && cosB > 0 && cosC > 0) {
            printf("锐角三角形");
            flag = 1;
        } else {
            printf("ERROR");
        }
    } else {
        printf("ERROR");
    }

    if (flag)
        printf("\n%.2lf", s);
    return 0;
}
