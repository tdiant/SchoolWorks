#include <stdio.h>

int main() {
    double k;
    scanf("%d",&k);
    if (k > 0) {
        printf("positive");
    } else if (k == 0) {
        printf("zero");
    } else if (k < 0) {
        printf("negative");
    }
    return 0;
}
