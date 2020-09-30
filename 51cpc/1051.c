#include "stdio.h"

int main() {
    int n, nums[1005], m;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", nums + i);
    scanf("%d", &m);
    for (int a = 0; a < m; a++) {
        int index;
        scanf("%d",&index);
        if(nums[index-1] % 2 == 1) {
            printf("no\n");
        } else {
            printf("yes\n");
        }
    }
    return 0;
}
