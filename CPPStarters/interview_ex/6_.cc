// types play
#include <iostream>
#include <cstddef>

using namespace std;

int main() {
  signed char sc = -1160; // -160; 6.2.3.1 - NOPE, not working so
  char c = sc;
  unsigned char uc = sc; // as stroustrup tells
  cout << (int)uc<< endl;
 
  cout << sizeof(uc) << endl;
  cout << sizeof(sc) << endl;

  char count[356];
  ++count[sc];
  ++count[uc];

  int_least32_t yy;
  int_fast32_t z;

  void *allocate(size_t n);

//  cout << sizeof(allocate) <<endl;
  cout << sizeof(yy) <<endl;
  cout << sizeof(z) << endl;
  
}

