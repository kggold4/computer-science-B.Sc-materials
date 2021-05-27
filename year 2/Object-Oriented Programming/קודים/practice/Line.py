from practice.Shape import Shape


class Line(Shape):
    def __init__(self, size):
        self.size = size

    def print_shape(self) -> None:
        for i in range(self.size):
            print('* ', end='')


if __name__ == '__main__':
    x = Line(10)
    x.print_shape()
