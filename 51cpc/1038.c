#include "stdio.h"

int main(){
    int result = 1, n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
        result *= i;
    printf("%d",result);
    return 0;
}