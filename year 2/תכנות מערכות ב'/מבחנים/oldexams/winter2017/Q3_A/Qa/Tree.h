#ifndef _TREE_
#define _TREE_
#include "Plant.h"

class Tree : public Plant {
 public:
  Tree(int=1,double=1);
  virtual void operator++(int);
  virtual void print(ostream&) const;
};

#endif
