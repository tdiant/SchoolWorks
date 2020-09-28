#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
double PI=3.14;
int main(){
	double angle;
	cin>>angle;
	angle=(angle/180)*PI;
	printf("%.2lf\n%.2lf",sin(angle),cos(angle));
	return 0;
}
