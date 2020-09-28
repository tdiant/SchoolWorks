#include <iostream>
#include <cstdio>
using namespace std;
int main() {
    double a1, a2, a3, a0, x;
    cin >> a1 >> a2 >> a3 >> a0 >> x;
    printf(
            "%.2lf",
            a1 * x * x * x +
            a2 * x * x +
            a3 * x +
            a0
    );
    return 0;
}
