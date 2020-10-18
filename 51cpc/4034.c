#include <stdio.h>

int gcd(int a,int b);
int lcm(int a,int b);

int main() {
    int n, nums[233];
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", nums + i);
    }
    if (n == 0) {
        printf("0");
        return 0;
    }
    int lastNum = nums[0];
    for (int i = 1; i < n; i++) {
        int now = nums[i];
        lastNum = lcm(now, lastNum);
    }
    printf("%d",lastNum);
    return 0;
}

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int lcm(int a, int b) {
    return a * b / gcd(a,b);
}
