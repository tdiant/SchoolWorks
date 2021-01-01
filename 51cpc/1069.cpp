#include <iostream>
#include <string>

using namespace std;

typedef struct {
    string id;
    int score = 0;
} team;

void swap(team *p1, team *p2) {
    team tmp;
    tmp = *p1;
    *p1 = *p2;
    *p2 = tmp;
}

int main() {
    int num;
    cin >> num;
    for (int i = 0; i < num; i++) {
        team teams[10086];

        int t;
        cin >> t;

        for (int j = 0; j < t; j++) {
            cin >> teams[j].id >> teams[j].score;
        }

        for (int k = 0; k < t - 1; k++) {
            for (int l = 0; l < t - 1; l++) {
                if (teams[l].score < teams[l + 1].score) {
                    swap(teams + l, teams + l + 1);
                }
            }
        }

        for (int k = 0; k < t; k++) {
            cout << teams[k].id << " " << teams[k].score << endl;
        }
    }
    return 0;
}
