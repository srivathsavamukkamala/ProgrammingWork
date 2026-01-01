# 1. Write a python snippet that's purpose is to validate user input. Prompt for a string with a length between
# 4 and 12 characters and continuously repeat the loop until a valid length is inputted. Output the valid string


sentence = input("Provide a string: ")
is_inrange=False
if len(sentence)>=4 and len(sentence)<=12:
    is_inrange=True
while not is_inrange:
    sentence = input("Provide a string: ")
    if len(sentence) >= 4 and len(sentence) <= 12:
        is_inrange = True
    #if :
print(sentence)



# 2. Using a nested for-loop, create these shapes
#        *
#        * *
#        * * *
#        * * * *
#        * * * * *
#
#        * * * * *
#        * * * *
#        * * *
#        * *
#        *

for i in range(0,2):
    if i==0:
        for x in range(1,6):
            print("        ", end="")
            for d in range(0,x):
                print("*",end=" ")
            print()
    else:
        for x in range(5,0,-1):
            print("        ", end="")
            for d in range(0,x):
                print("*", end=" ")
            print()
    print()


# 3. Use a while loop and the sentinel of -1 to prompt for inputs of Quiz grades. Using the loop and if
# statements, find the minimum and maximum numbers, while also finding the mean. Do this twice for two different classes (with different variable names) and then compare the
# two maximum, minimum, and mean numbers. Print out which class of each type is larger.

min_1=0
max_1=0
sum_1=0
count_1=0

min_2=0
max_2=0
sum_2=0
count_2=0

quiz=float(input("Input a Quiz Grade or Enter -1 to break: "))
while quiz>-1:
    if min_1==0:
        min_1=quiz
    else:
        if min_1>quiz:
            min_1=quiz
    if max_1==0:
        max_1=quiz
    else:
        if max_1<quiz:
            max_1=quiz
    count_1+=1
    sum_1+=quiz
    quiz=float(input("Input a Quiz Grade or Enter -1 to break: "))

quiz=float(input("Input a Quiz Grade or Enter -1 to break: "))
while quiz>-1:
    if min_2==0:
        min_2=quiz
    else:
        if min_2>quiz:
            min_2=quiz
    if max_2==0:
        max_2=quiz
    else:
        if max_2<quiz:
            max_2=quiz
    count_2+=1
    sum_2+=quiz
    quiz=float(input("Input a Quiz Grade or Enter -1 to break: "))

if max_1>max_2:
    print("Class 1 has a greater max score")
elif max_2>max_1:
    print("Class 2 has a greater max score")
else:
    print("Both Classes have the same max score")

if min_1>min_2:
    print("Class 1 has a greater min score")
elif min_2>min_1:
    print("Class 2 has a greater min score")
else:
    print("Both Classes have the same min score")

avg_1=sum_1/count_1
avg_2=sum_2/count_2

if avg_1>avg_2:
    print("Class 1 has a greater avg score")
elif avg_2>avg_1:
    print("Class 2 has a greater avg score")
else:
    print("Both Classes have the same avg score")

# 4. Most security professionals say that a password should have at least: an uppercase letter, a lowercase letter, and a number.
# Write a Python snippet that utilizes a loop, if-statements, and asks for an input of a password and outputs if any have been met.


password = input("Enter a password: ")
is_num=False
is_upperCase=False
is_lowerCase=False

for c in password:
    if c.isdigit():
        is_num=True
    if c.islower():
        is_lowerCase=True
    if c.isupper():
        is_upperCase=True

if is_num:
    if is_lowerCase:
        if is_upperCase:
            print("All Criteria have been met")
        else:
            print("Password does not have uppercase letter")
    else:
        if is_upperCase:
            print("Password does not have lowercase letter")
        else:
            print("Password does not have lowercase and uppercase letter")
else:
    if is_lowerCase:
        if is_upperCase:
            print("Password does not have number")
        else:
            print("Password does not have uppercase letter and number")
    else:
        if is_upperCase:
            print("Password does not have lowercase letter and number")
        else:
            print("Password does not have lowercase letter, uppercase letter, and number")


# Sample input: myname6
# Output:
# There is a lowercase letter in the password
# There is a number in the password

# Sample input: myName
# Output:
# There is a lowercase letter in the password
# There is an uppercase letter in the password

##Boolean Values = True and False and when Not
## Nested For Loops
## Specify specific char in string
##