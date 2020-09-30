#include <iostream>
using namespace std;

int main() {
    int num, i = 0;
    cin>>num;
    while (num>1 && num%2==0){
        num>>=1;
        i += 1;
    }
    cout<<i;
    return 0;
}
