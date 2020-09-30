#include <iostream>
using namespace std;

int getNineNum(int num) {
    int result = 0, src = num;
    while (num > 0) {
        if (num % 10 == 9)
            result += 1;
        num /= 10;
    }
    return result;
}

int main() {
    int N, result = 0;
    cin >> N;
    for (int i = 1; i <= N; i++) {
        result += getNineNum(i);
    }
    cout << result;
}