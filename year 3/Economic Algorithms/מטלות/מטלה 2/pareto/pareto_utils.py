from typing import List
from agent import Agent
import numpy as np


def isParetoImprovement(agents: List[Agent], option1: int, option2: int) -> bool:
    """
    Check each agent in the given agents list: return true if the first option value is less than the second
    else: return false
    """
    answer = True
    for agent_index in range(len(agents)):
        if agents[agent_index].value(option1) < agents[agent_index].value(option2):
            answer = False
            break
    return answer


def isParetoOptimal(agents: List[Agent], option: int, allOptions: List[int]) -> bool:
    # temp matrix that receive values of 0 and 1 and with its help
    # we will check whether the current option is Pareto Optimal
    check_matrix = np.ones((len(agents), len(allOptions)))
    for i in range(len(allOptions)):
        for j in range(len(agents)):
            if i != option:
                if agents[j].value(option) <= agents[j].value(allOptions[i]):
                    check_matrix[j][i] = 0

    # Go over the whole temp matrix: if there is one column that is all with zeros - that means this option is Pareto Optimal,
    # Otherwise - if there is no column full of zeros - necessarily this option is Pareto Optimal
    for j in range(len(check_matrix[0])):
        for i in range(len(check_matrix)):
            if j != option:
                if check_matrix[i][j] == 1:
                    break
                if i == len(check_matrix) - 1 and check_matrix[i][j] == 0:
                    return False
    return True
