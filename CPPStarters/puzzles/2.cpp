#include <iostream>
//#include <rope.h>
#include <array>
#include <algorithm>

using namespace std;

int main()
{
  int64_t prev1=1;
  int64_t prev2=2;
  int sum=0;  

  while(prev2<=4000000)
  {
    if(!(prev2%2))
      {
        sum+=prev2;
      }
    prev2=prev1+prev2;
    prev1=prev2-prev1;
  }	
  
  std::cout << sum;
  
  return 0;
}

