#include "stdio.h"
#include "string.h"

int main() {
    int a = 0, e = 0, i = 0, o = 0, u = 0;
    char str[666];
    scanf("%s", str);
    for (int j = 0; j < strlen(str); j++) {
        if (str[j] == 'a')
            a += 1;
        if (str[j] == 'e')
            e += 1;
        if (str[j] == 'i')
            i += 1;
        if (str[j] == 'o')
            o += 1;
        if (str[j] == 'u')
            u += 1;
    }

    printf("a:%d\ne:%d\ni:%d\no:%d\nu:%d", a, e, i, o, u);
    return 0;
}
