#include <iostream>
using namespace std;
//                       10^12         15             21
int64_t sum_up_to(int64_t upto,int64_t from1, int64_t from2)
{
  cout << "\nup to:" << upto <<";from1:" 
       << from1 << ";from2:" << from2 << endl;
  
  while(from2<upto)
  {
    int64_t from1_t = 3*from1 + 2*from2 - 2;
    int64_t from2_t = 4*from1 + 3*from2 - 3; 
    from1 = from1_t;
    from2 = from2_t;
  }
  std::cout << "fuck1=" << from1 << endl; 
  std::cout << "fuck2=" << from2 << endl;
  return 0;
}

int main(int argc, char ** argv){
  sum_up_to(1'000'000'000'000,15,21);
    

  return 0;
};

