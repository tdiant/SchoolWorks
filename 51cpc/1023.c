#include "stdio.h"

int main() {
    char c;
    scanf("%c",&c);
    if((c>=97 && c<=122) || c>=65 && c<=90) {
        printf("A");
    } else if(c>=48 && c<=57){
        printf("1");
    } else {
        printf("#");
    }
    return 0;
}
