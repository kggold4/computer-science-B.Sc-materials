#include "Smartphone.h"

Smartphone Upgrade(Smartphone sp) {
  Smartphone newSP =  sp;
  newSP.SetFreq(sp.GetFreq()+0.1);
  return newSP;
}
int main() {

  Smartphone SP1("SAMSUNG",2,16,1.4);
  Smartphone SP2("Apple",4,32,1.3);
  
  Smartphone SP11 = Upgrade(SP1);
  if(SP1.GetFreq() > SP2.GetFreq())
    SP2=SP1;
  return 0;
  
}
