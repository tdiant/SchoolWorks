#include <stdio.h>
#include <string.h>

int main() {
    char c, str[666];
    scanf("%s\n%c",str,&c);
    for(int i=0;i<strlen(str);i++){
        if(str[i]!=c)
            printf("%c",str[i]);
    }
    return 0;
}
