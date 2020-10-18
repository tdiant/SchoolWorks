#include <stdio.h>
#include <string.h>

int main() {
    char str[666];
    scanf("%s", str);
    int flag = 0;
    for (int i = 0; i < strlen(str); i++) {
        char c = str[i];
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            printf("%d", i + 1);
            flag = 1;
            break;
        }
    }
    if (!flag) {
        printf("0");
    }
    return 0;
}
