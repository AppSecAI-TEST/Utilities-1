#include <iostream>
#include <mutex>
#include <thread>
//#include <atomic>
#include <chrono>
#include <cassert>
#include <vector>
#include <string>

//  k dining filosophers
//  /o|o|o|o\
// o <=====> o
//  \o|o|o|o/
// every o need two 
//   no deadlocks
//   no hangry (dead phylosopher)
//  // eats or thinks
// different life
// different speed of resource using 
// (variation - different in time)
//   
// how to resolve conflict? 
// more hangriest -> gets forks

// compare state machine and | state machine
// with mentor/without etc

using namespace std::literals;

class Philosophier;

std::mutex mutexc;
void out(const std::string & out){
   mutexc.lock();
   std::cout << out << std::endl;
   mutexc.unlock();
}

class Table 
{
  private:
  std::mutex forks_mutex;
  std::vector<bool> forks;
  int sz;
  //std::vector<Philosophier> phils;
  public:
  Table(int k=2){
    sz=k;
    for(int i=0;i<k;i++)
    {
      bool fork=true;;
    //  forks.push_back(std::move(phil));
      forks.push_back(std::move(fork));
    //  std::thread(phils[k].start, 55, 6, 5, this);
    }   
  };

  bool drop_forks(int i){
    forks[i]=true;  
    forks[(i+sz-1)%sz]=true;
    return true;
  }
 
  bool try_take_forks(int i){
    assert(i<sz && i>=0);
    bool retval=false;
    forks_mutex.lock();
    if(forks[i] && forks[(i+sz-1)%sz]){
      forks[i]=false;
      forks[(i+sz-1)%sz]=false;
      retval=true;
    } else {
      retval=false;}
       
    forks_mutex.unlock();
    return retval;
  };
};

// collects requests, and even pushes to drop
class ReqManager;

class Philosophier
{
 private:
    Table * table; 
    ReqManager * manager;
 // if > 100 end eating
 // if < 50 want eating
    int lifePoints;
    int diningSpeed;
    int thinkingSpeed;
    bool has_forks;
    const int k;
    friend class ReqManager; 
public:
    
    std::mutex state_mutex;
     
    Philosophier(int num):k(num),lifePoints(0) {
    
    }

    void start(int lp, int ds, int ths, Table * tab){
      lifePoints=lp;
      diningSpeed=ds;
      thinkingSpeed=ths;
      table=tab;
      while(1){
        std::this_thread::sleep_for(1s);
        processCycle();
      }
    };
    
    void processCycle();
};

void start(Philosophier *phil,int lp, int ds, int ths, Table * tab){
  phil->start(lp,ds,ths,tab);
}

class ReqManager
{
  const std::vector< Philosophier *> * philBodies;  
public:
  ReqManager(std::vector<Philosophier *> * phils): philBodies(phils) {
    for(auto phil: *phils)
      phil->manager=this;
  }  
  void wantBusyFork(int i){
    std::mutex texmut;
    texmut.lock();
    // comment below to allow hangry die
    const int sz = philBodies->size(); 

    if(philBodies->at((i+sz-1)%sz)->lifePoints>50 
      && philBodies->at((i+1)%sz)->lifePoints>50){
        out(std::string("manager drops neighbors for:") + 
        std::to_string(i));
        philBodies->at(0)->table->drop_forks((i+sz-1)%sz); 
        philBodies->at(0)->table->drop_forks((i+1)%sz);
    }
    texmut.unlock(); 
  };

  // startManager();
};

void Philosophier::processCycle(){
      state_mutex.lock();// <--
      if(lifePoints<0){
        out(std::string("") + std::to_string(k) + "th is dead");    
        state_mutex.unlock();
        return;}
      if(has_forks) {lifePoints+=diningSpeed;
        out(std::string("")+ std::to_string(k) + "th is eating:" + 
        std::to_string(lifePoints));}
      else {lifePoints-=thinkingSpeed;
        out(std::string("")+std::to_string(k)+"th is thinking:"+std::to_string(lifePoints));}
      if(has_forks && lifePoints>=100)
        has_forks=!table->drop_forks(k);
      else if(lifePoints<50 && !has_forks){
	     has_forks=table->try_take_forks(k);
             if(!has_forks)
               manager->wantBusyFork(k); 
           }
      state_mutex.unlock();
}; 

int main()
{
// manager gives    
    std::vector< std::thread > phils(10); 
    std::vector< Philosophier *> phils_bodies(10);//{10,10,10,10,10,10,10,10,10,10};
    Table table(10);

    for(int i=0;i<10;i++)
    {
      phils_bodies[i] = new Philosophier(i);
    }
 
    ReqManager manager(&phils_bodies);
 
    for(int i=0;i<10;i++)
    {
      phils[i]=std::thread(&start, phils_bodies[i], 55, 20, 12, &table);
      //std::move(phil));
    }

    for(int i=0;i<10;i++)
    {
      phils[i].join();
    }

}

