#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;
int main(){
	char str[66];
	cin>>str;
	for(int i=0;i<strlen(str);i++){
		printf("%c",str[i]+2);
	}
	return 0;
}
