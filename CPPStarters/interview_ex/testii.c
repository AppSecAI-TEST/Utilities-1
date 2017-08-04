#include <stdio.h>

*GetSomeIDs()
{
  int ids[8];
  ids[1]=5;
  return ids;
}

int call(){
  int a[8]={1,2,3,4,5,6,7,8};
  return a[5];
}

int main()
{
 int *someIDs = GetSomeIDs();
 printf("%d\n",someIDs[1]);
 
 int b[6]={101,102,103,104,105};
 printf("%d\n",someIDs[1]);

 call();
 printf("%d\n",someIDs[1]);

 sleep(1);
 printf("%d\n",someIDs[1]);

 return 0;

}

