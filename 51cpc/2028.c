#include "stdio.h"

int main() {
    int n, last = -1;
    for (int i = 0; i < 3; i++) {
        scanf("%d", &n);
        if (n > last)
            last = n;
    }
    printf("%d", last);
    return 0;
}