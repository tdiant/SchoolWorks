#include <stdio.h>

int main(){
    int n,m, juZhen[105][105];
    scanf("%d%d",&n,&m);
    for(int a=0;a<n;a++){
        for(int b=0;b<m;b++){
            scanf("%d",juZhen[a] + b);
        }
    }

    for(int a=0;a<n;a++){
        for(int b=0;b<m;b++){
            printf("%d ",juZhen[a][b]);
        }
        printf("\n");
    }
    return 0;
}
