#include <stdio.h>

int solve(int n){
    if(n==0) return 0;
    if(n==1) return 1;
    if(n==2) return 2;
    return solve(n-1) + solve(n-2);
}

int main() {
    int n;
    scanf("%d", &n);
    printf("%d",solve(n));
    return 0;
}
