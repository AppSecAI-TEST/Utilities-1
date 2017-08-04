/* 
// tree traversal, c version
*/ 
#include<stdio.h>

// start 19:55
// v1 finished 20:32 - prototype

struct tree;

struct tree_ 
{
 // if *node==0 then it is end of list
  tree* nodes;
  int32_t length;
  int32_t val;
} tree;

int traverse_tree_b(tree *to_traverse);
int traverse_tree_deep(tree *to_traverse);
tree *get_nodes_for_next_layer(tree *cur_layer_nodes);
tree *prepare_tree();

int main(int argc, char **argv) 
{
  // we traverse tree different 
  tree * tree_to_traverse = prepare_tree();
  // traverses and prints out tree breath
  traverse_tree_b(tree); // breath traverse
  // traverse tree and prints out deep
  traverse_tree_deep(tree); // traverse deep

  return 0;
};

/*
      O  <- 1
    +-+-+ <--
    1 3 6 <- 2 - put in array -> allocate it 
   
  ........ <-3

*/

// non-recursive!
int traverse_tree_b(tree *ttt)
{
  tree *current_layer;
  
  // proto
  // printf("value: %d\n", ttt->a);
  // printf("value: %d\n", *(ttt->nodes)->a);  
  
  int non_end = 1; 

  tree * cur_layer_nodes = ttt;
  
  // layers loop
  while(non_end)
  {
    // nodes in layer loop
    // make array of nodes to print:
    // get all layer nodes in line from current nodes
    // we are on layer n:

    tree *cur_layer_nodes = get_nodes_for_next_layer(cur_layer_nodes); 

    for(int=0;i<cur_layer_nodes->length;i++)
    {
      // print nodes in layer
      printf("val:%d",(cur_layer_nodes+i)->val);
    }    
  } 

  return 0;

}


