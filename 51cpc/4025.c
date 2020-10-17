#include "stdio.h"
#include "string.h"

int main() {
    char str[233];
    int num = 0;
    scanf("%[^\n]",str);
    for(int i=0;i<strlen(str);i++){
        if(str[i]<=0)
            num += 1;
    }
    printf("%d",num/2);
    return 0;
}
