#include <stdio.h>

int main() {
    int sum = 0, n, a;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&a);
        sum += a;
    }
    printf("%d",sum / n);
    return 0;
}
