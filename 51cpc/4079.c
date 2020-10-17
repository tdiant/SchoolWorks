#include "stdio.h"

double count(int a, int b, char c);

int main() {
    int a, b;
    char c;
    scanf("%d%d %c", &a, &b, &c);
    printf("%.lf", count(a, b, c));
    return 0;
}

double count(int a, int b, char c) {
    switch (c) {
        default:
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            return a * 1.0 / b;
    }
}
