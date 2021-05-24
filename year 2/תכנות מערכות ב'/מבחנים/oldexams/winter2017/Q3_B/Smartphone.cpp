#include "Smartphone.h"
#include <cstring>
#include <stdio.h>
#include <iostream>

using namespace std;


Smartphone::Smartphone( int RAM, int Memory, double Frequency, int price):
  RAM_(RAM),Memory_(Memory),Frequency_(Frequency),price_(price) {}

double Smartphone::GetFreq() const{

  return Frequency_;
}
void Smartphone::SetFreq(double Frequency ){
  Frequency_ = Frequency;
}


void Smartphone::print() const {
  cout<<"RAM: " << RAM_ << ", Memory: " << Memory_ << ", Frequency: "<< Frequency_ << " Price: "<< price_ <<endl;
}
bool Smartphone::isCheap() const{
  return (price_ < 1000);
}
