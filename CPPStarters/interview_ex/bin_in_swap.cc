#include <iostream>
#include <vector>

using namespace std;

int slog2nfind(vector<int> & values, int value, 
	int begin/*=0*/, int end); // int end=values.size()-1);

// 23:24 proto
int main(int argc, char **argv)
{
  // 1 3 7 9 12 17
  // 12 17 1 3 7 9
  // 4  : val < start  => second sub string 
  // 14 > end 9 : val > start  => beg
  // 

  // if(in>vec.at(vec.size()-1))
  //   

  vector<int> vec = {12,14,17,1,3,7,9};  
  // 

  for_each(begin(vec),end(vec),
	[&](int v){std::cout << v << " ";}
        ); 

//  std::cout << slog2nfind(vec);
  
  std::cout << "\n14 find: " << slog2nfind(vec, 14,0, vec.size()-1); // int begin=0, 
	// int end=values.size()-1);
  std::cout << "\n15 find: " << slog2nfind(vec, 15,0, vec.size()-1);

  std::cout << "\n10 find:" << slog2nfind(vec, 10,0, vec.size()-1);
  
  std::cout << "\n3 find:" << slog2nfind(vec,3,0, vec.size()-1);
 
  return 0;
}


int simple_find(vector<int> & values, int value)
{
  for(int i=0;i<values.size();i++)
  {
    if(values[i]==value)
	return i;
  }
  return 0;
}

// 9 11 15 1 1 3 5 6 6 7 -> 4
// 1)
// val>cur cur>end -> right 
// val<cur cur>end 
//     val<beg -> right
//     val>beg -> left +
// val>cur cur<end ->
//     val>end -> left
//     val<end -> right 
// val<cur cur<end -> left +
//  
// extend it a little, 
// analyze case, when:
// val[beg]>val[end]
//   val_seek > val[end]
//     seek in first half
//   val_seek < val[end]
//     seek in second half
// else     
//   it is sorted well, seek normal
// 
int slog2nfind(vector<int> & values, int value, int begin, 
	int end)
{
  int cur_point = (end+begin) / 2;
 
  if(values[begin]==value)
  {
    return begin;
  } 

  if(values[end]==value)
  {
    return end;
  }
   
  if(end==begin || end==begin+1)
    return -1; // not found; or throw exception.

  if(values[cur_point]==value)
  {
    return cur_point;
  } 

  if( (value<values[cur_point] && values[cur_point]>values[end] &&
	     value>values[begin])
             || (values[cur_point]>value && values[cur_point]<values[end]) 
             || (value>values[cur_point] && values[cur_point]<values[end] &&
                value>values[end]))
  {
    // only left
    int new_end = cur_point;
    return slog2nfind(values,value,begin,new_end);
  } else // if( values[cur_point]>value && values[cur_point]>values[end])
  {  
    int new_begin = cur_point;
    return slog2nfind(values, value, new_begin,end);
  } 
}

