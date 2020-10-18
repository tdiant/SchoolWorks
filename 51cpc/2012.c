#include <stdio.h>

int sum(int nums[]);
void trans(int nums[]);

int main() {
    int nums[15];
    for (int i = 0; i < 10; i++) scanf("%d", nums + i);
    printf("%d\n", sum(nums));
    trans(nums);
    for (int i = 0; i < 10; i++) {
        printf("%d ", nums[i]);
    }
    return 0;
}

int sum(int nums[]) {
    int returnBack = 0;
    for (int i = 0; i < 10; i++) returnBack += nums[i];
    return returnBack;
}

void trans(int nums[]) {
    for (int i = 0; i < 5; i++) {
        int j = 9 - i;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
