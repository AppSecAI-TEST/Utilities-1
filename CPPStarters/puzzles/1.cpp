#include <iostream>
float a=0.0;
int64_t sum_up_to(int64_t upto,int64_t divisor)
{
std::cout << "\nup to:" << upto <<"; div:" << divisor;
// (k)*(k+1)/2 * mul
int64_t k=(upto-1)/divisor;
int64_t ret=divisor*k*(k+1)/2;
std::cout << "\nret=" <<ret;
return ret;
}

int main(int argc, char ** argv){
  int64_t sum = sum_up_to(1000,5) + sum_up_to(1000,3) - sum_up_to(1000,15); 
  std::cout << "\nsum=" << sum << "\n";
  return 0;
};

