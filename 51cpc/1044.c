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
    int N;
    scanf("%d",&N);
    
    if (N <= 3) {
        printf("1");
        return 0;
    }
    for (int i = N - 1; i > 1; i--) {
        if (isPrime(i)) {
            printf("%d",i);
            break;
        }
    }
}
