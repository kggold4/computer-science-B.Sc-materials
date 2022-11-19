from typing import Tuple, List
import numpy as np
import itertools


class Node:
    def __init__(self, values: Tuple):
        self.values = values


class ItemAllocationTwoPlayersGraph:
    def __init__(self, values_matrix: List[Tuple]):
        for values in values_matrix:
            x: Tuple = values

    def bfs(self):
        pass


if __name__ == '__main__':
    # items_matrix = [(11, 22), (11, 44)]
    # # x = np.choose(items_matrix)
    # x = [i for i in itertools.combinations(items_matrix, 2)]
    # print(x)
    # item_allocation_two_players_graph = ItemAllocationTwoPlayersGraph(items_matrix)

    items_matrix = [[11, 11, 55, 0], [22, 22, 33, 0], [33, 44, 0, 0]]
    all_combinations = [itertools.combinations(x, len(items_matrix)) for x in items_matrix]
    print([[i for i in x] for x in all_combinations])
    # for i, j, k in zip():
    #     print(i, j, k)
    #
    # for items in items_matrix:
    #     items.append(0)
    #     x = [i for i in itertools.combinations(items, 2)]
    #     print(f"X = '{x}'\n\n\n")
