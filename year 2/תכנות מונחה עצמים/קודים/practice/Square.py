from practice.Shape import Shape


class Square(Shape):
    def __init__(self, size):
        self.size = size

    def print_shape(self) -> None:
        for i in range(self.size):
            for j in range(self.size):
                print('*', sep=' ', end=' ')
            print('')


if __name__ == '__main__':
    x = Square(10)
    x.print_shape()
