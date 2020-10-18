#include <stdio.h>
#include <string.h>

int main() {
    char str1[233], str2[233];
    scanf("%s%s", str1, str2);
    for (int i = 0; i < strlen(str1); i++) {
        if (str1[i] != str2[i]) {
            printf(str1[i] > str2[i] ? "<" : ">");
            return 0;
        }
    }
    printf(
            strlen(str1) == strlen(str2) ? "=" :
            strlen(str1) > strlen(str2) ? ">" : "<"
    );
    return 0;
}
