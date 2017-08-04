#include <iostream>
#include <ctime> 
// start 1:00
// in A B C D
// A <= X*Y <= B
// C <= 2*(X+Y) <= D 
// X <= Y
// number of colutions?
// limit: 1 sec; 256 meg memory; 

// dynamic programming -> greedy algorythm
// to find solution
 
// naive: calulate number of solutions 
// we can select X than Y>=X
// 2 alternatives:
// A..B - divisors  
// 
// MAX: 
// 1<=A<=B<=10^9
// 4<=C<=D<=10^9
//

bool getstrtime(char * bufferto){
  time_t rawtime;
  struct tm * timeinfo;

  time (&rawtime);
  timeinfo = localtime (&rawtime);

  strftime (bufferto,80,"Now it's %c.",timeinfo);
  puts (bufferto);
  return true;
};

int main(int argc, char **argv)
{
  char buffer [80];
  getstrtime(buffer);
  std::cout << buffer << std::endl;
  int32_t A=1;
  int32_t B=1000000000;
  int32_t C=4;
  int32_t D=1000000000;  

  int sols = 0;
  
  for(int X=1;X<=B/2;X++){
    for(int Y=X;Y<=(B/2)/X;X++){
      if(Y*X>D)
        break;
      else
        sols++;
    }
  }

  std::cout << "sols=" << sols << std::endl;

  getstrtime(buffer);
  
  std::cout << buffer << std::endl;

  return -1;
};


