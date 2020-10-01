#include <iostream>
using namespace std;

int main(){
    int n,m, juZhen[105][105];
    cin>>n>>m;
    for(int a=0;a<n;a++){
        for(int b=0;b<m;b++){
            cin>>juZhen[a][b];
        }
    }

    for(int a=0;a<n;a++){
        for(int b=0;b<m;b++){
            cout<<juZhen[a][b]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
