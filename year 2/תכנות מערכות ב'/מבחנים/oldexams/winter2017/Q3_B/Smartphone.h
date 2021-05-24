#ifndef _SMART_
#define _SMART_

class Smartphone {
 public:
  Smartphone(int,int,double,int);
  double GetFreq() const;
  void SetFreq(double);
  void print() const;
  bool isCheap() const;
 private:
  int RAM_;
  int Memory_;
  double Frequency_;
  const int price_;
};
#endif
