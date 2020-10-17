#include "stdio.h"

int count(int num){
    if(num < -10)
        return 10;
    else if(num>=-10 && num<=10)
        return 0;
    else
        return -10;
}

int main(){
	int a;
	scanf("%d",&a);
	printf("%d",count(a));
	return 0;
}
