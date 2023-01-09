import statistics


def compute_budget(total_budget: float, citizen_votes: list[list]) -> list[float]:
    """
    Question 5 a

    >>> compute_budget(100, [[100, 0, 0], [0, 0, 100]])
    [50.0, 0, 50.0]

    >>> compute_budget(100, [[0, 0, 100], [100, 0, 0]])
    [50.0, 0, 50.0]

    >>> compute_budget(1000, [[250, 500, 750], [750, 500, 250]])
    [250, 500, 250]

    >>> compute_budget(3, [[1, 2], [0, 3]])
    [1, 2]

    >>> compute_budget(250, [[50, 100, 0, 100], [100, 0, 100, 50]])
    [62.5, 62.5, 62.5, 62.5]

    >>> compute_budget(25, [[5, 8, 0, 12], [12, 0, 8, 5]])
    [6.25, 6.25, 6.25, 6.25]

    >>> compute_budget(24, [[10, 6, 8], [6, 8, 10]])
    [8.0, 8.0, 8]

    >>> compute_budget(10, [[5, 3, 2], [2, 5, 3]])
    [3.5, 3.5, 3]

    >>> compute_budget(3/4, [[1/4, 1/2, 0, 0], [0, 1/4, 1/2, 0]])
    [0.25, 0.25, 0.25, 0]
    """
    return binary_search(low=0, high=1, citizen_votes=citizen_votes, total_budget=total_budget)


def binary_search(low, high, citizen_votes: list[list], total_budget: float):
    if high >= low:
        mid = (high + low) / 2
        medians = []
        for citizen_vote in range(len(citizen_votes[0])):
            arr_median = []
            current_medians = []
            for citizen_vote_index in range(1, len(citizen_votes)):
                current_medians.append(total_budget * min(1, citizen_vote_index * mid))
            arr_median += current_medians
            inner_medians = []
            for current_vote in citizen_votes:
                inner_medians.append(current_vote[citizen_vote])
            arr_median += inner_medians
            medians.append(statistics.median(arr_median))

        sum_medians = sum(medians)

        # Recursively binary search
        if sum_medians > total_budget:
            return binary_search(low=low, high=mid, citizen_votes=citizen_votes, total_budget=total_budget)
        elif sum_medians < total_budget:
            return binary_search(low=mid, high=high, citizen_votes=citizen_votes, total_budget=total_budget)
        else:
            return medians
    return -1


def check_fairness(total_budget: float, citizen_votes: list[list[float]], budget: list[float]) -> bool:
    """
    Question 5 b

    >>> citizen_votes = [[100, 0, 0], [0, 0, 100], [100, 0, 0], [0, 0, 100], [100, 0, 0], [0, 0, 100], [100, 0, 0], [0, 0, 100], [100, 0, 0], [0, 0, 100]]
    >>> budget = compute_budget(100, citizen_votes)
    >>> check_fairness(100, citizen_votes, budget)
    True

    >>> citizen_votes2 = [[50, 50, 0], [0, 50, 50]]
    >>> budget2 = compute_budget(100, citizen_votes2)
    >>> check_fairness(100, citizen_votes2, budget2)
    False

    >>> citizen_votes2 = [[7, 8], [9, 7]]
    >>> budget2 = compute_budget(16, citizen_votes2)
    >>> check_fairness(16, citizen_votes2, budget2)
    False

    >>> citizen_votes2 = [[3, 0, 0, 3], [0, 3, 3, 0]]
    >>> budget2 = compute_budget(6, citizen_votes2)
    >>> check_fairness(6, citizen_votes2, budget2)
    False

    >>> citizen_votes = [[3, 0, 0], [0, 0, 3], [3, 0, 0], [0, 0, 3], [3, 0, 0], [0, 0, 3], [3, 0, 0], [0, 0, 3], [3, 0, 0], [0, 0, 3]]
    >>> budget = compute_budget(3, citizen_votes)
    >>> check_fairness(3, citizen_votes, budget)
    True

    >>> citizen_votes = [[1,0], [1,0], [1,0], [1,0], [1,0], [1,0], [1,0], [1,0], [1,0], [1,0], [1,0], [1,0], [1,0]]
    >>> budget = compute_budget(1, citizen_votes)
    >>> check_fairness(1, citizen_votes, budget)
    True

    >>> citizen_votes = [[1, 1, 1, 0], [1, 1, 0, 1], [1, 0, 1, 1], [0, 1, 1, 1]]
    >>> budget = compute_budget(3, citizen_votes)
    >>> check_fairness(3, citizen_votes, budget)
    False

    >>> citizen_votes = [[2,4,2,4,2,4], [0,0,0,0,0,20]]
    >>> budget = compute_budget(18, citizen_votes)
    >>> check_fairness(18, citizen_votes, budget)
    False

    """
    length_items = len(citizen_votes[0])
    support_counts = [0] * length_items
    for vote in citizen_votes:
        for vote_key, vote_value in enumerate(vote):
            if vote_value:
                support_counts[vote_key] = support_counts[vote_key] + 1

    for item_index in range(length_items):
        avg_support_counts = support_counts[item_index] / len(citizen_votes)
        avg_budget = budget[item_index] / total_budget
        if avg_support_counts > avg_budget:
            return False
    return True


if __name__ == '__main__':
    import doctest

    (failures, tests) = doctest.testmod(report=True, optionflags=doctest.FAIL_FAST)
    print("{} failures, {} tests".format(failures, tests))
