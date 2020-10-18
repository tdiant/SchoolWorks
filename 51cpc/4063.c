#include <stdio.h>

int main(){
    int n,num,max=-2147483648,min=2147483647;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&num);
        if(num>max)
            max = num;
        if(num<min)
            min = num;
    }
    printf("%d %d",min,max);
	return 0;
}
