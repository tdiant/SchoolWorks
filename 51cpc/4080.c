#include "stdio.h"

int main(){
	int a,b;
	scanf("%d%d",&a,&b);
	int
	m = a % 10,
	n = a / 10 % 10,
	p = b % 10,
	q = b / 10 % 10;
	printf("%d%d%d%d",m,p,n,q);
	return 0;
}
