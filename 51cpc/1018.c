#include <stdio.h>

int main() {
    int m, n;
    scanf("%d%d",&m,&n);
    int x = 2 * m - 0.5 * n;
    int y = 0.5 * n - m;
    printf("%d %d",x,y);
    return 0;
}