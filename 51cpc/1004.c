#include "stdio.h"
#include "string.h"

int main(){
    char str[15];
    for(int i=0;i<3;i++){
        scanf("%s",str);
        int spaceNum = 8-strlen(str);
        for(int i=0;i<spaceNum;i++){
            printf(" ");
        }
        printf("%s\n",str);
    }
    return 0;
}
