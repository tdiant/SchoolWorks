#include "stdio.h"

int main(){
    double Xa,Xb,Ya,Yb;
    scanf("%lf%lf%lf%lf",&Xa,&Ya,&Xb,&Yb);
    printf("%.2lf %.2lfi",Xa+Xb,Ya+Yb);
    return 0;
}
