#include <iostream>
#include <vector>
#include <string>
#include <set>


// node 
class Node
{
  public:
  // visit node and its connections
  void set_connected(vector<Node *> & connected);
  void go();
  // initializes structure
  static bool displayer(void (*visitor)(std::string &in));
  private:
  static int counter=-1;
  static unique_ptr<std::set<Node *>> visitedp;
  static void (*visitor)(Node * in);
  std::vector<Node *> connections;
  std::string strout="val ";
};

static bool initialize(void *visitor(Node * in))
{
  visitedp = new std::set<Node>();
  counter = 0;
  this->visitor = visitor;
  return true;
}

//
// graph matrix
// 
int go()
{
  // visit string
  visitor(strout);
  // add graph 
  for(auto nodep : in){
//    if(nodep->)
       
  }

  return 0;
}

// 
//
int main(int argc, char **argv)
{
    

  return 0;
}



