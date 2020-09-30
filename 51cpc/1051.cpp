#include <iostream>
using namespace std;

int main() {
    int n, nums[1005], m;
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> nums[i];
    cin >> m;
    for (int a = 0; a < m; a++) {
        int index;
        cin >> index;
        if (nums[index - 1] % 2 == 1) {
            cout << "no" << endl;
        } else {
            cout << "yes" << endl;
        }
    }
    return 0;
}
