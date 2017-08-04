#include <iostream>
#include <vector>
#include <algorithm>
// TODO fill that,
// make guide
// train before tomorrow interview
// vector of vector to matrix
// map of vectors,
// multimap
// list

/* artificial task:
   sort n*n
   as vector of vectors
   most values are in center */

using namespace std;

void out_2dim(const vector<vector<int>> & vec){
  for(auto veca: vec){
    for(auto i: veca)
      std::cout << i << ":";
    cout << endl;
  }
}

// put element next to
bool put_elem(vector<vector<int>> & vec, int x,int y, int value)
{
  if(vec[x][y]==0) {
    vec[x][y]=value;
  } else return false;
  return true;
}

/* std=c++14 */
int main()
{
 // assume > 0
  vector<vector<int>> vec = {{1,2,3,4,5},
                         {6,7,8,9,10},
                         {11,12,13,14,15},
                         {16,17,18,19,20},
      			 {21,22,23,24,25}};

  out_2dim(vec);

  // method1: reassign to new array
  vector<int> newvec;
   
  for(auto veca: vec){
    for(auto i: veca)
      newvec.push_back(i);  
  }
    
  for(auto i:newvec) 
    std::cout << i << ":";
  std::cout << endl;
 
  std::sort(newvec.begin(),newvec.end(), 
            [](int i, int j) 
		{return i>j;}); 
  
  for(auto i:newvec) 
    std::cout << i << ":";
 
  // we need way to produce array element -> 2dim coord
  // 11->1 12->2 13->3 
  // 21 22->0 23
  // 31 32 33
  // make empty vector
  
  vector<int> row(5,0);
  vector<vector<int>> out(5,row);
       
  out_2dim(out);  

  int curx=5/2;
  int cury=5/2;

  pair<int,int> coords;  
  vector<pair<int,int>> vcoords;  

  for(int i=0;i<5;i++)
    for(int j=0;j<5;j++)
    {
      coords=make_pair(i,j);
      vcoords.push_back(coords);
    }
  
  // sort coords by distance from center
  sort(vcoords.begin(),vcoords.end(),[&](auto a,auto b) 
      {return abs(curx-a.first)+abs(cury-a.second)<
           abs(curx-b.first)+abs(cury-b.second);} // decreasing
  );

  for(int i=0;i<newvec.size();i++)
  {
    // fill central cubicle
    put_elem(out,vcoords[i].first,vcoords[i].second,newvec[i]);   
  }
 
  out_2dim(out);

 
  return 0;
}

