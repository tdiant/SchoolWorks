#include <stdio.h>
/*
* 1054 is same as 1055
*/
int main() {
    int n, m, juZhen[105][105];
    scanf("%d%d", &n, &m);
    for (int a = 0; a < n; a++) {
        for (int b = 0; b < m; b++) {
            scanf("%d", juZhen[a] + b);
        }
    }

    int q;
    scanf("%d", &q);

    for (int a = 0; a < q; a++) {
        int i, j;
        scanf("%d%d", &i, &j);
        printf("%d\n", juZhen[i - 1][j - 1]);
    }

    return 0;
}
