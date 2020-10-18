#include <stdio.h>

#define boolean int
#define true 1
#define false 0

int main() {
    int n, m, q;
    boolean qiPan[105][105];
    scanf("%d%d%d", &n, &m, &q);

    //init
    for (int a = 0; a < 105; a++)
        for (int b = 0; b < 105; b++)
            qiPan[a][b] = false;

    for (int a = 0; a < q; a++) {
        int i;
        int j;
        scanf("%d%d", &i, &j);
        qiPan[i - 1][j - 1] = true;
    }

    for (int a = 0; a < n; a++) {
        for (int b = 0; b < m; b++) {
            printf("%d ", qiPan[a][b]);
        }
        printf("\n");
    }

    return 0;
}
