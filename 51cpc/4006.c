#include "stdio.h"

int main() {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    printf(a + b > c && b + c > b && a + c > b ? "Yes" : "No");
}
