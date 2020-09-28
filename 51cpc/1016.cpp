#include <iostream>
using namespace std;
int main() {
    int money;
    cin >> money;
    int m = 50 - money;
    int numTen = m / 10;
    int numOne = m % 10;
    cout << numTen << endl << numOne;
    return 0;
}
