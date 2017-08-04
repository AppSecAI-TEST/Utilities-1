#include <iostream>
#include <vector>
#include <complex>
#include <algorithm>
using namespace std;

constexpr double square(double in)
{
  return in*in;  
}

double sum(const vector<double> &)
{
  
}

void v2_2_3()
{
const int dmv = 17;
int var = 17;
constexpr double max1 = 1.4*square(dmv); 
//constexpr double max2 = 1.4*square(var); 
const double max3 = 1.4*square(var);
// dmv is a named constant
// var is not a constant
// OK if square(17) is a constant expression // error: var is not a constant expression
// OK, may be evaluated at run time
double sum(const vector<double>&); 
vector<double> v {1.2, 3.4, 4.5}; 
const double s1 = sum(v);
constexpr double s2 = sum(v);
// sum will not modify its argument (§2.2.5) // v is not a constant
// OK: evaluated at run time
// error: sum(v) not constant expression

}

int main(int argc, char ** argv)
{
double d1 = 2.3; double d2 {2.3};
complex<double> z = 1; complex<double> z2 {d1,d2}; complex<double> z3 = {1,2};
vector<int> v {1,2,3,4,5,6};
// a complex number with double-precision floating-point scalars
// the = is optional with { ... }
// a vector of ints

  std::cout << "test N<2_2> started"<<std::endl;
  for(auto i: v) 
  {
  std::cout << "vector=" << i << std::endl;
  }
 
  std::cout << "z2==" << z2  << std::endl;
  std::cout << "d1==" << d1 << std::endl;
  std::cout << "d2==" << d2 << std::endl;

  v2_2_3();  
}


