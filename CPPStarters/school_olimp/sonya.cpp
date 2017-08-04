/* (c) Roman Gritsulyak, 2016 */
#include <iostream>
#include <vector>
#include <map>
#include <memory>
using namespace std;
/*
  http://codeforces.com/contest/714/problem/E
  We use voting schema for solving Sonya's task
  details:
    
*/

int main(){
  // + vote if >= ;  - vote if i<
  // schema - find minimal sequence from end, where 
  // votes for positive is more than previous
  map<int,vector<int> > votes_for_levels; // position with + vote for key
  vector<int> values;
  vector<int> out_values;
  int n, current; // length of array, current;
  cin >> n; 
  
  int min_normalized=0;
  int max_normalized=0;

  out_values.reserve(n);
  
  for(int i=0;i<n;i++){
    cin >> current;
    int normalized=current-n;
    vector<int> & vote_at = votes_for_levels[normalized];
    vote_at.push_back(i);
    values.push_back(current);
    if(min_normalized>normalized)
      min_normalized=current-n;
    if(max_normalized<normalized)
      max_normalized=current-n;
  }; 
 
  int last_max=n;
 
  for(auto a=votes_for_levels.rend();a!=votes_for_levels.rbegin();--a)
  {
    ///*
    cout << "debug map:" << a->first << ":" 
    for(auto b:a->second) 
      cout << b << " ";
    cout << "\n";
    //*/
    // : find largest seq from the end where + votes more than -    
    ratio_prev=last_max;
    ratio_num_m=0;
    ratio_num_p=0;
    
    for(b=a->second().rend()-1;b!=a->second.rbegin();b--){
      ratio_num_m=ratio_prev-*b;
      ratio_prev=*b;
      ratio_num_p++;
      if(ratio_num_p>ratio_num_m)
        last_max=*b;
    }
    
    if(last_max<n)
      for(int j=last_max;j<n;j++){
	out_values[j]=a->first+j;
      }  

      
  
  }

  

}


