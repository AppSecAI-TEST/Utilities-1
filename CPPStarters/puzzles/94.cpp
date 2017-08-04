#include <iostream>

using namespace std;

typedef __int128 (*fun)(__int128 k);

__int128 sqr_fun(__int128 k){
   return k*k;
};

int64_t bin_search(fun ofunction,__int128 begin,__int128 end,__int128 val)
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


__int128 sqrt(__int128 what) {
   return bin_search(sqr_fun,1,what/2, what); 
}

__int128 area(int64_t a,int64_t b,int64_t c){
  int64_t p = (a+b+c) / 2;
  __int128 a2 = sqrt(p*(p-a)*(p-b)*(p-c));
  return a2;
};

int main()
{
  // area = Sqrt(p*(p-a)*(p-b)*(p-c))
  // p = (a+b+c) / 2
  int64_t sum = 0;

  for(int64_t i=0;i<=1'000'000'000/3;i++)
  {   
    __int128 area1 = area(i,i,i-1);
 
    if(i%1'000'000==0)
    std::cout << "i=" << i << std::endl;
     
    if(area1!=-1)
    {
      /*if(!i%10)*/ 
      cout << "found:i-=" << i << ":area="<< (int64_t)area1<< endl;
      
      sum+= i*3-1; // area1;
    }

    __int128 area2 = area(i,i,i+1);

    if(area2!=-1)
    {
      /*if(!i%10)*/ cout << "found:i+=" << i << "area:" << (int64_t)area2 << endl;
      sum+= i*3+1; //area2;
    }
  }

  std::cout << "sum:" << sum << endl;

  return 0;
}

