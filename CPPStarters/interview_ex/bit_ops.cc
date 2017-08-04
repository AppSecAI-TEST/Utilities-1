#include <iostream>
class Bitoper 
{
  public:
    uint64_t make_64word(const std::string * const str);
};

struct MyExcept : std::exception 
{
  char * what() {
    return "MyExcept!!";
  };
};

uint64_t Bitoper::make_64word(const std::string * const str)
{
  uint64_t retval;
  
  if(str->size()<7)
    throw MyExcept();

  retval = 0;

  for(int i=0;i<8;i++)
  {
    retval <<=8;
    retval |= str->operator[](i);
  }
 
  return retval;
}

int main(int argc, char **argv)
{
  Bitoper myoper;

  uint64_t retval = myoper.make_64word(std::unique_ptr
	<std::string>(new std::string("zhopa pizda!")).get());  

  std::cout << std::hex << retval;

  char*  my = (char *) &retval;
 // mac little endian - return perverted

  std::cout << "\n" << my << ":" << strlen(my)<< "\n";

// net - big endian ok
// arm mixed for long float
  return 0;
}
