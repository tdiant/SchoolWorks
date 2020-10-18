#include <stdio.h>
#include <string.h>

int main() {
    char str[1005];
    while (gets(str)) {
        int result[130];
        for (int i = 0; i < 130; i++)
            result[i] = 0;

        int size = strlen(str);
        for (int i = 0; i < size; i++) {
            result[str[i]] += 1;
        }

        char c;
        int max = -1;
        for (int i = 40; i < 129; i++) {
            if (max < result[i]) {
                c = (char) i;
                max = result[i];
            }
        }

        printf("%c %d\n", c, max);
    }
    return 0;
}
