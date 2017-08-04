#include <iostream>
#include <tuple>
#include <vector>
#include <cmath>

bool check_prime(int64_t figure)
{
  std::vector<int> vec;
 
  bool found = false;
  int64_t f; 
  for(f=sqrt(figure);f>1;f--)
  {
    if(figure%f==0) 
      { found=true; break;}
  }
 
  if(found)
    return false;

  std::cout << "nprime:" << figure << std::endl;
  return true;
}

int main(int argc, char ** argv){
  int count=0;
  int64_t current = 2;

  while(true) {
   if(check_prime(current))
     {
       count++;
       if(count==10001)
         {std::cout << "found :" << current;exit(0);}
     }
    current++;
  }  

  return 0;
};

