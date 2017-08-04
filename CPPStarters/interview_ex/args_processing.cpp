#include <iostream>
#include <string>

template<typename T>
T adder(T v) {
  return v;
}

template<typename T, typename... Args>
T adder(T first, Args... args) {
  return first + adder(args...);
}

class PreAllocate
{
  static int counter=0;
  public: 
   
  std::string toString() {
      return std::string(counter++);    
    };
}; 

template <std::size_t MAX_OBJ_SIZE>
class not_optimal_pool 
{
  public:
    not_optimal_pool() {};
    
    // 
    template<typename OBJECT, typename ... ARGS>
    void alloc (std::shared_ptr<OBJECT> & object, ARGS ... args) 
    {
            
    };   

  private:

    template<typename T, typename ... ARGS>
    void args_processor(T arg, ARGS ... args)
    {
       std::cout << arg.toString() << "\n";
       if(sizeof...(args)==0)
         return;
       args_processor(args...);
    };

//    template<typename T>
//    void args_processor(T arg);
};

//inline template<std::size_t SZ>
//template<typename T>
//void not_optimal_pool<SZ>::args_processor<T>(T arg)
//{
//  std::cout << arg.toString << "\n";
//  std::cout << " endl \n" ;
//}

int main(int argc, char **argv)
{
  not_optimal_pool<100> opto;
  opto.alloc(); 

  std::cout << adder(1,2,3,4,5,6);  
  
  std::cout << opto;

  return 0;
}

