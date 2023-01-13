import copy
from typing import List
import numpy as np


def jefferson(num_of_sits: int, election: List[int]) -> List[int]:
    """
    Example:

    >>> jefferson(num_of_sits=5, election=[325, 135, 40])
    array([4, 1, 0])

    """
    division = np.zeros(len(election))
    election_values = copy.copy(election)
    while num_of_sits > 0:
        grater_value_index: int = election_values.index(max(election_values))
        division[grater_value_index] += 1
        election_values[grater_value_index] = election[grater_value_index] / (division[grater_value_index] + 1)
        num_of_sits -= 1
    results: List[int] = division.astype(int).__array__()
    return results


if __name__ == '__main__':
    import doctest

    (failures, tests) = doctest.testmod(report=True, optionflags=doctest.FAIL_FAST)
    print("{} failures, {} tests".format(failures, tests))
