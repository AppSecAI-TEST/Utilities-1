#include <iostream>
#include <memory> 

int main()
{
  int a[256];

  memset(a,0,256* sizeof(int));

  for(int i=0;i<256;i++)
    std::cout << a[i];
  
  return -1;
}

