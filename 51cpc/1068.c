#include "stdio.h"

int main() {
    int n, max = 0, num = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int a, b, c, d, e, score;
        scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
        score = a + b + c + d + e;
        if (score < 85)
            num += 1;
        if (max < score)
            max = score;
    }
    if(num!=n)
        printf("%d %d", num, max);
    else
        printf("%d No", num);
    return 0;
}
