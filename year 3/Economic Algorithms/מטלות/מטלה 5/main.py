from typing import List
import numpy as np

ARRAY_1 = [
    [1, 1, 0.07, 0],
    [0, 0, 0.93, 1]
]
ARRAY_2 = [
    [1, 0],
    [0, 1]
]

ARRAY_3 = [
    [1, 0, 0.4],
    [0, 0, 0],
    [0, 0.5, 0.3],
    [0, 0.5, 0.3]
]


def sum_of_shared_agent_of_item(item: List[int]) -> int:
    # TODO: add here doctests cases
    return len([item_division for item_division in item if item_division != 0])


def isConsumptionGraphHasCircle(graph_matrix: np.array) -> bool:
    """
    For each item check if the item is shared between more than two agents, if it is - return false, else - True
    The input array is a 2D matrix when row indexes represents the agents,
    and column indexes represents the part in percentage they get from the item.

    >>> isConsumptionGraphHasCircle(np.array(ARRAY_1))
    True

    >>> isConsumptionGraphHasCircle(np.array(ARRAY_2))
    True

    >>> isConsumptionGraphHasCircle(np.array(ARRAY_3))
    False

    """
    for item in graph_matrix.transpose():
        if sum_of_shared_agent_of_item(item) > 2:
            return False
    return True


if __name__ == '__main__':
    import doctest

    (failures, tests) = doctest.testmod(report=True, optionflags=doctest.FAIL_FAST)
    print("{} failures, {} tests".format(failures, tests))
