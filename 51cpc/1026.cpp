#include<cstdio>
#include<iostream>
using namespace std;
int main(){
	int x;
	cin>>x;
	if(x<0){
		cout<<x*x-1;
	} else if(x>=0 && x<1){
		cout<<x*x;
	} else if(x>=1){
		cout<<x*x+1;
	}
	return 0;
}
