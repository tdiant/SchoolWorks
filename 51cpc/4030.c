#include "stdio.h"
int main() {
    int m;
    scanf("%d", &m);
    for (int j = 0; j < m; j++) {
        int n, i = 0;
        scanf("%d", &n);
        while (n != 1) {
            if (n % 2) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }
            i++;
        }
        printf("%d\n", i);
    }
    return 0;
}
