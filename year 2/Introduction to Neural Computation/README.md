# Introduction to Neural Computation Course Materials

> Architectures and Algorithms:

### <i>The perceptron: </i>

Algorithm:

```
1. initialize weights to be 0 and set the bias to be "on" (value=1) with wight of -threshold
2. while there is no stop condition:
    2.1. for each input train vector x = (x_1, ..., x_n) we get the wanted result t:
    2.2. insert vector to perceptron inputes
    2.3. calculate:
         y_in = bias + SUM(i) { x_i * w_i }
         y_i = {
                1 if y_in > threshold,
                0 if y_in = threshold,
               -1 if y_in < threshold
                }
         2.3.1. check if y_i = t
             2.3.2.1. update weights by:
                      w_i(new) = w_i(old) + xi * t
             2.3.2.2. update bias by:
                      bias(new) = bias(old) + t
        2.3.2. if there is no changes in steps 2.2.2.1 and 2.2.2.2, stop
```

### <i>Discrete Hop-field net</i>

Algorithm:

```
1. initialize the matrix W (size n*n) by:
    for each w (weight) and p (train vector):
        1.1. W_ji = Sigma(p) { (2*s_i(p) - 1) * (2*t_i(p) - 1) } (for each i != j)
        1.2. W_ii = 0
2. while there is no stop codition, execute:
    2.1. for each input x_i:
         2.1.1. define activition as y_i = t_i
         2.1.2. claculate:
                y_in = x_i + SUM(j) { w_ji * y_i }
         2.1.3. define the activiation function:
                y_i = {
                        1 if y_in > threshold
                        y_in if y_in = threshold
                        0 if y_in < threshold
                        }
         2.1.4. sent y_i as an input for all others neurons
3. check if there is a converge
```

### <i>Bam net:</i>

Algorithm:

```
Introduction:
Bam net is a neural network with two layers Y and X when the number of neurons in layer Y is n and for X is m.

1. initialize the matrix W (size n*n) by:
    W_ji = Sigma(p) { (2*si(p) - 1) * (2*ti(p) - 1) } (for each i != j)
    W_ii = 0
2. for each train in vector x = (x_1, ..., x_n):
    2.1. initialize layer Y as input vector with the right size
    2.2. initialize layer X as input vector with the right size
    2.3. while the function doe's not converge yet, execute:
         2.3.1. update the activation function of layer X to be:
                y_in = SUM(i) { x_i * w_ji }
                y_i = f(y_in)
                send y_i as an input to layer X 
         2.3.2. update the activation function of layer Y to be:
                x_in = SUM(i) { y_i * wji }
                x_i = f(x_in)
         2.3.3. check convergation and if the weights vectors of Y and X layers as been balanced
```