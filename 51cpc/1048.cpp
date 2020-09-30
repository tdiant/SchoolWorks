#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int n, score[1005], m;
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> score[i];
    cin >> m;
    for (int a = 0; a < m; a++) {
        int i;
        int j;
        cin>>i>>j;
        int scoreSigma = 0;
        for(int b = i - 1;b<j;b++) {
            scoreSigma += score[b];
        }
        printf("%.2lf\n",scoreSigma*1.0/(j-i+1));
    }
    return 0;
}
