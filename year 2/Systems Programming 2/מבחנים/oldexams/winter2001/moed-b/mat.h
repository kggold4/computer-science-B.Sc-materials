#ifndef __MAT_H__
#define __MAT_H__

struct Problem {
};

class Mat {
public:
	Mat(const int&, const int&);
	Mat(const Mat&);	
	~Mat();

	Mat& operator=(const Mat&);
	Mat  operator+(const Mat&);
	Mat  operator+(const int&);

	int& at(const int&,const int&);

	const int& get_raws() const;
	const int& get_cols() const;

private:
	int* data;
	const int r,c;

	bool same_size(const Mat&) const;
};

#endif