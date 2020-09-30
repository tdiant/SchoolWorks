#include <cstdio>
#include <iostream>
#include <stack>

int main() {
    int num;
    std::cin>>num;

    std::stack<int> s;

    int i = 0;
    while(num>0){
        int a = num % 2;
        num /= 2;
        s.push(a);
        i+=1;
    }

    while(!s.empty()){
        printf("%d",s.top());
        s.pop();
    }

    return 0;
}
