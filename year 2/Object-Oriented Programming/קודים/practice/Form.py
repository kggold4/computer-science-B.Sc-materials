class Form:
    @staticmethod
    def formula(form: str, ev='') -> float:
        if form[0] == '(':
            return Form.formula(form[1:len(form) - 1], ev)
        elif form[0] == 'f':
            return Form.formula(form[2:len(form) - 1], ev+'1+')
        elif form[0] == 'g':
            return Form.formula(form[2:len(form) - 1], ev+'2*')
        else:
            final = ev+form
            print(final)
            return eval(final)

    @staticmethod
    def is_formula(form: str) -> bool:
        for i in range(len(form)):
            print(form[len(form) - 1 - i])
        return False


# f = x + 1
# g = x * 2
if __name__ == '__main__':
    a = "(f(g(10)))"
    b = "(g(((f((g((f(5)))))))))"
    print(Form.formula(a))
    print(Form.formula(b))
    # Form.is_formula(b)
