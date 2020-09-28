#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
int main(){
	double Xa,Xb,Ya,Yb;
	cin>>Xa>>Ya>>Xb>>Yb;
	printf("%.2lf",sqrt((Xa-Xb)*(Xa-Xb)+(Ya-Yb)*(Ya-Yb)));
	return 0;
}
