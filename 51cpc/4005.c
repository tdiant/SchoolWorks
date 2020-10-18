#include <stdio.h>

int isLeapYear(int year);

int main() {
    int dateNum[12] = {31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int date;
    scanf("%d", &date);

    int year = date / 10000;
    int month = date / 100 - year * 100;
    int day = date - year * 10000 - month * 100;

    int dayNum = 0;

    for(int i=1;i<month;i++){
        int monthNum = dateNum[i-1];
        if(monthNum<0)
            monthNum = isLeapYear(year)?29:28;
        dayNum += monthNum;
    }

    dayNum += day;

    printf("%d",dayNum);

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
