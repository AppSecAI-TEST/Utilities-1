#include <iostream>
#include <string>
// ok if I will use?
using namespace std;

string mul2(string str1);

// returns figures; in: power of 2
int power_2(int power)
{
/*
1) string representation of number and its operations
2) make sum of the string
(+) operation to sum two strings
*/

   string current = "1";
  
   for(int i=0;i<power;i++)
   {
     current = mul2(current);  
   }

   int retnum = 0;
   for(int i=0;i<current.length();i++)
   {
     retnum+=current[i]-'0';
   }  

   return retnum;
}

string mul2(string str1)
{
  string strout;

  int carry = 0;

  for(int i=str1.length()-1;i>=0;i--)
  {
    int temp = str1[i] - '0' + str1[i] - '0' + carry;
    
    carry=temp/10;
    
    if(carry)
      temp-=10;

    strout= (char) (temp+'0') + strout;
  }
  
   if (carry)
     strout=(char)(carry+'0')+strout;

   cout << "str1:" << str1 << "strout:" << strout << endl; 

  return strout;
}

int main(int argc, char **argv) 
{
  std::cout << mul2("9") << endl;

  std::cout << "power2 5:" <<  power_2(5) << endl;
  std::cout << "зщцук2 10:" << power_2(10) << endl;
  std::cout << power_2(1000) << endl;
  return 0;
}


