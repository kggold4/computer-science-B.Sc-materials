from typing import List


class Agent:
    """
    A class used to represent an Agent

    ...

    Attributes
    ----------
    agent_values: float
        the list of agent values of options (indexes)

    Methods
    -------
    value(option)
        return the agent value of the given option

    """

    def __init__(self, agent_values: List[float]):
        """
        Agent constructor
        """
        self.agent_values = agent_values

    def value(self, option: int) -> float:
        """
        Input: the index of an option
        Output: the value of the option to the agent
        """
        return self.agent_values[option]
