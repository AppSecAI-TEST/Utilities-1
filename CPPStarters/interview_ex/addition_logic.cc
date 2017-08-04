#include <iostream>

uint32_t add(uint32_t a1,uint32_t a2)
{
  // 0b001110011
  // 0b011001011 
  //           o c 
  // 0 0 -> 0 0 
  // 0 1 -> 1 0
  // 1 0 -> 1 0
  // 1 1 -> 0 1 ->

  // o(b3)  cc prev c    o(b4) new c
  // 1      0  1 ->      0     1
  // 0      0  1 ->      1     0 
  // 0      1  1 ->      1     1


  uint32_t out = 0;
  uint32_t c = 0; // carry

  for(int i=0;i<32;i++)
  {
    // sum bits and get carry
    uint32_t b1 = (a1>>i) & 0b00000001;
    uint32_t b2 = (a2>>i) & 0b00000001;
    uint32_t b3 = b1 ^ b2;
    uint32_t cc = b1 & b2;

    // get sum of prev carry and bits
    uint32_t b4 = b3 ^ c; // out after prev carry adjust 
    c = b3 & c; // carry with prev carry adjust
    // sum carries
    c = c ^ cc;
     
    out = out | (b4<<i);
    std::cout << out << std::endl;
  }  
   
  return out;

}


int main()
{
  std::cout << add(5625,7343) << std::endl;
  std::cout << (5625+7343) << std::endl;
}

