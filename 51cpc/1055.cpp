#include <iostream>
using namespace std;

/*
* 1054 is same as 1055
*/

int main() {
    int n, m, juZhen[105][105];
    cin >> n >> m;

    for (int a = 0; a < n; a++) {
        for (int b = 0; b < m; b++) {
            cin >> juZhen[a][b];
        }
    }

    int q;
    cin >> q;

    for (int a = 0; a < q; a++) {
        int i, j;
        cin >> i >> j;
        cout << juZhen[i - 1][j - 1] << endl;
    }

    return 0;
}
