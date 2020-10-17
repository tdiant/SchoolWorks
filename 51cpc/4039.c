#include "stdio.h"
int main() {
    int n;
    char s[10][15] = { "Monday", "Tuesday", "Wednsday", "Thursday", "Friday", "Saturday", "Sunday" };
    scanf("%d", &n);
    printf("%s", s[n - 1]);
    return 0;
}
