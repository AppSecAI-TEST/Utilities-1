#include <string>
#include <iostream>

using namespace std;

class Animal
{
private:
   std::string m_strName;

protected:
   Animal(const std::string& strName):  m_strName(strName)
   {
   }
public:
   const std::string& GetName() { return m_strName; }
   const char* Speak() { return "opopop:"; }
};

class Cat: public Animal
{
public:
   Cat(const std::string& strName): Animal(strName)
   {
   }
   const char* Speak() { return "Meowx"; }
};

class Dog: public Animal
{
public:
   Dog(const std::string& strName) : Animal(strName)
   {
   }
   const char* Speak() { return "Woof"; }
};

int main()
{
   Cat cCat("Fred");
   Animal *pAnimal = &cCat;
   cout << "Animal is named " << pAnimal->GetName() << ", and it says " << pAnimal->Speak() << endl;
   return 0;
}

