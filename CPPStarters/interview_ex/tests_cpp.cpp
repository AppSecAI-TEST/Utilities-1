#include <iostream>

constexpr int as(int a, int b, int c, int d) {
  if(a>b)
    return c;
  else
    return d;
}

int main(int argc, char** argv){
  std::cout << "input number: ";

  std::string scout;
  auto scoutp = &scout;

  std::cout << *scoutp;
//  scoutp = nullptr;
  std::cout << *scoutp;

  int i;

  int a[4]={1,2,3,4};

  int p = as(a[0],a[1],a[2],a[3]);

  std::cout << "as=" << p << std::endl;

  std::cin >> i;

  std::cout << "\n:input:" << i << std::endl;

  std::cout << "intsz=" << sizeof(int) << std::endl;

  static_assert(116>sizeof(int), "integers are too big");
  static_assert(6<=sizeof(int), "integers are too small");
// check integer size

  return 0;
}
