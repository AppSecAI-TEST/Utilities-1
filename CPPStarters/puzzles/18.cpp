#include <iostream>
#include <cmath> 

using namespace std;
const int MAX_LEVEL = 15;
const int SIZE = 120;

// (1+15) * 15 /2 == 8*15 == 120

int data[120] = 
{
75,
95, 64,
17, 47, 82,
18, 35, 87, 10,
20, 04, 82, 47, 65,
19, 01, 23, 75, 03, 34,
88, 02, 77, 73, 07, 63, 67,
99, 65, 04, 28, 06, 16, 70, 92,
41, 41, 26, 56, 83, 40, 80, 70, 33,
41, 48, 72, 33, 47, 32, 37, 16, 94, 29,
53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14,
70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57,
91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48,
63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31,
04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23
};

// here we save max values.
int data_max[120]; 

using namespace std;

inline int position(int level, int pos)
{
  return level*(level+1)/2 + pos;
}

int get_at(int *data, int level, int pos)
{
  return data[position(level,pos)];
}

int make_max_for(int level, int position, int *data, int *data_max){

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

  return 0;
}


