from contextlib import suppress
from typing import List
import networkx as nx
import numpy as np


def find_cycle_in_consumption_graph(allocation: List[List[float]]) -> bool:
    """
    >>> find_cycle_in_consumption_graph([[0.01, 0.0, 0.0], [0.9, 0.0, 1.0], [0.0, 0.7, 0.0]])
    False

    >>> find_cycle_in_consumption_graph([[0.35, 0.3, 0.0], [0.65, 0.7, 1.0], [0.0, 0.0, 1.0]])
    [(0, 3, 'forward'), (1, 3, 'reverse'), (1, 4, 'forward'), (0, 4, 'reverse')]
    True

    """
    # bilateral graph
    graph = nx.DiGraph()
    num_of_players = len(allocation)
    num_of_objects = len(np.transpose(allocation))

    # adding nodes of players objects (each has a side)
    graph.add_nodes_from(np.arange(num_of_objects + num_of_players))

    for plr in range(num_of_players):
        for obj in range(num_of_objects):
            # there is an edge from player to object
            # check if player get more than 0.0 of object
            if allocation[plr][obj] > 0:
                graph.add_edge(plr, num_of_players + obj)

    # checking if there exists a cycle
    with suppress(nx.NetworkXNoCycle):
        print(list(nx.find_cycle(graph, orientation="ignore")))
        return True
    return False


if __name__ == '__main__':
    import doctest

    (failures, tests) = doctest.testmod(report=True, optionflags=doctest.FAIL_FAST)
    print("{} failures, {} tests".format(failures, tests))
