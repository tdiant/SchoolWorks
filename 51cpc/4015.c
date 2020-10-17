#include "stdio.h"

#define boolean int
#define true 1
#define false 0

boolean isPrime(int num) {
    if (num <= 1)
        return false;
    for (int i = 2; i <= ((num + 1) / 2); i++) {
        if (num % i == 0)
            return false;
    }
    return true;
}

int main() {
    int n, sum = 0;
    scanf("%d", &n);
    for (int i = 2; i <= n; i++) {
        if (isPrime(i))
            sum += i;
    }
    printf("%d", sum);
    return 0;
}
