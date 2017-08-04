#include <vector>
#include <iostream>

std::vector<std::vector<int>> myVector;

int main()
{
  myVector = {
   {0,1,0,0},
   {0,1,0,1},
   {1,0,1,0},
   {0,1,1,1}
  };  

  for(auto && line : myVector) 
  {
    for(auto && value : line)
      std::cout << value << " ";
    std::cout << std::endl;
  }

  return 0;

};

