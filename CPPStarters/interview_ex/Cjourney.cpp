#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
// from ->  sorted: best time to solve -> longest amount for time
//      ->  
unordered_map<int, unordered_map<int, int> > solved;
/* (c) rt gritsulyak 2016
  pathes_from - array of pathes from 
  city to city with weight
  from - which city path is
  Tleft - time left to go
  path - already pathed path
*/
int best_path_to_n(const unordered_map<int,vector<pair<int,int>> > & 
        pathes_from, // pathes_from - array of pathes from
	const int from, // from - which city path is 
        const int Tleft, // Tleft - time left to go
        const int toN, // final point
        int & Tconsumed, // consumed time amount
        vector<int> & path) // already pathed path
{
/* cout << "trace:" << from << ":" << toN << ":" << Tleft << ":";
 for(auto i:path)
   cout << i;
 cout <<"\n";   
*/ // child pathes to investigate
 vector<pair<int,int>> pathes;
 
 try {
   pathes = pathes_from.at(from);
 } catch (...)
 {
   return -1;
 }
 int TcurrentConcumed = 0;
 int longest=-1;
 vector<int> longestPath;
 int pathN; // number of path

 for(auto k=0;k<pathes.size();k++)
 {
//   cout << "d: pathes[k]" << pathes[k].first << ":" <<
//    pathes[k].second << "\n";
   int currentL;
   vector<int> pathNew; // path from childs
   int newTleft = Tleft-pathes[k].second;
   TcurrentConcumed = pathes[k].second;
//   cout << "d: Tleft" << newTleft;   
   if(newTleft<0)
     continue;
   
   if(pathes[k].first==toN)
   { 
     currentL=1;
     pathNew.push_back(toN);
   } else { 
   currentL = best_path_to_n(pathes_from,
      pathes[k].first,newTleft,toN,TcurrentConcumed,pathNew);
   }

   if(currentL>longest)
   {
     longest = currentL;
     longestPath = pathNew;
   };
 } 

 path.push_back(from);
 path.insert(path.end(),
             longestPath.begin(), 
             longestPath.end());
 
 Tconsumed +=TcurrentConcumed;
 /*
 for(auto i:path)
   cout << i;
 cout <<"\n";
*/
 return path.size();
}

int main(int argc, char ** argv){
 int m,n,T;
 cin >> n >> m >> T;  

 // n - cities
 // m - roads
 // T - max time
 unordered_map<int,vector<pair<int,int>> > pathes_from;

 for(int i=0;i<m;i++)
 {
  int from, to, itime;
  cin >> from >> to >> itime;
  pair<int,int> road(to, itime);  
  pathes_from[from].push_back(road);
 }

 // лучший путь из i в n 
 // за оставшееся время Tleft
 // best_path_to_n(i, Tleft) returns n - length:
 // max(best_path_to_n(pathes_from[i][k][0],
 // Tleft-pathes_from[i][k][0]); 
 // k =0..sz(pathes_from[i])  
 vector<int> path;
 int sz;
 int tc;
 // best path from 
 sz=best_path_to_n(pathes_from,1,T,n,tc,path);
 
 cout << sz << "\n";

 for(int i=0;i<sz;i++):
   cout << path[i] << " ";
 
 cout << "\n"; 

}

