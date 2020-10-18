#include <stdio.h>

int nums[1500] = { 0 };

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int a;
        scanf("%d", &a);
        nums[a] = 1;
    }

    int total = 0;
    for (int i = 0; i < 1500; i++) {
        if (nums[i])
            total += 1;
    }

    printf("%d\n", total);
    for (int i = 0; i < 1500; i++) {
        if (nums[i])
            printf("%d ", i);
    }
    return 0;
}
