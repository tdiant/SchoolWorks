#include <stdio.h>

double getMoney(double money){
    switch (((int)money)/1000) {
        case 0:
            return money;
        case 1:
            return money * 0.9;
        case 2:
            return money * 0.85;
        case 3:
            return money * 0.8;
        default:
            return money * 0.75;
    }
}

int main() {
    double money;
    scanf("%lf",&money);
    printf("%.2lf",getMoney(money));
    return 0;
}
