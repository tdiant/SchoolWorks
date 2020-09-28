#include <iostream>
using namespace std;
int main() {
    int m, n;
    cin >> m >> n;
    int x = 2 * m - 0.5 * n;
    int y = 0.5 * n - m;
    cout << x << " " << y;
    return 0;
}