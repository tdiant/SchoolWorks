#include "stdio.h"

#define boolean int
#define true 1
#define false 0

boolean isPrime(int num);

int main() {
    int num;
    scanf("%d", &num);
    for (int i = 1; i < num; i++) {
        if (num - i < i)
            break;
        if (isPrime(i) && isPrime(num - i)) {
            printf("%d = %d + %d\n", num, i, num - i);
        }
    }
    return 0;
}

boolean isPrime(int num) {
    if (num == 1)
        return true; //sb oj,fuck!!!!!!
    if (num <= 1)
        return false;
    for (int i = 2; i <= ((num + 1) / 2); i++) {
        if (num % i == 0)
            return false;
    }
    return true;
}
