#include <iostream>

auto GetSomeIDs()
{
  int ids[8];
  ids[1]=5;
  return ids;
}

int main()
{
 int *someIDs = GetSomeIDs();

  
 
 std::cout << someIDs[1];

 return 0;

}

