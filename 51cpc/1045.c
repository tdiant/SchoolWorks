#include <stdio.h>

int main() {
    int i, j;
    char c;
    scanf("%c",&c);
    for (j = 0; j <= (c - 'A'); j++) {
        for (i = 0; i < j; i++)
            printf(" ");
        for (i = j; i <= (c - 'A'); i++)
            printf("%c",(char) (c - i));
        for (i = 'A'; i < c - j; i++)
            printf("%c",(char) i);
        printf("\n");
    }
    return 0;
}
