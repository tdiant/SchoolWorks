#include <iostream>
using namespace std;

int main() {
    int n, score[1005];
    cin>>n;
    for (int i = 0; i < n; i++)
        cin >> score[i];
    int m;
    cin >> m;
    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        cout << score[num - 1]<<" ";
    }
    return 0;
}
