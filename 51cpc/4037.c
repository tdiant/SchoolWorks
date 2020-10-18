#include <stdio.h>

int main() {
    int num;
    scanf("%d",&num);
    for(int i=num;i<=100;i++){
        if(i%9==0){
            printf("%d ",i);
        }
    }
    return 0;
}
