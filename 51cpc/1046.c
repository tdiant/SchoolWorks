#include <stdio.h>

int main() {
    int num, i = 0;
    scanf("%d",&num);
    while (num>1 && num%2==0){
        num>>=1;
        i += 1;
    }
    printf("%d",i);
    return 0;
}
