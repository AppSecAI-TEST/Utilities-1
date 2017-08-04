#include <iostream>
#include <cmath>
using namespace std;
int main(int argc, char ** argv){
 for(int64_t a=1;a<1000;a++)
   for(int64_t b=1;b<1000;b++)
     {
       auto res=a*a +b*b; 
       int64_t sq = sqrt(res);
       if(sq+a+b==1000 && sq*sq==res)
         std::cout << "found " <<a*b*sq <<" : a:" << a << " b:" << b << " c:" << sq << endl;
     } 
 return 0;
};

