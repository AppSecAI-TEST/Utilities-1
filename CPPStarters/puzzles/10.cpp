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
  int64_t count=0;
  int64_t current = 2;

  while(current<2'000'000) {
   if(check_prime(current))
     {
       count+=current;
     }
    current++;
  }  

  std::cout<< "sum = " << count;

  return 0;
};

