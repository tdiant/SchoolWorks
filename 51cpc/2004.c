#include "stdio.h"
int main(){
    int a,b,c,d;
    scanf("%d%d%d%d",&a,&b,&c,&d);
    printf("%d\n%d\n%d\n%d\n%d",a==b,a!=b,a!=b&&c<d,a==b||a==c,c%d!=2);
    return 0;
}