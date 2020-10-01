#include<iostream>
using namespace std;

int main() {
    int n, max = 0, num = 0;
    cin>>n;
    for (int i = 0; i < n; i++) {
        int a, b, c, d, e, score;
        cin>>a>>b>>c>>d>>e;
        score = a + b + c + d + e;
        if (score < 85)
            num += 1;
        if (max < score)
            max = score;
    }
    if(num!=n)
        cout<<num<<" "<<max;
    else
        cout<<num<<" No";
    return 0;
}
