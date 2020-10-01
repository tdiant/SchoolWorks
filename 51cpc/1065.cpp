#include <cstdio>
#include <iostream>
#include <stack>

int getNum(int num);

int main() {
    int num;
    std::cin>>num;

    std::cout<<getNum(num);

    return 0;
}

int getNum(int num){
    std::stack<int> s;

    int i = 0;
    while(num>0){
        int a = num % 8;
        num /= 8;
        s.push(a);
        i+=1;
    }

    int result = 0;

    while(!s.empty()){
        result *= 10;
        result += s.top();
        s.pop();
    }

    return result;
}
