#include <iostream>
#define PI 3.1415926

using namespace std;

int main()
{
    int type;
    double a,b,r;
    cin>>type;
    switch(type)
    {
    case 1:
        cin>>a>>b;
        cout<<(int)(a*b)<<endl;
        break;
    case 2:
        cin>>a>>b;
        cout<<(int)(a*b*0.5)<<endl;
        break;
    case 3:
        cin>>r;
        cout<<(int)(PI*r*r)<<endl;
        break;
    }
    return 0;
}
