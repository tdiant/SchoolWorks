#include <iostream>
using namespace std;

#define boolean int
#define true 1
#define false 0

int main() {
    int n, m, q;
    boolean qiPan[105][105];
    cin >> n >> m >> q;

    //init
    for (int a = 0; a < 105; a++)
        for (int b = 0; b < 105; b++)
            qiPan[a][b] = false;

    for (int a = 0; a < q; a++) {
        int i;
        int j;
        cin >> i >> j;
        qiPan[i - 1][j - 1] = true;
    }

    for (int a = 0; a < n; a++) {
        for (int b = 0; b < m; b++) {
            cout << qiPan[a][b] << " ";
        }
        cout << endl;
    }

    return 0;
}
