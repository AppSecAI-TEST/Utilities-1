#include <iostream>

int main(int argc, char **argv){
 for(int i=1;i<=100;i++){
   bool figure = true;
   if(!(i%3))
      std::cout << "Fizz" , figure = false;
   if(!(i%5))
      std::cout << "Buzz" , figure = false;
   
   if(figure)
      std::cout << i;
  
   std::cout << std::endl;
 }

}
