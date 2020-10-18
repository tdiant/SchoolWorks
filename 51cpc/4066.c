#include <stdio.h>
#include <string.h>

int main(){
	char str1[233],str2[233];
	scanf("%s %s",str1,str2);
	int length1 = strlen(str1), length2 = strlen(str2);
	for(int i=0;i<length1;i++){
	    int flag = 1;
	    for(int j=0;j<length2;j++){
	        if(str1[i+j] != str2[j]){
	            flag = 0;
                break;
	        }
	    }
	    if(flag){
	        printf("%d",i+1);
            break;
	    }
	}
	return 0;
}
