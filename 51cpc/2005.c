#include <stdio.h>
int main(){
    char c;
    int i;
    scanf("%c%d",&c,&i);
    printf("%c\n%d\n%d\n%d",(c>=97?c-32:c+32),i/100,i/10%10,i%10);
    return 0;
}
