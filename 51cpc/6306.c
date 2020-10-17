#include "stdio.h"
#include "string.h"

void print(char str[],int n);

void print(const char string[16]);

int main() {
    int n;
    scanf("%d",&n);
    print("ooo@ooo@ooo@ooo",n);
    print("..o@o.o@.o.@o.o",n);
    print("ooo@o.o@.o.@ooo",n);
    print("o..@o.o@.o.@o.o",n);
    print("ooo@ooo@ooo@ooo",n);
    return 0;
}

void print(char str[],int n) {
    for (int i = 0; i < strlen(str); i++) {
        if (str[i] == '@') {
            for (int j = 0; j < n; j++)
                printf(".");
            i++;
        }
        printf("%c", str[i]);
    }
    printf("\n");
}
