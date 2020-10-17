#include "stdio.h"

int main() {
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++) {
        int sum = 0, flag = 1, time = 0;
        for (int j = i; j <= n; j++) {
            sum += j;
            time += 1;
            if (sum > n) {
                flag = 0;
                break;
            } else if (sum == n) {
                break;
            }
        }
        if (!flag) {
            continue;
        } else {
            if (sum == n) {
                printf("%d=", n);
                for (int m = i; m < i + time - 1; m++) {
                    printf("%d+", m);
                }
                printf("%d", i + time - 1);
                break;
            }
        }
    }
    return 0;
}
