#include "objectpool.h"
#include <iostream>
#include <cstdlib>
#include <cstdint>
#include <vector>
#include <chrono>
#include <thread>

class Small
{
public:
    char ticker_id;
    int16_t bid;
    int16_t ask;
};

class Medium
{
public:
    char ticker_id;
    int32_t bid;
    int32_t ask;
};

class Large
{
public:
    int16_t ticker_id;
    int64_t bid;
    int64_t ask;
    int16_t precision; // after dot
    int64_t epoch_time;
};

int main()
{
    pool<100> pool100(120,20);
    std::shared_ptr<large> largeptr = nullptr;
    std::cout << largeptr << ":" << sizeof(*largeptr) << std::endl;

//    while(true)
    {
        std::this_thread::sleep_for (std::chrono::seconds(1));
    }

    pool100.alloc(largeptr);
    std::cout << largeptr->bid << std::endl;
    std::cout << "pool:" << &pool100 << std::endl;

    return 0;
}

