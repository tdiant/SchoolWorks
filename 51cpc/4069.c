#include <stdio.h>

void sortq(int a[],int n){
    //insert sort
    for(int i=1;i<n;i++) {
        int tmp = a[i];
        int j;
        for (j = i; j > 0 && a[j - 1] > tmp; j--) {
            a[j] = a[j - 1];
        }
        a[j] = tmp;
    }
}

int main(){
	int a, nums[233];;
	scanf("%d",&a);
	for(int i = 0;i<a;i++) {
        scanf("%d", nums + i);
    }
	sortq(nums,a);
	for(int i=0;i<a;i++){
	    printf("%d ",nums[i]);
	}
	return 0;
}
