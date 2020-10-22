#include <stdio.h>
#include <string.h>

char str1[66666], str2[66666];
int fuckA[66666] = { 0 }, fuckAi = 0;

int main() {
    scanf("%s%s", str1, str2);

    int dotA = strlen(str1), dotB = strlen(str2);

    // fucking in A
    for (int i = dotA - 1; i >= 0; i--) {
        fuckA[fuckAi++] = str1[i] - '0';
    }

    fuckAi = 0;

    // fucking in B
    int m = 0;
    for (int i = dotB - 1; i >= 0; i--) {
        int num = fuckA[fuckAi] + (str2[i] - '0') + m;
        m = num / 10;
        fuckA[fuckAi++] = num % 10;
    }
    if (m != 0)
        fuckA[fuckAi] = m;

    // print out
    int shit = 0;
    int flag = 1;
    for (int i = 66660; i >= 0; i--) {
        if (fuckA[i] != 0 && flag)
            flag = 0;
        if (!flag) {
            printf("%d", fuckA[i]);
            shit = 1;
        }
    }
    if (!shit)
        printf("0");

    return 0;
}