#include "stdio.h"

int main() {
    int n, s = 2, t = 3, j = 0;
    scanf("%d", &n);
    n = n + 1;
    for (; t > 0 && n != 0;) {
        t = n / 12;
        n = n - 12;
        j++;
    }
    if (j == 1) {
        printf("%d", s);
    } else {
        s = 2 + (j - 1) * 4;
        printf("%d", s);
    }
    return 0;
}
