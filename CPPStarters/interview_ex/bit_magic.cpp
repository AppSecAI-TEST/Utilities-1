#include <iostream>
#include <sstream>

void signOfInteger() {
  int32_t v;
  int sign;
  
  std::cout << "input int:\n";
  std::cin >> v;

  // CHAR_BIT is the number of bits per byte (normally 8).
  sign = -(v < 0);  // if v < 0 then -1, else 0. 
  // or, to avoid branching on CPUs with flag registers (IA32):
  sign = -(int)((unsigned int)((int)v) >> (sizeof(int) * CHAR_BIT - 1));
  // or, for one less instruction (but not portable):
  sign = v >> (sizeof(int) * CHAR_BIT - 1); 

  std::cout << "sign is:" << sign;  

}

int main(int argc, char ** argv){
  std::cout << "Input number of excersize" << std::endl;
  std::cout << "1) \n"
               "2) \n"
  	       "3) \n"
   	       "4) \n"
 	       "5) \n";

  int i;
  std::string mystr;
 
  do {
  getline(std::cin,mystr);
  std::stringstream(mystr) >> i;
  } while ( (i<1 || i>10) && (std::cout << "wrong!"<<mystr, 1) )
	;

  std::cout << "your choice: " << i << "\n"; 
  
  switch(i){
    case 1:
      signOfInteger();
      break;
    case 2:
   
    case 3:
    
    case 4:
    
    default:
      break;
   }
 
}

