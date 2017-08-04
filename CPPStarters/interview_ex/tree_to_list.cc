#include <iostream>
#include <cassert>
#include <memory>

// 19.25 start
struct node {
node *node1;
node *node2;
int value;
};

typedef node inode;
typedef node ilist;

// leaf (no childs)
// 
ilist * add_1leaf_to_list(
                 inode *leaf,   // leaf to add
                 ilist *list)   // add there
{ 
  std::cout << "add leaf:" << leaf->value << std::endl;
  assert((!leaf->node1 && !leaf->node2));

  if(!list) 
    return leaf;

  ilist *outlist=list;
  ilist *prev=nullptr;
  for(;outlist!=nullptr;prev=outlist,outlist=outlist->node2)
  {
// was:
//   a->node2==b; b->node1==a; b->node2==c ; c->node1=b
// should
//   +a->node2==new; +new->node1==a; +new->node2==b; +b->node1==new ; c->node1=b 
//

    if(leaf->value<outlist->value)
    {
      leaf->node2=outlist;
       
    // out  prev > cur 
    //      prev > leaf > cur       
      leaf->node1=outlist->node1;
      outlist->node1->node2=leaf;   
      outlist->node1=leaf;

// handle bgin
      if(list==outlist) // 
        list=leaf;
      return list;
    }
  }
  // end handle 
  leaf->node1=prev;
  prev->node2=leaf;

  return list;
}

// 20:07 break
// 21:45 return
// 21:57 finish tomorrow; tired
ilist * traverse_nodes(inode *parent, inode *child, ilist *in)
{
   if(!child) // if in null
      return in;
   
   if(child->node1)
     in = traverse_nodes(child,child->node1,in);
   
   if(child->node2)
     in = traverse_nodes(child,child->node2,in);   

   if(!child->node1 && !child->node2) // leaf
   {
     if(parent)
       if(parent->node1==child)
         parent->node1=nullptr;
       else if(parent->node2==child)
         parent->node2=nullptr;

     in = add_1leaf_to_list(child, in);
     return in;
   } 

   return in;
}

//           100
//     50           150
//   25   75      30    200
// 10  27
int main() 
{ 
  inode i1 = {nullptr,nullptr,100}; 
  inode i2 = {nullptr,nullptr,50}; i1.node1=&i2;// 1l 
  inode i3 = {nullptr,nullptr,150};i1.node2=&i3;// 1r  
  inode i4 = {nullptr,nullptr,25}; i2.node1=&i4;// 2l
  inode i5 = {nullptr,nullptr,75}; i2.node2=&i5;// 2r
  inode i6 = {nullptr,nullptr,30}; i3.node1=&i6;// 3l 
  inode i7 = {nullptr,nullptr,200};i3.node2=&i7;// 3r  
  inode i8 = {nullptr,nullptr,10}; i4.node1=&i8;// 4l
  inode i9 = {nullptr,nullptr,27}; i4.node2=&i9;// 4r 

  // 
  ilist *list = nullptr;
  list=traverse_nodes(nullptr,&i1,list);
  
  for(list;list!=nullptr;list=list->node2)
    std::cout <<"->" << list->value << "\n";
 
  return 0;
}

