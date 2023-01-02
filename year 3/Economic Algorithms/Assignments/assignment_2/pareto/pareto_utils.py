from typing import List
from agent import Agent


def isParetoImprovement(agents: List[Agent], option1: int, option2: int) -> bool:
    """
    Check each agent in the given agents list: return true if the first option value is less than the second,
    else: return false

    ...

    Tests
    -----

    Option 1 is Pareto Improvement of option 2?
    >>> isParetoImprovement(test_agents, 0, 1)
    False

    Option 4 is Pareto Improvement of option 5?
    >>> isParetoImprovement(test_agents, 3, 4)
    False

    Option 3 is Pareto Improvement of option 2?
    >>> isParetoImprovement(test_agents, 2, 1)
    True

    """
    for agent in agents:
        if agent.value(option1) < agent.value(option2):
            return False
    return True


def isParetoOptimal(agents: List[Agent], option: int, allOptions: List[int]) -> bool:
    """
    For each option in allOptions that different from the given option check if is a pareto improvement,
    If it is, return false, else: return true

    ...

    Tests
    -----

    Option 1 is Pareto Optimal?
    >>> isParetoOptimal(test_agents, 0, test_options)
    True

    Option 2 is Pareto Optimal?
    >>> isParetoOptimal(test_agents, 1, test_options)
    False

    Option 3 is Pareto Optimal?
    >>> isParetoOptimal(test_agents, 2, test_options)
    True

    Option 4 is Pareto Optimal?
    >>> isParetoOptimal(test_agents, 3, test_options)
    True

    Option 5 is Pareto Optimal?
    >>> isParetoOptimal(test_agents, 4, test_options)
    True

    """
    for opt in allOptions:
        if opt != option and isParetoImprovement(agents, opt, option):
            return False
    return True


if __name__ == '__main__':
    # example
    agent_1 = Agent([1, 2, 3, 4, 5])
    agent_2 = Agent([3, 1, 2, 5, 4])
    agent_3 = Agent([3, 5, 5, 1, 1])
    test_agents = [agent_1, agent_2, agent_3]
    test_options = [0, 1, 2, 3, 4]
    import doctest

    (failures, tests) = doctest.testmod(report=True)
    print(f"{failures} failures, {tests} tests")
