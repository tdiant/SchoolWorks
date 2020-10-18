#include <stdio.h>
#include <string.h>

int main(){
	char str[233];
	long result = 0;
	scanf("%s",str);
	for(int i=0;i<strlen(str);i++) {
        int num = str[i] - '0';
        result *= 10;
        result += num % 2;
    }
	printf("%ld",result);
	return 0;
}
