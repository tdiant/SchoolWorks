#include "stdio.h"

int isLeapYear(int year);

int main(){
    int year;
    scanf("%d",&year);
    printf(isLeapYear(year) ? "yes" : "no");
    return 0;
}

int isLeapYear(int year) {
    if (year % 4 == 0 && year % 100 != 0) {
        return 1;
    } else if (year % 400 == 0) {
        return 1;
    } else
        return 0;
}
