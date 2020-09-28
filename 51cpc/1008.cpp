#include<iostream>
#include<cstdio>
using namespace std;
int main(){
	double Xa,Xb,Ya,Yb;
	cin>>Xa>>Ya>>Xb>>Yb;
	printf("%.2lf",(Yb-Ya)/(Xb-Xa));
	return 0;
}
