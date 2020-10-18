#include <stdio.h>

int main() {
    int num, src, sum = 0;
    scanf("%d", &num);
    src = num;
    for (int i = 1; i < num; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }
    printf(sum == src ? "yes" : "no");
    return 0;
}
