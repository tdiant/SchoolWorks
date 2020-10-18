#include <stdio.h>

int main() {
    double sum = 0;
    int k, n = 1;
    scanf("%d", &k);
    while (1) {
        sum += 1.0 / n;
        if (sum > k) {
            printf("%d", n);
            break;
        }
        n += 1;
    }
    return 0;
}
