#include <stdio.h>
int main() {
    int num;
    scanf("%d", &num);
    if (num == 0) {
        printf("0");
    }
    while (num > 0) {
        printf("%d\n", num % 10);
        num /= 10;
    }
    return 0;
}