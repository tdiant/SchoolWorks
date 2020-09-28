#include <iostream>
#include <cstring>
using namespace std;
int main(){
	char str[15];
	while(cin>>str){
		int spaceNum = strlen(str);
		for(int i=0;i<spaceNum;i++){
			cout<<" ";
		}
		cout<<str<<endl;
	}
	return 0;
}