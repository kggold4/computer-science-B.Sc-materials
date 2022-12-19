from typing import List, Tuple
import numpy as np


def maximum_assignment(values: List[List[int]]) -> List[Tuple[int, int]]:
    """
    Same examples as section a and b:

    >>> maximum_assignment([[10, 5, 8], [9, 8, 7], [7, 10, 5]])
    [(0, 0), (1, 2), (2, 1)]

    >>> maximum_assignment([[10, 5], [9, 8]])
    [(0, 0), (1, 1)]

    """
    # assume n agents and n objects (len(agents) == len(objects))
    n = len(values)
    if n > 0:
        assert n == len(values[0])

    # Calculate marginal values for each agent and object pair
    marginals = []
    for agent in range(n):
        inner_marginals = []
        for obj in range(n):
            max_marginal_value = -1
            for value in range(n):
                if value != obj and max_marginal_value < values[agent][value]:
                    max_marginal_value = values[agent][value]
            marginal_value = values[agent][obj] - max_marginal_value
            inner_marginals.append(marginal_value)
        marginals.append(inner_marginals)

    # assign each marginal to agent in dict
    assignments = []
    new_marginals = {}
    for agent, marginal in zip(np.arange(n), marginals):
        new_marginals[agent] = marginal

    # Sort agents by maximum values of their marginals
    marginals = sorted(marginals, key=max, reverse=True)
    agents_to_iterate = []
    for marginal in marginals:
        agent_index = list(new_marginals.values()).index(marginal)
        agents_to_iterate.append(agent_index)

    # For each agent in maximum marginals sorted take the free max value object
    taken_objects = []
    for agent in agents_to_iterate:
        max_object_value = -np.inf
        max_value = -1
        for obj in range(n):
            if obj not in taken_objects and values[agent][obj] > max_object_value:
                max_object_value = values[agent][obj]
                max_value = obj
        taken_objects.append(max_value)
        assignments.append((agent, max_value))

    return sorted(assignments, key=lambda x: x[0])


if __name__ == '__main__':
    import doctest

    (failures, tests) = doctest.testmod(report=True, optionflags=doctest.FAIL_FAST)
    print("{} failures, {} tests".format(failures, tests))
