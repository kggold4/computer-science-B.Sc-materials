#ifndef _BUSH_
#define _BUSH_
#include "Plant.h"

class Bush : public Plant {
 public:
  Bush(int=1,double=0.5);
  virtual void operator++(int);
  virtual void print(ostream&) const;
};

#endif
