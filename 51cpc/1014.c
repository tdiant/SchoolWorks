#include <stdio.h>
#include <string.h>

int main(){
	char str[66];
	scanf("%s",str);
	for(int i=0;i<strlen(str);i++){
		printf("%c",str[i]+2);
	}
	return 0;
}
