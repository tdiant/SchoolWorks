#include <stdio.h>

#define boolean int
#define true 1
#define false 0

int main() {
    int n, score[1005], m;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", score + i);
    scanf("%d", &m);
    for (int a = 0; a < m; a++) {
        int target;
        scanf("%d", &target);
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (score[i] == target) {
                flag = true;
                break;
            }
        }
        if (flag) {
            printf("yes\n");
        } else {
            printf("no\n");
        }
    }
    return 0;
}
