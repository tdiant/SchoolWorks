#include <stdio.h>
#include <math.h>

double PI=3.14;
int main(){
	double angle;
	scanf("%lf",&angle);
	angle=(angle/180)*PI;
	printf("%.2lf\n%.2lf",sin(angle),cos(angle));
	return 0;
}
