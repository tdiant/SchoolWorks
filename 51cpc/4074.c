#include <stdio.h>

int main(){
	int a;
	scanf("%d",&a);
	if(a<=0){
	    printf("ERROR!");
        return 0;
	}
    for(int i=0;i<=a;i++){
        printf("%d+%d=%d\n",i,a-i,a);
    }
	return 0;
}
