from itertools import permutations
from typing import List
import numpy as np


def find_trading_cycle(preferences: List[List[int]]) -> List[int]:
    """
    Question 1 a

    # case when each preference in preferences is different
    >>> num_of_sets = np.random.randint(1, 10)
    >>> find_trading_cycle([permutation for permutation in permutations(np.arange(num_of_sets), num_of_sets)])
    [0, 0]

    >>> find_trading_cycle([[1, 2, 0], [0, 1, 2], [0, 2, 1]])
    [0, 1, 0]

    >>> find_trading_cycle([[3, 1, 2, 0], [2, 3, 0, 1], [2, 0, 3, 1], [1, 0, 3, 2]])
    [2, 2]

    >>> find_trading_cycle([[2, 1, 0, 3], [2, 0, 1, 3], [3, 0, 2, 1], [0, 3, 2, 1]])
    [0, 2, 3, 0]

    >>> find_trading_cycle([[3, 0, 2, 1], [2, 1, 0, 3], [0, 1, 2, 3], [2, 1, 3, 0]])
    [0, 3, 2, 0]

    >>> find_trading_cycle([[4, 3, 0, 2, 1], [4, 3, 1, 0, 2], [0, 3, 4, 2, 1], [4, 1, 2, 0, 3], [2, 4, 3, 0, 1]])
    [0, 4, 2, 0]

    >>> find_trading_cycle([[1, 2, 0, 3, 4], [2, 3, 0, 4, 1], [4, 1, 0, 3, 2], [3, 1, 0, 4, 2], [1, 3, 4, 2, 0]])
    [1, 2, 4, 1]

    >>> find_trading_cycle([[3, 0, 1, 2, 4], [0, 4, 1, 2, 3], [0, 2, 1, 3, 4], [0, 1, 4, 3, 2], [0, 1, 3, 4, 2]])
    [0, 3, 0]

    """

    # find the trading cycle in recursive function
    trading_cycle = []
    trading_cycle = _find_trading_cycle_recursive(index=0, trading_cycle=trading_cycle, preferences=preferences)
    return trading_cycle


def _find_trading_cycle_recursive(index: int, trading_cycle: List[int], preferences: List[List[int]]) -> List[int]:
    """
    Recursive function to find the trading cycle
    """
    # stopping condition
    if index in trading_cycle:
        trading_cycle.append(index)
        return trading_cycle[trading_cycle.index(index):]

    # move to next iteration
    trading_cycle.append(index)
    index = preferences[index][0]
    return _find_trading_cycle_recursive(index=index, trading_cycle=trading_cycle, preferences=preferences)


def trade_cycle_algorithm(preferences: List[List[int]]) -> dict:
    """
    Question 1 b

    >>> trade_cycle_algorithm([[1, 2, 0], [0, 2, 1], [2, 0, 1]])
    {0: 1, 1: 0, 2: 2}

    >>> trade_cycle_algorithm([[0, 2, 1], [2, 1, 0], [1, 0, 2]])
    {0: 0, 2: 1, 1: 2}

    >>> trade_cycle_algorithm([[3, 2, 1, 0], [0, 1, 3, 2], [3, 2, 1, 0], [3, 1, 0, 2]])
    {3: 3, 2: 2, 0: 1, 1: 0}

    >>> trade_cycle_algorithm([[3, 2, 0, 1], [2, 1, 3, 0], [1, 2, 3, 0], [0, 2, 3, 1]])
    {0: 3, 3: 0, 2: 1, 1: 2}

    >>> trade_cycle_algorithm([[0, 1, 2, 3, 4], [2, 3, 0, 1, 4], [0, 2, 3, 4, 1], [2, 4, 3, 0, 1], [4, 0, 1, 3, 2]])
    {0: 0, 2: 2, 4: 4, 3: 3, 1: 1}

    >>> trade_cycle_algorithm([[4, 0, 1, 2, 3], [1, 0, 3, 2, 4], [3, 2, 1, 0, 4], [4, 3, 1, 0, 2], [4, 3, 2, 1, 0]])
    {4: 4, 0: 0, 1: 1, 3: 3, 2: 2}

    """
    players = []
    strong_trading_cycle = dict()
    while len(preferences) > len(players):

        # using find_trading_cycle function
        cycle = find_trading_cycle(preferences)
        for index, player in enumerate(cycle):

            # skip last
            if index == len(cycle) - 1:
                break

            # update strong_trading_cycle and players
            strong_trading_cycle[player] = cycle[index + 1]
            players.append(player)

        # update the preference by deleting the unwanted cycle indexes in the cycle without the last
        [preference.remove(cycle_index) for preference in preferences for cycle_index in cycle[:-1]]
    return strong_trading_cycle


if __name__ == '__main__':
    import doctest

    (failures, tests) = doctest.testmod(report=True, optionflags=doctest.FAIL_FAST)
    print("{} failures, {} tests".format(failures, tests))
