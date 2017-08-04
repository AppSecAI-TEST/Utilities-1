#include <string>
#include <iostream>

std::string getCity (bool c)
{
    if(c)    return "Chicago";    
    else    return "New York";
}
    
void printCity(const std::string& city) { 
 std::cout <<"citi: const: " << city;
/* ... */}    // implementation 1
void printCity(std::string&&  city)     { 
std::cout <<"citi no const: " << city;
/* ... */}    // implementation 2

int main()
{
    std::string city = getCity(false);    
    printCity( city );                  // LINE X
    printCity( getCity(true) );         // LINE Y

    return 1;
}
