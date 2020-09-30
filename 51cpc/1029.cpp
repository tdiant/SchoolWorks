#include <iostream>
#include <cstdio>
using namespace std;

int main(){
    double srcMoney;
    cin>>srcMoney;

    double a = 1;

    if(srcMoney>=200) a = 0.9;
    if(srcMoney>=500) a = 0.8;
    if(srcMoney>=1000) a = 0.5;

    printf("%.2lf",srcMoney * a);

    return 0;
}
