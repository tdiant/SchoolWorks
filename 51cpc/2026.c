#include "stdio.h"
#include "math.h"
int main(){
	double num;
	scanf("%lf",&num);
	printf("%d",(int)floor(num+0.5));
	return 0;
}
