/* problem description:
  - hard to understand syntax, it is not clear.
  - hard to write, context sesitive, trace not works everywhere
  solution:
  -1) recreate syntactic tree basing on what is seen 
  -2) create editor in text using syntactic tree, with advice on parameters
  -3) create compiler text to XML
*/

// 1) recreate syntactic tree
//  typical xml: 
//  <parameter>
//     <subparamiter>value1</subparamiter>
//     <subparamiter2>value2</subparamiter2>
//  </parameter>
//  the task is to identify possible child types 
// (i.e. parameter->subparameter value types)
// and count frequencies
//  -- input  -> xml document -> flow of pairs 
//  -- output -> structure where they are stored

// how to store tokens names:
// set<string>
// when getting string from 
// 
#include <string>
#include <set>
#include <iostream>

using namespace std;

class pairdata {
  string *tagname;
  string *tagchild;
};

int main(int argc, char **argv)
{
  set<string> set1;
  // are string in set are same?
  for(int j=0;j<100;j++) {
  set1.insert(string("one") + string("two"));
  char * one = (char *)calloc(10,1); strcpy(one,"one");
  set1.insert(strcat(one,"three"));
  }

  for (auto &i:set1)
    std::cout << i << "\n";
}


