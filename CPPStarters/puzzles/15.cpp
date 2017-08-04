#include <iostream>

using namespace std;
/*
class A {

    public:

  //  ostream& operator<<(ostream&, const A&);          //a

    ostream& operator<<(ostream&) { 
    };                    //b

    friend ostream& operator<<(ostream& ostr, const A&) { 
       ostr << "aaa!";
       return ostr;
    };   //c

};
*/


double Cubes(const double & numb)
{
  double num = numb * numb * numb;
  return numb;
};

class A {

public:

    virtual ~A() { f(); }

    virtual void f() { cout << "A::f" << endl; }

};

class B: public A {

public:

    ~B() { }

    virtual void f() { cout << "B::f" << endl; }

};


int main(int argc, char ** argv)
{
 int х, у;

int xa=(у=(х=5)*2+7)/4; 

 std::cout << xa;
int i = 2;

int j = 2;

int s=(i++)+(++j);
 
 std::cout << i << ":" << j << s <<endl;

xa = 5;

int b = 0;    

int &r = xa;
    

r = b++;
    

cout << xa << r << b << endl;
{

   unsigned int a = 20;
   unsigned int b = 14;
   int c = a ^ b;

   cout << c << endl;

}

  A* a = new B;

  delete a;

  return 0;  
}

