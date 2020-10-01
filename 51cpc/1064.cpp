#include<iostream>
using namespace std;

bool isPrime(int num);

int main() {
    int num;
    cin >> num;
    for (int i = 1; i < num; i++) {
        if (num - i < i)
            break;
        if (isPrime(i) && isPrime(num - i)) {
            cout << num << " = " << i << " + " << num - i << endl;
        }
    }
    return 0;
}

bool isPrime(int num){
    if(num == 1)
        return true; //sb oj,fuck!!!!!!
    if(num<=1)
        return false;
    for(int i=2;i<=((num+1)/2);i++){
        if(num%i == 0)
            return false;
    }
    return true;
}
