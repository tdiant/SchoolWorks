#include <stdio.h>

int main() {
    int num, src, sum = 0;
    scanf("%d", &num);
    src = num;
    while (num > 0) {
        sum += (num % 10) * (num % 10) * (num % 10);
        num /= 10;
    }
    printf(src==sum?"YES":"NO");
    return 0;
}
