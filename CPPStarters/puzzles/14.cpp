#include <iostream>
#include <cmath>
using namespace std;
int main(int argc, char ** argv){
 int fres=2;
 int flen=2;
 for(int64_t a=1;a<1'000'000;a++)
     {
       auto res=a;
       auto len=1;
       while(res!=1)
       {
	 if(res%2==0)
           res=res/2;
         else
           res=3*res+1;	   
         len++;
       }
       if(len>flen){flen=len;fres=a;}
     } 
 std::cout << "fres="<< fres<<" flen=" << flen << std::endl;
 return 0;
};

