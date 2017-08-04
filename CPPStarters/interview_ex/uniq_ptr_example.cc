#include <iostream>
#include <memory>
 
struct Foo
{
    static int begin;
    int val=++begin;
    Foo(int &val_other) {val = val_other;};
    Foo(int val_o) {val = val_o;}
    Foo() { std::cout << "Foo::Foo\n";  }
    Foo(Foo &other) { std::cout << "copy other" << other.val << "\n"; }
    Foo(Foo &&other) {std::cout << "move other" << other.val << "\n"; }
    Foo & operator= (Foo &other){ std::cout << " = & other\n"; return other; }
    Foo & operator= (Foo &&other) {std::cout << " = && other\n"; return other; }
    ~Foo()     { std::cout << "Foo::~Foo\n"; }
    void bar() { std::cout << "Foo::bar\n";  }
};

int Foo::begin=0;
 
void f(const Foo &)
{
    std::cout << "f(const Foo&)\n";
}
 
int main()
{
    std::unique_ptr<Foo> p1(new Foo);  // p1 owns Foo
    if (p1) p1->bar();
 
    {
        std::unique_ptr<Foo> p2(std::move(p1));  // now p2 owns Foo
        f(*p2);
 
        p1 = std::move(p2);  // ownership returns to p1

  	p2->bar();
 
        std::unique_ptr<Foo> p3 = std::move(p2);

        p2->bar();        

        Foo *p4=p1.get();
        
        std::cout << "destroying p2...\n";
    }
 
    if (p1) p1->bar();
 
    // Foo instance is destroyed when p1 goes out of scope
}

