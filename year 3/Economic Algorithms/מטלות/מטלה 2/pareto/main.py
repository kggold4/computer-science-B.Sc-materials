from agent import Agent
from pareto_utils import isParetoImprovement, isParetoOptimal

if __name__ == '__main__':
    example = [[1, 2, 3, 4, 5], [3, 1, 2, 5, 4], [3, 5, 5, 1, 1]]  # Each row represents the values of each person
    # and each column in the row represents the option out of all the options
    agents = [Agent(example[0]), Agent(example[1]), Agent(example[2])]  # construct all agents to a list
    options = [0, 1, 2, 3, 4]  # all options as a list

    # test for isParetoImprovement function
    print("isParetoImprovement test:")
    print("option 1 is Pareto Improvement of option 2?", isParetoImprovement(agents, 0, 1))
    print("option 4 is Pareto Improvement of option 5?", isParetoImprovement(agents, 3, 4))
    print("option 3 is Pareto Improvement of option 2?", isParetoImprovement(agents, 2, 1))

    # test for isParetoOptimal function
    print("\nisParetoOptimal test:")
    print("option 1 is Pareto Optimal?", isParetoOptimal(agents, 0, options))
    print("option 2 is Pareto Optimal?", isParetoOptimal(agents, 1, options))
    print("option 3 is Pareto Optimal?", isParetoOptimal(agents, 2, options))
    print("option 4 is Pareto Optimal?", isParetoOptimal(agents, 3, options))
    print("option 5 is Pareto Optimal?", isParetoOptimal(agents, 4, options))

