#include <iostream>
#include <cstdio>
using namespace std;

int main(){
    int n;
    long result = 0;
    cin>>n;
    for(int i=0;i<n;i++){
        int num;
        cin>>num;
        result += num;
    }
    printf("%.2lf",result*1.0/n);
    return 0;
}
