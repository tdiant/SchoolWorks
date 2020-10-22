#include <stdio.h>

int main() {
    int nums[1080], status[1080] = {0}, n, k = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", nums + i);
        for (int j = 0; j < i; j++) {
            if (nums[j] == nums[i]) {
                status[i] = 1;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if (!status[i])
            k += 1;
    }
    printf("%d\n", k);

    for (int i = 0; i < n; i++) {
        if (!status[i])
            printf("%d ", nums[i]);
    }
    return 0;
}
