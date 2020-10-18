#include <stdio.h>
int main(){
	int a;
	char b[25];
	double c;
	scanf("%d%s%lf",&a,b,&c);
	if(a>0) printf("+");
	printf("%d\n",a);
	
	printf("%s\n",b);
	
	if(c>0) printf("+");
	printf("%.2lf",c);
	return 0;
}
