

1.
  
  The best way to make the object implement these funcs is
  to make them inherit from an abstract class which declares these
  functions:

class IUnknown
{
public:
	IUknown(): m_iRefCount(0) {}
	virtual void AddRef() = NULL;
	virtual void Release() = NULL;

	~IUnknown() {};

protected
    int m_iRefCount;
};


2.


class CStrManip : public IUnknown
{
public:
	void AddRef() { ++m_iRefCount;}
	void Release() {--m_iRefCount; if (!m_iRefCount) delete this; }
    RESULT Reverse(char* str);
    RESULT ToUpper(char* str);
};


3.

I. The problem will arise in the other client programs: segmentatiom fault.
II. We can move the IUnknown d'tor to the private part of IUnknown.




4.
//
// Auto-pointer class
//

template <class T>
class CAMP
{
public:
    // C'tors / D'tors
    CAMP(T* p = NULL) : m_p(p)  { if (m_p) m_p->AddRef(); }
    CAMP(const CAMP<T>& r) : m_p(r.m_p)  { if (m_p) m_p->AddRef(); }
    ~CAMP()                     { if (m_p) m_p->Release(); }

    // Operators
    T* operator->()             { return m_p; }
    CAMP& operator=(const CAMP<T>& r)    
								{
                                    if (this != &r)
                                    {
                                        if (m_p) m_p->Release();
                                        m_p = r.m_p;
                                        if (m_p) m_p->AddRef();
                                    }
                                    return *this;
                                }
	bool operator!=(const CAMP<T>& r) {return m_p != r.m_p;}

private:
    T* m_p;
};



6. 

Danny is wrong.
Exception might create memory leaks when NOT using CAMP.