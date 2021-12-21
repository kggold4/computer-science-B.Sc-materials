#ifndef _PLANT_
#define _PLANT_

#include <iostream>

using namespace std;

class Plant {
 public:
  Plant (int,double);
  virtual void print(ostream&) const;
  virtual void operator++(int)=0;
 protected:
  int age_;
  double height_;
};


ostream& operator<<(ostream&,const Plant&);
#endif
