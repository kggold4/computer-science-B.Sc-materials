#ifndef VECTOR_H_
#define VECTOR_H_

#include <vector>
using namespace std;

class SafeVecException {

};

template<class T>
class SafeVec {
public:
	SafeVec() :	max_(0), pvector_(new vector<T>(max_)) {};
	SafeVec(unsigned max) : max_(max), pvector_(new vector<T>(max_)) {};
	T& operator[](unsigned int i);
	const T& operator[](unsigned int i) const;
	SafeVec& operator=(const SafeVec& rhs);
	SafeVec(const SafeVec& rhs) : max_(rhs.max_), pvector_(new vector<T>(*rhs.pvector_)) {};
	~SafeVec();

	class SafeIterator {
	public:
		SafeIterator(typename vector<T>::iterator val) : iter_(val) {};
		SafeIterator& operator++() {
			 iter_++;
			return *this;
		}
		T& operator*() {
			return *iter_;
		}
		bool operator!=(const SafeIterator& rhs) {
			return iter_ != rhs.iter_;
		}

	private:
		typename vector<T>::iterator iter_;
	};

	SafeVec::SafeIterator begin() {
		return SafeIterator((*pvector_).begin());
	}
	SafeVec::SafeIterator end() {
		return SafeIterator((*pvector_).end());
	}

private:
	unsigned int max_;
	vector<T>* pvector_;
};

template<class T>
T& SafeVec<T>::operator[](unsigned int i) {
	if (i >= max_) {
		SafeVecException e;
		throw e;
	}
	return (*pvector_)[i];
}

template<class T>
const T& SafeVec<T>::operator[](unsigned int i) const {
	if (i >= max_) {
		SafeVecException e;
		throw e;
	}
	return (*pvector_)[i];
}

template<class T>
SafeVec<T>& SafeVec<T>::operator=(const SafeVec<T>& rhs) {
	if (this != &rhs) {
		max_ = rhs.max_;
		delete pvector_;
		pvector_ = new vector<T>(rhs.max_);
	}
	return *this;
}

template<class T>
SafeVec<T>::~SafeVec() {
	delete pvector_;
}

#endif /* VECTOR_H_ */
