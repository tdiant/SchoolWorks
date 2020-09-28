#include <iostream>
using namespace std;
int main() {
    int num;
    cin >> num;
    int a = num % 10;
    int b = num / 10 % 10;
    int c = num / 100 % 10;
    cout << c << " " << b << " " << a << endl;
    cout << a + b + c;
    return 0;
}
