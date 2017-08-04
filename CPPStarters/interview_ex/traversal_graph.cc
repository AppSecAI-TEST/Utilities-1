/* 
// graph traversal, c version
*/ 

// malloc
#include<set>
#include<stdlib.h>
#include<stdio.h>
#include<vector>
#include<iostream>
// start 19:55
// v1 finished 20:32 - prototype
// restart v2 20:50


using namespace std;

class graph 
{
  public:
  graph(int v):val{v}{};
  ~graph(){ cout << "icocapizd: " << val << endl;}
  vector<graph *> nodes;
  int32_t val;
};

std::set <graph*> passed;

int traverse_graph_b( vector<graph *> &to_traverse);
// int traverse_graph_deep(graph *to_traverse);
vector <graph *> & get_nodes_for_next_layer(vector<graph *>& cur_layer_nodes);
graph *prepare_graph();

int main(int argc, char **argv) 
{
  // we traverse graph different 
  graph * graph_to_traverse = prepare_graph();
  // traverses and prints out graph breath
  vector<graph *> toTraverse = *(new vector<graph *>);
  toTraverse.push_back(graph_to_traverse);

  traverse_graph_b(toTraverse);
  // breath traverse
  // traverse graph and prints out deep
  // traverse_graph_deep(graph); // traverse deep

  return 0;
};

/*
      O  <- 1
    +-+-+ <--
    1 3 6 <- 2 - put in array -> allocate it 
   
  ........ <-3

*/

// non-recursive!
int traverse_graph_b(vector<graph *> & ttt)
{
  vector<graph *> &cur_layer_nodes = ttt;
  
  if(cur_layer_nodes.empty())
    return -1;
  
  // layers loop
  while(!cur_layer_nodes.empty())
  {
    for(auto i: cur_layer_nodes)
    {
      // print nodes in layer
      printf("i=%d val:%d; ",i,i->val);
    }    

    printf("\n");

    // nodes in layer loop
    // make array of nodes to print:
    // get all layer nodes in line from current nodes
    // we are on layer n:
    cur_layer_nodes = get_nodes_for_next_layer(cur_layer_nodes); 
  } 

  return 0;
}

// 21:05 start
// 21:24 fin `
vector<graph *> & get_nodes_for_next_layer(vector<graph *> & cur_layer_head)
{
// allocate
   
  std::vector<graph *> & new_nodes = *(new vector<graph*>); 

  // move old nodes to new
  for(int i=0;i<cur_layer_head.size();i++)
  {
    for(int j=0;j<cur_layer_head[i]->nodes.size();j++)
    {
      graph * current = cur_layer_head[i]->nodes[j];
      if(current && passed.find(current)==passed.end())
        {
          passed.emplace(current);
          new_nodes.push_back(current);
        }
    }
  }

  // free old
  // free(cur_layer_nodes);

  return new_nodes;
}

// 20:53 start prepare graph
// 21:05 test finished


graph *prepare_graph()
{
 graph *head = new graph(1); //calloc(1,sizeof(graph));
 
 head->val=1; 

 head->nodes = *(new vector<graph *>(5));
 head->nodes={new graph(2),
   new graph(3),
   new graph(4),
   new graph(5),
   new graph(6)}; // calloc(5,sizeof(graph));
 
 head->nodes[0]->nodes= *(new vector<graph *>(5));
 head->nodes[0]->nodes={new graph(65),
   new graph(7),
   new graph(8),
   new graph(9),
   new graph(10)}; // calloc(5,sizeof(graph));

 head->nodes[1]->nodes= *(new vector<graph *>(5));
 head->nodes[1]->nodes={new graph(11),
   new graph(12),
   new graph(13),
   new graph(14),
   new graph(15)}; 
 
 head->nodes[3]->nodes= *(new vector<graph *>(5));
 head->nodes[3]->nodes={new graph(212),
   new graph(213),
   new graph(214),
   new graph(215),
   new graph(216)}; 
 
 head->nodes[3]->nodes[2] = head->nodes[1];

 //head->nodes[3].nodes[2].nodes = head->nodes+1;
 //head->nodes[3].nodes[2].length = head->nodes[1].length;


 head->nodes[4]->nodes= *(new vector<graph *>(5));
 head->nodes[4]->nodes={new graph(4212),
   new graph(4213),
   new graph(4214),
   new graph(4215),
   new graph(4216)}; 

 return head;

}


