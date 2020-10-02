#include "stdio.h"

int main() {
    int money;
    scanf("%d",&money);
    int m = 50 - money;
    int numTen = m / 10;
    int numOne = m % 10;
    printf("%d\n%d",numTen,numOne);
    return 0;
}
