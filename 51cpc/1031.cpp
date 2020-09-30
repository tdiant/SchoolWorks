#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

double getCos(int a,int b,int c){
    return (a*a+b*b-c*c)*1.0/(2*a*b);
}

int main() {
    int a, b, c;
    cin>>a>>b>>c;

    double cosA = getCos(b, c, a);
    double cosB = getCos(c, a, b);
    double cosC = getCos(a, b, c);

    double p = 0.5 * (a + b + c);
    double s = sqrt(p * (p - a) * (p - b) * (p - c) * 1.0);

    int flag = 0;

    if (a + b > c && a + c > b && b + c > a) {
        if (cosA == 0 || cosB == 0 || cosC == 0) {
            cout<<"直角三角形";
            flag = 1;
        } else if (cosA < 0 || cosB < 0 || cosC < 0) {
            cout<<"钝角三角形";
            flag = 1;
        } else if (cosA > 0 && cosB > 0 && cosC > 0) {
            cout<<"锐角三角形";
            flag = 1;
        } else {
            cout<<"ERROR";
        }
    } else {
        cout<<"ERROR";
    }

    if (flag)
        printf("\n%.2lf", s);
    return 0;
}
