#include <memory>
#include <iostream> 
#include <thread>
#include <chrono>
#include <mutex>

class One
{
  char * ptr;
protected:
  int value = 1;
public:
  One(){
    std::cout << "one\n";  
    ptr = new char[64];
  }

  virtual ~One(){
    std::cout << "~One\n";
    delete [] ptr;
  };
};

class Two : public One {
  char * ptr2;
public:  
  Two() //: value(2) // doestnt work 
  {
    value=2;
    std::cout << "Two\n";
    ptr2 = new char[128];
  };
  
  ~Two() {
    std::cout << "~Two\n";
  }
};



void thread_1(std::shared_ptr<One> one){ 
    std::this_thread::sleep_for(std::chrono::seconds(1));
//    std::shared_ptr<One> lp = one ; // thread-safe, even though the
                                  // shared use_count is incremented
    {
        static std::mutex io_mutex;
        std::lock_guard<std::mutex> lk(io_mutex);
        std::cout << "local pointer in a thread:\n"
                  << "  lp.get() = " << one.get()
                  << ", lp.use_count() = " << one.use_count() << '\n';
    }
}

void thread_2(std::shared_ptr<Two> two){
    std::this_thread::sleep_for(std::chrono::seconds(1));
    std::shared_ptr<One> lp = two; // thread-safe, even though the
                                  // shared use_count is incremented
    {
        static std::mutex io_mutex;
        std::lock_guard<std::mutex> lk(io_mutex);
        std::cout << "local pointer in a thread:\n"
                  << "  lp.get() = " << lp.get()
                  << ", lp.use_count() = " << lp.use_count() << '\n';
    }
}

int main()
{
  {
  std::shared_ptr<One> onetwo = std::make_shared<Two>();
  std::cout << "created some";
  
  std::shared_ptr<One> p = onetwo; 
 
  std::cout << "Created a shared Derived (as a pointer to Base)\n"
              << "  p.get() = " << p.get()
              << ", p.use_count() = " << p.use_count() << '\n';
    
  std::thread t1(thread_1, std::ref(onetwo)), t2(thread_1, std::ref(onetwo)), 
		t3(thread_1, std::ref(onetwo));
    
  p.reset(); // release ownership from main
    
  std::cout << "Shared ownership between 3 threads and released\n"
              << "ownership from main:\n"
              << "  p.get() = " << p.get()
              << ", p.use_count() = " << p.use_count() << '\n';
    
  t1.join(); t2.join(); t3.join();
  }
  std::cout << "All threads completed, the last one deleted Derived\n";
  std::cout << "return\n"; 
  
  return 0;
}


