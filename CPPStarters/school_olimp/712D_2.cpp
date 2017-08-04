#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int64_t modulo=1000000007;

int64_t addm(int64_t a1,int64_t a2){
 // cout << "adding " << a1 << "+" << a2;
  int64_t ret= (a1%modulo + a2%modulo)%modulo;
 // cout << " ret=" << ret << endl; 
  return ret;
}

int64_t mulm(int64_t a1, int64_t a2){
  int64_t ret=((a1%modulo) * (a2%modulo))%modulo;
 // cout << a1 << "*" << a2 << "=" << ret << endl;
  return ret;
}

int main(int argc, char ** argv){
//  std::cout << "input a b k t: " << std::endl;
  int a,b,k,t;

  std::cin >> a;
  std::cin >> b;
  std::cin >> k;
  std::cin >> t;

//  cout << a << ";" << b << ";" << k << ";" << t;
  
  vector<int64_t> sums,sums1, sums2;
  vector<int64_t> *sumsp, *sumsn, *sumstmp; 
  
  int MAXN=2*k*t;
//  cout << "MAX=" << MAXN << endl; 
  sums.reserve(2*k+1);
  sums1.reserve(MAXN*2+1); 
  sums2.reserve(MAXN*2+1);  
  
  for(int i=0;i<MAXN*2+1;i++)
  {
    sums1[i]=0;
    sums2[i]=0;
  }

  for(int si=-2*k;si<=+2*k;si++)
  {
    // a-b=-2k -> a=-k b=k 1 way
    // a-b=0 -> a=b - 2k+1 ways 
    // a-b=2k -> a=k;b=-2k 1 way
    //  
    // 
    //cout << "si=" << si;
    sums[si+2*k] = 2*k-abs(si)+1;
    sums1[si+MAXN] = sums[si+2*k];
    //cout << "; value=" << sums1[si+MAXN] << endl;
  }

 // sums=sums1;
 // cout << "1:" << sums1.size() << endl;
  sumsp=&sums1;
 // cout << "p:" << sumsp->size() << endl;
  sumsn=&sums2;

 // cout << "main cycle:" <<endl;

  for(int ti=2;ti<=t;ti++)
  {
 //   cout << "ti=" <<ti<<endl;
    for(int ki=-2*k*ti;ki<=2*k*ti;ki++)
    {
      (*sumsn)[ki+MAXN]=0;
      for(int si=-2*k;si<+2*k;si++)
        (*sumsn)[ki+MAXN]=addm((*sumsn)[ki+MAXN],
          mulm((*sumsp)[ki+MAXN+si],sums[2*k-si]));
    };

  //  for(int i=0;i<=MAXN*2;i++)
  //    cout <<(*sumsn)[i] << ":";
  //  cout <<endl;

    sumstmp=sumsp;
    sumsp=sumsn;
    sumsn=sumstmp;
  } 

   for(int i=0;i<=MAXN*2;i++)
     cout << (*sumsp)[i] <<  " ";
   cout <<endl;

  int64_t result=0;
   
  for(int i=b-a+1;i<=MAXN;i++)
     result=addm(result,(*sumsp)[i+MAXN]);  

  cout // << "final res"
  << result;
  return 0;
}

