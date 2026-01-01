# 1. Write a Python snippet that prompts the user to enter an IST course number
# 140, 242, 261, 311, 411
# Use If, and elif statements and else to determine whether they entered the correct course number.
# If a correct course number is entered, output the title of the class i.e. 140 is Intro to Application Development, etc.

##Name-Day of Completion
##Brief 2-3 line description of code

#
# meal=input("Take input: ")
# if len(meal)>0:
#     drink=input("Cool: ")
# else:
#     print("Not possible")
#
# if drink=='Cool':
#     print("Really Cool")
# else:
#     print("Really Bad")
#
# x=input("Enter a word")
# if x.isdigit():
#     print("Is number")
# else:
#     print("Input is not a number")
#
# #Taking int input from user
# user_input = int(input("Enter IST Course: "))
#
# ##Check if input is one of the 5 numbers. If so, print specific name of course else print not valid
# if user_input==140: #Checking if input is 140
#     print("140 is Intro to App Dev") #Print Name of course
# elif user_input==242: #Checking if input is 242
#     print("242 is Intermediate Obj Ori Dev") #Print Name of course
# elif user_input==261: #Checking if input is 261
#     print("261 is App Dev Design Studio 1") #Print Name of course
# elif user_input==311: #Checking if input is 311
#     print("311 is Obj-Ori Design and Software") #Print Name of course
# elif user_input==411: #Checking if input is 411
#     print("411 is Distrbuted Obj Computing") #Print Name of course
# else: #Input is not above
#     print("Not Valid") #Print Name of course
#
# # 2. Write a Python snippet that prompts a user to input a number between 1 - 100
# # Then output if the number is well below average (<20), is below the average (<40)
# # in the average (between 40 and 60), above the average (>60) or well above average (>80)
# # If not, output that it is not a valid entry
#
# ##Prompt User
# user_input = int(input("Give me a number between 1 and 100: "))
# if user_input>=1 and user_input<=100:
#     if user_input<20:
#         print("Well Below Average")
#     else:
#         if user_input<40:
#             print("Below Average")
#         else:
#             if user_input<60:
#                 print("Average")
#             else:
#                 if user_input<80:
#                     print("Above average")
#                 else:
#                     print("Well Above Average")
# else:
#     print("Not Valid Input")
#
#
# #3.Prompt for three integers. Check to see if all three are even by (1) using both compound conditional
# # and (2) nested-ifs.
#
# input_1=int(input("Give me a Number 1: "))
# input_2=int(input("Give me a Number 2: "))
# input_3=int(input("Give me a Number 3: "))
#
# if input_1%2==0 and input_2%2==0 and input_3%2==0:
#     print("All are even")
# else:
#     print("All are not even")
#
# if input_1%2==0:
#     if input_2%2==0:
#         if input_3%2==0:
#             print("All are even")
#         else:
#             print("All are not even")
#     else:
#         print("All are not even")
# else:
#     print("All are not even")
#
# # 4. Write a program that calculates and prints the
# # value of the coupon a person can receive based on groceries
# # purchased using the table below.
# # Prompt the user for the amount of their groceries, as a float.
# # If so, read in the input and determine the value of the
# # coupon based on the following information
# # Money spent:                           Coupon %:
# # More than $210                         14%
# # More than $150 - 210                   12%
# # More than $60 - 150                    10%
# # From $10 - 60                           8%
# # Less than $10                          No coupon
#
# user_input=float(input("Price of groceries: "))
#
# if user_input<0:
#     print("Not Valid")
# elif user_input>210:
#     print("Coupon is 14%")
# elif user_input>150:
#     print("Coupon is 12%")
# elif user_input>60:
#     print("Coupon is 10%")
# elif user_input>10:
#     print("Coupon is 8%")
# else:
#     print("No Coupon")
#
# ##Check to see in string, is digit not digit
# ##Making sure if statements are in order
#
# #0   0   0 1 0   1  0  0   P
# #DL  DR  C M IL  OL IR OR  G
#
# s=input()
#
# dash_left=s[0]
# dash_right=s[2]

# if M unlocked and G is P
## Child is 0 or DL is 1
## Unlock doors L or R



# def reverse(string):
#     if len(string)==1:
#         return string
#     return reverse(string[1:]) + string[0]
#
#
# reverse(word)
#     return dro + w --> drow
#
#     reverse(ord)
#         return dr + o --> dro
#         reverse(rd)
#             return d + r --> dr
#
#             reverse(d)
#                 d
#
# word
# drow
# reverse(word) --> drow
# x = add(2) --> 4
#

##While
##Functions with While loops

# Write a Python program with functions that validates a new password following these rules:
# Function -->Password must have at least 8 characters
# Function -->Password must have at least one uppercase and one lowercase letter
# Function -->Password must have at least one digit
# Write a program that asks for a phrase, then asks again to confirm it.
# If the phrases don't match, prompt again.
# Function --> same_phrase
# Write a code snippet to prompt a user for their age. Next, ask the user how many times
# they would like their age to be repeated.  Pass these values as parameters to a separate
# repetition function.  Use this function to output the repeated integer the number of times requested by the user.
# A new management has taken over and is offering to take 25% off your current rent if you share a room
# Use a function to see what your new monthly payment would be with your rent + electric bill


def password_validate(password):
    length1=length(password)
    uplo1=letters(password)
    di=digits(password)
    if length1 and uplo1 and di:
        print("Valid")
    else:
        print("Invalid")
def length(password):
    if len(password) >= 8:
        return True
    else:
        return False

def letters(password):
    ##Variable
    ##Condition
    ##Incr/Decr
    #length of password
    index = 0
    lo = False
    up = False
    ## hellosri
    ## 01234567 len-1
    while(index<len(password)):
        c = password[index]
        if c.isupper():
            up=True
        elif c.islower():
            lo=True
        index+=1

    # for c in password:
    #     if c.isupper():
    #         up=True
    #     elif c.islower():
    #         lo=True

    return lo and up


def digits(password):
    for c in password:
        if c.isdigit():
            return True
    return False


password=input("Enter password: ")
password_validate(password)


def repeat_age(age, repeat):
    for i in range(repeat):
        print(age)



def main():
    age = int(input("Enter Age: "))
    repeat = int(input("Enter number of times repeated: "))
    repeat_age(age,repeat)
main()

age = int(input("Enter Age: "))
repeat = int(input("Enter number of times repeated: "))

def repeat_age(age,repeat):
    for i in range(repeat):
        print(age)

def guess_num():
    guess=int(input("Guess a Number: "))
    master=8
    while(guess!=master):
        print("Wrong Guess ;;)))")
        guess = int(input("Guess a Number: "))

    print("Congrats")


var = ""
while(var!="-1"):
    var=input("New Input: ")