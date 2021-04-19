from practice.Shape import Shape


class Triangle(Shape):

    def __init__(self, size: int):
        self.size = size

    def print_shape(self) -> None:
        for i in range(self.size):
            for j in range(i):
                print('*', sep=' ', end=' ')
            print('')


if __name__ == '__main__':
    x = Triangle(10)
    x.print_shape()
