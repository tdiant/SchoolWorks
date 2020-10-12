#include "stdio.h"

int getMax(int a, int b, int c);
int getMiddle(int a, int b, int c);
int getMin(int a, int b, int c);
void printWeek(int week);

int main(){
	int a,b,c,w;
	scanf("%d%d%d%d",&a,&b,&c,&w);
	printf("%d\n%d\n%d\n",getMin(a,b,c),getMiddle(a,b,c),getMax(a,b,c));
	printWeek(w);
	return 0;
}

int getMax(int a, int b, int c){
	if(a>b&&a>c) return a;
	if(b>a&&b>c) return b;
	if(c>a&&c>b) return c;
	return a;
}

int getMin(int a, int b, int c){
	if(a<b&&a<c) return a;
	if(b<a&&b<c) return b;
	if(c<a&&c<b) return c;
	return a;
}

int getMiddle(int a, int b, int c){
	int max = getMax(a,b,c);
	int min = getMin(a,b,c);
	if(a!=max && a!=min) return a;
	if(b!=max && b!=min) return b;
	if(c!=max && c!=min) return c;
	return a;
}

void printWeek(int week){
	switch(week){
		default:
		case 1:
			printf("Monday");
			break;
		case 2:
			printf("Tuesday");
			break;
		case 3: 
			printf("Wednesday");
			break;
		case 4:
			printf("Thursday");
			break;
		case 5:
			printf("Friday");
			break;
		case 6:
			printf("Saturday");
			break;
		case 7:
			printf("Sunday");
			break;
	}
}
