import math


class Point2D:

    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.childes = []
        self.weight = {}
        self.index = 0

    def __cmp__(self, other):
        if self.x is other.x:
            return 0
        elif self.x > other.x:
            return 1
        else:
            return -1

    def __iter__(self):
        return self.weight.__iter__()

    def dist(self, other) -> float:
        return math.sqrt(math.pow(self.x - other.x) + math.pow(self.y - other.y))

    def add(self, item):
        self.weight[self.index] = item
        self.index += 1


if __name__ == '__main__':
    p = Point2D(5, 6)
    p.add(1)
    p.add(2)
    p.add(5)
    p.add(6)
    p.add(3)
    for i in p:
        print(i)
