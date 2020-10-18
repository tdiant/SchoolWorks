#include <stdio.h>
#include <math.h>

int main(){
	double a,b;
	scanf("%lf%lf",&a,&b);
	printf("%.1lf",fabs(a)+fabs(b));
	return 0;
}
