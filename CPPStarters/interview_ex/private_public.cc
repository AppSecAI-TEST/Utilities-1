#include <string>
#include <vector>
#include <iostream>
#define private public

class myClass 
{
 private:
   int a;
   std::string string_my;
};

int main(int argc, char** argv)
{
  myClass clas;

  clas.a = 0;
  clas.string_my = "trek";

  std::vector<int> bb{1,3,4,2,7,5,9,15,6,6,8};
 
  std::sort(begin(bb),end(bb), [&clas](int a1,int a2) {
		  clas.a++;
                  std::cout << "a1=" << a1 << " : a2=" << a2 << std::endl;
		  
   		  if(a1==a2)
		  {
		    std::cout << "FOUND PAIR!=" << 
		    a1 <<"=" << a2 << std::endl;
                  }  		    
  
		  return a1<a2;
		});

   std::cout<<"a==" <<clas.a << std::endl;
   std::cout<<"bb.size="<<bb.size() << std::endl;
   
   std::cout<<"bb:";
   
   for(auto &&a : bb)
 	std::cout << ":" << a << std::endl;   

   std::sort(begin(bb),end(bb), [&clas](int a1,int a2) {
                  clas.a++;
                  std::cout << "a1=" << a1 << " : a2=" << a2 << std::endl;

                  if(a1==a2)
                  {
                    std::cout << "FOUND PAIR!=" <<
                    a1 <<"=" << a2 << std::endl;
                  }

                  return a1<a2;
                });

   return 0;
}

