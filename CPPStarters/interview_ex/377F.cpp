#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{
  vector<int> N[400000];
  int M[400000][2];
  int n,m;
  
  cin >> n >> m;
  
  for(int i=0;i<m;i++)
  {
    cin >> M[i][0] >> M[i][1] >>endl;
    N[M[i][0]].push_back(M[i][1]);
    N[M[i][1]].push_back(M[i][0]);
  }

  // 1 find out of cycles
  // 2 put them "in"
  for(int i=0;i<m;i++)
  {
    
  }
  
  return 0;
}

