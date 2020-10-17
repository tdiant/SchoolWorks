#include "stdio.h"
#include "string.h"

int main() {
    char str[233];
    scanf("%[^\n]",str);

    int flag = 1;
    for(int i=0;i<strlen(str);i++){
        if(flag){
            char c = str[i];
            if(c>=97){
                c -= 32;
            }
            printf("%c",c);
            flag = 0;
            continue;
        }
        if(str[i]==' '){
            flag = 1;
        }
    }

    return 0;
}
