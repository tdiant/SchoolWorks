#include <stdio.h>

int nums[233] = { 0 }, n, left, k, j = 0;

int main() {
    scanf("%d%d", &n, &k);
    left = n;
    if (n == 0) {
        printf("1");
        return 0;
    }
    for (int id = 0;; id++) {
        id = id % n;
        if (nums[id])
            continue;
        if (left == 1) {
            printf("%d", id + 1);
            break;
        }
        j++;
        if (j == k) {
            nums[id] = 1;
            left -= 1;
            j = 0;
        }
    }
    return 0;
}
