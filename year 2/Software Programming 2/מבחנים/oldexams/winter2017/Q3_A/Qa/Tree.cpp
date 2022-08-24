#include "Tree.h"

Tree::Tree(int age,double height): Plant(age,height) {}

 void Tree::operator++(int x){
  age_++;
  height_+=1;
}
 void Tree::print(ostream& os) const{
  os << "Printing Tree" << endl;
  Plant::print(os);
}
