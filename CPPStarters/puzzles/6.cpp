#include <iostream>

int64_t diff(int64_t upto)
{
int64_t sum_sq=0;
int64_t sum=0;
for(int i=1;i<=upto;i++)
  { sum_sq += i*i; sum+=i;}

auto ret=sum*sum-sum_sq;

return ret;
}

int main(int argc, char ** argv){
  auto sum = diff(100);
  std::cout << "\nsum=" << sum << "\n";
  return 0;
};

