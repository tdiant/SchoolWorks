#include <stdio.h>
#include <string.h>
int main() {
    char str1[233];
    char str2[233];
    int flag = 1;
    scanf("%s %s", str1, str2);
    if (strlen(str1) != strlen(str2)) {
        printf("no");
        return 0;
    }
    for (int i = 0; i < strlen(str1); i++) {
        if (str1[i] != str2[i]) {
            flag = 0;
            break;
        }
    }
    printf("%s", flag ? "yes" : "no");
    return 0;
}