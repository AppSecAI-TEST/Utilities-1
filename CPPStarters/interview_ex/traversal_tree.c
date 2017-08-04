/* 
// tree traversal, c version
*/ 

// malloc
#include<stdlib.h>
#include<stdio.h>

// start 19:55
// v1 finished 20:32 - prototype
// restart v2 20:50

typedef struct tree_ 
{
  struct tree_* nodes;
  __uint32_t length;
  __int32_t val;
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
  traverse_tree_b(tree_to_traverse); // breath traverse
  // traverse tree and prints out deep
  // traverse_tree_deep(tree); // traverse deep

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
  tree * cur_layer_nodes = ttt;
  
  if(!cur_layer_nodes)
    return -1;
  
  printf("head:%d\n", cur_layer_nodes->val); 
 
  // layers loop
  while(cur_layer_nodes)
  {
    for(int i=0;i<cur_layer_nodes->length;i++)
    {
      // print nodes in layer
      printf("i=%d val:%d; ",i, cur_layer_nodes->nodes[i].val);
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
// 21:24 fin 
tree * get_nodes_for_next_layer(tree *cur_layer_head)
{
// we need to allocate array for this nodes;
// get size
  int size = 0;
  for(int i=0;i<cur_layer_head->length;i++)
  {
    if(cur_layer_head->nodes[i].nodes)
    size += cur_layer_head->nodes[i].length;
  }

  printf("size=%d\n",size);

  if(size==0)
    return 0;

// allocate
   
  tree *new_nodes = calloc(size,sizeof(tree)); 

  if(!new_nodes)
    return 0; 

  tree *new_head = calloc(1,sizeof(tree));
  
  if(!new_head)
    return 0;  

  new_head->nodes=new_nodes;
  new_head->length=size;

  // move old nodes to new
  int s = 0;
  for(int i=0;i<cur_layer_head->length;i++)
  {
    for(int j=0;j<cur_layer_head->nodes[i].length;j++)
    {
      new_head->nodes[s]=cur_layer_head->nodes[i].nodes[j];
      //printf("set node %d; from [%d][%d] val %d", s, i, j, cur_layer_head->nodes[i].nodes[j].val );
      s++;
    }
  }

  // free old
  // free(cur_layer_nodes);
 
  return new_head;
}

// 20:53 start prepare tree
// 21:05 test finished


tree *prepare_tree()
{
 tree *head = calloc(1,sizeof(tree));
 
 if(!head)
  return NULL;
 
 head->val=1; 

 head->nodes = calloc(5,sizeof(tree));
 
 if(!head->nodes)
  return NULL;

 head->length=5; 
 
 head->nodes[0].val = 2;
 head->nodes[1].val = 3;
 head->nodes[2].val = 4;
 head->nodes[3].val = 5;
 head->nodes[4].val = 6;
  
 head->nodes[0].nodes=calloc(5,sizeof(tree));
 
 if(!head->nodes[0].nodes)
   return NULL; 
 
 head->nodes[0].length = 5;

 head->nodes[0].nodes[0].val = 7;
 head->nodes[0].nodes[1].val = 8;
 head->nodes[0].nodes[2].val = 9;
 head->nodes[0].nodes[3].val = 10;
 head->nodes[0].nodes[4].val = 11;
 
 head->nodes[1].nodes=calloc(5,sizeof(tree));
 
 if(!head->nodes[1].nodes)
   return NULL;

 head->nodes[1].length = 5;

 head->nodes[1].nodes[0].val = 12;
 head->nodes[1].nodes[1].val = 13;
 head->nodes[1].nodes[2].val = 14;
 head->nodes[1].nodes[3].val = 15;
 head->nodes[1].nodes[4].val = 16;
 
 head->nodes[2].length = 0;
 head->nodes[2].nodes = NULL;
 
 head->nodes[3].nodes=calloc(5,sizeof(tree));
 
 if(!head->nodes[3].nodes)
   return NULL;

 head->nodes[3].length = 5;

 head->nodes[3].nodes[0].val = 17;
 head->nodes[3].nodes[1].val = 18;
 head->nodes[3].nodes[2].val = 19;
 head->nodes[3].nodes[3].val = 20;
 head->nodes[3].nodes[4].val = 21;

 //head->nodes[3].nodes[2].nodes = head->nodes+1;
 //head->nodes[3].nodes[2].length = head->nodes[1].length;


 head->nodes[4].nodes=NULL; 
 head->nodes[4].length=0;

 return head;

}


