#ifndef _SMART_
#define _SMART_

class Smartphone {
 public:
  Smartphone(const char*,int,int,double);
  Smartphone(const Smartphone&);
  ~Smartphone();
  Smartphone&  operator=(const Smartphone&);
  double GetFreq() const;
  void SetFreq(double);
 private:
  char* Company_;
  int RAM_;
  int Memory_;
  double Frequency_;
};

#endif
