#include <stdio.h>

int main() {
    int total;
    scanf("%d", &total);

    int result = 0;
    for (int i = 0; i < total; i++) {
        int num;
        scanf("%d", &num);
        if (num < 0)
            break;
        result += num;
    }
    printf("%d", result);
    return 0;
}