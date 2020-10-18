#include <stdio.h>
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
    int n, max = 0;
    scanf("%d", &n);
    for (int i = n - 1; i > 1; i--) {
        if (n % i != 0)
            continue;
        int m = n / i;
        if (m > i)
            break;
        if (isPrime(m) && isPrime(i)) {
            if (max < i)
                max = i;
        }
    }
    printf("%d", max > 0 ? max : n);
    return 0;
}
