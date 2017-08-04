#include <iostream>
#include <stdio>
// purpose
// implement class compiled both in c++03 and c++11
// to test move and copy elemtns

template <typename T>
class Element {
T value;

public:

// just copy on create
Element(T elementVal) : value(elementVal) {
}

// copy constructor
Element(const Element& from){
  value = from;
}

// move
Element(

// implement equals with logging 
// 
Element<T>& operator=(Element<T> && element) {
  std::cout << "reached operator = &&: " << std::endl;
  T tmp = std::move(element);
  return tmp;
 }

~Element(){
  std::cout << "Element T:" << T << value  <<" removed\n"; 
 }

};

