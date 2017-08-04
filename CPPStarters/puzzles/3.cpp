#include <iostream>
//#include <rope.h>
#include <math.h>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

int main()
{
  int64_t val=600851475143;
  bool found = false;
  std::set<int64_t> values;

  values.insert(val);

  while(!found)
  {
   bool found_v=false;
   for(auto v:values)
   {
   for(int64_t divisor=sqrt(v);divisor>=2;divisor--)
    {
      if(v%divisor==0)
      {
       auto val1=divisor;
       auto val2=v/divisor;
       if(val2==1 || val1==1)   
         break;       
       found_v=true;
       values.erase(v);
       values.insert(val1);
       values.insert(val2);
       cout << "erase:" << v <<";v1=" << val1 
            << ";v2=" << val2 << endl; 
       break; 
      }
    }
  
    if(found_v) 
     break;
    // restart loop
   }
   // no breaks, no new divisors
   found=!found_v;  
  }

  for(auto v:values) cout << ";v:" <<  v;
 
  return 0;
}

