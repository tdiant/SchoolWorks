#include <iostream>
using namespace std;
int main() {
    double k;
    cin >> k;
    if (k > 0) {
        cout << "positive";
    } else if (k == 0) {
        cout << "zero";
    } else if (k < 0) {
        cout << "negative";
    }
    return 0;
}
