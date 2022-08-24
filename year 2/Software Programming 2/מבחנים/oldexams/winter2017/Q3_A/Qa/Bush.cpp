#include "Bush.h"

Bush::Bush(int age,double height): Plant(age,height) {}

 void Bush::operator++(int x){
  age_++;
  height_+=0.5;
}
 void Bush::print(ostream& os) const{
  os << "Printing Bush" << endl;
  Plant::print(os);
}
