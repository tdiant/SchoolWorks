#include <stdio.h>

int main() {
    int n, max = -10000, min = 10000;
    while (1) {
        scanf("%d", &n);
        if (max < n)
            max = n;
        if (min > n)
            min = n;
        if (n == 0)
            break;
    }
    printf("%d %d", min, max);
}
