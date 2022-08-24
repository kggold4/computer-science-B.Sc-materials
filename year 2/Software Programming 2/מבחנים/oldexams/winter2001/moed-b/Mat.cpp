#include "mat.h"

Mat::Mat(const int& r_,
         const int& c_) : r(r_), c(c_) {
	data=new int[r*c];
}


Mat::Mat(const Mat& another) : r(another.r), c(another.c) {
	data=new int[r*c];
	*this=another;
}


Mat::~Mat() {
	delete[] data;
}


Mat&  Mat::operator=(const Mat& another) {
	if (this==&another)
		return *this;

	if (!same_size(another))
		throw Problem();

	for (int i=0; i<r*c; i++)
		data[i]=another.data[i];

	return *this;
}


Mat Mat::operator+(const Mat& M) {
	if (!same_size(M))
		throw Problem();

	Mat temp(r,c);

	for (int i=0; i<r*c; i++)
		temp.data[i]=data[i]+M.data[i];

	return temp;
}
		

Mat Mat::operator+(const int& x) {
	Mat temp(r,c);

	for (int i=0; i<r*c; i++)
		temp.data[i]=data[i]+x;

	return temp;
}


int& Mat::at(const int& r_,const int& c_) {
	if (r_<1 || r_>r || c_<1 || c_>c )
		throw Problem();

	return data[r_*c+c_-1];
}


const int& Mat::get_raws() const {
	return r;
}


const int& Mat::get_cols() const {
	return c;
}


bool Mat::same_size(const Mat& another) const {
	return (r==another.r && c==another.c);
}