#include <stdio.h>

int main() {
    int num, i = 0;
    scanf("%d", &num);
    while (num > 0) {
        num /= 10;
        i += 1;
    }
    printf("%d", i);
    return 0;
}
