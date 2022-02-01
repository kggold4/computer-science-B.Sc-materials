# Algorithms in Artificial Intelligence Course Study Materials

* find the final project of the course in: https://github.com/kggold4/algorithms-in-ai-final-project-bayesian-network.git

## Main algorithms:

### <i>BackWardInduction:<i>

```
* Z - all leaf nodes
* u - util function

function BackWardInduction (node h) returns u(h)
if h in Z:
	return u(h)
best_util = -inf
forall a in X(h):
	util_at_child = BackWardInduction(s(h,a))
	if util_at_child > best_util:
		best_util = util_at_child 
return best_util
```
