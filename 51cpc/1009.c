#include <stdio.h>
#include <math.h>

int main(){
	double Xa,Xb,Ya,Yb;
	scanf("%lf%lf%lf%lf",&Xa,&Ya,&Xb,&Yb);
	printf("%.2lf",sqrt((Xa-Xb)*(Xa-Xb)+(Ya-Yb)*(Ya-Yb)));
	return 0;
}
