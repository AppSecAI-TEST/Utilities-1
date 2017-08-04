#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

const uint64_t MAX_NUM=10000000000000000;

vector<int> out_ring;
vector<int> in_ring;

uint64_t make_max(const vector<int> & out_ring, const vector<int> & in_ring)
{
  string sret = "";

  sret = sret + to_string(out_ring[0]) + to_string(in_ring[0]) 
  + to_string(in_ring[1]);

  sret = sret +to_string(out_ring[1]) + to_string(in_ring[1]) 
  + to_string(in_ring[2]);

  sret = sret + to_string(out_ring[2]) + to_string(in_ring[2]) 
  + to_string(in_ring[3]);

  sret = sret + to_string(out_ring[3]) + to_string(in_ring[3]) 
  + to_string(in_ring[4]);

  sret = sret + to_string(out_ring[4]) + to_string(in_ring[4]) 
  + to_string(in_ring[0]);

  /*
  {
  uint64_t ret = 0 ;
  ret += out_ring[0]*100 + in_ring[0]*10 + in_ring[1];
  ret = ret*1000 + out_ring[1]*100 + in_ring[1]*10 + in_ring[2];
  ret = ret*1000 + out_ring[2]*100 + in_ring[2]*10 + in_ring[3];
  ret = ret*1000 + out_ring[3]*100 + in_ring[3]*10 + in_ring[4];
  ret = ret*1000 + out_ring[4]*100 + in_ring[4]*10 + in_ring[0];
  }
 
  return ret;
  */
   
  uint64_t ret;
  stringstream(sret) >> ret;

  return ret;
}

bool is_eligible(const vector<int> & out_ring, const vector<int> & in_ring)
{
  int value = out_ring[0] + in_ring[0] + in_ring[1];
  
  if(out_ring[1] + in_ring[1] + in_ring[2] != value)
    return false;

  if(out_ring[2] + in_ring[2] + in_ring[3] != value)
    return false;

  if(out_ring[3] + in_ring[3] + in_ring[4] != value)
    return false;

  if(out_ring[4] + in_ring[4] + in_ring[0] != value)
    return false;
   
  return true;
}

int main()
{
  // 16 digits -> 10 is external.
  // 9 -> is starting external
  uint64_t max_number = 0;
  
  vector<int> eight={1,2,3,4,5,6,7,8,9,10};   

  do {
/*  
  cout << "current eight:"; 
  for(auto val:eight) cout <<" " <<  val;
  cout << endl;
  */

  out_ring.clear();
  in_ring.clear();

 // out_ring.push_back();

  next_permutation(eight.begin(),eight.end());
  
  out_ring.push_back(eight[0]);
  out_ring.push_back(eight[1]);
  out_ring.push_back(eight[2]);
  out_ring.push_back(eight[3]);
  out_ring.push_back(eight[4]);
  
  in_ring.push_back(eight[5]);
  in_ring.push_back(eight[6]);
  in_ring.push_back(eight[7]);
  in_ring.push_back(eight[8]);
  in_ring.push_back(eight[9]);
  
  if(is_eligible(out_ring,in_ring)){
       uint64_t current = make_max(out_ring, in_ring);
       cout << "current";
       
       for(auto val:eight) cout <<" " <<  val;
         cout << endl;
       cout <<  "; eligible:" << current << endl;
       
       if(current > max_number && current < MAX_NUM)
         max_number = current;       
    }
  
 } while (next_permutation(eight.begin(),eight.end()));
 

  cout << "max:" << max_number << endl;
  
  return 0;
}

