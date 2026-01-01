
# read_steps(..)
# This function takes a file_name string as a parameter and returns a list of integer numbers (the steps read from the file).
# The method should connect and read from a file with the name passed, add each line (i.e.: each step count) to a result list,
# and return it when finished. Use appropriate file IO and use exception (IOError) handling (via try-except) as necessary.
#
def readSteps(filename):
    try:
        with open(filename, "r") as file:
            lines = file.readlines()
    except IOError as e:
        print("There was an error %s: " % e)
    return lines

# get_goal_summary(..)
# This function takes two parameters:
#
# a list of integers that holds the daily step data
# the daily step goal
# The function should compute the following info, then return it in a list (in this order):
#
# the number of days the user's step count was below the goal
# the number of days the user's step count exactly matched the goal
# the number of days the user's step count was above the goal

def getGoalSummary(li, goal):
    below = 0
    exact = 0
    above = 0
    summarized = []
    for i in li:
        if int(i) < goal:
            below += 1
        if int(i) == goal:
            exact += 1
        if int(i) > goal:
            above += 1

    summarized.append(below)
    summarized.append(exact)
    summarized.append(above)

    return summarized



# matching_steps(..)
# This function takes one parameter, a list of steps (denoting daily step data), and returns a list of step counts for which any two consecutive days match.
#
# For example, if the step data list contains values: 8050, 9000, 9000, 11500, 11500, 12000
#
# Then the list returned by this function should just contain the values 9000 and 11500 (since they are the only two consecutive days with equivalent counts).
#

def matchingSteps(steps):
    previous = steps[0]
    repeats = []
    for i in range(1, len(steps)):
        if steps[i] == previous:
            repeats.append(steps[i])
        previous = steps[i]

    return repeats

# write_analysis(..)
# This function takes four parameters and returns nothing; here is a summary of the parameters:
#
# a list of integers denoting the step data (pass in the list returned from the read_steps(..) function)
# a list of integers representing the user's goal summary (this is returned from the get_goal_summary(..) function)
# a list of integers (step counts) where the step count matched for any two consecutive days (this is the returned value from the matching_steps(..) function)
# the daily step goal (an integer)
# The method should write all this data to a file called "analysis.txt", each piece of info on its own line:
#
# "Daily step goal: ", and then the step goal
# "Days under step goal: ", "Days at step goal: ", and "Days over step goal: ", respectively, with the correct number of days
# "Average steps: ", and the average number of steps per day, expressed to two decimal places of precision
# For as many matching steps values are in the step data, write a line "Matching steps: " followed by the number of matching steps
# Use appropriate file IO and use exception (IOError) handling (via try-except) as necessary.

def writeAnalysis(stepData, goalSummary, repeats, stepGoal):
    try:
        with open("analysis.txt", "w") as file:
            total = 0
            average = 0
            file.write("Daily step goal: %d\n" % stepGoal)
            file.write("Days under step goal: %d\n" % goalSummary[0])
            file.write("Days at step goal: %d\n" % goalSummary[1])
            file.write("Days over step goal: %d\n" % goalSummary[2])

            for i in stepData:
                total += int(i)
                average = (total / len(stepData))

            file.write("Average steps: %.2f\n" % average)

            for i in repeats:
                file.write("Matching steps: %d\n" % int(i))
    except IOError as e:
        print("There was an error: %s" % e)


# Main function overview
# (details on all other required functions below)
#
def main():
    # Prompt the user to enter a daily step goal
    goal = int(input("Please enter a daily step goal: "))
    # Call the read_steps() function, passing in the name of the file to be read ("stepdata.txt") as a parameter. Save the returned step list data into a variable
    steps = readSteps("stepdata.txt")
    # Using the data returned from the read_steps() function, call:
    # get_goal_summary() function -- requires passing in the list of steps from the previous step and the user's daily step goal as parameters. Save the returned summary list into a variable
    summary = getGoalSummary(steps, goal)
    # matching_steps() function -- requires passing in the list of steps as a parameter. Save the returned matching list into a variable
    matching = matchingSteps(steps)
    # write_analysis() function -- requires passing in the list of steps, the returned results from get_goal_summary() and matching_steps(), and the user's entered daily step goal as parameters. No value returned
    writeAnalysis(steps, summary, matching, goal)
    # Print "Step data written to analysis.txt" (see sample run of the app below)
    print("Step data written to analysis.txt!")

main()