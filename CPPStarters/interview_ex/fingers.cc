#include <iostream>

class test final {
 int test;
};

// unsafe, experimental
uint64_t rol(uint64_t val, int shift ){
   return (val << shift)|(val >> (sizeof(uint64_t)*8-1));
}

uint64_t myhash(uint64_t input)
{
   uint64_t ret= input^0xabcdefff12345678;
   return ret;
}

uint32_t hasg(uint64_t in) 
{
   uint32_t hash, i;
   for(hash = i = 0; i< 8 ; i++)
   {
     hash += (in << (i*8))>>(i*8-1);
     hash += (hash <<10);
     hash ^= (hash >>6);
   }
   hash +=(hash <<3);
   hash ^=(hash >>11);
   hash +=(hash <<15); 
   return hash>>2;
}

int main(int argc, char ** argv)
{
  std::cout << "import fingerprints" << std::endl;

  uint32_t h3=hasg(73930);
  uint32_t h2=hasg(36478);
  
  std::cout << "3=>" << h3 << "\n 2=>" 
  << h2 ; 

  // create hashtable (32 bit)
  uint32_t size= 1<<30 ;
  std::cout << "\nsize=" << size << std::endl;

  uint64_t * hashes = new uint64_t[size];

  for(uint64_t j=0;j<10000;j++)
  {
    uint64_t offset=j*size;
    // clean
    for(int i=0;i<size;i++)
    {
      hashes[i]=0;     
    }  

    int zero_at=-1;

    for(int i=0;i<size;i++)
    {
       uint64_t value=offset+i;
       uint32_t key = hasg(value);
       
       if(key==0)
       {
         if(zero_at==-1)  
           zero_at=i; 
         else
           {
             std::cout << "zero collision detected:\n"
             "value = " << value <<
             "\n prev_value = " << zero_at;
             return 0;
           }	 
       }

       if(hashes[key]>0)
         { /*
           int found=-1;
	   for(int k=i-1;k>0;k--)
	   {
	     if(hasg32(k+offset)==key)
		found=k; 	     
	   } */
	     
	   std::cout << "collision detected:\n"
             "value = " << value <<
             "\n prev_value = " << hashes[key] - offset <<
             "\n key = " << key;
             return 0;
	 }          
       hashes[key] = value;
    }
  }
}


