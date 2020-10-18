#include <stdio.h>

int main(){
	int x;
	scanf("%d",&x);
	if(x<0){
		printf("%d",x*x-1);
	} else if(x>=0 && x<1){
		printf("%d",x*x);
	} else if(x>=1){
		printf("%d",x*x+1);
	}
	return 0;
}
