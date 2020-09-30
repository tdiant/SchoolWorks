#include <iostream>
using namespace std;

int main() {
    int total;
    cin>>total;

    int result = 0;
    for (int i = 0; i < total; i++) {
        int num;
        cin>>num;
        if (num < 0)
            break;
        result += num;
    }
    cout<<result;
    return 0;
}