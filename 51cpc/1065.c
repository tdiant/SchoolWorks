#include "stdio.h"

int getNum(int num);

int main() {
    int num;
    scanf("%d",&num);
    printf("%d",getNum(num));
    return 0;
}

int getNum(int num) {
    int stack[1005], topIndex = -1;

    int i = 0;
    while (num > 0) {
        int a = num % 8;
        num /= 8;
        stack[++topIndex] = a;
        i += 1;
    }

    int result = 0;

    while (topIndex >= 0) {
        result *= 10;
        result += stack[topIndex--];
    }

    return result;
}
