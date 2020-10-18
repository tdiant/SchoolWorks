#include <stdio.h>

int main(){
    int n;
    long result = 0;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        int num;
        scanf("%d",&num);
        result += num;
    }
    printf("%.2lf",result*1.0/n);
    return 0;
}
