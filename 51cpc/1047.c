#include "stdio.h"

int main() {
    int n, score[1005];
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", score + i);
    int m;
    scanf("%d", &m);
    for (int i = 0; i < m; i++) {
        int num;
        scanf("%d", &num);
        printf("%d ", score[num - 1]);
    }
    return 0;
}