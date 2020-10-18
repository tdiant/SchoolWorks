#include <stdio.h>
#include <string.h>

int main() {
    char str[1005];
    scanf("%[^\n]",str);

    int spaceNum = 0, size = strlen(str);
    bool isAlphaLast = false;

    for (int i = 0; i < size; i++) {
        char c = str[i];

        if (isAlphaLast && c == ' ') {
            spaceNum += 1;
        }

        if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90) || c == ',') {
            isAlphaLast = true;
        } else {
            isAlphaLast = false;
        }
    }

    printf("%d",spaceNum + 1);

    return 0;
}
