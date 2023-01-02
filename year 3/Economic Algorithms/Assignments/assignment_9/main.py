from typing import List

import cvxpy


def nash_budget(total: float, subjects: List[str], preferences: List[List[str]]):
    """
    # Example

    >>> example_total=500
    >>> example_subjects=['A', 'B', 'C', 'D']
    >>> example_preferences=[['A', 'B'], ['A', 'C'], ['A', 'D'], ['B', 'C'], ['A']]
    >>> nash_budget(total=example_total, subjects=example_subjects, preferences=example_preferences)
    Total: 500
    370.156 for A
    64.922 for B
    64.922 for C
    0.000 for D
    Citizen 0 gives 85.078 to A and 14.922 to B
    Citizen 1 gives 85.078 to A and 14.922 to C
    Citizen 2 gives 100.000 to A and 0.000 to D
    Citizen 3 gives 50.000 to B and 50.000 to C
    Citizen 4 gives 100.000 to A
    """
    num_subjects = len(subjects)
    num_citizens = len(preferences)

    allocation = cvxpy.Variable(num_subjects)
    expediency = [None for _ in range(num_citizens)]

    # Calculating expediency of elements
    for element, person in enumerate(preferences):
        expediency_of_element = None
        for preference in person:
            if not expediency_of_element:
                expediency_of_element = allocation[subjects.index(preference)]
            else:
                expediency_of_element += allocation[subjects.index(preference)]
        expediency[element] = expediency_of_element

    # Calculate sum of logs
    sum_logs = 0
    for element in expediency:
        sum_logs += cvxpy.log(element)

    # Solve problem
    problem = cvxpy.Maximize(sum_logs)
    is_allocation_sum_equal_total = [sum(allocation) == total]
    is_all_allocations_grater_than_zero = [element and 0 <= element for element in allocation]
    constraints = is_allocation_sum_equal_total + is_all_allocations_grater_than_zero
    prob = cvxpy.Problem(problem, constraints=constraints)
    prob.solve()

    # Get the result string
    output = f"Total: {total}\n"
    for element, subject in enumerate(subjects):
        output += f"{allocation[element].value:.3f} for {subject}\n"
    contribution = total / num_citizens

    for citizen, player in enumerate(preferences):
        output += f"Citizen {citizen} gives "
        value: float = contribution / expediency[citizen].value if expediency[citizen] else 0
        for player_index in range(len(player)):
            contribute_value: float = value * allocation[subjects.index(player[player_index])].value
            if player_index != len(player) - 1:
                output += f"{contribute_value:.3f} to {player[player_index]} and "
            else:
                output += f"{contribute_value:.3f} to {player[player_index]}\n"
    print(output, end='')


if __name__ == '__main__':
    import doctest

    (failures, tests) = doctest.testmod(report=True, optionflags=doctest.FAIL_FAST)
    print("{} failures, {} tests".format(failures, tests))
