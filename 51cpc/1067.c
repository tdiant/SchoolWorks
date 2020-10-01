#include<cstdio>

typedef struct {
    char name[233];
    int id;
    int score;
} person;

void swap(person *p1, person *p2){
    person tmp;
    tmp = *p1;
    *p1 = *p2;
    *p2 = tmp;
}

int main(){
    person data[233];
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++) {
        int a, b, c, d, e;
        scanf("%s%d%d%d%d%d%d", data[i].name, &data[i].id, &a, &b, &c, &d, &e);
        data[i].score = a + b + c + d + e;
    }

    //sort
    for(int m=0;m<n-1;m++) {
        for (int i = 0; i < n - 1; i++) {
            if (data[i + 1].score > data[i].score) {
                swap(data + i + 1, data + i);
            }
        }
    }

    //Print
    for(int i=0;i<n;i++) {
        person p = data[i];
        printf("%s %d total=%d\n", p.name, p.id, p.score);
    }

    return 0;
}