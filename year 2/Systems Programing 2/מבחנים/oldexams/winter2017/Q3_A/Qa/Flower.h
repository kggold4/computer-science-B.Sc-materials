#ifndef _FLOWER_
#define _FLOWER_
#include "Plant.h"

class Flower : public Plant {
 public:
  Flower(int=0,double=0);
  virtual void operator++(int);
  virtual void print(ostream&) const;
};

#endif
