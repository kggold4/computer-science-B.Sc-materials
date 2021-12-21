#include <iostream>
#include <cstring>

using namespace std;

class String {
public:
    String() = default;
    String(const char* string) {
        m_Size = strlen(string);
        m_Data = new char[m_Size];
        memcpy(m_Data, string, m_Size);
        cout << "created!\n" << endl;
    }
    // copy constructor
    String(const String& other) {
        m_Size = other.m_Size;
        m_Data = new char[m_Size];
        memcpy(m_Data, other.m_Data, m_Size);
        cout << "copied!\n" << endl;
    }
    // moving constructor
    String(String&& other) noexcept {
        m_Size = other.m_Size;
        m_Data = other.m_Data;
        cout << "moved!\n" << endl;
    }
    ~String() {
        delete m_Data;
        cout << "deleated!\n" << endl;
    }
    void print() {
        for(uint32_t i = 0; i < m_Size; i++){
            cout << m_Data[i];
        }
        cout << endl;
    }
private:
    char* m_Data;
    uint32_t m_Size;
};

class Entity {
public:
    Entity(const String& name)
        : n_Name(name) {} // make a copy of name
    void printName() {
        n_Name.print();
    }
    Entity(String && name) : n_Name(name) {}
private:
    String n_Name;
};


int main() {
    Entity en(String("KFIR"));
    en.printName();
    return 0;
}
