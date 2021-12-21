#include "Flower.h"

Flower::Flower(int age,double height): Plant(age,height) {}

 void Flower::operator++(int x){
  age_++;
  height_+=0.1;
 }
 void Flower::print(ostream& os) const{
  os << "Printing Flower" << endl;
  Plant::print(os);
}
