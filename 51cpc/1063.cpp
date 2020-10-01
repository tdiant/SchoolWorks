#include<iostream>
#include<cstring>
using namespace std;

int main() {
    char str[1005];
    cin >> str;
    int size = strlen(str);
    for (int i = size - 1; i >= 0; i--) {
        cout << str[i];
    }
    return 0;
}
