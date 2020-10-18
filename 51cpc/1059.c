#include <stdio.h>
#include <string.h>

int main() {
    char str[1005], find[1005];
    scanf("%s%s",str,find);

    int size1 = strlen(str);
    int size2 = strlen(find);

    if (size2 == 0) {
        printf("0");
        return 0;
    }

    for (int i = 0; i < size1 - size2 + 1; i++) {
        bool flag = false;
        if (str[i] == find[0]) {
            for (int j = i; j < i + size2; j++) {
                if(str[j] != find[j-i]){
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }

        if(flag){
            printf("%d",i+1);
            break;
        }
    }

    return 0;
}
