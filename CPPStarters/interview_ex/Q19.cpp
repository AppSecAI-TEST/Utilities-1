#include <iostream>
using namespace std;
//Which of the following will be the output upon executing the C++ code segment below?
void func1();
void func2();
void func3();
void func4();

void func1() {
    func2();
    cout << "func1  ";
    throw 1;
}

void func2() {
    try {
        func3();
    }
    catch(const exception& e) {
        cout << "10  ";
        throw 2;
    }
    catch(...) {
        cout << "5  ";
        throw "two  ";
    }
}

void func3() {
    cout << "func3  ";
    func4();
}

void func4() {
//    exception e="func4  ";
    throw 10;
}

int main()
{
    try {
        func1();
    }
    catch(int i) {
        cout << i;
    }
    catch(const exception& e) {
        cout << e.what();
    }
}


