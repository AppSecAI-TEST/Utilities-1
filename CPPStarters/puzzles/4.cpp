#include <iostream>
#include <tuple>
#include <vector>

bool check_palindrome(int64_t figure)
{
  std::vector<int> vec;
  
  for(int f=figure;f>0;f/=10)
  {
    vec.push_back(f%10); 
  }
  
  for(int i=0;i<vec.size()/2;i++)
  {
    if(vec[i]!=vec[vec.size()-i-1])
      return false;
  }
  
  for(auto i:vec) 
    std::cout << i << ":";
  
  std::cout << "palindrome:" << figure << std::endl;
  return true;
}

std::tuple<int64_t,int64_t,int64_t> palindrome3()
{
int64_t curpa = 0;
int64_t f1;
int64_t f2; 
for(auto i1=999;i1>99;i1--)
 for(auto i2=999;i2>99;i2--)
   {
    int64_t ret = i1*i2;
    if(check_palindrome(ret) && ret>curpa)
      {curpa = ret;f1=i1;f2=i2;}
   }
return std::make_tuple(f1,f2,curpa);
}

int main(int argc, char ** argv){
  auto palituple = palindrome3();
  std::cout << "\nsum=" << std::get<2>(palituple) << "; 1= " << std::get<0>(palituple) << "; 2=" << std::get<1>(palituple)  << "\n";
  return 0;
};

