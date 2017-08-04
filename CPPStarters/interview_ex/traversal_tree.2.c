/* 
// tree traversal, c version
*/ 
#include<stdio.h>

// start 19:55
// v1 finished 20:32 - prototype
// restart v2 20:50
struct tree;

struct tree_ 
{
 // if *node==0 then it is end of list
  tree* nodes;
  int32_t length;
  int32_t val;
} tree;

int traverse_tree_b(tree *to_traverse);
// int traverse_tree_deep(tree *to_traverse);
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

// 21:05 start
// 21:24 fin 
tree * get_nodes_for_next_layer(tree *cur_layer_nodes)
{
// we need to allocate array for this nodes;
// get size
  size = 0;
  for(int i=0;i<cur_layer_nodes->length;i++)
  {
    size += cur_layer_nodes[i].length;
  }

// allocate
   
  tree *new_nodes = malloc(size*sizeof(tree)); 

  if(!tree)
    return 0; 

  tree *cur_node = malloc(sizeof(tree));
  
  if(!tree)
    return 0;  

  cur_node->nodes=new_nodes;

  // move old nodes to new
  s = 0;
  for(int i=0;i<cur_layer_nodes->length;i++)
  {
    for(int j=0;j<cur_layer_nodes[i].length;j++)
    {
      cur_node->new_nodes[s]=cur_layer_nodes[i].nodes[j];
      s++;
    }
  }

  // free old
  free(cur_layer_nodes->nodes);
  free(cur_layer_nodes);

  return cur_node;
}

// 20:53 start prepare tree
// 21:05 test finished

tree *prepare_tree()
{
 tree *head = malloc(sizeof(tree));
 
 if(!head)
  return 0;
 
 head->value=1; 

 head->nodes = malloc(sizeof(tree)*5);
 
 if(!head->nodes)
  return 0;
  
 head->nodes[0].value = 2;
 head->nodes[1].value = 3;
 head->nodes[2].value = 4;
 head->nodes[3].value = 5;
 head->nodes[4].value = 6;
  
 head->nodes[0].nodes=malloc(sizeof(tree)*5);
 
 if(!head->nodes[0].nodes)
   return 0; 

 head->nodes[0].nodes[0].value = 7;
 head->nodes[0].nodes[1].value = 8;
 head->nodes[0].nodes[2].value = 9;
 head->nodes[0].nodes[3].value = 10;
 head->nodes[0].nodes[4].value = 11;
 
 head->nodes[1].nodes=malloc(sizeof(tree)*5);
 
 if(!head->nodes[1].nodes)
   return 0;

 head->nodes[1].nodes[0].value = 12;
 head->nodes[1].nodes[1].value = 13;
 head->nodes[1].nodes[2].value = 14;
 head->nodes[1].nodes[3].value = 15;
 head->nodes[1].nodes[4].value = 16;
 
 head->nodes[3].nodes=malloc(sizeof(tree)*5);
 
 if(!head->nodes[3].nodes)
   return 0;

 head->nodes[3].nodes[0].value = 17;
 head->nodes[3].nodes[1].value = 18;
 head->nodes[3].nodes[2].value = 19;
 head->nodes[3].nodes[3].value = 20;
 head->nodes[3].nodes[4].value = 21;
 
 if(!head->nodes[3].nodes)
   return 0;
}



