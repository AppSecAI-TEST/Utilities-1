#include <iostream>
#include <cmath>
#include <utility>
// too least preicsion
using namespace std;

std::pair<double,double> sqr_eq_solve(int64_t a, int64_t b, int64_t c)
{
  int64_t D=b*b-4*a*c;
  
  double x1=(-b+sqrt(D))/2;
  double x2=(-b-sqrt(D))/2;

  auto ret=make_pair(x1,x2);
 
  return ret;
}

typedef __int128 (*fun)(int64_t);

__int128 k_fun(int64_t k){
   __int128 k128 = (__int128)k;
   __int128 left = 2*k128*(k128-1); 
   return left;
};

int64_t bin_search(fun ofunction,int64_t begin,int64_t end,__int128 val)
{
//  int i=0;
  for(;;){
  //  i++;
  
  if(ofunction(begin)==val)
    return begin;
  
  if(ofunction(end)==val)
    return end;
  
  int64_t mid = (begin+end)/2;
   
  //if(i%100)
  //   std::cout << "begin:" << begin <<";end:" <<end <<";mid=" << mid << endl; 
  
  if(ofunction(mid)>val)
    end=mid; 
  else if(ofunction(mid)<val)
  { 
    if(begin==mid) 
      return -1;
    begin=mid;
  }
  else if(ofunction(mid)==val)
    return mid;
  }
}

int main(int argc, char ** argv){
 
  /* x>1'000'000'000'000 : k/X * (k-1)/(X-1) = 1/2
     (k^2-k)/(X^2-X) = 1/2 ;
     2k^2-2k = X^2 - X;
     D=b^2-4ac = 4-4*2*(-X^2+X) ; 
     k12 = (2+-sqrt(D))/2*a
     k12 = 1/2 +- sqrt(1-x+2X^2)
     1-.. is not our answer
     k> (2+ 2*sqrt(2)*X)/4 > 1/2+0.7*X
     for our case X is big k> 0.7X 
      */
  
 for(int64_t x=1'000'030'000'000;x<INT64_MAX;x++)
   {
      __int128 x128 = (__int128)x;
      __int128 right = x128*(x128-1);
 
      auto found = bin_search(k_fun, x/10*7,x/10*8,right);
	
      if(found>0)
	{
	  std::cout << "Found!! found=" << found  
 		    << "; x=" << x 
                    << "; value= << right" << endl;		
	  exit(0);

        } else 
  	   { 
            std::cout << "not found ; x=" << x << endl;
           }
      }  

  return 0;

};

