#include <cstdio>

int main() {
    int a, b;
    char c;

    scanf("%d%c%d", &a, &c, &b);

    if (c == '+') {
        printf("%d", a + b);
    } else if (c == '-') {
        printf("%d", a - b);
    } else if (c == '*') {
        printf("%d", a * b);
    } else if (c == '/' && b!=0) {
        double result = a * 1.0 / b;
        if(result == (int)result){
            printf("%d", (int)result);
        } else {
            printf("%.1lf", result);
        }
    } else {
    	printf("-1");
	}
    return 0;
}
