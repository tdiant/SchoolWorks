#include "stdio.h"

char getGrade(double k) {
    if (k >= 90 && k <= 100) {
        return 'A';
    } else if (k >= 80 && k < 90) {
        return 'B';
    } else if (k >= 70 && k < 80) {
        return 'C';
    } else if (k >= 60 && k < 70) {
        return 'D';
    } else if (k < 60) {
        return 'E';
    }
}
int main() {
    double k;
    scanf("%d",&k);
    printf("%c",getGrade(k));
    return 0;
}
