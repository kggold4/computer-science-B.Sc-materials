#include "Smartphone.h"
#include <cstring>
#include <stdio.h>

char* createcopy(const char* src) {
  char * dst = new char[strlen(src)+1];
  strcpy(dst,src);
  return dst;
 
}

Smartphone::Smartphone(const char* Company, int RAM, int Memory, double Frequency):
  Company_(createcopy(Company)),RAM_(RAM),Memory_(Memory),Frequency_(Frequency) {}
Smartphone::Smartphone(const Smartphone& rhs): 
  Company_(createcopy(rhs.Company_)),RAM_(rhs.RAM_),Memory_(rhs.Memory_),Frequency_(rhs.Frequency_) {}
Smartphone::~Smartphone(){
  delete Company_;
}
Smartphone&  Smartphone::operator=(const Smartphone& rhs) {
  if (this != &rhs) {
    delete Company_;
    Company_ = createcopy(rhs.Company_);
    RAM_ = rhs.RAM_;
    Memory_ = rhs.Memory_;
    Frequency_ = rhs.Frequency_;
  }
  return *this;
}
double Smartphone::GetFreq() const{

  return Frequency_;
}
void Smartphone::SetFreq(double Frequency ){
  Frequency_ = Frequency;
}
