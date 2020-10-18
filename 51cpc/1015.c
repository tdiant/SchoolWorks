#include <stdio.h>

int main() {
    int num;
    scanf("%d",&num);
    int a = num % 10;
    int b = num / 10 % 10;
    int c = num / 100 % 10;
    printf("%d %d %d\n%d",c,b,a,a+b+c);
    return 0;
}
