#include "Plant.h"

Plant::Plant (int age,double height) :age_(age),height_(height) {}

void Plant::print(ostream& os) const {
  os << "height: " << height_ << endl << "age: " << age_ << endl;
}


ostream& operator<<(ostream& os, const Plant& p) {
  p.print(os);
  return os;
}
