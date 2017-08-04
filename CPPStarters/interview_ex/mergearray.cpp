#include <iostream>
#include <vector>

using namespace std;
 
// O(n) without additional memory
bool merge2(vector<int> & array1, const vector<int> & array2, int a1size)
{ 
   int j1, j2, j1_;  // iterator through array1 -> changed, contains output
   
   if(a1size+array2.size()>array1.size())
      return false;
 
   j2=array2.size()-1;
   j1_=a1size+array2.size()-1;
   
   for(int j1=a1size-1;j1>=0;j1--)
   {
     if(j1_<0)
       break;
     while(array1[j1]<array2[j2] && j2>=0 && j1_>=0){
       array1[j1_]=array2[j2];
       j2--;
       j1_--;
     }
 
     array1[j1_]=array1[j1];
     j1_--; 
  }
   
   return true;
}

int main(int argc, char **argv)
{
  vector<int> array1={1,5,8,9,13,0,0,0,0,0};
  vector<int> array2={3,7,8};
  int a1size=5;

  merge2(array1,array2,a1size);

  for(auto i:array1)
    std::cout << i << "\n";

  return 0;
}

 
