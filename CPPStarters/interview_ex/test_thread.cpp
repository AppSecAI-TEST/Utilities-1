#include <iostream>
#include <thread>

static int a=0;

void worker()
{
    std::cout << "another thread" << a++ << std::endl;
}

int main()
{
    for(int i=0;i<100;i++)
    {
    std::thread t(worker);
    std::cout << "main thread" << std::endl;
    t.join();
    }
    return 0;
}

