#include <iostream>
#include <vector>

using namespace std;

int vectorNat(vector<int> a, int at){
   return a[at-1];
}

void setvectorNat(vector<int> &a, int at, int value){
   a[at-1] = value;
}

bool checkNum(vector<int> &toCheck){
  int temp;
  int sz = toCheck.size();
  for(int i=1;i<=sz;i++)
  {
    temp = i;
    
    while(temp!=vectorNat(toCheck,temp))  
      { 
        int temp1=vectorNat(toCheck,temp);
        if(temp1>sz)
           return false;

        if(vectorNat(toCheck,temp1)==temp1)
           return false; 

        int temp2=vectorNat(toCheck,temp1);
        if(temp2>sz)
           return false;
        setvectorNat(toCheck,temp1,temp1);
        setvectorNat(toCheck,temp,temp2);
        // element be move
        // false positive case:
      }
  }
  return true;
}

int main(int argc, char **argv)
{
  /* check if 1..N in sequence */ 
  vector<int> N1 = {6,3,2,4,5,1,7,8};
  vector<int> N2 = {1,3,2,6,4,5,8,7,6};
  vector<int> N3 = {1,3,5,6};

//  setvectorNat(N1,3, 10);

  for(int i=1;i<= N1.size();i++) 
     cout << vectorNat(N1,i) << endl;
  
  std::cout << checkNum(N1) <<":"; for(auto i: N1) cout << i << std::endl;
  std::cout << checkNum(N2) <<":"; for(auto i: N2) cout << i << std::endl;
  std::cout << checkNum(N3) <<":"; for(auto i: N3) cout << i << std::endl;

  return 0;
}


