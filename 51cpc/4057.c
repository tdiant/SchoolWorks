#include <stdio.h>

int main() {
    int n, nums[233] = {0}, a;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &a);
        nums[a - 1] += 1;
    }

    for (int i = 0; i <= n; i++) { //i don't know why it is work!
        if (nums[i] != 0) {
            printf("%d %d\n", i + 1, nums[i]);
        }
    }
    return 0;
}
