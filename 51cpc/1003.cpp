#include <iostream>
using namespace std;
int main() {
    int n = 3;
    char c;
    cin >> c;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << c;
        }
        cout << endl;
    }
    return 0;
}
