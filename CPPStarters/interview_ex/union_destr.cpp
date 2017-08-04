#include <iostream>
#include <vector>
/*
  union U1 {
  int i;
  std::string s;

  U1(int v) : i(v) {}
  U1(std::string const& v) : s(v) {}
} u1("hello"); // error: not destructible, ~U1 is implicitly deleted
*/

union U2 {
  int i;
  std::string s;

  U2(int v) : i(v) {}
  U2(std::string const& v) : s(v) {}
  ~U2() { /* what now? */ }
} u2("world"); // ok: ~U2 happily leaks std::string

int main(int argc, char **argv) 
{
// U1 uu1 = {"Hi!"};
 U2 uu2 = {"Hi!"};
// U3 uu3 = {"HiHiHi!"};
// U4 uu4 = {"HahAhi!"};

  for(auto a: std::vector<std::string>({"ione","itwo", "ithree"}))
  {
    std::cout << "test:" << a;  
  }

// U5 uu5 = {""};  

}

