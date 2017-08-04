#include <iostream>
#include <fstream>
#include <cmath> 
#include <vector>

// projecteuler ( based on 18.cpp)
using namespace std;

vector<int> data;
vector<int> data_max;

inline int position(int level, int pos)
{
  return level*(level+1)/2 + pos;
}

int get_at(const vector<int> data, int level, int pos)
{
  return data[position(level,pos)];
}

int make_max_for(int level, int position, 
vector<int> data, vector<int> & data_max){

  if(level==0)
     return data[0];  

  int first_parent_max = position==0?
        0:
        get_at(data_max,level-1,position-1);  
  
  int second_parent_max = position==level?
	0:
	get_at(data_max,level-1,position);
  
  data_max[::position(level,position)] = std::max(first_parent_max,second_parent_max)
  + data[::position(level,position)];
  
  return 0;
}

int main(int argc, char ** argv)
{
// walk next -> what is parent/child of a[i]?
// a[0] -> childs are a[1] and a[2]; no parent
// a[1] -> childs are a[3] and a[4];
// a[2] -> childs are a[4] and a[5];
// for nth element in row k; childs are nth 
// and n+1th element in row k+1 
// strategy seeking solution:
// (clever method) up down
// algorithm -> updown: 
// select max sums and go up  
// 
  fstream myfile("p067_triangle.txt", std::ios_base::in); 
  // myfile.open("p067_triangle.txt"); 
  
  int current;
  int i=0;
  while(myfile >> current) {
  cout << " current=" << current;
  data.push_back(current);
  i++;
  }
   
  int MAX_LEVEL = (-1+sqrt(1+8*i))/2;

  cout << endl << " i = " << i << "; MAX_LEVEL=" << MAX_LEVEL << endl; 
  
  data_max.resize(i);  

  data_max[0] = data[0];  

  int iter = 0; 

  for(int i=1;i < MAX_LEVEL;i++)
  {
    int starting_point=(i+1)*i/2;
    for(int j=0;j<=i;j++)
      {
          iter++;
          make_max_for(i,j,data,data_max);
      }      
  }  

  std::cout << "total iters:" << iter << std::endl;

  for(int i=0;i < MAX_LEVEL;i++)
  {
    int starting_point=(i+1)*i/2;
    for(int j=starting_point;j<=starting_point+i;j++)
      {
        cout << data[j] << ":" 
	<< data_max[j] << " ";      
      }      
    std::cout << endl;
  }  

  int cur_max = 0;

  int starting = (MAX_LEVEL*(MAX_LEVEL-1)/2);
 
  for(i=(MAX_LEVEL*(MAX_LEVEL-1)/2);i<starting+MAX_LEVEL;i++)
    if(data_max[i]>cur_max)
      cur_max=data_max[i];
   
  cout << endl << "max=" << cur_max << endl;

  return 0;

}


