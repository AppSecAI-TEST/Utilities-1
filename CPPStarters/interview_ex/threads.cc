// thread example
#include <iostream>       // std::cout
#include <thread>         // std::thread
#include <mutex>	  // std::mutex

std::mutex mut;
 
void foo() 
{
  // do stuff...
  for(int i=0;;i++){ 
    std::cout << "Unlocked!" << std::endl;
    if(i%3==0){
      mut.lock();
      std::cout << " foo lock !! Uraa!";
      mut.unlock();
    }
  }
}

void bar(int x)
{
  // do stuff...
  for(int i=0;;i++){ 
   if(i%250000==0)
   {
      mut.lock();
      std::cout << " bar unlock: i=" << std::endl;
      mut.unlock();
   }
  }
}

int main() 
{
  std::thread first (foo);     // spawn new thread that calls foo()
  std::thread second (bar,0);  // spawn new thread that calls bar(0)

  std::cout << "main, foo and bar now execute concurrently...\n";

  // synchronize threads:
  first.join();                // pauses until first finishes
  second.join();               // pauses until second finishes

  std::cout << "foo and bar completed.\n";

  return 0;
}

