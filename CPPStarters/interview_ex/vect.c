// gcc -std=c99 -mpreferred-stack-boundary=4 vect.c 
#include <stdio.h>
#include <time.h>

typedef int v4si __attribute__ (( vector_size(4*sizeof(int)) ));

typedef union {
v4si v;
int a[4];
} vect4;

int main()
{
int val;
int vval[4];
time_t my_t;
vect4 my_vect1;
my_vect1.a[0]=1;//,2,3,4};
my_vect1.a[1]=1;
my_vect1.a[2]=1;
my_vect1.a[3]=1;
vect4 my_vect2;
my_vect2.a[0]=11;
my_vect2.a[1]=12;
my_vect2.a[2]=13;
my_vect2.a[3]=14;
vect4 my_vect3;

my_t = time(NULL);
printf("%s\n %d", ctime(&my_t), sizeof(my_vect1));

//my_vect1={1,2,3,4};
//my_vect2={10,12,14,16};

my_vect3.v=my_vect1.v+my_vect2.v;
val = sizeof(my_vect3); 
printf("sum=%d", my_vect3.a[2]);
return 0;
}


