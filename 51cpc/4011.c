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
    int L, R, n = 0;
    scanf("%d%d", &L, &R);
    for (int i = L; i <= R; i++) {
        if (isPrime(i))
            n += 1;
    }
    printf("%d", n);
    return 0;
}
