//#include<>
int * GetSomeIDs();
int * ReorderIDs(int *someIDs){
  int someID=someIDs[1];
  someIDs[1]=someIDs[2];
  someIDs[2]=someID;
};

int main(int argc, char ** argv) 
{
int  * someIDs, theFirst, *r;
someIDs = GetSomeIDs(); /* defined below */
theFirst = someIDs [0];
r= ReorderIDs(someIDs);
/* we want to use ‘theFirst’ and  ‘r’ here*/
 return 0;
}

/*-------- GetSomeIDs-----*/
int * GetSomeIDs()
{
   int  ids[8];
/* The ids are defined here */
   return  ids;
}

