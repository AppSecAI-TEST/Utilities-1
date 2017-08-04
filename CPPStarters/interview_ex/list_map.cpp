#include<utility>
#include<list>
#include<map>
#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main()
{
  list<int> li = {11,1,2,5,6};

  li.sort([](int i1,int i2){
    return i1<i2;
  });

  map<int, vector<int>> mod3;
  
  for(auto a:li)
  {
  cout << "li elem:" << a << endl;
  vector<int> mod3val = mod3[a%3];
  mod3val.push_back(a);
  mod3[a%3]=mod3val;
  }
   
  for(auto a:mod3)
  {
  cout<< "mod3 elem:" << a.first << "=>"; 
    for(auto b:a.second)
       cout << ":" << b;
  cout <<endl;
  }  

}

