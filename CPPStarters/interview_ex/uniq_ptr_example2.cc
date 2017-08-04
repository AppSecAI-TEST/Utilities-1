 #include <iostream>
#include <memory>

struct Foo
{
    static int begin;
    int val=++begin;
    Foo(int &val_other) {val = val_other;};
    Foo(int val_o) {val = val_o;}
    Foo() { std::cout << "Foo::Foo val:"<<val<<"\n";  }
    Foo(const Foo &other) { std::cout << "copy other" << other.val << "\n"; }
    Foo(Foo &&other) {std::cout << "move other" << other.val << "\n"; }
    Foo & operator= (const Foo &other){ std::cout << " = & other\n"; return *this; }
    Foo & operator= (Foo &&other) {std::cout << " = && other\n"; return *this; }
    ~Foo()     { std::cout << "Foo::~Foo\n"; }
    void bar(std::string param) { std::cout << "Foo::bar "<< param << val << "\n" ;  }
};

int Foo::begin=0;

void f(const Foo &)
{
    std::cout << "f(const Foo&)\n";
}

int main()
{
    std::unique_ptr<Foo> p1(new Foo);  // p1 owns Foo
    if (p1) p1->bar(" if p1  ");
    
    {
        std::unique_ptr<Foo> p2(std::move(p1));  // now p2 owns Foo
	 
        if(p2.get())
           p1 = std::move(p2);  // ownership returns to p1

        if(p2)
        p2->bar( " p2 " );
        else 
        std::cout << "p2 moved\n";	

        std::unique_ptr<Foo> p3 = std::move(p1);
 
        if(!p2) std::cout << "p2 moved\n" << std::endl;
     
        p3->bar(" p3 ");

        Foo *p4=p1.get();
  
        if(!p1) std::cout << "p1 moved out\n"; 
  
        p4 = new Foo();

        std::cout << "destroying p2...\n";
    }

    if (p1) p1->bar("end if p1");

    // Foo instance is destroyed when p1 goes out of scope
}


