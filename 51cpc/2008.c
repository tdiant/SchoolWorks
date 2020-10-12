#include "stdio.h"

int main(){
	long num, i = 0;
	scanf("%d",&num);
	while(num>0){
		printf("%ld\n",num%10);
		num /= 10;
		i += 1;
	}
	printf("%d",i);
	return 0;
} 