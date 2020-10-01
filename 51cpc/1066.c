#include "stdio.h"

int getFibonacci(int num);

int getFibonacci(int target);
int getFibonacci(int target, int i, int a, int b);

int main() {
    int target;
    scanf("%d",&target);
    printf("%d",getFibonacci(target));
    return 0;
}

int getFibonacci(int target) {
    if (target == 1) return 0;
    if (target == 2) return 1;
    return getFibonacci(target, 3, 1, 0);
}

int getFibonacci(int target, int i, int a, int b) {
    if (i > target + 1)
        return a;
    return getFibonacci(target, i + 1, a + b, a);
}
