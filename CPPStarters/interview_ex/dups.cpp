#include <iostream>
#include <set>
#include <vector>

using namespace std;

vector<char> duplicates(std::vector<char> & in)
{
  std::set<char> possibledups; // -> just use array because char put -> [256]
  std::set<char> outputed;     //
  std::vector<char> returned;  //
  
  for(auto current=in.begin();current<in.end();current++)
  {
    if(possibledups.find(*current)!=possibledups.end()
       && outputed.find(*current)==outputed.end())
    {
      std::cout << *current << " ";
      returned.push_back(*current);
      outputed.insert(*current);
    }
    possibledups.insert(*current);  
  }
  
  return returned;
}

int main(){
 
 vector<char> to_process={1,2,3,4,5,3,2,2,4,6,7};
 
 vector<char> returned = duplicates(to_process);

 for(auto i:returned)
 {
   std::cout << i+0 << " ";
 }
 
 return 0;
}
