#include <vector>
#include <algorithm>
#include "Smartphone.h"
#include <map>
#include <iostream>      
#include <stdexcept>    

using namespace std;
void print_if_cheap(Smartphone* sp) {
  if (sp->isCheap()){
    cout<< "Cheap smartphone: " ;
    sp->print();
  }
}
class compareSP {
public:
  bool operator()(Smartphone* a, Smartphone* b) {
    return a->GetFreq() < b->GetFreq() ;
  }
};
int main() {
  map<const char*,Smartphone*> ShopMap;
  
  ShopMap["af54bx63"] = new  Smartphone(2,16,1.3,780);
  ShopMap["fd78op34"] = new  Smartphone(4,32,1.4,1050);
  ShopMap["ee11rr22"] = new  Smartphone(4,16,1.5,1400);
  
  try {
    (ShopMap.at("af54bx63"))->SetFreq(1.6);
    (ShopMap.at("xx99xx99"))->SetFreq(2.0);
  }
  catch(out_of_range e){
    cerr<< "Erorr out of range " << e.what() <<endl;
  }
  
  vector<Smartphone*> ShopVec;
  map<const char*,Smartphone*>::iterator it;
  for ( it = ShopMap.begin(); it != ShopMap.end(); ++it) {
    ShopVec.push_back((it->second));
  }
  for(int i=0; i<ShopVec.size() ; i++) 
    ShopVec[i]->print();
  compareSP cSP;
  sort(ShopVec.begin(),ShopVec.end(),cSP);
  for(int i=0; i<ShopVec.size() ; i++) 
    ShopVec[i]->print();
  for_each(ShopVec.begin(),ShopVec.end(),print_if_cheap);

  
}
