#include <iostream>
//#include <rope.h>
#include <array>
#include <algorithm>

using namespace std;

int main()
{

// some c++ play
//  crope r(100000,'x'); 
//  crope r2 = r + "abc" +r;  
   
  array<int,5> a5={1,7,3,5,2};
  array<int,3> a3={7,1,3};

  for(auto a:a5){std::cout << "\narray 5:" << a;};
  for(auto a:a3){std::cout << "\narray 3:" << a;};
  cout << "\n---%<---\n";
 
  auto res1 = find(begin(a5),end(a5), 7);
  auto res2 = find(begin(a3),end(a3),3);
  cout << "\n res=" << *res1;
  cout << "\n res=" << *res2;

  cout << "\n---%<---\n";
 
  sort(begin(a5),end(a5),[=](int a1,int a2) 
    -> int {return a1%2>a2%2;});
  sort(begin(a3),end(a3),[=](int a1,int a2) 
    -> int {return a1%2>a2%2;});

  for(auto a:a5){std::cout << "\narray 5:" << a;};
  for(auto a:a3){std::cout << "\narray 3:" << a;};
  cout << "\n---%<---\n";
 
  sort(begin(a5),end(a5),[=](int a1,int a2) 
    -> int {return a1%3>a2%3;});
  sort(begin(a5),end(a5),[=](int a1,int a2) 
    -> int {return a1%3>a2%3;});
  
  for(auto a:a5){std::cout << "\narray 5:" << a;};
  for(auto a:a3){std::cout << "\narray 3:" << a;};
  cout << "\n---%<---\n";
 
  return 0;
}

