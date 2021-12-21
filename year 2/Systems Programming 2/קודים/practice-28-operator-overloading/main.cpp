#include <iostream>
using namespace std;

struct Vector2 {
    float x, y;

    Vector2(float x, float y)
        : x(x), y(y) {}
    
    /* regular add and multiply methods */
    Vector2 add(const Vector2& other) const {
        return Vector2(x + other.x, y + other.y);
    }

    Vector2 multiply(const Vector2& other) const {
        return Vector2(x * other.x, y * other.y);
    }
    /* ******************************** */

    /* operator based method */

    Vector2 operator+(const Vector2& other) const {
        return add(other);
    }

    Vector2 operator*(const Vector2& other) const {
        return multiply(other);
    }

    bool operator==(const Vector2& other) const {
        return x == other.x && y == other.y;
    }

    bool operator!=(const Vector2& other) const {
        return !(*this == other);
    }

    /* ******************************** */
};

ostream& operator<<(ostream& stream, const Vector2& other) {
    stream << other.x << ", " << other.y;
    return stream;
}

int main() {

    Vector2 position(4.0f, 4.0f);
    Vector2 speed(0.5f, 1.5f);
    Vector2 powerup(1.1f, 1.1f);

    Vector2 result1 = position.add(speed.multiply(powerup));
    Vector2 result2 = position + speed * powerup;

    cout << result1 << endl;
    cout << result2 << endl;
    bool eq = (result1 == result2);
    cout << eq << endl;

    cin.get();
    return 0;
}
